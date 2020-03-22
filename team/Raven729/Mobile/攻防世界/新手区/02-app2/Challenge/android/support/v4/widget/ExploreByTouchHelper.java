package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    final class android.support.v4.widget.ExploreByTouchHelper$1 implements BoundsAdapter {
        android.support.v4.widget.ExploreByTouchHelper$1() {
            super();
        }

        public void obtainBounds(AccessibilityNodeInfoCompat arg1, Rect arg2) {
            arg1.getBoundsInParent(arg2);
        }

        public void obtainBounds(Object arg1, Rect arg2) {
            this.obtainBounds(((AccessibilityNodeInfoCompat)arg1), arg2);
        }
    }

    final class android.support.v4.widget.ExploreByTouchHelper$2 implements CollectionAdapter {
        android.support.v4.widget.ExploreByTouchHelper$2() {
            super();
        }

        public AccessibilityNodeInfoCompat get(SparseArrayCompat arg2, int arg3) {
            return arg2.valueAt(arg3);
        }

        public Object get(Object arg2, int arg3) {
            return this.get(((SparseArrayCompat)arg2), arg3);
        }

        public int size(SparseArrayCompat arg2) {
            return arg2.size();
        }

        public int size(Object arg2) {
            return this.size(((SparseArrayCompat)arg2));
        }
    }

    class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider(ExploreByTouchHelper arg1) {
            ExploreByTouchHelper.this = arg1;
            super();
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int arg2) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(arg2));
        }

        public AccessibilityNodeInfoCompat findFocus(int arg3) {
            int v0 = arg3 == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            AccessibilityNodeInfoCompat v0_1 = v0 == 0x80000000 ? null : this.createAccessibilityNodeInfo(v0);
            return v0_1;
        }

        public boolean performAction(int arg2, int arg3, Bundle arg4) {
            return ExploreByTouchHelper.this.performAction(arg2, arg3, arg4);
        }
    }

    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = 0x80000000;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final BoundsAdapter NODE_ADAPTER;
    private static final CollectionAdapter SPARSE_VALUES_ADAPTER;
    private int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    private int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    static {
        ExploreByTouchHelper.INVALID_PARENT_BOUNDS = new Rect(0x7FFFFFFF, 0x7FFFFFFF, 0x80000000, 0x80000000);
        ExploreByTouchHelper.NODE_ADAPTER = new android.support.v4.widget.ExploreByTouchHelper$1();
        ExploreByTouchHelper.SPARSE_VALUES_ADAPTER = new android.support.v4.widget.ExploreByTouchHelper$2();
    }

    public ExploreByTouchHelper(View arg4) {
        super();
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = 0x80000000;
        this.mKeyboardFocusedVirtualViewId = 0x80000000;
        this.mHoveredVirtualViewId = 0x80000000;
        if(arg4 == null) {
            throw new IllegalArgumentException("View may not be null");
        }

        this.mHost = arg4;
        this.mManager = arg4.getContext().getSystemService("accessibility");
        arg4.setFocusable(true);
        if(ViewCompat.getImportantForAccessibility(arg4) == 0) {
            ViewCompat.setImportantForAccessibility(arg4, 1);
        }
    }

    static int access$000(ExploreByTouchHelper arg1) {
        return arg1.mAccessibilityFocusedVirtualViewId;
    }

    static int access$100(ExploreByTouchHelper arg1) {
        return arg1.mKeyboardFocusedVirtualViewId;
    }

    private boolean clearAccessibilityFocus(int arg2) {
        boolean v0;
        if(this.mAccessibilityFocusedVirtualViewId == arg2) {
            this.mAccessibilityFocusedVirtualViewId = 0x80000000;
            this.mHost.invalidate();
            this.sendEventForVirtualView(arg2, 0x10000);
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public final boolean clearKeyboardFocusForVirtualView(int arg3) {
        boolean v0 = false;
        if(this.mKeyboardFocusedVirtualViewId == arg3) {
            this.mKeyboardFocusedVirtualViewId = 0x80000000;
            this.onVirtualViewKeyboardFocusChanged(arg3, false);
            this.sendEventForVirtualView(arg3, 8);
            v0 = true;
        }

        return v0;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        boolean v0 = this.mKeyboardFocusedVirtualViewId == 0x80000000 || !this.onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null) ? false : true;
        return v0;
    }

    private AccessibilityEvent createEvent(int arg2, int arg3) {
        AccessibilityEvent v0;
        switch(arg2) {
            case -1: {
                v0 = this.createEventForHost(arg3);
                break;
            }
            default: {
                v0 = this.createEventForChild(arg2, arg3);
                break;
            }
        }

        return v0;
    }

    private AccessibilityEvent createEventForChild(int arg6, int arg7) {
        AccessibilityEvent v0 = AccessibilityEvent.obtain(arg7);
        AccessibilityRecordCompat v1 = AccessibilityEventCompat.asRecord(v0);
        AccessibilityNodeInfoCompat v2 = this.obtainAccessibilityNodeInfo(arg6);
        v1.getText().add(v2.getText());
        v1.setContentDescription(v2.getContentDescription());
        v1.setScrollable(v2.isScrollable());
        v1.setPassword(v2.isPassword());
        v1.setEnabled(v2.isEnabled());
        v1.setChecked(v2.isChecked());
        this.onPopulateEventForVirtualView(arg6, v0);
        if((v0.getText().isEmpty()) && v0.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }

        v1.setClassName(v2.getClassName());
        v1.setSource(this.mHost, arg6);
        v0.setPackageName(this.mHost.getContext().getPackageName());
        return v0;
    }

    private AccessibilityEvent createEventForHost(int arg3) {
        AccessibilityEvent v0 = AccessibilityEvent.obtain(arg3);
        ViewCompat.onInitializeAccessibilityEvent(this.mHost, v0);
        return v0;
    }

    @NonNull private AccessibilityNodeInfoCompat createNodeForChild(int arg9) {
        int v7 = -1;
        AccessibilityNodeInfoCompat v3 = AccessibilityNodeInfoCompat.obtain();
        v3.setEnabled(true);
        v3.setFocusable(true);
        v3.setClassName("android.view.View");
        v3.setBoundsInParent(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
        v3.setBoundsInScreen(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
        v3.setParent(this.mHost);
        this.onPopulateNodeForVirtualView(arg9, v3);
        if(v3.getText() == null && v3.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }

        v3.getBoundsInParent(this.mTempParentRect);
        if(this.mTempParentRect.equals(ExploreByTouchHelper.INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }

        int v0 = v3.getActions();
        if((v0 & 0x40) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }

        if((v0 & 0x80) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }

        v3.setPackageName(this.mHost.getContext().getPackageName());
        v3.setSource(this.mHost, arg9);
        if(this.mAccessibilityFocusedVirtualViewId == arg9) {
            v3.setAccessibilityFocused(true);
            v3.addAction(0x80);
        }
        else {
            v3.setAccessibilityFocused(false);
            v3.addAction(0x40);
        }

        boolean v0_1 = this.mKeyboardFocusedVirtualViewId == arg9 ? true : false;
        if(v0_1) {
            v3.addAction(2);
        }
        else if(v3.isFocusable()) {
            v3.addAction(1);
        }

        v3.setFocused(v0_1);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        v3.getBoundsInScreen(this.mTempScreenRect);
        if(this.mTempScreenRect.equals(ExploreByTouchHelper.INVALID_PARENT_BOUNDS)) {
            v3.getBoundsInParent(this.mTempScreenRect);
            if(v3.mParentVirtualDescendantId != v7) {
                AccessibilityNodeInfoCompat v4 = AccessibilityNodeInfoCompat.obtain();
                for(v0 = v3.mParentVirtualDescendantId; v0 != v7; v0 = v4.mParentVirtualDescendantId) {
                    v4.setParent(this.mHost, v7);
                    v4.setBoundsInParent(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
                    this.onPopulateNodeForVirtualView(v0, v4);
                    v4.getBoundsInParent(this.mTempParentRect);
                    this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                }

                v4.recycle();
            }

            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }

        if(this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            this.mTempScreenRect.intersect(this.mTempVisibleRect);
            v3.setBoundsInScreen(this.mTempScreenRect);
            if(this.isVisibleToUser(this.mTempScreenRect)) {
                v3.setVisibleToUser(true);
            }
        }

        return v3;
    }

    @NonNull private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat v2 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, v2);
        ArrayList v3 = new ArrayList();
        this.getVisibleVirtualViews(((List)v3));
        if(v2.getChildCount() > 0 && v3.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }

        int v4 = v3.size();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            v2.addChild(this.mHost, v3.get(v1).intValue());
        }

        return v2;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent arg6) {
        boolean v0 = true;
        int v4 = 0x80000000;
        boolean v1 = false;
        if((this.mManager.isEnabled()) && (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager))) {
            switch(arg6.getAction()) {
                case 7: 
                case 9: {
                    goto label_13;
                }
                case 10: {
                    goto label_22;
                }
            }

            return v1;
        label_22:
            if(this.mAccessibilityFocusedVirtualViewId != v4) {
                this.updateHoveredVirtualView(v4);
                return true;
            label_13:
                int v2 = this.getVirtualViewAt(arg6.getX(), arg6.getY());
                this.updateHoveredVirtualView(v2);
                if(v2 == v4) {
                    v0 = false;
                }

                v1 = v0;
            }
        }

        return v1;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent arg8) {
        boolean v0 = false;
        Rect v6 = null;
        if(arg8.getAction() != 1) {
            int v2 = arg8.getKeyCode();
            switch(v2) {
                case 19: 
                case 20: 
                case 21: 
                case 22: {
                    goto label_8;
                }
                case 61: {
                    goto label_28;
                }
                case 23: 
                case 66: {
                    goto label_21;
                }
            }

            return v0;
        label_21:
            if((KeyEventCompat.hasNoModifiers(arg8)) && arg8.getRepeatCount() == 0) {
                this.clickKeyboardFocusedVirtualView();
                return true;
            label_8:
                if(KeyEventCompat.hasNoModifiers(arg8)) {
                    int v3 = ExploreByTouchHelper.keyToDirection(v2);
                    int v4 = arg8.getRepeatCount() + 1;
                    v2 = 0;
                    while(true) {
                        if(v2 < v4 && (this.moveFocus(v3, v6))) {
                            ++v2;
                            v0 = true;
                            continue;
                        }

                        return v0;
                    }

                label_28:
                    if(KeyEventCompat.hasNoModifiers(arg8)) {
                        v0 = this.moveFocus(2, v6);
                    }
                    else if(KeyEventCompat.hasModifiers(arg8, 1)) {
                        v0 = this.moveFocus(1, v6);
                    }
                }
            }
        }

        return v0;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg2) {
        if(this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider(this);
        }

        return this.mNodeProvider;
    }

    private SparseArrayCompat getAllNodes() {
        ArrayList v1 = new ArrayList();
        this.getVisibleVirtualViews(((List)v1));
        SparseArrayCompat v2 = new SparseArrayCompat();
        int v0;
        for(v0 = 0; v0 < ((List)v1).size(); ++v0) {
            v2.put(v0, this.createNodeForChild(v0));
        }

        return v2;
    }

    private void getBoundsInParent(int arg2, Rect arg3) {
        this.obtainAccessibilityNodeInfo(arg2).getBoundsInParent(arg3);
    }

    @Deprecated public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float arg1, float arg2);

    protected abstract void getVisibleVirtualViews(List arg1);

    private static Rect guessPreviouslyFocusedRect(@NonNull View arg4, int arg5, @NonNull Rect arg6) {
        int v2 = -1;
        int v0 = arg4.getWidth();
        int v1 = arg4.getHeight();
        switch(arg5) {
            case 17: {
                goto label_9;
            }
            case 33: {
                goto label_11;
            }
            case 66: {
                goto label_13;
            }
            case 130: {
                goto label_15;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_9:
        arg6.set(v0, 0, v0, v1);
        return arg6;
    label_11:
        arg6.set(0, v1, v0, v1);
        return arg6;
    label_13:
        arg6.set(v2, 0, v2, v1);
        return arg6;
    label_15:
        arg6.set(0, v2, v0, v2);
        return arg6;
    }

    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int arg4, int arg5) {
        if(arg4 != 0x80000000 && (this.mManager.isEnabled())) {
            ViewParent v0 = this.mHost.getParent();
            if(v0 != null) {
                AccessibilityEvent v1 = this.createEvent(arg4, 0x800);
                AccessibilityEventCompat.setContentChangeTypes(v1, arg5);
                ViewParentCompat.requestSendAccessibilityEvent(v0, this.mHost, v1);
            }
        }
    }

    public final void invalidateVirtualView(int arg2) {
        this.invalidateVirtualView(arg2, 0);
    }

    private boolean isVisibleToUser(Rect arg5) {
        boolean v1 = false;
        if(arg5 != null && !arg5.isEmpty() && this.mHost.getWindowVisibility() == 0) {
            ViewParent v0 = this.mHost.getParent();
            while(true) {
                if(!(v0 instanceof View)) {
                    break;
                }
                else if(ViewCompat.getAlpha(((View)v0)) > 0f && ((View)v0).getVisibility() == 0) {
                    v0 = ((View)v0).getParent();
                    continue;
                }

                return v1;
            }

            boolean v0_1 = v0 != null ? true : false;
            v1 = v0_1;
        }

        return v1;
    }

    private static int keyToDirection(int arg1) {
        int v0;
        switch(arg1) {
            case 19: {
                v0 = 33;
                break;
            }
            case 21: {
                v0 = 17;
                break;
            }
            case 22: {
                v0 = 66;
                break;
            }
            default: {
                v0 = 130;
                break;
            }
        }

        return v0;
    }

    private boolean moveFocus(int arg9, @Nullable Rect arg10) {
        boolean v5 = true;
        int v7 = 0x80000000;
        SparseArrayCompat v0 = this.getAllNodes();
        int v1 = this.mKeyboardFocusedVirtualViewId;
        Object v3 = v1 == v7 ? null : v0.get(v1);
        switch(arg9) {
            case 1: 
            case 2: {
                goto label_15;
            }
            case 17: 
            case 33: 
            case 66: 
            case 130: {
                goto label_28;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_28:
        Rect v4 = new Rect();
        if(this.mKeyboardFocusedVirtualViewId != v7) {
            this.getBoundsInParent(this.mKeyboardFocusedVirtualViewId, v4);
        }
        else if(arg10 != null) {
            v4.set(arg10);
        }
        else {
            ExploreByTouchHelper.guessPreviouslyFocusedRect(this.mHost, arg9, v4);
        }

        Object v1_1 = FocusStrategy.findNextFocusInAbsoluteDirection(v0, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, v3, v4, arg9);
        goto label_22;
    label_15:
        if(ViewCompat.getLayoutDirection(this.mHost) != 1) {
            v5 = false;
        }

        v1_1 = FocusStrategy.findNextFocusInRelativeDirection(v0, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, v3, arg9, v5, false);
    label_22:
        int v0_1 = v1_1 == null ? v7 : v0.keyAt(v0.indexOfValue(v1_1));
        return this.requestKeyboardFocusForVirtualView(v0_1);
    }

    @NonNull AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int arg2) {
        AccessibilityNodeInfoCompat v0 = arg2 == -1 ? this.createNodeForHost() : this.createNodeForChild(arg2);
        return v0;
    }

    public final void onFocusChanged(boolean arg3, int arg4, @Nullable Rect arg5) {
        if(this.mKeyboardFocusedVirtualViewId != 0x80000000) {
            this.clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }

        if(arg3) {
            this.moveFocus(arg4, arg5);
        }
    }

    public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg1, arg2);
        this.onPopulateEventForHost(arg2);
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        super.onInitializeAccessibilityNodeInfo(arg1, arg2);
        this.onPopulateNodeForHost(arg2);
    }

    protected abstract boolean onPerformActionForVirtualView(int arg1, int arg2, Bundle arg3);

    protected void onPopulateEventForHost(AccessibilityEvent arg1) {
    }

    protected void onPopulateEventForVirtualView(int arg1, AccessibilityEvent arg2) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat arg1) {
    }

    protected abstract void onPopulateNodeForVirtualView(int arg1, AccessibilityNodeInfoCompat arg2);

    protected void onVirtualViewKeyboardFocusChanged(int arg1, boolean arg2) {
    }

    boolean performAction(int arg2, int arg3, Bundle arg4) {
        boolean v0;
        switch(arg2) {
            case -1: {
                v0 = this.performActionForHost(arg3, arg4);
                break;
            }
            default: {
                v0 = this.performActionForChild(arg2, arg3, arg4);
                break;
            }
        }

        return v0;
    }

    private boolean performActionForChild(int arg2, int arg3, Bundle arg4) {
        boolean v0;
        switch(arg3) {
            case 1: {
                v0 = this.requestKeyboardFocusForVirtualView(arg2);
                break;
            }
            case 2: {
                v0 = this.clearKeyboardFocusForVirtualView(arg2);
                break;
            }
            case 64: {
                v0 = this.requestAccessibilityFocus(arg2);
                break;
            }
            case 128: {
                v0 = this.clearAccessibilityFocus(arg2);
                break;
            }
            default: {
                v0 = this.onPerformActionForVirtualView(arg2, arg3, arg4);
                break;
            }
        }

        return v0;
    }

    private boolean performActionForHost(int arg2, Bundle arg3) {
        return ViewCompat.performAccessibilityAction(this.mHost, arg2, arg3);
    }

    private boolean requestAccessibilityFocus(int arg3) {
        boolean v0 = false;
        if((this.mManager.isEnabled()) && (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) && this.mAccessibilityFocusedVirtualViewId != arg3) {
            if(this.mAccessibilityFocusedVirtualViewId != 0x80000000) {
                this.clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
            }

            this.mAccessibilityFocusedVirtualViewId = arg3;
            this.mHost.invalidate();
            this.sendEventForVirtualView(arg3, 0x8000);
            v0 = true;
        }

        return v0;
    }

    public final boolean requestKeyboardFocusForVirtualView(int arg4) {
        boolean v0 = false;
        if(((this.mHost.isFocused()) || (this.mHost.requestFocus())) && this.mKeyboardFocusedVirtualViewId != arg4) {
            if(this.mKeyboardFocusedVirtualViewId != 0x80000000) {
                this.clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
            }

            this.mKeyboardFocusedVirtualViewId = arg4;
            this.onVirtualViewKeyboardFocusChanged(arg4, true);
            this.sendEventForVirtualView(arg4, 8);
            v0 = true;
        }

        return v0;
    }

    public final boolean sendEventForVirtualView(int arg4, int arg5) {
        boolean v0 = false;
        if(arg4 != 0x80000000 && (this.mManager.isEnabled())) {
            ViewParent v1 = this.mHost.getParent();
            if(v1 != null) {
                v0 = ViewParentCompat.requestSendAccessibilityEvent(v1, this.mHost, this.createEvent(arg4, arg5));
            }
        }

        return v0;
    }

    private void updateHoveredVirtualView(int arg3) {
        if(this.mHoveredVirtualViewId != arg3) {
            int v0 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = arg3;
            this.sendEventForVirtualView(arg3, 0x80);
            this.sendEventForVirtualView(v0, 0x100);
        }
    }
}

