package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    interface PathStrategy {
        File getFileForUri(Uri arg1);

        Uri getUriForFile(File arg1);
    }

    class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap mRoots;

        public SimplePathStrategy(String arg2) {
            super();
            this.mRoots = new HashMap();
            this.mAuthority = arg2;
        }

        public void addRoot(String arg5, File arg6) {
            File v0_1;
            if(TextUtils.isEmpty(((CharSequence)arg5))) {
                throw new IllegalArgumentException("Name must not be empty");
            }

            try {
                v0_1 = arg6.getCanonicalFile();
            }
            catch(IOException v0) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + arg6, ((Throwable)v0));
            }

            this.mRoots.put(arg5, v0_1);
        }

        public File getFileForUri(Uri arg5) {
            File v1_2;
            String v0 = arg5.getEncodedPath();
            int v1 = v0.indexOf(0x2F, 1);
            String v2 = Uri.decode(v0.substring(1, v1));
            String v1_1 = Uri.decode(v0.substring(v1 + 1));
            Object v0_1 = this.mRoots.get(v2);
            if(v0_1 == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + arg5);
            }

            File v2_1 = new File(((File)v0_1), v1_1);
            try {
                v1_2 = v2_1.getCanonicalFile();
            }
            catch(IOException v0_2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + v2_1);
            }

            if(!v1_2.getPath().startsWith(((File)v0_1).getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }

            return v1_2;
        }

        public Uri getUriForFile(File arg7) {
            String v1;
            String v3;
            try {
                v3 = arg7.getCanonicalPath();
            }
            catch(IOException v0) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + arg7);
            }

            Object v2 = null;
            Iterator v4 = this.mRoots.entrySet().iterator();
            while(v4.hasNext()) {
                Object v0_1 = v4.next();
                v1 = ((Map$Entry)v0_1).getValue().getPath();
                if(!v3.startsWith(v1) || v2 != null && v1.length() <= ((Map$Entry)v2).getValue().getPath().length()) {
                    v0_1 = v2;
                }

                v2 = v0_1;
            }

            if(v2 == null) {
                throw new IllegalArgumentException("Failed to find configured root that contains " + v3);
            }

            String v0_2 = ((Map$Entry)v2).getValue().getPath();
            v1 = v0_2.endsWith("/") ? v3.substring(v0_2.length()) : v3.substring(v0_2.length() + 1);
            return new Uri$Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(((Map$Entry)v2).getKey()) + '/' + Uri.encode(v1, "/")).build();
        }
    }

    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private PathStrategy mStrategy;
    private static HashMap sCache;

    static {
        FileProvider.COLUMNS = new String[]{"_display_name", "_size"};
        FileProvider.DEVICE_ROOT = new File("/");
        FileProvider.sCache = new HashMap();
    }

    public FileProvider() {
        super();
    }

    public void attachInfo(Context arg3, ProviderInfo arg4) {
        super.attachInfo(arg3, arg4);
        if(arg4.exported) {
            throw new SecurityException("Provider must not be exported");
        }

        if(!arg4.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }

        this.mStrategy = FileProvider.getPathStrategy(arg3, arg4.authority);
    }

    private static File buildPath(File arg5, String[] arg6) {
        int v3 = arg6.length;
        int v2 = 0;
        File v1;
        for(v1 = arg5; v2 < v3; v1 = v0) {
            String v4 = arg6[v2];
            File v0 = v4 != null ? new File(v1, v4) : v1;
            ++v2;
        }

        return v1;
    }

    private static Object[] copyOf(Object[] arg2, int arg3) {
        Object[] v0 = new Object[arg3];
        System.arraycopy(arg2, 0, v0, 0, arg3);
        return v0;
    }

    private static String[] copyOf(String[] arg2, int arg3) {
        String[] v0 = new String[arg3];
        System.arraycopy(arg2, 0, v0, 0, arg3);
        return v0;
    }

    public int delete(Uri arg2, String arg3, String[] arg4) {
        int v0 = this.mStrategy.getFileForUri(arg2).delete() ? 1 : 0;
        return v0;
    }

    private static PathStrategy getPathStrategy(Context arg4, String arg5) {
        PathStrategy v0_4;
        HashMap v1 = FileProvider.sCache;
        __monitor_enter(v1);
        try {
            Object v0_1 = FileProvider.sCache.get(arg5);
            if(v0_1 == null) {
                try {
                    v0_4 = FileProvider.parsePathStrategy(arg4, arg5);
                    goto label_6;
                }
                catch(XmlPullParserException v0_2) {
                    try {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ((Throwable)v0_2));
                    label_6:
                        FileProvider.sCache.put(arg5, v0_4);
                    label_8:
                        __monitor_exit(v1);
                        return ((PathStrategy)v0_1);
                    label_16:
                        __monitor_exit(v1);
                        goto label_17;
                    }
                    catch(Throwable v0) {
                        goto label_16;
                    }
                }
                catch(IOException v0_3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ((Throwable)v0_3));
                }
            }

            goto label_8;
        }
        catch(Throwable v0) {
            goto label_16;
        }

    label_17:
        throw v0;
    }

    public String getType(Uri arg4) {
        String v0_1;
        File v0 = this.mStrategy.getFileForUri(arg4);
        int v1 = v0.getName().lastIndexOf(46);
        if(v1 >= 0) {
            v0_1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(v0.getName().substring(v1 + 1));
            if(v0_1 == null) {
                goto label_13;
            }
        }
        else {
        label_13:
            v0_1 = "application/octet-stream";
        }

        return v0_1;
    }

    public static Uri getUriForFile(Context arg1, String arg2, File arg3) {
        return FileProvider.getPathStrategy(arg1, arg2).getUriForFile(arg3);
    }

    public Uri insert(Uri arg3, ContentValues arg4) {
        throw new UnsupportedOperationException("No external inserts");
    }

    private static int modeToMode(String arg3) {
        int v0;
        if("r".equals(arg3)) {
            v0 = 0x10000000;
        }
        else {
            if(!"w".equals(arg3) && !"wt".equals(arg3)) {
                if("wa".equals(arg3)) {
                    return 0x2A000000;
                }
                else if("rw".equals(arg3)) {
                    return 0x38000000;
                }
                else if("rwt".equals(arg3)) {
                    return 0x3C000000;
                }
                else {
                    throw new IllegalArgumentException("Invalid mode: " + arg3);
                }
            }

            v0 = 0x2C000000;
        }

        return v0;
    }

    public boolean onCreate() {
        return 1;
    }

    public ParcelFileDescriptor openFile(Uri arg3, String arg4) {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(arg3), FileProvider.modeToMode(arg4));
    }

    private static PathStrategy parsePathStrategy(Context arg9, String arg10) {
        File[] v0_3;
        File v0_2;
        String v1 = null;
        SimplePathStrategy v2 = new SimplePathStrategy(arg10);
        XmlResourceParser v3 = arg9.getPackageManager().resolveContentProvider(arg10, 0x80).loadXmlMetaData(arg9.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if(v3 == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }

        while(true) {
            int v0 = v3.next();
            if(v0 == 1) {
                break;
            }

            if(v0 != 2) {
                continue;
            }

            String v0_1 = v3.getName();
            String v4 = v3.getAttributeValue(v1, "name");
            String v5 = v3.getAttributeValue(v1, "path");
            if("root-path".equals(v0_1)) {
                v0_2 = FileProvider.DEVICE_ROOT;
            }
            else if("files-path".equals(v0_1)) {
                v0_2 = arg9.getFilesDir();
            }
            else if("cache-path".equals(v0_1)) {
                v0_2 = arg9.getCacheDir();
            }
            else if("external-path".equals(v0_1)) {
                v0_2 = Environment.getExternalStorageDirectory();
            }
            else {
                if("external-files-path".equals(v0_1)) {
                    v0_3 = ContextCompat.getExternalFilesDirs(arg9, v1);
                    if(v0_3.length > 0) {
                        v0_2 = v0_3[0];
                        goto label_29;
                    }
                }
                else if("external-cache-path".equals(v0_1)) {
                    v0_3 = ContextCompat.getExternalCacheDirs(arg9);
                    if(v0_3.length > 0) {
                        v0_2 = v0_3[0];
                        goto label_29;
                    }
                }

                v0_2 = ((File)v1);
            }

        label_29:
            if(v0_2 == null) {
                continue;
            }

            v2.addRoot(v4, FileProvider.buildPath(v0_2, new String[]{v5}));
        }

        return ((PathStrategy)v2);
    }

    public Cursor query(Uri arg11, String[] arg12, String arg13, String[] arg14, String arg15) {
        int v0_1;
        File v3 = this.mStrategy.getFileForUri(arg11);
        if(arg12 == null) {
            arg12 = FileProvider.COLUMNS;
        }

        String[] v4 = new String[arg12.length];
        Object[] v5 = new Object[arg12.length];
        int v6 = arg12.length;
        int v2 = 0;
        int v1;
        for(v1 = 0; v2 < v6; v1 = v0_1) {
            String v0 = arg12[v2];
            if("_display_name".equals(v0)) {
                v4[v1] = "_display_name";
                v0_1 = v1 + 1;
                v5[v1] = v3.getName();
            }
            else if("_size".equals(v0)) {
                v4[v1] = "_size";
                v0_1 = v1 + 1;
                v5[v1] = Long.valueOf(v3.length());
            }
            else {
                v0_1 = v1;
            }

            ++v2;
        }

        String[] v0_2 = FileProvider.copyOf(v4, v1);
        Object[] v1_1 = FileProvider.copyOf(v5, v1);
        MatrixCursor v2_1 = new MatrixCursor(v0_2, 1);
        v2_1.addRow(v1_1);
        return ((Cursor)v2_1);
    }

    public int update(Uri arg3, ContentValues arg4, String arg5, String[] arg6) {
        throw new UnsupportedOperationException("No external updates");
    }
}

