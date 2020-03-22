package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e extends DataSetObservable {
    public final class a implements Comparable {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo arg1) {
            super();
            this.a = arg1;
        }

        public int a(a arg3) {
            return Float.floatToIntBits(arg3.b) - Float.floatToIntBits(this.b);
        }

        public int compareTo(Object arg2) {
            return this.a(((a)arg2));
        }

        public boolean equals(Object arg5) {
            boolean v0 = true;
            if(this != (((a)arg5))) {
                if(arg5 == null) {
                    v0 = false;
                }
                else if(this.getClass() != arg5.getClass()) {
                    v0 = false;
                }
                else if(Float.floatToIntBits(this.b) != Float.floatToIntBits(((a)arg5).b)) {
                    v0 = false;
                }
            }

            return v0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 0x1F;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder();
            v0.append("[");
            v0.append("resolveInfo:").append(this.a.toString());
            v0.append("; weight:").append(new BigDecimal(((double)this.b)));
            v0.append("]");
            return v0.toString();
        }
    }

    public interface b {
        void a(Intent arg1, List arg2, List arg3);
    }

    public final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(String arg3, long arg4, float arg6) {
            this(ComponentName.unflattenFromString(arg3), arg4, arg6);
        }

        public c(ComponentName arg1, long arg2, float arg4) {
            super();
            this.a = arg1;
            this.b = arg2;
            this.c = arg4;
        }

        public boolean equals(Object arg7) {
            boolean v0 = true;
            if(this != (((c)arg7))) {
                if(arg7 == null) {
                    v0 = false;
                }
                else if(this.getClass() != arg7.getClass()) {
                    v0 = false;
                }
                else {
                    if(this.a == null) {
                        if(((c)arg7).a != null) {
                            return false;
                        }
                    }
                    else if(!this.a.equals(((c)arg7).a)) {
                        return false;
                    }

                    if(this.b != ((c)arg7).b) {
                        return false;
                    }

                    if(Float.floatToIntBits(this.c) == Float.floatToIntBits(((c)arg7).c)) {
                        return v0;
                    }

                    v0 = false;
                }
            }

            return v0;
        }

        public int hashCode() {
            int v0 = this.a == null ? 0 : this.a.hashCode();
            return ((v0 + 0x1F) * 0x1F + (((int)(this.b ^ this.b >>> 0x20)))) * 0x1F + Float.floatToIntBits(this.c);
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder();
            v0.append("[");
            v0.append("; activity:").append(this.a);
            v0.append("; time:").append(this.b);
            v0.append("; weight:").append(new BigDecimal(((double)this.c)));
            v0.append("]");
            return v0.toString();
        }
    }

    public interface d {
        boolean a(e arg1, Intent arg2);
    }

    final class android.support.v7.widget.e$e extends AsyncTask {
        android.support.v7.widget.e$e(e arg1) {
            this.a = arg1;
            super();
        }

        public Void a(Object[] arg13) {
            FileOutputStream v3;
            int v2 = 0;
            Void v10 = null;
            Object v0 = arg13[0];
            Object v1 = arg13[1];
            try {
                v3 = this.a.b.openFileOutput(((String)v1), 0);
            }
            catch(FileNotFoundException v0_1) {
                Log.e(e.a, "Error writing historical record file: " + (((String)v1)), ((Throwable)v0_1));
                return v10;
            }

            XmlSerializer v4 = Xml.newSerializer();
            String v1_1 = null;
            try {
                v4.setOutput(((OutputStream)v3), v1_1);
                v4.startDocument("UTF-8", Boolean.valueOf(true));
                v4.startTag(null, "historical-records");
                int v5 = ((List)v0).size();
                while(v2 < v5) {
                    v1 = ((List)v0).remove(0);
                    v4.startTag(null, "historical-record");
                    v4.attribute(null, "activity", ((c)v1).a.flattenToString());
                    v4.attribute(null, "time", String.valueOf(((c)v1).b));
                    v4.attribute(null, "weight", String.valueOf(((c)v1).c));
                    v4.endTag(null, "historical-record");
                    ++v2;
                }
            }
            catch(IllegalArgumentException v0_2) {
                goto label_69;
            }
            catch(IllegalStateException v0_3) {
                goto label_87;
            }
            catch(IOException v0_4) {
                goto label_105;
            }
            catch(Throwable v0_5) {
                goto label_124;
            }

            String v0_6 = null;
            try {
                v4.endTag(v0_6, "historical-records");
                v4.endDocument();
            }
            catch(IllegalArgumentException v0_2) {
                goto label_69;
            }
            catch(IllegalStateException v0_3) {
                goto label_87;
            }
            catch(IOException v0_4) {
                goto label_105;
            }
            catch(Throwable v0_5) {
                goto label_124;
            }

            this.a.d = true;
            if(v3 == null) {
                return v10;
            }

            try {
                v3.close();
            }
            catch(IOException v0_4) {
            }

            return v10;
            try {
            label_69:
                Log.e(e.a, "Error writing historical record file: " + this.a.c, ((Throwable)v0_2));
            }
            catch(Throwable v0_5) {
                goto label_124;
            }

            this.a.d = true;
            if(v3 == null) {
                return v10;
            }

            try {
                v3.close();
            }
            catch(IOException v0_4) {
            }

            return v10;
            try {
            label_87:
                Log.e(e.a, "Error writing historical record file: " + this.a.c, ((Throwable)v0_3));
            }
            catch(Throwable v0_5) {
                goto label_124;
            }

            this.a.d = true;
            if(v3 == null) {
                return v10;
            }

            try {
                v3.close();
            }
            catch(IOException v0_4) {
            }

            return v10;
            try {
            label_105:
                Log.e(e.a, "Error writing historical record file: " + this.a.c, ((Throwable)v0_4));
            }
            catch(Throwable v0_5) {
                goto label_124;
            }

            this.a.d = true;
            if(v3 != null) {
                try {
                    v3.close();
                }
                catch(IOException v0_4) {
                }
            }

            return v10;
        label_124:
            this.a.d = true;
            if(v3 != null) {
                try {
                    v3.close();
                }
                catch(IOException v1_2) {
                }
            }

            throw v0_5;
        }

        public Object doInBackground(Object[] arg2) {
            return this.a(arg2);
        }
    }

    static final String a;
    final Context b;
    final String c;
    boolean d;
    private static final Object e;
    private static final Map f;
    private final Object g;
    private final List h;
    private final List i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    static {
        e.a = e.class.getSimpleName();
        e.e = new Object();
        e.f = new HashMap();
    }

    public int a() {
        Object v1 = this.g;
        __monitor_enter(v1);
        try {
            this.d();
            __monitor_exit(v1);
            return this.h.size();
        label_8:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_8;
        }

        throw v0;
    }

    public ResolveInfo a(int arg3) {
        Object v1 = this.g;
        __monitor_enter(v1);
        try {
            this.d();
            __monitor_exit(v1);
            return this.h.get(arg3).a;
        label_9:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_9;
        }

        throw v0;
    }

    public int a(ResolveInfo arg6) {
        int v0_1;
        Object v2 = this.g;
        __monitor_enter(v2);
        try {
            this.d();
            List v3 = this.h;
            int v4 = v3.size();
            int v1 = 0;
            while(true) {
                if(v1 >= v4) {
                    break;
                }
                else if(v3.get(v1).a == arg6) {
                    __monitor_exit(v2);
                    v0_1 = v1;
                }
                else {
                    ++v1;
                    continue;
                }

                return v0_1;
            }

            v0_1 = -1;
            __monitor_exit(v2);
            return v0_1;
        label_19:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_19;
        }

        throw v0;
    }

    private boolean a(c arg3) {
        boolean v0 = this.i.add(arg3);
        if(v0) {
            this.n = true;
            this.h();
            this.c();
            this.e();
            this.notifyChanged();
        }

        return v0;
    }

    public ResolveInfo b() {
        ResolveInfo v0_1;
        Object v1 = this.g;
        __monitor_enter(v1);
        try {
            this.d();
            if(!this.h.isEmpty()) {
                v0_1 = this.h.get(0).a;
                __monitor_exit(v1);
            }
            else {
                __monitor_exit(v1);
                v0_1 = null;
            }

            return v0_1;
        label_16:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_16;
        }

        throw v0;
    }

    public Intent b(int arg8) {
        Intent v0_1;
        Intent v1 = null;
        Object v2 = this.g;
        __monitor_enter(v2);
        try {
            if(this.j == null) {
                __monitor_exit(v2);
                v0_1 = v1;
            }
            else {
                this.d();
                Object v0_2 = this.h.get(arg8);
                ComponentName v3 = new ComponentName(((a)v0_2).a.activityInfo.packageName, ((a)v0_2).a.activityInfo.name);
                v0_1 = new Intent(this.j);
                v0_1.setComponent(v3);
                if(this.p != null && (this.p.a(this, new Intent(v0_1)))) {
                    __monitor_exit(v2);
                    return v1;
                }

                this.a(new c(v3, System.currentTimeMillis(), 1f));
                __monitor_exit(v2);
            }

            return v0_1;
        label_41:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_41;
        }

        throw v0;
    }

    public void c(int arg7) {
        Object v2 = this.g;
        __monitor_enter(v2);
        try {
            this.d();
            Object v0_1 = this.h.get(arg7);
            Object v1 = this.h.get(0);
            float v1_1 = v1 != null ? ((a)v1).b - ((a)v0_1).b + 5f : 1f;
            this.a(new c(new ComponentName(((a)v0_1).a.activityInfo.packageName, ((a)v0_1).a.activityInfo.name), System.currentTimeMillis(), v1_1));
            __monitor_exit(v2);
            return;
        label_31:
            __monitor_exit(v2);
        }
        catch(Throwable v0) {
            goto label_31;
        }

        throw v0;
    }

    private void c() {
        if(!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }

        if(this.n) {
            this.n = false;
            if(!TextUtils.isEmpty(this.c)) {
                new android.support.v7.widget.e$e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.i), this.c});
            }
        }
    }

    private void d() {
        int v0 = this.f() | this.g();
        this.h();
        if(v0 != 0) {
            this.e();
            this.notifyChanged();
        }
    }

    private boolean e() {
        boolean v0;
        if(this.k == null || this.j == null || (this.h.isEmpty()) || (this.i.isEmpty())) {
            v0 = false;
        }
        else {
            this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
            v0 = true;
        }

        return v0;
    }

    private boolean f() {
        boolean v0 = false;
        if((this.o) && this.j != null) {
            this.o = false;
            this.h.clear();
            List v2 = this.b.getPackageManager().queryIntentActivities(this.j, 0);
            int v3 = v2.size();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                this.h.add(new a(v2.get(v1)));
            }

            v0 = true;
        }

        return v0;
    }

    private boolean g() {
        boolean v0 = true;
        if(!this.d || !this.n || (TextUtils.isEmpty(this.c))) {
            v0 = false;
        }
        else {
            this.d = false;
            this.m = true;
            this.i();
        }

        return v0;
    }

    private void h() {
        int v3 = this.i.size() - this.l;
        if(v3 > 0) {
            this.n = true;
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                this.i.remove(0);
            }
        }
    }

    private void i() {
        List v0_5;
        XmlPullParser v2;
        FileInputStream v1;
        try {
            v1 = this.b.openFileInput(this.c);
        }
        catch(FileNotFoundException v0) {
            return;
        }

        try {
            v2 = Xml.newPullParser();
            v2.setInput(((InputStream)v1), "UTF-8");
            int v0_4;
            for(v0_4 = 0; v0_4 != 1; v0_4 = v2.next()) {
                if(v0_4 == 2) {
                    break;
                }
            }

            if(!"historical-records".equals(v2.getName())) {
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            }

            v0_5 = this.i;
            v0_5.clear();
            while(true) {
            label_36:
                int v3 = v2.next();
                if(v3 != 1) {
                    break;
                }

                goto label_38;
            }
        }
        catch(XmlPullParserException v0_1) {
            goto label_22;
        }
        catch(Throwable v0_2) {
            goto label_86;
        }
        catch(IOException v0_3) {
            goto label_56;
        }

        if(v3 == 3) {
            goto label_36;
        }

        if(v3 == 4) {
            goto label_36;
        }

        try {
            if("historical-record".equals(v2.getName())) {
                goto label_70;
            }

            throw new XmlPullParserException("Share records file not well-formed.");
        }
        catch(XmlPullParserException v0_1) {
            goto label_22;
        }
        catch(Throwable v0_2) {
            goto label_86;
        }
        catch(IOException v0_3) {
            goto label_56;
        }

    label_70:
        String v3_1 = null;
        try {
            v0_5.add(new c(v2.getAttributeValue(v3_1, "activity"), Long.parseLong(v2.getAttributeValue(null, "time")), Float.parseFloat(v2.getAttributeValue(null, "weight"))));
            goto label_36;
        }
        catch(XmlPullParserException v0_1) {
            goto label_22;
        }
        catch(Throwable v0_2) {
            goto label_86;
        }
        catch(IOException v0_3) {
            goto label_56;
        }

    label_38:
        if(v1 == null) {
            return;
        }

        try {
            v1.close();
        }
        catch(IOException v0_3) {
        }

        return;
        try {
        label_22:
            Log.e(e.a, "Error reading historical recrod file: " + this.c, ((Throwable)v0_1));
            if(v1 == null) {
                return;
            }
        }
        catch(Throwable v0_2) {
            goto label_86;
        }

        try {
            v1.close();
        }
        catch(IOException v0_3) {
        }

        return;
        try {
        label_56:
            Log.e(e.a, "Error reading historical recrod file: " + this.c, ((Throwable)v0_3));
            if(v1 == null) {
                return;
            }
        }
        catch(Throwable v0_2) {
            goto label_86;
        }

        try {
            v1.close();
        }
        catch(IOException v0_3) {
        }

        return;
    label_86:
        if(v1 != null) {
            try {
                v1.close();
            }
            catch(IOException v1_1) {
            }
        }

        throw v0_2;
    }
}

