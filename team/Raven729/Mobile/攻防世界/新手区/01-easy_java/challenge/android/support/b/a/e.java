package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build$VERSION;
import android.support.v4.b.a.c;
import android.support.v4.c.b$b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {
    class android.support.b.a.e$1 {
    }

    class a implements TypeEvaluator {
        private b[] a;

        a(android.support.b.a.e$1 arg1) {
            this();
        }

        private a() {
            super();
        }

        public b[] a(float arg5, b[] arg6, b[] arg7) {
            if(!android.support.v4.c.b.a(arg6, arg7)) {
                throw new IllegalArgumentException("Can\'t interpolate between two incompatible pathData");
            }

            if(this.a == null || !android.support.v4.c.b.a(this.a, arg6)) {
                this.a = android.support.v4.c.b.a(arg6);
            }

            int v0;
            for(v0 = 0; v0 < arg6.length; ++v0) {
                this.a[v0].a(arg6[v0], arg7[v0], arg5);
            }

            return this.a;
        }

        public Object evaluate(float arg2, Object arg3, Object arg4) {
            return this.a(arg2, ((b[])arg3), ((b[])arg4));
        }
    }

    public static Animator a(Context arg2, int arg3) {
        Animator v0 = Build$VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(arg2, arg3) : e.a(arg2, arg2.getResources(), arg2.getTheme(), arg3);
        return v0;
    }

    private static int a(Resources arg4, Resources$Theme arg5, AttributeSet arg6, XmlPullParser arg7) {
        int v0 = 0;
        TypedArray v2 = c.a(arg4, arg5, arg6, android.support.b.a.a.j);
        TypedValue v3 = c.b(v2, arg7, "value", 0);
        int v1 = v3 != null ? 1 : 0;
        if(v1 != 0 && (e.a(v3.type))) {
            v0 = 3;
        }

        v2.recycle();
        return v0;
    }

    private static boolean a(int arg1) {
        boolean v0 = arg1 < 28 || arg1 > 0x1F ? false : true;
        return v0;
    }

    private static int a(TypedArray arg6, int arg7, int arg8) {
        int v1 = 0;
        TypedValue v0 = arg6.peekValue(arg7);
        int v4 = v0 != null ? 1 : 0;
        int v0_1 = v4 != 0 ? v0.type : 0;
        TypedValue v5 = arg6.peekValue(arg8);
        int v3 = v5 != null ? 1 : 0;
        int v2 = v3 != 0 ? v5.type : 0;
        if(v4 != 0 && (e.a(v0_1)) || v3 != 0 && (e.a(v2))) {
            v1 = 3;
        }

        return v1;
    }

    public static Animator a(Context arg1, Resources arg2, Resources$Theme arg3, int arg4) {
        return e.a(arg1, arg2, arg3, arg4, 1f);
    }

    public static Animator a(Context arg5, Resources arg6, Resources$Theme arg7, int arg8, float arg9) {
        Resources$NotFoundException v2;
        Animator v0_3;
        XmlResourceParser v1;
        try {
            v1 = arg6.getAnimation(arg8);
            v0_3 = e.a(arg5, arg6, arg7, ((XmlPullParser)v1), arg9);
            if(v1 == null) {
                return v0_3;
            }
        }
        catch(Throwable v0) {
        }
        catch(IOException v0_1) {
            try {
                v2 = new Resources$NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(arg8));
                v2.initCause(((Throwable)v0_1));
                throw v2;
            }
            catch(Throwable v0) {
            label_19:
                if(v1 != null) {
                    v1.close();
                }

                throw v0;
            }
        }
        catch(XmlPullParserException v0_2) {
            try {
                v2 = new Resources$NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(arg8));
                v2.initCause(((Throwable)v0_2));
                throw v2;
            }
            catch(Throwable v0) {
                goto label_19;
            }
        }

        v1.close();
        return v0_3;
    }

    private static Animator a(Context arg8, Resources arg9, Resources$Theme arg10, XmlPullParser arg11, float arg12) {
        return e.a(arg8, arg9, arg10, arg11, Xml.asAttributeSet(arg11), null, 0, arg12);
    }

    private static Animator a(Context arg17, Resources arg18, Resources$Theme arg19, XmlPullParser arg20, AttributeSet arg21, AnimatorSet arg22, int arg23, float arg24) {
        Object v5 = null;
        ArrayList v13 = null;
        int v15 = arg20.getDepth();
        while(true) {
            int v4 = arg20.next();
            if((v4 != 3 || arg20.getDepth() > v15) && v4 != 1) {
                if(v4 != 2) {
                    continue;
                }

                String v4_1 = arg20.getName();
                if(v4_1.equals("objectAnimator")) {
                    ObjectAnimator v5_1 = e.a(arg17, arg18, arg19, arg21, arg24, arg20);
                    v4 = 0;
                }
                else if(v4_1.equals("animator")) {
                    ValueAnimator v5_2 = e.a(arg17, arg18, arg19, arg21, null, arg24, arg20);
                    v4 = 0;
                }
                else if(v4_1.equals("set")) {
                    AnimatorSet v12 = new AnimatorSet();
                    TypedArray v16 = c.a(arg18, arg19, arg21, android.support.b.a.a.h);
                    e.a(arg17, arg18, arg19, arg20, arg21, v12, c.a(v16, arg20, "ordering", 0, 0), arg24);
                    v16.recycle();
                    v4 = 0;
                    AnimatorSet v5_3 = v12;
                }
                else if(v4_1.equals("propertyValuesHolder")) {
                    PropertyValuesHolder[] v6 = e.a(arg17, arg18, arg19, arg20, Xml.asAttributeSet(arg20));
                    if(v6 != null && (((ObjectAnimator)v5)) != null && (((((ObjectAnimator)v5)) instanceof ValueAnimator))) {
                        ((ObjectAnimator)v5).setValues(v6);
                    }

                    v4 = 1;
                }
                else {
                    break;
                }

                if(arg22 == null) {
                    continue;
                }

                if(v4 != 0) {
                    continue;
                }

                ArrayList v4_2 = v13 == null ? new ArrayList() : v13;
                v4_2.add(v5);
                v13 = v4_2;
                continue;
            }

            goto label_101;
        }

        throw new RuntimeException("Unknown animator name: " + arg20.getName());
    label_101:
        if(arg22 != null && v13 != null) {
            Animator[] v8 = new Animator[v13.size()];
            Iterator v9 = v13.iterator();
            int v6_1;
            for(v6_1 = 0; v9.hasNext(); ++v6_1) {
                v8[v6_1] = v9.next();
            }

            if(arg23 == 0) {
                arg22.playTogether(v8);
            }
            else {
                arg22.playSequentially(v8);
            }
        }

        return ((Animator)v5);
    }

    private static ObjectAnimator a(Context arg7, Resources arg8, Resources$Theme arg9, AttributeSet arg10, float arg11, XmlPullParser arg12) {
        ObjectAnimator v4 = new ObjectAnimator();
        e.a(arg7, arg8, arg9, arg10, ((ValueAnimator)v4), arg11, arg12);
        return v4;
    }

    private static ValueAnimator a(Context arg4, Resources arg5, Resources$Theme arg6, AttributeSet arg7, ValueAnimator arg8, float arg9, XmlPullParser arg10) {
        TypedArray v0 = c.a(arg5, arg6, arg7, android.support.b.a.a.g);
        TypedArray v1 = c.a(arg5, arg6, arg7, android.support.b.a.a.k);
        if(arg8 == null) {
            arg8 = new ValueAnimator();
        }

        e.a(arg8, v0, v1, arg9, arg10);
        int v2 = c.c(v0, arg10, "interpolator", 0, 0);
        if(v2 > 0) {
            arg8.setInterpolator(d.a(arg4, v2));
        }

        v0.recycle();
        if(v1 != null) {
            v1.recycle();
        }

        return arg8;
    }

    private static PropertyValuesHolder[] a(Context arg8, Resources arg9, Resources$Theme arg10, XmlPullParser arg11, AttributeSet arg12) {
        ArrayList v0_2;
        ArrayList v6 = null;
        while(true) {
            int v0 = arg11.getEventType();
            if(v0 != 3 && v0 != 1) {
                if(v0 != 2) {
                    arg11.next();
                }
                else {
                    if(arg11.getName().equals("propertyValuesHolder")) {
                        TypedArray v7 = c.a(arg9, arg10, arg12, android.support.b.a.a.i);
                        String v4 = c.a(v7, arg11, "propertyName", 3);
                        int v5 = c.a(v7, arg11, "valueType", 2, 4);
                        PropertyValuesHolder v0_1 = e.a(arg8, arg9, arg10, arg11, v4, v5);
                        PropertyValuesHolder v1 = v0_1 == null ? e.a(v7, v5, 0, 1, v4) : v0_1;
                        if(v1 != null) {
                            v0_2 = v6 == null ? new ArrayList() : v6;
                            v0_2.add(v1);
                        }
                        else {
                            v0_2 = v6;
                        }

                        v7.recycle();
                    }
                    else {
                        v0_2 = v6;
                    }

                    arg11.next();
                    v6 = v0_2;
                }

                continue;
            }

            break;
        }

        PropertyValuesHolder[] v0_3 = null;
        if(v6 != null) {
            int v3 = v6.size();
            PropertyValuesHolder[] v1_1 = new PropertyValuesHolder[v3];
            int v2;
            for(v2 = 0; v2 < v3; ++v2) {
                v1_1[v2] = v6.get(v2);
            }

            v0_3 = v1_1;
        }

        return v0_3;
    }

    private static Keyframe a(Keyframe arg2, float arg3) {
        Keyframe v0;
        if(arg2.getType() == Float.TYPE) {
            v0 = Keyframe.ofFloat(arg3);
        }
        else if(arg2.getType() == Integer.TYPE) {
            v0 = Keyframe.ofInt(arg3);
        }
        else {
            v0 = Keyframe.ofObject(arg3);
        }

        return v0;
    }

    private static Keyframe a(Context arg9, Resources arg10, Resources$Theme arg11, AttributeSet arg12, int arg13, XmlPullParser arg14) {
        int v1 = 3;
        TypedArray v5 = c.a(arg10, arg11, arg12, android.support.b.a.a.j);
        Keyframe v0 = null;
        float v6 = c.a(v5, arg14, "fraction", v1, -1f);
        TypedValue v7 = c.b(v5, arg14, "value", 0);
        int v3 = v7 != null ? 1 : 0;
        if(arg13 == 4) {
            if(v3 != 0 && (e.a(v7.type))) {
                arg13 = v1;
                goto label_20;
            }

            arg13 = 0;
        }

    label_20:
        if(v3 != 0) {
            switch(arg13) {
                case 0: {
                    goto label_33;
                }
                case 1: 
                case 3: {
                    goto label_38;
                }
            }

            goto label_22;
        label_33:
            v0 = Keyframe.ofFloat(v6, c.a(v5, arg14, "value", 0, 0f));
            goto label_22;
        label_38:
            v0 = Keyframe.ofInt(v6, c.a(v5, arg14, "value", 0, 0));
        }
        else if(arg13 == 0) {
            v0 = Keyframe.ofFloat(v6);
        }
        else {
            v0 = Keyframe.ofInt(v6);
        }

    label_22:
        v1 = c.c(v5, arg14, "interpolator", 1, 0);
        if(v1 > 0) {
            v0.setInterpolator(d.a(arg9, v1));
        }

        v5.recycle();
        return v0;
    }

    private static PropertyValuesHolder a(Context arg9, Resources arg10, Resources$Theme arg11, XmlPullParser arg12, String arg13, int arg14) {
        PropertyValuesHolder v0_3;
        int v3_1;
        Keyframe[] v5;
        int v1_2;
        int v2;
        ArrayList v0_1;
        int v0;
        PropertyValuesHolder v7 = null;
        ArrayList v6 = null;
        int v4 = arg14;
        while(true) {
            v0 = arg12.next();
            if(v0 != 3 && v0 != 1) {
                if(arg12.getName().equals("keyframe")) {
                    if(v4 == 4) {
                        v4 = e.a(arg10, arg11, Xml.asAttributeSet(arg12), arg12);
                    }

                    Keyframe v1 = e.a(arg9, arg10, arg11, Xml.asAttributeSet(arg12), v4, arg12);
                    if(v1 != null) {
                        v0_1 = v6 == null ? new ArrayList() : v6;
                        v0_1.add(v1);
                    }
                    else {
                        v0_1 = v6;
                    }

                    arg12.next();
                }
                else {
                    v0_1 = v6;
                }

                v6 = v0_1;
                continue;
            }

            break;
        }

        if(v6 != null) {
            v2 = v6.size();
            if(v2 > 0) {
                Object v0_2 = v6.get(0);
                Object v1_1 = v6.get(v2 - 1);
                float v3 = ((Keyframe)v1_1).getFraction();
                if(v3 >= 1f) {
                    v1_2 = v2;
                }
                else if(v3 < 0f) {
                    ((Keyframe)v1_1).setFraction(1f);
                    v1_2 = v2;
                }
                else {
                    v6.add(v6.size(), e.a(((Keyframe)v1_1), 1f));
                    v1_2 = v2 + 1;
                }

                float v2_1 = ((Keyframe)v0_2).getFraction();
                if(v2_1 != 0f) {
                    if(v2_1 < 0f) {
                        ((Keyframe)v0_2).setFraction(0f);
                    }
                    else {
                        v6.add(0, e.a(((Keyframe)v0_2), 0f));
                        ++v1_2;
                    }
                }

                v5 = new Keyframe[v1_2];
                v6.toArray(((Object[])v5));
                v3_1 = 0;
                goto label_55;
            }
            else {
                goto label_112;
            }
        }
        else {
        label_112:
            v0_3 = v7;
            return v0_3;
        label_55:
            while(v3_1 < v1_2) {
                Keyframe v0_4 = v5[v3_1];
                if(v0_4.getFraction() < 0f) {
                    if(v3_1 == 0) {
                        v0_4.setFraction(0f);
                    }
                    else if(v3_1 == v1_2 - 1) {
                        v0_4.setFraction(1f);
                    }
                    else {
                        v0 = v3_1 + 1;
                        v2 = v3_1;
                        while(v0 < v1_2 - 1) {
                            if(v5[v0].getFraction() >= 0f) {
                                break;
                            }

                            v2 = v0;
                            ++v0;
                        }

                        e.a(v5, v5[v2 + 1].getFraction() - v5[v3_1 - 1].getFraction(), v3_1, v2);
                    }
                }

                ++v3_1;
            }

            v0_3 = PropertyValuesHolder.ofKeyframe(arg13, v5);
            if(v4 != 3) {
                return v0_3;
            }

            v0_3.setEvaluator(f.a());
        }

        return v0_3;
    }

    private static void a(Keyframe[] arg3, float arg4, int arg5, int arg6) {
        float v0 = arg4 / (((float)(arg6 - arg5 + 2)));
        while(arg5 <= arg6) {
            arg3[arg5].setFraction(arg3[arg5 - 1].getFraction() + v0);
            ++arg5;
        }
    }

    private static PropertyValuesHolder a(TypedArray arg8, int arg9, int arg10, int arg11, String arg12) {
        float v0_3;
        int v1_4;
        PropertyValuesHolder v0_2;
        TypedValue v1 = arg8.peekValue(arg10);
        int v6 = v1 != null ? 1 : 0;
        int v0 = v6 != 0 ? v1.type : 0;
        TypedValue v2 = arg8.peekValue(arg11);
        int v5 = v2 != null ? 1 : 0;
        int v4 = v5 != 0 ? v2.type : 0;
        if(arg9 == 4) {
            if(v6 != 0 && (e.a(v0)) || v5 != 0 && (e.a(v4))) {
                arg9 = 3;
                goto label_22;
            }

            arg9 = 0;
        }

    label_22:
        int v3 = arg9 == 0 ? 1 : 0;
        PropertyValuesHolder v1_1 = null;
        if(arg9 == 2) {
            String v0_1 = arg8.getString(arg10);
            String v2_1 = arg8.getString(arg11);
            b[] v3_1 = android.support.v4.c.b.b(v0_1);
            b[] v4_1 = android.support.v4.c.b.b(v2_1);
            if(v3_1 != null || v4_1 != null) {
                if(v3_1 != null) {
                    a v1_2 = new a(null);
                    if(v4_1 == null) {
                        return PropertyValuesHolder.ofObject(arg12, ((TypeEvaluator)v1_2), new Object[]{v3_1});
                    }
                    else if(!android.support.v4.c.b.a(v3_1, v4_1)) {
                        throw new InflateException(" Can\'t morph from " + v0_1 + " to " + v2_1);
                    }
                    else {
                        v0_2 = PropertyValuesHolder.ofObject(arg12, ((TypeEvaluator)v1_2), new Object[]{v3_1, v4_1});
                        return v0_2;
                    }
                }
                else if(v4_1 != null) {
                    return PropertyValuesHolder.ofObject(arg12, new a(null), new Object[]{v4_1});
                }
            }

            v0_2 = v1_1;
        }
        else {
            f v2_2 = null;
            if(arg9 == 3) {
                v2_2 = f.a();
            }

            if(v3 == 0) {
                if(v6 != 0) {
                    if(v0 == 5) {
                        v1_4 = ((int)arg8.getDimension(arg10, 0f));
                    }
                    else if(e.a(v0)) {
                        v1_4 = arg8.getColor(arg10, 0);
                    }
                    else {
                        v1_4 = arg8.getInt(arg10, 0);
                    }

                    if(v5 != 0) {
                        if(v4 == 5) {
                            v0 = ((int)arg8.getDimension(arg11, 0f));
                        }
                        else if(e.a(v4)) {
                            v0 = arg8.getColor(arg11, 0);
                        }
                        else {
                            v0 = arg8.getInt(arg11, 0);
                        }

                        v0_2 = PropertyValuesHolder.ofInt(arg12, new int[]{v1_4, v0});
                        goto label_116;
                    }

                    v0_2 = PropertyValuesHolder.ofInt(arg12, new int[]{v1_4});
                    goto label_116;
                }

                if(v5 != 0) {
                    if(v4 == 5) {
                        v0 = ((int)arg8.getDimension(arg11, 0f));
                    }
                    else if(e.a(v4)) {
                        v0 = arg8.getColor(arg11, 0);
                    }
                    else {
                        v0 = arg8.getInt(arg11, 0);
                    }

                    v0_2 = PropertyValuesHolder.ofInt(arg12, new int[]{v0});
                    goto label_116;
                }

                v0_2 = v1_1;
            }
            else if(v6 != 0) {
                float v1_3 = v0 == 5 ? arg8.getDimension(arg10, 0f) : arg8.getFloat(arg10, 0f);
                if(v5 != 0) {
                    v0_3 = v4 == 5 ? arg8.getDimension(arg11, 0f) : arg8.getFloat(arg11, 0f);
                    v0_2 = PropertyValuesHolder.ofFloat(arg12, new float[]{v1_3, v0_3});
                    goto label_116;
                }

                v0_2 = PropertyValuesHolder.ofFloat(arg12, new float[]{v1_3});
            }
            else {
                v0_3 = v4 == 5 ? arg8.getDimension(arg11, 0f) : arg8.getFloat(arg11, 0f);
                v0_2 = PropertyValuesHolder.ofFloat(arg12, new float[]{v0_3});
            }

        label_116:
            if(v0_2 == null) {
                return v0_2;
            }

            if(v2_2 == null) {
                return v0_2;
            }

            v0_2.setEvaluator(((TypeEvaluator)v2_2));
        }

        return v0_2;
    }

    private static void a(ValueAnimator arg11, TypedArray arg12, TypedArray arg13, float arg14, XmlPullParser arg15) {
        int v10 = 6;
        int v6 = 5;
        int v9 = 4;
        long v2 = ((long)c.a(arg12, arg15, "duration", 1, 300));
        long v4 = ((long)c.a(arg12, arg15, "startOffset", 2, 0));
        int v0 = c.a(arg12, arg15, "valueType", 7, v9);
        if((c.a(arg15, "valueFrom")) && (c.a(arg15, "valueTo"))) {
            if(v0 == v9) {
                v0 = e.a(arg12, v6, v10);
            }

            PropertyValuesHolder v1 = e.a(arg12, v0, v6, v10, "");
            if(v1 == null) {
                goto label_30;
            }

            arg11.setValues(new PropertyValuesHolder[]{v1});
        }

    label_30:
        arg11.setDuration(v2);
        arg11.setStartDelay(v4);
        arg11.setRepeatCount(c.a(arg12, arg15, "repeatCount", 3, 0));
        arg11.setRepeatMode(c.a(arg12, arg15, "repeatMode", v9, 1));
        if(arg13 != null) {
            e.a(arg11, arg13, v0, arg14, arg15);
        }
    }

    private static void a(ValueAnimator arg5, TypedArray arg6, int arg7, float arg8, XmlPullParser arg9) {
        int v4 = 2;
        String v0 = c.a(arg6, arg9, "pathData", 1);
        if(v0 != null) {
            String v1 = c.a(arg6, arg9, "propertyXName", v4);
            String v2 = c.a(arg6, arg9, "propertyYName", 3);
            if(v1 == null && v2 == null) {
                throw new InflateException(arg6.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }

            e.a(android.support.v4.c.b.a(v0), ((ObjectAnimator)arg5), 0.5f * arg8, v1, v2);
        }
        else {
            ((ObjectAnimator)arg5).setPropertyName(c.a(arg6, arg9, "propertyName", 0));
        }
    }

    private static void a(Path arg13, ObjectAnimator arg14, float arg15, String arg16, String arg17) {
        int v2_2;
        PathMeasure v2 = new PathMeasure(arg13, false);
        float v1 = 0f;
        ArrayList v5 = new ArrayList();
        v5.add(Float.valueOf(0f));
        do {
            v1 += v2.getLength();
            v5.add(Float.valueOf(v1));
        }
        while(v2.nextContour());

        PathMeasure v6 = new PathMeasure(arg13, false);
        int v7 = Math.min(100, (((int)(v1 / arg15))) + 1);
        float[] v8 = new float[v7];
        float[] v9 = new float[v7];
        float[] v10 = new float[2];
        int v3 = 0;
        float v11 = v1 / (((float)(v7 - 1)));
        int v4 = 0;
        v1 = 0f;
        while(v4 < v7) {
            v6.getPosTan(v1, v10, null);
            v6.getPosTan(v1, v10, null);
            v8[v4] = v10[0];
            v9[v4] = v10[1];
            float v2_1 = v1 + v11;
            if(v3 + 1 >= v5.size() || v2_1 <= v5.get(v3 + 1).floatValue()) {
                v1 = v2_1;
                v2_2 = v3;
            }
            else {
                v1 = v2_1 - v5.get(v3 + 1).floatValue();
                v2_2 = v3 + 1;
                v6.nextContour();
            }

            ++v4;
            v3 = v2_2;
        }

        PropertyValuesHolder v2_3 = null;
        PropertyValuesHolder v1_1 = null;
        if(arg16 != null) {
            v2_3 = PropertyValuesHolder.ofFloat(arg16, v8);
        }

        if(arg17 != null) {
            v1_1 = PropertyValuesHolder.ofFloat(arg17, v9);
        }

        if(v2_3 == null) {
            arg14.setValues(new PropertyValuesHolder[]{v1_1});
        }
        else if(v1_1 == null) {
            arg14.setValues(new PropertyValuesHolder[]{v2_3});
        }
        else {
            arg14.setValues(new PropertyValuesHolder[]{v2_3, v1_1});
        }
    }
}

