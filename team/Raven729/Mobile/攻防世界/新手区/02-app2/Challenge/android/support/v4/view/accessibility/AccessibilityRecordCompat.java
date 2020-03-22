package android.support.v4.view.accessibility;

import android.os.Build$VERSION;
import android.os.Parcelable;
import android.view.View;
import java.util.Collections;
import java.util.List;

public class AccessibilityRecordCompat {
    class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        AccessibilityRecordIcsImpl() {
            super();
        }

        public int getAddedCount(Object arg2) {
            return AccessibilityRecordCompatIcs.getAddedCount(arg2);
        }

        public CharSequence getBeforeText(Object arg2) {
            return AccessibilityRecordCompatIcs.getBeforeText(arg2);
        }

        public CharSequence getClassName(Object arg2) {
            return AccessibilityRecordCompatIcs.getClassName(arg2);
        }

        public CharSequence getContentDescription(Object arg2) {
            return AccessibilityRecordCompatIcs.getContentDescription(arg2);
        }

        public int getCurrentItemIndex(Object arg2) {
            return AccessibilityRecordCompatIcs.getCurrentItemIndex(arg2);
        }

        public int getFromIndex(Object arg2) {
            return AccessibilityRecordCompatIcs.getFromIndex(arg2);
        }

        public int getItemCount(Object arg2) {
            return AccessibilityRecordCompatIcs.getItemCount(arg2);
        }

        public Parcelable getParcelableData(Object arg2) {
            return AccessibilityRecordCompatIcs.getParcelableData(arg2);
        }

        public int getRemovedCount(Object arg2) {
            return AccessibilityRecordCompatIcs.getRemovedCount(arg2);
        }

        public int getScrollX(Object arg2) {
            return AccessibilityRecordCompatIcs.getScrollX(arg2);
        }

        public int getScrollY(Object arg2) {
            return AccessibilityRecordCompatIcs.getScrollY(arg2);
        }

