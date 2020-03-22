package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat {
    class JellybeanMr1Impl extends DisplayManagerCompat {
        private final Object mDisplayManagerObj;

        public JellybeanMr1Impl(Context arg2) {
            super();
            this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(arg2);
        }

        public Display getDisplay(int arg2) {
            return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, arg2);
        }

        public Display[] getDisplays() {
            return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
        }

        public Display[] getDisplays(String arg2) {
            return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, arg2);
        }
    }

    class LegacyImpl extends DisplayManagerCompat {
        private final WindowManager mWindowManager;

        public LegacyImpl(Context arg2) {
            super();
            this.mWindowManager = arg2.getSystemService("window");
        }

        public Display getDisplay(int arg3) {
            Display v0 = this.mWindowManager.getDefaultDisplay();
            if(v0.getDisplayId() != arg3) {
                v0 = null;
            }

            return v0;
        }

        public Display[] getDisplays() {
            return new Display[]{this.mWindowManager.getDefaultDisplay()};
        }

        public Display[] getDisplays(String arg2) {
            Display[] v0 = arg2 == null ? this.getDisplays() : new Display[0];
            return v0;
        }
    }

    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap sInstances;

    static {
        DisplayManagerCompat.sInstances = new WeakHashMap();
    }

    DisplayManagerCompat() {
        super();
    }

    public abstract Display getDisplay(int arg1);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String arg1);

    public static DisplayManagerCompat getInstance(Context arg3) {
        JellybeanMr1Impl v0_2;
        WeakHashMap v1 = DisplayManagerCompat.sInstances;
        __monitor_enter(v1);
        try {
            Object v0_1 = DisplayManagerCompat.sInstances.get(arg3);
            if(v0_1 == null) {
                if(Build$VERSION.SDK_INT >= 17) {
                    v0_2 = new JellybeanMr1Impl(arg3);
                }
                else {
                    LegacyImpl v0_3 = new LegacyImpl(arg3);
                }

                DisplayManagerCompat.sInstances.put(arg3, v0_2);
            }

            __monitor_exit(v1);
            return ((DisplayManagerCompat)v0_2);
        label_18:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_18;
        }

        throw v0;
    }
}

