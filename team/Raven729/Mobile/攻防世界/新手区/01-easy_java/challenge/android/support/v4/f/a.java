package android.support.v4.f;

import android.support.v4.g.j;
import android.util.Base64;
import java.util.List;

public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final List d;
    private final int e;
    private final String f;

    public a(String arg3, String arg4, String arg5, List arg6) {
        super();
        this.a = j.a(arg3);
        this.b = j.a(arg4);
        this.c = j.a(arg5);
        this.d = j.a(arg6);
        this.e = 0;
        this.f = this.a + "-" + this.b + "-" + this.c;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder v5 = new StringBuilder();
        v5.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        int v2;
        for(v2 = 0; v2 < this.d.size(); ++v2) {
            v5.append(" [");
            Object v0 = this.d.get(v2);
            int v4;
            for(v4 = 0; v4 < ((List)v0).size(); ++v4) {
                v5.append(" \"");
                v5.append(Base64.encodeToString(((List)v0).get(v4), 0));
                v5.append("\"");
            }

            v5.append(" ]");
        }

        v5.append("}");
        v5.append("mCertificatesArray: " + this.e);
        return v5.toString();
    }
}

