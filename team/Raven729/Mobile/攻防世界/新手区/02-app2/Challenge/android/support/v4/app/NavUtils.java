package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import android.util.Log;

public final class NavUtils {
    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity arg1);

        String getParentActivityName(Context arg1, ActivityInfo arg2);

        void navigateUpTo(Activity arg1, Intent arg2);

        boolean shouldUpRecreateTask(Activity arg1, Intent arg2);
    }

    class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
            super();
        }

        public Intent getParentActivityIntent(Activity arg6) {
            Intent v0 = null;
            String v1 = NavUtils.getParentActivityName(arg6);
            if(v1 != null) {
                ComponentName v2 = new ComponentName(((Context)arg6), v1);
                try {
                    if(NavUtils.getParentActivityName(((Context)arg6), v2) == null) {
                        return IntentCompat.makeMainActivity(v2);
                    }

                    v0 = new Intent().setComponent(v2);
                }
                catch(PackageManager$NameNotFoundException v2_1) {
                    Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName \'" + v1 + "\' in manifest");
                }
            }

            return v0;
        }

        public String getParentActivityName(Context arg4, ActivityInfo arg5) {
            String v0;
            String v1 = null;
            if(arg5.metaData == null) {
                v0 = v1;
            }
            else {
                v0 = arg5.metaData.getString("android.support.PARENT_ACTIVITY");
                if(v0 == null) {
                    v0 = v1;
                }
                else if(v0.charAt(0) == 46) {
                    v0 = arg4.getPackageName() + v0;
                }
            }

            return v0;
        }

        public void navigateUpTo(Activity arg2, Intent arg3) {
            arg3.addFlags(0x4000000);
            arg2.startActivity(arg3);
            arg2.finish();
        }

        public boolean shouldUpRecreateTask(Activity arg3, Intent arg4) {
            String v0 = arg3.getIntent().getAction();
            boolean v0_1 = v0 == null || (v0.equals("android.intent.action.MAIN")) ? false : true;
            return v0_1;
        }
    }

    class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
            super();
        }

        public Intent getParentActivityIntent(Activity arg2) {
            Intent v0 = NavUtilsJB.getParentActivityIntent(arg2);
            if(v0 == null) {
                v0 = this.superGetParentActivityIntent(arg2);
            }

            return v0;
        }

        public String getParentActivityName(Context arg2, ActivityInfo arg3) {
            String v0 = NavUtilsJB.getParentActivityName(arg3);
            if(v0 == null) {
                v0 = super.getParentActivityName(arg2, arg3);
            }

            return v0;
        }

        public void navigateUpTo(Activity arg1, Intent arg2) {
            NavUtilsJB.navigateUpTo(arg1, arg2);
        }

        public boolean shouldUpRecreateTask(Activity arg2, Intent arg3) {
            return NavUtilsJB.shouldUpRecreateTask(arg2, arg3);
        }

        Intent superGetParentActivityIntent(Activity arg2) {
            return super.getParentActivityIntent(arg2);
        }
    }

    private static final NavUtilsImpl IMPL = null;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    static {
        NavUtils.IMPL = Build$VERSION.SDK_INT >= 16 ? new NavUtilsImplJB() : new NavUtilsImplBase();
    }

    private NavUtils() {
        super();
    }

    public static Intent getParentActivityIntent(Activity arg1) {
        return NavUtils.IMPL.getParentActivityIntent(arg1);
    }

    public static Intent getParentActivityIntent(Context arg3, ComponentName arg4) {
        Intent v0_1;
        String v0 = NavUtils.getParentActivityName(arg3, arg4);
        if(v0 == null) {
            v0_1 = null;
        }
        else {
            ComponentName v1 = new ComponentName(arg4.getPackageName(), v0);
            v0_1 = NavUtils.getParentActivityName(arg3, v1) == null ? IntentCompat.makeMainActivity(v1) : new Intent().setComponent(v1);
        }

        return v0_1;
    }

    public static Intent getParentActivityIntent(Context arg2, Class arg3) {
        Intent v0_1;
        String v0 = NavUtils.getParentActivityName(arg2, new ComponentName(arg2, arg3));
        if(v0 == null) {
            v0_1 = null;
        }
        else {
            ComponentName v1 = new ComponentName(arg2, v0);
            v0_1 = NavUtils.getParentActivityName(arg2, v1) == null ? IntentCompat.makeMainActivity(v1) : new Intent().setComponent(v1);
        }

        return v0_1;
    }

    @Nullable public static String getParentActivityName(Context arg2, ComponentName arg3) {
        return NavUtils.IMPL.getParentActivityName(arg2, arg2.getPackageManager().getActivityInfo(arg3, 0x80));
    }

    @Nullable public static String getParentActivityName(Activity arg2) {
        try {
            return NavUtils.getParentActivityName(((Context)arg2), arg2.getComponentName());
        }
        catch(PackageManager$NameNotFoundException v0) {
            throw new IllegalArgumentException(((Throwable)v0));
        }
    }

    public static void navigateUpFromSameTask(Activity arg3) {
        Intent v0 = NavUtils.getParentActivityIntent(arg3);
        if(v0 == null) {
            throw new IllegalArgumentException("Activity " + arg3.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }

        NavUtils.navigateUpTo(arg3, v0);
    }

    public static void navigateUpTo(Activity arg1, Intent arg2) {
        NavUtils.IMPL.navigateUpTo(arg1, arg2);
    }

    public static boolean shouldUpRecreateTask(Activity arg1, Intent arg2) {
        return NavUtils.IMPL.shouldUpRecreateTask(arg1, arg2);
    }
}

