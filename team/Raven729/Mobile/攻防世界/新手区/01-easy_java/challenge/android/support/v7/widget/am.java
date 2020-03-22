package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class am extends aj implements al {
    public class a extends af {
        final int g;
        final int h;
        private al i;
        private MenuItem j;

        public a(Context arg6, boolean arg7) {
            int v4 = 22;
            int v3 = 21;
            super(arg6, arg7);
            Configuration v0 = arg6.getResources().getConfiguration();
            if(Build$VERSION.SDK_INT < 17 || 1 != v0.getLayoutDirection()) {
                this.g = v4;
                this.h = v3;
            }
            else {
                this.g = v3;
                this.h = v4;
            }
        }

        public boolean a(MotionEvent arg2, int arg3) {
            return super.a(arg2, arg3);
        }

        public boolean hasFocus() {
            return super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public boolean isFocused() {
            return super.isFocused();
        }

        public boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent arg6) {
            j v1_1;
            int v1;
            if(this.i != null) {
                ListAdapter v0 = this.getAdapter();
                if((v0 instanceof HeaderViewListAdapter)) {
                    v1 = ((HeaderViewListAdapter)v0).getHeadersCount();
                    v0 = ((HeaderViewListAdapter)v0).getWrappedAdapter();
                }
                else {
                    v1 = 0;
                }

                j v2 = null;
                if(arg6.getAction() != 10) {
                    int v3 = this.pointToPosition(((int)arg6.getX()), ((int)arg6.getY()));
                    if(v3 != -1) {
                        v1 = v3 - v1;
                        if(v1 < 0) {
                            goto label_37;
                        }
                        else if(v1 < ((g)v0).getCount()) {
                            v1_1 = ((g)v0).a(v1);
                        }
                        else {
                            goto label_37;
                        }
                    }
                    else {
                        goto label_37;
                    }
                }
                else {
                label_37:
                    v1_1 = v2;
                }

                MenuItem v2_1 = this.j;
                if((((j)v2_1)) == v1_1) {
                    goto label_33;
                }

                h v0_1 = ((g)v0).a();
                if(v2_1 != null) {
                    this.i.a(v0_1, v2_1);
                }

                this.j = ((MenuItem)v1_1);
                if(v1_1 == null) {
                    goto label_33;
                }

                this.i.b(v0_1, ((MenuItem)v1_1));
            }

        label_33:
            return super.onHoverEvent(arg6);
        }

        public boolean onKeyDown(int arg7, KeyEvent arg8) {
            boolean v0_1;
            View v0 = this.getSelectedView();
            if(v0 == null || arg7 != this.g) {
                if(v0 != null && arg7 == this.h) {
                    this.setSelection(-1);
                    this.getAdapter().a().a(false);
                    return true;
                }

                v0_1 = super.onKeyDown(arg7, arg8);
            }
            else {
                if((((ListMenuItemView)v0).isEnabled()) && (((ListMenuItemView)v0).getItemData().hasSubMenu())) {
                    this.performItemClick(v0, this.getSelectedItemPosition(), this.getSelectedItemId());
                }

                v0_1 = true;
            }

            return v0_1;
        }

        public void setHoverListener(al arg1) {
            this.i = arg1;
        }
    }

    private static Method a;
    private al b;

    static {
        try {
            am.a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        }
        catch(NoSuchMethodException v0) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public am(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public void a(Object arg3) {
        if(Build$VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition(((Transition)arg3));
        }
    }

    public void a(al arg1) {
        this.b = arg1;
    }

    af a(Context arg2, boolean arg3) {
        a v0 = new a(arg2, arg3);
        v0.setHoverListener(((al)this));
        return ((af)v0);
    }

    public void a(h arg2, MenuItem arg3) {
        if(this.b != null) {
            this.b.a(arg2, arg3);
        }
    }

    public void b(Object arg3) {
        if(Build$VERSION.SDK_INT >= 23) {
            this.g.setExitTransition(((Transition)arg3));
        }
    }

    public void b(h arg2, MenuItem arg3) {
        if(this.b != null) {
            this.b.b(arg2, arg3);
        }
    }

    public void c(boolean arg6) {
        if(am.a != null) {
            try {
                am.a.invoke(this.g, Boolean.valueOf(arg6));
            }
            catch(Exception v0) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}

