package android.support.v4.app;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.transition.Transition$EpicenterCallback;
import android.transition.Transition$TransitionListener;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

@TargetApi(value=21) @RequiresApi(value=21) class FragmentTransitionCompat21 {
    FragmentTransitionCompat21() {
        super();
    }

    static String access$000(Map arg1, String arg2) {
        return FragmentTransitionCompat21.findKeyForValue(arg1, arg2);
    }

    public static void addTarget(Object arg0, View arg1) {
        if(arg0 != null) {
            ((Transition)arg0).addTarget(arg1);
        }
    }

    public static void addTargets(Object arg3, ArrayList arg4) {
        int v1;
        int v0 = 0;
        if(arg3 != null) {
            if((arg3 instanceof TransitionSet)) {
                v1 = ((TransitionSet)arg3).getTransitionCount();
                while(v0 < v1) {
                    FragmentTransitionCompat21.addTargets(((TransitionSet)arg3).getTransitionAt(v0), arg4);
                    ++v0;
                }
            }
            else if(!FragmentTransitionCompat21.hasSimpleTarget(((Transition)arg3)) && (FragmentTransitionCompat21.isNullOrEmpty(((Transition)arg3).getTargets()))) {
                int v2 = arg4.size();
                for(v1 = 0; v1 < v2; ++v1) {
                    ((Transition)arg3).addTarget(arg4.get(v1));
                }
            }
        }
    }

    public static void beginDelayedTransition(ViewGroup arg0, Object arg1) {
        TransitionManager.beginDelayedTransition(arg0, ((Transition)arg1));
    }

    private static void bfsAddViewChildren(List arg7, View arg8) {
        int v2 = arg7.size();
        if(!FragmentTransitionCompat21.containedBeforeIndex(arg7, arg8, v2)) {
            arg7.add(arg8);
            int v1;
            for(v1 = v2; v1 < arg7.size(); ++v1) {
                Object v0 = arg7.get(v1);
                if((v0 instanceof ViewGroup)) {
                    int v4 = ((ViewGroup)v0).getChildCount();
                    int v3;
                    for(v3 = 0; v3 < v4; ++v3) {
                        View v5 = ((ViewGroup)v0).getChildAt(v3);
                        if(!FragmentTransitionCompat21.containedBeforeIndex(arg7, v5, v2)) {
                            arg7.add(v5);
                        }
                    }
                }
            }
        }
    }

    public static void captureTransitioningViews(ArrayList arg3, View arg4) {
        if(arg4.getVisibility() == 0) {
            if(!(arg4 instanceof ViewGroup)) {
                arg3.add(arg4);
            }
            else if(((ViewGroup)arg4).isTransitionGroup()) {
                arg3.add(arg4);
            }
            else {
                int v1 = ((ViewGroup)arg4).getChildCount();
                int v0;
                for(v0 = 0; v0 < v1; ++v0) {
                    FragmentTransitionCompat21.captureTransitioningViews(arg3, ((ViewGroup)arg4).getChildAt(v0));
                }
            }
        }
    }

    public static Object cloneTransition(Object arg1) {
        Object v0 = null;
        if(arg1 != null) {
            Transition v0_1 = ((Transition)arg1).clone();
        }

        return v0;
    }

    private static boolean containedBeforeIndex(List arg3, View arg4, int arg5) {
        boolean v0 = false;
        int v1 = 0;
        while(v1 < arg5) {
            if(arg3.get(v1) == arg4) {
                v0 = true;
            }
            else {
                ++v1;
                continue;
            }

            return v0;
        }

        return v0;
    }

    private static String findKeyForValue(Map arg3, String arg4) {
        String v0_1;
        Object v0;
        Iterator v1 = arg3.entrySet().iterator();
        do {
            if(v1.hasNext()) {
                v0 = v1.next();
                if(!arg4.equals(((Map$Entry)v0).getValue())) {
                    continue;
                }

                break;
            }
            else {
                goto label_10;
            }
        }
        while(true);

        v0 = ((Map$Entry)v0).getKey();
        return v0_1;
    label_10:
        v0_1 = null;
        return v0_1;
    }

    public static void findNamedViews(Map arg3, View arg4) {
        if(arg4.getVisibility() == 0) {
            String v0 = arg4.getTransitionName();
            if(v0 != null) {
                arg3.put(v0, arg4);
            }

            if(!(arg4 instanceof ViewGroup)) {
                return;
            }

            int v1 = ((ViewGroup)arg4).getChildCount();
            int v0_1;
            for(v0_1 = 0; v0_1 < v1; ++v0_1) {
                FragmentTransitionCompat21.findNamedViews(arg3, ((ViewGroup)arg4).getChildAt(v0_1));
            }
        }
    }

