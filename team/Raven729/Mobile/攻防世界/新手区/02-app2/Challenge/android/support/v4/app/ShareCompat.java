package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class ShareCompat {
    public class IntentBuilder {
        private Activity mActivity;
        private ArrayList mBccAddresses;
        private ArrayList mCcAddresses;
        private CharSequence mChooserTitle;
        private Intent mIntent;
        private ArrayList mStreams;
        private ArrayList mToAddresses;

        private IntentBuilder(Activity arg4) {
            super();
            this.mActivity = arg4;
            this.mIntent = new Intent().setAction("android.intent.action.SEND");
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", arg4.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", arg4.getComponentName());
            this.mIntent.addFlags(0x80000);
        }

        public IntentBuilder addEmailBcc(String arg2) {
            if(this.mBccAddresses == null) {
                this.mBccAddresses = new ArrayList();
            }

            this.mBccAddresses.add(arg2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.BCC", arg2);
            return this;
        }

        public IntentBuilder addEmailCc(String arg2) {
            if(this.mCcAddresses == null) {
                this.mCcAddresses = new ArrayList();
            }

            this.mCcAddresses.add(arg2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.CC", arg2);
            return this;
        }

        public IntentBuilder addEmailTo(String arg2) {
            if(this.mToAddresses == null) {
                this.mToAddresses = new ArrayList();
            }

            this.mToAddresses.add(arg2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] arg2) {
            this.combineArrayExtra("android.intent.extra.EMAIL", arg2);
            return this;
        }

        public IntentBuilder addStream(Uri arg4) {
            Parcelable v0 = this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if(this.mStreams != null || v0 != null) {
                if(this.mStreams == null) {
                    this.mStreams = new ArrayList();
                }

                if(v0 != null) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                    this.mStreams.add(v0);
                }

                this.mStreams.add(arg4);
            }
            else {
                this = this.setStream(arg4);
            }

            return this;
        }

        private void combineArrayExtra(String arg6, ArrayList arg7) {
            String[] v2 = this.mIntent.getStringArrayExtra(arg6);
            int v0 = v2 != null ? v2.length : 0;
            String[] v3 = new String[arg7.size() + v0];
            arg7.toArray(((Object[])v3));
            if(v2 != null) {
                System.arraycopy(v2, 0, v3, arg7.size(), v0);
            }

            this.mIntent.putExtra(arg6, v3);
        }

        private void combineArrayExtra(String arg6, String[] arg7) {
            Intent v2 = this.getIntent();
            String[] v3 = v2.getStringArrayExtra(arg6);
            int v0 = v3 != null ? v3.length : 0;
            String[] v4 = new String[arg7.length + v0];
            if(v3 != null) {
                System.arraycopy(v3, 0, v4, 0, v0);
            }

            System.arraycopy(arg7, 0, v4, v0, arg7.length);
            v2.putExtra(arg6, v4);
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(this.getIntent(), this.mChooserTitle);
        }

        public static IntentBuilder from(Activity arg1) {
            return new IntentBuilder(arg1);
        }

        Activity getActivity() {
            return this.mActivity;
        }

        public Intent getIntent() {
            ArrayList v6 = null;
            if(this.mToAddresses != null) {
                this.combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
                this.mToAddresses = v6;
            }

            if(this.mCcAddresses != null) {
                this.combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
                this.mCcAddresses = v6;
            }

            if(this.mBccAddresses != null) {
                this.combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
                this.mBccAddresses = v6;
            }

            int v1 = this.mStreams == null || this.mStreams.size() <= 1 ? 0 : 1;
            boolean v3 = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if(v1 == 0 && (v3)) {
                this.mIntent.setAction("android.intent.action.SEND");
                if(this.mStreams == null || (this.mStreams.isEmpty())) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                }
                else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
                }

                this.mStreams = v6;
            }

            if(v1 != 0 && !v3) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if(this.mStreams != null && !this.mStreams.isEmpty()) {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                    goto label_61;
                }

                this.mIntent.removeExtra("android.intent.extra.STREAM");
            }

        label_61:
            return this.mIntent;
        }

        public IntentBuilder setChooserTitle(@StringRes int arg2) {
            return this.setChooserTitle(this.mActivity.getText(arg2));
        }

        public IntentBuilder setChooserTitle(CharSequence arg1) {
            this.mChooserTitle = arg1;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] arg3) {
            this.mIntent.putExtra("android.intent.extra.BCC", arg3);
            return this;
        }

        public IntentBuilder setEmailCc(String[] arg3) {
            this.mIntent.putExtra("android.intent.extra.CC", arg3);
            return this;
        }

        public IntentBuilder setEmailTo(String[] arg3) {
            if(this.mToAddresses != null) {
                this.mToAddresses = null;
            }

            this.mIntent.putExtra("android.intent.extra.EMAIL", arg3);
            return this;
        }

        public IntentBuilder setHtmlText(String arg3) {
            this.mIntent.putExtra("android.intent.extra.HTML_TEXT", arg3);
            if(!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                this.setText(Html.fromHtml(arg3));
            }

            return this;
        }

        public IntentBuilder setStream(Uri arg3) {
            if(!this.mIntent.getAction().equals("android.intent.action.SEND")) {
                this.mIntent.setAction("android.intent.action.SEND");
            }

            this.mStreams = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", ((Parcelable)arg3));
            return this;
        }

        public IntentBuilder setSubject(String arg3) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", arg3);
            return this;
        }

        public IntentBuilder setText(CharSequence arg3) {
            this.mIntent.putExtra("android.intent.extra.TEXT", arg3);
            return this;
        }

        public IntentBuilder setType(String arg2) {
            this.mIntent.setType(arg2);
            return this;
        }

        public void startChooser() {
            this.mActivity.startActivity(this.createChooserIntent());
        }
    }

    public class IntentReader {
        private static final String TAG = "IntentReader";
        private Activity mActivity;
        private ComponentName mCallingActivity;
        private String mCallingPackage;
        private Intent mIntent;
        private ArrayList mStreams;

        private IntentReader(Activity arg2) {
            super();
            this.mActivity = arg2;
            this.mIntent = arg2.getIntent();
            this.mCallingPackage = ShareCompat.getCallingPackage(arg2);
            this.mCallingActivity = ShareCompat.getCallingActivity(arg2);
        }

        public static IntentReader from(Activity arg1) {
            return new IntentReader(arg1);
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            Drawable v0 = null;
            if(this.mCallingActivity != null) {
                PackageManager v1 = this.mActivity.getPackageManager();
                try {
                    v0 = v1.getActivityIcon(this.mCallingActivity);
                }
                catch(PackageManager$NameNotFoundException v1_1) {
                    Log.e("IntentReader", "Could not retrieve icon for calling activity", ((Throwable)v1_1));
                }
            }

            return v0;
        }

        public Drawable getCallingApplicationIcon() {
            Drawable v0 = null;
            if(this.mCallingPackage != null) {
                PackageManager v1 = this.mActivity.getPackageManager();
                try {
                    v0 = v1.getApplicationIcon(this.mCallingPackage);
                }
                catch(PackageManager$NameNotFoundException v1_1) {
                    Log.e("IntentReader", "Could not retrieve icon for calling application", ((Throwable)v1_1));
                }
            }

            return v0;
        }

        public CharSequence getCallingApplicationLabel() {
            CharSequence v0 = null;
            if(this.mCallingPackage != null) {
                PackageManager v1 = this.mActivity.getPackageManager();
                try {
                    v0 = v1.getApplicationLabel(v1.getApplicationInfo(this.mCallingPackage, 0));
                }
                catch(PackageManager$NameNotFoundException v1_1) {
                    Log.e("IntentReader", "Could not retrieve label for calling application", ((Throwable)v1_1));
                }
            }

            return v0;
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String v0_1;
            String v1 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
            if(v1 == null) {
                CharSequence v0 = this.getText();
                if((v0 instanceof Spanned)) {
                    v0_1 = Html.toHtml(((Spanned)v0));
                }
                else if(v0 != null) {
                    v0_1 = ShareCompat.IMPL.escapeHtml(v0);
                }
                else {
                    goto label_13;
                }
            }
            else {
            label_13:
                v0_1 = v1;
            }

            return v0_1;
        }

        public Uri getStream() {
            return this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int arg4) {
            Object v0;
            if(this.mStreams == null && (this.isMultipleShare())) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }

            if(this.mStreams != null) {
                v0 = this.mStreams.get(arg4);
            }
            else if(arg4 == 0) {
                Parcelable v0_1 = this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            else {
                goto label_18;
            }

            return ((Uri)v0);
        label_18:
            throw new IndexOutOfBoundsException("Stream items available: " + this.getStreamCount() + " index requested: " + arg4);
        }

        public int getStreamCount() {
            int v0;
            if(this.mStreams == null && (this.isMultipleShare())) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }

            if(this.mStreams != null) {
                v0 = this.mStreams.size();
            }
            else if(this.mIntent.hasExtra("android.intent.extra.STREAM")) {
                v0 = 1;
            }
            else {
                v0 = 0;
            }

            return v0;
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String v0 = this.mIntent.getAction();
            boolean v0_1 = ("android.intent.action.SEND".equals(v0)) || ("android.intent.action.SEND_MULTIPLE".equals(v0)) ? true : false;
            return v0_1;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    interface ShareCompatImpl {
        void configureMenuItem(MenuItem arg1, IntentBuilder arg2);

        String escapeHtml(CharSequence arg1);
    }

    class ShareCompatImplBase implements ShareCompatImpl {
        ShareCompatImplBase() {
            super();
        }

        public void configureMenuItem(MenuItem arg2, IntentBuilder arg3) {
            arg2.setIntent(arg3.createChooserIntent());
        }

        public String escapeHtml(CharSequence arg4) {
            StringBuilder v0 = new StringBuilder();
            ShareCompatImplBase.withinStyle(v0, arg4, 0, arg4.length());
            return v0.toString();
        }

        private static void withinStyle(StringBuilder arg5, CharSequence arg6, int arg7, int arg8) {
            char v4 = ' ';
            int v0;
            for(v0 = arg7; v0 < arg8; ++v0) {
                char v1 = arg6.charAt(v0);
                if(v1 == 60) {
                    arg5.append("&lt;");
                }
                else if(v1 == 62) {
                    arg5.append("&gt;");
                }
                else if(v1 == 38) {
                    arg5.append("&amp;");
                }
                else {
                    if(v1 <= 0x7E && v1 >= v4) {
                        if(v1 == v4) {
                            while(v0 + 1 < arg8) {
                                if(arg6.charAt(v0 + 1) != v4) {
                                    break;
                                }

                                arg5.append("&nbsp;");
                                ++v0;
                            }

                            arg5.append(v4);
                            goto label_8;
                        }

                        arg5.append(v1);
                        goto label_8;
                    }

                    arg5.append("&#" + v1 + ";");
                }

            label_8:
            }
        }
    }

    class ShareCompatImplICS extends ShareCompatImplBase {
        ShareCompatImplICS() {
            super();
        }

        public void configureMenuItem(MenuItem arg3, IntentBuilder arg4) {
            ShareCompatICS.configureMenuItem(arg3, arg4.getActivity(), arg4.getIntent());
            if(this.shouldAddChooserIntent(arg3)) {
                arg3.setIntent(arg4.createChooserIntent());
            }
        }

        boolean shouldAddChooserIntent(MenuItem arg2) {
            boolean v0 = !arg2.hasSubMenu() ? true : false;
            return v0;
        }
    }

    class ShareCompatImplJB extends ShareCompatImplICS {
        ShareCompatImplJB() {
            super();
        }

        public String escapeHtml(CharSequence arg2) {
            return ShareCompatJB.escapeHtml(arg2);
        }

        boolean shouldAddChooserIntent(MenuItem arg2) {
            return 0;
        }
    }

    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    static ShareCompatImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 16) {
            ShareCompat.IMPL = new ShareCompatImplJB();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            ShareCompat.IMPL = new ShareCompatImplICS();
        }
        else {
            ShareCompat.IMPL = new ShareCompatImplBase();
        }
    }

    private ShareCompat() {
        super();
    }

    public static void configureMenuItem(Menu arg3, int arg4, IntentBuilder arg5) {
        MenuItem v0 = arg3.findItem(arg4);
        if(v0 == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + arg4 + " in the supplied menu");
        }

        ShareCompat.configureMenuItem(v0, arg5);
    }

    public static void configureMenuItem(MenuItem arg1, IntentBuilder arg2) {
        ShareCompat.IMPL.configureMenuItem(arg1, arg2);
    }

    public static ComponentName getCallingActivity(Activity arg2) {
        ComponentName v0 = arg2.getCallingActivity();
        if(v0 == null) {
            Parcelable v0_1 = arg2.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
        }

        return v0;
    }

    public static String getCallingPackage(Activity arg2) {
        String v0 = arg2.getCallingPackage();
        if(v0 == null) {
            v0 = arg2.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }

        return v0;
    }
}

