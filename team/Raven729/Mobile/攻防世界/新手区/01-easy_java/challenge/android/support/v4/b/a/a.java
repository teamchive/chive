package android.support.v4.b.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {
    public interface android.support.v4.b.a.a$a {
    }

    public final class b implements android.support.v4.b.a.a$a {
        private final c[] a;

        public b(c[] arg1) {
            super();
            this.a = arg1;
        }

        public c[] a() {
            return this.a;
        }
    }

    public final class c {
        private final String a;
        private int b;
        private boolean c;
        private int d;

        public c(String arg1, int arg2, boolean arg3, int arg4) {
            super();
            this.a = arg1;
            this.b = arg2;
            this.c = arg3;
            this.d = arg4;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }
    }

    public final class d implements android.support.v4.b.a.a$a {
        private final android.support.v4.f.a a;
        private final int b;
        private final int c;

        public d(android.support.v4.f.a arg1, int arg2, int arg3) {
            super();
            this.a = arg1;
            this.c = arg2;
            this.b = arg3;
        }

        public android.support.v4.f.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    public static android.support.v4.b.a.a$a a(XmlPullParser arg3, Resources arg4) {
        int v2 = 2;
        do {
            int v0 = arg3.next();
            if(v0 == v2) {
                break;
            }
        }
        while(v0 != 1);

        if(v0 != v2) {
            throw new XmlPullParserException("No start tag found");
        }

        return a.b(arg3, arg4);
    }

    public static List a(Resources arg5, int arg6) {
        ArrayList v0 = null;
        if(arg6 != 0) {
            TypedArray v3 = arg5.obtainTypedArray(arg6);
            if(v3.length() > 0) {
                ArrayList v2 = new ArrayList();
                int v0_1 = v3.getResourceId(0, 0) != 0 ? 1 : 0;
                if(v0_1 != 0) {
                    for(v0_1 = 0; v0_1 < v3.length(); ++v0_1) {
                        ((List)v2).add(a.a(arg5.getStringArray(v3.getResourceId(v0_1, 0))));
                    }

                    v0 = v2;
                    goto label_24;
                }

                ((List)v2).add(a.a(arg5.getStringArray(arg6)));
                v0 = v2;
            }

        label_24:
            v3.recycle();
        }

        if(v0 == null) {
            List v0_2 = Collections.emptyList();
        }

        return ((List)v0);
    }

    private static List a(String[] arg5) {
        ArrayList v2 = new ArrayList();
        int v3 = arg5.length;
        int v0;
        for(v0 = 0; v0 < v3; ++v0) {
            ((List)v2).add(Base64.decode(arg5[v0], 0));
        }

        return ((List)v2);
    }

    private static void a(XmlPullParser arg2) {
        int v0;
        for(v0 = 1; v0 > 0; --v0) {
            switch(arg2.next()) {
                case 2: {
                    goto label_5;
                }
                case 3: {
                    goto label_7;
                }
            }

            continue;
        label_5:
            ++v0;
            continue;
        label_7:
        }
    }

    private static android.support.v4.b.a.a$a b(XmlPullParser arg3, Resources arg4) {
        android.support.v4.b.a.a$a v0_1;
        String v0 = null;
        arg3.require(2, v0, "font-family");
        if(arg3.getName().equals("font-family")) {
            v0_1 = a.c(arg3, arg4);
        }
        else {
            a.a(arg3);
        }

        return v0_1;
    }

    private static android.support.v4.b.a.a$a c(XmlPullParser arg9, Resources arg10) {
        d v0_1;
        int v8 = 3;
        TypedArray v0 = arg10.obtainAttributes(Xml.asAttributeSet(arg9), android.support.a.a$a.FontFamily);
        String v1 = v0.getString(android.support.a.a$a.FontFamily_fontProviderAuthority);
        String v2 = v0.getString(android.support.a.a$a.FontFamily_fontProviderPackage);
        String v3 = v0.getString(android.support.a.a$a.FontFamily_fontProviderQuery);
        int v4 = v0.getResourceId(android.support.a.a$a.FontFamily_fontProviderCerts, 0);
        int v5 = v0.getInteger(android.support.a.a$a.FontFamily_fontProviderFetchStrategy, 1);
        int v6 = v0.getInteger(android.support.a.a$a.FontFamily_fontProviderFetchTimeout, 500);
        v0.recycle();
        if(v1 == null || v2 == null) {
        label_33:
            ArrayList v0_2 = new ArrayList();
            while(arg9.next() != v8) {
                if(arg9.getEventType() != 2) {
                    continue;
                }

                if(arg9.getName().equals("font")) {
                    ((List)v0_2).add(a.d(arg9, arg10));
                    continue;
                }

                a.a(arg9);
            }

            if(((List)v0_2).isEmpty()) {
                android.support.v4.b.a.a$a v0_3 = null;
                goto label_32;
            }

            b v0_4 = new b(((List)v0_2).toArray(new c[((List)v0_2).size()]));
        }
        else {
            if(v3 == null) {
                goto label_33;
            }

            while(arg9.next() != v8) {
                a.a(arg9);
            }

            v0_1 = new d(new android.support.v4.f.a(v1, v2, v3, a.a(arg10, v4)), v5, v6);
        }

    label_32:
        return ((android.support.v4.b.a.a$a)v0_1);
    }

    private static c d(XmlPullParser arg6, Resources arg7) {
        boolean v0 = true;
        TypedArray v2 = arg7.obtainAttributes(Xml.asAttributeSet(arg6), android.support.a.a$a.FontFamilyFont);
        int v3 = v2.getInt(android.support.a.a$a.FontFamilyFont_fontWeight, 400);
        if(1 != v2.getInt(android.support.a.a$a.FontFamilyFont_fontStyle, 0)) {
            v0 = false;
        }

        int v1 = v2.getResourceId(android.support.a.a$a.FontFamilyFont_font, 0);
        String v4 = v2.getString(android.support.a.a$a.FontFamilyFont_font);
        v2.recycle();
        while(arg6.next() != 3) {
            a.a(arg6);
        }

        return new c(v4, v3, v0, v1);
    }
}

