package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v7.a.a$a;
import android.support.v7.view.c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ai implements c {
    public class SearchAutoComplete extends f {
        class android.support.v7.widget.SearchView$SearchAutoComplete$1 implements Runnable {
            android.support.v7.widget.SearchView$SearchAutoComplete$1(SearchAutoComplete arg1) {
                this.a = arg1;
                super();
            }

            public void run() {
                SearchAutoComplete.a(this.a);
            }
        }

        final Runnable a;
        private int b;
        private SearchView c;
        private boolean d;

        public SearchAutoComplete(Context arg2) {
            this(arg2, null);
        }

        public SearchAutoComplete(Context arg2, AttributeSet arg3) {
            this(arg2, arg3, a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context arg2, AttributeSet arg3, int arg4) {
            super(arg2, arg3, arg4);
            this.a = new android.support.v7.widget.SearchView$SearchAutoComplete$1(this);
            this.b = this.getThreshold();
        }

        static void a(SearchAutoComplete arg0, boolean arg1) {
            arg0.setImeVisibility(arg1);
        }

        private void a() {
            if(this.d) {
                this.getContext().getSystemService("input_method").showSoftInput(((View)this), 0);
                this.d = false;
            }
        }

        static void a(SearchAutoComplete arg0) {
            arg0.a();
        }

        public boolean enoughToFilter() {
            boolean v0 = this.b <= 0 || (super.enoughToFilter()) ? true : false;
            return v0;
        }

        private int getSearchViewTextMinWidthDp() {
            int v0_1;
            Configuration v0 = this.getResources().getConfiguration();
            int v1 = v0.screenWidthDp;
            int v2 = v0.screenHeightDp;
            if(v1 < 960 || v2 < 720 || v0.orientation != 2) {
                if(v1 < 600 && (v1 < 640 || v2 < 480)) {
                    return 0xA0;
                }

                v0_1 = 0xC0;
            }
            else {
                v0_1 = 0x100;
            }

            return v0_1;
        }

        public InputConnection onCreateInputConnection(EditorInfo arg3) {
            InputConnection v0 = super.onCreateInputConnection(arg3);
            if(this.d) {
                this.removeCallbacks(this.a);
                this.post(this.a);
            }

            return v0;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.setMinWidth(((int)TypedValue.applyDimension(1, ((float)this.getSearchViewTextMinWidthDp()), this.getResources().getDisplayMetrics())));
        }

        protected void onFocusChanged(boolean arg2, int arg3, Rect arg4) {
            super.onFocusChanged(arg2, arg3, arg4);
            this.c.g();
        }

        public boolean onKeyPreIme(int arg3, KeyEvent arg4) {
            KeyEvent$DispatcherState v1;
            boolean v0 = true;
            if(arg3 == 4) {
                if(arg4.getAction() == 0 && arg4.getRepeatCount() == 0) {
                    v1 = this.getKeyDispatcherState();
                    if(v1 != null) {
                        v1.startTracking(arg4, this);
                    }
                    else {
                    }

                    return v0;
                }

                if(arg4.getAction() != 1) {
                    goto label_25;
                }

                v1 = this.getKeyDispatcherState();
                if(v1 != null) {
                    v1.handleUpEvent(arg4);
                }

                if(!arg4.isTracking()) {
                    goto label_25;
                }

                if(arg4.isCanceled()) {
                    goto label_25;
                }

                this.c.clearFocus();
                this.setImeVisibility(false);
            }
            else {
            label_25:
                v0 = super.onKeyPreIme(arg3, arg4);
            }

            return v0;
        }

        public void onWindowFocusChanged(boolean arg3) {
            super.onWindowFocusChanged(arg3);
            if((arg3) && (this.c.hasFocus()) && this.getVisibility() == 0) {
                this.d = true;
                if(SearchView.a(this.getContext())) {
                    SearchView.i.a(((AutoCompleteTextView)this), true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence arg1) {
        }

        private void setImeVisibility(boolean arg4) {
            Object v0 = this.getContext().getSystemService("input_method");
            if(!arg4) {
                this.d = false;
                this.removeCallbacks(this.a);
                ((InputMethodManager)v0).hideSoftInputFromWindow(this.getWindowToken(), 0);
            }
            else if(((InputMethodManager)v0).isActive(((View)this))) {
                this.d = false;
                this.removeCallbacks(this.a);
                ((InputMethodManager)v0).showSoftInput(((View)this), 0);
            }
            else {
                this.d = true;
            }
        }

        void setSearchView(SearchView arg1) {
            this.c = arg1;
        }

        public void setThreshold(int arg1) {
            super.setThreshold(arg1);
            this.b = arg1;
        }
    }

    class android.support.v7.widget.SearchView$a {
        private Method a;
        private Method b;
        private Method c;

        android.support.v7.widget.SearchView$a() {
            super();
            try {
                this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged");
                this.a.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
            }

            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged");
                this.b.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
            }

            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
            }
            catch(NoSuchMethodException v0) {
            }
        }

        void a(AutoCompleteTextView arg3) {
            if(this.a != null) {
                try {
                    this.a.invoke(arg3);
                }
                catch(Exception v0) {
                }
            }
        }

        void a(AutoCompleteTextView arg5, boolean arg6) {
            if(this.c != null) {
                try {
                    this.c.invoke(arg5, Boolean.valueOf(arg6));
                }
                catch(Exception v0) {
                }
            }
        }

        void b(AutoCompleteTextView arg3) {
            if(this.b != null) {
                try {
                    this.b.invoke(arg3);
                }
                catch(Exception v0) {
                }
            }
        }
    }

    public interface b {
        boolean a();
    }

    public interface android.support.v7.widget.SearchView$c {
        boolean a(String arg1);
    }

    public interface d {
    }

    class e extends android.support.v4.h.a {
        final class android.support.v7.widget.SearchView$e$1 implements Parcelable$ClassLoaderCreator {
            android.support.v7.widget.SearchView$e$1() {
                super();
            }

            public e a(Parcel arg3) {
                return new e(arg3, null);
            }

            public e a(Parcel arg2, ClassLoader arg3) {
                return new e(arg2, arg3);
            }

            public e[] a(int arg2) {
                return new e[arg2];
            }

            public Object createFromParcel(Parcel arg2) {
                return this.a(arg2);
            }

            public Object createFromParcel(Parcel arg2, ClassLoader arg3) {
                return this.a(arg2, arg3);
            }

            public Object[] newArray(int arg2) {
                return this.a(arg2);
            }
        }

        public static final Parcelable$Creator CREATOR;
        boolean b;

        static {
            e.CREATOR = new android.support.v7.widget.SearchView$e$1();
        }

        e(Parcelable arg1) {
            super(arg1);
        }

        public e(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            this.b = arg2.readValue(null).booleanValue();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeValue(Boolean.valueOf(this.b));
        }
    }

    class android.support.v7.widget.SearchView$f extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public android.support.v7.widget.SearchView$f(Rect arg2, Rect arg3, View arg4) {
            super(arg2, arg4);
            this.e = ViewConfiguration.get(arg4.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            this.a(arg2, arg3);
            this.a = arg4;
        }

        public void a(Rect arg4, Rect arg5) {
            this.b.set(arg4);
            this.d.set(arg4);
            this.d.inset(-this.e, -this.e);
            this.c.set(arg5);
        }

        public boolean onTouchEvent(MotionEvent arg7) {
            boolean v2;
            int v1 = 1;
            boolean v0 = false;
            int v3 = ((int)arg7.getX());
            int v4 = ((int)arg7.getY());
            switch(arg7.getAction()) {
                case 0: {
                    if(!this.b.contains(v3, v4)) {
                        goto label_8;
                    }

                    this.f = true;
                    v2 = true;
                    break;
                }
                case 1: 
                case 2: {
                    v2 = this.f;
                    if(!v2) {
                        goto label_9;
                    }

                    if(this.d.contains(v3, v4)) {
                        goto label_9;
                    }

                    v1 = 0;
                    break;
                }
                case 3: {
                    v2 = this.f;
                    this.f = false;
                    break;
                }
                default: {
                label_8:
                    v2 = false;
                    break;
                }
            }

        label_9:
            if(v2) {
                if(v1 == 0 || (this.c.contains(v3, v4))) {
                    arg7.setLocation(((float)(v3 - this.c.left)), ((float)(v4 - this.c.top)));
                }
                else {
                    arg7.setLocation(((float)(this.a.getWidth() / 2)), ((float)(this.a.getHeight() / 2)));
                }

                v0 = this.a.dispatchTouchEvent(arg7);
            }

            return v0;
        }
    }

    private View$OnClickListener A;
    private boolean B;
    private boolean C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private CharSequence J;
    private boolean K;
    private int L;
    private Bundle M;
    private final Runnable N;
    private Runnable O;
    private final WeakHashMap P;
    final SearchAutoComplete a;
    final ImageView b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    View$OnFocusChangeListener f;
    android.support.v4.widget.c g;
    SearchableInfo h;
    static final android.support.v7.widget.SearchView$a i;
    private final View j;
    private final View k;
    private android.support.v7.widget.SearchView$f l;
    private Rect m;
    private Rect n;
    private int[] o;
    private int[] p;
    private final ImageView q;
    private final Drawable r;
    private final int s;
    private final int t;
    private final Intent u;
    private final Intent v;
    private final CharSequence w;
    private android.support.v7.widget.SearchView$c x;
    private b y;
    private d z;

    static {
        SearchView.i = new android.support.v7.widget.SearchView$a();
    }

    private Intent a(String arg4, Uri arg5, String arg6, String arg7, int arg8, String arg9) {
        Intent v0 = new Intent(arg4);
        v0.addFlags(0x10000000);
        if(arg5 != null) {
            v0.setData(arg5);
        }

        v0.putExtra("user_query", this.J);
        if(arg7 != null) {
            v0.putExtra("query", arg7);
        }

        if(arg6 != null) {
            v0.putExtra("intent_extra_data_key", arg6);
        }

        if(this.M != null) {
            v0.putExtra("app_data", this.M);
        }

        if(arg8 != 0) {
            v0.putExtra("action_key", arg8);
            v0.putExtra("action_msg", arg9);
        }

        v0.setComponent(this.h.getSearchActivity());
        return v0;
    }

    private void a(View arg5, Rect arg6) {
        arg5.getLocationInWindow(this.o);
        this.getLocationInWindow(this.p);
        int v0 = this.o[1] - this.p[1];
        int v1 = this.o[0] - this.p[0];
        arg6.set(v1, v0, arg5.getWidth() + v1, arg5.getHeight() + v0);
    }

    private void a(boolean arg7) {
        boolean v4 = true;
        int v2 = 8;
        this.C = arg7;
        int v0 = arg7 ? 0 : v2;
        boolean v3 = !TextUtils.isEmpty(this.a.getText()) ? true : false;
        this.b.setVisibility(v0);
        this.b(v3);
        View v5 = this.j;
        v0 = arg7 ? v2 : 0;
        v5.setVisibility(v0);
        if(this.q.getDrawable() != null && !this.B) {
            v2 = 0;
        }

        this.q.setVisibility(v2);
        this.m();
        if(v3) {
            v4 = false;
        }

        this.c(v4);
        this.l();
    }

    static boolean a(Context arg2) {
        boolean v0 = arg2.getResources().getConfiguration().orientation == 2 ? true : false;
        return v0;
    }

    public void a() {
        if(!this.K) {
            this.K = true;
            this.L = this.a.getImeOptions();
            this.a.setImeOptions(this.L | 0x2000000);
            this.a.setText("");
            this.setIconified(false);
        }
    }

    void a(int arg8, String arg9, String arg10) {
        this.getContext().startActivity(this.a("android.intent.action.SEARCH", null, null, arg10, arg8, arg9));
    }

    void a(CharSequence arg1) {
        this.setQuery(arg1);
    }

    public void a(CharSequence arg3, boolean arg4) {
        this.a.setText(arg3);
        if(arg3 != null) {
            this.a.setSelection(this.a.length());
            this.J = arg3;
        }

        if((arg4) && !TextUtils.isEmpty(arg3)) {
            this.d();
        }
    }

    private void b(boolean arg3) {
        int v0 = 8;
        if((this.D) && (this.k()) && (this.hasFocus()) && ((arg3) || !this.I)) {
            v0 = 0;
        }

        this.c.setVisibility(v0);
    }

    private CharSequence b(CharSequence arg6) {
        SpannableStringBuilder v6;
        if((this.B) && this.r != null) {
            int v0 = ((int)((((double)this.a.getTextSize())) * 1.25));
            this.r.setBounds(0, 0, v0, v0);
            SpannableStringBuilder v0_1 = new SpannableStringBuilder("   ");
            v0_1.setSpan(new ImageSpan(this.r), 1, 2, 33);
            v0_1.append(arg6);
            v6 = v0_1;
        }

        return ((CharSequence)v6);
    }

    public void b() {
        this.a("", false);
        this.clearFocus();
        this.a(true);
        this.a.setImeOptions(this.L);
        this.K = false;
    }

    private void c(boolean arg4) {
        int v0;
        int v1 = 8;
        if(!this.I || (this.c()) || !arg4) {
            v0 = v1;
        }
        else {
            v0 = 0;
            this.c.setVisibility(v1);
        }

        this.e.setVisibility(v0);
    }

    public boolean c() {
        return this.C;
    }

    public void clearFocus() {
        this.G = true;
        super.clearFocus();
        this.a.clearFocus();
        SearchAutoComplete.a(this.a, false);
        this.G = false;
    }

    void d() {
        Editable v0 = this.a.getText();
        if(v0 != null && TextUtils.getTrimmedLength(((CharSequence)v0)) > 0 && (this.x == null || !this.x.a(((CharSequence)v0).toString()))) {
            if(this.h != null) {
                this.a(0, null, ((CharSequence)v0).toString());
            }

            SearchAutoComplete.a(this.a, false);
            this.q();
        }
    }

    void e() {
        if(!TextUtils.isEmpty(this.a.getText())) {
            this.a.setText("");
            this.a.requestFocus();
            SearchAutoComplete.a(this.a, true);
        }
        else if(this.B) {
            if(this.y != null && (this.y.a())) {
                return;
            }

            this.clearFocus();
            this.a(true);
        }
    }

    void f() {
        this.a(false);
        this.a.requestFocus();
        SearchAutoComplete.a(this.a, true);
        if(this.A != null) {
            this.A.onClick(((View)this));
        }
    }

    void g() {
        this.a(this.c());
        this.n();
        if(this.a.hasFocus()) {
            this.h();
        }
    }

    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public int getMaxWidth() {
        return this.H;
    }

    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(android.support.v7.a.a$d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(android.support.v7.a.a$d.abc_search_view_preferred_width);
    }

    public CharSequence getQuery() {
        return this.a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence v0;
        if(this.E != null) {
            v0 = this.E;
        }
        else {
            if(this.h != null && this.h.getHintId() != 0) {
                return this.getContext().getText(this.h.getHintId());
            }

            v0 = this.w;
        }

        return v0;
    }

    int getSuggestionCommitIconResId() {
        return this.t;
    }

    int getSuggestionRowLayout() {
        return this.s;
    }

    public android.support.v4.widget.c getSuggestionsAdapter() {
        return this.g;
    }

    void h() {
        SearchView.i.a(this.a);
        SearchView.i.b(this.a);
    }

    private boolean i() {
        boolean v0 = false;
        if(this.h != null && (this.h.getVoiceSearchEnabled())) {
            Intent v1 = null;
            if(this.h.getVoiceSearchLaunchWebSearch()) {
                v1 = this.u;
            }
            else if(this.h.getVoiceSearchLaunchRecognizer()) {
                v1 = this.v;
            }

            if(v1 == null) {
                return v0;
            }

            if(this.getContext().getPackageManager().resolveActivity(v1, 0x10000) == null) {
                return v0;
            }

            v0 = true;
        }

        return v0;
    }

    private boolean k() {
        boolean v0;
        if(!this.D && !this.I) {
            goto label_8;
        }
        else if(!this.c()) {
            v0 = true;
        }
        else {
        label_8:
            v0 = false;
        }

        return v0;
    }

    private void l() {
        int v0 = 8;
        if((this.k()) && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) {
            v0 = 0;
        }

        this.k.setVisibility(v0);
    }

    private void m() {
        int v0 = 1;
        int v1 = 0;
        int v2 = !TextUtils.isEmpty(this.a.getText()) ? 1 : 0;
        if(v2 == 0 && (!this.B || (this.K))) {
            v0 = 0;
        }

        ImageView v3 = this.d;
        if(v0 == 0) {
            v1 = 8;
        }

        v3.setVisibility(v1);
        Drawable v1_1 = this.d.getDrawable();
        if(v1_1 != null) {
            int[] v0_1 = v2 != 0 ? SearchView.ENABLED_STATE_SET : SearchView.EMPTY_STATE_SET;
            v1_1.setState(v0_1);
        }
    }

    private void n() {
        this.post(this.N);
    }

    private void o() {
        String v0_1;
        CharSequence v0 = this.getQueryHint();
        SearchAutoComplete v1 = this.a;
        if(v0 == null) {
            v0_1 = "";
        }

        v1.setHint(this.b(((CharSequence)v0_1)));
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.N);
        this.post(this.O);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean arg6, int arg7, int arg8, int arg9, int arg10) {
        super.onLayout(arg6, arg7, arg8, arg9, arg10);
        if(arg6) {
            this.a(this.a, this.m);
            this.n.set(this.m.left, 0, this.m.right, arg10 - arg8);
            if(this.l == null) {
                this.l = new android.support.v7.widget.SearchView$f(this.n, this.m, this.a);
                this.setTouchDelegate(this.l);
            }
            else {
                this.l.a(this.n, this.m);
            }
        }
    }

    protected void onMeasure(int arg5, int arg6) {
        int v3 = 0x40000000;
        if(this.c()) {
            super.onMeasure(arg5, arg6);
        }
        else {
            int v1 = View$MeasureSpec.getMode(arg5);
            int v0 = View$MeasureSpec.getSize(arg5);
            switch(v1) {
                case 1073741824: {
                    if(this.H > 0) {
                        v0 = Math.min(this.H, v0);
                    }
                    else {
                    }

                    break;
                }
                case -2147483648: {
                    v0 = this.H > 0 ? Math.min(this.H, v0) : Math.min(this.getPreferredWidth(), v0);
                    break;
                }
                case 0: {
                    v0 = this.H > 0 ? this.H : this.getPreferredWidth();
                    break;
                }
            }

            int v2 = View$MeasureSpec.getMode(arg6);
            v1 = View$MeasureSpec.getSize(arg6);
            switch(v2) {
                case -2147483648: {
                    v1 = Math.min(this.getPreferredHeight(), v1);
                    break;
                }
                case 0: {
                    v1 = this.getPreferredHeight();
                    break;
                }
            }

            super.onMeasure(View$MeasureSpec.makeMeasureSpec(v0, v3), View$MeasureSpec.makeMeasureSpec(v1, v3));
        }
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof e)) {
            super.onRestoreInstanceState(arg2);
        }
        else {
            super.onRestoreInstanceState(((e)arg2).a());
            this.a(((e)arg2).b);
            this.requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        e v1 = new e(super.onSaveInstanceState());
        v1.b = this.c();
        return ((Parcelable)v1);
    }

    public void onWindowFocusChanged(boolean arg1) {
        super.onWindowFocusChanged(arg1);
        this.n();
    }

    private void p() {
        int v1 = 1;
        this.a.setThreshold(this.h.getSuggestThreshold());
        this.a.setImeOptions(this.h.getImeOptions());
        int v0 = this.h.getInputType();
        if((v0 & 15) == 1) {
            v0 &= 0xFFFEFFFF;
            if(this.h.getSuggestAuthority() != null) {
                v0 = v0 | 0x10000 | 0x80000;
            }
        }

        this.a.setInputType(v0);
        if(this.g != null) {
            this.g.a(null);
        }

        if(this.h.getSuggestAuthority() != null) {
            this.g = new aq(this.getContext(), this, this.h, this.P);
            this.a.setAdapter(this.g);
            android.support.v4.widget.c v0_1 = this.g;
            if(this.F) {
                v1 = 2;
            }

            ((aq)v0_1).a(v1);
        }
    }

    private void q() {
        this.a.dismissDropDown();
    }

    public boolean requestFocus(int arg3, Rect arg4) {
        boolean v0 = false;
        if(!this.G && (this.isFocusable())) {
            if(!this.c()) {
                boolean v1 = this.a.requestFocus(arg3, arg4);
                if(v1) {
                    this.a(false);
                }

                v0 = v1;
            }
            else {
                v0 = super.requestFocus(arg3, arg4);
            }
        }

        return v0;
    }

    public void setAppSearchData(Bundle arg1) {
        this.M = arg1;
    }

    public void setIconified(boolean arg1) {
        if(arg1) {
            this.e();
        }
        else {
            this.f();
        }
    }

    public void setIconifiedByDefault(boolean arg2) {
        if(this.B != arg2) {
            this.B = arg2;
            this.a(arg2);
            this.o();
        }
    }

    public void setImeOptions(int arg2) {
        this.a.setImeOptions(arg2);
    }

    public void setInputType(int arg2) {
        this.a.setInputType(arg2);
    }

    public void setMaxWidth(int arg1) {
        this.H = arg1;
        this.requestLayout();
    }

    public void setOnCloseListener(b arg1) {
        this.y = arg1;
    }

    public void setOnQueryTextFocusChangeListener(View$OnFocusChangeListener arg1) {
        this.f = arg1;
    }

    public void setOnQueryTextListener(android.support.v7.widget.SearchView$c arg1) {
        this.x = arg1;
    }

    public void setOnSearchClickListener(View$OnClickListener arg1) {
        this.A = arg1;
    }

    public void setOnSuggestionListener(d arg1) {
        this.z = arg1;
    }

    private void setQuery(CharSequence arg3) {
        this.a.setText(arg3);
        SearchAutoComplete v1 = this.a;
        int v0 = TextUtils.isEmpty(arg3) ? 0 : arg3.length();
        v1.setSelection(v0);
    }

    public void setQueryHint(CharSequence arg1) {
        this.E = arg1;
        this.o();
    }

    public void setQueryRefinementEnabled(boolean arg3) {
        this.F = arg3;
        if((this.g instanceof aq)) {
            android.support.v4.widget.c v0 = this.g;
            int v1 = arg3 ? 2 : 1;
            ((aq)v0).a(v1);
        }
    }

    public void setSearchableInfo(SearchableInfo arg3) {
        this.h = arg3;
        if(this.h != null) {
            this.p();
            this.o();
        }

        this.I = this.i();
        if(this.I) {
            this.a.setPrivateImeOptions("nm");
        }

        this.a(this.c());
    }

    public void setSubmitButtonEnabled(boolean arg2) {
        this.D = arg2;
        this.a(this.c());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.c arg3) {
        this.g = arg3;
        this.a.setAdapter(this.g);
    }
}

