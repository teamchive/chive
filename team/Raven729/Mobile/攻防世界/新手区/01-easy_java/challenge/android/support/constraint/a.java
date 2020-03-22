package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.util.AttributeSet;

public class a extends b {
    private int f;
    private int g;
    private android.support.constraint.a.a.a h;

    public a(Context arg2) {
        super(arg2);
        this.f = 0;
        this.g = 0;
        super.setVisibility(8);
    }

    protected void a(AttributeSet arg8) {
        super.a(arg8);
        this.h = new android.support.constraint.a.a.a();
        if(arg8 != null) {
            TypedArray v2 = this.getContext().obtainStyledAttributes(arg8, android.support.constraint.g$b.ConstraintLayout_Layout);
            int v3 = v2.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                int v4 = v2.getIndex(v0);
                if(v4 == android.support.constraint.g$b.ConstraintLayout_Layout_barrierDirection) {
                    this.setType(v2.getInt(v4, 0));
                }
                else if(v4 == android.support.constraint.g$b.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.h.a(v2.getBoolean(v4, true));
                }
            }
        }

        this.d = this.h;
        this.a();
    }

    public int getType() {
        return this.f;
    }

    public void setType(int arg7) {
        int v5 = 6;
        int v4 = 5;
        this.f = arg7;
        this.g = arg7;
        if(Build$VERSION.SDK_INT >= 17) {
            int v0 = 1 == this.getResources().getConfiguration().getLayoutDirection() ? 1 : 0;
            if(v0 != 0) {
                if(this.f == v4) {
                    this.g = 1;
                    goto label_12;
                }

                if(this.f != v5) {
                    goto label_12;
                }

                this.g = 0;
                goto label_12;
            }

            if(this.f == v4) {
                this.g = 0;
                goto label_12;
            }

            if(this.f != v5) {
                goto label_12;
            }

            this.g = 1;
        }
        else if(this.f == v4) {
            this.g = 0;
        }
        else if(this.f == v5) {
            this.g = 1;
        }

    label_12:
        this.h.a(this.g);
    }
}

