package android.support.v4.widget;

import android.os.Build$VERSION;
import android.view.View$OnTouchListener;

public final class PopupMenuCompat {
    class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
            super();
        }

        public View$OnTouchListener getDragToOpenListener(Object arg2) {
            return null;
        }
    }

    class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
            super();
        }

        public View$OnTouchListener getDragToOpenListener(Object arg2) {
            return PopupMenuCompatKitKat.getDragToOpenListener(arg2);
        }
    }

    interface PopupMenuImpl {
        View$OnTouchListener getDragToOpenListener(Object arg1);
    }

    static final PopupMenuImpl IMPL;

    static {
        PopupMenuCompat.IMPL = Build$VERSION.SDK_INT >= 19 ? new KitKatPopupMenuImpl() : new BasePopupMenuImpl();
    }

    private PopupMenuCompat() {
        super();
    }

    public static View$OnTouchListener getDragToOpenListener(Object arg1) {
        return PopupMenuCompat.IMPL.getDragToOpenListener(arg1);
    }
}

