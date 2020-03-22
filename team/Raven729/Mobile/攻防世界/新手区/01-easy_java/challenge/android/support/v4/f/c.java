package android.support.v4.f;

import android.os.Handler$Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    class android.support.v4.f.c$1 implements Handler$Callback {
        android.support.v4.f.c$1(c arg1) {
            this.a = arg1;
            super();
        }

        public boolean handleMessage(Message arg4) {
            switch(arg4.what) {
                case 0: {
                    c.a(this.a);
                    break;
                }
                case 1: {
                    c.a(this.a, arg4.obj);
                    break;
                }
            }

            return 1;
        }
    }

    public interface a {
        void a(Object arg1);
    }

    private final Object a;
    private HandlerThread b;
    private Handler c;
    private int d;
    private Handler$Callback e;
    private final int f;
    private final int g;
    private final String h;

    public c(String arg2, int arg3, int arg4) {
        super();
        this.a = new Object();
        this.e = new android.support.v4.f.c$1(this);
        this.h = arg2;
        this.g = arg3;
        this.f = arg4;
        this.d = 0;
    }

    public Object a(Callable arg11, int arg12) {
        Object v0_1;
        ReentrantLock v4 = new ReentrantLock();
        Condition v6 = v4.newCondition();
        AtomicReference v2 = new AtomicReference();
        AtomicBoolean v5 = new AtomicBoolean(true);
        this.a(new Runnable(v2, arg11, v4, v5, v6) {
            public void run() {
                try {
                    this.a.set(this.b.call());
                }
                catch(Exception v0) {
                }

                this.c.lock();
                try {
                    this.d.set(false);
                    this.e.signal();
                }
                catch(Throwable v0_1) {
                    this.c.unlock();
                    throw v0_1;
                }

                this.c.unlock();
            }
        });
        v4.lock();
        try {
            if(v5.get()) {
                goto label_19;
            }

            v0_1 = v2.get();
        }
        catch(Throwable v0) {
            goto label_35;
        }

        v4.unlock();
        return v0_1;
        try {
        label_19:
            long v0_2 = TimeUnit.MILLISECONDS.toNanos(((long)arg12));
            try {
                do {
                label_22:
                    v0_2 = v6.awaitNanos(v0_2);
                    break;
                }
                while(true);
            }
            catch(InterruptedException v3) {
            }
        }
        catch(Throwable v0) {
            goto label_35;
        }

        try {
            if(v5.get()) {
                goto label_28;
            }

            v0_1 = v2.get();
        }
        catch(Throwable v0) {
            goto label_35;
        }

        v4.unlock();
        return v0_1;
    label_28:
        if(v0_2 > 0) {
            goto label_22;
        }

        try {
            throw new InterruptedException("timeout");
        }
        catch(Throwable v0) {
            goto label_35;
        }

        return v0_1;
    label_35:
        v4.unlock();
        throw v0;
    }

    public void a(Callable arg3, a arg4) {
        this.a(new Runnable(arg3, new Handler(), arg4) {
            public void run() {
                Object v0_1;
                try {
                    v0_1 = this.a.call();
                }
                catch(Exception v0) {
                    v0_1 = null;
                }

                this.b.post(new Runnable(v0_1) {
                    public void run() {
                        this.b.c.a(this.a);
                    }
                });
            }
        });
    }

    private void a() {
        Object v1 = this.a;
        __monitor_enter(v1);
        try {
            if(this.c.hasMessages(1)) {
                __monitor_exit(v1);
            }
            else {
                this.b.quit();
                this.b = null;
                this.c = null;
                __monitor_exit(v1);
            }

            return;
        label_17:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_17;
        }

        throw v0;
    }

    static void a(c arg0) {
        arg0.a();
    }

    static void a(c arg0, Runnable arg1) {
        arg0.b(arg1);
    }

    private void a(Runnable arg5) {
        Object v1 = this.a;
        __monitor_enter(v1);
        try {
            if(this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                ++this.d;
            }

            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, arg5));
            __monitor_exit(v1);
            return;
        label_31:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_31;
        }

        throw v0;
    }

    private void b(Runnable arg7) {
        arg7.run();
        Object v1 = this.a;
        __monitor_enter(v1);
        try {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), ((long)this.f));
            __monitor_exit(v1);
            return;
        label_16:
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_16;
        }

        throw v0;
    }
}