    public static void getBoundsOnScreen(View arg6, Rect arg7) {
        int[] v0 = new int[2];
        arg6.getLocationOnScreen(v0);
        arg7.set(v0[0], v0[1], v0[0] + arg6.getWidth(), v0[1] + arg6.getHeight());
    }

    private static boolean hasSimpleTarget(Transition arg1) {
        boolean v0 = !FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetIds()) || !FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetNames()) || !FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetTypes()) ? true : false;
        return v0;
    }

    private static boolean isNullOrEmpty(List arg1) {
        boolean v0 = arg1 == null || (arg1.isEmpty()) ? true : false;
        return v0;
    }

    public static Object mergeTransitionsInSequence(Object arg2, Object arg3, Object arg4) {
        TransitionSet v0;
        Object v1_1;
        TransitionSet v1 = null;
        if(arg2 != null && arg3 != null) {
            v1 = new TransitionSet().addTransition(((Transition)arg2)).addTransition(((Transition)arg3)).setOrdering(1);
        }
        else if(arg2 != null) {
            v1_1 = arg2;
        }
        else if(arg3 != null) {
            v1_1 = arg3;
        }

        if(arg4 != null) {
            v0 = new TransitionSet();
            if(v1 != null) {
                v0.addTransition(((Transition)v1));
            }

            v0.addTransition(((Transition)arg4));
        }
        else {
            v0 = v1;
        }

        return v0;
    }

    public static Object mergeTransitionsTogether(Object arg1, Object arg2, Object arg3) {
        TransitionSet v0 = new TransitionSet();
        if(arg1 != null) {
            v0.addTransition(((Transition)arg1));
        }

        if(arg2 != null) {
            v0.addTransition(((Transition)arg2));
        }

        if(arg3 != null) {
            v0.addTransition(((Transition)arg3));
        }

        return v0;
    }

    public static ArrayList prepareSetNameOverridesOptimized(ArrayList arg5) {
        ArrayList v2 = new ArrayList();
        int v3 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            Object v0 = arg5.get(v1);
            v2.add(((View)v0).getTransitionName());
            ((View)v0).setTransitionName(null);
        }

        return v2;
    }

    public static void removeTarget(Object arg0, View arg1) {
        if(arg0 != null) {
            ((Transition)arg0).removeTarget(arg1);
        }
    }

    public static void replaceTargets(Object arg4, ArrayList arg5, ArrayList arg6) {
        int v1;
        int v0 = 0;
        if((arg4 instanceof TransitionSet)) {
            v1 = ((TransitionSet)arg4).getTransitionCount();
            while(v0 < v1) {
                FragmentTransitionCompat21.replaceTargets(((TransitionSet)arg4).getTransitionAt(v0), arg5, arg6);
                ++v0;
            }
        }
        else if(!FragmentTransitionCompat21.hasSimpleTarget(((Transition)arg4))) {
            List v1_1 = ((Transition)arg4).getTargets();
            if(v1_1 != null && v1_1.size() == arg5.size() && (v1_1.containsAll(((Collection)arg5)))) {
                v1 = arg6 == null ? 0 : arg6.size();
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    ((Transition)arg4).addTarget(arg6.get(v2));
                }

                for(v1 = arg5.size() - 1; v1 >= 0; --v1) {
                    ((Transition)arg4).removeTarget(arg5.get(v1));
                }
            }
        }
    }

    public static void scheduleHideFragmentView(Object arg1, View arg2, ArrayList arg3) {
        ((Transition)arg1).addListener(new Transition$TransitionListener(arg2, arg3) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg5) {
                arg5.removeListener(((Transition$TransitionListener)this));
                this.val$fragmentView.setVisibility(8);
                int v3 = this.val$exitingViews.size();
                int v1;
                for(v1 = 0; v1 < v3; ++v1) {
                    this.val$exitingViews.get(v1).setVisibility(0);
                }
            }

            public void onTransitionPause(Transition arg1) {
            }

            public void onTransitionResume(Transition arg1) {
            }

            public void onTransitionStart(Transition arg1) {
            }
        });
    }

    public static void scheduleNameReset(ViewGroup arg1, ArrayList arg2, Map arg3) {
        OneShotPreDrawListener.add(((View)arg1), new Runnable(arg2, arg3) {
            public void run() {
                int v3 = this.val$sharedElementsIn.size();
                int v2;
                for(v2 = 0; v2 < v3; ++v2) {
                    Object v0 = this.val$sharedElementsIn.get(v2);
                    ((View)v0).setTransitionName(this.val$nameOverrides.get(((View)v0).getTransitionName()));
                }
            }
        });
    }

    public static void scheduleRemoveTargets(Object arg7, Object arg8, ArrayList arg9, Object arg10, ArrayList arg11, Object arg12, ArrayList arg13) {
        ((Transition)arg7).addListener(new Transition$TransitionListener(arg8, arg9, arg10, arg11, arg12, arg13) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg1) {
            }

            public void onTransitionPause(Transition arg1) {
            }

            public void onTransitionResume(Transition arg1) {
            }

            public void onTransitionStart(Transition arg4) {
                ArrayList v2 = null;
                if(this.val$enterTransition != null) {
                    FragmentTransitionCompat21.replaceTargets(this.val$enterTransition, this.val$enteringViews, v2);
                }

                if(this.val$exitTransition != null) {
                    FragmentTransitionCompat21.replaceTargets(this.val$exitTransition, this.val$exitingViews, v2);
                }

                if(this.val$sharedElementTransition != null) {
                    FragmentTransitionCompat21.replaceTargets(this.val$sharedElementTransition, this.val$sharedElementsIn, v2);
                }
            }
        });
    }

    public static void setEpicenter(Object arg1, Rect arg2) {
        if(arg1 != null) {
            ((Transition)arg1).setEpicenterCallback(new Transition$EpicenterCallback(arg2) {
                public Rect onGetEpicenter(Transition arg2) {
                    Rect v0 = this.val$epicenter == null || (this.val$epicenter.isEmpty()) ? null : this.val$epicenter;
                    return v0;
                }
            });
        }
    }

    public static void setEpicenter(Object arg2, View arg3) {
        if(arg3 != null) {
            Rect v0 = new Rect();
            FragmentTransitionCompat21.getBoundsOnScreen(arg3, v0);
            ((Transition)arg2).setEpicenterCallback(new Transition$EpicenterCallback(v0) {
                public Rect onGetEpicenter(Transition arg2) {
                    return this.val$epicenter;
                }
            });
        }
    }

    public static void setNameOverridesOptimized(View arg8, ArrayList arg9, ArrayList arg10, ArrayList arg11, Map arg12) {
        int v1 = arg10.size();
        ArrayList v5 = new ArrayList();
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            Object v0 = arg9.get(v4);
            String v6 = ((View)v0).getTransitionName();
            v5.add(v6);
            if(v6 != null) {
                ((View)v0).setTransitionName(null);
                v0 = arg12.get(v6);
                int v2 = 0;
                while(v2 < v1) {
                    if(((String)v0).equals(arg11.get(v2))) {
                        arg10.get(v2).setTransitionName(v6);
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    break;
                }
            }
        }

        OneShotPreDrawListener.add(arg8, new Runnable(v1, arg10, arg11, arg9, v5) {
            public void run() {
                int v2;
                for(v2 = 0; v2 < this.val$numSharedElements; ++v2) {
                    this.val$sharedElementsIn.get(v2).setTransitionName(this.val$inNames.get(v2));
                    this.val$sharedElementsOut.get(v2).setTransitionName(this.val$outNames.get(v2));
                }
            }
        });
    }

    public static void setNameOverridesUnoptimized(View arg1, ArrayList arg2, Map arg3) {
        OneShotPreDrawListener.add(arg1, new Runnable(arg2, arg3) {
            public void run() {
                int v2 = this.val$sharedElementsIn.size();
                int v1;
                for(v1 = 0; v1 < v2; ++v1) {
                    Object v0 = this.val$sharedElementsIn.get(v1);
                    String v3 = ((View)v0).getTransitionName();
                    if(v3 != null) {
                        ((View)v0).setTransitionName(FragmentTransitionCompat21.findKeyForValue(this.val$nameOverrides, v3));
                    }
                }
            }
        });
    }

    public static void setSharedElementTargets(Object arg4, View arg5, ArrayList arg6) {
        List v2 = ((TransitionSet)arg4).getTargets();
        v2.clear();
        int v3 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            FragmentTransitionCompat21.bfsAddViewChildren(v2, arg6.get(v1));
        }

        v2.add(arg5);
        arg6.add(arg5);
        FragmentTransitionCompat21.addTargets(arg4, arg6);
    }

    public static void swapSharedElementTargets(Object arg1, ArrayList arg2, ArrayList arg3) {
        if(arg1 != null) {
            ((TransitionSet)arg1).getTargets().clear();
            ((TransitionSet)arg1).getTargets().addAll(((Collection)arg3));
            FragmentTransitionCompat21.replaceTargets(arg1, arg2, arg3);
        }
    }

    public static Object wrapTransitionInSet(Object arg1) {
        TransitionSet v0_1;
        if(arg1 == null) {
            Object v0 = null;
        }
        else {
            v0_1 = new TransitionSet();
            v0_1.addTransition(((Transition)arg1));
        }

        return v0_1;
    }
}

