package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build$VERSION;

public final class IntentCompat {
    interface IntentCompatImpl {
        Intent makeMainActivity(ComponentName arg1);

        Intent makeMainSelectorActivity(String arg1, String arg2);

        Intent makeRestartActivityTask(ComponentName arg1);
    }

    class IntentCompatImplBase implements IntentCompatImpl {
        IntentCompatImplBase() {
            super();
        }

        public Intent makeMainActivity(ComponentName arg3) {
            Intent v0 = new Intent("android.intent.action.MAIN");
            v0.setComponent(arg3);
            v0.addCategory("android.intent.category.LAUNCHER");
            return v0;
        }

        public Intent makeMainSelectorActivity(String arg2, String arg3) {
            Intent v0 = new Intent(arg2);
            v0.addCategory(arg3);
            return v0;
        }

        public Intent makeRestartActivityTask(ComponentName arg3) {
            Intent v0 = this.makeMainActivity(arg3);
            v0.addFlags(0x10008000);
            return v0;
        }
    }

    class IntentCompatImplHC extends IntentCompatImplBase {
        IntentCompatImplHC() {
            super();
        }

        public Intent makeMainActivity(ComponentName arg2) {
            return IntentCompatHoneycomb.makeMainActivity(arg2);
        }

        public Intent makeRestartActivityTask(ComponentName arg2) {
            return IntentCompatHoneycomb.makeRestartActivityTask(arg2);
        }
    }

    class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        IntentCompatImplIcsMr1() {
            super();
        }

        public Intent makeMainSelectorActivity(String arg2, String arg3) {
            return IntentCompatIcsMr1.makeMainSelectorActivity(arg2, arg3);
        }
    }

    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0x8000;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0x4000;
    private static final IntentCompatImpl IMPL;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 15) {
            IntentCompat.IMPL = new IntentCompatImplIcsMr1();
        }
        else if(v0 >= 11) {
            IntentCompat.IMPL = new IntentCompatImplHC();
        }
        else {
            IntentCompat.IMPL = new IntentCompatImplBase();
        }
    }

    private IntentCompat() {
        super();
    }

    public static Intent makeMainActivity(ComponentName arg1) {
        return IntentCompat.IMPL.makeMainActivity(arg1);
    }

    public static Intent makeMainSelectorActivity(String arg1, String arg2) {
        return IntentCompat.IMPL.makeMainSelectorActivity(arg1, arg2);
    }

    public static Intent makeRestartActivityTask(ComponentName arg1) {
        return IntentCompat.IMPL.makeRestartActivityTask(arg1);
    }
}

