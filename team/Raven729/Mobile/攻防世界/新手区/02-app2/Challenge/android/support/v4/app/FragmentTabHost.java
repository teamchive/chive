package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View$BaseSavedState;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost$OnTabChangeListener;
import android.widget.TabHost$TabContentFactory;
import android.widget.TabHost$TabSpec;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements TabHost$OnTabChangeListener {
    class DummyTabFactory implements TabHost$TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context arg1) {
            super();
            this.mContext = arg1;
        }

        public View createTabContent(String arg4) {
            View v0 = new View(this.mContext);
            v0.setMinimumWidth(0);
            v0.setMinimumHeight(0);
            return v0;
        }
    }

    class SavedState extends View$BaseSavedState {
        final class android.support.v4.app.FragmentTabHost$SavedState$1 implements Parcelable$Creator {
            android.support.v4.app.FragmentTabHost$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2);
            }

            public Object createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2);
            }

            public SavedState[] newArray(int arg2) {
                return new SavedState[arg2];
            }

            public Object[] newArray(int arg2) {
                return this.newArray(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        String curTab;

        static {
            SavedState.CREATOR = new android.support.v4.app.FragmentTabHost$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2) {
            super(arg2);
            this.curTab = arg2.readString();
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeString(this.curTab);
        }
    }

    final class TabInfo {
        @Nullable final Bundle args;
        @NonNull final Class clss;
        Fragment fragment;
        @NonNull final String tag;

        TabInfo(@NonNull String arg1, @NonNull Class arg2, @Nullable Bundle arg3) {
            super();
            this.tag = arg1;
            this.clss = arg2;
            this.args = arg3;
        }
    }

    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost$OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList mTabs;

    public FragmentTabHost(Context arg3) {
        super(arg3, null);
        this.mTabs = new ArrayList();
        this.initFragmentTabHost(arg3, null);
    }

    public FragmentTabHost(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mTabs = new ArrayList();
        this.initFragmentTabHost(arg2, arg3);
    }

    public void addTab(@NonNull TabHost$TabSpec arg4, @NonNull Class arg5, @Nullable Bundle arg6) {
        arg4.setContent(new DummyTabFactory(this.mContext));
        String v0 = arg4.getTag();
        TabInfo v1 = new TabInfo(v0, arg5, arg6);
        if(this.mAttached) {
            v1.fragment = this.mFragmentManager.findFragmentByTag(v0);
            if(v1.fragment != null && !v1.fragment.isDetached()) {
                FragmentTransaction v0_1 = this.mFragmentManager.beginTransaction();
                v0_1.detach(v1.fragment);
                v0_1.commit();
            }
        }

        this.mTabs.add(v1);
        this.addTab(arg4);
    }

    @Nullable private FragmentTransaction doTabChanged(@Nullable String arg5, @Nullable FragmentTransaction arg6) {
        TabInfo v0 = this.getTabInfoForTag(arg5);
        if(this.mLastTab != v0) {
            if(arg6 == null) {
                arg6 = this.mFragmentManager.beginTransaction();
            }

            if(this.mLastTab != null && this.mLastTab.fragment != null) {
                arg6.detach(this.mLastTab.fragment);
            }

            if(v0 != null) {
                if(v0.fragment == null) {
                    v0.fragment = Fragment.instantiate(this.mContext, v0.clss.getName(), v0.args);
                    arg6.add(this.mContainerId, v0.fragment, v0.tag);
                }
                else {
                    arg6.attach(v0.fragment);
                }
            }

            this.mLastTab = v0;
        }

        return arg6;
    }

    private void ensureContent() {
        if(this.mRealTabContent == null) {
            this.mRealTabContent = this.findViewById(this.mContainerId);
            if(this.mRealTabContent == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
            }
        }
    }

    private void ensureHierarchy(Context arg8) {
        int v2 = 0x1020013;
        int v4 = -1;
        if(this.findViewById(v2) == null) {
            LinearLayout v0 = new LinearLayout(arg8);
            v0.setOrientation(1);
            this.addView(((View)v0), new FrameLayout$LayoutParams(v4, v4));
            TabWidget v1 = new TabWidget(arg8);
            v1.setId(v2);
            v1.setOrientation(0);
            v0.addView(((View)v1), new LinearLayout$LayoutParams(v4, -2, 0f));
            FrameLayout v1_1 = new FrameLayout(arg8);
            v1_1.setId(0x1020011);
            v0.addView(((View)v1_1), new LinearLayout$LayoutParams(0, 0, 0f));
            v1_1 = new FrameLayout(arg8);
            this.mRealTabContent = v1_1;
            this.mRealTabContent.setId(this.mContainerId);
            v0.addView(((View)v1_1), new LinearLayout$LayoutParams(v4, 0, 1f));
        }
    }

    @Nullable private TabInfo getTabInfoForTag(String arg5) {
        TabInfo v0_1;
        int v2 = this.mTabs.size();
        int v1 = 0;
        while(true) {
            if(v1 < v2) {
                Object v0 = this.mTabs.get(v1);
                if(!((TabInfo)v0).tag.equals(arg5)) {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            return v0_1;
        }

        v0_1 = null;
        return v0_1;
    }

    private void initFragmentTabHost(Context arg4, AttributeSet arg5) {
        TypedArray v0 = arg4.obtainStyledAttributes(arg5, new int[]{0x10100F3}, 0, 0);
        this.mContainerId = v0.getResourceId(0, 0);
        v0.recycle();
        super.setOnTabChangedListener(((TabHost$OnTabChangeListener)this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String v3 = this.getCurrentTabTag();
        FragmentTransaction v1 = null;
        int v4 = this.mTabs.size();
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            Object v0 = this.mTabs.get(v2);
            ((TabInfo)v0).fragment = this.mFragmentManager.findFragmentByTag(((TabInfo)v0).tag);
            if(((TabInfo)v0).fragment != null && !((TabInfo)v0).fragment.isDetached()) {
                if(((TabInfo)v0).tag.equals(v3)) {
                    this.mLastTab = ((TabInfo)v0);
                }
                else {
                    if(v1 == null) {
                        v1 = this.mFragmentManager.beginTransaction();
                    }

                    v1.detach(((TabInfo)v0).fragment);
                }
            }
        }

        this.mAttached = true;
        FragmentTransaction v0_1 = this.doTabChanged(v3, v1);
        if(v0_1 != null) {
            v0_1.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
        }
        else {
            super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
            this.setCurrentTabByTag(((SavedState)arg2).curTab);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.curTab = this.getCurrentTabTag();
        return ((Parcelable)v1);
    }

    public void onTabChanged(String arg2) {
        if(this.mAttached) {
            FragmentTransaction v0 = this.doTabChanged(arg2, null);
            if(v0 != null) {
                v0.commit();
            }
        }

        if(this.mOnTabChangeListener != null) {
            this.mOnTabChangeListener.onTabChanged(arg2);
        }
    }

    public void setOnTabChangedListener(TabHost$OnTabChangeListener arg1) {
        this.mOnTabChangeListener = arg1;
    }

    @Deprecated public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context arg1, FragmentManager arg2) {
        this.ensureHierarchy(arg1);
        super.setup();
        this.mContext = arg1;
        this.mFragmentManager = arg2;
        this.ensureContent();
    }

    public void setup(Context arg3, FragmentManager arg4, int arg5) {
        this.ensureHierarchy(arg3);
        super.setup();
        this.mContext = arg3;
        this.mFragmentManager = arg4;
        this.mContainerId = arg5;
        this.ensureContent();
        this.mRealTabContent.setId(arg5);
        if(this.getId() == -1) {
            this.setId(0x1020012);
        }
    }
}

