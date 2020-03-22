package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class j extends CheckedTextView {
    private static final int[] a;
    private final y b;

    static {
        j.a = new int[]{0x1010108};
    }

    public j(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0x10103C8);
    }

    public j(Context arg4, AttributeSet arg5, int arg6) {
        super(at.a(arg4), arg5, arg6);
        this.b = y.a(((TextView)this));
        this.b.a(arg5, arg6);
        this.b.a();
        aw v0 = aw.a(this.getContext(), arg5, j.a, arg6, 0);
        this.setCheckMarkDrawable(v0.a(0));
        v0.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.b != null) {
            this.b.a();
        }
    }

    public void setCheckMarkDrawable(int arg2) {
        this.setCheckMarkDrawable(b.b(this.getContext(), arg2));
    }

    public void setTextAppearance(Context arg2, int arg3) {
        super.setTextAppearance(arg2, arg3);
        if(this.b != null) {
            this.b.a(arg2, arg3);
        }
    }
}

