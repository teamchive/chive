package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat {
    public class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
        public static final AccessibilityActionCompat ACTION_CLICK;
        public static final AccessibilityActionCompat ACTION_COLLAPSE;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_COPY;
        public static final AccessibilityActionCompat ACTION_CUT;
        public static final AccessibilityActionCompat ACTION_DISMISS;
        public static final AccessibilityActionCompat ACTION_EXPAND;
        public static final AccessibilityActionCompat ACTION_FOCUS;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_PASTE;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SELECT;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION;
        public static final AccessibilityActionCompat ACTION_SET_TEXT;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        final Object mAction;

        static {
            AccessibilityActionCompat.ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            AccessibilityActionCompat.ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            AccessibilityActionCompat.ACTION_SELECT = new AccessibilityActionCompat(4, null);
            AccessibilityActionCompat.ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            AccessibilityActionCompat.ACTION_CLICK = new AccessibilityActionCompat(16, null);
            AccessibilityActionCompat.ACTION_LONG_CLICK = new AccessibilityActionCompat(0x20, null);
            AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(0x40, null);
            AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(0x80, null);
            AccessibilityActionCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(0x100, null);
            AccessibilityActionCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(0x200, null);
            AccessibilityActionCompat.ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(0x400, null);
            AccessibilityActionCompat.ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(0x800, null);
            AccessibilityActionCompat.ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(0x1000, null);
            AccessibilityActionCompat.ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(0x2000, null);
            AccessibilityActionCompat.ACTION_COPY = new AccessibilityActionCompat(0x4000, null);
            AccessibilityActionCompat.ACTION_PASTE = new AccessibilityActionCompat(0x8000, null);
            AccessibilityActionCompat.ACTION_CUT = new AccessibilityActionCompat(0x10000, null);
            AccessibilityActionCompat.ACTION_SET_SELECTION = new AccessibilityActionCompat(0x20000, null);
            AccessibilityActionCompat.ACTION_EXPAND = new AccessibilityActionCompat(0x40000, null);
            AccessibilityActionCompat.ACTION_COLLAPSE = new AccessibilityActionCompat(0x80000, null);
            AccessibilityActionCompat.ACTION_DISMISS = new AccessibilityActionCompat(0x100000, null);
            AccessibilityActionCompat.ACTION_SET_TEXT = new AccessibilityActionCompat(0x200000, null);
            AccessibilityActionCompat.ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
            AccessibilityActionCompat.ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
            AccessibilityActionCompat.ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
            AccessibilityActionCompat.ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
            AccessibilityActionCompat.ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
            AccessibilityActionCompat.ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
            AccessibilityActionCompat.ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
            AccessibilityActionCompat.ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());
        }

        AccessibilityActionCompat(Object arg1) {
            super();
            this.mAction = arg1;
        }

        public AccessibilityActionCompat(int arg2, CharSequence arg3) {
            this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(arg2, arg3));
        }

        public int getId() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
        }

        public CharSequence getLabel() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
        }
    }

    class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
            super();
        }

        public void addAction(Object arg1, Object arg2) {
            AccessibilityNodeInfoCompatApi21.addAction(arg1, arg2);
        }

        public int getAccessibilityActionId(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(arg2);
        }

        public CharSequence getAccessibilityActionLabel(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(arg2);
        }

        public List getActionList(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getActionList(arg2);
        }

        public int getCollectionInfoSelectionMode(Object arg2) {
            return CollectionInfo.getSelectionMode(arg2);
        }

        public CharSequence getError(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getError(arg2);
        }

        public int getMaxTextLength(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getMaxTextLength(arg2);
        }

        public Object getWindow(Object arg2) {
            return AccessibilityNodeInfoCompatApi21.getWindow(arg2);
        }

        public boolean isCollectionItemSelected(Object arg2) {
            return CollectionItemInfo.isSelected(arg2);
        }

        public Object newAccessibilityAction(int arg2, CharSequence arg3) {
            return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(arg2, arg3);
        }

        public Object obtainCollectionInfo(int arg2, int arg3, boolean arg4, int arg5) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(arg2, arg3, arg4, arg5);
        }

        public Object obtainCollectionItemInfo(int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public boolean removeAction(Object arg2, Object arg3) {
            return AccessibilityNodeInfoCompatApi21.removeAction(arg2, arg3);
        }

        public boolean removeChild(Object arg2, View arg3) {
            return AccessibilityNodeInfoCompatApi21.removeChild(arg2, arg3);
        }

        public boolean removeChild(Object arg2, View arg3, int arg4) {
            return AccessibilityNodeInfoCompatApi21.removeChild(arg2, arg3, arg4);
        }

        public void setError(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatApi21.setError(arg1, arg2);
        }

        public void setMaxTextLength(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatApi21.setMaxTextLength(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
            super();
        }

        public Object getTraversalAfter(Object arg2) {
            return AccessibilityNodeInfoCompatApi22.getTraversalAfter(arg2);
        }

        public Object getTraversalBefore(Object arg2) {
            return AccessibilityNodeInfoCompatApi22.getTraversalBefore(arg2);
        }

        public void setTraversalAfter(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(arg1, arg2);
        }

        public void setTraversalAfter(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(arg1, arg2, arg3);
        }

        public void setTraversalBefore(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(arg1, arg2);
        }

        public void setTraversalBefore(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(arg1, arg2, arg3);
        }
    }

    class AccessibilityNodeInfoApi23Impl extends AccessibilityNodeInfoApi22Impl {
        AccessibilityNodeInfoApi23Impl() {
            super();
        }

        public Object getActionContextClick() {
            return AccessibilityNodeInfoCompatApi23.getActionContextClick();
        }

        public Object getActionScrollDown() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollDown();
        }

        public Object getActionScrollLeft() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollLeft();
        }

        public Object getActionScrollRight() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollRight();
        }

        public Object getActionScrollToPosition() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollToPosition();
        }

        public Object getActionScrollUp() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollUp();
        }

        public Object getActionShowOnScreen() {
            return AccessibilityNodeInfoCompatApi23.getActionShowOnScreen();
        }

        public boolean isContextClickable(Object arg2) {
            return AccessibilityNodeInfoCompatApi23.isContextClickable(arg2);
        }

        public void setContextClickable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatApi23.setContextClickable(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoApi24Impl extends AccessibilityNodeInfoApi23Impl {
        AccessibilityNodeInfoApi24Impl() {
            super();
        }

        public Object getActionSetProgress() {
            return AccessibilityNodeInfoCompatApi24.getActionSetProgress();
        }

        public int getDrawingOrder(Object arg2) {
            return AccessibilityNodeInfoCompatApi24.getDrawingOrder(arg2);
        }

        public boolean isImportantForAccessibility(Object arg2) {
            return AccessibilityNodeInfoCompatApi24.isImportantForAccessibility(arg2);
        }

        public void setDrawingOrder(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatApi24.setDrawingOrder(arg1, arg2);
        }

        public void setImportantForAccessibility(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatApi24.setImportantForAccessibility(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
            super();
        }

        public void addAction(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatIcs.addAction(arg1, arg2);
        }

        public void addChild(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatIcs.addChild(arg1, arg2);
        }

        public List findAccessibilityNodeInfosByText(Object arg2, String arg3) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(arg2, arg3);
        }

        public int getActions(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getActions(arg2);
        }

        public void getBoundsInParent(Object arg1, Rect arg2) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(arg1, arg2);
        }

        public void getBoundsInScreen(Object arg1, Rect arg2) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(arg1, arg2);
        }

        public Object getChild(Object arg2, int arg3) {
            return AccessibilityNodeInfoCompatIcs.getChild(arg2, arg3);
        }

        public int getChildCount(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(arg2);
        }

        public CharSequence getClassName(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getClassName(arg2);
        }

        public CharSequence getContentDescription(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(arg2);
        }

        public CharSequence getPackageName(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(arg2);
        }

        public Object getParent(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getParent(arg2);
        }

        public CharSequence getText(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getText(arg2);
        }

        public int getWindowId(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(arg2);
        }

        public boolean isCheckable(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(arg2);
        }

        public boolean isChecked(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isChecked(arg2);
        }

        public boolean isClickable(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isClickable(arg2);
        }

        public boolean isEnabled(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(arg2);
        }

        public boolean isFocusable(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(arg2);
        }

        public boolean isFocused(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isFocused(arg2);
        }

        public boolean isLongClickable(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(arg2);
        }

        public boolean isPassword(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isPassword(arg2);
        }

        public boolean isScrollable(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(arg2);
        }

        public boolean isSelected(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.isSelected(arg2);
        }

        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        public Object obtain(View arg2) {
            return AccessibilityNodeInfoCompatIcs.obtain(arg2);
        }

        public Object obtain(Object arg2) {
            return AccessibilityNodeInfoCompatIcs.obtain(arg2);
        }

        public boolean performAction(Object arg2, int arg3) {
            return AccessibilityNodeInfoCompatIcs.performAction(arg2, arg3);
        }

        public void recycle(Object arg1) {
            AccessibilityNodeInfoCompatIcs.recycle(arg1);
        }

        public void setBoundsInParent(Object arg1, Rect arg2) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(arg1, arg2);
        }

        public void setBoundsInScreen(Object arg1, Rect arg2) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(arg1, arg2);
        }

        public void setCheckable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setCheckable(arg1, arg2);
        }

        public void setChecked(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setChecked(arg1, arg2);
        }

        public void setClassName(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatIcs.setClassName(arg1, arg2);
        }

        public void setClickable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setClickable(arg1, arg2);
        }

        public void setContentDescription(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(arg1, arg2);
        }

        public void setEnabled(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setEnabled(arg1, arg2);
        }

        public void setFocusable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setFocusable(arg1, arg2);
        }

        public void setFocused(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setFocused(arg1, arg2);
        }

        public void setLongClickable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(arg1, arg2);
        }

        public void setPackageName(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatIcs.setPackageName(arg1, arg2);
        }

        public void setParent(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatIcs.setParent(arg1, arg2);
        }

        public void setPassword(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setPassword(arg1, arg2);
        }

        public void setScrollable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setScrollable(arg1, arg2);
        }

        public void setSelected(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatIcs.setSelected(arg1, arg2);
        }

        public void setSource(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatIcs.setSource(arg1, arg2);
        }

        public void setText(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatIcs.setText(arg1, arg2);
        }
    }

    interface AccessibilityNodeInfoImpl {
        void addAction(Object arg1, int arg2);

        void addAction(Object arg1, Object arg2);

        void addChild(Object arg1, View arg2);

        void addChild(Object arg1, View arg2, int arg3);

        boolean canOpenPopup(Object arg1);

        List findAccessibilityNodeInfosByText(Object arg1, String arg2);

        List findAccessibilityNodeInfosByViewId(Object arg1, String arg2);

        Object findFocus(Object arg1, int arg2);

        Object focusSearch(Object arg1, int arg2);

        int getAccessibilityActionId(Object arg1);

        CharSequence getAccessibilityActionLabel(Object arg1);

        Object getActionContextClick();

        List getActionList(Object arg1);

        Object getActionScrollDown();

        Object getActionScrollLeft();

        Object getActionScrollRight();

        Object getActionScrollToPosition();

        Object getActionScrollUp();

        Object getActionSetProgress();

        Object getActionShowOnScreen();

        int getActions(Object arg1);

        void getBoundsInParent(Object arg1, Rect arg2);

        void getBoundsInScreen(Object arg1, Rect arg2);

        Object getChild(Object arg1, int arg2);

        int getChildCount(Object arg1);

        CharSequence getClassName(Object arg1);

        Object getCollectionInfo(Object arg1);

        int getCollectionInfoColumnCount(Object arg1);

        int getCollectionInfoRowCount(Object arg1);

        int getCollectionInfoSelectionMode(Object arg1);

        int getCollectionItemColumnIndex(Object arg1);

        int getCollectionItemColumnSpan(Object arg1);

        Object getCollectionItemInfo(Object arg1);

        int getCollectionItemRowIndex(Object arg1);

        int getCollectionItemRowSpan(Object arg1);

        CharSequence getContentDescription(Object arg1);

        int getDrawingOrder(Object arg1);

        CharSequence getError(Object arg1);

        Bundle getExtras(Object arg1);

        int getInputType(Object arg1);

        Object getLabelFor(Object arg1);

        Object getLabeledBy(Object arg1);

        int getLiveRegion(Object arg1);

        int getMaxTextLength(Object arg1);

        int getMovementGranularities(Object arg1);

        CharSequence getPackageName(Object arg1);

        Object getParent(Object arg1);

        Object getRangeInfo(Object arg1);

        CharSequence getRoleDescription(Object arg1);

        CharSequence getText(Object arg1);

        int getTextSelectionEnd(Object arg1);

        int getTextSelectionStart(Object arg1);

        Object getTraversalAfter(Object arg1);

        Object getTraversalBefore(Object arg1);

        String getViewIdResourceName(Object arg1);

        Object getWindow(Object arg1);

        int getWindowId(Object arg1);

        boolean isAccessibilityFocused(Object arg1);

        boolean isCheckable(Object arg1);

        boolean isChecked(Object arg1);

        boolean isClickable(Object arg1);

        boolean isCollectionInfoHierarchical(Object arg1);

        boolean isCollectionItemHeading(Object arg1);

        boolean isCollectionItemSelected(Object arg1);

        boolean isContentInvalid(Object arg1);

        boolean isContextClickable(Object arg1);

        boolean isDismissable(Object arg1);

        boolean isEditable(Object arg1);

        boolean isEnabled(Object arg1);

        boolean isFocusable(Object arg1);

        boolean isFocused(Object arg1);

        boolean isImportantForAccessibility(Object arg1);

        boolean isLongClickable(Object arg1);

        boolean isMultiLine(Object arg1);

        boolean isPassword(Object arg1);

        boolean isScrollable(Object arg1);

        boolean isSelected(Object arg1);

        boolean isVisibleToUser(Object arg1);

        Object newAccessibilityAction(int arg1, CharSequence arg2);

        Object obtain();

        Object obtain(Object arg1);

        Object obtain(View arg1);

        Object obtain(View arg1, int arg2);

        Object obtainCollectionInfo(int arg1, int arg2, boolean arg3);

        Object obtainCollectionInfo(int arg1, int arg2, boolean arg3, int arg4);

        Object obtainCollectionItemInfo(int arg1, int arg2, int arg3, int arg4, boolean arg5);

        Object obtainCollectionItemInfo(int arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6);

        Object obtainRangeInfo(int arg1, float arg2, float arg3, float arg4);

        boolean performAction(Object arg1, int arg2);

        boolean performAction(Object arg1, int arg2, Bundle arg3);

        void recycle(Object arg1);

        boolean refresh(Object arg1);

        boolean removeAction(Object arg1, Object arg2);

        boolean removeChild(Object arg1, View arg2);

        boolean removeChild(Object arg1, View arg2, int arg3);

        void setAccessibilityFocused(Object arg1, boolean arg2);

        void setBoundsInParent(Object arg1, Rect arg2);

        void setBoundsInScreen(Object arg1, Rect arg2);

        void setCanOpenPopup(Object arg1, boolean arg2);

        void setCheckable(Object arg1, boolean arg2);

        void setChecked(Object arg1, boolean arg2);

        void setClassName(Object arg1, CharSequence arg2);

        void setClickable(Object arg1, boolean arg2);

        void setCollectionInfo(Object arg1, Object arg2);

        void setCollectionItemInfo(Object arg1, Object arg2);

        void setContentDescription(Object arg1, CharSequence arg2);

        void setContentInvalid(Object arg1, boolean arg2);

        void setContextClickable(Object arg1, boolean arg2);

        void setDismissable(Object arg1, boolean arg2);

        void setDrawingOrder(Object arg1, int arg2);

        void setEditable(Object arg1, boolean arg2);

        void setEnabled(Object arg1, boolean arg2);

        void setError(Object arg1, CharSequence arg2);

        void setFocusable(Object arg1, boolean arg2);

        void setFocused(Object arg1, boolean arg2);

        void setImportantForAccessibility(Object arg1, boolean arg2);

        void setInputType(Object arg1, int arg2);

        void setLabelFor(Object arg1, View arg2);

        void setLabelFor(Object arg1, View arg2, int arg3);

        void setLabeledBy(Object arg1, View arg2);

        void setLabeledBy(Object arg1, View arg2, int arg3);

        void setLiveRegion(Object arg1, int arg2);

        void setLongClickable(Object arg1, boolean arg2);

        void setMaxTextLength(Object arg1, int arg2);

        void setMovementGranularities(Object arg1, int arg2);

        void setMultiLine(Object arg1, boolean arg2);

        void setPackageName(Object arg1, CharSequence arg2);

        void setParent(Object arg1, View arg2);

        void setParent(Object arg1, View arg2, int arg3);

        void setPassword(Object arg1, boolean arg2);

        void setRangeInfo(Object arg1, Object arg2);

        void setRoleDescription(Object arg1, CharSequence arg2);

        void setScrollable(Object arg1, boolean arg2);

        void setSelected(Object arg1, boolean arg2);

        void setSource(Object arg1, View arg2);

        void setSource(Object arg1, View arg2, int arg3);

        void setText(Object arg1, CharSequence arg2);

        void setTextSelection(Object arg1, int arg2, int arg3);

        void setTraversalAfter(Object arg1, View arg2);

        void setTraversalAfter(Object arg1, View arg2, int arg3);

        void setTraversalBefore(Object arg1, View arg2);

        void setTraversalBefore(Object arg1, View arg2, int arg3);

        void setViewIdResourceName(Object arg1, String arg2);

        void setVisibleToUser(Object arg1, boolean arg2);
    }

    class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
            super();
        }

        public void addChild(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatJellyBean.addChild(arg1, arg2, arg3);
        }

        public Object findFocus(Object arg2, int arg3) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(arg2, arg3);
        }

        public Object focusSearch(Object arg2, int arg3) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(arg2, arg3);
        }

        public int getMovementGranularities(Object arg2) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(arg2);
        }

        public boolean isAccessibilityFocused(Object arg2) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(arg2);
        }

        public boolean isVisibleToUser(Object arg2) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(arg2);
        }

        public Object obtain(View arg2, int arg3) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(arg2, arg3);
        }

        public boolean performAction(Object arg2, int arg3, Bundle arg4) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(arg2, arg3, arg4);
        }

        public void setAccessibilityFocused(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(arg1, arg2);
        }

        public void setMovementGranularities(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(arg1, arg2);
        }

        public void setParent(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatJellyBean.setParent(arg1, arg2, arg3);
        }

        public void setSource(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatJellyBean.setSource(arg1, arg2, arg3);
        }

        public void setVisibleToUser(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
            super();
        }

        public Object getLabelFor(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(arg2);
        }

        public Object getLabeledBy(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(arg2);
        }

        public void setLabelFor(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(arg1, arg2);
        }

        public void setLabelFor(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(arg1, arg2, arg3);
        }

        public void setLabeledBy(Object arg1, View arg2) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(arg1, arg2);
        }

        public void setLabeledBy(Object arg1, View arg2, int arg3) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(arg1, arg2, arg3);
        }
    }

    class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
            super();
        }

        public List findAccessibilityNodeInfosByViewId(Object arg2, String arg3) {
            return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(arg2, arg3);
        }

        public int getTextSelectionEnd(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(arg2);
        }

        public int getTextSelectionStart(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(arg2);
        }

        public String getViewIdResourceName(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(arg2);
        }

        public boolean isEditable(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(arg2);
        }

        public boolean refresh(Object arg2) {
            return AccessibilityNodeInfoCompatJellybeanMr2.refresh(arg2);
        }

        public void setEditable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatJellybeanMr2.setEditable(arg1, arg2);
        }

        public void setTextSelection(Object arg1, int arg2, int arg3) {
            AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(arg1, arg2, arg3);
        }

        public void setViewIdResourceName(Object arg1, String arg2) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
            super();
        }

        public boolean canOpenPopup(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.canOpenPopup(arg2);
        }

        public Object getCollectionInfo(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(arg2);
        }

        public int getCollectionInfoColumnCount(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionInfo.getColumnCount(arg2);
        }

        public int getCollectionInfoRowCount(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionInfo.getRowCount(arg2);
        }

        public int getCollectionItemColumnIndex(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getColumnIndex(arg2);
        }

        public int getCollectionItemColumnSpan(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getColumnSpan(arg2);
        }

        public Object getCollectionItemInfo(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(arg2);
        }

        public int getCollectionItemRowIndex(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getRowIndex(arg2);
        }

        public int getCollectionItemRowSpan(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getRowSpan(arg2);
        }

        public Bundle getExtras(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getExtras(arg2);
        }

        public int getInputType(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getInputType(arg2);
        }

        public int getLiveRegion(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getLiveRegion(arg2);
        }

        public Object getRangeInfo(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getRangeInfo(arg2);
        }

        public CharSequence getRoleDescription(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.getRoleDescription(arg2);
        }

        public boolean isCollectionInfoHierarchical(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionInfo.isHierarchical(arg2);
        }

        public boolean isCollectionItemHeading(Object arg2) {
            return android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.isHeading(arg2);
        }

        public boolean isContentInvalid(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.isContentInvalid(arg2);
        }

        public boolean isDismissable(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.isDismissable(arg2);
        }

        public boolean isMultiLine(Object arg2) {
            return AccessibilityNodeInfoCompatKitKat.isMultiLine(arg2);
        }

        public Object obtainCollectionInfo(int arg2, int arg3, boolean arg4) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(arg2, arg3, arg4);
        }

        public Object obtainCollectionInfo(int arg2, int arg3, boolean arg4, int arg5) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(arg2, arg3, arg4, arg5);
        }

        public Object obtainCollectionItemInfo(int arg2, int arg3, int arg4, int arg5, boolean arg6) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(arg2, arg3, arg4, arg5, arg6);
        }

        public Object obtainCollectionItemInfo(int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(arg2, arg3, arg4, arg5, arg6);
        }

        public Object obtainRangeInfo(int arg2, float arg3, float arg4, float arg5) {
            return AccessibilityNodeInfoCompatKitKat.obtainRangeInfo(arg2, arg3, arg4, arg5);
        }

        public void setCanOpenPopup(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(arg1, arg2);
        }

        public void setCollectionInfo(Object arg1, Object arg2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionInfo(arg1, arg2);
        }

        public void setCollectionItemInfo(Object arg1, Object arg2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(arg1, arg2);
        }

        public void setContentInvalid(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatKitKat.setContentInvalid(arg1, arg2);
        }

        public void setDismissable(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatKitKat.setDismissable(arg1, arg2);
        }

        public void setInputType(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatKitKat.setInputType(arg1, arg2);
        }

        public void setLiveRegion(Object arg1, int arg2) {
            AccessibilityNodeInfoCompatKitKat.setLiveRegion(arg1, arg2);
        }

        public void setMultiLine(Object arg1, boolean arg2) {
            AccessibilityNodeInfoCompatKitKat.setMultiLine(arg1, arg2);
        }

        public void setRangeInfo(Object arg1, Object arg2) {
            AccessibilityNodeInfoCompatKitKat.setRangeInfo(arg1, arg2);
        }

        public void setRoleDescription(Object arg1, CharSequence arg2) {
            AccessibilityNodeInfoCompatKitKat.setRoleDescription(arg1, arg2);
        }
    }

    class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
            super();
        }

        public void addAction(Object arg1, int arg2) {
        }

        public void addAction(Object arg1, Object arg2) {
        }

        public void addChild(Object arg1, View arg2) {
        }

        public void addChild(Object arg1, View arg2, int arg3) {
        }

        public boolean canOpenPopup(Object arg2) {
            return 0;
        }

        public List findAccessibilityNodeInfosByText(Object arg2, String arg3) {
            return Collections.emptyList();
        }

        public List findAccessibilityNodeInfosByViewId(Object arg2, String arg3) {
            return Collections.emptyList();
        }

        public Object findFocus(Object arg2, int arg3) {
            return null;
        }

        public Object focusSearch(Object arg2, int arg3) {
            return null;
        }

        public int getAccessibilityActionId(Object arg2) {
            return 0;
        }

        public CharSequence getAccessibilityActionLabel(Object arg2) {
            return null;
        }

        public Object getActionContextClick() {
            return null;
        }

        public List getActionList(Object arg2) {
            return null;
        }

        public Object getActionScrollDown() {
            return null;
        }

        public Object getActionScrollLeft() {
            return null;
        }

        public Object getActionScrollRight() {
            return null;
        }

        public Object getActionScrollToPosition() {
            return null;
        }

        public Object getActionScrollUp() {
            return null;
        }

        public Object getActionSetProgress() {
            return null;
        }

        public Object getActionShowOnScreen() {
            return null;
        }

        public int getActions(Object arg2) {
            return 0;
        }

        public void getBoundsInParent(Object arg1, Rect arg2) {
        }

        public void getBoundsInScreen(Object arg1, Rect arg2) {
        }

        public Object getChild(Object arg2, int arg3) {
            return null;
        }

        public int getChildCount(Object arg2) {
            return 0;
        }

        public CharSequence getClassName(Object arg2) {
            return null;
        }

        public Object getCollectionInfo(Object arg2) {
            return null;
        }

        public int getCollectionInfoColumnCount(Object arg2) {
            return 0;
        }

        public int getCollectionInfoRowCount(Object arg2) {
            return 0;
        }

        public int getCollectionInfoSelectionMode(Object arg2) {
            return 0;
        }

        public int getCollectionItemColumnIndex(Object arg2) {
            return 0;
        }

        public int getCollectionItemColumnSpan(Object arg2) {
            return 0;
        }

        public Object getCollectionItemInfo(Object arg2) {
            return null;
        }

        public int getCollectionItemRowIndex(Object arg2) {
            return 0;
        }

        public int getCollectionItemRowSpan(Object arg2) {
            return 0;
        }

        public CharSequence getContentDescription(Object arg2) {
            return null;
        }

        public int getDrawingOrder(Object arg2) {
            return 0;
        }

        public CharSequence getError(Object arg2) {
            return null;
        }

        public Bundle getExtras(Object arg2) {
            return new Bundle();
        }

        public int getInputType(Object arg2) {
            return 0;
        }

        public Object getLabelFor(Object arg2) {
            return null;
        }

        public Object getLabeledBy(Object arg2) {
            return null;
        }

        public int getLiveRegion(Object arg2) {
            return 0;
        }

        public int getMaxTextLength(Object arg2) {
            return -1;
        }

        public int getMovementGranularities(Object arg2) {
            return 0;
        }

        public CharSequence getPackageName(Object arg2) {
            return null;
        }

        public Object getParent(Object arg2) {
            return null;
        }

        public Object getRangeInfo(Object arg2) {
            return null;
        }

        public CharSequence getRoleDescription(Object arg2) {
            return null;
        }

        public CharSequence getText(Object arg2) {
            return null;
        }

        public int getTextSelectionEnd(Object arg2) {
            return -1;
        }

        public int getTextSelectionStart(Object arg2) {
            return -1;
        }

        public Object getTraversalAfter(Object arg2) {
            return null;
        }

        public Object getTraversalBefore(Object arg2) {
            return null;
        }

        public String getViewIdResourceName(Object arg2) {
            return null;
        }

        public Object getWindow(Object arg2) {
            return null;
        }

        public int getWindowId(Object arg2) {
            return 0;
        }

        public boolean isAccessibilityFocused(Object arg2) {
            return 0;
        }

        public boolean isCheckable(Object arg2) {
            return 0;
        }

        public boolean isChecked(Object arg2) {
            return 0;
        }

        public boolean isClickable(Object arg2) {
            return 0;
        }

        public boolean isCollectionInfoHierarchical(Object arg2) {
            return 0;
        }

        public boolean isCollectionItemHeading(Object arg2) {
            return 0;
        }

        public boolean isCollectionItemSelected(Object arg2) {
            return 0;
        }

        public boolean isContentInvalid(Object arg2) {
            return 0;
        }

        public boolean isContextClickable(Object arg2) {
            return 0;
        }

        public boolean isDismissable(Object arg2) {
            return 0;
        }

        public boolean isEditable(Object arg2) {
            return 0;
        }

        public boolean isEnabled(Object arg2) {
            return 0;
        }

        public boolean isFocusable(Object arg2) {
            return 0;
        }

        public boolean isFocused(Object arg2) {
            return 0;
        }

        public boolean isImportantForAccessibility(Object arg2) {
            return 1;
        }

        public boolean isLongClickable(Object arg2) {
            return 0;
        }

        public boolean isMultiLine(Object arg2) {
            return 0;
        }

        public boolean isPassword(Object arg2) {
            return 0;
        }

        public boolean isScrollable(Object arg2) {
            return 0;
        }

        public boolean isSelected(Object arg2) {
            return 0;
        }

        public boolean isVisibleToUser(Object arg2) {
            return 0;
        }

        public Object newAccessibilityAction(int arg2, CharSequence arg3) {
            return null;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(View arg2) {
            return null;
        }

        public Object obtain(View arg2, int arg3) {
            return null;
        }

        public Object obtain(Object arg2) {
            return null;
        }

        public Object obtainCollectionInfo(int arg2, int arg3, boolean arg4) {
            return null;
        }

        public Object obtainCollectionInfo(int arg2, int arg3, boolean arg4, int arg5) {
            return null;
        }

        public Object obtainCollectionItemInfo(int arg2, int arg3, int arg4, int arg5, boolean arg6) {
            return null;
        }

        public Object obtainCollectionItemInfo(int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) {
            return null;
        }

        public Object obtainRangeInfo(int arg2, float arg3, float arg4, float arg5) {
            return null;
        }

        public boolean performAction(Object arg2, int arg3) {
            return 0;
        }

        public boolean performAction(Object arg2, int arg3, Bundle arg4) {
            return 0;
        }

        public void recycle(Object arg1) {
        }

        public boolean refresh(Object arg2) {
            return 0;
        }

        public boolean removeAction(Object arg2, Object arg3) {
            return 0;
        }

        public boolean removeChild(Object arg2, View arg3) {
            return 0;
        }

        public boolean removeChild(Object arg2, View arg3, int arg4) {
            return 0;
        }

        public void setAccessibilityFocused(Object arg1, boolean arg2) {
        }

        public void setBoundsInParent(Object arg1, Rect arg2) {
        }

        public void setBoundsInScreen(Object arg1, Rect arg2) {
        }

        public void setCanOpenPopup(Object arg1, boolean arg2) {
        }

        public void setCheckable(Object arg1, boolean arg2) {
        }

        public void setChecked(Object arg1, boolean arg2) {
        }

        public void setClassName(Object arg1, CharSequence arg2) {
        }

        public void setClickable(Object arg1, boolean arg2) {
        }

        public void setCollectionInfo(Object arg1, Object arg2) {
        }

        public void setCollectionItemInfo(Object arg1, Object arg2) {
        }

        public void setContentDescription(Object arg1, CharSequence arg2) {
        }

        public void setContentInvalid(Object arg1, boolean arg2) {
        }

        public void setContextClickable(Object arg1, boolean arg2) {
        }

        public void setDismissable(Object arg1, boolean arg2) {
        }

        public void setDrawingOrder(Object arg1, int arg2) {
        }

        public void setEditable(Object arg1, boolean arg2) {
        }

        public void setEnabled(Object arg1, boolean arg2) {
        }

        public void setError(Object arg1, CharSequence arg2) {
        }

        public void setFocusable(Object arg1, boolean arg2) {
        }

        public void setFocused(Object arg1, boolean arg2) {
        }

        public void setImportantForAccessibility(Object arg1, boolean arg2) {
        }

        public void setInputType(Object arg1, int arg2) {
        }

        public void setLabelFor(Object arg1, View arg2) {
        }

        public void setLabelFor(Object arg1, View arg2, int arg3) {
        }

        public void setLabeledBy(Object arg1, View arg2) {
        }

        public void setLabeledBy(Object arg1, View arg2, int arg3) {
        }

        public void setLiveRegion(Object arg1, int arg2) {
        }

        public void setLongClickable(Object arg1, boolean arg2) {
        }

        public void setMaxTextLength(Object arg1, int arg2) {
        }

        public void setMovementGranularities(Object arg1, int arg2) {
        }

        public void setMultiLine(Object arg1, boolean arg2) {
        }

        public void setPackageName(Object arg1, CharSequence arg2) {
        }

        public void setParent(Object arg1, View arg2) {
        }

        public void setParent(Object arg1, View arg2, int arg3) {
        }

        public void setPassword(Object arg1, boolean arg2) {
        }

        public void setRangeInfo(Object arg1, Object arg2) {
        }

        public void setRoleDescription(Object arg1, CharSequence arg2) {
        }

        public void setScrollable(Object arg1, boolean arg2) {
        }

        public void setSelected(Object arg1, boolean arg2) {
        }

        public void setSource(Object arg1, View arg2) {
        }

        public void setSource(Object arg1, View arg2, int arg3) {
        }

        public void setText(Object arg1, CharSequence arg2) {
        }

        public void setTextSelection(Object arg1, int arg2, int arg3) {
        }

        public void setTraversalAfter(Object arg1, View arg2) {
        }

        public void setTraversalAfter(Object arg1, View arg2, int arg3) {
        }

        public void setTraversalBefore(Object arg1, View arg2) {
        }

        public void setTraversalBefore(Object arg1, View arg2, int arg3) {
        }

        public void setViewIdResourceName(Object arg1, String arg2) {
        }

        public void setVisibleToUser(Object arg1, boolean arg2) {
        }
    }

    public class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public int getSelectionMode() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(this.mInfo);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }

        public static CollectionInfoCompat obtain(int arg2, int arg3, boolean arg4) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(arg2, arg3, arg4));
        }

        public static CollectionInfoCompat obtain(int arg2, int arg3, boolean arg4, int arg5) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(arg2, arg3, arg4, arg5));
        }
    }

    public class CollectionItemInfoCompat {
        final Object mInfo;

        CollectionItemInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }

        public static CollectionItemInfoCompat obtain(int arg7, int arg8, int arg9, int arg10, boolean arg11) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(arg7, arg8, arg9, arg10, arg11));
        }

        public static CollectionItemInfoCompat obtain(int arg8, int arg9, int arg10, int arg11, boolean arg12, boolean arg13) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(arg8, arg9, arg10, arg11, arg12, arg13));
        }
    }

    public class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public float getCurrent() {
            return RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return RangeInfo.getType(this.mInfo);
        }

        public static RangeInfoCompat obtain(int arg2, float arg3, float arg4, float arg5) {
            return new RangeInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(arg2, arg3, arg4, arg5));
        }
    }

    public static final int ACTION_ACCESSIBILITY_FOCUS = 0x40;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 0x80;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 0x80000;
    public static final int ACTION_COPY = 0x4000;
    public static final int ACTION_CUT = 0x10000;
    public static final int ACTION_DISMISS = 0x100000;
    public static final int ACTION_EXPAND = 0x40000;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 0x20;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 0x100;
    public static final int ACTION_NEXT_HTML_ELEMENT = 0x400;
    public static final int ACTION_PASTE = 0x8000;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 0x200;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 0x800;
    public static final int ACTION_SCROLL_BACKWARD = 0x2000;
    public static final int ACTION_SCROLL_FORWARD = 0x1000;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 0x20000;
    public static final int ACTION_SET_TEXT = 0x200000;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    static final AccessibilityNodeInfoImpl IMPL = null;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public int mParentVirtualDescendantId;

    static {
        if(Build$VERSION.SDK_INT >= 24) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoApi24Impl();
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoApi23Impl();
        }
        else if(Build$VERSION.SDK_INT >= 22) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoApi22Impl();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoApi21Impl();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoKitKatImpl();
        }
        else if(Build$VERSION.SDK_INT >= 18) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
        }
        else if(Build$VERSION.SDK_INT >= 17) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoJellybeanImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoIcsImpl();
        }
        else {
            AccessibilityNodeInfoCompat.IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }

    public AccessibilityNodeInfoCompat(Object arg2) {
        super();
        this.mParentVirtualDescendantId = -1;
        this.mInfo = arg2;
    }

    public void addAction(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.addAction(this.mInfo, arg3);
    }

    public void addAction(AccessibilityActionCompat arg4) {
        AccessibilityNodeInfoCompat.IMPL.addAction(this.mInfo, arg4.mAction);
    }

    public void addChild(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, arg3);
    }

    public void addChild(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, arg3, arg4);
    }

    public boolean canOpenPopup() {
        return AccessibilityNodeInfoCompat.IMPL.canOpenPopup(this.mInfo);
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((AccessibilityNodeInfoCompat)arg5))) {
            if(arg5 == null) {
                v0 = false;
            }
            else if(this.getClass() != arg5.getClass()) {
                v0 = false;
            }
            else if(this.mInfo == null) {
                if(((AccessibilityNodeInfoCompat)arg5).mInfo != null) {
                    v0 = false;
                }
            }
            else if(!this.mInfo.equals(((AccessibilityNodeInfoCompat)arg5).mInfo)) {
                v0 = false;
            }
        }

        return v0;
    }

    public List findAccessibilityNodeInfosByText(String arg7) {
        ArrayList v1 = new ArrayList();
        List v2 = AccessibilityNodeInfoCompat.IMPL.findAccessibilityNodeInfosByText(this.mInfo, arg7);
        int v3 = v2.size();
        int v0;
        for(v0 = 0; v0 < v3; ++v0) {
            ((List)v1).add(new AccessibilityNodeInfoCompat(v2.get(v0)));
        }

        return ((List)v1);
    }

    public List findAccessibilityNodeInfosByViewId(String arg5) {
        ArrayList v0;
        List v1 = AccessibilityNodeInfoCompat.IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, arg5);
        if(v1 != null) {
            v0 = new ArrayList();
            Iterator v1_1 = v1.iterator();
            while(v1_1.hasNext()) {
                ((List)v0).add(new AccessibilityNodeInfoCompat(v1_1.next()));
            }
        }
        else {
            List v0_1 = Collections.emptyList();
        }

        return ((List)v0);
    }

    public AccessibilityNodeInfoCompat findFocus(int arg3) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.findFocus(this.mInfo, arg3));
    }

    public AccessibilityNodeInfoCompat focusSearch(int arg3) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.focusSearch(this.mInfo, arg3));
    }

    public List getActionList() {
        ArrayList v0;
        List v2 = AccessibilityNodeInfoCompat.IMPL.getActionList(this.mInfo);
        if(v2 != null) {
            v0 = new ArrayList();
            int v3 = v2.size();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                ((List)v0).add(new AccessibilityActionCompat(v2.get(v1)));
            }
        }
        else {
            List v0_1 = Collections.emptyList();
        }

        return ((List)v0);
    }

    private static String getActionSymbolicName(int arg1) {
        String v0;
        switch(arg1) {
            case 1: {
                v0 = "ACTION_FOCUS";
                break;
            }
            case 2: {
                v0 = "ACTION_CLEAR_FOCUS";
                break;
            }
            case 4: {
                v0 = "ACTION_SELECT";
                break;
            }
            case 8: {
                v0 = "ACTION_CLEAR_SELECTION";
                break;
            }
            case 16: {
                v0 = "ACTION_CLICK";
                break;
            }
            case 32: {
                v0 = "ACTION_LONG_CLICK";
                break;
            }
            case 64: {
                v0 = "ACTION_ACCESSIBILITY_FOCUS";
                break;
            }
            case 128: {
                v0 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                break;
            }
            case 256: {
                v0 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                break;
            }
            case 512: {
                v0 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                break;
            }
            case 1024: {
                v0 = "ACTION_NEXT_HTML_ELEMENT";
                break;
            }
            case 2048: {
                v0 = "ACTION_PREVIOUS_HTML_ELEMENT";
                break;
            }
            case 4096: {
                v0 = "ACTION_SCROLL_FORWARD";
                break;
            }
            case 8192: {
                v0 = "ACTION_SCROLL_BACKWARD";
                break;
            }
            case 16384: {
                v0 = "ACTION_COPY";
                break;
            }
            case 32768: {
                v0 = "ACTION_PASTE";
                break;
            }
            case 65536: {
                v0 = "ACTION_CUT";
                break;
            }
            case 131072: {
                v0 = "ACTION_SET_SELECTION";
                break;
            }
            default: {
                v0 = "ACTION_UNKNOWN";
                break;
            }
        }

        return v0;
    }

    public int getActions() {
        return AccessibilityNodeInfoCompat.IMPL.getActions(this.mInfo);
    }

    public void getBoundsInParent(Rect arg3) {
        AccessibilityNodeInfoCompat.IMPL.getBoundsInParent(this.mInfo, arg3);
    }

    public void getBoundsInScreen(Rect arg3) {
        AccessibilityNodeInfoCompat.IMPL.getBoundsInScreen(this.mInfo, arg3);
    }

    public AccessibilityNodeInfoCompat getChild(int arg3) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getChild(this.mInfo, arg3));
    }

    public int getChildCount() {
        return AccessibilityNodeInfoCompat.IMPL.getChildCount(this.mInfo);
    }

    public CharSequence getClassName() {
        return AccessibilityNodeInfoCompat.IMPL.getClassName(this.mInfo);
    }

    public CollectionInfoCompat getCollectionInfo() {
        Object v1 = AccessibilityNodeInfoCompat.IMPL.getCollectionInfo(this.mInfo);
        CollectionInfoCompat v0 = v1 == null ? null : new CollectionInfoCompat(v1);
        return v0;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        Object v1 = AccessibilityNodeInfoCompat.IMPL.getCollectionItemInfo(this.mInfo);
        CollectionItemInfoCompat v0 = v1 == null ? null : new CollectionItemInfoCompat(v1);
        return v0;
    }

    public CharSequence getContentDescription() {
        return AccessibilityNodeInfoCompat.IMPL.getContentDescription(this.mInfo);
    }

    public int getDrawingOrder() {
        return AccessibilityNodeInfoCompat.IMPL.getDrawingOrder(this.mInfo);
    }

    public CharSequence getError() {
        return AccessibilityNodeInfoCompat.IMPL.getError(this.mInfo);
    }

    public Bundle getExtras() {
        return AccessibilityNodeInfoCompat.IMPL.getExtras(this.mInfo);
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return AccessibilityNodeInfoCompat.IMPL.getInputType(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getLabelFor(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getLabeledBy(this.mInfo));
    }

    public int getLiveRegion() {
        return AccessibilityNodeInfoCompat.IMPL.getLiveRegion(this.mInfo);
    }

    public int getMaxTextLength() {
        return AccessibilityNodeInfoCompat.IMPL.getMaxTextLength(this.mInfo);
    }

    public int getMovementGranularities() {
        return AccessibilityNodeInfoCompat.IMPL.getMovementGranularities(this.mInfo);
    }

    public CharSequence getPackageName() {
        return AccessibilityNodeInfoCompat.IMPL.getPackageName(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getParent(this.mInfo));
    }

    public RangeInfoCompat getRangeInfo() {
        Object v1 = AccessibilityNodeInfoCompat.IMPL.getRangeInfo(this.mInfo);
        RangeInfoCompat v0 = v1 == null ? null : new RangeInfoCompat(v1);
        return v0;
    }

    @Nullable public CharSequence getRoleDescription() {
        return AccessibilityNodeInfoCompat.IMPL.getRoleDescription(this.mInfo);
    }

    public CharSequence getText() {
        return AccessibilityNodeInfoCompat.IMPL.getText(this.mInfo);
    }

    public int getTextSelectionEnd() {
        return AccessibilityNodeInfoCompat.IMPL.getTextSelectionEnd(this.mInfo);
    }

    public int getTextSelectionStart() {
        return AccessibilityNodeInfoCompat.IMPL.getTextSelectionStart(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getTraversalAfter(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getTraversalBefore(this.mInfo));
    }

    public String getViewIdResourceName() {
        return AccessibilityNodeInfoCompat.IMPL.getViewIdResourceName(this.mInfo);
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.getWindow(this.mInfo));
    }

    public int getWindowId() {
        return AccessibilityNodeInfoCompat.IMPL.getWindowId(this.mInfo);
    }

    public int hashCode() {
        int v0 = this.mInfo == null ? 0 : this.mInfo.hashCode();
        return v0;
    }

    public boolean isAccessibilityFocused() {
        return AccessibilityNodeInfoCompat.IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable() {
        return AccessibilityNodeInfoCompat.IMPL.isCheckable(this.mInfo);
    }

    public boolean isChecked() {
        return AccessibilityNodeInfoCompat.IMPL.isChecked(this.mInfo);
    }

    public boolean isClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isClickable(this.mInfo);
    }

    public boolean isContentInvalid() {
        return AccessibilityNodeInfoCompat.IMPL.isContentInvalid(this.mInfo);
    }

    public boolean isContextClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isContextClickable(this.mInfo);
    }

    public boolean isDismissable() {
        return AccessibilityNodeInfoCompat.IMPL.isDismissable(this.mInfo);
    }

    public boolean isEditable() {
        return AccessibilityNodeInfoCompat.IMPL.isEditable(this.mInfo);
    }

    public boolean isEnabled() {
        return AccessibilityNodeInfoCompat.IMPL.isEnabled(this.mInfo);
    }

    public boolean isFocusable() {
        return AccessibilityNodeInfoCompat.IMPL.isFocusable(this.mInfo);
    }

    public boolean isFocused() {
        return AccessibilityNodeInfoCompat.IMPL.isFocused(this.mInfo);
    }

    public boolean isImportantForAccessibility() {
        return AccessibilityNodeInfoCompat.IMPL.isImportantForAccessibility(this.mInfo);
    }

    public boolean isLongClickable() {
        return AccessibilityNodeInfoCompat.IMPL.isLongClickable(this.mInfo);
    }

    public boolean isMultiLine() {
        return AccessibilityNodeInfoCompat.IMPL.isMultiLine(this.mInfo);
    }

    public boolean isPassword() {
        return AccessibilityNodeInfoCompat.IMPL.isPassword(this.mInfo);
    }

    public boolean isScrollable() {
        return AccessibilityNodeInfoCompat.IMPL.isScrollable(this.mInfo);
    }

    public boolean isSelected() {
        return AccessibilityNodeInfoCompat.IMPL.isSelected(this.mInfo);
    }

    public boolean isVisibleToUser() {
        return AccessibilityNodeInfoCompat.IMPL.isVisibleToUser(this.mInfo);
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat arg2) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(arg2.mInfo));
    }

    public static AccessibilityNodeInfoCompat obtain(View arg1) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(arg1));
    }

    public static AccessibilityNodeInfoCompat obtain(View arg1, int arg2) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfoCompat.IMPL.obtain(arg1, arg2));
    }

    public boolean performAction(int arg3) {
        return AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, arg3);
    }

    public boolean performAction(int arg3, Bundle arg4) {
        return AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, arg3, arg4);
    }

    public void recycle() {
        AccessibilityNodeInfoCompat.IMPL.recycle(this.mInfo);
    }

    public boolean refresh() {
        return AccessibilityNodeInfoCompat.IMPL.refresh(this.mInfo);
    }

    public boolean removeAction(AccessibilityActionCompat arg4) {
        return AccessibilityNodeInfoCompat.IMPL.removeAction(this.mInfo, arg4.mAction);
    }

    public boolean removeChild(View arg3) {
        return AccessibilityNodeInfoCompat.IMPL.removeChild(this.mInfo, arg3);
    }

    public boolean removeChild(View arg3, int arg4) {
        return AccessibilityNodeInfoCompat.IMPL.removeChild(this.mInfo, arg3, arg4);
    }

    public void setAccessibilityFocused(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setAccessibilityFocused(this.mInfo, arg3);
    }

    public void setBoundsInParent(Rect arg3) {
        AccessibilityNodeInfoCompat.IMPL.setBoundsInParent(this.mInfo, arg3);
    }

    public void setBoundsInScreen(Rect arg3) {
        AccessibilityNodeInfoCompat.IMPL.setBoundsInScreen(this.mInfo, arg3);
    }

    public void setCanOpenPopup(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setCanOpenPopup(this.mInfo, arg3);
    }

    public void setCheckable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setCheckable(this.mInfo, arg3);
    }

    public void setChecked(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setChecked(this.mInfo, arg3);
    }

    public void setClassName(CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setClassName(this.mInfo, arg3);
    }

    public void setClickable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setClickable(this.mInfo, arg3);
    }

    public void setCollectionInfo(Object arg4) {
        AccessibilityNodeInfoCompat.IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat)arg4).mInfo);
    }

    public void setCollectionItemInfo(Object arg4) {
        AccessibilityNodeInfoCompat.IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat)arg4).mInfo);
    }

    public void setContentDescription(CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setContentDescription(this.mInfo, arg3);
    }

    public void setContentInvalid(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setContentInvalid(this.mInfo, arg3);
    }

    public void setContextClickable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setContextClickable(this.mInfo, arg3);
    }

    public void setDismissable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setDismissable(this.mInfo, arg3);
    }

    public void setDrawingOrder(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.setDrawingOrder(this.mInfo, arg3);
    }

    public void setEditable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setEditable(this.mInfo, arg3);
    }

    public void setEnabled(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setEnabled(this.mInfo, arg3);
    }

    public void setError(CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setError(this.mInfo, arg3);
    }

    public void setFocusable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setFocusable(this.mInfo, arg3);
    }

    public void setFocused(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setFocused(this.mInfo, arg3);
    }

    public void setImportantForAccessibility(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setImportantForAccessibility(this.mInfo, arg3);
    }

    public void setInputType(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.setInputType(this.mInfo, arg3);
    }

    public void setLabelFor(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setLabelFor(this.mInfo, arg3);
    }

    public void setLabelFor(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setLabelFor(this.mInfo, arg3, arg4);
    }

    public void setLabeledBy(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setLabeledBy(this.mInfo, arg3);
    }

    public void setLabeledBy(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setLabeledBy(this.mInfo, arg3, arg4);
    }

    public void setLiveRegion(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.setLiveRegion(this.mInfo, arg3);
    }

    public void setLongClickable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setLongClickable(this.mInfo, arg3);
    }

    public void setMaxTextLength(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.setMaxTextLength(this.mInfo, arg3);
    }

    public void setMovementGranularities(int arg3) {
        AccessibilityNodeInfoCompat.IMPL.setMovementGranularities(this.mInfo, arg3);
    }

    public void setMultiLine(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setMultiLine(this.mInfo, arg3);
    }

    public void setPackageName(CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setPackageName(this.mInfo, arg3);
    }

    public void setParent(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, arg3);
    }

    public void setParent(View arg3, int arg4) {
        this.mParentVirtualDescendantId = arg4;
        AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, arg3, arg4);
    }

    public void setPassword(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setPassword(this.mInfo, arg3);
    }

    public void setRangeInfo(RangeInfoCompat arg4) {
        AccessibilityNodeInfoCompat.IMPL.setRangeInfo(this.mInfo, arg4.mInfo);
    }

    public void setRoleDescription(@Nullable CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setRoleDescription(this.mInfo, arg3);
    }

    public void setScrollable(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setScrollable(this.mInfo, arg3);
    }

    public void setSelected(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setSelected(this.mInfo, arg3);
    }

    public void setSource(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, arg3);
    }

    public void setSource(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, arg3, arg4);
    }

    public void setText(CharSequence arg3) {
        AccessibilityNodeInfoCompat.IMPL.setText(this.mInfo, arg3);
    }

    public void setTextSelection(int arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setTextSelection(this.mInfo, arg3, arg4);
    }

    public void setTraversalAfter(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalAfter(this.mInfo, arg3);
    }

    public void setTraversalAfter(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalAfter(this.mInfo, arg3, arg4);
    }

    public void setTraversalBefore(View arg3) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalBefore(this.mInfo, arg3);
    }

    public void setTraversalBefore(View arg3, int arg4) {
        AccessibilityNodeInfoCompat.IMPL.setTraversalBefore(this.mInfo, arg3, arg4);
    }

    public void setViewIdResourceName(String arg3) {
        AccessibilityNodeInfoCompat.IMPL.setViewIdResourceName(this.mInfo, arg3);
    }

    public void setVisibleToUser(boolean arg3) {
        AccessibilityNodeInfoCompat.IMPL.setVisibleToUser(this.mInfo, arg3);
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder();
        v1.append(super.toString());
        Rect v0 = new Rect();
        this.getBoundsInParent(v0);
        v1.append("; boundsInParent: " + v0);
        this.getBoundsInScreen(v0);
        v1.append("; boundsInScreen: " + v0);
        v1.append("; packageName: ").append(this.getPackageName());
        v1.append("; className: ").append(this.getClassName());
        v1.append("; text: ").append(this.getText());
        v1.append("; contentDescription: ").append(this.getContentDescription());
        v1.append("; viewId: ").append(this.getViewIdResourceName());
        v1.append("; checkable: ").append(this.isCheckable());
        v1.append("; checked: ").append(this.isChecked());
        v1.append("; focusable: ").append(this.isFocusable());
        v1.append("; focused: ").append(this.isFocused());
        v1.append("; selected: ").append(this.isSelected());
        v1.append("; clickable: ").append(this.isClickable());
        v1.append("; longClickable: ").append(this.isLongClickable());
        v1.append("; enabled: ").append(this.isEnabled());
        v1.append("; password: ").append(this.isPassword());
        v1.append("; scrollable: " + this.isScrollable());
        v1.append("; [");
        int v0_1 = this.getActions();
        while(v0_1 != 0) {
            int v2 = 1 << Integer.numberOfTrailingZeros(v0_1);
            v0_1 &= v2 ^ -1;
            v1.append(AccessibilityNodeInfoCompat.getActionSymbolicName(v2));
            if(v0_1 == 0) {
                continue;
            }

            v1.append(", ");
        }

        v1.append("]");
        return v1.toString();
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object arg1) {
        AccessibilityNodeInfoCompat v0 = arg1 != null ? new AccessibilityNodeInfoCompat(arg1) : null;
        return v0;
    }
}

