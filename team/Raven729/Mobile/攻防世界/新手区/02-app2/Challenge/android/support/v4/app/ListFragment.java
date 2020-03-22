package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    class android.support.v4.app.ListFragment$1 implements Runnable {
        android.support.v4.app.ListFragment$1(ListFragment arg1) {
            ListFragment.this = arg1;
            super();
        }

        public void run() {
            ListFragment.this.mList.focusableViewAvailable(ListFragment.this.mList);
        }
    }

    class android.support.v4.app.ListFragment$2 implements AdapterView$OnItemClickListener {
        android.support.v4.app.ListFragment$2(ListFragment arg1) {
            ListFragment.this = arg1;
            super();
        }

        public void onItemClick(AdapterView arg7, View arg8, int arg9, long arg10) {
            ListFragment.this.onListItemClick(arg7, arg8, arg9, arg10);
        }
    }

    static final int INTERNAL_EMPTY_ID = 0xFF0001;
    static final int INTERNAL_LIST_CONTAINER_ID = 0xFF0003;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 0xFF0002;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView$OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public ListFragment() {
        super();
        this.mHandler = new Handler();
        this.mRequestFocus = new android.support.v4.app.ListFragment$1(this);
        this.mOnClickListener = new android.support.v4.app.ListFragment$2(this);
    }

    private void ensureList() {
        if(this.mList == null) {
            View v0 = this.getView();
            if(v0 == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            else {
                if((v0 instanceof ListView)) {
                    this.mList = ((ListView)v0);
                }
                else {
                    this.mStandardEmptyView = v0.findViewById(0xFF0001);
                    if(this.mStandardEmptyView == null) {
                        this.mEmptyView = v0.findViewById(0x1020004);
                    }
                    else {
                        this.mStandardEmptyView.setVisibility(8);
                    }

                    this.mProgressContainer = v0.findViewById(0xFF0002);
                    this.mListContainer = v0.findViewById(0xFF0003);
                    v0 = v0.findViewById(0x102000A);
                    if(!(v0 instanceof ListView)) {
                        if(v0 == null) {
                            throw new RuntimeException("Your content must have a ListView whose id attribute is \'android.R.id.list\'");
                        }

                        throw new RuntimeException("Content has view with id attribute \'android.R.id.list\' that is not a ListView class");
                    }

                    this.mList = ((ListView)v0);
                    if(this.mEmptyView != null) {
                        this.mList.setEmptyView(this.mEmptyView);
                        goto label_13;
                    }

                    if(this.mEmptyText == null) {
                        goto label_13;
                    }

                    this.mStandardEmptyView.setText(this.mEmptyText);
                    this.mList.setEmptyView(this.mStandardEmptyView);
                }

            label_13:
                this.mListShown = true;
                this.mList.setOnItemClickListener(this.mOnClickListener);
                if(this.mAdapter != null) {
                    ListAdapter v0_1 = this.mAdapter;
                    this.mAdapter = null;
                    this.setListAdapter(v0_1);
                }
                else if(this.mProgressContainer != null) {
                    this.setListShown(false, false);
                }

                this.mHandler.post(this.mRequestFocus);
            }
        }
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public ListView getListView() {
        this.ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater arg10, ViewGroup arg11, Bundle arg12) {
        Context v0 = this.getContext();
        FrameLayout v1 = new FrameLayout(v0);
        LinearLayout v2 = new LinearLayout(v0);
        v2.setId(0xFF0002);
        v2.setOrientation(1);
        v2.setVisibility(8);
        v2.setGravity(17);
        v2.addView(new ProgressBar(v0, null, 0x101007A), new FrameLayout$LayoutParams(-2, -2));
        v1.addView(((View)v2), new FrameLayout$LayoutParams(-1, -1));
        FrameLayout v2_1 = new FrameLayout(v0);
        v2_1.setId(0xFF0003);
        TextView v3 = new TextView(v0);
        v3.setId(0xFF0001);
        v3.setGravity(17);
        v2_1.addView(((View)v3), new FrameLayout$LayoutParams(-1, -1));
        ListView v3_1 = new ListView(v0);
        v3_1.setId(0x102000A);
        v3_1.setDrawSelectorOnTop(false);
        v2_1.addView(((View)v3_1), new FrameLayout$LayoutParams(-1, -1));
        v1.addView(((View)v2_1), new FrameLayout$LayoutParams(-1, -1));
        v1.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        return ((View)v1);
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView arg1, View arg2, int arg3, long arg4) {
    }

    public void onViewCreated(View arg1, Bundle arg2) {
        super.onViewCreated(arg1, arg2);
        this.ensureList();
    }

    public void setEmptyText(CharSequence arg3) {
        this.ensureList();
        if(this.mStandardEmptyView == null) {
            throw new IllegalStateException("Can\'t be used with a custom content view");
        }

        this.mStandardEmptyView.setText(arg3);
        if(this.mEmptyText == null) {
            this.mList.setEmptyView(this.mStandardEmptyView);
        }

        this.mEmptyText = arg3;
    }

    public void setListAdapter(ListAdapter arg5) {
        boolean v2 = false;
        int v0 = this.mAdapter != null ? 1 : 0;
        this.mAdapter = arg5;
        if(this.mList != null) {
            this.mList.setAdapter(arg5);
            if(!this.mListShown && v0 == 0) {
                if(this.getView().getWindowToken() != null) {
                    v2 = true;
                }

                this.setListShown(true, v2);
            }
        }
    }

    private void setListShown(boolean arg7, boolean arg8) {
        int v5 = 0x10A0001;
        int v4 = 0x10A0000;
        int v3 = 8;
        this.ensureList();
        if(this.mProgressContainer == null) {
            throw new IllegalStateException("Can\'t be used with a custom content view");
        }

        if(this.mListShown != arg7) {
            this.mListShown = arg7;
            if(arg7) {
                if(arg8) {
                    this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v5));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v4));
                }
                else {
                    this.mProgressContainer.clearAnimation();
                    this.mListContainer.clearAnimation();
                }

                this.mProgressContainer.setVisibility(v3);
                this.mListContainer.setVisibility(0);
            }
            else {
                if(arg8) {
                    this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v4));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getContext(), v5));
                }
                else {
                    this.mProgressContainer.clearAnimation();
                    this.mListContainer.clearAnimation();
                }

                this.mProgressContainer.setVisibility(0);
                this.mListContainer.setVisibility(v3);
            }
        }
    }

    public void setListShown(boolean arg2) {
        this.setListShown(arg2, true);
    }

    public void setListShownNoAnimation(boolean arg2) {
        this.setListShown(arg2, false);
    }

    public void setSelection(int arg2) {
        this.ensureList();
        this.mList.setSelection(arg2);
    }
}

