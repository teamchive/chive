package android.support.v4.util;

public class Pair {
    public final Object first;
    public final Object second;

    public Pair(Object arg1, Object arg2) {
        super();
        this.first = arg1;
        this.second = arg2;
    }

    public static Pair create(Object arg1, Object arg2) {
        return new Pair(arg1, arg2);
    }

    public boolean equals(Object arg4) {
        boolean v0 = false;
        if(((arg4 instanceof Pair)) && (Pair.objectsEqual(((Pair)arg4).first, this.first)) && (Pair.objectsEqual(((Pair)arg4).second, this.second))) {
            v0 = true;
        }

        return v0;
    }

    public int hashCode() {
        int v1 = 0;
        int v0 = this.first == null ? 0 : this.first.hashCode();
        if(this.second != null) {
            v1 = this.second.hashCode();
        }

        return v0 ^ v1;
    }

    private static boolean objectsEqual(Object arg1, Object arg2) {
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

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}