        public AccessibilityNodeInfoCompat getSource(Object arg2) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityRecordCompatIcs.getSource(arg2));
        }

        public List getText(Object arg2) {
            return AccessibilityRecordCompatIcs.getText(arg2);
        }

        public int getToIndex(Object arg2) {
            return AccessibilityRecordCompatIcs.getToIndex(arg2);
        }

        public int getWindowId(Object arg2) {
            return AccessibilityRecordCompatIcs.getWindowId(arg2);
        }

        public boolean isChecked(Object arg2) {
            return AccessibilityRecordCompatIcs.isChecked(arg2);
        }

        public boolean isEnabled(Object arg2) {
            return AccessibilityRecordCompatIcs.isEnabled(arg2);
        }

        public boolean isFullScreen(Object arg2) {
            return AccessibilityRecordCompatIcs.isFullScreen(arg2);
        }

        public boolean isPassword(Object arg2) {
            return AccessibilityRecordCompatIcs.isPassword(arg2);
        }

        public boolean isScrollable(Object arg2) {
            return AccessibilityRecordCompatIcs.isScrollable(arg2);
        }

        public Object obtain() {
            return AccessibilityRecordCompatIcs.obtain();
        }

        public Object obtain(Object arg2) {
            return AccessibilityRecordCompatIcs.obtain(arg2);
        }

        public void recycle(Object arg1) {
            AccessibilityRecordCompatIcs.recycle(arg1);
        }

        public void setAddedCount(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setAddedCount(arg1, arg2);
        }

        public void setBeforeText(Object arg1, CharSequence arg2) {
            AccessibilityRecordCompatIcs.setBeforeText(arg1, arg2);
        }

        public void setChecked(Object arg1, boolean arg2) {
            AccessibilityRecordCompatIcs.setChecked(arg1, arg2);
        }

        public void setClassName(Object arg1, CharSequence arg2) {
            AccessibilityRecordCompatIcs.setClassName(arg1, arg2);
        }

        public void setContentDescription(Object arg1, CharSequence arg2) {
            AccessibilityRecordCompatIcs.setContentDescription(arg1, arg2);
        }

        public void setCurrentItemIndex(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setCurrentItemIndex(arg1, arg2);
        }

        public void setEnabled(Object arg1, boolean arg2) {
            AccessibilityRecordCompatIcs.setEnabled(arg1, arg2);
        }

        public void setFromIndex(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setFromIndex(arg1, arg2);
        }

        public void setFullScreen(Object arg1, boolean arg2) {
            AccessibilityRecordCompatIcs.setFullScreen(arg1, arg2);
        }

        public void setItemCount(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setItemCount(arg1, arg2);
        }

        public void setParcelableData(Object arg1, Parcelable arg2) {
            AccessibilityRecordCompatIcs.setParcelableData(arg1, arg2);
        }

        public void setPassword(Object arg1, boolean arg2) {
            AccessibilityRecordCompatIcs.setPassword(arg1, arg2);
        }

        public void setRemovedCount(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setRemovedCount(arg1, arg2);
        }

        public void setScrollX(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setScrollX(arg1, arg2);
        }

        public void setScrollY(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setScrollY(arg1, arg2);
        }

        public void setScrollable(Object arg1, boolean arg2) {
            AccessibilityRecordCompatIcs.setScrollable(arg1, arg2);
        }

        public void setSource(Object arg1, View arg2) {
            AccessibilityRecordCompatIcs.setSource(arg1, arg2);
        }

        public void setToIndex(Object arg1, int arg2) {
            AccessibilityRecordCompatIcs.setToIndex(arg1, arg2);
        }
    }

    class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        AccessibilityRecordIcsMr1Impl() {
            super();
        }

        public int getMaxScrollX(Object arg2) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollX(arg2);
        }

        public int getMaxScrollY(Object arg2) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollY(arg2);
        }

        public void setMaxScrollX(Object arg1, int arg2) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollX(arg1, arg2);
        }

        public void setMaxScrollY(Object arg1, int arg2) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollY(arg1, arg2);
        }
    }

    interface AccessibilityRecordImpl {
        int getAddedCount(Object arg1);

        CharSequence getBeforeText(Object arg1);

        CharSequence getClassName(Object arg1);

        CharSequence getContentDescription(Object arg1);

        int getCurrentItemIndex(Object arg1);

        int getFromIndex(Object arg1);

        int getItemCount(Object arg1);

        int getMaxScrollX(Object arg1);

        int getMaxScrollY(Object arg1);

        Parcelable getParcelableData(Object arg1);

        int getRemovedCount(Object arg1);

        int getScrollX(Object arg1);

        int getScrollY(Object arg1);

        AccessibilityNodeInfoCompat getSource(Object arg1);

        List getText(Object arg1);

        int getToIndex(Object arg1);

        int getWindowId(Object arg1);

        boolean isChecked(Object arg1);

        boolean isEnabled(Object arg1);

        boolean isFullScreen(Object arg1);

        boolean isPassword(Object arg1);

        boolean isScrollable(Object arg1);

        Object obtain();

        Object obtain(Object arg1);

        void recycle(Object arg1);

        void setAddedCount(Object arg1, int arg2);

        void setBeforeText(Object arg1, CharSequence arg2);

        void setChecked(Object arg1, boolean arg2);

        void setClassName(Object arg1, CharSequence arg2);

        void setContentDescription(Object arg1, CharSequence arg2);

        void setCurrentItemIndex(Object arg1, int arg2);

        void setEnabled(Object arg1, boolean arg2);

        void setFromIndex(Object arg1, int arg2);

        void setFullScreen(Object arg1, boolean arg2);

        void setItemCount(Object arg1, int arg2);

        void setMaxScrollX(Object arg1, int arg2);

        void setMaxScrollY(Object arg1, int arg2);

        void setParcelableData(Object arg1, Parcelable arg2);

        void setPassword(Object arg1, boolean arg2);

        void setRemovedCount(Object arg1, int arg2);

        void setScrollX(Object arg1, int arg2);

        void setScrollY(Object arg1, int arg2);

        void setScrollable(Object arg1, boolean arg2);

        void setSource(Object arg1, View arg2);

        void setSource(Object arg1, View arg2, int arg3);

        void setToIndex(Object arg1, int arg2);
    }

    class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
        AccessibilityRecordJellyBeanImpl() {
            super();
        }

        public void setSource(Object arg1, View arg2, int arg3) {
            AccessibilityRecordCompatJellyBean.setSource(arg1, arg2, arg3);
        }
    }

    class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        AccessibilityRecordStubImpl() {
            super();
        }

        public int getAddedCount(Object arg2) {
            return 0;
        }

        public CharSequence getBeforeText(Object arg2) {
            return null;
        }

        public CharSequence getClassName(Object arg2) {
            return null;
        }

        public CharSequence getContentDescription(Object arg2) {
            return null;
        }

        public int getCurrentItemIndex(Object arg2) {
            return 0;
        }

        public int getFromIndex(Object arg2) {
            return 0;
        }

        public int getItemCount(Object arg2) {
            return 0;
        }

        public int getMaxScrollX(Object arg2) {
            return 0;
        }

        public int getMaxScrollY(Object arg2) {
            return 0;
        }

        public Parcelable getParcelableData(Object arg2) {
            return null;
        }

        public int getRemovedCount(Object arg2) {
            return 0;
        }

        public int getScrollX(Object arg2) {
            return 0;
        }

        public int getScrollY(Object arg2) {
            return 0;
        }

        public AccessibilityNodeInfoCompat getSource(Object arg2) {
            return null;
        }

        public List getText(Object arg2) {
            return Collections.emptyList();
        }

        public int getToIndex(Object arg2) {
            return 0;
        }

        public int getWindowId(Object arg2) {
            return 0;
        }

        public boolean isChecked(Object arg2) {
            return 0;
        }

        public boolean isEnabled(Object arg2) {
            return 0;
        }

        public boolean isFullScreen(Object arg2) {
            return 0;
        }

        public boolean isPassword(Object arg2) {
            return 0;
        }

        public boolean isScrollable(Object arg2) {
            return 0;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object arg2) {
            return null;
        }

        public void recycle(Object arg1) {
        }

        public void setAddedCount(Object arg1, int arg2) {
        }

        public void setBeforeText(Object arg1, CharSequence arg2) {
        }

        public void setChecked(Object arg1, boolean arg2) {
        }

        public void setClassName(Object arg1, CharSequence arg2) {
        }

        public void setContentDescription(Object arg1, CharSequence arg2) {
        }

        public void setCurrentItemIndex(Object arg1, int arg2) {
        }

        public void setEnabled(Object arg1, boolean arg2) {
        }

        public void setFromIndex(Object arg1, int arg2) {
        }

        public void setFullScreen(Object arg1, boolean arg2) {
        }

        public void setItemCount(Object arg1, int arg2) {
        }

        public void setMaxScrollX(Object arg1, int arg2) {
        }

        public void setMaxScrollY(Object arg1, int arg2) {
        }

        public void setParcelableData(Object arg1, Parcelable arg2) {
        }

        public void setPassword(Object arg1, boolean arg2) {
        }

        public void setRemovedCount(Object arg1, int arg2) {
        }

        public void setScrollX(Object arg1, int arg2) {
        }

        public void setScrollY(Object arg1, int arg2) {
        }

        public void setScrollable(Object arg1, boolean arg2) {
        }

        public void setSource(Object arg1, View arg2) {
        }

        public void setSource(Object arg1, View arg2, int arg3) {
        }

        public void setToIndex(Object arg1, int arg2) {
        }
    }

    private static final AccessibilityRecordImpl IMPL;
    private final Object mRecord;

    static {
        if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityRecordCompat.IMPL = new AccessibilityRecordJellyBeanImpl();
        }
        else if(Build$VERSION.SDK_INT >= 15) {
            AccessibilityRecordCompat.IMPL = new AccessibilityRecordIcsMr1Impl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityRecordCompat.IMPL = new AccessibilityRecordIcsImpl();
        }
        else {
            AccessibilityRecordCompat.IMPL = new AccessibilityRecordStubImpl();
        }
    }

    @Deprecated public AccessibilityRecordCompat(Object arg1) {
        super();
        this.mRecord = arg1;
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((AccessibilityRecordCompat)arg5))) {
            if(arg5 == null) {
                v0 = false;
            }
            else if(this.getClass() != arg5.getClass()) {
                v0 = false;
            }
            else if(this.mRecord == null) {
                if(((AccessibilityRecordCompat)arg5).mRecord != null) {
                    v0 = false;
                }
            }
            else if(!this.mRecord.equals(((AccessibilityRecordCompat)arg5).mRecord)) {
                v0 = false;
            }
        }

        return v0;
    }

    public int getAddedCount() {
        return AccessibilityRecordCompat.IMPL.getAddedCount(this.mRecord);
    }

    public CharSequence getBeforeText() {
        return AccessibilityRecordCompat.IMPL.getBeforeText(this.mRecord);
    }

    public CharSequence getClassName() {
        return AccessibilityRecordCompat.IMPL.getClassName(this.mRecord);
    }

    public CharSequence getContentDescription() {
        return AccessibilityRecordCompat.IMPL.getContentDescription(this.mRecord);
    }

    public int getCurrentItemIndex() {
        return AccessibilityRecordCompat.IMPL.getCurrentItemIndex(this.mRecord);
    }

    public int getFromIndex() {
        return AccessibilityRecordCompat.IMPL.getFromIndex(this.mRecord);
    }

    @Deprecated public Object getImpl() {
        return this.mRecord;
    }

    public int getItemCount() {
        return AccessibilityRecordCompat.IMPL.getItemCount(this.mRecord);
    }

    public int getMaxScrollX() {
        return AccessibilityRecordCompat.IMPL.getMaxScrollX(this.mRecord);
    }

    public int getMaxScrollY() {
        return AccessibilityRecordCompat.IMPL.getMaxScrollY(this.mRecord);
    }

    public Parcelable getParcelableData() {
        return AccessibilityRecordCompat.IMPL.getParcelableData(this.mRecord);
    }

    public int getRemovedCount() {
        return AccessibilityRecordCompat.IMPL.getRemovedCount(this.mRecord);
    }

    public int getScrollX() {
        return AccessibilityRecordCompat.IMPL.getScrollX(this.mRecord);
    }

    public int getScrollY() {
        return AccessibilityRecordCompat.IMPL.getScrollY(this.mRecord);
    }

    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityRecordCompat.IMPL.getSource(this.mRecord);
    }

    public List getText() {
        return AccessibilityRecordCompat.IMPL.getText(this.mRecord);
    }

    public int getToIndex() {
        return AccessibilityRecordCompat.IMPL.getToIndex(this.mRecord);
    }

    public int getWindowId() {
        return AccessibilityRecordCompat.IMPL.getWindowId(this.mRecord);
    }

    public int hashCode() {
        int v0 = this.mRecord == null ? 0 : this.mRecord.hashCode();
        return v0;
    }

    public boolean isChecked() {
        return AccessibilityRecordCompat.IMPL.isChecked(this.mRecord);
    }

    public boolean isEnabled() {
        return AccessibilityRecordCompat.IMPL.isEnabled(this.mRecord);
    }

    public boolean isFullScreen() {
        return AccessibilityRecordCompat.IMPL.isFullScreen(this.mRecord);
    }

    public boolean isPassword() {
        return AccessibilityRecordCompat.IMPL.isPassword(this.mRecord);
    }

    public boolean isScrollable() {
        return AccessibilityRecordCompat.IMPL.isScrollable(this.mRecord);
    }

    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecordCompat.IMPL.obtain());
    }

    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat arg3) {
        return new AccessibilityRecordCompat(AccessibilityRecordCompat.IMPL.obtain(arg3.mRecord));
    }

    public void recycle() {
        AccessibilityRecordCompat.IMPL.recycle(this.mRecord);
    }

    public void setAddedCount(int arg3) {
        AccessibilityRecordCompat.IMPL.setAddedCount(this.mRecord, arg3);
    }

    public void setBeforeText(CharSequence arg3) {
        AccessibilityRecordCompat.IMPL.setBeforeText(this.mRecord, arg3);
    }

    public void setChecked(boolean arg3) {
        AccessibilityRecordCompat.IMPL.setChecked(this.mRecord, arg3);
    }

    public void setClassName(CharSequence arg3) {
        AccessibilityRecordCompat.IMPL.setClassName(this.mRecord, arg3);
    }

    public void setContentDescription(CharSequence arg3) {
        AccessibilityRecordCompat.IMPL.setContentDescription(this.mRecord, arg3);
    }

    public void setCurrentItemIndex(int arg3) {
        AccessibilityRecordCompat.IMPL.setCurrentItemIndex(this.mRecord, arg3);
    }

    public void setEnabled(boolean arg3) {
        AccessibilityRecordCompat.IMPL.setEnabled(this.mRecord, arg3);
    }

    public void setFromIndex(int arg3) {
        AccessibilityRecordCompat.IMPL.setFromIndex(this.mRecord, arg3);
    }

    public void setFullScreen(boolean arg3) {
        AccessibilityRecordCompat.IMPL.setFullScreen(this.mRecord, arg3);
    }

    public void setItemCount(int arg3) {
        AccessibilityRecordCompat.IMPL.setItemCount(this.mRecord, arg3);
    }

    public void setMaxScrollX(int arg3) {
        AccessibilityRecordCompat.IMPL.setMaxScrollX(this.mRecord, arg3);
    }

    public void setMaxScrollY(int arg3) {
        AccessibilityRecordCompat.IMPL.setMaxScrollY(this.mRecord, arg3);
    }

    public void setParcelableData(Parcelable arg3) {
        AccessibilityRecordCompat.IMPL.setParcelableData(this.mRecord, arg3);
    }

    public void setPassword(boolean arg3) {
        AccessibilityRecordCompat.IMPL.setPassword(this.mRecord, arg3);
    }

    public void setRemovedCount(int arg3) {
        AccessibilityRecordCompat.IMPL.setRemovedCount(this.mRecord, arg3);
    }

    public void setScrollX(int arg3) {
        AccessibilityRecordCompat.IMPL.setScrollX(this.mRecord, arg3);
    }

    public void setScrollY(int arg3) {
        AccessibilityRecordCompat.IMPL.setScrollY(this.mRecord, arg3);
    }

    public void setScrollable(boolean arg3) {
        AccessibilityRecordCompat.IMPL.setScrollable(this.mRecord, arg3);
    }

    public void setSource(View arg3) {
        AccessibilityRecordCompat.IMPL.setSource(this.mRecord, arg3);
    }

    public void setSource(View arg3, int arg4) {
        AccessibilityRecordCompat.IMPL.setSource(this.mRecord, arg3, arg4);
    }

    public void setToIndex(int arg3) {
        AccessibilityRecordCompat.IMPL.setToIndex(this.mRecord, arg3);
    }
}

