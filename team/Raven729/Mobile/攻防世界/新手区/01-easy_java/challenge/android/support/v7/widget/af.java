package android.support.v7.widget;

import android.content.Context;
import android.os.Build$VERSION;
import android.support.v4.h.r;
import android.support.v4.widget.g;
import android.support.v7.a.a$a;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

class af extends ak {
    private boolean g;
    private boolean h;
    private boolean i;
    private r j;
    private g k;

    public af(Context arg3, boolean arg4) {
        super(arg3, null, a.dropDownListViewStyle);
        this.h = arg4;
        this.setCacheColorHint(0);
    }

    public boolean a(MotionEvent arg9, int arg10) {
        boolean v0_1;
        boolean v3_1;
        int v0;
        int v3 = arg9.getActionMasked();
        switch(v3) {
            case 1: {
                v0_1 = false;
            label_24:
                int v4 = arg9.findPointerIndex(arg10);
                if(v4 < 0) {
                    v0 = 0;
                    v3_1 = false;
                    goto label_6;
                }

                int v5 = ((int)arg9.getX(v4));
                v4 = ((int)arg9.getY(v4));
                int v6 = this.pointToPosition(v5, v4);
                if(v6 == -1) {
                    v3_1 = v0_1;
                    v0 = 1;
                    goto label_6;
                }

                View v0_2 = this.getChildAt(v6 - this.getFirstVisiblePosition());
                this.a(v0_2, v6, ((float)v5), ((float)v4));
                if(v3 != 1) {
                    goto label_4;
                }

                this.a(v0_2, v6);
                goto label_4;
            }
            case 2: {
                v0_1 = true;
                goto label_24;
            }
            case 3: {
                v0 = 0;
                v3_1 = false;
                break;
            }
            default: {
            label_4:
                v0 = 0;
                v3_1 = true;
                break;
            }
        }

    label_6:
        if(!v3_1 || v0 != 0) {
            this.d();
        }

        if(v3_1) {
            if(this.k == null) {
                this.k = new g(((ListView)this));
            }

            this.k.a(true);
            this.k.onTouch(((View)this), arg9);
        }
        else {
            if(this.k == null) {
                return v3_1;
            }

            this.k.a(false);
        }

        return v3_1;
    }

    private void a(View arg3, int arg4) {
        this.performItemClick(arg3, arg4, this.getItemIdAtPosition(arg4));
    }

    private void a(View arg7, int arg8, float arg9, float arg10) {
        int v5 = 21;
        this.i = true;
        if(Build$VERSION.SDK_INT >= v5) {
            this.drawableHotspotChanged(arg9, arg10);
        }

        if(!this.isPressed()) {
            this.setPressed(true);
        }

        this.layoutChildren();
        if(this.f != -1) {
            View v0 = this.getChildAt(this.f - this.getFirstVisiblePosition());
            if(v0 != null && v0 != arg7 && (v0.isPressed())) {
                v0.setPressed(false);
            }
        }

        this.f = arg8;
        float v0_1 = arg9 - (((float)arg7.getLeft()));
        float v1 = arg10 - (((float)arg7.getTop()));
        if(Build$VERSION.SDK_INT >= v5) {
            arg7.drawableHotspotChanged(v0_1, v1);
        }

        if(!arg7.isPressed()) {
            arg7.setPressed(true);
        }

        this.a(arg8, arg7, arg9, arg10);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    protected boolean a() {
        boolean v0 = (this.i) || (super.a()) ? true : false;
        return v0;
    }

    private void d() {
        this.i = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View v0 = this.getChildAt(this.f - this.getFirstVisiblePosition());
        if(v0 != null) {
            v0.setPressed(false);
        }

        if(this.j != null) {
            this.j.b();
            this.j = null;
        }
    }

    public boolean hasFocus() {
        boolean v0 = (this.h) || (super.hasFocus()) ? true : false;
        return v0;
    }

    public boolean hasWindowFocus() {
        boolean v0 = (this.h) || (super.hasWindowFocus()) ? true : false;
        return v0;
    }

    public boolean isFocused() {
        boolean v0 = (this.h) || (super.isFocused()) ? true : false;
        return v0;
    }

    public boolean isInTouchMode() {
        boolean v0 = (this.h) && (this.g) || (super.isInTouchMode()) ? true : false;
        return v0;
    }

    void setListSelectionHidden(boolean arg1) {
        this.g = arg1;
    }
}

