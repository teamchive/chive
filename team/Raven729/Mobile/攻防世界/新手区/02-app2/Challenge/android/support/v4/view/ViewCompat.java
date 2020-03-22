package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class ViewCompat {
    class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
        Api24ViewCompatImpl() {
            super();
        }

        public void setPointerIcon(View arg2, PointerIconCompat arg3) {
            Object v0 = arg3 != null ? arg3.getPointerIcon() : null;
            ViewCompatApi24.setPointerIcon(arg2, v0);
        }
    }

    class BaseViewCompatImpl implements ViewCompatImpl {
        private Method mDispatchFinishTemporaryDetach;
        private Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        WeakHashMap mViewPropertyAnimatorCompatMap;
        private static Method sChildrenDrawingOrderMethod;

        BaseViewCompatImpl() {
            super();
            this.mViewPropertyAnimatorCompatMap = null;
        }

        public ViewPropertyAnimatorCompat animate(View arg2) {
            return new ViewPropertyAnimatorCompat(arg2);
        }

        private void bindTempDetach() {
            try {
                this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach");
                this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach");
            }
            catch(NoSuchMethodException v0) {
                Log.e("ViewCompat", "Couldn\'t find method", ((Throwable)v0));
            }

            this.mTempDetachBound = true;
        }

        public boolean canScrollHorizontally(View arg2, int arg3) {
            boolean v0 = !(arg2 instanceof ScrollingView) || !this.canScrollingViewScrollHorizontally(((ScrollingView)arg2), arg3) ? false : true;
            return v0;
        }

        public boolean canScrollVertically(View arg2, int arg3) {
            boolean v0 = !(arg2 instanceof ScrollingView) || !this.canScrollingViewScrollVertically(((ScrollingView)arg2), arg3) ? false : true;
            return v0;
        }

        private boolean canScrollingViewScrollHorizontally(ScrollingView arg6, int arg7) {
            boolean v0 = true;
            int v2 = arg6.computeHorizontalScrollOffset();
            int v3 = arg6.computeHorizontalScrollRange() - arg6.computeHorizontalScrollExtent();
            if(v3 == 0) {
                v0 = false;
            }
            else if(arg7 < 0) {
                if(v2 <= 0) {
                    v0 = false;
                }
            }
            else if(v2 >= v3 - 1) {
                v0 = false;
            }

            return v0;
        }

        private boolean canScrollingViewScrollVertically(ScrollingView arg6, int arg7) {
            boolean v0 = true;
            int v2 = arg6.computeVerticalScrollOffset();
            int v3 = arg6.computeVerticalScrollRange() - arg6.computeVerticalScrollExtent();
            if(v3 == 0) {
                v0 = false;
            }
            else if(arg7 < 0) {
                if(v2 <= 0) {
                    v0 = false;
                }
            }
            else if(v2 >= v3 - 1) {
                v0 = false;
            }

            return v0;
        }

        public int combineMeasuredStates(int arg2, int arg3) {
            return arg2 | arg3;
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
            return arg2;
        }

        public void dispatchFinishTemporaryDetach(View arg4) {
            if(!this.mTempDetachBound) {
                this.bindTempDetach();
            }

            if(this.mDispatchFinishTemporaryDetach != null) {
                try {
                    this.mDispatchFinishTemporaryDetach.invoke(arg4);
                }
                catch(Exception v0) {
                    Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", ((Throwable)v0));
                }
            }
            else {
                arg4.onFinishTemporaryDetach();
            }
        }

        public boolean dispatchNestedFling(View arg2, float arg3, float arg4, boolean arg5) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).dispatchNestedFling(arg3, arg4, arg5) : false;
            return v0;
        }

        public boolean dispatchNestedPreFling(View arg2, float arg3, float arg4) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).dispatchNestedPreFling(arg3, arg4) : false;
            return v0;
        }

        public boolean dispatchNestedPreScroll(View arg2, int arg3, int arg4, int[] arg5, int[] arg6) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).dispatchNestedPreScroll(arg3, arg4, arg5, arg6) : false;
            return v0;
        }

        public boolean dispatchNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11, int[] arg12) {
            boolean v0 = (arg7 instanceof NestedScrollingChild) ? arg7.dispatchNestedScroll(arg8, arg9, arg10, arg11, arg12) : false;
            return v0;
        }

        public void dispatchStartTemporaryDetach(View arg4) {
            if(!this.mTempDetachBound) {
                this.bindTempDetach();
            }

            if(this.mDispatchStartTemporaryDetach != null) {
                try {
                    this.mDispatchStartTemporaryDetach.invoke(arg4);
                }
                catch(Exception v0) {
                    Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", ((Throwable)v0));
                }
            }
            else {
                arg4.onStartTemporaryDetach();
            }
        }

        public int getAccessibilityLiveRegion(View arg2) {
            return 0;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg2) {
            return null;
        }

        public float getAlpha(View arg2) {
            return 1f;
        }

        public ColorStateList getBackgroundTintList(View arg2) {
            return ViewCompatBase.getBackgroundTintList(arg2);
        }

        public PorterDuff$Mode getBackgroundTintMode(View arg2) {
            return ViewCompatBase.getBackgroundTintMode(arg2);
        }

        public Rect getClipBounds(View arg2) {
            return null;
        }

        public Display getDisplay(View arg2) {
            return ViewCompatBase.getDisplay(arg2);
        }

        public float getElevation(View arg2) {
            return 0;
        }

        public boolean getFitsSystemWindows(View arg2) {
            return 0;
        }

        long getFrameTime() {
            return 10;
        }

        public int getImportantForAccessibility(View arg2) {
            return 0;
        }

        public int getLabelFor(View arg2) {
            return 0;
        }

        public int getLayerType(View arg2) {
            return 0;
        }

        public int getLayoutDirection(View arg2) {
            return 0;
        }

        public Matrix getMatrix(View arg2) {
            return null;
        }

        public int getMeasuredHeightAndState(View arg2) {
            return arg2.getMeasuredHeight();
        }

        public int getMeasuredState(View arg2) {
            return 0;
        }

        public int getMeasuredWidthAndState(View arg2) {
            return arg2.getMeasuredWidth();
        }

        public int getMinimumHeight(View arg2) {
            return ViewCompatBase.getMinimumHeight(arg2);
        }

        public int getMinimumWidth(View arg2) {
            return ViewCompatBase.getMinimumWidth(arg2);
        }

        public int getPaddingEnd(View arg2) {
            return arg2.getPaddingRight();
        }

        public int getPaddingStart(View arg2) {
            return arg2.getPaddingLeft();
        }

        public ViewParent getParentForAccessibility(View arg2) {
            return arg2.getParent();
        }

        public float getPivotX(View arg2) {
            return 0;
        }

        public float getPivotY(View arg2) {
            return 0;
        }

        public float getRotation(View arg2) {
            return 0;
        }

        public float getRotationX(View arg2) {
            return 0;
        }

        public float getRotationY(View arg2) {
            return 0;
        }

        public float getScaleX(View arg2) {
            return 0;
        }

        public float getScaleY(View arg2) {
            return 0;
        }

        public int getScrollIndicators(View arg2) {
            return 0;
        }

        public String getTransitionName(View arg2) {
            return null;
        }

        public float getTranslationX(View arg2) {
            return 0;
        }

        public float getTranslationY(View arg2) {
            return 0;
        }

        public float getTranslationZ(View arg2) {
            return 0;
        }

        public int getWindowSystemUiVisibility(View arg2) {
            return 0;
        }

        public float getX(View arg2) {
            return ((float)arg2.getLeft());
        }

        public float getY(View arg2) {
            return ((float)arg2.getTop());
        }

        public float getZ(View arg3) {
            return this.getTranslationZ(arg3) + this.getElevation(arg3);
        }

        public boolean hasAccessibilityDelegate(View arg2) {
            return 0;
        }

        public boolean hasNestedScrollingParent(View arg2) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).hasNestedScrollingParent() : false;
            return v0;
        }

        public boolean hasOnClickListeners(View arg2) {
            return 0;
        }

        public boolean hasOverlappingRendering(View arg2) {
            return 1;
        }

        public boolean hasTransientState(View arg2) {
            return 0;
        }

        public boolean isAttachedToWindow(View arg2) {
            return ViewCompatBase.isAttachedToWindow(arg2);
        }

        public boolean isImportantForAccessibility(View arg2) {
            return 1;
        }

        public boolean isInLayout(View arg2) {
            return 0;
        }

        public boolean isLaidOut(View arg2) {
            return ViewCompatBase.isLaidOut(arg2);
        }

        public boolean isLayoutDirectionResolved(View arg2) {
            return 0;
        }

        public boolean isNestedScrollingEnabled(View arg2) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).isNestedScrollingEnabled() : false;
            return v0;
        }

        public boolean isPaddingRelative(View arg2) {
            return 0;
        }

        public void jumpDrawablesToCurrentState(View arg1) {
        }

        public void offsetLeftAndRight(View arg1, int arg2) {
            ViewCompatBase.offsetLeftAndRight(arg1, arg2);
        }

        public void offsetTopAndBottom(View arg1, int arg2) {
            ViewCompatBase.offsetTopAndBottom(arg1, arg2);
        }

        public WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
            return arg2;
        }

        public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        }

        public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        }

        public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        }

        public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
            return 0;
        }

        public void postInvalidateOnAnimation(View arg1) {
            arg1.invalidate();
        }

        public void postInvalidateOnAnimation(View arg1, int arg2, int arg3, int arg4, int arg5) {
            arg1.invalidate(arg2, arg3, arg4, arg5);
        }

        public void postOnAnimation(View arg3, Runnable arg4) {
            arg3.postDelayed(arg4, this.getFrameTime());
        }

        public void postOnAnimationDelayed(View arg4, Runnable arg5, long arg6) {
            arg4.postDelayed(arg5, this.getFrameTime() + arg6);
        }

        public void requestApplyInsets(View arg1) {
        }

        public int resolveSizeAndState(int arg2, int arg3, int arg4) {
            return View.resolveSize(arg2, arg3);
        }

        public void setAccessibilityDelegate(View arg1, AccessibilityDelegateCompat arg2) {
        }

        public void setAccessibilityLiveRegion(View arg1, int arg2) {
        }

        public void setActivated(View arg1, boolean arg2) {
        }

        public void setAlpha(View arg1, float arg2) {
        }

        public void setBackground(View arg1, Drawable arg2) {
            arg1.setBackgroundDrawable(arg2);
        }

        public void setBackgroundTintList(View arg1, ColorStateList arg2) {
            ViewCompatBase.setBackgroundTintList(arg1, arg2);
        }

        public void setBackgroundTintMode(View arg1, PorterDuff$Mode arg2) {
            ViewCompatBase.setBackgroundTintMode(arg1, arg2);
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup arg7, boolean arg8) {
            if(BaseViewCompatImpl.sChildrenDrawingOrderMethod != null) {
                goto label_14;
            }

            try {
                BaseViewCompatImpl.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException v0) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", ((Throwable)v0));
            }

            BaseViewCompatImpl.sChildrenDrawingOrderMethod.setAccessible(true);
            try {
            label_14:
                BaseViewCompatImpl.sChildrenDrawingOrderMethod.invoke(arg7, Boolean.valueOf(arg8));
            }
            catch(InvocationTargetException v0_1) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", ((Throwable)v0_1));
            }
            catch(IllegalArgumentException v0_2) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", ((Throwable)v0_2));
            }
            catch(IllegalAccessException v0_3) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", ((Throwable)v0_3));
            }
        }

        public void setClipBounds(View arg1, Rect arg2) {
        }

        public void setElevation(View arg1, float arg2) {
        }

        public void setFitsSystemWindows(View arg1, boolean arg2) {
        }

        public void setHasTransientState(View arg1, boolean arg2) {
        }

        public void setImportantForAccessibility(View arg1, int arg2) {
        }

        public void setLabelFor(View arg1, int arg2) {
        }

        public void setLayerPaint(View arg1, Paint arg2) {
        }

        public void setLayerType(View arg1, int arg2, Paint arg3) {
        }

        public void setLayoutDirection(View arg1, int arg2) {
        }

        public void setNestedScrollingEnabled(View arg2, boolean arg3) {
            if((arg2 instanceof NestedScrollingChild)) {
                ((NestedScrollingChild)arg2).setNestedScrollingEnabled(arg3);
            }
        }

        public void setOnApplyWindowInsetsListener(View arg1, OnApplyWindowInsetsListener arg2) {
        }

        public void setPaddingRelative(View arg1, int arg2, int arg3, int arg4, int arg5) {
            arg1.setPadding(arg2, arg3, arg4, arg5);
        }

        public void setPivotX(View arg1, float arg2) {
        }

        public void setPivotY(View arg1, float arg2) {
        }

        public void setPointerIcon(View arg1, PointerIconCompat arg2) {
        }

        public void setRotation(View arg1, float arg2) {
        }

        public void setRotationX(View arg1, float arg2) {
        }

        public void setRotationY(View arg1, float arg2) {
        }

        public void setSaveFromParentEnabled(View arg1, boolean arg2) {
        }

        public void setScaleX(View arg1, float arg2) {
        }

        public void setScaleY(View arg1, float arg2) {
        }

        public void setScrollIndicators(View arg1, int arg2) {
        }

        public void setScrollIndicators(View arg1, int arg2, int arg3) {
        }

        public void setTransitionName(View arg1, String arg2) {
        }

        public void setTranslationX(View arg1, float arg2) {
        }

        public void setTranslationY(View arg1, float arg2) {
        }

        public void setTranslationZ(View arg1, float arg2) {
        }

        public void setX(View arg1, float arg2) {
        }

        public void setY(View arg1, float arg2) {
        }

        public void setZ(View arg1, float arg2) {
        }

        public boolean startNestedScroll(View arg2, int arg3) {
            boolean v0 = (arg2 instanceof NestedScrollingChild) ? ((NestedScrollingChild)arg2).startNestedScroll(arg3) : false;
            return v0;
        }

        public void stopNestedScroll(View arg2) {
            if((arg2 instanceof NestedScrollingChild)) {
                ((NestedScrollingChild)arg2).stopNestedScroll();
            }
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface FocusDirection {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface FocusRealDirection {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface FocusRelativeDirection {
    }

    class HCViewCompatImpl extends BaseViewCompatImpl {
        HCViewCompatImpl() {
            super();
        }

        public int combineMeasuredStates(int arg2, int arg3) {
            return ViewCompatHC.combineMeasuredStates(arg2, arg3);
        }

        public float getAlpha(View arg2) {
            return ViewCompatHC.getAlpha(arg2);
        }

        long getFrameTime() {
            return ViewCompatHC.getFrameTime();
        }

        public int getLayerType(View arg2) {
            return ViewCompatHC.getLayerType(arg2);
        }

        public Matrix getMatrix(View arg2) {
            return ViewCompatHC.getMatrix(arg2);
        }

        public int getMeasuredHeightAndState(View arg2) {
            return ViewCompatHC.getMeasuredHeightAndState(arg2);
        }

        public int getMeasuredState(View arg2) {
            return ViewCompatHC.getMeasuredState(arg2);
        }

        public int getMeasuredWidthAndState(View arg2) {
            return ViewCompatHC.getMeasuredWidthAndState(arg2);
        }

        public float getPivotX(View arg2) {
            return ViewCompatHC.getPivotX(arg2);
        }

        public float getPivotY(View arg2) {
            return ViewCompatHC.getPivotY(arg2);
        }

        public float getRotation(View arg2) {
            return ViewCompatHC.getRotation(arg2);
        }

        public float getRotationX(View arg2) {
            return ViewCompatHC.getRotationX(arg2);
        }

        public float getRotationY(View arg2) {
            return ViewCompatHC.getRotationY(arg2);
        }

        public float getScaleX(View arg2) {
            return ViewCompatHC.getScaleX(arg2);
        }

        public float getScaleY(View arg2) {
            return ViewCompatHC.getScaleY(arg2);
        }

        public float getTranslationX(View arg2) {
            return ViewCompatHC.getTranslationX(arg2);
        }

        public float getTranslationY(View arg2) {
            return ViewCompatHC.getTranslationY(arg2);
        }

        public float getX(View arg2) {
            return ViewCompatHC.getX(arg2);
        }

        public float getY(View arg2) {
            return ViewCompatHC.getY(arg2);
        }

        public void jumpDrawablesToCurrentState(View arg1) {
            ViewCompatHC.jumpDrawablesToCurrentState(arg1);
        }

        public void offsetLeftAndRight(View arg1, int arg2) {
            ViewCompatHC.offsetLeftAndRight(arg1, arg2);
        }

        public void offsetTopAndBottom(View arg1, int arg2) {
            ViewCompatHC.offsetTopAndBottom(arg1, arg2);
        }

        public int resolveSizeAndState(int arg2, int arg3, int arg4) {
            return ViewCompatHC.resolveSizeAndState(arg2, arg3, arg4);
        }

        public void setActivated(View arg1, boolean arg2) {
            ViewCompatHC.setActivated(arg1, arg2);
        }

        public void setAlpha(View arg1, float arg2) {
            ViewCompatHC.setAlpha(arg1, arg2);
        }

        public void setLayerPaint(View arg2, Paint arg3) {
            this.setLayerType(arg2, this.getLayerType(arg2), arg3);
            arg2.invalidate();
        }

        public void setLayerType(View arg1, int arg2, Paint arg3) {
            ViewCompatHC.setLayerType(arg1, arg2, arg3);
        }

        public void setPivotX(View arg1, float arg2) {
            ViewCompatHC.setPivotX(arg1, arg2);
        }

        public void setPivotY(View arg1, float arg2) {
            ViewCompatHC.setPivotY(arg1, arg2);
        }

        public void setRotation(View arg1, float arg2) {
            ViewCompatHC.setRotation(arg1, arg2);
        }

        public void setRotationX(View arg1, float arg2) {
            ViewCompatHC.setRotationX(arg1, arg2);
        }

        public void setRotationY(View arg1, float arg2) {
            ViewCompatHC.setRotationY(arg1, arg2);
        }

        public void setSaveFromParentEnabled(View arg1, boolean arg2) {
            ViewCompatHC.setSaveFromParentEnabled(arg1, arg2);
        }

        public void setScaleX(View arg1, float arg2) {
            ViewCompatHC.setScaleX(arg1, arg2);
        }

        public void setScaleY(View arg1, float arg2) {
            ViewCompatHC.setScaleY(arg1, arg2);
        }

        public void setTranslationX(View arg1, float arg2) {
            ViewCompatHC.setTranslationX(arg1, arg2);
        }

        public void setTranslationY(View arg1, float arg2) {
            ViewCompatHC.setTranslationY(arg1, arg2);
        }

        public void setX(View arg1, float arg2) {
            ViewCompatHC.setX(arg1, arg2);
        }

        public void setY(View arg1, float arg2) {
            ViewCompatHC.setY(arg1, arg2);
        }
    }

    class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
            super();
        }

        public boolean hasOnClickListeners(View arg2) {
            return ViewCompatICSMr1.hasOnClickListeners(arg2);
        }
    }

    class ICSViewCompatImpl extends HCViewCompatImpl {
        static boolean accessibilityDelegateCheckFailed;
        static Field mAccessibilityDelegateField;

        static {
            ICSViewCompatImpl.accessibilityDelegateCheckFailed = false;
        }

        ICSViewCompatImpl() {
            super();
        }

        public ViewPropertyAnimatorCompat animate(View arg3) {
            ViewPropertyAnimatorCompat v0_1;
            if(this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
            }

            Object v0 = this.mViewPropertyAnimatorCompatMap.get(arg3);
            if(v0 == null) {
                v0_1 = new ViewPropertyAnimatorCompat(arg3);
                this.mViewPropertyAnimatorCompatMap.put(arg3, v0_1);
            }

            return v0_1;
        }

        public boolean canScrollHorizontally(View arg2, int arg3) {
            return ViewCompatICS.canScrollHorizontally(arg2, arg3);
        }

        public boolean canScrollVertically(View arg2, int arg3) {
            return ViewCompatICS.canScrollVertically(arg2, arg3);
        }

        public boolean hasAccessibilityDelegate(View arg5) {
            boolean v0 = true;
            boolean v1 = false;
            if(!ICSViewCompatImpl.accessibilityDelegateCheckFailed) {
                if(ICSViewCompatImpl.mAccessibilityDelegateField == null) {
                    try {
                        ICSViewCompatImpl.mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
                        ICSViewCompatImpl.mAccessibilityDelegateField.setAccessible(true);
                    }
                    catch(Throwable v2) {
                        ICSViewCompatImpl.accessibilityDelegateCheckFailed = true;
                        return v1;
                    }
                }

                try {
                    if(ICSViewCompatImpl.mAccessibilityDelegateField.get(arg5) == null) {
                        goto label_22;
                    }

                    goto label_17;
                }
                catch(Throwable v2) {
                    ICSViewCompatImpl.accessibilityDelegateCheckFailed = true;
                    return v1;
                }

            label_22:
                v0 = false;
            label_17:
                v1 = v0;
            }

            return v1;
        }

        public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            ViewCompatICS.onInitializeAccessibilityEvent(arg1, arg2);
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(arg2, arg3.getInfo());
        }

        public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            ViewCompatICS.onPopulateAccessibilityEvent(arg1, arg2);
        }

        public void setAccessibilityDelegate(View arg2, @Nullable AccessibilityDelegateCompat arg3) {
            Object v0 = arg3 == null ? null : arg3.getBridge();
            ViewCompatICS.setAccessibilityDelegate(arg2, v0);
        }

        public void setFitsSystemWindows(View arg1, boolean arg2) {
            ViewCompatICS.setFitsSystemWindows(arg1, arg2);
        }
    }

    class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
            super();
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg3) {
            Object v1 = ViewCompatJB.getAccessibilityNodeProvider(arg3);
            AccessibilityNodeProviderCompat v0 = v1 != null ? new AccessibilityNodeProviderCompat(v1) : null;
            return v0;
        }

        public boolean getFitsSystemWindows(View arg2) {
            return ViewCompatJB.getFitsSystemWindows(arg2);
        }

        public int getImportantForAccessibility(View arg2) {
            return ViewCompatJB.getImportantForAccessibility(arg2);
        }

        public int getMinimumHeight(View arg2) {
            return ViewCompatJB.getMinimumHeight(arg2);
        }

        public int getMinimumWidth(View arg2) {
            return ViewCompatJB.getMinimumWidth(arg2);
        }

        public ViewParent getParentForAccessibility(View arg2) {
            return ViewCompatJB.getParentForAccessibility(arg2);
        }

        public boolean hasOverlappingRendering(View arg2) {
            return ViewCompatJB.hasOverlappingRendering(arg2);
        }

        public boolean hasTransientState(View arg2) {
            return ViewCompatJB.hasTransientState(arg2);
        }

        public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
            return ViewCompatJB.performAccessibilityAction(arg2, arg3, arg4);
        }

        public void postInvalidateOnAnimation(View arg1) {
            ViewCompatJB.postInvalidateOnAnimation(arg1);
        }

        public void postInvalidateOnAnimation(View arg1, int arg2, int arg3, int arg4, int arg5) {
            ViewCompatJB.postInvalidateOnAnimation(arg1, arg2, arg3, arg4, arg5);
        }

        public void postOnAnimation(View arg1, Runnable arg2) {
            ViewCompatJB.postOnAnimation(arg1, arg2);
        }

        public void postOnAnimationDelayed(View arg2, Runnable arg3, long arg4) {
            ViewCompatJB.postOnAnimationDelayed(arg2, arg3, arg4);
        }

        public void requestApplyInsets(View arg1) {
            ViewCompatJB.requestApplyInsets(arg1);
        }

        public void setBackground(View arg1, Drawable arg2) {
            ViewCompatJB.setBackground(arg1, arg2);
        }

        public void setHasTransientState(View arg1, boolean arg2) {
            ViewCompatJB.setHasTransientState(arg1, arg2);
        }

        public void setImportantForAccessibility(View arg2, int arg3) {
            if(arg3 == 4) {
                arg3 = 2;
            }

            ViewCompatJB.setImportantForAccessibility(arg2, arg3);
        }
    }

    class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
            super();
        }

        public Display getDisplay(View arg2) {
            return ViewCompatJellybeanMr1.getDisplay(arg2);
        }

        public int getLabelFor(View arg2) {
            return ViewCompatJellybeanMr1.getLabelFor(arg2);
        }

        public int getLayoutDirection(View arg2) {
            return ViewCompatJellybeanMr1.getLayoutDirection(arg2);
        }

        public int getPaddingEnd(View arg2) {
            return ViewCompatJellybeanMr1.getPaddingEnd(arg2);
        }

        public int getPaddingStart(View arg2) {
            return ViewCompatJellybeanMr1.getPaddingStart(arg2);
        }

        public int getWindowSystemUiVisibility(View arg2) {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(arg2);
        }

        public boolean isPaddingRelative(View arg2) {
            return ViewCompatJellybeanMr1.isPaddingRelative(arg2);
        }

        public void setLabelFor(View arg1, int arg2) {
            ViewCompatJellybeanMr1.setLabelFor(arg1, arg2);
        }

        public void setLayerPaint(View arg1, Paint arg2) {
            ViewCompatJellybeanMr1.setLayerPaint(arg1, arg2);
        }

        public void setLayoutDirection(View arg1, int arg2) {
            ViewCompatJellybeanMr1.setLayoutDirection(arg1, arg2);
        }

        public void setPaddingRelative(View arg1, int arg2, int arg3, int arg4, int arg5) {
            ViewCompatJellybeanMr1.setPaddingRelative(arg1, arg2, arg3, arg4, arg5);
        }
    }

    class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
            super();
        }

        public Rect getClipBounds(View arg2) {
            return ViewCompatJellybeanMr2.getClipBounds(arg2);
        }

        public boolean isInLayout(View arg2) {
            return ViewCompatJellybeanMr2.isInLayout(arg2);
        }

        public void setClipBounds(View arg1, Rect arg2) {
            ViewCompatJellybeanMr2.setClipBounds(arg1, arg2);
        }
    }

    class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
            super();
        }

        public int getAccessibilityLiveRegion(View arg2) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(arg2);
        }

        public boolean isAttachedToWindow(View arg2) {
            return ViewCompatKitKat.isAttachedToWindow(arg2);
        }

        public boolean isLaidOut(View arg2) {
            return ViewCompatKitKat.isLaidOut(arg2);
        }

        public boolean isLayoutDirectionResolved(View arg2) {
            return ViewCompatKitKat.isLayoutDirectionResolved(arg2);
        }

        public void setAccessibilityLiveRegion(View arg1, int arg2) {
            ViewCompatKitKat.setAccessibilityLiveRegion(arg1, arg2);
        }

        public void setImportantForAccessibility(View arg1, int arg2) {
            ViewCompatJB.setImportantForAccessibility(arg1, arg2);
        }
    }

    class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
            super();
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View arg2, WindowInsetsCompat arg3) {
            return WindowInsetsCompat.wrap(ViewCompatLollipop.dispatchApplyWindowInsets(arg2, WindowInsetsCompat.unwrap(arg3)));
        }

        public boolean dispatchNestedFling(View arg2, float arg3, float arg4, boolean arg5) {
            return ViewCompatLollipop.dispatchNestedFling(arg2, arg3, arg4, arg5);
        }

        public boolean dispatchNestedPreFling(View arg2, float arg3, float arg4) {
            return ViewCompatLollipop.dispatchNestedPreFling(arg2, arg3, arg4);
        }

        public boolean dispatchNestedPreScroll(View arg2, int arg3, int arg4, int[] arg5, int[] arg6) {
            return ViewCompatLollipop.dispatchNestedPreScroll(arg2, arg3, arg4, arg5, arg6);
        }

        public boolean dispatchNestedScroll(View arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
            return ViewCompatLollipop.dispatchNestedScroll(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public ColorStateList getBackgroundTintList(View arg2) {
            return ViewCompatLollipop.getBackgroundTintList(arg2);
        }

        public PorterDuff$Mode getBackgroundTintMode(View arg2) {
            return ViewCompatLollipop.getBackgroundTintMode(arg2);
        }

        public float getElevation(View arg2) {
            return ViewCompatLollipop.getElevation(arg2);
        }

        public String getTransitionName(View arg2) {
            return ViewCompatLollipop.getTransitionName(arg2);
        }

        public float getTranslationZ(View arg2) {
            return ViewCompatLollipop.getTranslationZ(arg2);
        }

        public float getZ(View arg2) {
            return ViewCompatLollipop.getZ(arg2);
        }

        public boolean hasNestedScrollingParent(View arg2) {
            return ViewCompatLollipop.hasNestedScrollingParent(arg2);
        }

        public boolean isImportantForAccessibility(View arg2) {
            return ViewCompatLollipop.isImportantForAccessibility(arg2);
        }

        public boolean isNestedScrollingEnabled(View arg2) {
            return ViewCompatLollipop.isNestedScrollingEnabled(arg2);
        }

        public void offsetLeftAndRight(View arg1, int arg2) {
            ViewCompatLollipop.offsetLeftAndRight(arg1, arg2);
        }

        public void offsetTopAndBottom(View arg1, int arg2) {
            ViewCompatLollipop.offsetTopAndBottom(arg1, arg2);
        }

        public WindowInsetsCompat onApplyWindowInsets(View arg2, WindowInsetsCompat arg3) {
            return WindowInsetsCompat.wrap(ViewCompatLollipop.onApplyWindowInsets(arg2, WindowInsetsCompat.unwrap(arg3)));
        }

        public void requestApplyInsets(View arg1) {
            ViewCompatLollipop.requestApplyInsets(arg1);
        }

        public void setBackgroundTintList(View arg1, ColorStateList arg2) {
            ViewCompatLollipop.setBackgroundTintList(arg1, arg2);
        }

        public void setBackgroundTintMode(View arg1, PorterDuff$Mode arg2) {
            ViewCompatLollipop.setBackgroundTintMode(arg1, arg2);
        }

        public void setElevation(View arg1, float arg2) {
            ViewCompatLollipop.setElevation(arg1, arg2);
        }

        public void setNestedScrollingEnabled(View arg1, boolean arg2) {
            ViewCompatLollipop.setNestedScrollingEnabled(arg1, arg2);
        }

        public void setOnApplyWindowInsetsListener(View arg2, OnApplyWindowInsetsListener arg3) {
            if(arg3 == null) {
                ViewCompatLollipop.setOnApplyWindowInsetsListener(arg2, null);
            }
            else {
                ViewCompatLollipop.setOnApplyWindowInsetsListener(arg2, new OnApplyWindowInsetsListenerBridge(arg3) {
                    public Object onApplyWindowInsets(View arg3, Object arg4) {
                        return WindowInsetsCompat.unwrap(this.val$listener.onApplyWindowInsets(arg3, WindowInsetsCompat.wrap(arg4)));
                    }
                });
            }
        }

        public void setTransitionName(View arg1, String arg2) {
            ViewCompatLollipop.setTransitionName(arg1, arg2);
        }

        public void setTranslationZ(View arg1, float arg2) {
            ViewCompatLollipop.setTranslationZ(arg1, arg2);
        }

        public void setZ(View arg1, float arg2) {
            ViewCompatLollipop.setZ(arg1, arg2);
        }

        public boolean startNestedScroll(View arg2, int arg3) {
            return ViewCompatLollipop.startNestedScroll(arg2, arg3);
        }

        public void stopNestedScroll(View arg1) {
            ViewCompatLollipop.stopNestedScroll(arg1);
        }
    }

    class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        MarshmallowViewCompatImpl() {
            super();
        }

        public int getScrollIndicators(View arg2) {
            return ViewCompatMarshmallow.getScrollIndicators(arg2);
        }

        public void offsetLeftAndRight(View arg1, int arg2) {
            ViewCompatMarshmallow.offsetLeftAndRight(arg1, arg2);
        }

        public void offsetTopAndBottom(View arg1, int arg2) {
            ViewCompatMarshmallow.offsetTopAndBottom(arg1, arg2);
        }

        public void setScrollIndicators(View arg1, int arg2) {
            ViewCompatMarshmallow.setScrollIndicators(arg1, arg2);
        }

        public void setScrollIndicators(View arg1, int arg2, int arg3) {
            ViewCompatMarshmallow.setScrollIndicators(arg1, arg2, arg3);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollIndicators {
    }

    interface ViewCompatImpl {
        ViewPropertyAnimatorCompat animate(View arg1);

        boolean canScrollHorizontally(View arg1, int arg2);

        boolean canScrollVertically(View arg1, int arg2);

        int combineMeasuredStates(int arg1, int arg2);

        WindowInsetsCompat dispatchApplyWindowInsets(View arg1, WindowInsetsCompat arg2);

        void dispatchFinishTemporaryDetach(View arg1);

        boolean dispatchNestedFling(View arg1, float arg2, float arg3, boolean arg4);

        boolean dispatchNestedPreFling(View arg1, float arg2, float arg3);

        boolean dispatchNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4, int[] arg5);

        boolean dispatchNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6);

        void dispatchStartTemporaryDetach(View arg1);

        int getAccessibilityLiveRegion(View arg1);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1);

        float getAlpha(View arg1);

        ColorStateList getBackgroundTintList(View arg1);

        PorterDuff$Mode getBackgroundTintMode(View arg1);

        Rect getClipBounds(View arg1);

        Display getDisplay(View arg1);

        float getElevation(View arg1);

        boolean getFitsSystemWindows(View arg1);

        int getImportantForAccessibility(View arg1);

        int getLabelFor(View arg1);

        int getLayerType(View arg1);

        int getLayoutDirection(View arg1);

        @Nullable Matrix getMatrix(View arg1);

        int getMeasuredHeightAndState(View arg1);

        int getMeasuredState(View arg1);

        int getMeasuredWidthAndState(View arg1);

        int getMinimumHeight(View arg1);

        int getMinimumWidth(View arg1);

        int getPaddingEnd(View arg1);

        int getPaddingStart(View arg1);

        ViewParent getParentForAccessibility(View arg1);

        float getPivotX(View arg1);

        float getPivotY(View arg1);

        float getRotation(View arg1);

        float getRotationX(View arg1);

        float getRotationY(View arg1);

        float getScaleX(View arg1);

        float getScaleY(View arg1);

        int getScrollIndicators(View arg1);

        String getTransitionName(View arg1);

        float getTranslationX(View arg1);

        float getTranslationY(View arg1);

        float getTranslationZ(View arg1);

        int getWindowSystemUiVisibility(View arg1);

        float getX(View arg1);

        float getY(View arg1);

        float getZ(View arg1);

        boolean hasAccessibilityDelegate(View arg1);

        boolean hasNestedScrollingParent(View arg1);

        boolean hasOnClickListeners(View arg1);

        boolean hasOverlappingRendering(View arg1);

        boolean hasTransientState(View arg1);

        boolean isAttachedToWindow(View arg1);

        boolean isImportantForAccessibility(View arg1);

        boolean isInLayout(View arg1);

        boolean isLaidOut(View arg1);

        boolean isLayoutDirectionResolved(View arg1);

        boolean isNestedScrollingEnabled(View arg1);

        boolean isPaddingRelative(View arg1);

        void jumpDrawablesToCurrentState(View arg1);

        void offsetLeftAndRight(View arg1, int arg2);

        void offsetTopAndBottom(View arg1, int arg2);

        WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2);

        void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2);

        void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2);

        boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3);

        void postInvalidateOnAnimation(View arg1);

        void postInvalidateOnAnimation(View arg1, int arg2, int arg3, int arg4, int arg5);

        void postOnAnimation(View arg1, Runnable arg2);

        void postOnAnimationDelayed(View arg1, Runnable arg2, long arg3);

        void requestApplyInsets(View arg1);

        int resolveSizeAndState(int arg1, int arg2, int arg3);

        void setAccessibilityDelegate(View arg1, @Nullable AccessibilityDelegateCompat arg2);

        void setAccessibilityLiveRegion(View arg1, int arg2);

        void setActivated(View arg1, boolean arg2);

        void setAlpha(View arg1, float arg2);

        void setBackground(View arg1, Drawable arg2);

        void setBackgroundTintList(View arg1, ColorStateList arg2);

        void setBackgroundTintMode(View arg1, PorterDuff$Mode arg2);

        void setChildrenDrawingOrderEnabled(ViewGroup arg1, boolean arg2);

        void setClipBounds(View arg1, Rect arg2);

        void setElevation(View arg1, float arg2);

        void setFitsSystemWindows(View arg1, boolean arg2);

        void setHasTransientState(View arg1, boolean arg2);

        void setImportantForAccessibility(View arg1, int arg2);

        void setLabelFor(View arg1, int arg2);

        void setLayerPaint(View arg1, Paint arg2);

        void setLayerType(View arg1, int arg2, Paint arg3);

        void setLayoutDirection(View arg1, int arg2);

        void setNestedScrollingEnabled(View arg1, boolean arg2);

        void setOnApplyWindowInsetsListener(View arg1, OnApplyWindowInsetsListener arg2);

        void setPaddingRelative(View arg1, int arg2, int arg3, int arg4, int arg5);

        void setPivotX(View arg1, float arg2);

        void setPivotY(View arg1, float arg2);

        void setPointerIcon(View arg1, PointerIconCompat arg2);

        void setRotation(View arg1, float arg2);

        void setRotationX(View arg1, float arg2);

        void setRotationY(View arg1, float arg2);

        void setSaveFromParentEnabled(View arg1, boolean arg2);

        void setScaleX(View arg1, float arg2);

        void setScaleY(View arg1, float arg2);

        void setScrollIndicators(View arg1, int arg2);

        void setScrollIndicators(View arg1, int arg2, int arg3);

        void setTransitionName(View arg1, String arg2);

        void setTranslationX(View arg1, float arg2);

        void setTranslationY(View arg1, float arg2);

        void setTranslationZ(View arg1, float arg2);

        void setX(View arg1, float arg2);

        void setY(View arg1, float arg2);

        void setZ(View arg1, float arg2);

        boolean startNestedScroll(View arg1, int arg2);

        void stopNestedScroll(View arg1);
    }

    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10;
    static final ViewCompatImpl IMPL = null;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    public static final int MEASURED_STATE_MASK = 0xFF000000;
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    @Deprecated public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 0x20;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(BuildCompat.isAtLeastN()) {
            ViewCompat.IMPL = new Api24ViewCompatImpl();
        }
        else if(v0 >= 23) {
            ViewCompat.IMPL = new MarshmallowViewCompatImpl();
        }
        else if(v0 >= 21) {
            ViewCompat.IMPL = new LollipopViewCompatImpl();
        }
        else if(v0 >= 19) {
            ViewCompat.IMPL = new KitKatViewCompatImpl();
        }
        else if(v0 >= 18) {
            ViewCompat.IMPL = new JbMr2ViewCompatImpl();
        }
        else if(v0 >= 17) {
            ViewCompat.IMPL = new JbMr1ViewCompatImpl();
        }
        else if(v0 >= 16) {
            ViewCompat.IMPL = new JBViewCompatImpl();
        }
        else if(v0 >= 15) {
            ViewCompat.IMPL = new ICSMr1ViewCompatImpl();
        }
        else if(v0 >= 14) {
            ViewCompat.IMPL = new ICSViewCompatImpl();
        }
        else if(v0 >= 11) {
            ViewCompat.IMPL = new HCViewCompatImpl();
        }
        else {
            ViewCompat.IMPL = new BaseViewCompatImpl();
        }
    }

    protected ViewCompat() {
        super();
    }

    public static ViewPropertyAnimatorCompat animate(View arg1) {
        return ViewCompat.IMPL.animate(arg1);
    }

    public static boolean canScrollHorizontally(View arg1, int arg2) {
        return ViewCompat.IMPL.canScrollHorizontally(arg1, arg2);
    }

    public static boolean canScrollVertically(View arg1, int arg2) {
        return ViewCompat.IMPL.canScrollVertically(arg1, arg2);
    }

    public static int combineMeasuredStates(int arg1, int arg2) {
        return ViewCompat.IMPL.combineMeasuredStates(arg1, arg2);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
        return ViewCompat.IMPL.dispatchApplyWindowInsets(arg1, arg2);
    }

    public static void dispatchFinishTemporaryDetach(View arg1) {
        ViewCompat.IMPL.dispatchFinishTemporaryDetach(arg1);
    }

    public static boolean dispatchNestedFling(View arg1, float arg2, float arg3, boolean arg4) {
        return ViewCompat.IMPL.dispatchNestedFling(arg1, arg2, arg3, arg4);
    }

    public static boolean dispatchNestedPreFling(View arg1, float arg2, float arg3) {
        return ViewCompat.IMPL.dispatchNestedPreFling(arg1, arg2, arg3);
    }

    public static boolean dispatchNestedPreScroll(View arg6, int arg7, int arg8, int[] arg9, int[] arg10) {
        return ViewCompat.IMPL.dispatchNestedPreScroll(arg6, arg7, arg8, arg9, arg10);
    }

    public static boolean dispatchNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11, int[] arg12) {
        return ViewCompat.IMPL.dispatchNestedScroll(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public static void dispatchStartTemporaryDetach(View arg1) {
        ViewCompat.IMPL.dispatchStartTemporaryDetach(arg1);
    }

    public static int getAccessibilityLiveRegion(View arg1) {
        return ViewCompat.IMPL.getAccessibilityLiveRegion(arg1);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1) {
        return ViewCompat.IMPL.getAccessibilityNodeProvider(arg1);
    }

    public static float getAlpha(View arg1) {
        return ViewCompat.IMPL.getAlpha(arg1);
    }

    public static ColorStateList getBackgroundTintList(View arg1) {
        return ViewCompat.IMPL.getBackgroundTintList(arg1);
    }

    public static PorterDuff$Mode getBackgroundTintMode(View arg1) {
        return ViewCompat.IMPL.getBackgroundTintMode(arg1);
    }

    public static Rect getClipBounds(View arg1) {
        return ViewCompat.IMPL.getClipBounds(arg1);
    }

    public static Display getDisplay(@NonNull View arg1) {
        return ViewCompat.IMPL.getDisplay(arg1);
    }

    public static float getElevation(View arg1) {
        return ViewCompat.IMPL.getElevation(arg1);
    }

    public static boolean getFitsSystemWindows(View arg1) {
        return ViewCompat.IMPL.getFitsSystemWindows(arg1);
    }

    public static int getImportantForAccessibility(View arg1) {
        return ViewCompat.IMPL.getImportantForAccessibility(arg1);
    }

    public static int getLabelFor(View arg1) {
        return ViewCompat.IMPL.getLabelFor(arg1);
    }

    public static int getLayerType(View arg1) {
        return ViewCompat.IMPL.getLayerType(arg1);
    }

    public static int getLayoutDirection(View arg1) {
        return ViewCompat.IMPL.getLayoutDirection(arg1);
    }

    @Nullable public static Matrix getMatrix(View arg1) {
        return ViewCompat.IMPL.getMatrix(arg1);
    }

    public static int getMeasuredHeightAndState(View arg1) {
        return ViewCompat.IMPL.getMeasuredHeightAndState(arg1);
    }

    public static int getMeasuredState(View arg1) {
        return ViewCompat.IMPL.getMeasuredState(arg1);
    }

    public static int getMeasuredWidthAndState(View arg1) {
        return ViewCompat.IMPL.getMeasuredWidthAndState(arg1);
    }

    public static int getMinimumHeight(View arg1) {
        return ViewCompat.IMPL.getMinimumHeight(arg1);
    }

    public static int getMinimumWidth(View arg1) {
        return ViewCompat.IMPL.getMinimumWidth(arg1);
    }

    @Deprecated public static int getOverScrollMode(View arg1) {
        return arg1.getOverScrollMode();
    }

    public static int getPaddingEnd(View arg1) {
        return ViewCompat.IMPL.getPaddingEnd(arg1);
    }

    public static int getPaddingStart(View arg1) {
        return ViewCompat.IMPL.getPaddingStart(arg1);
    }

    public static ViewParent getParentForAccessibility(View arg1) {
        return ViewCompat.IMPL.getParentForAccessibility(arg1);
    }

    public static float getPivotX(View arg1) {
        return ViewCompat.IMPL.getPivotX(arg1);
    }

    public static float getPivotY(View arg1) {
        return ViewCompat.IMPL.getPivotY(arg1);
    }

    public static float getRotation(View arg1) {
        return ViewCompat.IMPL.getRotation(arg1);
    }

    public static float getRotationX(View arg1) {
        return ViewCompat.IMPL.getRotationX(arg1);
    }

    public static float getRotationY(View arg1) {
        return ViewCompat.IMPL.getRotationY(arg1);
    }

    public static float getScaleX(View arg1) {
        return ViewCompat.IMPL.getScaleX(arg1);
    }

    public static float getScaleY(View arg1) {
        return ViewCompat.IMPL.getScaleY(arg1);
    }

    public static int getScrollIndicators(@NonNull View arg1) {
        return ViewCompat.IMPL.getScrollIndicators(arg1);
    }

    public static String getTransitionName(View arg1) {
        return ViewCompat.IMPL.getTransitionName(arg1);
    }

    public static float getTranslationX(View arg1) {
        return ViewCompat.IMPL.getTranslationX(arg1);
    }

    public static float getTranslationY(View arg1) {
        return ViewCompat.IMPL.getTranslationY(arg1);
    }

    public static float getTranslationZ(View arg1) {
        return ViewCompat.IMPL.getTranslationZ(arg1);
    }

    public static int getWindowSystemUiVisibility(View arg1) {
        return ViewCompat.IMPL.getWindowSystemUiVisibility(arg1);
    }

    public static float getX(View arg1) {
        return ViewCompat.IMPL.getX(arg1);
    }

    public static float getY(View arg1) {
        return ViewCompat.IMPL.getY(arg1);
    }

    public static float getZ(View arg1) {
        return ViewCompat.IMPL.getZ(arg1);
    }

    public static boolean hasAccessibilityDelegate(View arg1) {
        return ViewCompat.IMPL.hasAccessibilityDelegate(arg1);
    }

    public static boolean hasNestedScrollingParent(View arg1) {
        return ViewCompat.IMPL.hasNestedScrollingParent(arg1);
    }

    public static boolean hasOnClickListeners(View arg1) {
        return ViewCompat.IMPL.hasOnClickListeners(arg1);
    }

    public static boolean hasOverlappingRendering(View arg1) {
        return ViewCompat.IMPL.hasOverlappingRendering(arg1);
    }

    public static boolean hasTransientState(View arg1) {
        return ViewCompat.IMPL.hasTransientState(arg1);
    }

    public static boolean isAttachedToWindow(View arg1) {
        return ViewCompat.IMPL.isAttachedToWindow(arg1);
    }

    public static boolean isImportantForAccessibility(View arg1) {
        return ViewCompat.IMPL.isImportantForAccessibility(arg1);
    }

    public static boolean isInLayout(View arg1) {
        return ViewCompat.IMPL.isInLayout(arg1);
    }

    public static boolean isLaidOut(View arg1) {
        return ViewCompat.IMPL.isLaidOut(arg1);
    }

    public static boolean isLayoutDirectionResolved(View arg1) {
        return ViewCompat.IMPL.isLayoutDirectionResolved(arg1);
    }

    public static boolean isNestedScrollingEnabled(View arg1) {
        return ViewCompat.IMPL.isNestedScrollingEnabled(arg1);
    }

    @Deprecated public static boolean isOpaque(View arg1) {
        return arg1.isOpaque();
    }

    public static boolean isPaddingRelative(View arg1) {
        return ViewCompat.IMPL.isPaddingRelative(arg1);
    }

    public static void jumpDrawablesToCurrentState(View arg1) {
        ViewCompat.IMPL.jumpDrawablesToCurrentState(arg1);
    }

    public static void offsetLeftAndRight(View arg1, int arg2) {
        ViewCompat.IMPL.offsetLeftAndRight(arg1, arg2);
    }

    public static void offsetTopAndBottom(View arg1, int arg2) {
        ViewCompat.IMPL.offsetTopAndBottom(arg1, arg2);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
        return ViewCompat.IMPL.onApplyWindowInsets(arg1, arg2);
    }

    public static void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        ViewCompat.IMPL.onInitializeAccessibilityEvent(arg1, arg2);
    }

    public static void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        ViewCompat.IMPL.onInitializeAccessibilityNodeInfo(arg1, arg2);
    }

    public static void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        ViewCompat.IMPL.onPopulateAccessibilityEvent(arg1, arg2);
    }

    public static boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3) {
        return ViewCompat.IMPL.performAccessibilityAction(arg1, arg2, arg3);
    }

    public static void postInvalidateOnAnimation(View arg1) {
        ViewCompat.IMPL.postInvalidateOnAnimation(arg1);
    }

    public static void postInvalidateOnAnimation(View arg6, int arg7, int arg8, int arg9, int arg10) {
        ViewCompat.IMPL.postInvalidateOnAnimation(arg6, arg7, arg8, arg9, arg10);
    }

    public static void postOnAnimation(View arg1, Runnable arg2) {
        ViewCompat.IMPL.postOnAnimation(arg1, arg2);
    }

    public static void postOnAnimationDelayed(View arg2, Runnable arg3, long arg4) {
        ViewCompat.IMPL.postOnAnimationDelayed(arg2, arg3, arg4);
    }

    public static void requestApplyInsets(View arg1) {
        ViewCompat.IMPL.requestApplyInsets(arg1);
    }

    public static int resolveSizeAndState(int arg1, int arg2, int arg3) {
        return ViewCompat.IMPL.resolveSizeAndState(arg1, arg2, arg3);
    }

    public static void setAccessibilityDelegate(View arg1, AccessibilityDelegateCompat arg2) {
        ViewCompat.IMPL.setAccessibilityDelegate(arg1, arg2);
    }

    public static void setAccessibilityLiveRegion(View arg1, int arg2) {
        ViewCompat.IMPL.setAccessibilityLiveRegion(arg1, arg2);
    }

    public static void setActivated(View arg1, boolean arg2) {
        ViewCompat.IMPL.setActivated(arg1, arg2);
    }

    public static void setAlpha(View arg1, @FloatRange(from=0, to=1) float arg2) {
        ViewCompat.IMPL.setAlpha(arg1, arg2);
    }

    public static void setBackground(View arg1, Drawable arg2) {
        ViewCompat.IMPL.setBackground(arg1, arg2);
    }

    public static void setBackgroundTintList(View arg1, ColorStateList arg2) {
        ViewCompat.IMPL.setBackgroundTintList(arg1, arg2);
    }

    public static void setBackgroundTintMode(View arg1, PorterDuff$Mode arg2) {
        ViewCompat.IMPL.setBackgroundTintMode(arg1, arg2);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup arg1, boolean arg2) {
        ViewCompat.IMPL.setChildrenDrawingOrderEnabled(arg1, arg2);
    }

    public static void setClipBounds(View arg1, Rect arg2) {
        ViewCompat.IMPL.setClipBounds(arg1, arg2);
    }

    public static void setElevation(View arg1, float arg2) {
        ViewCompat.IMPL.setElevation(arg1, arg2);
    }

    public static void setFitsSystemWindows(View arg1, boolean arg2) {
        ViewCompat.IMPL.setFitsSystemWindows(arg1, arg2);
    }

    public static void setHasTransientState(View arg1, boolean arg2) {
        ViewCompat.IMPL.setHasTransientState(arg1, arg2);
    }

    public static void setImportantForAccessibility(View arg1, int arg2) {
        ViewCompat.IMPL.setImportantForAccessibility(arg1, arg2);
    }

    public static void setLabelFor(View arg1, @IdRes int arg2) {
        ViewCompat.IMPL.setLabelFor(arg1, arg2);
    }

    public static void setLayerPaint(View arg1, Paint arg2) {
        ViewCompat.IMPL.setLayerPaint(arg1, arg2);
    }

    public static void setLayerType(View arg1, int arg2, Paint arg3) {
        ViewCompat.IMPL.setLayerType(arg1, arg2, arg3);
    }

    public static void setLayoutDirection(View arg1, int arg2) {
        ViewCompat.IMPL.setLayoutDirection(arg1, arg2);
    }

    public static void setNestedScrollingEnabled(View arg1, boolean arg2) {
        ViewCompat.IMPL.setNestedScrollingEnabled(arg1, arg2);
    }

    public static void setOnApplyWindowInsetsListener(View arg1, OnApplyWindowInsetsListener arg2) {
        ViewCompat.IMPL.setOnApplyWindowInsetsListener(arg1, arg2);
    }

    @Deprecated public static void setOverScrollMode(View arg0, int arg1) {
        arg0.setOverScrollMode(arg1);
    }

    public static void setPaddingRelative(View arg6, int arg7, int arg8, int arg9, int arg10) {
        ViewCompat.IMPL.setPaddingRelative(arg6, arg7, arg8, arg9, arg10);
    }

    public static void setPivotX(View arg1, float arg2) {
        ViewCompat.IMPL.setPivotX(arg1, arg2);
    }

    public static void setPivotY(View arg1, float arg2) {
        ViewCompat.IMPL.setPivotY(arg1, arg2);
    }

    public static void setPointerIcon(@NonNull View arg1, PointerIconCompat arg2) {
        ViewCompat.IMPL.setPointerIcon(arg1, arg2);
    }

    public static void setRotation(View arg1, float arg2) {
        ViewCompat.IMPL.setRotation(arg1, arg2);
    }

    public static void setRotationX(View arg1, float arg2) {
        ViewCompat.IMPL.setRotationX(arg1, arg2);
    }

    public static void setRotationY(View arg1, float arg2) {
        ViewCompat.IMPL.setRotationY(arg1, arg2);
    }

    public static void setSaveFromParentEnabled(View arg1, boolean arg2) {
        ViewCompat.IMPL.setSaveFromParentEnabled(arg1, arg2);
    }

    public static void setScaleX(View arg1, float arg2) {
        ViewCompat.IMPL.setScaleX(arg1, arg2);
    }

    public static void setScaleY(View arg1, float arg2) {
        ViewCompat.IMPL.setScaleY(arg1, arg2);
    }

    public static void setScrollIndicators(@NonNull View arg1, int arg2) {
        ViewCompat.IMPL.setScrollIndicators(arg1, arg2);
    }

    public static void setScrollIndicators(@NonNull View arg1, int arg2, int arg3) {
        ViewCompat.IMPL.setScrollIndicators(arg1, arg2, arg3);
    }

    public static void setTransitionName(View arg1, String arg2) {
        ViewCompat.IMPL.setTransitionName(arg1, arg2);
    }

    public static void setTranslationX(View arg1, float arg2) {
        ViewCompat.IMPL.setTranslationX(arg1, arg2);
    }

    public static void setTranslationY(View arg1, float arg2) {
        ViewCompat.IMPL.setTranslationY(arg1, arg2);
    }

    public static void setTranslationZ(View arg1, float arg2) {
        ViewCompat.IMPL.setTranslationZ(arg1, arg2);
    }

    public static void setX(View arg1, float arg2) {
        ViewCompat.IMPL.setX(arg1, arg2);
    }

    public static void setY(View arg1, float arg2) {
        ViewCompat.IMPL.setY(arg1, arg2);
    }

    public static void setZ(View arg1, float arg2) {
        ViewCompat.IMPL.setZ(arg1, arg2);
    }

    public static boolean startNestedScroll(View arg1, int arg2) {
        return ViewCompat.IMPL.startNestedScroll(arg1, arg2);
    }

    public static void stopNestedScroll(View arg1) {
        ViewCompat.IMPL.stopNestedScroll(arg1);
    }
}

