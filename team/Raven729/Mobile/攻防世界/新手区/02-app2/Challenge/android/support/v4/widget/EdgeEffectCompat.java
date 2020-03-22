package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build$VERSION;

public final class EdgeEffectCompat {
    class BaseEdgeEffectImpl implements EdgeEffectImpl {
        BaseEdgeEffectImpl() {
            super();
        }

        public boolean draw(Object arg2, Canvas arg3) {
            return 0;
        }

        public void finish(Object arg1) {
        }

        public boolean isFinished(Object arg2) {
            return 1;
        }

        public Object newEdgeEffect(Context arg2) {
            return null;
        }

        public boolean onAbsorb(Object arg2, int arg3) {
            return 0;
        }

        public boolean onPull(Object arg2, float arg3) {
            return 0;
        }

        public boolean onPull(Object arg2, float arg3, float arg4) {
            return 0;
        }

        public boolean onRelease(Object arg2) {
            return 0;
        }

        public void setSize(Object arg1, int arg2, int arg3) {
        }
    }

    class EdgeEffectIcsImpl implements EdgeEffectImpl {
        EdgeEffectIcsImpl() {
            super();
        }

        public boolean draw(Object arg2, Canvas arg3) {
            return EdgeEffectCompatIcs.draw(arg2, arg3);
        }

        public void finish(Object arg1) {
            EdgeEffectCompatIcs.finish(arg1);
        }

        public boolean isFinished(Object arg2) {
            return EdgeEffectCompatIcs.isFinished(arg2);
        }

        public Object newEdgeEffect(Context arg2) {
            return EdgeEffectCompatIcs.newEdgeEffect(arg2);
        }

        public boolean onAbsorb(Object arg2, int arg3) {
            return EdgeEffectCompatIcs.onAbsorb(arg2, arg3);
        }

        public boolean onPull(Object arg2, float arg3) {
            return EdgeEffectCompatIcs.onPull(arg2, arg3);
        }

        public boolean onPull(Object arg2, float arg3, float arg4) {
            return EdgeEffectCompatIcs.onPull(arg2, arg3);
        }

        public boolean onRelease(Object arg2) {
            return EdgeEffectCompatIcs.onRelease(arg2);
        }

        public void setSize(Object arg1, int arg2, int arg3) {
            EdgeEffectCompatIcs.setSize(arg1, arg2, arg3);
        }
    }

    interface EdgeEffectImpl {
        boolean draw(Object arg1, Canvas arg2);

        void finish(Object arg1);

        boolean isFinished(Object arg1);

        Object newEdgeEffect(Context arg1);

        boolean onAbsorb(Object arg1, int arg2);

        boolean onPull(Object arg1, float arg2);

        boolean onPull(Object arg1, float arg2, float arg3);

        boolean onRelease(Object arg1);

        void setSize(Object arg1, int arg2, int arg3);
    }

    class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
        EdgeEffectLollipopImpl() {
            super();
        }

        public boolean onPull(Object arg2, float arg3, float arg4) {
            return EdgeEffectCompatLollipop.onPull(arg2, arg3, arg4);
        }
    }

    private static final EdgeEffectImpl IMPL;
    private Object mEdgeEffect;

    static {
        if(Build$VERSION.SDK_INT >= 21) {
            EdgeEffectCompat.IMPL = new EdgeEffectLollipopImpl();
        }
        else if(Build$VERSION.SDK_INT >= 14) {
            EdgeEffectCompat.IMPL = new EdgeEffectIcsImpl();
        }
        else {
            EdgeEffectCompat.IMPL = new BaseEdgeEffectImpl();
        }
    }

    public EdgeEffectCompat(Context arg2) {
        super();
        this.mEdgeEffect = EdgeEffectCompat.IMPL.newEdgeEffect(arg2);
    }

    public boolean draw(Canvas arg3) {
        return EdgeEffectCompat.IMPL.draw(this.mEdgeEffect, arg3);
    }

    public void finish() {
        EdgeEffectCompat.IMPL.finish(this.mEdgeEffect);
    }

    public boolean isFinished() {
        return EdgeEffectCompat.IMPL.isFinished(this.mEdgeEffect);
    }

    public boolean onAbsorb(int arg3) {
        return EdgeEffectCompat.IMPL.onAbsorb(this.mEdgeEffect, arg3);
    }

    @Deprecated public boolean onPull(float arg3) {
        return EdgeEffectCompat.IMPL.onPull(this.mEdgeEffect, arg3);
    }

    public boolean onPull(float arg3, float arg4) {
        return EdgeEffectCompat.IMPL.onPull(this.mEdgeEffect, arg3, arg4);
    }

    public boolean onRelease() {
        return EdgeEffectCompat.IMPL.onRelease(this.mEdgeEffect);
    }

    public void setSize(int arg3, int arg4) {
        EdgeEffectCompat.IMPL.setSize(this.mEdgeEffect, arg3, arg4);
    }
}

