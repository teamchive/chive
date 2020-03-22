package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig {
    private final List mChildNonConfigs;
    private final List mFragments;

    FragmentManagerNonConfig(List arg1, List arg2) {
        super();
        this.mFragments = arg1;
        this.mChildNonConfigs = arg2;
    }

    List getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    List getFragments() {
        return this.mFragments;
    }
}

