package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(ListView arg1) {
        super(((View)arg1));
        this.mTarget = arg1;
    }

    public boolean canTargetScrollHorizontally(int arg2) {
        return 0;
    }

    public boolean canTargetScrollVertically(int arg7) {
        boolean v0 = false;
        ListView v1 = this.mTarget;
        int v2 = v1.getCount();
        if(v2 != 0) {
            int v3 = v1.getChildCount();
            int v4 = v1.getFirstVisiblePosition();
            int v5 = v4 + v3;
            if(arg7 > 0) {
                if(v5 >= v2 && v1.getChildAt(v3 - 1).getBottom() <= v1.getHeight()) {
                    return v0;
                }
            }
            else if(arg7 >= 0) {
                return v0;
            }
            else if(v4 <= 0 && v1.getChildAt(0).getTop() >= 0) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    public void scrollTargetBy(int arg2, int arg3) {
        ListViewCompat.scrollListBy(this.mTarget, arg3);
    }
}

