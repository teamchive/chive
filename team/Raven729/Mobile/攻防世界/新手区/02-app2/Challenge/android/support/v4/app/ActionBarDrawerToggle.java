package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build$VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout$DrawerListener;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

@Deprecated public class ActionBarDrawerToggle implements DrawerListener {
    interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity arg1);

        Object setActionBarDescription(Object arg1, Activity arg2, int arg3);

        Object setActionBarUpIndicator(Object arg1, Activity arg2, Drawable arg3, int arg4);
    }

    class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplBase() {
            super();
        }

        public Drawable getThemeUpIndicator(Activity arg2) {
            return null;
        }

        public Object setActionBarDescription(Object arg1, Activity arg2, int arg3) {
            return arg1;
        }

        public Object setActionBarUpIndicator(Object arg1, Activity arg2, Drawable arg3, int arg4) {
            return arg1;
        }
    }

    @TargetApi(value=11) @RequiresApi(value=11) class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplHC() {
            super();
        }

        public Drawable getThemeUpIndicator(Activity arg2) {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(arg2);
        }

        public Object setActionBarDescription(Object arg2, Activity arg3, int arg4) {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(arg2, arg3, arg4);
        }

        public Object setActionBarUpIndicator(Object arg2, Activity arg3, Drawable arg4, int arg5) {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(arg2, arg3, arg4, arg5);
        }
    }

    @TargetApi(value=18) @RequiresApi(value=18) class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
        ActionBarDrawerToggleImplJellybeanMR2() {
            super();
        }

        public Drawable getThemeUpIndicator(Activity arg2) {
            return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(arg2);
        }

        public Object setActionBarDescription(Object arg2, Activity arg3, int arg4) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(arg2, arg3, arg4);
        }

        public Object setActionBarUpIndicator(Object arg2, Activity arg3, Drawable arg4, int arg5) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(arg2, arg3, arg4, arg5);
        }
    }

    public interface Delegate {
        @Nullable Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int arg1);

        void setActionBarUpIndicator(Drawable arg1, @StringRes int arg2);
    }

    public interface DelegateProvider {
        @Nullable Delegate getDrawerToggleDelegate();
    }

    class SlideDrawable extends InsetDrawable implements Drawable$Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;

        SlideDrawable(ActionBarDrawerToggle arg4, Drawable arg5) {
            boolean v0 = false;
            ActionBarDrawerToggle.this = arg4;
            super(arg5, 0);
            if(Build$VERSION.SDK_INT > 18) {
                v0 = true;
            }

            this.mHasMirroring = v0;
            this.mTmpRect = new Rect();
        }

        public void draw(Canvas arg7) {
            int v0 = 1;
            this.copyBounds(this.mTmpRect);
            arg7.save();
            int v1 = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1 ? 1 : 0;
            if(v1 != 0) {
                v0 = -1;
            }

            int v2 = this.mTmpRect.width();
            arg7.translate((((float)v0)) * (-this.mOffset * (((float)v2)) * this.mPosition), 0f);
            if(v1 != 0 && !this.mHasMirroring) {
                arg7.translate(((float)v2), 0f);
                arg7.scale(-1f, 1f);
            }

            super.draw(arg7);
            arg7.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float arg1) {
            this.mOffset = arg1;
            this.invalidateSelf();
        }

        public void setPosition(float arg1) {
            this.mPosition = arg1;
            this.invalidateSelf();
        }
    }

    private static final int ID_HOME = 0x102002C;
    private static final ActionBarDrawerToggleImpl IMPL = null;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.333333f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;

    static {
        int v0 = Build$VERSION.SDK_INT;
        if(v0 >= 18) {
            ActionBarDrawerToggle.IMPL = new ActionBarDrawerToggleImplJellybeanMR2();
        }
        else if(v0 >= 11) {
            ActionBarDrawerToggle.IMPL = new ActionBarDrawerToggleImplHC();
        }
        else {
            ActionBarDrawerToggle.IMPL = new ActionBarDrawerToggleImplBase();
        }
    }

    public ActionBarDrawerToggle(Activity arg8, DrawerLayout arg9, @DrawableRes int arg10, @StringRes int arg11, @StringRes int arg12) {
        boolean v3 = !ActionBarDrawerToggle.assumeMaterial(((Context)arg8)) ? true : false;
        this(arg8, arg9, v3, arg10, arg11, arg12);
    }

    public ActionBarDrawerToggle(Activity arg3, DrawerLayout arg4, boolean arg5, @DrawableRes int arg6, @StringRes int arg7, @StringRes int arg8) {
        super();
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = arg3;
        this.mActivityImpl = (arg3 instanceof DelegateProvider) ? arg3.getDrawerToggleDelegate() : null;
        this.mDrawerLayout = arg4;
        this.mDrawerImageResource = arg6;
        this.mOpenDrawerContentDescRes = arg7;
        this.mCloseDrawerContentDescRes = arg8;
        this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(((Context)arg3), arg6);
        this.mSlider = new SlideDrawable(this, this.mDrawerImage);
        SlideDrawable v1 = this.mSlider;
        float v0 = arg5 ? 0.333333f : 0f;
        v1.setOffset(v0);
    }

    private static boolean assumeMaterial(Context arg2) {
        int v1 = 21;
        boolean v0 = arg2.getApplicationInfo().targetSdkVersion < v1 || Build$VERSION.SDK_INT < v1 ? false : true;
        return v0;
    }

    Drawable getThemeUpIndicator() {
        Drawable v0 = this.mActivityImpl != null ? this.mActivityImpl.getThemeUpIndicator() : ActionBarDrawerToggle.IMPL.getThemeUpIndicator(this.mActivity);
        return v0;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration arg3) {
        if(!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
        }

        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        this.syncState();
    }

    public void onDrawerClosed(View arg3) {
        this.mSlider.setPosition(0f);
        if(this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View arg3) {
        this.mSlider.setPosition(1f);
        if(this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View arg5, float arg6) {
        float v3 = 2f;
        float v2 = 0.5f;
        float v0 = this.mSlider.getPosition();
        v0 = arg6 > v2 ? Math.max(v0, Math.max(0f, arg6 - v2) * v3) : Math.min(v0, arg6 * v3);
        this.mSlider.setPosition(v0);
    }

    public void onDrawerStateChanged(int arg1) {
    }

    public boolean onOptionsItemSelected(MenuItem arg4) {
        boolean v0;
        int v2 = 0x800003;
        if(arg4 == null || arg4.getItemId() != 0x102002C || !this.mDrawerIndicatorEnabled) {
            v0 = false;
        }
        else {
            if(this.mDrawerLayout.isDrawerVisible(v2)) {
                this.mDrawerLayout.closeDrawer(v2);
            }
            else {
                this.mDrawerLayout.openDrawer(v2);
            }

            v0 = true;
        }

        return v0;
    }

    void setActionBarDescription(int arg4) {
        if(this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarDescription(arg4);
        }
        else {
            this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, arg4);
        }
    }

    void setActionBarUpIndicator(Drawable arg4, int arg5) {
        if(this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarUpIndicator(arg4, arg5);
        }
        else {
            this.mSetIndicatorInfo = ActionBarDrawerToggle.IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, arg4, arg5);
        }
    }

    public void setDrawerIndicatorEnabled(boolean arg4) {
        if(arg4 != this.mDrawerIndicatorEnabled) {
            if(arg4) {
                SlideDrawable v1 = this.mSlider;
                int v0 = this.mDrawerLayout.isDrawerOpen(0x800003) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
                this.setActionBarUpIndicator(((Drawable)v1), v0);
            }
            else {
                this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }

            this.mDrawerIndicatorEnabled = arg4;
        }
    }

    public void setHomeAsUpIndicator(int arg2) {
        Drawable v0 = null;
        if(arg2 != 0) {
            v0 = ContextCompat.getDrawable(this.mActivity, arg2);
        }

        this.setHomeAsUpIndicator(v0);
    }

    public void setHomeAsUpIndicator(Drawable arg3) {
        if(arg3 == null) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        }
        else {
            this.mHomeAsUpIndicator = arg3;
            this.mHasCustomUpIndicator = true;
        }

        if(!this.mDrawerIndicatorEnabled) {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void syncState() {
        int v2 = 0x800003;
        if(this.mDrawerLayout.isDrawerOpen(v2)) {
            this.mSlider.setPosition(1f);
        }
        else {
            this.mSlider.setPosition(0f);
        }

        if(this.mDrawerIndicatorEnabled) {
            SlideDrawable v1 = this.mSlider;
            int v0 = this.mDrawerLayout.isDrawerOpen(v2) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
            this.setActionBarUpIndicator(((Drawable)v1), v0);
        }
    }
}

