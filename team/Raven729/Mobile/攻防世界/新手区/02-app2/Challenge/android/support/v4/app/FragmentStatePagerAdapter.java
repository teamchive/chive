package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;

    public FragmentStatePagerAdapter(FragmentManager arg3) {
        super();
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = arg3;
    }

    public void destroyItem(ViewGroup arg4, int arg5, Object arg6) {
        Object v0_1;
        Object v1 = null;
        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        while(this.mSavedState.size() <= arg5) {
            this.mSavedState.add(v1);
        }

        ArrayList v2 = this.mSavedState;
        if(((Fragment)arg6).isAdded()) {
            SavedState v0 = this.mFragmentManager.saveFragmentInstanceState(((Fragment)arg6));
        }
        else {
            v0_1 = v1;
        }

        v2.set(arg5, v0_1);
        this.mFragments.set(arg5, v1);
        this.mCurTransaction.remove(((Fragment)arg6));
    }

    public void finishUpdate(ViewGroup arg2) {
        if(this.mCurTransaction != null) {
            this.mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int arg1);

    public Object instantiateItem(ViewGroup arg5, int arg6) {
        Object v0;
        if(this.mFragments.size() > arg6) {
            v0 = this.mFragments.get(arg6);
            if(v0 == null) {
                goto label_8;
            }
        }
        else {
        label_8:
            if(this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }

            Fragment v1 = this.getItem(arg6);
            if(this.mSavedState.size() > arg6) {
                v0 = this.mSavedState.get(arg6);
                if(v0 != null) {
                    v1.setInitialSavedState(((SavedState)v0));
                }
            }

            while(this.mFragments.size() <= arg6) {
                this.mFragments.add(null);
            }

            v1.setMenuVisibility(false);
            v1.setUserVisibleHint(false);
            this.mFragments.set(arg6, v1);
            this.mCurTransaction.add(arg5.getId(), v1);
            Fragment v0_1 = v1;
        }

        return v0;
    }

    public boolean isViewFromObject(View arg2, Object arg3) {
        boolean v0 = ((Fragment)arg3).getView() == arg2 ? true : false;
        return v0;
    }

    public void restoreState(Parcelable arg7, ClassLoader arg8) {
        Fragment v4;
        int v3_1;
        if(arg7 != null) {
            ((Bundle)arg7).setClassLoader(arg8);
            Parcelable[] v3 = ((Bundle)arg7).getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if(v3 != null) {
                int v1;
                for(v1 = 0; v1 < v3.length; ++v1) {
                    this.mSavedState.add(v3[v1]);
                }
            }

            Iterator v1_1 = ((Bundle)arg7).keySet().iterator();
            while(true) {
            label_21:
                if(!v1_1.hasNext()) {
                    return;
                }

                Object v0 = v1_1.next();
                if(!((String)v0).startsWith("f")) {
                    continue;
                }

                v3_1 = Integer.parseInt(((String)v0).substring(1));
                v4 = this.mFragmentManager.getFragment(((Bundle)arg7), ((String)v0));
                if(v4 == null) {
                    Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + (((String)v0)));
                    continue;
                }

                break;
            }

            while(this.mFragments.size() <= v3_1) {
                this.mFragments.add(null);
            }

            v4.setMenuVisibility(false);
            this.mFragments.set(v3_1, v4);
            goto label_21;
        }
    }

    public Parcelable saveState() {
        Bundle v0 = null;
        if(this.mSavedState.size() > 0) {
            v0 = new Bundle();
            SavedState[] v1 = new SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(((Object[])v1));
            v0.putParcelableArray("states", ((Parcelable[])v1));
        }

        int v1_1 = 0;
        Bundle v2 = v0;
        while(v1_1 < this.mFragments.size()) {
            Object v0_1 = this.mFragments.get(v1_1);
            if(v0_1 != null && (((Fragment)v0_1).isAdded())) {
                if(v2 == null) {
                    v2 = new Bundle();
                }

                this.mFragmentManager.putFragment(v2, "f" + v1_1, ((Fragment)v0_1));
            }

            ++v1_1;
        }

        return ((Parcelable)v2);
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

