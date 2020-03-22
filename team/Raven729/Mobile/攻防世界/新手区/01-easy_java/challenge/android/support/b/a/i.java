package android.support.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$FillType;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v4.b.a.c;
import android.support.v4.c.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {
    class a extends d {
        public a() {
            super();
        }

        public a(a arg1) {
            super(((d)arg1));
        }

        public void a(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            if(c.a(arg5, "pathData")) {
                TypedArray v0 = c.a(arg2, arg4, arg3, android.support.b.a.a.d);
                this.a(v0);
                v0.recycle();
            }
        }

        private void a(TypedArray arg2) {
            String v0 = arg2.getString(0);
            if(v0 != null) {
                this.n = v0;
            }

            v0 = arg2.getString(1);
            if(v0 != null) {
                this.m = b.b(v0);
            }
        }

        public boolean a() {
            return 1;
        }
    }

    class android.support.b.a.i$b extends d {
        int a;
        float b;
        int c;
        float d;
        int e;
        float f;
        float g;
        float h;
        float i;
        Paint$Cap j;
        Paint$Join k;
        float l;
        private int[] p;

        public android.support.b.a.i$b() {
            super();
            this.a = 0;
            this.b = 0f;
            this.c = 0;
            this.d = 1f;
            this.e = 0;
            this.f = 1f;
            this.g = 0f;
            this.h = 1f;
            this.i = 0f;
            this.j = Paint$Cap.BUTT;
            this.k = Paint$Join.MITER;
            this.l = 4f;
        }

        public android.support.b.a.i$b(android.support.b.a.i$b arg4) {
            super(((d)arg4));
            this.a = 0;
            this.b = 0f;
            this.c = 0;
            this.d = 1f;
            this.e = 0;
            this.f = 1f;
            this.g = 0f;
            this.h = 1f;
            this.i = 0f;
            this.j = Paint$Cap.BUTT;
            this.k = Paint$Join.MITER;
            this.l = 4f;
            this.p = arg4.p;
            this.a = arg4.a;
            this.b = arg4.b;
            this.d = arg4.d;
            this.c = arg4.c;
            this.e = arg4.e;
            this.f = arg4.f;
            this.g = arg4.g;
            this.h = arg4.h;
            this.i = arg4.i;
            this.j = arg4.j;
            this.k = arg4.k;
            this.l = arg4.l;
        }

        public void a(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            TypedArray v0 = c.a(arg2, arg4, arg3, android.support.b.a.a.c);
            this.a(v0, arg5);
            v0.recycle();
        }

        private Paint$Cap a(int arg1, Paint$Cap arg2) {
            switch(arg1) {
                case 0: {
                    arg2 = Paint$Cap.BUTT;
                    break;
                }
                case 1: {
                    arg2 = Paint$Cap.ROUND;
                    break;
                }
                case 2: {
                    arg2 = Paint$Cap.SQUARE;
                    break;
                }
            }

            return arg2;
        }

        private Paint$Join a(int arg1, Paint$Join arg2) {
            switch(arg1) {
                case 0: {
                    arg2 = Paint$Join.MITER;
                    break;
                }
                case 1: {
                    arg2 = Paint$Join.ROUND;
                    break;
                }
                case 2: {
                    arg2 = Paint$Join.BEVEL;
                    break;
                }
            }

            return arg2;
        }

        private void a(TypedArray arg5, XmlPullParser arg6) {
            int v3 = -1;
            this.p = null;
            if(c.a(arg6, "pathData")) {
                String v0 = arg5.getString(0);
                if(v0 != null) {
                    this.n = v0;
                }

                v0 = arg5.getString(2);
                if(v0 != null) {
                    this.m = b.b(v0);
                }

                this.c = c.b(arg5, arg6, "fillColor", 1, this.c);
                this.f = c.a(arg5, arg6, "fillAlpha", 12, this.f);
                this.j = this.a(c.a(arg5, arg6, "strokeLineCap", 8, v3), this.j);
                this.k = this.a(c.a(arg5, arg6, "strokeLineJoin", 9, v3), this.k);
                this.l = c.a(arg5, arg6, "strokeMiterLimit", 10, this.l);
                this.a = c.b(arg5, arg6, "strokeColor", 3, this.a);
                this.d = c.a(arg5, arg6, "strokeAlpha", 11, this.d);
                this.b = c.a(arg5, arg6, "strokeWidth", 4, this.b);
                this.h = c.a(arg5, arg6, "trimPathEnd", 6, this.h);
                this.i = c.a(arg5, arg6, "trimPathOffset", 7, this.i);
                this.g = c.a(arg5, arg6, "trimPathStart", 5, this.g);
                this.e = c.a(arg5, arg6, "fillType", 13, this.e);
            }
        }

        float getFillAlpha() {
            return this.f;
        }

        int getFillColor() {
            return this.c;
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.a;
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setFillAlpha(float arg1) {
            this.f = arg1;
        }

        void setFillColor(int arg1) {
            this.c = arg1;
        }

        void setStrokeAlpha(float arg1) {
            this.d = arg1;
        }

        void setStrokeColor(int arg1) {
            this.a = arg1;
        }

        void setStrokeWidth(float arg1) {
            this.b = arg1;
        }

        void setTrimPathEnd(float arg1) {
            this.h = arg1;
        }

        void setTrimPathOffset(float arg1) {
            this.i = arg1;
        }

        void setTrimPathStart(float arg1) {
            this.g = arg1;
        }
    }

    class android.support.b.a.i$c {
        final ArrayList a;
        float b;
        int c;
        private final Matrix d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private final Matrix k;
        private int[] l;
        private String m;

        public android.support.b.a.i$c() {
            super();
            this.d = new Matrix();
            this.a = new ArrayList();
            this.b = 0f;
            this.e = 0f;
            this.f = 0f;
            this.g = 1f;
            this.h = 1f;
            this.i = 0f;
            this.j = 0f;
            this.k = new Matrix();
            this.m = null;
        }

        public android.support.b.a.i$c(android.support.b.a.i$c arg6, android.support.v4.g.a arg7) {
            android.support.b.a.i$b v0_1;
            super();
            this.d = new Matrix();
            this.a = new ArrayList();
            this.b = 0f;
            this.e = 0f;
            this.f = 0f;
            this.g = 1f;
            this.h = 1f;
            this.i = 0f;
            this.j = 0f;
            this.k = new Matrix();
            this.m = null;
            this.b = arg6.b;
            this.e = arg6.e;
            this.f = arg6.f;
            this.g = arg6.g;
            this.h = arg6.h;
            this.i = arg6.i;
            this.j = arg6.j;
            this.l = arg6.l;
            this.m = arg6.m;
            this.c = arg6.c;
            if(this.m != null) {
                arg7.put(this.m, this);
            }

            this.k.set(arg6.k);
            ArrayList v3 = arg6.a;
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= v3.size()) {
                    return;
                }

                Object v0 = v3.get(v1);
                if((v0 instanceof android.support.b.a.i$c)) {
                    this.a.add(new android.support.b.a.i$c(((android.support.b.a.i$c)v0), arg7));
                }
                else {
                    if((v0 instanceof android.support.b.a.i$b)) {
                        v0_1 = new android.support.b.a.i$b(((android.support.b.a.i$b)v0));
                    }
                    else if((v0 instanceof a)) {
                        a v0_2 = new a(((a)v0));
                    }
                    else {
                        break;
                    }

                    this.a.add(v0_1);
                    if(((d)v0_1).n == null) {
                        goto label_60;
                    }

                    arg7.put(((d)v0_1).n, v0_1);
                }

            label_60:
            }

            throw new IllegalStateException("Unknown object in the tree!");
        }

        public void a(Resources arg2, AttributeSet arg3, Resources$Theme arg4, XmlPullParser arg5) {
            TypedArray v0 = c.a(arg2, arg4, arg3, android.support.b.a.a.b);
            this.a(v0, arg5);
            v0.recycle();
        }

        static Matrix a(android.support.b.a.i$c arg1) {
            return arg1.d;
        }

        private void a() {
            this.k.reset();
            this.k.postTranslate(-this.e, -this.f);
            this.k.postScale(this.g, this.h);
            this.k.postRotate(this.b, 0f, 0f);
            this.k.postTranslate(this.i + this.e, this.j + this.f);
        }

        private void a(TypedArray arg4, XmlPullParser arg5) {
            this.l = null;
            this.b = c.a(arg4, arg5, "rotation", 5, this.b);
            this.e = arg4.getFloat(1, this.e);
            this.f = arg4.getFloat(2, this.f);
            this.g = c.a(arg4, arg5, "scaleX", 3, this.g);
            this.h = c.a(arg4, arg5, "scaleY", 4, this.h);
            this.i = c.a(arg4, arg5, "translateX", 6, this.i);
            this.j = c.a(arg4, arg5, "translateY", 7, this.j);
            String v0 = arg4.getString(0);
            if(v0 != null) {
                this.m = v0;
            }

            this.a();
        }

        static Matrix b(android.support.b.a.i$c arg1) {
            return arg1.k;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.k;
        }

        public float getPivotX() {
            return this.e;
        }

        public float getPivotY() {
            return this.f;
        }

        public float getRotation() {
            return this.b;
        }

        public float getScaleX() {
            return this.g;
        }

        public float getScaleY() {
            return this.h;
        }

        public float getTranslateX() {
            return this.i;
        }

        public float getTranslateY() {
            return this.j;
        }

        public void setPivotX(float arg2) {
            if(arg2 != this.e) {
                this.e = arg2;
                this.a();
            }
        }

        public void setPivotY(float arg2) {
            if(arg2 != this.f) {
                this.f = arg2;
                this.a();
            }
        }

        public void setRotation(float arg2) {
            if(arg2 != this.b) {
                this.b = arg2;
                this.a();
            }
        }

        public void setScaleX(float arg2) {
            if(arg2 != this.g) {
                this.g = arg2;
                this.a();
            }
        }

        public void setScaleY(float arg2) {
            if(arg2 != this.h) {
                this.h = arg2;
                this.a();
            }
        }

        public void setTranslateX(float arg2) {
            if(arg2 != this.i) {
                this.i = arg2;
                this.a();
            }
        }

        public void setTranslateY(float arg2) {
            if(arg2 != this.j) {
                this.j = arg2;
                this.a();
            }
        }
    }

    class d {
        protected android.support.v4.c.b$b[] m;
        String n;
        int o;

        public d() {
            super();
            this.m = null;
        }

        public d(d arg2) {
            super();
            this.m = null;
            this.n = arg2.n;
            this.o = arg2.o;
            this.m = b.a(arg2.m);
        }

        public void a(Path arg2) {
            arg2.reset();
            if(this.m != null) {
                android.support.v4.c.b$b.a(this.m, arg2);
            }
        }

        public boolean a() {
            return 0;
        }

        public android.support.v4.c.b$b[] getPathData() {
            return this.m;
        }

        public String getPathName() {
            return this.n;
        }

        public void setPathData(android.support.v4.c.b$b[] arg2) {
            if(!b.a(this.m, arg2)) {
                this.m = b.a(arg2);
            }
            else {
                b.b(this.m, arg2);
            }
        }
    }

    class e {
        final android.support.b.a.i$c a;
        float b;
        float c;
        float d;
        float e;
        int f;
        String g;
        final android.support.v4.g.a h;
        private final Path i;
        private final Path j;
        private static final Matrix k;
        private final Matrix l;
        private Paint m;
        private Paint n;
        private PathMeasure o;
        private int p;

        static {
            e.k = new Matrix();
        }

        public e() {
            super();
            this.l = new Matrix();
            this.b = 0f;
            this.c = 0f;
            this.d = 0f;
            this.e = 0f;
            this.f = 0xFF;
            this.g = null;
            this.h = new android.support.v4.g.a();
            this.a = new android.support.b.a.i$c();
            this.i = new Path();
            this.j = new Path();
        }

        public e(e arg4) {
            super();
            this.l = new Matrix();
            this.b = 0f;
            this.c = 0f;
            this.d = 0f;
            this.e = 0f;
            this.f = 0xFF;
            this.g = null;
            this.h = new android.support.v4.g.a();
            this.a = new android.support.b.a.i$c(arg4.a, this.h);
            this.i = new Path(arg4.i);
            this.j = new Path(arg4.j);
            this.b = arg4.b;
            this.c = arg4.c;
            this.d = arg4.d;
            this.e = arg4.e;
            this.p = arg4.p;
            this.f = arg4.f;
            this.g = arg4.g;
            if(arg4.g != null) {
                this.h.put(arg4.g, this);
            }
        }

        private static float a(float arg2, float arg3, float arg4, float arg5) {
            return arg2 * arg5 - arg3 * arg4;
        }

        private float a(Matrix arg13) {
            float v0 = 0f;
            float[] v1 = new float[]{0f, 1f, 1f, 0f};
            arg13.mapVectors(v1);
            float v2 = ((float)Math.hypot(((double)v1[0]), ((double)v1[1])));
            float v3 = ((float)Math.hypot(((double)v1[2]), ((double)v1[3])));
            float v1_1 = e.a(v1[0], v1[1], v1[2], v1[3]);
            v2 = Math.max(v2, v3);
            if(v2 > 0f) {
                v0 = Math.abs(v1_1) / v2;
            }

            return v0;
        }

        static Paint a(e arg1) {
            return arg1.n;
        }

        static Paint a(e arg0, Paint arg1) {
            arg0.n = arg1;
            return arg1;
        }

        private void a(android.support.b.a.i$c arg9, Matrix arg10, Canvas arg11, int arg12, int arg13, ColorFilter arg14) {
            android.support.b.a.i$c.a(arg9).set(arg10);
            android.support.b.a.i$c.a(arg9).preConcat(android.support.b.a.i$c.b(arg9));
            arg11.save();
            int v7;
            for(v7 = 0; v7 < arg9.a.size(); ++v7) {
                Object v1 = arg9.a.get(v7);
                if((v1 instanceof android.support.b.a.i$c)) {
                    this.a(((android.support.b.a.i$c)v1), android.support.b.a.i$c.a(arg9), arg11, arg12, arg13, arg14);
                }
                else if((v1 instanceof d)) {
                    this.a(arg9, v1, arg11, arg12, arg13, arg14);
                }
            }

            arg11.restore();
        }

        private void a(android.support.b.a.i$c arg9, d arg10, Canvas arg11, int arg12, int arg13, ColorFilter arg14) {
            float v0 = (((float)arg12)) / this.d;
            float v1 = (((float)arg13)) / this.e;
            float v2 = Math.min(v0, v1);
            Matrix v3 = android.support.b.a.i$c.a(arg9);
            this.l.set(v3);
            this.l.postScale(v0, v1);
            v1 = this.a(v3);
            if(v1 != 0f) {
                arg10.a(this.i);
                Path v0_1 = this.i;
                this.j.reset();
                if(arg10.a()) {
                    this.j.addPath(v0_1, this.l);
                    arg11.clipPath(this.j);
                }
                else {
                    if(((android.support.b.a.i$b)arg10).g != 0f || ((android.support.b.a.i$b)arg10).h != 1f) {
                        float v3_1 = (((android.support.b.a.i$b)arg10).g + ((android.support.b.a.i$b)arg10).i) % 1f;
                        float v4 = (((android.support.b.a.i$b)arg10).h + ((android.support.b.a.i$b)arg10).i) % 1f;
                        if(this.o == null) {
                            this.o = new PathMeasure();
                        }

                        this.o.setPath(this.i, false);
                        float v5 = this.o.getLength();
                        v3_1 *= v5;
                        v4 *= v5;
                        v0_1.reset();
                        if(v3_1 > v4) {
                            this.o.getSegment(v3_1, v5, v0_1, true);
                            this.o.getSegment(0f, v4, v0_1, true);
                        }
                        else {
                            this.o.getSegment(v3_1, v4, v0_1, true);
                        }

                        v0_1.rLineTo(0f, 0f);
                    }

                    this.j.addPath(v0_1, this.l);
                    if(((android.support.b.a.i$b)arg10).c != 0) {
                        if(this.n == null) {
                            this.n = new Paint();
                            this.n.setStyle(Paint$Style.FILL);
                            this.n.setAntiAlias(true);
                        }

                        Paint v3_2 = this.n;
                        v3_2.setColor(i.a(((android.support.b.a.i$b)arg10).c, ((android.support.b.a.i$b)arg10).f));
                        v3_2.setColorFilter(arg14);
                        Path v4_1 = this.j;
                        Path$FillType v0_2 = ((android.support.b.a.i$b)arg10).e == 0 ? Path$FillType.WINDING : Path$FillType.EVEN_ODD;
                        v4_1.setFillType(v0_2);
                        arg11.drawPath(this.j, v3_2);
                    }

                    if(((android.support.b.a.i$b)arg10).a == 0) {
                        return;
                    }

                    if(this.m == null) {
                        this.m = new Paint();
                        this.m.setStyle(Paint$Style.STROKE);
                        this.m.setAntiAlias(true);
                    }

                    Paint v0_3 = this.m;
                    if(((android.support.b.a.i$b)arg10).k != null) {
                        v0_3.setStrokeJoin(((android.support.b.a.i$b)arg10).k);
                    }

                    if(((android.support.b.a.i$b)arg10).j != null) {
                        v0_3.setStrokeCap(((android.support.b.a.i$b)arg10).j);
                    }

                    v0_3.setStrokeMiter(((android.support.b.a.i$b)arg10).l);
                    v0_3.setColor(i.a(((android.support.b.a.i$b)arg10).a, ((android.support.b.a.i$b)arg10).d));
                    v0_3.setColorFilter(arg14);
                    v0_3.setStrokeWidth(v1 * v2 * ((android.support.b.a.i$b)arg10).b);
                    arg11.drawPath(this.j, v0_3);
                }
            }
        }

        public void a(Canvas arg8, int arg9, int arg10, ColorFilter arg11) {
            this.a(this.a, e.k, arg8, arg9, arg10, arg11);
        }

        static Paint b(e arg1) {
            return arg1.m;
        }

        static Paint b(e arg0, Paint arg1) {
            arg0.m = arg1;
            return arg1;
        }

        public float getAlpha() {
            return (((float)this.getRootAlpha())) / 255f;
        }

        public int getRootAlpha() {
            return this.f;
        }

        public void setAlpha(float arg2) {
            this.setRootAlpha(((int)(255f * arg2)));
        }

        public void setRootAlpha(int arg1) {
            this.f = arg1;
        }
    }

    class f extends Drawable$ConstantState {
        int a;
        e b;
        ColorStateList c;
        PorterDuff$Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff$Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f() {
            super();
            this.c = null;
            this.d = i.a;
            this.b = new e();
        }

        public f(f arg4) {
            super();
            this.c = null;
            this.d = i.a;
            if(arg4 != null) {
                this.a = arg4.a;
                this.b = new e(arg4.b);
                if(e.a(arg4.b) != null) {
                    e.a(this.b, new Paint(e.a(arg4.b)));
                }

                if(e.b(arg4.b) != null) {
                    e.b(this.b, new Paint(e.b(arg4.b)));
                }

                this.c = arg4.c;
                this.d = arg4.d;
                this.e = arg4.e;
            }
        }

        public void a(int arg4, int arg5) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), arg4, arg5, null);
        }

        public void a(Canvas arg4, ColorFilter arg5, Rect arg6) {
            arg4.drawBitmap(this.f, null, arg6, this.a(arg5));
        }

        public Paint a(ColorFilter arg3) {
            Paint v0;
            if((this.a()) || arg3 != null) {
                if(this.l == null) {
                    this.l = new Paint();
                    this.l.setFilterBitmap(true);
                }

                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(arg3);
                v0 = this.l;
            }
            else {
                v0 = null;
            }

            return v0;
        }

        public boolean a() {
            boolean v0 = this.b.getRootAlpha() < 0xFF ? true : false;
            return v0;
        }

        public void b(int arg2, int arg3) {
            if(this.f == null || !this.c(arg2, arg3)) {
                this.f = Bitmap.createBitmap(arg2, arg3, Bitmap$Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            boolean v0 = (this.k) || this.g != this.c || this.h != this.d || this.j != this.e || this.i != this.b.getRootAlpha() ? false : true;
            return v0;
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int arg2, int arg3) {
            boolean v0 = arg2 != this.f.getWidth() || arg3 != this.f.getHeight() ? false : true;
            return v0;
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources arg2) {
            return new i(this);
        }
    }

    class g extends Drawable$ConstantState {
        private final Drawable$ConstantState a;

        public g(Drawable$ConstantState arg1) {
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
            i v1 = new i();
            v1.b = this.a.newDrawable();
            return ((Drawable)v1);
        }

        public Drawable newDrawable(Resources arg3) {
            i v1 = new i();
            v1.b = this.a.newDrawable(arg3);
            return ((Drawable)v1);
        }

        public Drawable newDrawable(Resources arg3, Resources$Theme arg4) {
            i v1 = new i();
            v1.b = this.a.newDrawable(arg3, arg4);
            return ((Drawable)v1);
        }
    }

    static final PorterDuff$Mode a;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable$ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    static {
        i.a = PorterDuff$Mode.SRC_IN;
    }

    i() {
        super();
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    i(f arg4) {
        super();
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = arg4;
        this.d = this.a(this.d, arg4.c, arg4.d);
    }

    Object a(String arg2) {
        return this.c.b.h.get(arg2);
    }

    public static i a(Resources arg5, int arg6, Resources$Theme arg7) {
        int v4 = 2;
        if(Build$VERSION.SDK_INT >= 24) {
            i v0 = new i();
            v0.b = android.support.v4.b.a.b.a(arg5, arg6, arg7);
            v0.h = new g(v0.b.getConstantState());
            return v0;
        }

        try {
            XmlResourceParser v0_3 = arg5.getXml(arg6);
            AttributeSet v1 = Xml.asAttributeSet(((XmlPullParser)v0_3));
            do {
                int v2 = ((XmlPullParser)v0_3).next();
                if(v2 == v4) {
                    break;
                }
            }
            while(v2 != 1);

            if(v2 != v4) {
                throw new XmlPullParserException("No start tag found");
            }

            return i.a(arg5, ((XmlPullParser)v0_3), v1, arg7);
        }
        catch(IOException v0_1) {
            Log.e("VectorDrawableCompat", "parser error", ((Throwable)v0_1));
        }
        catch(XmlPullParserException v0_2) {
            Log.e("VectorDrawableCompat", "parser error", ((Throwable)v0_2));
        }

        return null;
    }

    void a(boolean arg1) {
        this.g = arg1;
    }

    PorterDuffColorFilter a(PorterDuffColorFilter arg3, ColorStateList arg4, PorterDuff$Mode arg5) {
        PorterDuffColorFilter v0 = arg4 == null || arg5 == null ? null : new PorterDuffColorFilter(arg4.getColorForState(this.getState(), 0), arg5);
        return v0;
    }

    static int a(int arg2, float arg3) {
        return (((int)((((float)Color.alpha(arg2))) * arg3))) << 24 | 0xFFFFFF & arg2;
    }

    private static PorterDuff$Mode a(int arg2, PorterDuff$Mode arg3) {
        switch(arg2) {
            case 3: {
                arg3 = PorterDuff$Mode.SRC_OVER;
                break;
            }
            case 5: {
                arg3 = PorterDuff$Mode.SRC_IN;
                break;
            }
            case 9: {
                arg3 = PorterDuff$Mode.SRC_ATOP;
                break;
            }
            case 14: {
                arg3 = PorterDuff$Mode.MULTIPLY;
                break;
            }
            case 15: {
                arg3 = PorterDuff$Mode.SCREEN;
                break;
            }
            case 16: {
                if(Build$VERSION.SDK_INT < 11) {
                    return arg3;
                }

                arg3 = PorterDuff$Mode.ADD;
                break;
            }
        }

        return arg3;
    }

    public static i a(Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
        i v0 = new i();
        v0.inflate(arg1, arg2, arg3, arg4);
        return v0;
    }

    private void a(TypedArray arg7, XmlPullParser arg8) {
        f v0 = this.c;
        e v1 = v0.b;
        v0.d = i.a(c.a(arg7, arg8, "tintMode", 6, -1), PorterDuff$Mode.SRC_IN);
        ColorStateList v2 = arg7.getColorStateList(1);
        if(v2 != null) {
            v0.c = v2;
        }

        v0.e = c.a(arg7, arg8, "autoMirrored", 5, v0.e);
        v1.d = c.a(arg7, arg8, "viewportWidth", 7, v1.d);
        v1.e = c.a(arg7, arg8, "viewportHeight", 8, v1.e);
        if(v1.d <= 0f) {
            throw new XmlPullParserException(arg7.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }

        if(v1.e <= 0f) {
            throw new XmlPullParserException(arg7.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }

        v1.b = arg7.getDimension(3, v1.b);
        v1.c = arg7.getDimension(2, v1.c);
        if(v1.b <= 0f) {
            throw new XmlPullParserException(arg7.getPositionDescription() + "<vector> tag requires width > 0");
        }

        if(v1.c <= 0f) {
            throw new XmlPullParserException(arg7.getPositionDescription() + "<vector> tag requires height > 0");
        }

        v1.setAlpha(c.a(arg7, arg8, "alpha", 4, v1.getAlpha()));
        String v0_1 = arg7.getString(0);
        if(v0_1 != null) {
            v1.g = v0_1;
            v1.h.put(v0_1, v1);
        }
    }

    private boolean a() {
        boolean v0 = true;
        if(Build$VERSION.SDK_INT >= 17) {
            if((this.isAutoMirrored()) && android.support.v4.c.a.a.g(((Drawable)this)) == 1) {
                return v0;
            }

            v0 = false;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public void applyTheme(Resources$Theme arg1) {
        super.applyTheme(arg1);
    }

    private void b(Resources arg11, XmlPullParser arg12, AttributeSet arg13, Resources$Theme arg14) {
        int v9 = 3;
        f v3 = this.c;
        e v4 = v3.b;
        Stack v5 = new Stack();
        v5.push(v4.a);
        int v0 = arg12.getEventType();
        int v6 = arg12.getDepth() + 1;
        int v1 = 1;
        while(v0 != 1) {
            if(arg12.getDepth() < v6 && v0 == v9) {
                break;
            }

            if(v0 == 2) {
                String v7 = arg12.getName();
                Object v0_1 = v5.peek();
                if("path".equals(v7)) {
                    android.support.b.a.i$b v1_1 = new android.support.b.a.i$b();
                    v1_1.a(arg11, arg13, arg14, arg12);
                    ((android.support.b.a.i$c)v0_1).a.add(v1_1);
                    if(v1_1.getPathName() != null) {
                        v4.h.put(v1_1.getPathName(), v1_1);
                    }

                    v0 = 0;
                    v3.a |= v1_1.o;
                }
                else {
                    if("clip-path".equals(v7)) {
                        a v7_1 = new a();
                        v7_1.a(arg11, arg13, arg14, arg12);
                        ((android.support.b.a.i$c)v0_1).a.add(v7_1);
                        if(v7_1.getPathName() != null) {
                            v4.h.put(v7_1.getPathName(), v7_1);
                        }

                        v3.a |= v7_1.o;
                        v0 = v1;
                        goto label_38;
                    }

                    if("group".equals(v7)) {
                        android.support.b.a.i$c v7_2 = new android.support.b.a.i$c();
                        v7_2.a(arg11, arg13, arg14, arg12);
                        ((android.support.b.a.i$c)v0_1).a.add(v7_2);
                        v5.push(v7_2);
                        if(v7_2.getGroupName() != null) {
                            v4.h.put(v7_2.getGroupName(), v7_2);
                        }

                        v3.a |= v7_2.c;
                    }

                    v0 = v1;
                }

            label_38:
                v1 = v0;
            }
            else {
                if(v0 != v9) {
                    goto label_39;
                }

                if(!"group".equals(arg12.getName())) {
                    goto label_39;
                }

                v5.pop();
            }

        label_39:
            v0 = arg12.next();
        }

        if(v1 != 0) {
            StringBuffer v0_2 = new StringBuffer();
            if(v0_2.length() > 0) {
                v0_2.append(" or ");
            }

            v0_2.append("path");
            throw new XmlPullParserException("no " + v0_2 + " defined");
        }
    }

    public boolean canApplyTheme() {
        if(this.b != null) {
            android.support.v4.c.a.a.d(this.b);
        }

        return 0;
    }

    public void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas arg11) {
        PorterDuffColorFilter v0;
        int v9 = 0x800;
        float v2 = 1f;
        if(this.b != null) {
            this.b.draw(arg11);
        }
        else {
            this.copyBounds(this.k);
            if(this.k.width() > 0 && this.k.height() > 0) {
                if(this.e == null) {
                    v0 = this.d;
                }
                else {
                    ColorFilter v0_1 = this.e;
                }

                arg11.getMatrix(this.j);
                this.j.getValues(this.i);
                float v3 = Math.abs(this.i[0]);
                float v1 = Math.abs(this.i[4]);
                float v4 = Math.abs(this.i[1]);
                float v5 = Math.abs(this.i[3]);
                if(v4 != 0f || v5 != 0f) {
                    v1 = v2;
                    v3 = v2;
                }

                int v3_1 = ((int)(v3 * (((float)this.k.width()))));
                int v1_1 = ((int)(v1 * (((float)this.k.height()))));
                v3_1 = Math.min(v9, v3_1);
                v1_1 = Math.min(v9, v1_1);
                if(v3_1 <= 0) {
                    return;
                }

                if(v1_1 <= 0) {
                    return;
                }

                int v4_1 = arg11.save();
                arg11.translate(((float)this.k.left), ((float)this.k.top));
                if(this.a()) {
                    arg11.translate(((float)this.k.width()), 0f);
                    arg11.scale(-1f, v2);
                }

                this.k.offsetTo(0, 0);
                this.c.b(v3_1, v1_1);
                if(!this.g) {
                    this.c.a(v3_1, v1_1);
                }
                else if(!this.c.b()) {
                    this.c.a(v3_1, v1_1);
                    this.c.c();
                }

                this.c.a(arg11, ((ColorFilter)v0), this.k);
                arg11.restoreToCount(v4_1);
            }
        }
    }

    public int getAlpha() {
        int v0 = this.b != null ? android.support.v4.c.a.a.c(this.b) : this.c.b.getRootAlpha();
        return v0;
    }

    public int getChangingConfigurations() {
        int v0 = this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
        return v0;
    }

    public ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public Drawable$ConstantState getConstantState() {
        f v0_1;
        if(this.b == null || Build$VERSION.SDK_INT < 24) {
            this.c.a = this.getChangingConfigurations();
            v0_1 = this.c;
        }
        else {
            g v0 = new g(this.b.getConstantState());
        }

        return ((Drawable$ConstantState)v0_1);
    }

    public Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        int v0 = this.b != null ? this.b.getIntrinsicHeight() : ((int)this.c.b.c);
        return v0;
    }

    public int getIntrinsicWidth() {
        int v0 = this.b != null ? this.b.getIntrinsicWidth() : ((int)this.c.b.b);
        return v0;
    }

    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        int v0 = this.b != null ? this.b.getOpacity() : -3;
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

    public void inflate(Resources arg4, XmlPullParser arg5, AttributeSet arg6, Resources$Theme arg7) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg4, arg5, arg6, arg7);
        }
        else {
            f v0 = this.c;
            v0.b = new e();
            TypedArray v1 = c.a(arg4, arg7, arg6, android.support.b.a.a.a);
            this.a(v1, arg5);
            v1.recycle();
            v0.a = this.getChangingConfigurations();
            v0.k = true;
            this.b(arg4, arg5, arg6, arg7);
            this.d = this.a(this.d, v0.c, v0.d);
        }
    }

    public void inflate(Resources arg2, XmlPullParser arg3, AttributeSet arg4) {
        if(this.b != null) {
            this.b.inflate(arg2, arg3, arg4);
        }
        else {
            this.inflate(arg2, arg3, arg4, null);
        }
    }

    public void invalidateSelf() {
        if(this.b != null) {
            this.b.invalidateSelf();
        }
        else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        boolean v0 = this.b != null ? android.support.v4.c.a.a.b(this.b) : this.c.e;
        return v0;
    }

    public boolean isStateful() {
        boolean v0;
        if(this.b != null) {
            v0 = this.b.isStateful();
        }
        else {
            if(!super.isStateful() && (this.c == null || this.c.c == null || !this.c.c.isStateful())) {
                return false;
            }

            v0 = true;
        }

        return v0;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(this.b != null) {
            this.b.mutate();
        }
        else if(!this.f && super.mutate() == this) {
            this.c = new f(this.c);
            this.f = true;
        }

        return this;
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.b != null) {
            this.b.setBounds(arg2);
        }
    }

    protected boolean onStateChange(int[] arg4) {
        boolean v0;
        if(this.b != null) {
            v0 = this.b.setState(arg4);
        }
        else {
            f v0_1 = this.c;
            if(v0_1.c != null && v0_1.d != null) {
                this.d = this.a(this.d, v0_1.c, v0_1.d);
                this.invalidateSelf();
                return true;
            }

            v0 = false;
        }

        return v0;
    }

    public void scheduleSelf(Runnable arg3, long arg4) {
        if(this.b != null) {
            this.b.scheduleSelf(arg3, arg4);
        }
        else {
            super.scheduleSelf(arg3, arg4);
        }
    }

    public void setAlpha(int arg2) {
        if(this.b != null) {
            this.b.setAlpha(arg2);
        }
        else if(this.c.b.getRootAlpha() != arg2) {
            this.c.b.setRootAlpha(arg2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean arg2) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg2);
        }
        else {
            this.c.e = arg2;
        }
    }

    public void setChangingConfigurations(int arg1) {
        super.setChangingConfigurations(arg1);
    }

    public void setColorFilter(ColorFilter arg2) {
        if(this.b != null) {
            this.b.setColorFilter(arg2);
        }
        else {
            this.e = arg2;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(int arg1, PorterDuff$Mode arg2) {
        super.setColorFilter(arg1, arg2);
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
            this.setTintList(ColorStateList.valueOf(arg2));
        }
    }

    public void setTintList(ColorStateList arg3) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg3);
        }
        else {
            f v0 = this.c;
            if(v0.c != arg3) {
                v0.c = arg3;
                this.d = this.a(this.d, arg3, v0.d);
                this.invalidateSelf();
            }
        }
    }

    public void setTintMode(PorterDuff$Mode arg3) {
        if(this.b != null) {
            android.support.v4.c.a.a.a(this.b, arg3);
        }
        else {
            f v0 = this.c;
            if(v0.d != arg3) {
                v0.d = arg3;
                this.d = this.a(this.d, v0.c, arg3);
                this.invalidateSelf();
            }
        }
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        boolean v0 = this.b != null ? this.b.setVisible(arg2, arg3) : super.setVisible(arg2, arg3);
        return v0;
    }

    public void unscheduleSelf(Runnable arg2) {
        if(this.b != null) {
            this.b.unscheduleSelf(arg2);
        }
        else {
            super.unscheduleSelf(arg2);
        }
    }
}

