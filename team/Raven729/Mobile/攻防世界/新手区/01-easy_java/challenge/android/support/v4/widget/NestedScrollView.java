package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.h.a.e;
import android.support.v4.h.b;
import android.support.v4.h.i;
import android.support.v4.h.j;
import android.support.v4.h.k;
import android.support.v4.h.m;
import android.support.v4.h.p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView extends FrameLayout implements i, k {
    class a extends b {
        a() {
            super();
        }

        public void a(View arg3, android.support.v4.h.a.a arg4) {
            super.a(arg3, arg4);
            arg4.a(ScrollView.class.getName());
            if(((NestedScrollView)arg3).isEnabled()) {
                int v0 = ((NestedScrollView)arg3).getScrollRange();
                if(v0 > 0) {
                    arg4.a(true);
                    if(((NestedScrollView)arg3).getScrollY() > 0) {
                        arg4.a(0x2000);
                    }

                    if(((NestedScrollView)arg3).getScrollY() >= v0) {
                        return;
                    }

                    arg4.a(0x1000);
                }
            }
        }

        public boolean a(View arg5, int arg6, Bundle arg7) {
            boolean v0 = true;
            if(!super.a(arg5, arg6, arg7)) {
                if(!((NestedScrollView)arg5).isEnabled()) {
                    v0 = false;
                }
                else {
                    switch(arg6) {
                        case 4096: {
                            goto label_12;
                        }
                        case 8192: {
                            goto label_27;
                        }
                    }

                    return false;
                label_27:
                    int v2 = Math.max(((NestedScrollView)arg5).getScrollY() - (((NestedScrollView)arg5).getHeight() - ((NestedScrollView)arg5).getPaddingBottom() - ((NestedScrollView)arg5).getPaddingTop()), 0);
                    if(v2 != ((NestedScrollView)arg5).getScrollY()) {
                        ((NestedScrollView)arg5).c(0, v2);
                    }
                    else {
                        return false;
                    label_12:
                        v2 = Math.min(((NestedScrollView)arg5).getHeight() - ((NestedScrollView)arg5).getPaddingBottom() - ((NestedScrollView)arg5).getPaddingTop() + ((NestedScrollView)arg5).getScrollY(), ((NestedScrollView)arg5).getScrollRange());
                        if(v2 != ((NestedScrollView)arg5).getScrollY()) {
                            ((NestedScrollView)arg5).c(0, v2);
                        }
                        else {
                            v0 = false;
                        }
                    }
                }
            }

            return v0;
        }

        public void d(View arg2, AccessibilityEvent arg3) {
            super.d(arg2, arg3);
            arg3.setClassName(ScrollView.class.getName());
            boolean v0 = ((NestedScrollView)arg2).getScrollRange() > 0 ? true : false;
            arg3.setScrollable(v0);
            arg3.setScrollX(((NestedScrollView)arg2).getScrollX());
            arg3.setScrollY(((NestedScrollView)arg2).getScrollY());
            e.a(((AccessibilityRecord)arg3), ((NestedScrollView)arg2).getScrollX());
            e.b(((AccessibilityRecord)arg3), ((NestedScrollView)arg2).getScrollRange());
        }
    }

    public interface android.support.v4.widget.NestedScrollView$b {
        void a(NestedScrollView arg1, int arg2, int arg3, int arg4, int arg5);
    }

    class c extends View$BaseSavedState {
        final class android.support.v4.widget.NestedScrollView$c$1 implements Parcelable$Creator {
            android.support.v4.widget.NestedScrollView$c$1() {
                super();
            }

            public c a(Parcel arg2) {
                return new c(arg2);
            }

            public c[] a(int arg2) {
                return new c[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        public int a;

        static {
            c.CREATOR = new android.support.v4.widget.NestedScrollView$c$1();
        }

        c(Parcelable arg1) {
            super(arg1);
        }

        c(Parcel arg2) {
            super(arg2);
            this.a = arg2.readInt();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.a);
        }
    }

    private float A;
    private android.support.v4.widget.NestedScrollView$b B;
    private long a;
    private final Rect b;
    private OverScroller c;
    private EdgeEffect d;
    private EdgeEffect e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private int u;
    private c v;
    private static final a w;
    private static final int[] x;
    private final m y;
    private final j z;

    static {
        NestedScrollView.w = new a();
        NestedScrollView.x = new int[]{0x101017A};
    }

    public NestedScrollView(Context arg2) {
        this(arg2, null);
    }

    public NestedScrollView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public NestedScrollView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6, arg7);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        this.a();
        TypedArray v0 = arg5.obtainStyledAttributes(arg6, NestedScrollView.x, arg7, 0);
        this.setFillViewport(v0.getBoolean(0, false));
        v0.recycle();
        this.y = new m(((ViewGroup)this));
        this.z = new j(((View)this));
        this.setNestedScrollingEnabled(true);
        p.a(((View)this), NestedScrollView.w);
    }

    private void a() {
        this.c = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(0x40000);
        this.setWillNotDraw(false);
        ViewConfiguration v0 = ViewConfiguration.get(this.getContext());
        this.n = v0.getScaledTouchSlop();
        this.o = v0.getScaledMinimumFlingVelocity();
        this.p = v0.getScaledMaximumFlingVelocity();
    }

    private View a(boolean arg12, int arg13, int arg14) {
        int v0_1;
        Object v1_1;
        ArrayList v6 = this.getFocusables(2);
        Object v3 = null;
        int v2 = 0;
        int v7 = ((List)v6).size();
        int v5 = 0;
        while(v5 < v7) {
            Object v0 = ((List)v6).get(v5);
            int v4 = ((View)v0).getTop();
            int v8 = ((View)v0).getBottom();
            if(arg13 >= v8 || v4 >= arg14) {
            label_53:
                v0_1 = v2;
                v1_1 = v3;
            }
            else {
                int v1 = arg13 >= v4 || v8 >= arg14 ? 0 : 1;
                if(v3 == null) {
                    int v10 = v1;
                    v1_1 = v0;
                    v0_1 = v10;
                    goto label_20;
                }

                if(!arg12 || v4 >= ((View)v3).getTop()) {
                    if(!arg12 && v8 > ((View)v3).getBottom()) {
                    label_33:
                        v4 = 1;
                        goto label_34;
                    }

                    v4 = 0;
                }
                else {
                    goto label_33;
                }

            label_34:
                if(v2 != 0) {
                    if(v1 == 0) {
                        goto label_53;
                    }

                    if(v4 == 0) {
                        goto label_53;
                    }

                    v1_1 = v0;
                    v0_1 = v2;
                    goto label_20;
                }

                if(v1 != 0) {
                    v1_1 = v0;
                    v0_1 = 1;
                    goto label_20;
                }

                if(v4 == 0) {
                    goto label_53;
                }

                v1_1 = v0;
                v0_1 = v2;
            }

        label_20:
            ++v5;
            v3 = v1_1;
            v2 = v0_1;
        }

        return ((View)v3);
    }

    private void a(MotionEvent arg4) {
        int v0 = arg4.getActionIndex();
        if(arg4.getPointerId(v0) == this.q) {
            v0 = v0 == 0 ? 1 : 0;
            this.f = ((int)arg4.getY(v0));
            this.q = arg4.getPointerId(v0);
            if(this.k == null) {
                return;
            }

            this.k.clear();
        }
    }

    private boolean a(int arg7, int arg8, int arg9) {
        NestedScrollView v3_1;
        boolean v2 = false;
        int v0 = this.getHeight();
        int v4 = this.getScrollY();
        int v5 = v4 + v0;
        boolean v0_1 = arg7 == 33 ? true : false;
        View v3 = this.a(v0_1, arg8, arg9);
        if(v3 == null) {
            v3_1 = this;
        }

        if(arg8 < v4 || arg9 > v5) {
            v0 = v0_1 ? arg8 - v4 : arg9 - v5;
            this.g(v0);
            v2 = true;
        }

        if((((View)v3_1)) != this.findFocus()) {
            ((View)v3_1).requestFocus(arg7);
        }

        return v2;
    }

    private boolean a(Rect arg4, boolean arg5) {
        int v2 = this.a(arg4);
        boolean v0 = v2 != 0 ? true : false;
        if(v0) {
            if(arg5) {
                this.scrollBy(0, v2);
            }
            else {
                this.b(0, v2);
            }
        }

        return v0;
    }

    protected int a(Rect arg8) {
        int v2 = 0;
        if(this.getChildCount() != 0) {
            int v3 = this.getHeight();
            int v0 = this.getScrollY();
            int v1 = v0 + v3;
            int v4 = this.getVerticalFadingEdgeLength();
            if(arg8.top > 0) {
                v0 += v4;
            }

            if(arg8.bottom < this.getChildAt(0).getHeight()) {
                v1 -= v4;
            }

            if(arg8.bottom <= v1 || arg8.top <= v0) {
                if(arg8.top < v0 && arg8.bottom < v1) {
                    v0 = arg8.height() > v3 ? -(v1 - arg8.bottom) : -(v0 - arg8.top);
                    v0 = Math.max(v0, -this.getScrollY());
                    goto label_29;
                }

                v0 = 0;
            }
            else {
                v0 = arg8.height() > v3 ? arg8.top - v0 : arg8.bottom - v1;
                v0 = Math.min(v0, this.getChildAt(0).getBottom() - v1);
            }

        label_29:
            v2 = v0;
        }

        return v2;
    }

    private boolean a(View arg3) {
        boolean v0 = false;
        if(!this.a(arg3, 0, this.getHeight())) {
            v0 = true;
        }

        return v0;
    }

    private boolean a(View arg3, int arg4, int arg5) {
        arg3.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(arg3, this.b);
        boolean v0 = this.b.bottom + arg4 < this.getScrollY() || this.b.top - arg4 > this.getScrollY() + arg5 ? false : true;
        return v0;
    }

    private static boolean a(View arg3, View arg4) {
        boolean v1 = true;
        if(arg3 != arg4) {
            ViewParent v0 = arg3.getParent();
            boolean v0_1 = !(v0 instanceof ViewGroup) || !NestedScrollView.a(((View)v0), arg4) ? false : true;
            v1 = v0_1;
        }

        return v1;
    }

    public void a(int arg2) {
        this.z.c(arg2);
    }

    public boolean a(int arg2, int arg3) {
        return this.z.a(arg2, arg3);
    }

    boolean a(int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, boolean arg19) {
        boolean v8;
        boolean v9;
        this.getOverScrollMode();
        int v7 = arg13 + arg11;
        int v5 = arg14 + arg12;
        int v6 = -0;
        int v2 = arg15;
        int v4 = -0;
        int v3 = arg16;
        if(v7 > v2) {
            v9 = true;
        }
        else if(v7 < v6) {
            v9 = true;
            v2 = v6;
        }
        else {
            v9 = false;
            v2 = v7;
        }

        if(v5 > v3) {
            v8 = true;
        }
        else if(v5 < v4) {
            v8 = true;
            v3 = v4;
        }
        else {
            v8 = false;
            v3 = v5;
        }

        if((v8) && !this.b(1)) {
            this.c.springBack(v2, v3, 0, 0, 0, this.getScrollRange());
        }

        this.onOverScrolled(v2, v3, v9, v8);
        boolean v1 = (v9) || (v8) ? true : false;
        return v1;
    }

    public boolean a(int arg8, int arg9, int arg10, int arg11, int[] arg12, int arg13) {
        return this.z.a(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public boolean a(int arg7, int arg8, int[] arg9, int[] arg10, int arg11) {
        return this.z.a(arg7, arg8, arg9, arg10, arg11);
    }

    public boolean a(KeyEvent arg5) {
        int v0 = 33;
        boolean v1 = false;
        int v2 = 130;
        this.b.setEmpty();
        if(this.b()) {
            if(arg5.getAction() != 0) {
                return v1;
            }

            switch(arg5.getKeyCode()) {
                case 19: {
                    goto label_31;
                }
                case 20: {
                    goto label_37;
                }
                case 62: {
                    goto label_43;
                }
            }

            return v1;
        label_37:
            if(!arg5.isAltPressed()) {
                return this.e(v2);
            }

            return this.d(v2);
        label_43:
            if(!arg5.isShiftPressed()) {
                v0 = v2;
            }

            this.c(v0);
            return v1;
        label_31:
            if(!arg5.isAltPressed()) {
                return this.e(v0);
            }

            v1 = this.d(v0);
        }
        else if((this.isFocused()) && arg5.getKeyCode() != 4) {
            View v0_1 = this.findFocus();
            if((((NestedScrollView)v0_1)) == this) {
                v0_1 = null;
            }

            v0_1 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0_1, v2);
            boolean v0_2 = v0_1 == null || (((NestedScrollView)v0_1)) == this || !v0_1.requestFocus(v2) ? false : true;
            v1 = v0_2;
        }

        return v1;
    }

    public void addView(View arg3) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3);
    }

    public void addView(View arg3, int arg4) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4);
    }

    public void addView(View arg3, int arg4, ViewGroup$LayoutParams arg5) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4, arg5);
    }

    public void addView(View arg3, ViewGroup$LayoutParams arg4) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }

        super.addView(arg3, arg4);
    }

    public final void b(int arg6, int arg7) {
        if(this.getChildCount() != 0) {
            if(AnimationUtils.currentAnimationTimeMillis() - this.a > 0xFA) {
                int v0 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
                int v1 = this.getScrollY();
                this.c.startScroll(this.getScrollX(), v1, 0, Math.max(0, Math.min(v1 + arg7, v0)) - v1);
                p.a(((View)this));
            }
            else {
                if(!this.c.isFinished()) {
                    this.c.abortAnimation();
                }

                this.scrollBy(arg6, arg7);
            }

            this.a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private static int b(int arg1, int arg2, int arg3) {
        if(arg2 >= arg3 || arg1 < 0) {
            arg1 = 0;
        }
        else if(arg2 + arg1 > arg3) {
            arg1 = arg3 - arg2;
        }

        return arg1;
    }

    private void b(View arg3) {
        arg3.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(arg3, this.b);
        int v0 = this.a(this.b);
        if(v0 != 0) {
            this.scrollBy(0, v0);
        }
    }

    private boolean b() {
        boolean v0 = false;
        View v1 = this.getChildAt(0);
        if(v1 != null && this.getHeight() < v1.getHeight() + this.getPaddingTop() + this.getPaddingBottom()) {
            v0 = true;
        }

        return v0;
    }

    public boolean b(int arg2) {
        return this.z.a(arg2);
    }

    private void c() {
        if(this.k == null) {
            this.k = VelocityTracker.obtain();
        }
        else {
            this.k.clear();
        }
    }

    public boolean c(int arg5) {
        int v0 = arg5 == 130 ? 1 : 0;
        int v2 = this.getHeight();
        if(v0 != 0) {
            this.b.top = this.getScrollY() + v2;
            v0 = this.getChildCount();
            if(v0 > 0) {
                View v0_1 = this.getChildAt(v0 - 1);
                if(this.b.top + v2 > v0_1.getBottom()) {
                    this.b.top = v0_1.getBottom() - v2;
                }
            }
        }
        else {
            this.b.top = this.getScrollY() - v2;
            if(this.b.top < 0) {
                this.b.top = 0;
            }
        }

        this.b.bottom = this.b.top + v2;
        return this.a(arg5, this.b.top, this.b.bottom);
    }

    public final void c(int arg3, int arg4) {
        this.b(arg3 - this.getScrollX(), arg4 - this.getScrollY());
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if(this.c.computeScrollOffset()) {
            this.c.getCurrX();
            int v14 = this.c.getCurrY();
            int v2 = v14 - this.u;
            if(this.a(0, v2, this.s, null, 1)) {
                v2 -= this.s[1];
            }

            if(v2 != 0) {
                int v6 = this.getScrollRange();
                int v4 = this.getScrollY();
                this.a(0, v2, this.getScrollX(), v4, 0, v6, 0, 0, false);
                int v9 = this.getScrollY() - v4;
                if(!this.a(0, v9, 0, v2 - v9, null, 1)) {
                    int v0 = this.getOverScrollMode();
                    if(v0 != 0) {
                        if(v0 == 1 && v6 > 0) {
                            goto label_46;
                        }

                        v0 = 0;
                    }
                    else {
                    label_46:
                        v0 = 1;
                    }

                    if(v0 == 0) {
                        goto label_56;
                    }

                    this.g();
                    if(v14 <= 0 && v4 > 0) {
                        this.d.onAbsorb(((int)this.c.getCurrVelocity()));
                        goto label_56;
                    }

                    if(v14 < v6) {
                        goto label_56;
                    }

                    if(v4 >= v6) {
                        goto label_56;
                    }

                    this.e.onAbsorb(((int)this.c.getCurrVelocity()));
                }
            }

        label_56:
            this.u = v14;
            p.a(((View)this));
        }
        else {
            if(this.b(1)) {
                this.a(1);
            }

            this.u = 0;
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int v0 = this.getChildCount();
        int v1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if(v0 == 0) {
            v0 = v1;
        }
        else {
            v0 = this.getChildAt(0).getBottom();
            int v2 = this.getScrollY();
            v1 = Math.max(0, v0 - v1);
            if(v2 < 0) {
                v0 -= v2;
            }
            else if(v2 > v1) {
                v0 += v2 - v1;
            }
        }

        return v0;
    }

    private void d() {
        if(this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private boolean d(int arg5, int arg6) {
        boolean v0 = false;
        if(this.getChildCount() > 0) {
            int v1 = this.getScrollY();
            View v2 = this.getChildAt(0);
            if(arg6 >= v2.getTop() - v1 && arg6 < v2.getBottom() - v1 && arg5 >= v2.getLeft() && arg5 < v2.getRight()) {
                v0 = true;
            }
        }

        return v0;
    }

    public boolean d(int arg5) {
        int v0 = arg5 == 130 ? 1 : 0;
        int v2 = this.getHeight();
        this.b.top = 0;
        this.b.bottom = v2;
        if(v0 != 0) {
            v0 = this.getChildCount();
            if(v0 > 0) {
                this.b.bottom = this.getChildAt(v0 - 1).getBottom() + this.getPaddingBottom();
                this.b.top = this.b.bottom - v2;
            }
        }

        return this.a(arg5, this.b.top, this.b.bottom);
    }

    public boolean dispatchKeyEvent(KeyEvent arg2) {
        boolean v0 = (super.dispatchKeyEvent(arg2)) || (this.a(arg2)) ? true : false;
        return v0;
    }

    public boolean dispatchNestedFling(float arg2, float arg3, boolean arg4) {
        return this.z.a(arg2, arg3, arg4);
    }

    public boolean dispatchNestedPreFling(float arg2, float arg3) {
        return this.z.a(arg2, arg3);
    }

    public boolean dispatchNestedPreScroll(int arg2, int arg3, int[] arg4, int[] arg5) {
        return this.z.a(arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedScroll(int arg7, int arg8, int arg9, int arg10, int[] arg11) {
        return this.z.a(arg7, arg8, arg9, arg10, arg11);
    }

    public void draw(Canvas arg7) {
        int v2;
        int v1;
        super.draw(arg7);
        if(this.d != null) {
            int v0 = this.getScrollY();
            if(!this.d.isFinished()) {
                v1 = arg7.save();
                v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                arg7.translate(((float)this.getPaddingLeft()), ((float)Math.min(0, v0)));
                this.d.setSize(v2, this.getHeight());
                if(this.d.draw(arg7)) {
                    p.a(((View)this));
                }

                arg7.restoreToCount(v1);
            }

            if(this.e.isFinished()) {
                return;
            }

            v1 = arg7.save();
            v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v3 = this.getHeight();
            arg7.translate(((float)(-v2 + this.getPaddingLeft())), ((float)(Math.max(this.getScrollRange(), v0) + v3)));
            arg7.rotate(180f, ((float)v2), 0f);
            this.e.setSize(v2, v3);
            if(this.e.draw(arg7)) {
                p.a(((View)this));
            }

            arg7.restoreToCount(v1);
        }
    }

    private void e() {
        if(this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    public boolean e(int arg8) {
        boolean v0_1;
        int v6 = 130;
        View v0 = this.findFocus();
        if((((NestedScrollView)v0)) == this) {
            v0 = null;
        }

        View v3 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0, arg8);
        int v1 = this.getMaxScrollAmount();
        if(v3 == null || !this.a(v3, v1, this.getHeight())) {
            if(arg8 == 33 && this.getScrollY() < v1) {
                v1 = this.getScrollY();
            }
            else if(arg8 == v6 && this.getChildCount() > 0) {
                int v3_1 = this.getChildAt(0).getBottom();
                int v4 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
                if(v3_1 - v4 < v1) {
                    v1 = v3_1 - v4;
                }
            }

            if(v1 == 0) {
                v0_1 = false;
                return v0_1;
            }

            if(arg8 != v6) {
                v1 = -v1;
            }

            this.g(v1);
        label_20:
            if(v0 != null && (v0.isFocused()) && (this.a(v0))) {
                int v0_2 = this.getDescendantFocusability();
                this.setDescendantFocusability(0x20000);
                this.requestFocus();
                this.setDescendantFocusability(v0_2);
            }

            v0_1 = true;
        }
        else {
            v3.getDrawingRect(this.b);
            this.offsetDescendantRectToMyCoords(v3, this.b);
            this.g(this.a(this.b));
            v3.requestFocus(arg8);
            goto label_20;
        }

        return v0_1;
    }

    private void f() {
        this.j = false;
        this.e();
        this.a(0);
        if(this.d != null) {
            this.d.onRelease();
            this.e.onRelease();
        }
    }

    public void f(int arg12) {
        if(this.getChildCount() > 0) {
            this.a(2, 1);
            this.c.fling(this.getScrollX(), this.getScrollY(), 0, arg12, 0, 0, 0x80000000, 0x7FFFFFFF, 0, 0);
            this.u = this.getScrollY();
            p.a(((View)this));
        }
    }

    private void g(int arg3) {
        if(arg3 != 0) {
            if(this.m) {
                this.b(0, arg3);
            }
            else {
                this.scrollBy(0, arg3);
            }
        }
    }

    private void g() {
        EdgeEffect v2 = null;
        if(this.getOverScrollMode() == 2) {
            this.d = v2;
            this.e = v2;
        }
        else if(this.d == null) {
            Context v0 = this.getContext();
            this.d = new EdgeEffect(v0);
            this.e = new EdgeEffect(v0);
        }
    }

    protected float getBottomFadingEdgeStrength() {
        float v0;
        if(this.getChildCount() == 0) {
            v0 = 0f;
        }
        else {
            int v0_1 = this.getVerticalFadingEdgeLength();
            int v1 = this.getChildAt(0).getBottom() - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
            v0 = v1 < v0_1 ? (((float)v1)) / (((float)v0_1)) : 1f;
        }

        return v0;
    }

    public int getMaxScrollAmount() {
        return ((int)(0.5f * (((float)this.getHeight()))));
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    int getScrollRange() {
        int v0 = 0;
        if(this.getChildCount() > 0) {
            v0 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
        }

        return v0;
    }

    protected float getTopFadingEdgeStrength() {
        float v0;
        if(this.getChildCount() == 0) {
            v0 = 0f;
        }
        else {
            int v0_1 = this.getVerticalFadingEdgeLength();
            int v1 = this.getScrollY();
            v0 = v1 < v0_1 ? (((float)v1)) / (((float)v0_1)) : 1f;
        }

        return v0;
    }

    private float getVerticalScrollFactorCompat() {
        if(this.A == 0f) {
            TypedValue v0 = new TypedValue();
            Context v1 = this.getContext();
            if(!v1.getTheme().resolveAttribute(0x101004D, v0, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            else {
                this.A = v0.getDimension(v1.getResources().getDisplayMetrics());
            }
        }

        return this.A;
    }

    private void h(int arg4) {
        boolean v0_1;
        int v0 = this.getScrollY();
        if(v0 > 0 || arg4 > 0) {
            if(v0 >= this.getScrollRange() && arg4 >= 0) {
            label_15:
                v0_1 = false;
                goto label_8;
            }

            v0_1 = true;
        }
        else {
            goto label_15;
        }

    label_8:
        if(!this.dispatchNestedPreFling(0f, ((float)arg4))) {
            this.dispatchNestedFling(0f, ((float)arg4), v0_1);
            this.f(arg4);
        }
    }

    public boolean hasNestedScrollingParent() {
        return this.z.b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.z.a();
    }

    protected void measureChild(View arg5, int arg6, int arg7) {
        arg5.measure(NestedScrollView.getChildMeasureSpec(arg6, this.getPaddingLeft() + this.getPaddingRight(), arg5.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View arg4, int arg5, int arg6, int arg7, int arg8) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        arg4.measure(NestedScrollView.getChildMeasureSpec(arg5, this.getPaddingLeft() + this.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg6, ((ViewGroup$MarginLayoutParams)v0).width), View$MeasureSpec.makeMeasureSpec(((ViewGroup$MarginLayoutParams)v0).bottomMargin + ((ViewGroup$MarginLayoutParams)v0).topMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent arg5) {
        boolean v0 = false;
        if((arg5.getSource() & 2) != 0) {
            switch(arg5.getAction()) {
                case 8: {
                    if(!this.j) {
                        float v1 = arg5.getAxisValue(9);
                        if(v1 != 0f) {
                            int v2 = ((int)(v1 * this.getVerticalScrollFactorCompat()));
                            int v1_1 = this.getScrollRange();
                            int v3 = this.getScrollY();
                            v2 = v3 - v2;
                            if(v2 < 0) {
                                v1_1 = 0;
                            }
                            else if(v2 <= v1_1) {
                                v1_1 = v2;
                            }

                            if(v1_1 == v3) {
                                return v0;
                            }

                            super.scrollTo(this.getScrollX(), v1_1);
                            v0 = true;
                        }
                    }

                    return v0;
                }
            }
        }

        return v0;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg8) {
        int v5 = 2;
        int v4 = -1;
        boolean v0 = true;
        int v1 = arg8.getAction();
        if(v1 != v5 || !this.j) {
            switch(v1 & 0xFF) {
                case 0: {
                    v1 = ((int)arg8.getY());
                    if(!this.d(((int)arg8.getX()), v1)) {
                        this.j = false;
                        this.e();
                        goto label_11;
                    }

                    this.f = v1;
                    this.q = arg8.getPointerId(0);
                    this.c();
                    this.k.addMovement(arg8);
                    this.c.computeScrollOffset();
                    if(this.c.isFinished()) {
                        v0 = false;
                    }

                    this.j = v0;
                    this.a(v5, 0);
                    break;
                }
                case 2: {
                    v1 = this.q;
                    if(v1 == v4) {
                        goto label_11;
                    }

                    int v2 = arg8.findPointerIndex(v1);
                    if(v2 == v4) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + v1 + " in onInterceptTouchEvent");
                        goto label_11;
                    }

                    v1 = ((int)arg8.getY(v2));
                    if(Math.abs(v1 - this.f) <= this.n) {
                        goto label_11;
                    }

                    if((this.getNestedScrollAxes() & 2) != 0) {
                        goto label_11;
                    }

                    this.j = true;
                    this.f = v1;
                    this.d();
                    this.k.addMovement(arg8);
                    this.t = 0;
                    ViewParent v1_1 = this.getParent();
                    if(v1_1 == null) {
                        goto label_11;
                    }

                    v1_1.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                case 1: 
                case 3: {
                    this.j = false;
                    this.q = v4;
                    this.e();
                    if(this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        p.a(((View)this));
                    }

                    this.a(0);
                    break;
                }
                case 6: {
                    this.a(arg8);
                    break;
                }
            }

        label_11:
            v0 = this.j;
        }

        return v0;
    }

    protected void onLayout(boolean arg5, int arg6, int arg7, int arg8, int arg9) {
        View v3 = null;
        super.onLayout(arg5, arg6, arg7, arg8, arg9);
        this.g = false;
        if(this.i != null && (NestedScrollView.a(this.i, ((View)this)))) {
            this.b(this.i);
        }

        this.i = v3;
        if(!this.h) {
            if(this.v != null) {
                this.scrollTo(this.getScrollX(), this.v.a);
                this.v = ((c)v3);
            }

            int v0 = this.getChildCount() > 0 ? this.getChildAt(0).getMeasuredHeight() : 0;
            v0 = Math.max(0, v0 - (arg9 - arg7 - this.getPaddingBottom() - this.getPaddingTop()));
            if(this.getScrollY() > v0) {
                this.scrollTo(this.getScrollX(), v0);
                goto label_36;
            }

            if(this.getScrollY() >= 0) {
                goto label_36;
            }

            this.scrollTo(this.getScrollX(), 0);
        }

    label_36:
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.h = true;
    }

    protected void onMeasure(int arg6, int arg7) {
        super.onMeasure(arg6, arg7);
        if((this.l) && View$MeasureSpec.getMode(arg7) != 0 && this.getChildCount() > 0) {
            View v1 = this.getChildAt(0);
            int v2 = this.getMeasuredHeight();
            if(v1.getMeasuredHeight() < v2) {
                v1.measure(NestedScrollView.getChildMeasureSpec(arg6, this.getPaddingLeft() + this.getPaddingRight(), v1.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(v2 - this.getPaddingTop() - this.getPaddingBottom(), 0x40000000));
            }
        }
    }

    public boolean onNestedFling(View arg2, float arg3, float arg4, boolean arg5) {
        boolean v0;
        if(!arg5) {
            this.h(((int)arg4));
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public boolean onNestedPreFling(View arg2, float arg3, float arg4) {
        return this.dispatchNestedPreFling(arg3, arg4);
    }

    public void onNestedPreScroll(View arg2, int arg3, int arg4, int[] arg5) {
        this.dispatchNestedPreScroll(arg3, arg4, arg5, null);
    }

    public void onNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11) {
        int v0 = this.getScrollY();
        this.scrollBy(0, arg11);
        int v2 = this.getScrollY() - v0;
        this.dispatchNestedScroll(0, v2, 0, arg11 - v2, null);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.y.a(arg2, arg3, arg4);
        this.startNestedScroll(2);
    }

    protected void onOverScrolled(int arg1, int arg2, boolean arg3, boolean arg4) {
        super.scrollTo(arg1, arg2);
    }

    protected boolean onRequestFocusInDescendants(int arg4, Rect arg5) {
        boolean v0 = false;
        if(arg4 == 2) {
            arg4 = 130;
        }
        else if(arg4 == 1) {
            arg4 = 33;
        }

        View v1 = arg5 == null ? FocusFinder.getInstance().findNextFocus(((ViewGroup)this), null, arg4) : FocusFinder.getInstance().findNextFocusFromRect(((ViewGroup)this), arg5, arg4);
        if(v1 != null && !this.a(v1)) {
            v0 = v1.requestFocus(arg4, arg5);
        }

        return v0;
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof c)) {
            super.onRestoreInstanceState(arg2);
        }
        else {
            super.onRestoreInstanceState(((c)arg2).getSuperState());
            this.v = ((c)arg2);
            this.requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        c v1 = new c(super.onSaveInstanceState());
        v1.a = this.getScrollY();
        return ((Parcelable)v1);
    }

    protected void onScrollChanged(int arg7, int arg8, int arg9, int arg10) {
        super.onScrollChanged(arg7, arg8, arg9, arg10);
        if(this.B != null) {
            this.B.a(this, arg7, arg8, arg9, arg10);
        }
    }

    protected void onSizeChanged(int arg3, int arg4, int arg5, int arg6) {
        super.onSizeChanged(arg3, arg4, arg5, arg6);
        View v0 = this.findFocus();
        if(v0 != null && this != (((NestedScrollView)v0)) && (this.a(v0, 0, arg6))) {
            v0.getDrawingRect(this.b);
            this.offsetDescendantRectToMyCoords(v0, this.b);
            this.g(this.a(this.b));
        }
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        boolean v0 = (arg4 & 2) != 0 ? true : false;
        return v0;
    }

    public void onStopNestedScroll(View arg2) {
        this.y.a(arg2);
        this.stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent arg21) {
        int v16;
        ViewParent v2_2;
        boolean v2_1;
        this.d();
        MotionEvent v17 = MotionEvent.obtain(arg21);
        int v2 = arg21.getActionMasked();
        if(v2 == 0) {
            this.t = 0;
        }

        v17.offsetLocation(0f, ((float)this.t));
        switch(v2) {
            case 0: {
                if(this.getChildCount() == 0) {
                    v2_1 = false;
                    return v2_1;
                }

                v2_1 = !this.c.isFinished() ? true : false;
                this.j = v2_1;
                if(v2_1) {
                    v2_2 = this.getParent();
                    if(v2_2 != null) {
                        v2_2.requestDisallowInterceptTouchEvent(true);
                    }
                }

                if(!this.c.isFinished()) {
                    this.c.abortAnimation();
                }

                this.f = ((int)arg21.getY());
                this.q = arg21.getPointerId(0);
                this.a(2, 0);
                break;
            }
            case 1: {
                VelocityTracker v2_3 = this.k;
                v2_3.computeCurrentVelocity(1000, ((float)this.p));
                v2 = ((int)v2_3.getYVelocity(this.q));
                if(Math.abs(v2) > this.o) {
                    this.h(-v2);
                }
                else if(this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    p.a(((View)this));
                }

                this.q = -1;
                this.f();
                break;
            }
            case 2: {
                int v18 = arg21.findPointerIndex(this.q);
                if(v18 == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                    goto label_14;
                }

                int v8 = ((int)arg21.getY(v18));
                int v4 = this.f - v8;
                if(this.a(0, v4, this.s, this.r, 0)) {
                    v4 -= this.s[1];
                    v17.offsetLocation(0f, ((float)this.r[1]));
                    this.t += this.r[1];
                }

                if(!this.j && Math.abs(v4) > this.n) {
                    v2_2 = this.getParent();
                    if(v2_2 != null) {
                        v2_2.requestDisallowInterceptTouchEvent(true);
                    }

                    this.j = true;
                    if(v4 > 0) {
                        v4 -= this.n;
                        goto label_139;
                    }

                    v4 += this.n;
                }

            label_139:
                if(!this.j) {
                    goto label_14;
                }

                this.f = v8 - this.r[1];
                int v19 = this.getScrollY();
                v8 = this.getScrollRange();
                v2 = this.getOverScrollMode();
                if(v2 != 0) {
                    if(v2 == 1 && v8 > 0) {
                        goto label_156;
                    }

                    v16 = 0;
                }
                else {
                label_156:
                    v16 = 1;
                }

                if((this.a(0, v4, 0, this.getScrollY(), 0, v8, 0, 0, true)) && !this.b(0)) {
                    this.k.clear();
                }

                int v11 = this.getScrollY() - v19;
                if(this.a(0, v11, 0, v4 - v11, this.r, 0)) {
                    this.f -= this.r[1];
                    v17.offsetLocation(0f, ((float)this.r[1]));
                    this.t += this.r[1];
                    goto label_14;
                }

                if(v16 == 0) {
                    goto label_14;
                }

                this.g();
                v2 = v19 + v4;
                if(v2 < 0) {
                    android.support.v4.widget.e.a(this.d, (((float)v4)) / (((float)this.getHeight())), arg21.getX(v18) / (((float)this.getWidth())));
                    if(!this.e.isFinished()) {
                        this.e.onRelease();
                    }
                }
                else if(v2 > v8) {
                    android.support.v4.widget.e.a(this.e, (((float)v4)) / (((float)this.getHeight())), 1f - arg21.getX(v18) / (((float)this.getWidth())));
                    if(!this.d.isFinished()) {
                        this.d.onRelease();
                    }
                }

                if(this.d == null) {
                    goto label_14;
                }

                if((this.d.isFinished()) && (this.e.isFinished())) {
                    goto label_14;
                }

                p.a(((View)this));
                break;
            }
            case 3: {
                if((this.j) && this.getChildCount() > 0 && (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange()))) {
                    p.a(((View)this));
                }

                this.q = -1;
                this.f();
                break;
            }
            case 5: {
                v2 = arg21.getActionIndex();
                this.f = ((int)arg21.getY(v2));
                this.q = arg21.getPointerId(v2);
                break;
            }
            case 6: {
                this.a(arg21);
                this.f = ((int)arg21.getY(arg21.findPointerIndex(this.q)));
                break;
            }
        }

    label_14:
        if(this.k != null) {
            this.k.addMovement(v17);
        }

        v17.recycle();
        return true;
    }

    public void requestChildFocus(View arg2, View arg3) {
        if(!this.g) {
            this.b(arg3);
        }
        else {
            this.i = arg3;
        }

        super.requestChildFocus(arg2, arg3);
    }

    public boolean requestChildRectangleOnScreen(View arg4, Rect arg5, boolean arg6) {
        arg5.offset(arg4.getLeft() - arg4.getScrollX(), arg4.getTop() - arg4.getScrollY());
        return this.a(arg5, arg6);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg1) {
        if(arg1) {
            this.e();
        }

        super.requestDisallowInterceptTouchEvent(arg1);
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    public void scrollTo(int arg5, int arg6) {
        if(this.getChildCount() > 0) {
            View v0 = this.getChildAt(0);
            int v1 = NestedScrollView.b(arg5, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), v0.getWidth());
            int v0_1 = NestedScrollView.b(arg6, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), v0.getHeight());
            if(v1 == this.getScrollX() && v0_1 == this.getScrollY()) {
                return;
            }

            super.scrollTo(v1, v0_1);
        }
    }

    public void setFillViewport(boolean arg2) {
        if(arg2 != this.l) {
            this.l = arg2;
            this.requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean arg2) {
        this.z.a(arg2);
    }

    public void setOnScrollChangeListener(android.support.v4.widget.NestedScrollView$b arg1) {
        this.B = arg1;
    }

    public void setSmoothScrollingEnabled(boolean arg1) {
        this.m = arg1;
    }

    public boolean shouldDelayChildPressedState() {
        return 1;
    }

    public boolean startNestedScroll(int arg2) {
        return this.z.b(arg2);
    }

    public void stopNestedScroll() {
        this.z.c();
    }
}

