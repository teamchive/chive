package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build$VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ViewPropertyAnimatorCompat {
    class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        class Starter implements Runnable {
            WeakReference mViewRef;
            ViewPropertyAnimatorCompat mVpa;

            Starter(BaseViewPropertyAnimatorCompatImpl arg2, ViewPropertyAnimatorCompat arg3, View arg4) {
                BaseViewPropertyAnimatorCompatImpl.this = arg2;
                super();
                this.mViewRef = new WeakReference(arg4);
                this.mVpa = arg3;
            }

            public void run() {
                Object v0 = this.mViewRef.get();
                if(v0 != null) {
                    BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, ((View)v0));
                }
            }
        }

        WeakHashMap mStarterMap;

        BaseViewPropertyAnimatorCompatImpl() {
            super();
            this.mStarterMap = null;
        }

        public void alpha(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void alphaBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void cancel(ViewPropertyAnimatorCompat arg1, View arg2) {
            this.postStartMessage(arg1, arg2);
        }

        public long getDuration(ViewPropertyAnimatorCompat arg3, View arg4) {
            return 0;
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat arg2, View arg3) {
            return null;
        }

        public long getStartDelay(ViewPropertyAnimatorCompat arg3, View arg4) {
            return 0;
        }

        private void postStartMessage(ViewPropertyAnimatorCompat arg3, View arg4) {
            Starter v0_1;
            Object v0 = null;
            if(this.mStarterMap != null) {
                v0 = this.mStarterMap.get(arg4);
            }

            if(v0 == null) {
                v0_1 = new Starter(this, arg3, arg4);
                if(this.mStarterMap == null) {
                    this.mStarterMap = new WeakHashMap();
                }

                this.mStarterMap.put(arg4, v0_1);
            }

            arg4.removeCallbacks(((Runnable)v0_1));
            arg4.post(((Runnable)v0_1));
        }

        private void removeStartMessage(View arg2) {
            if(this.mStarterMap != null) {
                Object v0 = this.mStarterMap.get(arg2);
                if(v0 != null) {
                    arg2.removeCallbacks(((Runnable)v0));
                }
            }
        }

        public void rotation(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void rotationBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void rotationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void rotationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void scaleX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void scaleY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void setDuration(ViewPropertyAnimatorCompat arg1, View arg2, long arg3) {
        }

        public void setInterpolator(ViewPropertyAnimatorCompat arg1, View arg2, Interpolator arg3) {
        }

        public void setListener(ViewPropertyAnimatorCompat arg2, View arg3, ViewPropertyAnimatorListener arg4) {
            arg3.setTag(0x7E000000, arg4);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat arg1, View arg2, long arg3) {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat arg1, View arg2, ViewPropertyAnimatorUpdateListener arg3) {
        }

        public void start(ViewPropertyAnimatorCompat arg1, View arg2) {
            this.removeStartMessage(arg2);
            this.startAnimation(arg1, arg2);
        }

        void startAnimation(ViewPropertyAnimatorCompat arg5, View arg6) {
            Runnable v1 = null;
            Object v0 = arg6.getTag(0x7E000000);
            if(!(v0 instanceof ViewPropertyAnimatorListener)) {
                v0 = v1;
            }

            Runnable v2 = arg5.mStartAction;
            Runnable v3 = arg5.mEndAction;
            arg5.mStartAction = v1;
            arg5.mEndAction = v1;
            if(v2 != null) {
                v2.run();
            }

            if(v0 != null) {
                ((ViewPropertyAnimatorListener)v0).onAnimationStart(arg6);
                ((ViewPropertyAnimatorListener)v0).onAnimationEnd(arg6);
            }

            if(v3 != null) {
                v3.run();
            }

            if(this.mStarterMap != null) {
                this.mStarterMap.remove(arg6);
            }
        }

        public void translationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void translationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void translationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void translationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void translationZ(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
        }

        public void translationZBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
        }

        public void withEndAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3) {
            arg1.mEndAction = arg3;
            this.postStartMessage(arg1, arg2);
        }

        public void withLayer(ViewPropertyAnimatorCompat arg1, View arg2) {
        }

        public void withStartAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3) {
            arg1.mStartAction = arg3;
            this.postStartMessage(arg1, arg2);
        }

        public void x(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void xBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void y(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void yBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            this.postStartMessage(arg1, arg2);
        }

        public void z(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
        }

        public void zBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
        }
    }

    class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        class MyVpaListener implements ViewPropertyAnimatorListener {
            boolean mAnimEndCalled;
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat arg1) {
                super();
                this.mVpa = arg1;
            }

            public void onAnimationCancel(View arg4) {
                Object v0 = arg4.getTag(0x7E000000);
                Object v1 = null;
                if(!(v0 instanceof ViewPropertyAnimatorListener)) {
                    v0 = v1;
                }

                if(v0 != null) {
                    ((ViewPropertyAnimatorListener)v0).onAnimationCancel(arg4);
                }
            }

            public void onAnimationEnd(View arg4) {
                Paint v1 = null;
                if(this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(arg4, this.mVpa.mOldLayerType, v1);
                    this.mVpa.mOldLayerType = -1;
                }

                if(Build$VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                    if(this.mVpa.mEndAction != null) {
                        Runnable v0 = this.mVpa.mEndAction;
                        this.mVpa.mEndAction = ((Runnable)v1);
                        v0.run();
                    }

                    Object v0_1 = arg4.getTag(0x7E000000);
                    if(!(v0_1 instanceof ViewPropertyAnimatorListener)) {
                        v0_1 = v1;
                    }

                    if(v0_1 != null) {
                        ((ViewPropertyAnimatorListener)v0_1).onAnimationEnd(arg4);
                    }

                    this.mAnimEndCalled = true;
                }
            }

            public void onAnimationStart(View arg4) {
                Paint v1 = null;
                this.mAnimEndCalled = false;
                if(this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(arg4, 2, v1);
                }

                if(this.mVpa.mStartAction != null) {
                    Runnable v0 = this.mVpa.mStartAction;
                    this.mVpa.mStartAction = ((Runnable)v1);
                    v0.run();
                }

                Object v0_1 = arg4.getTag(0x7E000000);
                if(!(v0_1 instanceof ViewPropertyAnimatorListener)) {
                    v0_1 = v1;
                }

                if(v0_1 != null) {
                    ((ViewPropertyAnimatorListener)v0_1).onAnimationStart(arg4);
                }
            }
        }

        WeakHashMap mLayerMap;

        ICSViewPropertyAnimatorCompatImpl() {
            super();
            this.mLayerMap = null;
        }

        public void alpha(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.alpha(arg2, arg3);
        }

        public void alphaBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.alphaBy(arg2, arg3);
        }

        public void cancel(ViewPropertyAnimatorCompat arg1, View arg2) {
            ViewPropertyAnimatorCompatICS.cancel(arg2);
        }

        public long getDuration(ViewPropertyAnimatorCompat arg3, View arg4) {
            return ViewPropertyAnimatorCompatICS.getDuration(arg4);
        }

        public long getStartDelay(ViewPropertyAnimatorCompat arg3, View arg4) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(arg4);
        }

        public void rotation(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotation(arg2, arg3);
        }

        public void rotationBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotationBy(arg2, arg3);
        }

        public void rotationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotationX(arg2, arg3);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotationXBy(arg2, arg3);
        }

        public void rotationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotationY(arg2, arg3);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.rotationYBy(arg2, arg3);
        }

        public void scaleX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.scaleX(arg2, arg3);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.scaleXBy(arg2, arg3);
        }

        public void scaleY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.scaleY(arg2, arg3);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.scaleYBy(arg2, arg3);
        }

        public void setDuration(ViewPropertyAnimatorCompat arg2, View arg3, long arg4) {
            ViewPropertyAnimatorCompatICS.setDuration(arg3, arg4);
        }

        public void setInterpolator(ViewPropertyAnimatorCompat arg1, View arg2, Interpolator arg3) {
            ViewPropertyAnimatorCompatICS.setInterpolator(arg2, arg3);
        }

        public void setListener(ViewPropertyAnimatorCompat arg2, View arg3, ViewPropertyAnimatorListener arg4) {
            arg3.setTag(0x7E000000, arg4);
            ViewPropertyAnimatorCompatICS.setListener(arg3, new MyVpaListener(arg2));
        }

        public void setStartDelay(ViewPropertyAnimatorCompat arg2, View arg3, long arg4) {
            ViewPropertyAnimatorCompatICS.setStartDelay(arg3, arg4);
        }

        public void start(ViewPropertyAnimatorCompat arg1, View arg2) {
            ViewPropertyAnimatorCompatICS.start(arg2);
        }

        public void translationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.translationX(arg2, arg3);
        }

        public void translationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.translationXBy(arg2, arg3);
        }

        public void translationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.translationY(arg2, arg3);
        }

        public void translationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.translationYBy(arg2, arg3);
        }

        public void withEndAction(ViewPropertyAnimatorCompat arg2, View arg3, Runnable arg4) {
            ViewPropertyAnimatorCompatICS.setListener(arg3, new MyVpaListener(arg2));
            arg2.mEndAction = arg4;
        }

        public void withLayer(ViewPropertyAnimatorCompat arg2, View arg3) {
            arg2.mOldLayerType = ViewCompat.getLayerType(arg3);
            ViewPropertyAnimatorCompatICS.setListener(arg3, new MyVpaListener(arg2));
        }

        public void withStartAction(ViewPropertyAnimatorCompat arg2, View arg3, Runnable arg4) {
            ViewPropertyAnimatorCompatICS.setListener(arg3, new MyVpaListener(arg2));
            arg2.mStartAction = arg4;
        }

        public void x(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.x(arg2, arg3);
        }

        public void xBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.xBy(arg2, arg3);
        }

        public void y(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.y(arg2, arg3);
        }

        public void yBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatICS.yBy(arg2, arg3);
        }
    }

    class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
            super();
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat arg2, View arg3) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(arg3);
        }
    }

    class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
            super();
        }

        public void setListener(ViewPropertyAnimatorCompat arg1, View arg2, ViewPropertyAnimatorListener arg3) {
            ViewPropertyAnimatorCompatJB.setListener(arg2, arg3);
        }

        public void withEndAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3) {
            ViewPropertyAnimatorCompatJB.withEndAction(arg2, arg3);
        }

        public void withLayer(ViewPropertyAnimatorCompat arg1, View arg2) {
            ViewPropertyAnimatorCompatJB.withLayer(arg2);
        }

        public void withStartAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3) {
            ViewPropertyAnimatorCompatJB.withStartAction(arg2, arg3);
        }
    }

    class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
            super();
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat arg1, View arg2, ViewPropertyAnimatorUpdateListener arg3) {
            ViewPropertyAnimatorCompatKK.setUpdateListener(arg2, arg3);
        }
    }

    class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
            super();
        }

        public void translationZ(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatLollipop.translationZ(arg2, arg3);
        }

        public void translationZBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatLollipop.translationZBy(arg2, arg3);
        }

        public void z(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatLollipop.z(arg2, arg3);
        }

        public void zBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3) {
            ViewPropertyAnimatorCompatLollipop.zBy(arg2, arg3);
        }
    }

    interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void alphaBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void cancel(ViewPropertyAnimatorCompat arg1, View arg2);

        long getDuration(ViewPropertyAnimatorCompat arg1, View arg2);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat arg1, View arg2);

        long getStartDelay(ViewPropertyAnimatorCompat arg1, View arg2);

        void rotation(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void rotationBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void rotationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void rotationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void rotationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void rotationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void scaleX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void scaleXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void scaleY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void scaleYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void setDuration(ViewPropertyAnimatorCompat arg1, View arg2, long arg3);

        void setInterpolator(ViewPropertyAnimatorCompat arg1, View arg2, Interpolator arg3);

        void setListener(ViewPropertyAnimatorCompat arg1, View arg2, ViewPropertyAnimatorListener arg3);

        void setStartDelay(ViewPropertyAnimatorCompat arg1, View arg2, long arg3);

        void setUpdateListener(ViewPropertyAnimatorCompat arg1, View arg2, ViewPropertyAnimatorUpdateListener arg3);

        void start(ViewPropertyAnimatorCompat arg1, View arg2);

        void translationX(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void translationXBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void translationY(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void translationYBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void translationZ(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void translationZBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void withEndAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3);

        void withLayer(ViewPropertyAnimatorCompat arg1, View arg2);

        void withStartAction(ViewPropertyAnimatorCompat arg1, View arg2, Runnable arg3);

        void x(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void xBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void y(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void yBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void z(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);

        void zBy(ViewPropertyAnimatorCompat arg1, View arg2, float arg3);
    }

    static final ViewPropertyAnimatorCompatImpl IMPL = null;
    static final int LISTENER_TAG_ID = 0x7E000000;
    private static final String TAG = "ViewAnimatorCompat";
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private WeakReference mView;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 21) {
            ViewPropertyAnimatorCompat.IMPL = new LollipopViewPropertyAnimatorCompatImpl();
        }
        else if(v0 >= 19) {
            ViewPropertyAnimatorCompat.IMPL = new KitKatViewPropertyAnimatorCompatImpl();
        }
        else if(v0 >= 18) {
            ViewPropertyAnimatorCompat.IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        }
        else if(v0 >= 16) {
            ViewPropertyAnimatorCompat.IMPL = new JBViewPropertyAnimatorCompatImpl();
        }
        else if(v0 >= 14) {
            ViewPropertyAnimatorCompat.IMPL = new ICSViewPropertyAnimatorCompatImpl();
        }
        else {
            ViewPropertyAnimatorCompat.IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    ViewPropertyAnimatorCompat(View arg2) {
        super();
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(arg2);
    }

    public ViewPropertyAnimatorCompat alpha(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.alpha(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.alphaBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public void cancel() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.cancel(this, ((View)v0));
        }
    }

    public long getDuration() {
        Object v0 = this.mView.get();
        long v0_1 = v0 != null ? ViewPropertyAnimatorCompat.IMPL.getDuration(this, ((View)v0)) : 0;
        return v0_1;
    }

    public Interpolator getInterpolator() {
        Object v0 = this.mView.get();
        Interpolator v0_1 = v0 != null ? ViewPropertyAnimatorCompat.IMPL.getInterpolator(this, ((View)v0)) : null;
        return v0_1;
    }

    public long getStartDelay() {
        Object v0 = this.mView.get();
        long v0_1 = v0 != null ? ViewPropertyAnimatorCompat.IMPL.getStartDelay(this, ((View)v0)) : 0;
        return v0_1;
    }

    public ViewPropertyAnimatorCompat rotation(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotation(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotationBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotationX(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotationXBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotationY(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.rotationYBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.scaleX(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.scaleXBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.scaleY(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.scaleYBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long arg4) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.setDuration(this, ((View)v0), arg4);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.setInterpolator(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.setListener(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long arg4) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.setStartDelay(this, ((View)v0), arg4);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.setUpdateListener(this, ((View)v0), arg3);
        }

        return this;
    }

    public void start() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.start(this, ((View)v0));
        }
    }

    public ViewPropertyAnimatorCompat translationX(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationX(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationXBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationY(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationYBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationZ(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.translationZBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.withEndAction(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.withLayer(this, ((View)v0));
        }

        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.withStartAction(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat x(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.x(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.xBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat y(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.y(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.yBy(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat z(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.z(this, ((View)v0), arg3);
        }

        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float arg3) {
        Object v0 = this.mView.get();
        if(v0 != null) {
            ViewPropertyAnimatorCompat.IMPL.zBy(this, ((View)v0), arg3);
        }

        return this;
    }
}

