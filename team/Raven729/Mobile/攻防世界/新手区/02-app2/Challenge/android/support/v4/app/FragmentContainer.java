package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class FragmentContainer {
    public FragmentContainer() {
        super();
    }

    @Nullable public abstract View onFindViewById(@IdRes int arg1);

    public abstract boolean onHasView();
}

