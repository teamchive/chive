package android.support.v4.util;

public final class Pools {
    public interface Pool {
        Object acquire();

        boolean release(Object arg1);
    }

    public class SimplePool implements Pool {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int arg3) {
            super();
            if(arg3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }

            this.mPool = new Object[arg3];
        }

        public Object acquire() {
            Object v0;
            Object v1 = null;
            if(this.mPoolSize > 0) {
                int v2 = this.mPoolSize - 1;
                v0 = this.mPool[v2];
                this.mPool[v2] = v1;
                --this.mPoolSize;
            }
            else {
                v0 = v1;
            }

            return v0;
        }

        private boolean isInPool(Object arg4) {
            boolean v1 = false;
            int v0 = 0;
            while(v0 < this.mPoolSize) {
                if(this.mPool[v0] == arg4) {
                    v1 = true;
                }
                else {
                    ++v0;
                    continue;
                }

                return v1;
            }

            return v1;
        }

        public boolean release(Object arg3) {
            boolean v0;
            if(this.isInPool(arg3)) {
                throw new IllegalStateException("Already in the pool!");
            }

            if(this.mPoolSize < this.mPool.length) {
                this.mPool[this.mPoolSize] = arg3;
                ++this.mPoolSize;
                v0 = true;
            }
            else {
                v0 = false;
            }

            return v0;
        }
    }

    public class SynchronizedPool extends SimplePool {
        private final Object mLock;

        public SynchronizedPool(int arg2) {
            super(arg2);
            this.mLock = new Object();
        }

        public Object acquire() {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                __monitor_exit(v1);
                return super.acquire();
            label_6:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }

        public boolean release(Object arg3) {
            Object v1 = this.mLock;
            __monitor_enter(v1);
            try {
                __monitor_exit(v1);
                return super.release(arg3);
            label_6:
                __monitor_exit(v1);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }
    }

    private Pools() {
        super();
    }
}

