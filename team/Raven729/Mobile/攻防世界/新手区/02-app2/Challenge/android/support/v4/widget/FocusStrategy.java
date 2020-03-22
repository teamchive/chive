package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FocusStrategy {
    public interface BoundsAdapter {
        void obtainBounds(Object arg1, Rect arg2);
    }

    public interface CollectionAdapter {
        Object get(Object arg1, int arg2);

        int size(Object arg1);
    }

    class SequentialComparator implements Comparator {
        private final BoundsAdapter mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        SequentialComparator(boolean arg2, BoundsAdapter arg3) {
            super();
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = arg2;
            this.mAdapter = arg3;
        }

        public int compare(Object arg7, Object arg8) {
            int v0 = 1;
            int v1 = -1;
            Rect v2 = this.mTemp1;
            Rect v3 = this.mTemp2;
            this.mAdapter.obtainBounds(arg7, v2);
            this.mAdapter.obtainBounds(arg8, v3);
            if(v2.top >= v3.top) {
                if(v2.top > v3.top) {
                    v1 = 1;
                }
                else if(v2.left < v3.left) {
                    if(!this.mIsLayoutRtl) {
                        v0 = v1;
                    }

                    v1 = v0;
                }
                else {
                    if(v2.left > v3.left) {
                        if(this.mIsLayoutRtl) {
                            return v1;
                        }

                        return 1;
                    }

                    if(v2.bottom < v3.bottom) {
                        return v1;
                    }

                    if(v2.bottom > v3.bottom) {
                        return 1;
                    }

                    if(v2.right < v3.right) {
                        if(!this.mIsLayoutRtl) {
                            v0 = v1;
                        }

                        return v0;
                    }

                    if(v2.right > v3.right) {
                        if(this.mIsLayoutRtl) {
                            return v1;
                        }

                        return 1;
                    }

                    v1 = 0;
                }
            }

            return v1;
        }
    }

    FocusStrategy() {
        super();
    }

    private static boolean beamBeats(int arg4, @NonNull Rect arg5, @NonNull Rect arg6, @NonNull Rect arg7) {
        boolean v0 = true;
        boolean v2 = FocusStrategy.beamsOverlap(arg4, arg5, arg6);
        if((FocusStrategy.beamsOverlap(arg4, arg5, arg7)) || !v2) {
            v0 = false;
        }
        else if((FocusStrategy.isToDirectionOf(arg4, arg5, arg7)) && arg4 != 17 && arg4 != 66 && FocusStrategy.majorAxisDistance(arg4, arg5, arg6) >= FocusStrategy.majorAxisDistanceToFarEdge(arg4, arg5, arg7)) {
            v0 = false;
        }

        return v0;
    }

    private static boolean beamsOverlap(int arg4, @NonNull Rect arg5, @NonNull Rect arg6) {
        boolean v0 = true;
        switch(arg4) {
            case 17: 
            case 66: {
                if(arg6.bottom >= arg5.top && arg6.top <= arg5.bottom) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 33: 
            case 130: {
                if(arg6.right >= arg5.left && arg6.left <= arg5.right) {
                    return v0;
                }

                v0 = false;
                break;
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        return v0;
    }

    public static Object findNextFocusInAbsoluteDirection(@NonNull Object arg7, @NonNull CollectionAdapter arg8, @NonNull BoundsAdapter arg9, @Nullable Object arg10, @NonNull Rect arg11, int arg12) {
        Rect v3 = new Rect(arg11);
        switch(arg12) {
            case 17: {
                goto label_8;
            }
            case 33: {
                goto label_28;
            }
            case 66: {
                goto label_23;
            }
            case 130: {
                goto label_32;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_23:
        v3.offset(-(arg11.width() + 1), 0);
        goto label_11;
    label_8:
        v3.offset(arg11.width() + 1, 0);
        goto label_11;
    label_28:
        v3.offset(0, arg11.height() + 1);
        goto label_11;
    label_32:
        v3.offset(0, -(arg11.height() + 1));
    label_11:
        int v4 = arg8.size(arg7);
        Rect v5 = new Rect();
        int v2 = 0;
        Object v0 = null;
        while(v2 < v4) {
            Object v1 = arg8.get(arg7, v2);
            if(v1 != arg10) {
                arg9.obtainBounds(v1, v5);
                if(FocusStrategy.isBetterCandidate(arg12, arg11, v5, v3)) {
                    v3.set(v5);
                    v0 = v1;
                }
            }

            ++v2;
        }

        return v0;
    }

    public static Object findNextFocusInRelativeDirection(@NonNull Object arg4, @NonNull CollectionAdapter arg5, @NonNull BoundsAdapter arg6, @Nullable Object arg7, int arg8, boolean arg9, boolean arg10) {
        int v1 = arg5.size(arg4);
        ArrayList v2 = new ArrayList(v1);
        int v0;
        for(v0 = 0; v0 < v1; ++v0) {
            v2.add(arg5.get(arg4, v0));
        }

        Collections.sort(((List)v2), new SequentialComparator(arg9, arg6));
        switch(arg8) {
            case 1: {
                goto label_19;
            }
            case 2: {
                goto label_17;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    label_17:
        Object v0_1 = FocusStrategy.getNextFocusable(arg7, v2, arg10);
        return v0_1;
    label_19:
        return FocusStrategy.getPreviousFocusable(arg7, v2, arg10);
    }

    private static Object getNextFocusable(Object arg2, ArrayList arg3, boolean arg4) {
        Object v0_1;
        int v1 = arg3.size();
        int v0 = arg2 == null ? -1 : arg3.lastIndexOf(arg2);
        ++v0;
        if(v0 < v1) {
            v0_1 = arg3.get(v0);
        }
        else {
            if((arg4) && v1 > 0) {
                return arg3.get(0);
            }

            v0_1 = null;
        }

        return v0_1;
    }

    private static Object getPreviousFocusable(Object arg2, ArrayList arg3, boolean arg4) {
        Object v0_1;
        int v1 = arg3.size();
        int v0 = arg2 == null ? v1 : arg3.indexOf(arg2);
        --v0;
        if(v0 >= 0) {
            v0_1 = arg3.get(v0);
        }
        else {
            if((arg4) && v1 > 0) {
                return arg3.get(v1 - 1);
            }

            v0_1 = null;
        }

        return v0_1;
    }

    private static int getWeightedDistanceFor(int arg2, int arg3) {
        return arg2 * 13 * arg2 + arg3 * arg3;
    }

    private static boolean isBetterCandidate(int arg5, @NonNull Rect arg6, @NonNull Rect arg7, @NonNull Rect arg8) {
        boolean v0 = true;
        if(!FocusStrategy.isCandidate(arg6, arg7, arg5)) {
            v0 = false;
        }
        else if((FocusStrategy.isCandidate(arg6, arg8, arg5)) && !FocusStrategy.beamBeats(arg5, arg6, arg7, arg8)) {
            if(FocusStrategy.beamBeats(arg5, arg6, arg8, arg7)) {
                v0 = false;
            }
            else if(FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(arg5, arg6, arg7), FocusStrategy.minorAxisDistance(arg5, arg6, arg7)) >= FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(arg5, arg6, arg8), FocusStrategy.minorAxisDistance(arg5, arg6, arg8))) {
                v0 = false;
            }
        }

        return v0;
    }

    private static boolean isCandidate(@NonNull Rect arg4, @NonNull Rect arg5, int arg6) {
        boolean v0 = true;
        switch(arg6) {
            case 17: {
                if((arg4.right > arg5.right || arg4.left >= arg5.right) && arg4.left > arg5.left) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 33: {
                if((arg4.bottom > arg5.bottom || arg4.top >= arg5.bottom) && arg4.top > arg5.top) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 66: {
                if((arg4.left < arg5.left || arg4.right <= arg5.left) && arg4.right < arg5.right) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 130: {
                if((arg4.top < arg5.top || arg4.bottom <= arg5.top) && arg4.bottom < arg5.bottom) {
                    return v0;
                }

                v0 = false;
                break;
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        return v0;
    }

    private static boolean isToDirectionOf(int arg4, @NonNull Rect arg5, @NonNull Rect arg6) {
        boolean v0 = true;
        switch(arg4) {
            case 17: {
                if(arg5.left >= arg6.right) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 33: {
                if(arg5.top >= arg6.bottom) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 66: {
                if(arg5.right <= arg6.left) {
                    return v0;
                }

                v0 = false;
                break;
            }
            case 130: {
                if(arg5.bottom <= arg6.top) {
                    return v0;
                }

                v0 = false;
                break;
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        return v0;
    }

    private static int majorAxisDistance(int arg2, @NonNull Rect arg3, @NonNull Rect arg4) {
        return Math.max(0, FocusStrategy.majorAxisDistanceRaw(arg2, arg3, arg4));
    }

    private static int majorAxisDistanceRaw(int arg2, @NonNull Rect arg3, @NonNull Rect arg4) {
        switch(arg2) {
            case 17: {
                goto label_5;
            }
            case 33: {
                goto label_13;
            }
            case 66: {
                goto label_9;
            }
            case 130: {
                goto label_17;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_17:
        int v0 = arg4.top - arg3.bottom;
        return v0;
    label_5:
        return arg3.left - arg4.right;
    label_9:
        return arg4.left - arg3.right;
    label_13:
        return arg3.top - arg4.bottom;
    }

    private static int majorAxisDistanceToFarEdge(int arg2, @NonNull Rect arg3, @NonNull Rect arg4) {
        return Math.max(1, FocusStrategy.majorAxisDistanceToFarEdgeRaw(arg2, arg3, arg4));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int arg2, @NonNull Rect arg3, @NonNull Rect arg4) {
        switch(arg2) {
            case 17: {
                goto label_5;
            }
            case 33: {
                goto label_13;
            }
            case 66: {
                goto label_9;
            }
            case 130: {
                goto label_17;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_17:
        int v0 = arg4.bottom - arg3.bottom;
        return v0;
    label_5:
        return arg3.left - arg4.left;
    label_9:
        return arg4.right - arg3.right;
    label_13:
        return arg3.top - arg4.top;
    }

    private static int minorAxisDistance(int arg3, @NonNull Rect arg4, @NonNull Rect arg5) {
        switch(arg3) {
            case 17: 
            case 66: {
                goto label_5;
            }
            case 33: 
            case 130: {
                goto label_16;
            }
        }

        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    label_5:
        int v0 = Math.abs(arg4.top + arg4.height() / 2 - (arg5.top + arg5.height() / 2));
        return v0;
    label_16:
        return Math.abs(arg4.left + arg4.width() / 2 - (arg5.left + arg5.width() / 2));
    }
}

