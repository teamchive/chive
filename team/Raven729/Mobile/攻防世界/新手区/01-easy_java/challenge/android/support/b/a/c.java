package android.support.b.a;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class c extends h implements b {
    class android.support.b.a.c$1 implements Drawable$Callback {
        android.support.b.a.c$1(c arg1) {
            this.a = arg1;
            super();
        }

        public void invalidateDrawable(Drawable arg2) {
            this.a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable arg2, Runnable arg3, long arg4) {
            this.a.scheduleSelf(arg3, arg4);
        }

        public void unscheduleDrawable(Drawable arg2, Runnable arg3) {
            this.a.unscheduleSelf(arg3);
        }
    }

    class a extends Drawable$ConstantState {
        int a;
        i b;
        AnimatorSet c;
        android.support.v4.g.a d;
        private ArrayList e;

        public a(Context arg6, a arg7, Drawable$Callback arg8, Resources arg9) {
            int v1 = 0;
            super();
            if(arg7 != null) {
                this.a = arg7.a;
                if(arg7.b != null) {
                    Drawable$ConstantState v0 = arg7.b.getConstantState();
                    this.b = arg9 != null ? v0.newDrawable(arg9) : v0.newDrawable();
                    this.b = this.b.mutate();
                    this.b.setCallback(arg8);
                    this.b.setBounds(arg7.b.getBounds());
                    this.b.a(false);
                }

                if(arg7.e == null) {
                    return;
                }

                int v2 = arg7.e.size();
                this.e = new ArrayList(v2);
                this.d = new android.support.v4.g.a(v2);
                while(v1 < v2) {
                    Object v0_1 = arg7.e.get(v1);
                    Animator v3 = ((Animator)v0_1).clone();
                    v0_1 = arg7.d.get(v0_1);
                    v3.setTarget(this.b.a(((String)v0_1)));
                    this.e.add(v3);
                    this.d.put(v3, v0_1);
                    ++v1;
                }

                this.a();
            }
        }

        static ArrayList a(a arg1) {
            return arg1.e;
        }

        static ArrayList a(a arg0, ArrayList arg1) {
            arg0.e = arg1;
            return arg1;
        }

        public void a() {
            if(this.c == null) {
                this.c = new AnimatorSet();
            }

            this.c.playTogether(this.e);
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources arg3) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    class android.support.b.a.c$b extends Drawable$ConstantState {
        private final Drawable$ConstantState a;

        public android.support.b.a.c$b(Drawable$ConstantState arg1) {
            super();
            this.a = arg1;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c v0 = new c();
            v0.b = this.a.newDrawable();
            v0.b.setCallback(v0.a);
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg4) {
            c v0 = new c();
            v0.b = this.a.newDrawable(arg4);
            v0.b.setCallback(v0.a);
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg4, Resources$Theme arg5) {
            c v0 = new c();
            v0.b = this.a.newDrawable(arg4, arg5);
            v0.b.setCallback(v0.a);
            return ((Drawable)v0);
        }
    }

    final Drawable$Callback a;
    private a c;
    private Context d;
    private ArgbEvaluator e;
    private Animator$AnimatorListener f;
    private ArrayList g;

    c() {
        this(null, null, null);
    }

    private c(Context arg3, a arg4, Resources arg5) {
        super();
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = new android.support.b.a.c$1(this);
        this.d = arg3;
        this.c = arg4 != null ? arg4 : new a(arg3, arg4, this.a, arg5);
    }

    private c(Context arg2) {
        this(arg2, null, null);
    }

    public static c a(Context arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) {
        c v0 = new c(arg1);
        v0.inflate(arg2, arg3, arg4, arg5);
        return v0;
    }

    private void a(Animator arg4) {
        if((arg4 instanceof AnimatorSet)) {
            ArrayList v2 = arg4.getChildAnimations();
            if(v2 != null) {
                int v1;
                for(v1 = 0; v1 < ((List)v2).size(); ++v1) {
                    this.a(((List)v2).get(v1));
                }
            }
        }

        if((arg4 instanceof ObjectAnimator)) {
            String v0 = ((ObjectAnimator)arg4).getPropertyName();
            if(!"fillColor".equals(v0) && !"strokeColor".equals(v0)) {
                return;
            }

            if(this.e == null) {
                this.e = new ArgbEvaluator();
            }

            ((ObjectAnimator)arg4).setEvaluator(this.e);
        }
    }

    private void a(String arg3, Animator arg4) {
        arg4.setTarget(this.c.b.a(arg3));
        if(Build$VERSION.SDK_INT < 21) {
            this.a(arg4);
        }

        if(a.a(this.c) == null) {
            a.a(this.c, new ArrayList());
            this.c.d = new android.support.v4.g.a();
        }

        a.a(this.c).add(arg4);
        this.c.d.put(arg4, arg3);
    }

    public void applyTheme(Resources$Theme arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
    }

    public boolean canApplyTheme() {
        boolean v0 = this.b != null ? android.support.v4.c.a.a.d(this.b) : false;
        return v0;
    }

    public void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas arg2) {
        if(this.b != null) {
            this.b.draw(arg2);
        }
        else {
            this.c.b.draw(arg2);
            if(this.c.c.isStarted()) {
                this.invalidateSelf();
            }
        }
    }

    public int getAlpha() {
        int v0 = this.b != null ? android.support.v4.c.a.a.c(this.b) : this.c.b.getAlpha();
        return v0;
    }

    public int getChangingConfigurations() {
        int v0 = this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
        return v0;
    }

    public ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable$ConstantState getConstantState() {
        Drawable$ConstantState v0_1;
        if(this.b == null || Build$VERSION.SDK_INT < 24) {
            v0_1 = null;
        }
        else {
            android.support.b.a.c$b v0 = new android.support.b.a.c$b(this.b.getConstantState());
        }

        return v0_1;
    }

    public Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        int v0 = this.b != null ? this.b.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
        return v0;
    }

    public int getIntrinsicWidth() {
        int v0 = this.b != null ? this.b.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
        return v0;
    }

    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        int v0 = this.b != null ? this.b.getOpacity() : this.c.b.getOpacity();
        return v0;
    }

    public boolean getPadding(Rect arg2) {
        return super.getPadding(arg2);
    }

    public int[] getState() {
        return super.getState();
    }

    public Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources arg8, XmlPullParser arg9, AttributeSet arg10, Resources$Theme arg11) {
        TypedArray v0_2;
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg8, arg9, arg10, arg11);
        }
        else {
            int v0 = arg9.getEventType();
            int v1 = arg9.getDepth() + 1;
            while(v0 != 1) {
                if(arg9.getDepth() < v1 && v0 == 3) {
                    break;
                }

                if(v0 == 2) {
                    String v0_1 = arg9.getName();
                    if("animated-vector".equals(v0_1)) {
                        v0_2 = android.support.v4.b.a.c.a(arg8, arg11, arg10, android.support.b.a.a.e);
                        int v2 = v0_2.getResourceId(0, 0);
                        if(v2 != 0) {
                            i v2_1 = i.a(arg8, v2, arg11);
                            v2_1.a(false);
                            v2_1.setCallback(this.a);
                            if(this.c.b != null) {
                                this.c.b.setCallback(null);
                            }

                            this.c.b = v2_1;
                        }

                        v0_2.recycle();
                    }
                    else {
                        if(!"target".equals(v0_1)) {
                            goto label_39;
                        }

                        v0_2 = arg8.obtainAttributes(arg10, android.support.b.a.a.f);
                        String v2_2 = v0_2.getString(0);
                        int v3 = v0_2.getResourceId(1, 0);
                        if(v3 != 0) {
                            if(this.d != null) {
                                this.a(v2_2, e.a(this.d, v3));
                            }
                            else {
                                v0_2.recycle();
                                throw new IllegalStateException("Context can\'t be null when inflating animators");
                            }
                        }

                        v0_2.recycle();
                    }
                }

            label_39:
                v0 = arg9.next();
            }

            this.c.a();
        }
    }

    public void inflate(Resources arg2, XmlPullParser arg3, AttributeSet arg4) {
        this.inflate(arg2, arg3, arg4, null);
    }

    public boolean isAutoMirrored() {
        boolean v0 = this.b != null ? android.support.v4.c.a.a.b(this.b) : this.c.b.isAutoMirrored();
        return v0;
    }

    public boolean isRunning() {
        boolean v0 = this.b != null ? this.b.isRunning() : this.c.c.isRunning();
        return v0;
    }

    public boolean isStateful() {
        boolean v0 = this.b != null ? this.b.isStateful() : this.c.b.isStateful();
        return v0;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(this.b != null) {
            this.b.mutate();
        }

        return this;
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.b != null) {
            this.b.setBounds(arg2);
        }
        else {
            this.c.b.setBounds(arg2);
        }
    }

    protected boolean onLevelChange(int arg2) {
        boolean v0 = this.b != null ? this.b.setLevel(arg2) : this.c.b.setLevel(arg2);
        return v0;
    }

    protected boolean onStateChange(int[] arg2) {
        boolean v0 = this.b != null ? this.b.setState(arg2) : this.c.b.setState(arg2);
        return v0;
    }

    public void setAlpha(int arg2) {
        if(this.b != null) {
            this.b.setAlpha(arg2);
        }
        else {
            this.c.b.setAlpha(arg2);
        }
    }

    public void setAutoMirrored(boolean arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
        else {
            this.c.b.setAutoMirrored(arg2);
        }
    }

    public void setChangingConfigurations(int arg1) {
        super.setChangingConfigurations(arg1);
    }

    public void setColorFilter(int arg1, PorterDuff$Mode arg2) {
        super.setColorFilter(arg1, arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        if(this.b != null) {
            this.b.setColorFilter(arg2);
        }
        else {
            this.c.b.setColorFilter(arg2);
        }
    }

    public void setFilterBitmap(boolean arg1) {
        super.setFilterBitmap(arg1);
    }

    public void setHotspot(float arg1, float arg2) {
        super.setHotspot(arg1, arg2);
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        super.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public boolean setState(int[] arg2) {
        return super.setState(arg2);
    }

    public void setTint(int arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
        else {
            this.c.b.setTint(arg2);
        }
    }

    public void setTintList(ColorStateList arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
        else {
            this.c.b.setTintList(arg2);
        }
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
        else {
            this.c.b.setTintMode(arg2);
        }
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        boolean v0;
        if(this.b != null) {
            v0 = this.b.setVisible(arg2, arg3);
        }
        else {
            this.c.b.setVisible(arg2, arg3);
            v0 = super.setVisible(arg2, arg3);
        }

        return v0;
    }

    public void start() {
        if(this.b != null) {
            this.b.start();
        }
        else if(!this.c.c.isStarted()) {
            this.c.c.start();
            this.invalidateSelf();
        }
    }

    public void stop() {
        if(this.b != null) {
            this.b.stop();
        }
        else {
            this.c.c.end();
        }
    }
}

