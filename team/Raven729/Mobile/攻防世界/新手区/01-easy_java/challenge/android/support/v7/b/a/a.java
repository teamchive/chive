package android.support.v7.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.a.a$j;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class a {
    private static int a(int arg1, float arg2) {
        return android.support.v4.c.a.b(arg1, Math.round((((float)Color.alpha(arg1))) * arg2));
    }

    public static ColorStateList a(Resources arg4, XmlPullParser arg5, Resources$Theme arg6) {
        int v3 = 2;
        AttributeSet v0 = Xml.asAttributeSet(arg5);
        do {
            int v1 = arg5.next();
            if(v1 == v3) {
                break;
            }
        }
        while(v1 != 1);

        if(v1 != v3) {
            throw new XmlPullParserException("No start tag found");
        }

        return a.a(arg4, arg5, v0, arg6);
    }

    private static ColorStateList a(Resources arg4, XmlPullParser arg5, AttributeSet arg6, Resources$Theme arg7) {
        String v0 = arg5.getName();
        if(!v0.equals("selector")) {
            throw new XmlPullParserException(arg5.getPositionDescription() + ": invalid color state list tag " + v0);
        }

        return a.b(arg4, arg5, arg6, arg7);
    }

    private static TypedArray a(Resources arg1, Resources$Theme arg2, AttributeSet arg3, int[] arg4) {
        TypedArray v0 = arg2 == null ? arg1.obtainAttributes(arg3, arg4) : arg2.obtainStyledAttributes(arg3, arg4, 0, 0);
        return v0;
    }

    private static ColorStateList b(Resources arg17, XmlPullParser arg18, AttributeSet arg19, Resources$Theme arg20) {
        int v7;
        int v11 = arg18.getDepth() + 1;
        int[][] v5 = new int[20][];
        int[][] v6 = v5;
        int v4 = 0;
        int[] v3 = new int[v5.length];
        do {
        label_11:
            int v5_1 = arg18.next();
            if(v5_1 != 1) {
                v7 = arg18.getDepth();
                if(v7 < v11 && v5_1 == 3) {
                    goto label_83;
                }

                if(v5_1 != 2) {
                    continue;
                }

                if(v7 > v11) {
                    continue;
                }

                if(!arg18.getName().equals("item")) {
                    continue;
                }

                break;
            }

            goto label_83;
        }
        while(true);

        TypedArray v7_1 = a.a(arg17, arg20, arg19, j.ColorStateListItem);
        int v12 = v7_1.getColor(j.ColorStateListItem_android_color, 0xFFFF00FF);
        float v5_2 = 1f;
        if(v7_1.hasValue(j.ColorStateListItem_android_alpha)) {
            v5_2 = v7_1.getFloat(j.ColorStateListItem_android_alpha, v5_2);
        }
        else if(v7_1.hasValue(j.ColorStateListItem_alpha)) {
            v5_2 = v7_1.getFloat(j.ColorStateListItem_alpha, v5_2);
        }

        v7_1.recycle();
        int v9 = 0;
        int v13 = arg19.getAttributeCount();
        int[] v14 = new int[v13];
        int v10 = 0;
        goto label_45;
    label_83:
        int[] v5_3 = new int[v4];
        int[][] v7_2 = new int[v4][];
        System.arraycopy(v3, 0, v5_3, 0, v4);
        System.arraycopy(v6, 0, v7_2, 0, v4);
        return new ColorStateList(v7_2, v5_3);
    label_45:
        while(v10 < v13) {
            v7 = arg19.getAttributeNameResource(v10);
            if(v7 == 0x10101A5 || v7 == 0x101031F || v7 == android.support.v7.a.a$a.alpha) {
                v7 = v9;
            }
            else {
                int v8 = v9 + 1;
                if(!arg19.getAttributeBooleanValue(v10, false)) {
                    v7 = -v7;
                }

                v14[v9] = v7;
                v7 = v8;
            }

            ++v10;
            v9 = v7;
        }

        int[] v7_3 = StateSet.trimStateSet(v14, v9);
        v5_3 = c.a(v3, v4, a.a(v12, v5_2));
        Object[] v3_1 = c.a(((Object[])v6), v4, v7_3);
        ++v4;
        Object[] v6_1 = v3_1;
        v3 = v5_3;
        goto label_11;
    }
}

