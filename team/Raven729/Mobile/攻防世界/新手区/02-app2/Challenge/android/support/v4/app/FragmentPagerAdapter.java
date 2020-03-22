package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;

    public FragmentPagerAdapter(FragmentManager arg2) {
        super();
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = arg2;
    }

    public void destroyItem(ViewGroup arg2, int arg3, Object arg4) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        this.mCurTransaction.detach(((Fragment)arg4));
    }

    public void finishUpdate(ViewGroup arg2) {
        if(this.mCurTransaction != null) {
            this.mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int arg1);

    public long getItemId(int arg3) {
        return ((long)arg3);
    }

    public Object instantiateItem(ViewGroup arg8, int arg9) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        long v2 = this.getItemId(arg9);
        Fragment v0 = this.mFragmentManager.findFragmentByTag(FragmentPagerAdapter.makeFragmentName(arg8.getId(), v2));
        if(v0 != null) {
            this.mCurTransaction.attach(v0);
        }
        else {
            v0 = this.getItem(arg9);
            this.mCurTransaction.add(arg8.getId(), v0, FragmentPagerAdapter.makeFragmentName(arg8.getId(), v2));
        }

        if(v0 != this.mCurrentPrimaryItem) {
            v0.setMenuVisibility(false);
            v0.setUserVisibleHint(false);
        }

        return v0;
    }

    public boolean isViewFromObject(View arg2, Object arg3) {
        boolean v0 = ((Fragment)arg3).getView() == arg2 ? true : false;
        return v0;
    }

    private static String makeFragmentName(int arg3, long arg4) {
        return "android:switcher:" + arg3 + ":" + arg4;
    }

    public void restoreState(Parcelable arg1, ClassLoader arg2) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup arg4, int arg5, Object arg6) {
        if(arg6 != this.mCurrentPrimaryItem) {
            if(this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }

            if(arg6 != null) {
                ((Fragment)arg6).setMenuVisibility(true);
                ((Fragment)arg6).setUserVisibleHint(true);
            }

            this.mCurrentPrimaryItem = ((Fragment)arg6);
        }
    }

    public void startUpdate(ViewGroup arg4) {
        if(arg4.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}

