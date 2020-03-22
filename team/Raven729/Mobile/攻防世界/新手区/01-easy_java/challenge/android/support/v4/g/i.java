package android.support.v4.g;

public class i {
    public final Object a;
    public final Object b;

    private static boolean a(Object arg1, Object arg2) {
        boolean v0;
        if(arg1 != arg2) {
            if(arg1 != null && (arg1.equals(arg2))) {
                goto label_4;
            }

            v0 = false;
        }
        else {
        label_4:
            v0 = true;
        }

        return v0;
    }

    public boolean equals(Object arg4) {
        boolean v0 = false;
        if(((arg4 instanceof i)) && (i.a(((i)arg4).a, this.a)) && (i.a(((i)arg4).b, this.b))) {
            v0 = true;
        }

        return v0;
    }

    public int hashCode() {
        int v1 = 0;
        int v0 = this.a == null ? 0 : this.a.hashCode();
        if(this.b != null) {
            v1 = this.b.hashCode();
        }

        return v0 ^ v1;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}

