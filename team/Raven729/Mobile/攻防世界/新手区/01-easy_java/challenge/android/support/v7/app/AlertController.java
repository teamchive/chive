package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.h.p;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a$f;
import android.support.v7.a.a$j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AbsListView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
    class android.support.v7.app.AlertController$1 implements View$OnClickListener {
        android.support.v7.app.AlertController$1(AlertController arg1) {
            this.a = arg1;
            super();
        }

        public void onClick(View arg4) {
            Message v0;
            if(arg4 != this.a.c || this.a.d == null) {
                if(arg4 == this.a.e && this.a.f != null) {
                    v0 = Message.obtain(this.a.f);
                    goto label_9;
                }

                if(arg4 == this.a.g && this.a.h != null) {
                    v0 = Message.obtain(this.a.h);
                    goto label_9;
                }

                v0 = null;
            }
            else {
                v0 = Message.obtain(this.a.d);
            }

        label_9:
            if(v0 != null) {
                v0.sendToTarget();
            }

            this.a.p.obtainMessage(1, this.a.a).sendToTarget();
        }
    }

    public class RecycleListView extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context arg2) {
            this(arg2, null);
        }

        public RecycleListView(Context arg4, AttributeSet arg5) {
            super(arg4, arg5);
            TypedArray v0 = arg4.obtainStyledAttributes(arg5, j.RecycleListView);
            this.b = v0.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.a = v0.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean arg5, boolean arg6) {
            if(!arg6 || !arg5) {
                int v2 = this.getPaddingLeft();
                int v0 = arg5 ? this.getPaddingTop() : this.a;
                int v3 = this.getPaddingRight();
                int v1 = arg6 ? this.getPaddingBottom() : this.b;
                this.setPadding(v2, v0, v3, v1);
            }
        }
    }

    public class a {
        public interface android.support.v7.app.AlertController$a$a {
            void a(ListView arg1);
        }

        public int A;
        public boolean B;
        public boolean[] C;
        public boolean D;
        public boolean E;
        public int F;
        public DialogInterface$OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public AdapterView$OnItemSelectedListener K;
        public android.support.v7.app.AlertController$a$a L;
        public boolean M;
        public final Context a;
        public final LayoutInflater b;
        public int c;
        public Drawable d;
        public int e;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public DialogInterface$OnClickListener j;
        public CharSequence k;
        public DialogInterface$OnClickListener l;
        public CharSequence m;
        public DialogInterface$OnClickListener n;
        public boolean o;
        public DialogInterface$OnCancelListener p;
        public DialogInterface$OnDismissListener q;
        public DialogInterface$OnKeyListener r;
        public CharSequence[] s;
        public ListAdapter t;
        public DialogInterface$OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        public a(Context arg3) {
            super();
            this.c = 0;
            this.e = 0;
            this.B = false;
            this.F = -1;
            this.M = true;
            this.a = arg3;
            this.o = true;
            this.b = arg3.getSystemService("layout_inflater");
        }

        public void a(AlertController arg7) {
            Message v3 = null;
            if(this.g != null) {
                arg7.b(this.g);
            }
            else {
                if(this.f != null) {
                    arg7.a(this.f);
                }

                if(this.d != null) {
                    arg7.a(this.d);
                }

                if(this.c != 0) {
                    arg7.b(this.c);
                }

                if(this.e == 0) {
                    goto label_5;
                }

                arg7.b(arg7.c(this.e));
            }

        label_5:
            if(this.h != null) {
                arg7.b(this.h);
            }

            if(this.i != null) {
                arg7.a(-1, this.i, this.j, v3);
            }

            if(this.k != null) {
                arg7.a(-2, this.k, this.l, v3);
            }

            if(this.m != null) {
                arg7.a(-3, this.m, this.n, v3);
            }

            if(this.s != null || this.H != null || this.t != null) {
                this.b(arg7);
            }

            if(this.w != null) {
                if(this.B) {
                    arg7.a(this.w, this.x, this.y, this.z, this.A);
                }
                else {
                    arg7.c(this.w);
                }
            }
            else if(this.v != 0) {
                arg7.a(this.v);
            }
        }

        private void b(AlertController arg11) {
            SimpleCursorAdapter v0_2;
            int v4 = 0x1020014;
            View v6 = this.b.inflate(arg11.l, null);
            if(!this.D) {
                int v2 = this.E ? arg11.n : arg11.o;
                if(this.H != null) {
                    v0_2 = new SimpleCursorAdapter(this.a, v2, this.H, new String[]{this.I}, new int[]{v4});
                    goto label_17;
                }

                if(this.t != null) {
                    ListAdapter v0_3 = this.t;
                    goto label_17;
                }

                c v0_4 = new c(this.a, v2, v4, this.s);
            }
            else if(this.H == null) {
                android.support.v7.app.AlertController$a$1 v0 = new ArrayAdapter(this.a, arg11.m, v4, this.s, ((RecycleListView)v6)) {
                    public View getView(int arg4, View arg5, ViewGroup arg6) {
                        View v0 = super.getView(arg4, arg5, arg6);
                        if(this.b.C != null && (this.b.C[arg4])) {
                            this.a.setItemChecked(arg4, true);
                        }

                        return v0;
                    }
                };
            }
            else {
                android.support.v7.app.AlertController$a$2 v0_1 = new CursorAdapter(this.a, this.H, false, ((RecycleListView)v6), arg11) {
                    private final int d;
                    private final int e;

                    public void bindView(View arg5, Context arg6, Cursor arg7) {
                        arg5.findViewById(0x1020014).setText(arg7.getString(this.d));
                        RecycleListView v2 = this.a;
                        int v3 = arg7.getPosition();
                        boolean v0 = arg7.getInt(this.e) == 1 ? true : false;
                        v2.setItemChecked(v3, v0);
                    }

                    public View newView(Context arg4, Cursor arg5, ViewGroup arg6) {
                        return this.c.b.inflate(this.b.m, arg6, false);
                    }
                };
            }

        label_17:
            if(this.L != null) {
                this.L.a(((ListView)v6));
            }

            arg11.j = ((ListAdapter)v0_2);
            arg11.k = this.F;
            if(this.u != null) {
                ((RecycleListView)v6).setOnItemClickListener(new AdapterView$OnItemClickListener(arg11) {
                    public void onItemClick(AdapterView arg3, View arg4, int arg5, long arg6) {
                        this.b.u.onClick(this.a.a, arg5);
                        if(!this.b.E) {
                            this.a.a.dismiss();
                        }
                    }
                });
            }
            else if(this.G != null) {
                ((RecycleListView)v6).setOnItemClickListener(new AdapterView$OnItemClickListener(((RecycleListView)v6), arg11) {
                    public void onItemClick(AdapterView arg4, View arg5, int arg6, long arg7) {
                        if(this.c.C != null) {
                            this.c.C[arg6] = this.a.isItemChecked(arg6);
                        }

                        this.c.G.onClick(this.b.a, arg6, this.a.isItemChecked(arg6));
                    }
                });
            }

            if(this.K != null) {
                ((RecycleListView)v6).setOnItemSelectedListener(this.K);
            }

            if(this.E) {
                ((RecycleListView)v6).setChoiceMode(1);
            }
            else if(this.D) {
                ((RecycleListView)v6).setChoiceMode(2);
            }

            arg11.b = ((ListView)v6);
        }
    }

    final class b extends Handler {
        private WeakReference a;

        public b(DialogInterface arg2) {
            super();
            this.a = new WeakReference(arg2);
        }

        public void handleMessage(Message arg4) {
            switch(arg4.what) {
                case -3: 
                case -2: 
                case -1: {
                    arg4.obj.onClick(this.a.get(), arg4.what);
                    break;
                }
                case 1: {
                    arg4.obj.dismiss();
                    break;
                }
            }
        }
    }

    class c extends ArrayAdapter {
        public c(Context arg1, int arg2, int arg3, CharSequence[] arg4) {
            super(arg1, arg2, arg3, ((Object[])arg4));
        }

        public long getItemId(int arg3) {
            return ((long)arg3);
        }

        public boolean hasStableIds() {
            return 1;
        }
    }

    private boolean A;
    private CharSequence B;
    private CharSequence C;
    private CharSequence D;
    private int E;
    private Drawable F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private View J;
    private int K;
    private int L;
    private boolean M;
    private int N;
    private final View$OnClickListener O;
    final l a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private CharSequence s;
    private CharSequence t;
    private View u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public AlertController(Context arg6, l arg7, Window arg8) {
        super();
        this.A = false;
        this.E = 0;
        this.k = -1;
        this.N = 0;
        this.O = new android.support.v7.app.AlertController$1(this);
        this.q = arg6;
        this.a = arg7;
        this.r = arg8;
        this.p = new b(((DialogInterface)arg7));
        TypedArray v0 = arg6.obtainStyledAttributes(null, j.AlertDialog, android.support.v7.a.a$a.alertDialogStyle, 0);
        this.K = v0.getResourceId(j.AlertDialog_android_layout, 0);
        this.L = v0.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = v0.getResourceId(j.AlertDialog_listLayout, 0);
        this.m = v0.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = v0.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = v0.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.M = v0.getBoolean(j.AlertDialog_showTitle, true);
        v0.recycle();
        arg7.a(1);
    }

    private ViewGroup a(View arg3, View arg4) {
        View v0;
        if(arg3 != null) {
            if(arg4 != null) {
                ViewParent v0_1 = arg4.getParent();
                if((v0_1 instanceof ViewGroup)) {
                    ((ViewGroup)v0_1).removeView(arg4);
                }
            }

            if((arg3 instanceof ViewStub)) {
                v0 = ((ViewStub)arg3).inflate();
                goto label_4;
            }

            v0 = arg3;
        }
        else if((arg4 instanceof ViewStub)) {
            v0 = ((ViewStub)arg4).inflate();
        }
        else {
            v0 = arg4;
        }

    label_4:
        return ((ViewGroup)v0);
    }

    static void a(View arg3, View arg4, View arg5) {
        int v2 = 4;
        int v1 = 0;
        if(arg4 != null) {
            int v0 = arg3.canScrollVertically(-1) ? 0 : v2;
            arg4.setVisibility(v0);
        }

        if(arg5 != null) {
            if(!arg3.canScrollVertically(1)) {
                v1 = v2;
            }

            arg5.setVisibility(v1);
        }
    }

    private void a(ViewGroup arg6) {
        View v1;
        int v4 = 0x20000;
        int v0 = 0;
        int v3 = -1;
        if(this.u != null) {
            v1 = this.u;
        }
        else if(this.v != 0) {
            v1 = LayoutInflater.from(this.q).inflate(this.v, arg6, false);
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            v0 = 1;
        }

        if(v0 == 0 || !AlertController.a(v1)) {
            this.r.setFlags(v4, v4);
        }

        if(v0 != 0) {
            View v0_1 = this.r.findViewById(f.custom);
            ((FrameLayout)v0_1).addView(v1, new ViewGroup$LayoutParams(v3, v3));
            if(this.A) {
                ((FrameLayout)v0_1).setPadding(this.w, this.x, this.y, this.z);
            }

            if(this.b == null) {
                return;
            }

            arg6.getLayoutParams().g = 0f;
        }
        else {
            arg6.setVisibility(8);
        }
    }

    static boolean a(View arg4) {
        boolean v0 = true;
        if(!arg4.onCheckIsTextEditor()) {
            if(!(arg4 instanceof ViewGroup)) {
                v0 = false;
            }
            else {
                int v2 = ((ViewGroup)arg4).getChildCount();
                do {
                    if(v2 > 0) {
                        --v2;
                        if(!AlertController.a(((ViewGroup)arg4).getChildAt(v2))) {
                            continue;
                        }

                        return v0;
                    }
                    else {
                        goto label_16;
                    }
                }
                while(true);

                return v0;
            label_16:
                v0 = false;
            }
        }

        return v0;
    }

    private void a(ViewGroup arg6, View arg7, int arg8, int arg9) {
        View v0 = null;
        View v2 = this.r.findViewById(f.scrollIndicatorUp);
        View v1 = this.r.findViewById(f.scrollIndicatorDown);
        if(Build$VERSION.SDK_INT >= 23) {
            p.a(arg7, arg8, arg9);
            if(v2 != null) {
                arg6.removeView(v2);
            }

            if(v1 == null) {
                return;
            }

            arg6.removeView(v1);
        }
        else {
            if(v2 != null && (arg8 & 1) == 0) {
                arg6.removeView(v2);
                v2 = v0;
            }

            if(v1 == null || (arg8 & 2) != 0) {
                v0 = v1;
            }
            else {
                arg6.removeView(v1);
            }

            if(v2 == null && v0 == null) {
                return;
            }

            if(this.t != null) {
                this.i.setOnScrollChangeListener(new android.support.v4.widget.NestedScrollView$b(v2, v0) {
                    public void a(NestedScrollView arg3, int arg4, int arg5, int arg6, int arg7) {
                        AlertController.a(((View)arg3), this.a, this.b);
                    }
                });
                this.i.post(new Runnable(v2, v0) {
                    public void run() {
                        AlertController.a(this.c.i, this.a, this.b);
                    }
                });
                return;
            }

            if(this.b != null) {
                this.b.setOnScrollListener(new AbsListView$OnScrollListener(v2, v0) {
                    public void onScroll(AbsListView arg3, int arg4, int arg5, int arg6) {
                        AlertController.a(((View)arg3), this.a, this.b);
                    }

                    public void onScrollStateChanged(AbsListView arg1, int arg2) {
                    }
                });
                this.b.post(new Runnable(v2, v0) {
                    public void run() {
                        AlertController.a(this.c.b, this.a, this.b);
                    }
                });
                return;
            }

            if(v2 != null) {
                arg6.removeView(v2);
            }

            if(v0 == null) {
                return;
            }

            arg6.removeView(v0);
        }
    }

    private void a(Button arg3) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        ((LinearLayout$LayoutParams)v0).gravity = 1;
        ((LinearLayout$LayoutParams)v0).weight = 0.5f;
        arg3.setLayoutParams(v0);
    }

    private static boolean a(Context arg4) {
        boolean v0 = true;
        TypedValue v1 = new TypedValue();
        arg4.getTheme().resolveAttribute(android.support.v7.a.a$a.alertDialogCenterButtons, v1, true);
        if(v1.data == 0) {
            v0 = false;
        }

        return v0;
    }

    public void a() {
        this.a.setContentView(this.b());
        this.c();
    }

    public void a(int arg2) {
        this.u = null;
        this.v = arg2;
        this.A = false;
    }

    public void a(int arg3, CharSequence arg4, DialogInterface$OnClickListener arg5, Message arg6) {
        if(arg6 == null && arg5 != null) {
            arg6 = this.p.obtainMessage(arg3, arg5);
        }

        switch(arg3) {
            case -3: {
                goto label_15;
            }
            case -2: {
                goto label_12;
            }
            case -1: {
                goto label_9;
            }
        }

        throw new IllegalArgumentException("Button does not exist");
    label_9:
        this.B = arg4;
        this.d = arg6;
        return;
    label_12:
        this.C = arg4;
        this.f = arg6;
        return;
    label_15:
        this.D = arg4;
        this.h = arg6;
    }

    public void a(Drawable arg3) {
        this.F = arg3;
        this.E = 0;
        if(this.G != null) {
            if(arg3 != null) {
                this.G.setVisibility(0);
                this.G.setImageDrawable(arg3);
            }
            else {
                this.G.setVisibility(8);
            }
        }
    }

    public void a(View arg2, int arg3, int arg4, int arg5, int arg6) {
        this.u = arg2;
        this.v = 0;
        this.A = true;
        this.w = arg3;
        this.x = arg4;
        this.y = arg5;
        this.z = arg6;
    }

    public void a(CharSequence arg2) {
        this.s = arg2;
        if(this.H != null) {
            this.H.setText(arg2);
        }
    }

    public boolean a(int arg2, KeyEvent arg3) {
        boolean v0 = this.i == null || !this.i.a(arg3) ? false : true;
        return v0;
    }

    private int b() {
        int v0;
        if(this.L == 0) {
            v0 = this.K;
        }
        else if(this.N == 1) {
            v0 = this.L;
        }
        else {
            v0 = this.K;
        }

        return v0;
    }

    private void b(ViewGroup arg7) {
        int v5 = 8;
        if(this.J != null) {
            arg7.addView(this.J, 0, new ViewGroup$LayoutParams(-1, -2));
            this.r.findViewById(f.title_template).setVisibility(v5);
        }
        else {
            this.G = this.r.findViewById(0x1020006);
            int v0 = !TextUtils.isEmpty(this.s) ? 1 : 0;
            if(v0 != 0 && (this.M)) {
                this.H = this.r.findViewById(f.alertTitle);
                this.H.setText(this.s);
                if(this.E != 0) {
                    this.G.setImageResource(this.E);
                }
                else if(this.F != null) {
                    this.G.setImageDrawable(this.F);
                }
                else {
                    this.H.setPadding(this.G.getPaddingLeft(), this.G.getPaddingTop(), this.G.getPaddingRight(), this.G.getPaddingBottom());
                    this.G.setVisibility(v5);
                }

                return;
            }

            this.r.findViewById(f.title_template).setVisibility(v5);
            this.G.setVisibility(v5);
            arg7.setVisibility(v5);
        }
    }

    public void b(int arg3) {
        this.F = null;
        this.E = arg3;
        if(this.G != null) {
            if(arg3 != 0) {
                this.G.setVisibility(0);
                this.G.setImageResource(this.E);
            }
            else {
                this.G.setVisibility(8);
            }
        }
    }

    public void b(View arg1) {
        this.J = arg1;
    }

    public void b(CharSequence arg2) {
        this.t = arg2;
        if(this.I != null) {
            this.I.setText(arg2);
        }
    }

    public boolean b(int arg2, KeyEvent arg3) {
        boolean v0 = this.i == null || !this.i.a(arg3) ? false : true;
        return v0;
    }

    private void c() {
        ListView v4_2;
        int v9 = 8;
        View v0 = this.r.findViewById(f.parentPanel);
        View v2 = v0.findViewById(f.topPanel);
        View v4 = v0.findViewById(f.contentPanel);
        View v5 = v0.findViewById(f.buttonPanel);
        v0 = v0.findViewById(f.customPanel);
        this.a(((ViewGroup)v0));
        View v6 = ((ViewGroup)v0).findViewById(f.topPanel);
        View v7 = ((ViewGroup)v0).findViewById(f.contentPanel);
        View v8 = ((ViewGroup)v0).findViewById(f.buttonPanel);
        ViewGroup v6_1 = this.a(v6, v2);
        ViewGroup v7_1 = this.a(v7, v4);
        ViewGroup v5_1 = this.a(v8, v5);
        this.c(v7_1);
        this.d(v5_1);
        this.b(v6_1);
        int v4_1 = v0 == null || ((ViewGroup)v0).getVisibility() == v9 ? 0 : 1;
        boolean v2_1 = v6_1 == null || v6_1.getVisibility() == v9 ? false : true;
        boolean v5_2 = v5_1 == null || v5_1.getVisibility() == v9 ? false : true;
        if(!v5_2 && v7_1 != null) {
            v0 = v7_1.findViewById(f.textSpacerNoButtons);
            if(v0 != null) {
                v0.setVisibility(0);
            }
        }

        if(v2_1) {
            if(this.i != null) {
                this.i.setClipToPadding(true);
            }

            v0 = null;
            if(this.t != null || this.b != null) {
                v0 = v6_1.findViewById(f.titleDividerNoCustom);
            }

            if(v0 == null) {
                goto label_59;
            }

            v0.setVisibility(0);
        }
        else {
            if(v7_1 == null) {
                goto label_59;
            }

            v0 = v7_1.findViewById(f.textSpacerNoTitle);
            if(v0 == null) {
                goto label_59;
            }

            v0.setVisibility(0);
        }

    label_59:
        if((this.b instanceof RecycleListView)) {
            this.b.a(v2_1, v5_2);
        }

        if(v4_1 == 0) {
            if(this.b != null) {
                v4_2 = this.b;
            }
            else {
                NestedScrollView v4_3 = this.i;
            }

            if(v4_2 == null) {
                goto label_77;
            }

            int v2_2 = v2_1 ? 1 : 0;
            int v0_1 = v5_2 ? 2 : 0;
            this.a(v7_1, ((View)v4_2), v0_1 | v2_2, 3);
        }

    label_77:
        ListView v0_2 = this.b;
        if(v0_2 != null && this.j != null) {
            v0_2.setAdapter(this.j);
            int v1 = this.k;
            if(v1 > -1) {
                v0_2.setItemChecked(v1, true);
                v0_2.setSelection(v1);
            }
        }
    }

    private void c(ViewGroup arg6) {
        int v3 = 8;
        int v4 = -1;
        this.i = this.r.findViewById(f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.I = arg6.findViewById(0x102000B);
        if(this.I != null) {
            if(this.t != null) {
                this.I.setText(this.t);
            }
            else {
                this.I.setVisibility(v3);
                this.i.removeView(this.I);
                if(this.b != null) {
                    ViewParent v0 = this.i.getParent();
                    int v1 = ((ViewGroup)v0).indexOfChild(this.i);
                    ((ViewGroup)v0).removeViewAt(v1);
                    ((ViewGroup)v0).addView(this.b, v1, new ViewGroup$LayoutParams(v4, v4));
                }
                else {
                    arg6.setVisibility(v3);
                }
            }
        }
    }

    public int c(int arg4) {
        TypedValue v0 = new TypedValue();
        this.q.getTheme().resolveAttribute(arg4, v0, true);
        return v0.resourceId;
    }

    public void c(View arg2) {
        this.u = arg2;
        this.v = 0;
        this.A = false;
    }

    private void d(ViewGroup arg9) {
        int v1;
        int v3 = 1;
        int v7 = 8;
        int v4 = 2;
        int v5 = 4;
        this.c = arg9.findViewById(0x1020019);
        this.c.setOnClickListener(this.O);
        if(TextUtils.isEmpty(this.B)) {
            this.c.setVisibility(v7);
            v1 = 0;
        }
        else {
            this.c.setText(this.B);
            this.c.setVisibility(0);
            v1 = 1;
        }

        this.e = arg9.findViewById(0x102001A);
        this.e.setOnClickListener(this.O);
        if(TextUtils.isEmpty(this.C)) {
            this.e.setVisibility(v7);
        }
        else {
            this.e.setText(this.C);
            this.e.setVisibility(0);
            v1 |= v4;
        }

        this.g = arg9.findViewById(0x102001B);
        this.g.setOnClickListener(this.O);
        if(TextUtils.isEmpty(this.D)) {
            this.g.setVisibility(v7);
        }
        else {
            this.g.setText(this.D);
            this.g.setVisibility(0);
            v1 |= v5;
        }

        if(AlertController.a(this.q)) {
            if(v1 == 1) {
                this.a(this.c);
            }
            else if(v1 == v4) {
                this.a(this.e);
            }
            else if(v1 == v5) {
                this.a(this.g);
            }
        }

        if(v1 == 0) {
            v3 = 0;
        }

        if(v3 == 0) {
            arg9.setVisibility(v7);
        }
    }
}

