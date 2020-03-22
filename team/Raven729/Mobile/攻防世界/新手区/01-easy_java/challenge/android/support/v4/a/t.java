package android.support.v4.a;

import android.graphics.Rect;
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

class t {
    public static Object a(Object arg1) {
        Object v0 = null;
        if(arg1 != null) {
            Transition v0_1 = ((Transition)arg1).clone();
        }

        return v0;
    }

    public static void a(Object arg4, View arg5, ArrayList arg6) {
        List v2 = ((TransitionSet)arg4).getTargets();
        v2.clear();
        int v3 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            t.a(v2, arg6.get(v1));
        }

        v2.add(arg5);
        arg6.add(arg5);
        t.a(arg4, arg6);
    }

    public static void a(Object arg1, Rect arg2) {
        if(arg1 != null) {
            ((Transition)arg1).setEpicenterCallback(new Transition$EpicenterCallback(arg2) {
                public Rect onGetEpicenter(Transition arg2) {
                    Rect v0 = this.a == null || (this.a.isEmpty()) ? null : this.a;
                    return v0;
                }
            });
        }
    }

    public static void a(View arg6, Rect arg7) {
        int[] v0 = new int[2];
        arg6.getLocationOnScreen(v0);
        arg7.set(v0[0], v0[1], v0[0] + arg6.getWidth(), v0[1] + arg6.getHeight());
    }

    public static Object a(Object arg1, Object arg2, Object arg3) {
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

    public static ArrayList a(ArrayList arg5) {
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

    public static void a(Object arg7, Object arg8, ArrayList arg9, Object arg10, ArrayList arg11, Object arg12, ArrayList arg13) {
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
                if(this.a != null) {
                    t.b(this.a, this.b, v2);
                }

                if(this.c != null) {
                    t.b(this.c, this.d, v2);
                }

                if(this.e != null) {
                    t.b(this.e, this.f, v2);
                }
            }
        });
    }

    public static void a(ViewGroup arg0, Object arg1) {
        TransitionManager.beginDelayedTransition(arg0, ((Transition)arg1));
    }

    public static void a(View arg8, ArrayList arg9, ArrayList arg10, ArrayList arg11, Map arg12) {
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

        x.a(arg8, new Runnable(v1, arg10, arg11, arg9, v5) {
            public void run() {
                int v2;
                for(v2 = 0; v2 < this.a; ++v2) {
                    this.b.get(v2).setTransitionName(this.c.get(v2));
                    this.d.get(v2).setTransitionName(this.e.get(v2));
                }
            }
        });
    }

    public static void a(Object arg1, ArrayList arg2, ArrayList arg3) {
        if(arg1 != null) {
            ((TransitionSet)arg1).getTargets().clear();
            ((TransitionSet)arg1).getTargets().addAll(((Collection)arg3));
            t.b(arg1, arg2, arg3);
        }
    }

    public static void a(Object arg2, View arg3) {
        if(arg3 != null) {
            Rect v0 = new Rect();
            t.a(arg3, v0);
            ((Transition)arg2).setEpicenterCallback(new Transition$EpicenterCallback(v0) {
                public Rect onGetEpicenter(Transition arg2) {
                    return this.a;
                }
            });
        }
    }

    public static void a(Map arg3, View arg4) {
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
                t.a(arg3, ((ViewGroup)arg4).getChildAt(v0_1));
            }
        }
    }

    public static void a(ArrayList arg3, View arg4) {
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
                    t.a(arg3, ((ViewGroup)arg4).getChildAt(v0));
                }
            }
        }
    }

    public static void a(Object arg3, ArrayList arg4) {
        int v1;
        int v0 = 0;
        if(arg3 != null) {
            if((arg3 instanceof TransitionSet)) {
                v1 = ((TransitionSet)arg3).getTransitionCount();
                while(v0 < v1) {
                    t.a(((TransitionSet)arg3).getTransitionAt(v0), arg4);
                    ++v0;
                }
            }
            else if(!t.a(((Transition)arg3)) && (t.a(((Transition)arg3).getTargets()))) {
                int v2 = arg4.size();
                for(v1 = 0; v1 < v2; ++v1) {
                    ((Transition)arg3).addTarget(arg4.get(v1));
                }
            }
        }
    }

    public static void a(View arg1, ArrayList arg2, Map arg3) {
        x.a(arg1, new Runnable(arg2, arg3) {
            public void run() {
                int v2 = this.a.size();
                int v1;
                for(v1 = 0; v1 < v2; ++v1) {
                    Object v0 = this.a.get(v1);
                    String v3 = ((View)v0).getTransitionName();
                    if(v3 != null) {
                        ((View)v0).setTransitionName(t.a(this.b, v3));
                    }
                }
            }
        });
    }

    public static void a(ViewGroup arg1, ArrayList arg2, Map arg3) {
        x.a(((View)arg1), new Runnable(arg2, arg3) {
            public void run() {
                int v3 = this.a.size();
                int v2;
                for(v2 = 0; v2 < v3; ++v2) {
                    Object v0 = this.a.get(v2);
                    ((View)v0).setTransitionName(this.b.get(((View)v0).getTransitionName()));
                }
            }
        });
    }

    static String a(Map arg1, String arg2) {
        return t.b(arg1, arg2);
    }

    private static void a(List arg7, View arg8) {
        int v2 = arg7.size();
        if(!t.a(arg7, arg8, v2)) {
            arg7.add(arg8);
            int v1;
            for(v1 = v2; v1 < arg7.size(); ++v1) {
                Object v0 = arg7.get(v1);
                if((v0 instanceof ViewGroup)) {
                    int v4 = ((ViewGroup)v0).getChildCount();
                    int v3;
                    for(v3 = 0; v3 < v4; ++v3) {
                        View v5 = ((ViewGroup)v0).getChildAt(v3);
                        if(!t.a(arg7, v5, v2)) {
                            arg7.add(v5);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(Transition arg1) {
        boolean v0 = !t.a(arg1.getTargetIds()) || !t.a(arg1.getTargetNames()) || !t.a(arg1.getTargetTypes()) ? true : false;
        return v0;
    }

    private static boolean a(List arg1) {
        boolean v0 = arg1 == null || (arg1.isEmpty()) ? true : false;
        return v0;
    }

    private static boolean a(List arg3, View arg4, int arg5) {
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

    public static Object b(Object arg1) {
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

    public static Object b(Object arg2, Object arg3, Object arg4) {
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

    public static void b(Object arg4, ArrayList arg5, ArrayList arg6) {
        int v1;
        int v0 = 0;
        if((arg4 instanceof TransitionSet)) {
            v1 = ((TransitionSet)arg4).getTransitionCount();
            while(v0 < v1) {
                t.b(((TransitionSet)arg4).getTransitionAt(v0), arg5, arg6);
                ++v0;
            }
        }
        else if(!t.a(((Transition)arg4))) {
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

    public static void b(Object arg1, View arg2, ArrayList arg3) {
        ((Transition)arg1).addListener(new Transition$TransitionListener(arg2, arg3) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg5) {
                arg5.removeListener(((Transition$TransitionListener)this));
                this.a.setVisibility(8);
                int v3 = this.b.size();
                int v1;
                for(v1 = 0; v1 < v3; ++v1) {
                    this.b.get(v1).setVisibility(0);
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

    public static void b(Object arg0, View arg1) {
        if(arg0 != null) {
            ((Transition)arg0).addTarget(arg1);
        }
    }

    private static String b(Map arg3, String arg4) {
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
        goto label_9;
    label_10:
        String v0_1 = null;
    label_9:
        return ((String)v0);
    }

    public static void c(Object arg0, View arg1) {
        if(arg0 != null) {
            ((Transition)arg0).removeTarget(arg1);
        }
    }
}

