package android.support.v4.view;

import android.content.Context;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean arg1);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean arg1);
    }

    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    public ActionProvider(Context arg1) {
        super();
        this.mContext = arg1;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return 0;
    }

    public boolean isVisible() {
        return 1;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem arg2) {
        return this.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return 0;
    }

    public void onPrepareSubMenu(SubMenu arg1) {
    }

    public boolean overridesItemVisibility() {
        return 0;
    }

    public void refreshVisibility() {
        if(this.mVisibilityListener != null && (this.overridesItemVisibility())) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public void setSubUiVisibilityListener(SubUiVisibilityListener arg1) {
        this.mSubUiVisibilityListener = arg1;
    }

    public void setVisibilityListener(VisibilityListener arg4) {
        if(this.mVisibilityListener != null && arg4 != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }

        this.mVisibilityListener = arg4;
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public void subUiVisibilityChanged(boolean arg2) {
        if(this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(arg2);
        }
    }
}

