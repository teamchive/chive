package android.support.v4.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab implements Iterable {
    public interface a {
        Intent a_();
    }

    class b extends c {
        b() {
            super();
        }
    }

    class c {
        c() {
            super();
        }
    }

    private static final c a;
    private final ArrayList b;
    private final Context c;

    static {
        ab.a = Build$VERSION.SDK_INT >= 16 ? new b() : new c();
    }

    private ab(Context arg2) {
        super();
        this.b = new ArrayList();
        this.c = arg2;
    }

    public static ab a(Context arg1) {
        return new ab(arg1);
    }

    public ab a(Activity arg3) {
        Intent v0 = null;
        if((arg3 instanceof a)) {
            v0 = arg3.a_();
        }

        Intent v1 = v0 == null ? w.a(arg3) : v0;
        if(v1 != null) {
            ComponentName v0_1 = v1.getComponent();
            if(v0_1 == null) {
                v0_1 = v1.resolveActivity(this.c.getPackageManager());
            }

            this.a(v0_1);
            this.a(v1);
        }

        return this;
    }

    public ab a(ComponentName arg4) {
        int v1 = this.b.size();
        try {
            Intent v0_1;
            for(v0_1 = w.a(this.c, arg4); v0_1 != null; v0_1 = w.a(this.c, v0_1.getComponent())) {
                this.b.add(v1, v0_1);
            }
        }
        catch(PackageManager$NameNotFoundException v0) {
            goto label_14;
        }

        return this;
    label_14:
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(((Throwable)v0));
    }

    public ab a(Intent arg2) {
        this.b.add(arg2);
        return this;
    }

    public void a() {
        this.a(null);
    }

    public void a(Bundle arg5) {
        if(this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }

        Object[] v0 = this.b.toArray(new Intent[this.b.size()]);
        v0[0] = new Intent(v0[0]).addFlags(0x1000C000);
        if(!android.support.v4.b.a.a(this.c, ((Intent[])v0), arg5)) {
            Intent v1 = new Intent(v0[v0.length - 1]);
            v1.addFlags(0x10000000);
            this.c.startActivity(v1);
        }
    }

    @Deprecated public Iterator iterator() {
        return this.b.iterator();
    }
}

