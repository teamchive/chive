package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.support.v7.a.a$f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class aq extends j implements View$OnClickListener {
    final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View arg2) {
            super();
            this.a = arg2.findViewById(0x1020014);
            this.b = arg2.findViewById(0x1020015);
            this.c = arg2.findViewById(0x1020007);
            this.d = arg2.findViewById(0x1020008);
            this.e = arg2.findViewById(f.edit_query);
        }
    }

    private final SearchManager j;
    private final SearchView k;
    private final SearchableInfo l;
    private final Context m;
    private final WeakHashMap n;
    private final int o;
    private boolean p;
    private int q;
    private ColorStateList r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;

    public aq(Context arg5, SearchView arg6, SearchableInfo arg7, WeakHashMap arg8) {
        super(arg5, arg6.getSuggestionRowLayout(), null, true);
        this.p = false;
        this.q = 1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.j = this.d.getSystemService("search");
        this.k = arg6;
        this.l = arg7;
        this.o = arg6.getSuggestionCommitIconResId();
        this.m = arg5;
        this.n = arg8;
    }

    public void a(int arg1) {
        this.q = arg1;
    }

    private Drawable a(ComponentName arg5) {
        Drawable v0_1;
        Object v1 = null;
        String v2 = arg5.flattenToShortString();
        if(this.n.containsKey(v2)) {
            Object v0 = this.n.get(v2);
            v0_1 = v0 == null ? ((Drawable)v1) : ((Drawable$ConstantState)v0).newDrawable(this.m.getResources());
        }
        else {
            v0_1 = this.b(arg5);
            if(v0_1 != null) {
                Drawable$ConstantState v1_1 = v0_1.getConstantState();
            }

            this.n.put(v2, v1);
        }

        return v0_1;
    }

    private Drawable a(String arg5) {
        Drawable v0_2;
        Drawable v1 = null;
        if(arg5 != null && !arg5.isEmpty() && !"0".equals(arg5)) {
            try {
                int v2 = Integer.parseInt(arg5);
                String v3 = "android.resource://" + this.m.getPackageName() + "/" + v2;
                v0_2 = this.b(v3);
                if(v0_2 == null) {
                    v0_2 = android.support.v4.b.a.a(this.m, v2);
                    this.a(v3, v0_2);
                }
                else {
                }
            }
            catch(Resources$NotFoundException v0) {
                Log.w("SuggestionsAdapter", "Icon resource not found: " + arg5);
                v0_2 = v1;
            }
            catch(NumberFormatException v0_1) {
                v0_2 = this.b(arg5);
                if(v0_2 == null) {
                    v0_2 = this.b(Uri.parse(arg5));
                    this.a(arg5, v0_2);
                }
                else {
                }
            }
        }
        else {
            v0_2 = v1;
        }

        return v0_2;
    }

    private void a(String arg3, Drawable arg4) {
        if(arg4 != null) {
            this.n.put(arg3, arg4.getConstantState());
        }
    }

    private static String a(Cursor arg4, int arg5) {
        String v0 = null;
        if(arg5 != -1) {
            try {
                v0 = arg4.getString(arg5);
            }
            catch(Exception v1) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", ((Throwable)v1));
            }
        }

        return v0;
    }

    public static String a(Cursor arg1, String arg2) {
        return aq.a(arg1, arg1.getColumnIndex(arg2));
    }

    private void a(ImageView arg3, Drawable arg4, int arg5) {
        arg3.setImageDrawable(arg4);
        if(arg4 == null) {
            arg3.setVisibility(arg5);
        }
        else {
            arg3.setVisibility(0);
            arg4.setVisible(false, false);
            arg4.setVisible(true, false);
        }
    }

    private void a(TextView arg2, CharSequence arg3) {
        arg2.setText(arg3);
        if(TextUtils.isEmpty(arg3)) {
            arg2.setVisibility(8);
        }
        else {
            arg2.setVisibility(0);
        }
    }

    Drawable a(Uri arg8) {
        Resources v3;
        String v2 = arg8.getAuthority();
        if(TextUtils.isEmpty(((CharSequence)v2))) {
            throw new FileNotFoundException("No authority: " + arg8);
        }

        try {
            v3 = this.d.getPackageManager().getResourcesForApplication(v2);
        }
        catch(PackageManager$NameNotFoundException v0) {
            throw new FileNotFoundException("No package found for authority: " + arg8);
        }

        List v1 = arg8.getPathSegments();
        if(v1 == null) {
            throw new FileNotFoundException("No path: " + arg8);
        }

        int v0_1 = v1.size();
        if(v0_1 == 1) {
            try {
                v0_1 = Integer.parseInt(v1.get(0));
            }
            catch(NumberFormatException v0_2) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + arg8);
            }
        }
        else if(v0_1 == 2) {
            v0_1 = v3.getIdentifier(v1.get(1), v1.get(0), v2);
        }
        else {
            goto label_69;
        }

        if(v0_1 == 0) {
            throw new FileNotFoundException("No resource found for: " + arg8);
        }

        return v3.getDrawable(v0_1);
    label_69:
        throw new FileNotFoundException("More than two path segments: " + arg8);
    }

    Cursor a(SearchableInfo arg7, String arg8, int arg9) {
        String[] v4;
        Cursor v2 = null;
        if(arg7 != null) {
            String v0 = arg7.getSuggestAuthority();
            if(v0 != null) {
                Uri$Builder v0_1 = new Uri$Builder().scheme("content").authority(v0).query("").fragment("");
                String v1 = arg7.getSuggestPath();
                if(v1 != null) {
                    v0_1.appendEncodedPath(v1);
                }

                v0_1.appendPath("search_suggest_query");
                String v3 = arg7.getSuggestSelection();
                if(v3 != null) {
                    v4 = new String[]{arg8};
                }
                else {
                    v0_1.appendPath(arg8);
                    v4 = ((String[])v2);
                }

                if(arg9 > 0) {
                    v0_1.appendQueryParameter("limit", String.valueOf(arg9));
                }

                v2 = this.d.getContentResolver().query(v0_1.build(), ((String[])v2), v3, v4, ((String)v2));
            }
        }

        return v2;
    }

    public Cursor a(CharSequence arg5) {
        Cursor v0_2;
        Cursor v1 = null;
        String v0 = arg5 == null ? "" : arg5.toString();
        if(this.k.getVisibility() == 0 && this.k.getWindowVisibility() == 0) {
            try {
                v0_2 = this.a(this.l, v0, 50);
                if(v0_2 != null) {
                    v0_2.getCount();
                    return v0_2;
                }
                else {
                }
            }
            catch(RuntimeException v0_1) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", ((Throwable)v0_1));
            }

            v0_2 = v1;
        }
        else {
            v0_2 = v1;
        }

        return v0_2;
    }

    public View a(Context arg4, Cursor arg5, ViewGroup arg6) {
        View v1 = super.a(arg4, arg5, arg6);
        v1.setTag(new a(v1));
        v1.findViewById(f.edit_query).setImageResource(this.o);
        return v1;
    }

    public void a(Cursor arg4) {
        if(this.p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if(arg4 == null) {
                return;
            }

            arg4.close();
            return;
        }

        try {
            super.a(arg4);
            if(arg4 == null) {
                return;
            }

            this.s = arg4.getColumnIndex("suggest_text_1");
            this.t = arg4.getColumnIndex("suggest_text_2");
            this.u = arg4.getColumnIndex("suggest_text_2_url");
            this.v = arg4.getColumnIndex("suggest_icon_1");
            this.w = arg4.getColumnIndex("suggest_icon_2");
            this.x = arg4.getColumnIndex("suggest_flags");
        }
        catch(Exception v0) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", ((Throwable)v0));
        }
    }

    public void a(View arg10, Context arg11, Cursor arg12) {
        CharSequence v3_1;
        int v8 = 8;
        int v7 = 2;
        Object v0 = arg10.getTag();
        int v1 = this.x != -1 ? arg12.getInt(this.x) : 0;
        if(((a)v0).a != null) {
            this.a(((a)v0).a, aq.a(arg12, this.s));
        }

        if(((a)v0).b != null) {
            String v3 = aq.a(arg12, this.u);
            if(v3 != null) {
                v3_1 = this.b(((CharSequence)v3));
            }
            else {
                v3 = aq.a(arg12, this.t);
            }

            if(TextUtils.isEmpty(v3_1)) {
                if(((a)v0).a != null) {
                    ((a)v0).a.setSingleLine(false);
                    ((a)v0).a.setMaxLines(v7);
                }
            }
            else if(((a)v0).a != null) {
                ((a)v0).a.setSingleLine(true);
                ((a)v0).a.setMaxLines(1);
            }

            this.a(((a)v0).b, v3_1);
        }

        if(((a)v0).c != null) {
            this.a(((a)v0).c, this.e(arg12), 4);
        }

        if(((a)v0).d != null) {
            this.a(((a)v0).d, this.f(arg12), v8);
        }

        if(this.q != v7) {
            if(this.q == 1 && (v1 & 1) != 0) {
                goto label_49;
            }

            ((a)v0).e.setVisibility(v8);
        }
        else {
        label_49:
            ((a)v0).e.setVisibility(0);
            ((a)v0).e.setTag(((a)v0).a.getText());
            ((a)v0).e.setOnClickListener(((View$OnClickListener)this));
        }
    }

    private Drawable b(ComponentName arg6) {
        ActivityInfo v2_1;
        Drawable v0 = null;
        PackageManager v1 = this.d.getPackageManager();
        int v2 = 0x80;
        try {
            v2_1 = v1.getActivityInfo(arg6, v2);
        }
        catch(PackageManager$NameNotFoundException v1_1) {
            Log.w("SuggestionsAdapter", v1_1.toString());
            return v0;
        }

        int v3 = v2_1.getIconResource();
        if(v3 != 0) {
            Drawable v1_2 = v1.getDrawable(arg6.getPackageName(), v3, v2_1.applicationInfo);
            if(v1_2 == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + v3 + " for " + arg6.flattenToShortString());
            }
            else {
                v0 = v1_2;
            }
        }

        return v0;
    }

    private Drawable b(String arg2) {
        Object v0 = this.n.get(arg2);
        Drawable v0_1 = v0 == null ? null : ((Drawable$ConstantState)v0).newDrawable();
        return v0_1;
    }

    private Drawable b(Uri arg7) {
        InputStream v2;
        Drawable v0_2;
        Drawable v1 = null;
        try {
            if(!"android.resource".equals(arg7.getScheme())) {
                goto label_32;
            }

            try {
                v0_2 = this.a(arg7);
                return v0_2;
            }
            catch(Resources$NotFoundException v0_1) {
                try {
                    throw new FileNotFoundException("Resource does not exist: " + arg7);
                label_32:
                    v2 = this.m.getContentResolver().openInputStream(arg7);
                    if(v2 != null) {
                        goto label_45;
                    }

                    throw new FileNotFoundException("Failed to open " + arg7);
                }
                catch(FileNotFoundException v0) {
                    goto label_29;
                }
            }
        }
        catch(FileNotFoundException v0) {
            goto label_29;
        }

    label_45:
        String v0_3 = null;
        try {
            v0_2 = Drawable.createFromStream(v2, v0_3);
        }
        catch(Throwable v0_4) {
            try {
                v2.close();
            }
            catch(IOException v2_1) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + arg7, ((Throwable)v2_1));
            }

            throw v0_4;
        }

        try {
            v2.close();
        }
        catch(FileNotFoundException v0) {
        }
        catch(IOException v2_1) {
            try {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + arg7, ((Throwable)v2_1));
            }
            catch(FileNotFoundException v0) {
            label_29:
                Log.w("SuggestionsAdapter", "Icon not found: " + arg7 + ", " + v0.getMessage());
                v0_2 = v1;
            }
        }

        return v0_2;
    }

    private CharSequence b(CharSequence arg8) {
        String v1 = null;
        if(this.r == null) {
            TypedValue v0 = new TypedValue();
            this.d.getTheme().resolveAttribute(android.support.v7.a.a$a.textColorSearchUrl, v0, true);
            this.r = this.d.getResources().getColorStateList(v0.resourceId);
        }

        SpannableString v6 = new SpannableString(arg8);
        v6.setSpan(new TextAppearanceSpan(v1, 0, 0, this.r, ((ColorStateList)v1)), 0, arg8.length(), 33);
        return ((CharSequence)v6);
    }

    public CharSequence c(Cursor arg3) {
        String v0_1;
        CharSequence v0 = null;
        if(arg3 != null) {
            String v1 = aq.a(arg3, "suggest_intent_query");
            if(v1 != null) {
                v0_1 = v1;
            }
            else {
                if(this.l.shouldRewriteQueryFromData()) {
                    v1 = aq.a(arg3, "suggest_intent_data");
                    if(v1 != null) {
                        v0_1 = v1;
                        goto label_2;
                    }
                }

                if(!this.l.shouldRewriteQueryFromText()) {
                    goto label_2;
                }

                v1 = aq.a(arg3, "suggest_text_1");
                if(v1 == null) {
                    goto label_2;
                }

                v0_1 = v1;
            }
        }

    label_2:
        return ((CharSequence)v0_1);
    }

    private void d(Cursor arg3) {
        Bundle v0 = arg3 != null ? arg3.getExtras() : null;
        if(v0 != null) {
            v0.getBoolean("in_progress");
        }
    }

    private Drawable e(Cursor arg3) {
        Drawable v0;
        if(this.v == -1) {
            v0 = null;
        }
        else {
            v0 = this.a(arg3.getString(this.v));
            if(v0 == null) {
                v0 = this.g(arg3);
            }
        }

        return v0;
    }

    private Drawable f(Cursor arg3) {
        Drawable v0 = this.w == -1 ? null : this.a(arg3.getString(this.w));
        return v0;
    }

    private Drawable g(Cursor arg2) {
        Drawable v0 = this.a(this.l.getSearchActivity());
        if(v0 == null) {
            v0 = this.d.getPackageManager().getDefaultActivityIcon();
        }

        return v0;
    }

    public View getDropDownView(int arg4, View arg5, ViewGroup arg6) {
        View v0;
        try {
            v0 = super.getDropDownView(arg4, arg5, arg6);
        }
        catch(RuntimeException v2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", ((Throwable)v2));
            View v1 = this.b(this.d, this.c, arg6);
            if(v1 != null) {
                v1.getTag().a.setText(v2.toString());
            }

            v0 = v1;
        }

        return v0;
    }

    public View getView(int arg4, View arg5, ViewGroup arg6) {
        View v0;
        try {
            v0 = super.getView(arg4, arg5, arg6);
        }
        catch(RuntimeException v2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", ((Throwable)v2));
            View v1 = this.a(this.d, this.c, arg6);
            if(v1 != null) {
                v1.getTag().a.setText(v2.toString());
            }

            v0 = v1;
        }

        return v0;
    }

    public boolean hasStableIds() {
        return 0;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.d(this.a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.d(this.a());
    }

    public void onClick(View arg3) {
        Object v0 = arg3.getTag();
        if((v0 instanceof CharSequence)) {
            this.k.a(((CharSequence)v0));
        }
    }
}

