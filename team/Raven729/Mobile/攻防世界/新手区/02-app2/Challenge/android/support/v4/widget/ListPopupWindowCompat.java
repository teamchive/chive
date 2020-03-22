package android.support.v4.widget;

import android.os.Build$VERSION;
import android.view.View$OnTouchListener;
import android.view.View;

public final class ListPopupWindowCompat {
    class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        BaseListPopupWindowImpl() {
            super();
        }

        public View$OnTouchListener createDragToOpenListener(Object arg2, View arg3) {
            return null;
        }
    }

    class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
            super();
        }

        public View$OnTouchListener createDragToOpenListener(Object arg2, View arg3) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(arg2, arg3);
        }
    }

    interface ListPopupWindowImpl {
        View$OnTouchListener createDragToOpenListener(Object arg1, View arg2);
    }

    static final ListPopupWindowImpl IMPL;

    static {
        ListPopupWindowCompat.IMPL = Build$VERSION.SDK_INT >= 19 ? new KitKatListPopupWindowImpl() : new BaseListPopupWindowImpl();
    }

    private ListPopupWindowCompat() {
        super();
    }

    public static View$OnTouchListener createDragToOpenListener(Object arg1, View arg2) {
        return ListPopupWindowCompat.IMPL.createDragToOpenListener(arg1, arg2);
    }
}

