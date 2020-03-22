package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.p;
import android.support.v7.a.a$f;
import android.support.v7.a.a$g;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements a {
    private j a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private Drawable h;
    private int i;
    private Context j;
    private boolean k;
    private Drawable l;
    private int m;
    private LayoutInflater n;
    private boolean o;

    public ListMenuItemView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, android.support.v7.a.a$a.listMenuViewStyle);
    }

    public ListMenuItemView(Context arg5, AttributeSet arg6, int arg7) {
        super(arg5, arg6);
        aw v0 = aw.a(this.getContext(), arg6, android.support.v7.a.a$j.MenuView, arg7, 0);
        this.h = v0.a(android.support.v7.a.a$j.MenuView_android_itemBackground);
        this.i = v0.g(android.support.v7.a.a$j.MenuView_android_itemTextAppearance, -1);
        this.k = v0.a(android.support.v7.a.a$j.MenuView_preserveIconSpacing, false);
        this.j = arg5;
        this.l = v0.a(android.support.v7.a.a$j.MenuView_subMenuArrow);
        v0.a();
    }

    public void a(j arg3, int arg4) {
        this.a = arg3;
        this.m = arg4;
        int v0 = arg3.isVisible() ? 0 : 8;
        this.setVisibility(v0);
        this.setTitle(arg3.a(((a)this)));
        this.setCheckable(arg3.isCheckable());
        this.a(arg3.f(), arg3.d());
        this.setIcon(arg3.getIcon());
        this.setEnabled(arg3.isEnabled());
        this.setSubMenuArrowVisible(arg3.hasSubMenu());
        this.setContentDescription(arg3.getContentDescription());
    }

    public void a(boolean arg4, char arg5) {
        int v0 = !arg4 || !this.a.f() ? 8 : 0;
        if(v0 == 0) {
            this.f.setText(this.a.e());
        }

        if(this.f.getVisibility() != v0) {
            this.f.setVisibility(v0);
        }
    }

    public boolean a() {
        return 0;
    }

    private void b() {
        this.b = this.getInflater().inflate(g.abc_list_menu_item_icon, ((ViewGroup)this), false);
        this.addView(this.b, 0);
    }

    private void c() {
        this.c = this.getInflater().inflate(g.abc_list_menu_item_radio, ((ViewGroup)this), false);
        this.addView(this.c);
    }

    private void d() {
        this.e = this.getInflater().inflate(g.abc_list_menu_item_checkbox, ((ViewGroup)this), false);
        this.addView(this.e);
    }

    private LayoutInflater getInflater() {
        if(this.n == null) {
            this.n = LayoutInflater.from(this.getContext());
        }

        return this.n;
    }

    public j getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        p.a(((View)this), this.h);
        this.d = this.findViewById(f.title);
        if(this.i != -1) {
            this.d.setTextAppearance(this.j, this.i);
        }

        this.f = this.findViewById(f.shortcut);
        this.g = this.findViewById(f.submenuarrow);
        if(this.g != null) {
            this.g.setImageDrawable(this.l);
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        if(this.b != null && (this.k)) {
            ViewGroup$LayoutParams v1 = this.getLayoutParams();
            ViewGroup$LayoutParams v0 = this.b.getLayoutParams();
            if(v1.height > 0 && ((LinearLayout$LayoutParams)v0).width <= 0) {
                ((LinearLayout$LayoutParams)v0).width = v1.height;
            }
        }

        super.onMeasure(arg4, arg5);
    }

    public void setCheckable(boolean arg6) {
        CheckBox v3_1;
        CheckBox v2;
        int v1 = 8;
        if((arg6) || this.c != null || this.e != null) {
            if(this.a.g()) {
                if(this.c == null) {
                    this.c();
                }

                RadioButton v3 = this.c;
                v2 = this.e;
            }
            else {
                if(this.e == null) {
                    this.d();
                }

                v3_1 = this.e;
                RadioButton v2_1 = this.c;
            }

            if(arg6) {
                ((CompoundButton)v3_1).setChecked(this.a.isChecked());
                int v0 = arg6 ? 0 : v1;
                if(((CompoundButton)v3_1).getVisibility() != v0) {
                    ((CompoundButton)v3_1).setVisibility(v0);
                }

                if(v2 == null) {
                    return;
                }

                if(((CompoundButton)v2).getVisibility() == v1) {
                    return;
                }

                ((CompoundButton)v2).setVisibility(v1);
                return;
            }

            if(this.e != null) {
                this.e.setVisibility(v1);
            }

            if(this.c == null) {
                return;
            }

            this.c.setVisibility(v1);
        }
    }

    public void setChecked(boolean arg2) {
        RadioButton v0;
        if(this.a.g()) {
            if(this.c == null) {
                this.c();
            }

            v0 = this.c;
        }
        else {
            if(this.e == null) {
                this.d();
            }

            CheckBox v0_1 = this.e;
        }

        ((CompoundButton)v0).setChecked(arg2);
    }

    public void setForceShowIcon(boolean arg1) {
        this.o = arg1;
        this.k = arg1;
    }

    public void setIcon(Drawable arg4) {
        int v0 = (this.a.i()) || (this.o) ? 1 : 0;
        if((v0 != 0 || (this.k)) && (this.b != null || arg4 != null || (this.k))) {
            if(this.b == null) {
                this.b();
            }

            if(arg4 == null && !this.k) {
                this.b.setVisibility(8);
                return;
            }

            ImageView v2 = this.b;
            if(v0 == 0) {
                arg4 = null;
            }

            v2.setImageDrawable(arg4);
            if(this.b.getVisibility() == 0) {
                return;
            }

            this.b.setVisibility(0);
        }
    }

    private void setSubMenuArrowVisible(boolean arg3) {
        if(this.g != null) {
            ImageView v1 = this.g;
            int v0 = arg3 ? 0 : 8;
            v1.setVisibility(v0);
        }
    }

    public void setTitle(CharSequence arg3) {
        int v1 = 8;
        if(arg3 != null) {
            this.d.setText(arg3);
            if(this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
        else if(this.d.getVisibility() != v1) {
            this.d.setVisibility(v1);
        }
    }
}

