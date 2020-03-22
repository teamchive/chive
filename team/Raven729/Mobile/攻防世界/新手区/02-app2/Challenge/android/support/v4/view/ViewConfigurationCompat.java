package android.support.v4.view;

import android.os.Build$VERSION;
import android.view.ViewConfiguration;

public final class ViewConfigurationCompat {
    class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
            super();
        }

        public boolean hasPermanentMenuKey(ViewConfiguration arg2) {
            return 1;
        }
    }

    class HoneycombViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
            super();
        }

        public boolean hasPermanentMenuKey(ViewConfiguration arg2) {
            return 0;
        }
    }

    class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
            super();
        }

        public boolean hasPermanentMenuKey(ViewConfiguration arg2) {
            return ViewConfigurationCompatICS.hasPermanentMenuKey(arg2);
        }
    }

    interface ViewConfigurationVersionImpl {
        boolean hasPermanentMenuKey(ViewConfiguration arg1);
    }

    static final ViewConfigurationVersionImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 14) {
            ViewConfigurationCompat.IMPL = new IcsViewConfigurationVersionImpl();
        }
        else if(Build$VERSION.SDK_INT >= 11) {
            ViewConfigurationCompat.IMPL = new HoneycombViewConfigurationVersionImpl();
        }
        else {
            ViewConfigurationCompat.IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    private ViewConfigurationCompat() {
        super();
    }

    @Deprecated public static int getScaledPagingTouchSlop(ViewConfiguration arg1) {
        return arg1.getScaledPagingTouchSlop();
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration arg1) {
        return ViewConfigurationCompat.IMPL.hasPermanentMenuKey(arg1);
    }
}

