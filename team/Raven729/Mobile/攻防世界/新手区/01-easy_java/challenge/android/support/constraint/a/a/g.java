package android.support.constraint.a.a;

import java.util.Arrays;

public class g extends d {
    protected d[] ab;
    protected int ac;

    public g() {
        super();
        this.ab = new d[4];
        this.ac = 0;
    }

    public void H() {
        this.ac = 0;
    }

    public void b(d arg3) {
        if(this.ac + 1 > this.ab.length) {
            this.ab = Arrays.copyOf(this.ab, this.ab.length * 2);
        }

        this.ab[this.ac] = arg3;
        ++this.ac;
    }
}

