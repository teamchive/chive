package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;

public class d extends ViewGroup {
    public class a extends android.support.constraint.ConstraintLayout$a {
        public float an;
        public boolean ao;
        public float ap;
        public float aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public a(int arg4, int arg5) {
            super(arg4, arg5);
            this.an = 1f;
            this.ao = false;
            this.ap = 0f;
            this.aq = 0f;
            this.ar = 0f;
            this.as = 0f;
            this.at = 1f;
            this.au = 1f;
            this.av = 0f;
            this.aw = 0f;
            this.ax = 0f;
            this.ay = 0f;
            this.az = 0f;
        }

        public a(Context arg6, AttributeSet arg7) {
            int v0 = 0;
            super(arg6, arg7);
            this.an = 1f;
            this.ao = false;
            this.ap = 0f;
            this.aq = 0f;
            this.ar = 0f;
            this.as = 0f;
            this.at = 1f;
            this.au = 1f;
            this.av = 0f;
            this.aw = 0f;
            this.ax = 0f;
            this.ay = 0f;
            this.az = 0f;
            TypedArray v1 = arg6.obtainStyledAttributes(arg7, b.ConstraintSet);
            int v2 = v1.getIndexCount();
            while(v0 < v2) {
                int v3 = v1.getIndex(v0);
                if(v3 == b.ConstraintSet_android_alpha) {
                    this.an = v1.getFloat(v3, this.an);
                }
                else if(v3 == b.ConstraintSet_android_elevation) {
                    this.ap = v1.getFloat(v3, this.ap);
                    this.ao = true;
                }
                else if(v3 == b.ConstraintSet_android_rotationX) {
                    this.ar = v1.getFloat(v3, this.ar);
                }
                else if(v3 == b.ConstraintSet_android_rotationY) {
                    this.as = v1.getFloat(v3, this.as);
                }
                else if(v3 == b.ConstraintSet_android_rotation) {
                    this.aq = v1.getFloat(v3, this.aq);
                }
                else if(v3 == b.ConstraintSet_android_scaleX) {
                    this.at = v1.getFloat(v3, this.at);
                }
                else if(v3 == b.ConstraintSet_android_scaleY) {
                    this.au = v1.getFloat(v3, this.au);
                }
                else if(v3 == b.ConstraintSet_android_transformPivotX) {
                    this.av = v1.getFloat(v3, this.av);
                }
                else if(v3 == b.ConstraintSet_android_transformPivotY) {
                    this.aw = v1.getFloat(v3, this.aw);
                }
                else if(v3 == b.ConstraintSet_android_translationX) {
                    this.ax = v1.getFloat(v3, this.ax);
                }
                else if(v3 == b.ConstraintSet_android_translationY) {
                    this.ay = v1.getFloat(v3, this.ay);
                }
                else if(v3 == b.ConstraintSet_android_translationZ) {
                    this.ax = v1.getFloat(v3, this.az);
                }

                ++v0;
            }
        }
    }

    c a;

    protected a a() {
        return new a(-2, -2);
    }

    public a a(AttributeSet arg3) {
        return new a(this.getContext(), arg3);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return this.a(arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg2) {
        return new android.support.constraint.ConstraintLayout$a(arg2);
    }

    public c getConstraintSet() {
        if(this.a == null) {
            this.a = new c();
        }

        this.a.a(this);
        return this.a;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }
}

