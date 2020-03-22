package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements ag {
    private a a;

    public FitWindowsFrameLayout(Context arg1) {
        super(arg1);
    }

    public FitWindowsFrameLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    protected boolean fitSystemWindows(Rect arg2) {
        if(this.a != null) {
            this.a.a(arg2);
        }

        return super.fitSystemWindows(arg2);
    }

    public void setOnFitSystemWindowsListener(a arg1) {
        this.a = arg1;
    }
}

