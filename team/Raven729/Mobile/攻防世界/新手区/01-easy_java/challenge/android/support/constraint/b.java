package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.a.a.g;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import java.util.Arrays;

public abstract class b extends View {
    protected int[] a;
    protected int b;
    protected Context c;
    protected g d;
    protected boolean e;
    private String f;

    public b(Context arg4) {
        super(arg4);
        this.a = new int[0x20];
        this.b = 0;
        this.d = null;
        this.e = false;
        this.c = arg4;
        this.a(null);
    }

    public void a(ConstraintLayout arg4) {
        if(this.isInEditMode()) {
            this.setIds(this.f);
        }

        if(this.d != null) {
            this.d.H();
            int v0;
            for(v0 = 0; v0 < this.b; ++v0) {
                View v1 = arg4.findViewById(this.a[v0]);
                if(v1 != null) {
                    this.d.b(arg4.a(v1));
                }
            }
        }
    }

    public void a() {
        if(this.d != null) {
            ViewGroup$LayoutParams v0 = this.getLayoutParams();
            if((v0 instanceof a)) {
                ((a)v0).al = this.d;
            }
        }
    }

    protected void a(AttributeSet arg6) {
        if(arg6 != null) {
            TypedArray v1 = this.getContext().obtainStyledAttributes(arg6, android.support.constraint.g$b.ConstraintLayout_Layout);
            int v2 = v1.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                int v3 = v1.getIndex(v0);
                if(v3 == android.support.constraint.g$b.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f = v1.getString(v3);
                    this.setIds(this.f);
                }
            }
        }
    }

    private void a(String arg7) {
        int v0_2;
        int v1;
        Object v5 = null;
        if(arg7 != null && this.c != null) {
            String v3 = arg7.trim();
            try {
                v1 = android.support.constraint.g$a.class.getField(v3).getInt(null);
            }
            catch(Exception v0) {
                v1 = 0;
            }

            if(v1 == 0) {
                v1 = this.c.getResources().getIdentifier(v3, "id", this.c.getPackageName());
            }

            if(v1 != 0 || !this.isInEditMode() || !(this.getParent() instanceof ConstraintLayout)) {
            label_47:
                v0_2 = v1;
            }
            else {
                Object v0_1 = this.getParent().a(0, v3);
                if(v0_1 == null) {
                    goto label_47;
                }
                else if((v0_1 instanceof Integer)) {
                    v0_2 = ((Integer)v0_1).intValue();
                }
                else {
                    goto label_47;
                }
            }

            if(v0_2 != 0) {
                this.setTag(v0_2, v5);
            }
            else {
                Log.w("ConstraintHelper", "Could not find id of \"" + v3 + "\"");
            }
        }
    }

    public void b(ConstraintLayout arg1) {
    }

    public void c(ConstraintLayout arg1) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    public void onDraw(Canvas arg1) {
    }

    protected void onMeasure(int arg3, int arg4) {
        if(this.e) {
            super.onMeasure(arg3, arg4);
        }
        else {
            this.setMeasuredDimension(0, 0);
        }
    }

    private void setIds(String arg4) {
        if(arg4 != null) {
            int v0;
            for(v0 = 0; true; v0 = v1 + 1) {
                int v1 = arg4.indexOf(44, v0);
                if(v1 == -1) {
                    break;
                }

                this.a(arg4.substring(v0, v1));
            }

            this.a(arg4.substring(v0));
        }
    }

    public void setReferencedIds(int[] arg4) {
        int v0 = 0;
        this.b = 0;
        while(v0 < arg4.length) {
            this.setTag(arg4[v0], null);
            ++v0;
        }
    }

    public void setTag(int arg3, Object arg4) {
        if(this.b + 1 > this.a.length) {
            this.a = Arrays.copyOf(this.a, this.a.length * 2);
        }

        this.a[this.b] = arg3;
        ++this.b;
    }
}

