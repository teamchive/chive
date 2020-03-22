package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.h.o;
import android.support.v7.a.a$a;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class h extends Button implements o {
    private final g a;
    private final y b;

    public h(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, a.buttonStyle);
    }

    public h(Context arg2, AttributeSet arg3, int arg4) {
        super(at.a(arg2), arg3, arg4);
        this.a = new g(((View)this));
        this.a.a(arg3, arg4);
        this.b = y.a(((TextView)this));
        this.b.a(arg3, arg4);
        this.b.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.a != null) {
            this.a.c();
        }

        if(this.b != null) {
            this.b.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        int v0;
        if(Build$VERSION.SDK_INT >= 26) {
            v0 = super.getAutoSizeMaxTextSize();
        }
        else if(this.b != null) {
            v0 = this.b.g();
        }
        else {
            v0 = -1;
        }

        return v0;
    }

    public int getAutoSizeMinTextSize() {
        int v0;
        if(Build$VERSION.SDK_INT >= 26) {
            v0 = super.getAutoSizeMinTextSize();
        }
        else if(this.b != null) {
            v0 = this.b.f();
        }
        else {
            v0 = -1;
        }

        return v0;
    }

    public int getAutoSizeStepGranularity() {
        int v0;
        if(Build$VERSION.SDK_INT >= 26) {
            v0 = super.getAutoSizeStepGranularity();
        }
        else if(this.b != null) {
            v0 = this.b.e();
        }
        else {
            v0 = -1;
        }

        return v0;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        int[] v0;
        if(Build$VERSION.SDK_INT >= 26) {
            v0 = super.getAutoSizeTextAvailableSizes();
        }
        else if(this.b != null) {
            v0 = this.b.h();
        }
        else {
            v0 = new int[0];
        }

        return v0;
    }

    public int getAutoSizeTextType() {
        int v0 = 1;
        if(Build$VERSION.SDK_INT >= 26) {
            if(super.getAutoSizeTextType() != 1) {
                v0 = 0;
            }
        }
        else if(this.b != null) {
            v0 = this.b.d();
        }
        else {
            v0 = 0;
        }

        return v0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList v0 = this.a != null ? this.a.a() : null;
        return v0;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        PorterDuff$Mode v0 = this.a != null ? this.a.b() : null;
        return v0;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg2);
        arg2.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg2) {
        super.onInitializeAccessibilityNodeInfo(arg2);
        arg2.setClassName(Button.class.getName());
    }

    protected void onLayout(boolean arg7, int arg8, int arg9, int arg10, int arg11) {
        super.onLayout(arg7, arg8, arg9, arg10, arg11);
        if(this.b != null) {
            this.b.a(arg7, arg8, arg9, arg10, arg11);
        }
    }

    protected void onTextChanged(CharSequence arg3, int arg4, int arg5, int arg6) {
        super.onTextChanged(arg3, arg4, arg5, arg6);
        if(this.b != null && Build$VERSION.SDK_INT < 26 && (this.b.c())) {
            this.b.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int arg3, int arg4, int arg5, int arg6) {
        if(Build$VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithConfiguration(arg3, arg4, arg5, arg6);
        }
        else if(this.b != null) {
            this.b.a(arg3, arg4, arg5, arg6);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arg3, arg4);
        }
        else if(this.b != null) {
            this.b.a(arg3, arg4);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int arg3) {
        if(Build$VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeWithDefaults(arg3);
        }
        else if(this.b != null) {
            this.b.a(arg3);
        }
    }

    public void setBackgroundDrawable(Drawable arg2) {
        super.setBackgroundDrawable(arg2);
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setBackgroundResource(int arg2) {
        super.setBackgroundResource(arg2);
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setSupportAllCaps(boolean arg2) {
        if(this.b != null) {
            this.b.a(arg2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }
    }

    public void setTextAppearance(Context arg2, int arg3) {
        super.setTextAppearance(arg2, arg3);
        if(this.b != null) {
            this.b.a(arg2, arg3);
        }
    }

    public void setTextSize(int arg3, float arg4) {
        if(Build$VERSION.SDK_INT >= 26) {
            super.setTextSize(arg3, arg4);
        }
        else if(this.b != null) {
            this.b.a(arg3, arg4);
        }
    }
}

