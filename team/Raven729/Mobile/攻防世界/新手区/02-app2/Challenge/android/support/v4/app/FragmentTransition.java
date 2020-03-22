package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class FragmentTransition {
    class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
            super();
        }
    }

    private static final int[] INVERSE_OPS;

    static {
        FragmentTransition.INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6};
    }

    FragmentTransition() {
        super();
    }

    static void access$000(ArrayList arg0, int arg1) {
        FragmentTransition.setViewVisibility(arg0, arg1);
    }

    static ArrayList access$100(Object arg1, Fragment arg2, ArrayList arg3, View arg4) {
        return FragmentTransition.configureEnteringExitingViews(arg1, arg2, arg3, arg4);
    }

    static void access$200(Fragment arg0, Fragment arg1, boolean arg2, ArrayMap arg3, boolean arg4) {
        FragmentTransition.callSharedElementStartEnd(arg0, arg1, arg2, arg3, arg4);
    }

    static ArrayMap access$300(ArrayMap arg1, Object arg2, FragmentContainerTransition arg3) {
        return FragmentTransition.captureInSharedElements(arg1, arg2, arg3);
    }

    static View access$400(ArrayMap arg1, FragmentContainerTransition arg2, Object arg3, boolean arg4) {
        return FragmentTransition.getInEpicenterView(arg1, arg2, arg3, arg4);
    }

    private static void addSharedElementsWithMatchingNames(ArrayList arg3, ArrayMap arg4, Collection arg5) {
        int v1;
        for(v1 = arg4.size() - 1; v1 >= 0; --v1) {
            Object v0 = arg4.valueAt(v1);
            if(arg5.contains(ViewCompat.getTransitionName(((View)v0)))) {
                arg3.add(v0);
            }
        }
    }

    private static void addToFirstInLastOut(BackStackRecord arg11, Op arg12, SparseArray arg13, boolean arg14, boolean arg15) {
        FragmentContainerTransition v0_4;
        FragmentContainerTransition v8;
        boolean v5;
        int v7;
        int v6;
        int v4;
        boolean v0_1;
        Fragment v10 = null;
        Fragment v1 = arg12.fragment;
        int v9 = v1.mContainerId;
        if(v9 != 0) {
            int v0 = arg14 ? FragmentTransition.INVERSE_OPS[arg12.cmd] : arg12.cmd;
            switch(v0) {
                case 4: {
                    if(arg15) {
                        if((v1.mHiddenChanged) && (v1.mAdded) && (v1.mHidden)) {
                            v0 = 1;
                            goto label_96;
                        }

                        v0 = 0;
                    }
                    else {
                        if((v1.mAdded) && !v1.mHidden) {
                            v0 = 1;
                            goto label_96;
                        }

                        v0 = 0;
                    }

                label_96:
                    v4 = 0;
                    v6 = v0;
                    v7 = 1;
                    v5 = false;
                    break;
                }
                case 5: {
                    if(arg15) {
                        if((v1.mHiddenChanged) && !v1.mHidden && (v1.mAdded)) {
                            v0_1 = true;
                            goto label_64;
                        }

                        v0_1 = false;
                    }
                    else {
                        v0_1 = v1.mHidden;
                    }

                label_64:
                    v4 = 1;
                    v6 = 0;
                    v7 = 0;
                    v5 = v0_1;
                    break;
                }
                case 3: 
                case 6: {
                    if(arg15) {
                        if(!v1.mAdded && v1.mView != null && v1.mView.getVisibility() == 0 && v1.mPostponedAlpha >= 0f) {
                            v0 = 1;
                            goto label_123;
                        }

                        v0 = 0;
                    }
                    else {
                        if((v1.mAdded) && !v1.mHidden) {
                            v0 = 1;
                            goto label_123;
                        }

                        v0 = 0;
                    }

                label_123:
                    v4 = 0;
                    v6 = v0;
                    v7 = 1;
                    v5 = false;
                    break;
                }
                case 1: 
                case 7: {
                    if(arg15) {
                        v0_1 = v1.mIsNewlyAdded;
                    }
                    else {
                        if(!v1.mAdded && !v1.mHidden) {
                            v0_1 = true;
                            goto label_75;
                        }

                        v0_1 = false;
                    }

                label_75:
                    v4 = 1;
                    v6 = 0;
                    v7 = 0;
                    v5 = v0_1;
                    break;
                }
                default: {
                    v4 = 0;
                    v6 = 0;
                    v7 = 0;
                    v5 = false;
                    break;
                }
            }

            Object v0_2 = arg13.get(v9);
            if(v5) {
                v8 = FragmentTransition.ensureContainer(((FragmentContainerTransition)v0_2), arg13, v9);
                v8.lastIn = v1;
                v8.lastInIsPop = arg14;
                v8.lastInTransaction = arg11;
            }
            else {
                Object v8_1 = v0_2;
            }

            if(!arg15 && v4 != 0) {
                if(v8 != null && v8.firstOut == v1) {
                    v8.firstOut = v10;
                }

                FragmentManagerImpl v0_3 = arg11.mManager;
                if(v1.mState >= 1) {
                    goto label_39;
                }

                if(v0_3.mCurState < 1) {
                    goto label_39;
                }

                if(arg11.mAllowOptimization) {
                    goto label_39;
                }

                v0_3.makeActive(v1);
                v0_3.moveToState(v1, 1, 0, 0, false);
            }

        label_39:
            if(v6 != 0) {
                if(v8 != null && v8.firstOut != null) {
                    goto label_138;
                }

                v0_4 = FragmentTransition.ensureContainer(v8, arg13, v9);
                v0_4.firstOut = v1;
                v0_4.firstOutIsPop = arg14;
                v0_4.firstOutTransaction = arg11;
            }
            else {
            label_138:
                v0_4 = v8;
            }

            if(arg15) {
                return;
            }

            if(v7 == 0) {
                return;
            }

            if(v0_4 == null) {
                return;
            }

            if(v0_4.lastIn != v1) {
                return;
            }

            v0_4.lastIn = v10;
        }
    }

    public static void calculateFragments(BackStackRecord arg4, SparseArray arg5, boolean arg6) {
        int v3 = arg4.mOps.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            FragmentTransition.addToFirstInLastOut(arg4, arg4.mOps.get(v1), arg5, false, arg6);
        }
    }

    private static ArrayMap calculateNameOverrides(int arg9, ArrayList arg10, ArrayList arg11, int arg12, int arg13) {
        ArrayList v4;
        ArrayList v3;
        ArrayMap v7 = new ArrayMap();
        int v6;
        for(v6 = arg13 - 1; v6 >= arg12; --v6) {
            Object v0 = arg10.get(v6);
            if(((BackStackRecord)v0).interactsWith(arg9)) {
                boolean v1 = arg11.get(v6).booleanValue();
                if(((BackStackRecord)v0).mSharedElementSourceNames != null) {
                    int v8 = ((BackStackRecord)v0).mSharedElementSourceNames.size();
                    if(v1) {
                        v3 = ((BackStackRecord)v0).mSharedElementSourceNames;
                        v4 = ((BackStackRecord)v0).mSharedElementTargetNames;
                    }
                    else {
                        ArrayList v1_1 = ((BackStackRecord)v0).mSharedElementSourceNames;
                        v3 = ((BackStackRecord)v0).mSharedElementTargetNames;
                        v4 = v1_1;
                    }

                    int v5;
                    for(v5 = 0; v5 < v8; ++v5) {
                        v0 = v4.get(v5);
                        Object v1_2 = v3.get(v5);
                        Object v2 = v7.remove(v1_2);
                        if(v2 != null) {
                            v7.put(v0, v2);
                        }
                        else {
                            v7.put(v0, v1_2);
                        }
                    }
                }
            }
        }

        return v7;
    }

    public static void calculatePopFragments(BackStackRecord arg3, SparseArray arg4, boolean arg5) {
        if(arg3.mManager.mContainer.onHasView()) {
            int v1;
            for(v1 = arg3.mOps.size() - 1; v1 >= 0; --v1) {
                FragmentTransition.addToFirstInLastOut(arg3, arg3.mOps.get(v1), arg4, true, arg5);
            }
        }
    }

    private static void callSharedElementStartEnd(Fragment arg7, Fragment arg8, boolean arg9, ArrayMap arg10, boolean arg11) {
        List v6 = null;
        int v1 = 0;
        SharedElementCallback v2 = arg9 ? arg8.getEnterTransitionCallback() : arg7.getEnterTransitionCallback();
        if(v2 != null) {
            ArrayList v3 = new ArrayList();
            ArrayList v4 = new ArrayList();
            int v0 = arg10 == null ? 0 : arg10.size();
            while(v1 < v0) {
                v4.add(arg10.keyAt(v1));
                v3.add(arg10.valueAt(v1));
                ++v1;
            }

            if(arg11) {
                v2.onSharedElementStart(((List)v4), ((List)v3), v6);
                return;
            }

            v2.onSharedElementEnd(((List)v4), ((List)v3), v6);
        }
    }

    private static ArrayMap captureInSharedElements(ArrayMap arg6, Object arg7, FragmentContainerTransition arg8) {
        ArrayMap v0_4;
        String v0_3;
        SharedElementCallback v0_1;
        ArrayList v4;
        SharedElementCallback v1_1;
        Fragment v0 = arg8.lastIn;
        View v1 = v0.getView();
        if((arg6.isEmpty()) || arg7 == null || v1 == null) {
            arg6.clear();
            v0_4 = null;
        }
        else {
            ArrayMap v2 = new ArrayMap();
            FragmentTransitionCompat21.findNamedViews(((Map)v2), v1);
            BackStackRecord v3 = arg8.lastInTransaction;
            if(arg8.lastInIsPop) {
                v1_1 = v0.getExitTransitionCallback();
                v4 = v3.mSharedElementSourceNames;
                v0_1 = v1_1;
            }
            else {
                v1_1 = v0.getEnterTransitionCallback();
                v4 = v3.mSharedElementTargetNames;
                v0_1 = v1_1;
            }

            if(v4 != null) {
                v2.retainAll(((Collection)v4));
            }

            if(v0_1 != null) {
                v0_1.onMapSharedElements(((List)v4), ((Map)v2));
                int v3_1;
                for(v3_1 = v4.size() - 1; v3_1 >= 0; --v3_1) {
                    Object v0_2 = v4.get(v3_1);
                    Object v1_2 = v2.get(v0_2);
                    if(v1_2 == null) {
                        v0_3 = FragmentTransition.findKeyForValue(arg6, ((String)v0_2));
                        if(v0_3 != null) {
                            arg6.remove(v0_3);
                        }
                    }
                    else if(!((String)v0_2).equals(ViewCompat.getTransitionName(((View)v1_2)))) {
                        v0_3 = FragmentTransition.findKeyForValue(arg6, ((String)v0_2));
                        if(v0_3 != null) {
                            arg6.put(v0_3, ViewCompat.getTransitionName(((View)v1_2)));
                        }
                    }
                }
            }
            else {
                FragmentTransition.retainValues(arg6, v2);
            }

            v0_4 = v2;
        }

        return v0_4;
    }

    private static ArrayMap captureOutSharedElements(ArrayMap arg6, Object arg7, FragmentContainerTransition arg8) {
        ArrayMap v0_3;
        SharedElementCallback v0_1;
        ArrayList v2_1;
        SharedElementCallback v1;
        if((arg6.isEmpty()) || arg7 == null) {
            arg6.clear();
            v0_3 = null;
        }
        else {
            Fragment v0 = arg8.firstOut;
            ArrayMap v3 = new ArrayMap();
            FragmentTransitionCompat21.findNamedViews(((Map)v3), v0.getView());
            BackStackRecord v2 = arg8.firstOutTransaction;
            if(arg8.firstOutIsPop) {
                v1 = v0.getEnterTransitionCallback();
                v2_1 = v2.mSharedElementTargetNames;
                v0_1 = v1;
            }
            else {
                v1 = v0.getExitTransitionCallback();
                v2_1 = v2.mSharedElementSourceNames;
                v0_1 = v1;
            }

            v3.retainAll(((Collection)v2_1));
            if(v0_1 != null) {
                v0_1.onMapSharedElements(((List)v2_1), ((Map)v3));
                int v4;
                for(v4 = v2_1.size() - 1; v4 >= 0; --v4) {
                    Object v0_2 = v2_1.get(v4);
                    Object v1_1 = v3.get(v0_2);
                    if(v1_1 == null) {
                        arg6.remove(v0_2);
                    }
                    else if(!((String)v0_2).equals(ViewCompat.getTransitionName(((View)v1_1)))) {
                        arg6.put(ViewCompat.getTransitionName(((View)v1_1)), arg6.remove(v0_2));
                    }
                }
            }
            else {
                arg6.retainAll(v3.keySet());
            }

            v0_3 = v3;
        }

        return v0_3;
    }

    private static ArrayList configureEnteringExitingViews(Object arg2, Fragment arg3, ArrayList arg4, View arg5) {
        ArrayList v0 = null;
        if(arg2 != null) {
            v0 = new ArrayList();
            View v1 = arg3.getView();
            if(v1 != null) {
                FragmentTransitionCompat21.captureTransitioningViews(v0, v1);
            }

            if(arg4 != null) {
                v0.removeAll(((Collection)arg4));
            }

            if(v0.isEmpty()) {
                return v0;
            }

            v0.add(arg5);
            FragmentTransitionCompat21.addTargets(arg2, v0);
        }

        return v0;
    }

    private static Object configureSharedElementsOptimized(ViewGroup arg8, View arg9, ArrayMap arg10, FragmentContainerTransition arg11, ArrayList arg12, ArrayList arg13, Object arg14, Object arg15) {
        View v5_1;
        Rect v6_1;
        Object v7;
        Object v5 = null;
        Fragment v1 = arg11.lastIn;
        Fragment v2 = arg11.firstOut;
        if(v1 != null) {
            v1.getView().setVisibility(0);
        }

        if(v1 != null && v2 != null) {
            boolean v3 = arg11.lastInIsPop;
            Object v0 = arg10.isEmpty() ? v5 : FragmentTransition.getSharedElementTransition(v1, v2, v3);
            ArrayMap v6 = FragmentTransition.captureOutSharedElements(arg10, v0, arg11);
            ArrayMap v4 = FragmentTransition.captureInSharedElements(arg10, v0, arg11);
            if(arg10.isEmpty()) {
                if(v6 != null) {
                    v6.clear();
                }

                if(v4 != null) {
                    v4.clear();
                    v7 = v5;
                    goto label_23;
                }

                v7 = v5;
            }
            else {
                FragmentTransition.addSharedElementsWithMatchingNames(arg12, v6, arg10.keySet());
                FragmentTransition.addSharedElementsWithMatchingNames(arg13, v4, arg10.values());
                v7 = v0;
            }

        label_23:
            if(arg14 == null && arg15 == null && v7 == null) {
                return v5;
            }

            FragmentTransition.callSharedElementStartEnd(v1, v2, v3, v6, true);
            if(v7 != null) {
                arg13.add(arg9);
                FragmentTransitionCompat21.setSharedElementTargets(v7, arg9, arg12);
                FragmentTransition.setOutEpicenter(v7, arg15, v6, arg11.firstOutIsPop, arg11.firstOutTransaction);
                v6_1 = new Rect();
                v5_1 = FragmentTransition.getInEpicenterView(v4, arg11, arg14, v3);
                if(v5_1 != null) {
                    FragmentTransitionCompat21.setEpicenter(arg14, v6_1);
                }
            }
            else {
                v6_1 = ((Rect)v5);
            }

            OneShotPreDrawListener.add(((View)arg8), new Runnable(v1, v2, v3, v4, v5_1, v6_1) {
                public void run() {
                    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
                    if(this.val$epicenterView != null) {
                        FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView, this.val$epicenter);
                    }
                }
            });
            v5 = v7;
        }

        return v5;
    }

    private static Object configureSharedElementsUnoptimized(ViewGroup arg13, View arg14, ArrayMap arg15, FragmentContainerTransition arg16, ArrayList arg17, ArrayList arg18, Object arg19, Object arg20) {
        Rect v12;
        Object v3;
        Fragment v7 = arg16.lastIn;
        Fragment v8 = arg16.firstOut;
        if(v7 == null || v8 == null) {
            v3 = null;
        }
        else {
            boolean v9 = arg16.lastInIsPop;
            Object v1 = arg15.isEmpty() ? null : FragmentTransition.getSharedElementTransition(v7, v8, v9);
            ArrayMap v2 = FragmentTransition.captureOutSharedElements(arg15, v1, arg16);
            if(arg15.isEmpty()) {
                v3 = null;
            }
            else {
                arg17.addAll(v2.values());
                v3 = v1;
            }

            if(arg19 == null && arg20 == null && v3 == null) {
                return null;
            }

            FragmentTransition.callSharedElementStartEnd(v7, v8, v9, v2, true);
            if(v3 != null) {
                v12 = new Rect();
                FragmentTransitionCompat21.setSharedElementTargets(v3, arg14, arg17);
                FragmentTransition.setOutEpicenter(v3, arg20, v2, arg16.firstOutIsPop, arg16.firstOutTransaction);
                if(arg19 != null) {
                    FragmentTransitionCompat21.setEpicenter(arg19, v12);
                }
            }
            else {
                v12 = null;
            }

            OneShotPreDrawListener.add(((View)arg13), new Runnable(arg15, v3, arg16, arg18, arg14, v7, v8, v9, arg17, arg19, v12) {
                public void run() {
                    ArrayMap v0 = FragmentTransition.captureInSharedElements(this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
                    if(v0 != null) {
                        this.val$sharedElementsIn.addAll(v0.values());
                        this.val$sharedElementsIn.add(this.val$nonExistentView);
                    }

                    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, v0, false);
                    if(this.val$finalSharedElementTransition != null) {
                        FragmentTransitionCompat21.swapSharedElementTargets(this.val$finalSharedElementTransition, this.val$sharedElementsOut, this.val$sharedElementsIn);
                        View v0_1 = FragmentTransition.getInEpicenterView(v0, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
                        if(v0_1 != null) {
                            FragmentTransitionCompat21.getBoundsOnScreen(v0_1, this.val$inEpicenter);
                        }
                    }
                }
            });
        }

        return v3;
    }

    private static void configureTransitionsOptimized(FragmentManagerImpl arg16, int arg17, FragmentContainerTransition arg18, View arg19, ArrayMap arg20) {
        View v1 = null;
        if(arg16.mContainer.onHasView()) {
            v1 = arg16.mContainer.onFindViewById(arg17);
        }

        if(v1 != null) {
            Fragment v9 = arg18.lastIn;
            Fragment v10 = arg18.firstOut;
            boolean v12 = arg18.lastInIsPop;
            boolean v2 = arg18.firstOutIsPop;
            ArrayList v6 = new ArrayList();
            ArrayList v5 = new ArrayList();
            Object v7 = FragmentTransition.getEnterTransition(v9, v12);
            Object v8 = FragmentTransition.getExitTransition(v10, v2);
            Object v14 = FragmentTransition.configureSharedElementsOptimized(((ViewGroup)v1), arg19, arg20, arg18, v5, v6, v7, v8);
            if(v7 == null && v14 == null && v8 == null) {
                return;
            }

            ArrayList v13 = FragmentTransition.configureEnteringExitingViews(v8, v10, v5, arg19);
            ArrayList v11 = FragmentTransition.configureEnteringExitingViews(v7, v9, v6, arg19);
            FragmentTransition.setViewVisibility(v11, 4);
            Object v9_1 = FragmentTransition.mergeTransitions(v7, v8, v14, v9, v12);
            if(v9_1 == null) {
                return;
            }

            FragmentTransition.replaceHide(v8, v10, v13);
            ArrayList v2_1 = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(v6);
            FragmentTransitionCompat21.scheduleRemoveTargets(v9_1, v7, v11, v8, v13, v14, v6);
            FragmentTransitionCompat21.beginDelayedTransition(((ViewGroup)v1), v9_1);
            FragmentTransitionCompat21.setNameOverridesOptimized(v1, v5, v6, v2_1, arg20);
            FragmentTransition.setViewVisibility(v11, 0);
            FragmentTransitionCompat21.swapSharedElementTargets(v14, v5, v6);
        }
    }

    private static void configureTransitionsUnoptimized(FragmentManagerImpl arg21, int arg22, FragmentContainerTransition arg23, View arg24, ArrayMap arg25) {
        View v1 = null;
        if(arg21.mContainer.onHasView()) {
            v1 = arg21.mContainer.onFindViewById(arg22);
        }

        if(v1 != null) {
            Fragment v15 = arg23.lastIn;
            Fragment v9 = arg23.firstOut;
            boolean v2 = arg23.lastInIsPop;
            boolean v3 = arg23.firstOutIsPop;
            Object v7 = FragmentTransition.getEnterTransition(v15, v2);
            Object v8 = FragmentTransition.getExitTransition(v9, v3);
            ArrayList v5 = new ArrayList();
            ArrayList v6 = new ArrayList();
            Object v13 = FragmentTransition.configureSharedElementsUnoptimized(((ViewGroup)v1), arg24, arg25, arg23, v5, v6, v7, v8);
            if(v7 == null && v13 == null && v8 == null) {
                return;
            }

            ArrayList v12 = FragmentTransition.configureEnteringExitingViews(v8, v9, v5, arg24);
            Object v11 = v12 == null || (v12.isEmpty()) ? null : v8;
            FragmentTransitionCompat21.addTarget(v7, arg24);
            v8 = FragmentTransition.mergeTransitions(v7, v11, v13, v15, arg23.lastInIsPop);
            if(v8 == null) {
                return;
            }

            ArrayList v10 = new ArrayList();
            FragmentTransitionCompat21.scheduleRemoveTargets(v8, v7, v10, v11, v12, v13, v6);
            FragmentTransition.scheduleTargetChange(v1, v15, arg24, v6, v7, v10, v11, v12);
            FragmentTransitionCompat21.setNameOverridesUnoptimized(v1, v6, arg25);
            FragmentTransitionCompat21.beginDelayedTransition(((ViewGroup)v1), v8);
            FragmentTransitionCompat21.scheduleNameReset(((ViewGroup)v1), v6, arg25);
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition arg0, SparseArray arg1, int arg2) {
        if(arg0 == null) {
            arg0 = new FragmentContainerTransition();
            arg1.put(arg2, arg0);
        }

        return arg0;
    }

    private static String findKeyForValue(ArrayMap arg3, String arg4) {
        String v0_2;
        int v1 = arg3.size();
        int v0 = 0;
        while(true) {
            if(v0 >= v1) {
                break;
            }
            else if(arg4.equals(arg3.valueAt(v0))) {
                Object v0_1 = arg3.keyAt(v0);
            }
            else {
                ++v0;
                continue;
            }

            return v0_2;
        }

        v0_2 = null;
        return v0_2;
    }

    private static Object getEnterTransition(Fragment arg1, boolean arg2) {
        Object v0;
        if(arg1 == null) {
            v0 = null;
        }
        else {
            v0 = arg2 ? arg1.getReenterTransition() : arg1.getEnterTransition();
            v0 = FragmentTransitionCompat21.cloneTransition(v0);
        }

        return v0;
    }

    private static Object getExitTransition(Fragment arg1, boolean arg2) {
        Object v0;
        if(arg1 == null) {
            v0 = null;
        }
        else {
            v0 = arg2 ? arg1.getReturnTransition() : arg1.getExitTransition();
            v0 = FragmentTransitionCompat21.cloneTransition(v0);
        }

        return v0;
    }

    private static View getInEpicenterView(ArrayMap arg3, FragmentContainerTransition arg4, Object arg5, boolean arg6) {
        Object v0_1;
        BackStackRecord v0 = arg4.lastInTransaction;
        if(arg5 == null || arg3 == null || v0.mSharedElementSourceNames == null || (v0.mSharedElementSourceNames.isEmpty())) {
            View v0_2 = null;
        }
        else {
            v0_1 = arg6 ? v0.mSharedElementSourceNames.get(0) : v0.mSharedElementTargetNames.get(0);
            v0_1 = arg3.get(v0_1);
        }

        return ((View)v0_1);
    }

    private static Object getSharedElementTransition(Fragment arg1, Fragment arg2, boolean arg3) {
        Object v0;
        if(arg1 == null || arg2 == null) {
            v0 = null;
        }
        else {
            v0 = arg3 ? arg2.getSharedElementReturnTransition() : arg1.getSharedElementEnterTransition();
            v0 = FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(v0));
        }

        return v0;
    }

    private static Object mergeTransitions(Object arg1, Object arg2, Object arg3, Fragment arg4, boolean arg5) {
        boolean v0 = true;
        if(arg1 != null && arg2 != null && arg4 != null) {
            v0 = arg5 ? arg4.getAllowReturnTransitionOverlap() : arg4.getAllowEnterTransitionOverlap();
        }

        Object v0_1 = v0 ? FragmentTransitionCompat21.mergeTransitionsTogether(arg2, arg1, arg3) : FragmentTransitionCompat21.mergeTransitionsInSequence(arg2, arg1, arg3);
        return v0_1;
    }

    private static void replaceHide(Object arg2, Fragment arg3, ArrayList arg4) {
        if(arg3 != null && arg2 != null && (arg3.mAdded) && (arg3.mHidden) && (arg3.mHiddenChanged)) {
            arg3.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(arg2, arg3.getView(), arg4);
            OneShotPreDrawListener.add(arg3.mContainer, new Runnable(arg4) {
                public void run() {
                    FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
                }
            });
        }
    }

    private static void retainValues(ArrayMap arg2, ArrayMap arg3) {
        int v1;
        for(v1 = arg2.size() - 1; v1 >= 0; --v1) {
            if(!arg3.containsKey(arg2.valueAt(v1))) {
                arg2.removeAt(v1);
            }
        }
    }

    private static void scheduleTargetChange(ViewGroup arg8, Fragment arg9, View arg10, ArrayList arg11, Object arg12, ArrayList arg13, Object arg14, ArrayList arg15) {
        OneShotPreDrawListener.add(((View)arg8), new Runnable(arg12, arg10, arg9, arg11, arg13, arg15, arg14) {
            public void run() {
                if(this.val$enterTransition != null) {
                    FragmentTransitionCompat21.removeTarget(this.val$enterTransition, this.val$nonExistentView);
                    this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
                }

                if(this.val$exitingViews != null) {
                    if(this.val$exitTransition != null) {
                        ArrayList v0 = new ArrayList();
                        v0.add(this.val$nonExistentView);
                        FragmentTransitionCompat21.replaceTargets(this.val$exitTransition, this.val$exitingViews, v0);
                    }

                    this.val$exitingViews.clear();
                    this.val$exitingViews.add(this.val$nonExistentView);
                }
            }
        });
    }

    private static void setOutEpicenter(Object arg2, Object arg3, ArrayMap arg4, boolean arg5, BackStackRecord arg6) {
        if(arg6.mSharedElementSourceNames != null && !arg6.mSharedElementSourceNames.isEmpty()) {
            Object v0 = arg5 ? arg6.mSharedElementTargetNames.get(0) : arg6.mSharedElementSourceNames.get(0);
            v0 = arg4.get(v0);
            FragmentTransitionCompat21.setEpicenter(arg2, ((View)v0));
            if(arg3 == null) {
                return;
            }

            FragmentTransitionCompat21.setEpicenter(arg3, ((View)v0));
        }
    }

    private static void setViewVisibility(ArrayList arg2, int arg3) {
        if(arg2 != null) {
            int v1;
            for(v1 = arg2.size() - 1; v1 >= 0; --v1) {
                arg2.get(v1).setVisibility(arg3);
            }
        }
    }

    static void startTransitions(FragmentManagerImpl arg7, ArrayList arg8, ArrayList arg9, int arg10, int arg11, boolean arg12) {
        Object v0;
        if(arg7.mCurState >= 1 && Build$VERSION.SDK_INT >= 21) {
            SparseArray v3 = new SparseArray();
            int v2;
            for(v2 = arg10; v2 < arg11; ++v2) {
                v0 = arg8.get(v2);
                if(arg9.get(v2).booleanValue()) {
                    FragmentTransition.calculatePopFragments(((BackStackRecord)v0), v3, arg12);
                }
                else {
                    FragmentTransition.calculateFragments(((BackStackRecord)v0), v3, arg12);
                }
            }

            if(v3.size() == 0) {
                return;
            }

            View v2_1 = new View(arg7.mHost.getContext());
            int v4 = v3.size();
            int v1;
            for(v1 = 0; v1 < v4; ++v1) {
                int v5 = v3.keyAt(v1);
                ArrayMap v6 = FragmentTransition.calculateNameOverrides(v5, arg8, arg9, arg10, arg11);
                v0 = v3.valueAt(v1);
                if(arg12) {
                    FragmentTransition.configureTransitionsOptimized(arg7, v5, ((FragmentContainerTransition)v0), v2_1, v6);
                }
                else {
                    FragmentTransition.configureTransitionsUnoptimized(arg7, v5, ((FragmentContainerTransition)v0), v2_1, v6);
                }
            }
        }
    }
}

