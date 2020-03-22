package android.arch.lifecycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map$Entry;

public class d extends b {
    class android.arch.lifecycle.d$1 {
        static {
            android.arch.lifecycle.d$1.b = new int[android.arch.lifecycle.b$b.values().length];
            try {
                android.arch.lifecycle.d$1.b[android.arch.lifecycle.b$b.b.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.b[android.arch.lifecycle.b$b.c.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.b[android.arch.lifecycle.b$b.d.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.b[android.arch.lifecycle.b$b.e.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.b[android.arch.lifecycle.b$b.a.ordinal()] = 5;
            }
            catch(NoSuchFieldError v0) {
            }

            android.arch.lifecycle.d$1.a = new int[a.values().length];
            try {
                android.arch.lifecycle.d$1.a[a.ON_CREATE.ordinal()] = 1;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_STOP.ordinal()] = 2;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_START.ordinal()] = 3;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_PAUSE.ordinal()] = 4;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_RESUME.ordinal()] = 5;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_DESTROY.ordinal()] = 6;
            }
            catch(NoSuchFieldError v0) {
            }

            try {
                android.arch.lifecycle.d$1.a[a.ON_ANY.ordinal()] = 7;
            }
            catch(NoSuchFieldError v0) {
            }
        }
    }

    class android.arch.lifecycle.d$a {
        android.arch.lifecycle.b$b a;
        android.arch.lifecycle.a b;

        void a(c arg3, a arg4) {
            android.arch.lifecycle.b$b v0 = d.b(arg4);
            this.a = d.a(this.a, v0);
            this.b.a(arg3, arg4);
            this.a = v0;
        }
    }

    private android.arch.a.a.a a;
    private android.arch.lifecycle.b$b b;
    private final c c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList g;

    public d(c arg3) {
        super();
        this.a = new android.arch.a.a.a();
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = new ArrayList();
        this.c = arg3;
        this.b = android.arch.lifecycle.b$b.b;
    }

    static android.arch.lifecycle.b$b a(android.arch.lifecycle.b$b arg1, android.arch.lifecycle.b$b arg2) {
        if(arg2 == null || arg2.compareTo(((Enum)arg1)) >= 0) {
            arg2 = arg1;
        }

        return arg2;
    }

    private boolean a() {
        boolean v1 = true;
        if(this.a.a() != 0) {
            android.arch.lifecycle.b$b v2 = this.a.d().getValue().a;
            android.arch.lifecycle.b$b v0 = this.a.e().getValue().a;
            boolean v0_1 = v2 != v0 || this.b != v0 ? false : true;
            v1 = v0_1;
        }

        return v1;
    }

    public void a(a arg3) {
        this.b = d.b(arg3);
        if((this.e) || this.d != 0) {
            this.f = true;
        }
        else {
            this.e = true;
            this.e();
            this.e = false;
        }
    }

    public void a(android.arch.lifecycle.b$b arg1) {
        this.b = arg1;
    }

    static android.arch.lifecycle.b$b b(a arg3) {
        switch(android.arch.lifecycle.d$1.a[arg3.ordinal()]) {
            case 1: 
            case 2: {
                goto label_13;
            }
            case 3: 
            case 4: {
                goto label_15;
            }
            case 5: {
                goto label_17;
            }
            case 6: {
                goto label_19;
            }
        }

        throw new IllegalArgumentException("Unexpected event value " + arg3);
    label_17:
        android.arch.lifecycle.b$b v0 = android.arch.lifecycle.b$b.e;
        return v0;
    label_19:
        return android.arch.lifecycle.b$b.a;
    label_13:
        return android.arch.lifecycle.b$b.c;
    label_15:
        return android.arch.lifecycle.b$b.d;
    }

    private void b() {
        this.g.remove(this.g.size() - 1);
    }

    private void b(android.arch.lifecycle.b$b arg2) {
        this.g.add(arg2);
    }

    private static a c(android.arch.lifecycle.b$b arg3) {
        switch(android.arch.lifecycle.d$1.b[arg3.ordinal()]) {
            case 1: {
                goto label_13;
            }
            case 2: {
                goto label_16;
            }
            case 3: {
                goto label_18;
            }
            case 4: {
                goto label_20;
            }
            case 5: {
                goto label_22;
            }
        }

        throw new IllegalArgumentException("Unexpected state value " + arg3);
    label_18:
        a v0 = a.ON_STOP;
        return v0;
    label_20:
        return a.ON_PAUSE;
    label_22:
        throw new IllegalArgumentException();
    label_13:
        throw new IllegalArgumentException();
    label_16:
        return a.ON_DESTROY;
    }

    private void c() {
        Object v1;
        android.arch.a.a.b$d v2 = this.a.c();
        do {
        label_2:
            if((((Iterator)v2).hasNext()) && !this.f) {
                Object v0 = ((Iterator)v2).next();
                v1 = ((Map$Entry)v0).getValue();
                while(true) {
                label_8:
                    if(((android.arch.lifecycle.d$a)v1).a.compareTo(this.b) >= 0) {
                        goto label_2;
                    }

                    if(this.f) {
                        goto label_2;
                    }

                    if(!this.a.a(((Map$Entry)v0).getKey())) {
                        goto label_2;
                    }

                    goto label_18;
                }
            }

            return;
        }
        while(true);

    label_18:
        this.b(((android.arch.lifecycle.d$a)v1).a);
        ((android.arch.lifecycle.d$a)v1).a(this.c, d.d(((android.arch.lifecycle.d$a)v1).a));
        this.b();
        goto label_8;
    }

    private static a d(android.arch.lifecycle.b$b arg3) {
        switch(android.arch.lifecycle.d$1.b[arg3.ordinal()]) {
            case 2: {
                goto label_15;
            }
            case 3: {
                goto label_17;
            }
            case 4: {
                goto label_19;
            }
            case 1: 
            case 5: {
                goto label_13;
            }
        }

        throw new IllegalArgumentException("Unexpected state value " + arg3);
    label_17:
        a v0 = a.ON_RESUME;
        return v0;
    label_19:
        throw new IllegalArgumentException();
    label_13:
        return a.ON_CREATE;
    label_15:
        return a.ON_START;
    }

    private void d() {
        Object v1;
        Iterator v2 = this.a.b();
        do {
        label_2:
            if((v2.hasNext()) && !this.f) {
                Object v0 = v2.next();
                v1 = ((Map$Entry)v0).getValue();
                while(true) {
                label_8:
                    if(((android.arch.lifecycle.d$a)v1).a.compareTo(this.b) <= 0) {
                        goto label_2;
                    }

                    if(this.f) {
                        goto label_2;
                    }

                    if(!this.a.a(((Map$Entry)v0).getKey())) {
                        goto label_2;
                    }

                    goto label_18;
                }
            }

            return;
        }
        while(true);

    label_18:
        a v3 = d.c(((android.arch.lifecycle.d$a)v1).a);
        this.b(d.b(v3));
        ((android.arch.lifecycle.d$a)v1).a(this.c, v3);
        this.b();
        goto label_8;
    }

    private void e() {
        while(!this.a()) {
            this.f = false;
            if(this.b.compareTo(this.a.d().getValue().a) < 0) {
                this.d();
            }

            Map$Entry v0 = this.a.e();
            if(this.f) {
                continue;
            }

            if(v0 == null) {
                continue;
            }

            if(this.b.compareTo(v0.getValue().a) <= 0) {
                continue;
            }

            this.c();
        }

        this.f = false;
    }
}

