package android.support.v4.f;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.CancellationSignal;
import android.support.v4.c.h;
import android.support.v4.g.g;
import android.support.v4.g.j;
import android.support.v4.g.k;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {
    final class android.support.v4.f.b$4 implements Comparator {
        android.support.v4.f.b$4() {
            super();
        }

        public int a(byte[] arg5, byte[] arg6) {
            int v1 = 0;
            if(arg5.length != arg6.length) {
                v1 = arg5.length - arg6.length;
            }
            else {
                int v0 = 0;
                while(v0 < arg5.length) {
                    if(arg5[v0] != arg6[v0]) {
                        v1 = arg5[v0] - arg6[v0];
                    }
                    else {
                        ++v0;
                        continue;
                    }

                    return v1;
                }
            }

            return v1;
        }

        public int compare(Object arg2, Object arg3) {
            return this.a(((byte[])arg2), ((byte[])arg3));
        }
    }

    public class a {
        private final int a;
        private final android.support.v4.f.b$b[] b;

        public a(int arg1, android.support.v4.f.b$b[] arg2) {
            super();
            this.a = arg1;
            this.b = arg2;
        }

        public int a() {
            return this.a;
        }

        public android.support.v4.f.b$b[] b() {
            return this.b;
        }
    }

    public class android.support.v4.f.b$b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public android.support.v4.f.b$b(Uri arg2, int arg3, int arg4, boolean arg5, int arg6) {
            super();
            this.a = j.a(arg2);
            this.b = arg3;
            this.c = arg4;
            this.d = arg5;
            this.e = arg6;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    private static final g a;
    private static final c b;
    private static final Object c;
    private static final k d;
    private static final Comparator e;

    static {
        b.a = new g(16);
        b.b = new c("fonts", 10, 10000);
        b.c = new Object();
        b.d = new k();
        b.e = new android.support.v4.f.b$4();
    }

    public static Typeface a(Context arg6, android.support.v4.f.a arg7, TextView arg8, int arg9, int arg10, int arg11) {
        Typeface v0_2;
        Typeface v1 = null;
        String v2 = arg7.f() + "-" + arg11;
        Object v0 = b.a.a(v2);
        if(v0 == null) {
            int v0_1 = arg9 == 0 ? 1 : 0;
            if(v0_1 != 0 && arg10 == -1) {
                v0_2 = b.b(arg6, arg7, arg11);
                goto label_12;
            }

            android.support.v4.f.b$1 v3 = new Callable(arg6, arg7, arg11, v2) {
                public Typeface a() {
                    Typeface v0 = b.a(this.a, this.b, this.c);
                    if(v0 != null) {
                        b.a().a(this.d, v0);
                    }

                    return v0;
                }

                public Object call() {
                    return this.a();
                }
            };
            if(v0_1 != 0) {
                try {
                    v0 = b.b.a(((Callable)v3), arg10);
                }
                catch(InterruptedException v0_3) {
                    v0_2 = v1;
                }

                goto label_12;
            }

            android.support.v4.f.b$2 v4 = new android.support.v4.f.c$a(new WeakReference(arg8), arg8, arg11) {
                public void a(Typeface arg3) {
                    if(this.a.get() != null) {
                        this.b.setTypeface(arg3, this.c);
                    }
                }

                public void a(Object arg1) {
                    this.a(((Typeface)arg1));
                }
            };
            Object v5 = b.c;
            __monitor_enter(v5);
            try {
                if(b.d.containsKey(v2)) {
                    b.d.get(v2).add(v4);
                    __monitor_exit(v5);
                    v0_2 = v1;
                    goto label_12;
                }

                ArrayList v0_5 = new ArrayList();
                v0_5.add(v4);
                b.d.put(v2, v0_5);
                __monitor_exit(v5);
            }
            catch(Throwable v0_4) {
                try {
                label_59:
                    __monitor_exit(v5);
                }
                catch(Throwable v0_4) {
                    goto label_59;
                }

                throw v0_4;
            }

            b.b.a(((Callable)v3), new android.support.v4.f.c$a(v2) {
                public void a(Typeface arg5) {
                    int v2;
                    Object v0_1;
                    Object v1 = b.b();
                    __monitor_enter(v1);
                    try {
                        v0_1 = b.c().get(this.a);
                        b.c().remove(this.a);
                        __monitor_exit(v1);
                        v1 = null;
                        v2 = 0;
                    }
                    catch(Throwable v0) {
                        try {
                        label_19:
                            __monitor_exit(v1);
                        }
                        catch(Throwable v0) {
                            goto label_19;
                        }

                        throw v0;
                    }

                    while(v2 < ((ArrayList)v0_1).size()) {
                        ((ArrayList)v0_1).get(v2).a(arg5);
                        ++v2;
                    }
                }

                public void a(Object arg1) {
                    this.a(((Typeface)arg1));
                }
            });
            v0_2 = v1;
        }

    label_12:
        return ((Typeface)v0);
    }

    public static Map a(Context arg5, android.support.v4.f.b$b[] arg6, CancellationSignal arg7) {
        HashMap v1 = new HashMap();
        int v2 = arg6.length;
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            android.support.v4.f.b$b v3 = arg6[v0];
            if(v3.e() == 0) {
                Uri v3_1 = v3.a();
                if(!v1.containsKey(v3_1)) {
                    v1.put(v3_1, h.a(arg5, arg7, v3_1));
                }
            }
        }

        return Collections.unmodifiableMap(((Map)v1));
    }

    public static ProviderInfo a(PackageManager arg6, android.support.v4.f.a arg7, Resources arg8) {
        ProviderInfo v0;
        String v1 = arg7.a();
        ProviderInfo v2 = arg6.resolveContentProvider(v1, 0);
        if(v2 == null) {
            throw new PackageManager$NameNotFoundException("No package found for authority: " + v1);
        }

        if(!v2.packageName.equals(arg7.b())) {
            throw new PackageManager$NameNotFoundException("Found content provider " + v1 + ", but package was not " + arg7.b());
        }

        List v3 = b.a(arg6.getPackageInfo(v2.packageName, 0x40).signatures);
        Collections.sort(v3, b.e);
        List v4 = b.a(arg7, arg8);
        int v1_1 = 0;
        while(true) {
            if(v1_1 < v4.size()) {
                ArrayList v5 = new ArrayList(v4.get(v1_1));
                Collections.sort(((List)v5), b.e);
                if(b.a(v3, ((List)v5))) {
                    v0 = v2;
                }
                else {
                    ++v1_1;
                    continue;
                }
            }
            else {
                return null;
            }

            return v0;
        }

        return null;
    }

    private static List a(Signature[] arg3) {
        ArrayList v1 = new ArrayList();
        int v0;
        for(v0 = 0; v0 < arg3.length; ++v0) {
            ((List)v1).add(arg3[v0].toByteArray());
        }

        return ((List)v1);
    }

    private static List a(android.support.v4.f.a arg1, Resources arg2) {
        List v0 = arg1.d() != null ? arg1.d() : android.support.v4.b.a.a.a(arg2, arg1.e());
        return v0;
    }

    private static boolean a(List arg4, List arg5) {
        boolean v3 = false;
        if(arg4.size() == arg5.size()) {
            int v2 = 0;
            while(true) {
                if(v2 >= arg4.size()) {
                    break;
                }
                else if(Arrays.equals(arg4.get(v2), arg5.get(v2))) {
                    ++v2;
                    continue;
                }

                return v3;
            }

            v3 = true;
        }

        return v3;
    }

    static Typeface a(Context arg1, android.support.v4.f.a arg2, int arg3) {
        return b.b(arg1, arg2, arg3);
    }

    static g a() {
        return b.a;
    }

    public static a a(Context arg3, CancellationSignal arg4, android.support.v4.f.a arg5) {
        ProviderInfo v0 = b.a(arg3.getPackageManager(), arg5, arg3.getResources());
        a v0_1 = v0 == null ? new a(1, null) : new a(0, b.a(arg3, arg5, v0.authority, arg4));
        return v0_1;
    }

    static android.support.v4.f.b$b[] a(Context arg18, android.support.v4.f.a arg19, String arg20, CancellationSignal arg21) {
        boolean v8;
        int v7;
        Uri v5;
        int v6;
        int v9_1;
        int v16;
        int v15;
        int v14;
        int v13;
        ArrayList v2_1;
        Cursor v3_1;
        Cursor v10;
        ArrayList v11 = new ArrayList();
        Uri v3 = new Uri$Builder().scheme("content").authority(arg20).build();
        Uri v12 = new Uri$Builder().scheme("content").authority(arg20).appendPath("file").build();
        Cursor v9 = null;
        try {
            v10 = Build$VERSION.SDK_INT > 16 ? arg18.getContentResolver().query(v3, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{arg19.c()}, null, arg21) : arg18.getContentResolver().query(v3, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{arg19.c()}, null);
        }
        catch(Throwable v2) {
            v3_1 = v9;
            goto label_103;
        }

        if(v10 != null) {
            try {
                if(v10.getCount() > 0) {
                    int v11_1 = v10.getColumnIndex("result_code");
                    v2_1 = new ArrayList();
                    v13 = v10.getColumnIndex("_id");
                    v14 = v10.getColumnIndex("file_id");
                    v15 = v10.getColumnIndex("font_ttc_index");
                    v16 = v10.getColumnIndex("font_weight");
                    int v17 = v10.getColumnIndex("font_italic");
                    while(true) {
                    label_72:
                        if(v10.moveToNext()) {
                            if(v11_1 != -1) {
                                v9_1 = v10.getInt(v11_1);
                            }
                            else {
                                goto label_139;
                            }

                            goto label_77;
                        }

                        goto label_151;
                    }
                }
                else {
                    goto label_150;
                }

                goto label_151;
            }
            catch(Throwable v2) {
                goto label_102;
            }

        label_139:
            v9_1 = 0;
            try {
            label_77:
                if(v15 != -1) {
                    v6 = v10.getInt(v15);
                }
                else {
                    goto label_141;
                }

                goto label_80;
            }
            catch(Throwable v2) {
                goto label_102;
            }

        label_141:
            v6 = 0;
            try {
            label_80:
                v5 = v14 == -1 ? ContentUris.withAppendedId(v3, v10.getLong(v13)) : ContentUris.withAppendedId(v12, v10.getLong(v14));
                if(v16 != -1) {
                    v7 = v10.getInt(v16);
                }
                else {
                    goto label_146;
                }

                goto label_89;
            }
            catch(Throwable v2) {
                goto label_102;
            }

        label_146:
            v7 = 400;
            try {
            label_89:
                if(v17 == -1) {
                    goto label_148;
                }
                else if(v10.getInt(v17) == 1) {
                    v8 = true;
                }
                else {
                    goto label_148;
                }

                goto label_97;
            }
            catch(Throwable v2) {
                goto label_102;
            }

        label_148:
            v8 = false;
            try {
            label_97:
                v2_1.add(new android.support.v4.f.b$b(v5, v6, v7, v8, v9_1));
                goto label_72;
            }
            catch(Throwable v2) {
            label_102:
                v3_1 = v10;
            }

        label_103:
            if(v3_1 != null) {
                v3_1.close();
            }

            throw v2;
        }
        else {
        label_150:
            v2_1 = v11;
        }

    label_151:
        if(v10 != null) {
            v10.close();
        }

        return v2_1.toArray(new android.support.v4.f.b$b[0]);
    }

    private static Typeface b(Context arg3, android.support.v4.f.a arg4, int arg5) {
        a v1_2;
        CancellationSignal v0 = null;
        CancellationSignal v1 = null;
        try {
            v1_2 = b.a(arg3, v1, arg4);
        }
        catch(PackageManager$NameNotFoundException v1_1) {
            goto label_7;
        }

        if(v1_2.a() == 0) {
            Typeface v0_1 = android.support.v4.c.c.a(arg3, v0, v1_2.b(), arg5);
        }

    label_7:
        return ((Typeface)v0);
    }

    static Object b() {
        return b.c;
    }

    static k c() {
        return b.d;
    }
}

