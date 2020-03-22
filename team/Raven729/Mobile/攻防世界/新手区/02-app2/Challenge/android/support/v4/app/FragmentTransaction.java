package android.support.v4.app;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.view.View;

public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 0x1000;
    public static final int TRANSIT_EXIT_MASK = 0x2000;
    public static final int TRANSIT_FRAGMENT_CLOSE = 0x2002;
    public static final int TRANSIT_FRAGMENT_FADE = 0x1003;
    public static final int TRANSIT_FRAGMENT_OPEN = 0x1001;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    public FragmentTransaction() {
        super();
    }

    public abstract FragmentTransaction add(@IdRes int arg1, Fragment arg2);

    public abstract FragmentTransaction add(@IdRes int arg1, Fragment arg2, @Nullable String arg3);

    public abstract FragmentTransaction add(Fragment arg1, String arg2);

    public abstract FragmentTransaction addSharedElement(View arg1, String arg2);

    public abstract FragmentTransaction addToBackStack(@Nullable String arg1);

    public abstract FragmentTransaction attach(Fragment arg1);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public abstract FragmentTransaction detach(Fragment arg1);

    public abstract FragmentTransaction disallowAddToBackStack();

    public abstract FragmentTransaction hide(Fragment arg1);

    public abstract boolean isAddToBackStackAllowed();

    public abstract boolean isEmpty();

    public abstract FragmentTransaction remove(Fragment arg1);

    public abstract FragmentTransaction replace(@IdRes int arg1, Fragment arg2);

    public abstract FragmentTransaction replace(@IdRes int arg1, Fragment arg2, @Nullable String arg3);

    public abstract FragmentTransaction setAllowOptimization(boolean arg1);

    public abstract FragmentTransaction setBreadCrumbShortTitle(@StringRes int arg1);

    public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence arg1);

    public abstract FragmentTransaction setBreadCrumbTitle(@StringRes int arg1);

    public abstract FragmentTransaction setBreadCrumbTitle(CharSequence arg1);

    public abstract FragmentTransaction setCustomAnimations(@AnimRes int arg1, @AnimRes int arg2);

    public abstract FragmentTransaction setCustomAnimations(@AnimRes int arg1, @AnimRes int arg2, @AnimRes int arg3, @AnimRes int arg4);

    public abstract FragmentTransaction setTransition(int arg1);

    public abstract FragmentTransaction setTransitionStyle(@StyleRes int arg1);

    public abstract FragmentTransaction show(Fragment arg1);
}

