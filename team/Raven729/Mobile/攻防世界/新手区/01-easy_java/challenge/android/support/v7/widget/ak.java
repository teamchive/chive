package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ak extends ListView {
    class a extends android.support.v7.c.a.a {
        private boolean a;

        public a(Drawable arg2) {
            super(arg2);
            this.a = true;
        }

        void a(boolean arg1) {
            this.a = arg1;
        }

        public void draw(Canvas arg2) {
            if(this.a) {
                super.draw(arg2);
            }
        }

        public void setHotspot(float arg2, float arg3) {
            if(this.a) {
                super.setHotspot(arg2, arg3);
            }
        }

        public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
            if(this.a) {
                super.setHotspotBounds(arg2, arg3, arg4, arg5);
            }
        }

        public boolean setState(int[] arg2) {
            boolean v0 = this.a ? super.setState(arg2) : false;
            return v0;
        }

        public boolean setVisible(boolean arg2, boolean arg3) {
            boolean v0 = this.a ? super.setVisible(arg2, arg3) : false;
            return v0;
        }
    }

    final Rect a;
    int b;
    int c;
    int d;
    int e;
    protected int f;
    private static final int[] g;
    private Field h;
    private a i;

    static {
        ak.g = new int[]{0};
    }

    public ak(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.a = new Rect();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
        }
        catch(NoSuchFieldException v0) {
            v0.printStackTrace();
        }
    }

    public int a(int arg13, int arg14, int arg15, int arg16, int arg17) {
        View v2_1;
        int v2 = this.getListPaddingTop();
        int v3 = this.getListPaddingBottom();
        this.getListPaddingLeft();
        this.getListPaddingRight();
        int v1 = this.getDividerHeight();
        Drawable v4 = this.getDivider();
        ListAdapter v8 = this.getAdapter();
        if(v8 == null) {
            arg16 = v2 + v3;
        }
        else {
            v3 += v2;
            if(v1 <= 0 || v4 == null) {
                v1 = 0;
            }

            int v4_1 = 0;
            View v6 = null;
            int v5 = 0;
            int v9 = v8.getCount();
            int v7 = 0;
            while(v7 < v9) {
                v2 = v8.getItemViewType(v7);
                if(v2 != v5) {
                    int v11 = v2;
                    v2_1 = null;
                    v5 = v11;
                }
                else {
                    v2_1 = v6;
                }

                v6 = v8.getView(v7, v2_1, ((ViewGroup)this));
                ViewGroup$LayoutParams v2_2 = v6.getLayoutParams();
                if(v2_2 == null) {
                    v2_2 = this.generateDefaultLayoutParams();
                    v6.setLayoutParams(v2_2);
                }

                v2 = v2_2.height > 0 ? View$MeasureSpec.makeMeasureSpec(v2_2.height, 0x40000000) : View$MeasureSpec.makeMeasureSpec(0, 0);
                v6.measure(arg13, v2);
                v6.forceLayout();
                v2 = v7 > 0 ? v3 + v1 : v3;
                v2 += v6.getMeasuredHeight();
                if(v2 >= arg16) {
                    if(arg17 < 0) {
                        return arg16;
                    }

                    if(v7 <= arg17) {
                        return arg16;
                    }

                    if(v4_1 <= 0) {
                        return arg16;
                    }

                    if(v2 == arg16) {
                        return arg16;
                    }

                    return v4_1;
                }

                if(arg17 >= 0 && v7 >= arg17) {
                    v4_1 = v2;
                }

                ++v7;
                v3 = v2;
            }

            arg16 = v3;
        }

        return arg16;
    }

    protected void a(int arg7, View arg8) {
        boolean v0 = true;
        Drawable v3 = this.getSelector();
        int v2 = v3 == null || arg7 == -1 ? 0 : 1;
        if(v2 != 0) {
            v3.setVisible(false, false);
        }

        this.b(arg7, arg8);
        if(v2 != 0) {
            Rect v2_1 = this.a;
            float v4 = v2_1.exactCenterX();
            float v2_2 = v2_1.exactCenterY();
            if(this.getVisibility() != 0) {
                v0 = false;
            }

            v3.setVisible(v0, false);
            android.support.v4.c.a.a.a(v3, v4, v2_2);
        }
    }

    protected void a(int arg3, View arg4, float arg5, float arg6) {
        this.a(arg3, arg4);
        Drawable v0 = this.getSelector();
        if(v0 != null && arg3 != -1) {
            android.support.v4.c.a.a.a(v0, arg5, arg6);
        }
    }

    protected void a(Canvas arg3) {
        if(!this.a.isEmpty()) {
            Drawable v0 = this.getSelector();
            if(v0 != null) {
                v0.setBounds(this.a);
                v0.draw(arg3);
            }
        }
    }

    protected boolean a() {
        return 0;
    }

    protected void b(int arg6, View arg7) {
        Field v1;
        boolean v0_2;
        Rect v0 = this.a;
        v0.set(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom());
        v0.left -= this.b;
        v0.top -= this.c;
        v0.right += this.d;
        v0.bottom += this.e;
        try {
            v0_2 = this.h.getBoolean(this);
            if(arg7.isEnabled() == v0_2) {
                return;
            }

            v1 = this.h;
            if(!v0_2) {
                v0_2 = true;
            }
            else {
                goto label_35;
            }

            goto label_29;
        }
        catch(IllegalAccessException v0_1) {
            goto label_38;
        }

    label_35:
        v0_2 = false;
        try {
        label_29:
            v1.set(this, Boolean.valueOf(v0_2));
            if(arg6 == -1) {
                return;
            }

            this.refreshDrawableState();
        }
        catch(IllegalAccessException v0_1) {
        label_38:
            v0_1.printStackTrace();
        }
    }

    protected void b() {
        Drawable v0 = this.getSelector();
        if(v0 != null && (this.c())) {
            v0.setState(this.getDrawableState());
        }
    }

    protected boolean c() {
        boolean v0 = !this.a() || !this.isPressed() ? false : true;
        return v0;
    }

    protected void dispatchDraw(Canvas arg1) {
        this.a(arg1);
        super.dispatchDraw(arg1);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.b();
    }

    public boolean onTouchEvent(MotionEvent arg3) {
        switch(arg3.getAction()) {
            case 0: {
                this.f = this.pointToPosition(((int)arg3.getX()), ((int)arg3.getY()));
                break;
            }
        }

        return super.onTouchEvent(arg3);
    }

    public void setSelector(Drawable arg3) {
        a v0 = arg3 != null ? new a(arg3) : null;
        this.i = v0;
        super.setSelector(this.i);
        Rect v0_1 = new Rect();
        if(arg3 != null) {
            arg3.getPadding(v0_1);
        }

        this.b = v0_1.left;
        this.c = v0_1.top;
        this.d = v0_1.right;
        this.e = v0_1.bottom;
    }

    protected void setSelectorEnabled(boolean arg2) {
        if(this.i != null) {
            this.i.a(arg2);
        }
    }
}

