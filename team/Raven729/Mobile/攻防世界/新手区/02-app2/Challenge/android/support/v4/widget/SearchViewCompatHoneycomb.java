package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.SearchView$OnCloseListener;
import android.widget.SearchView$OnQueryTextListener;
import android.widget.SearchView;

@TargetApi(value=11) @RequiresApi(value=11) class SearchViewCompatHoneycomb {
    interface OnCloseListenerCompatBridge {
        boolean onClose();
    }

    interface OnQueryTextListenerCompatBridge {
        boolean onQueryTextChange(String arg1);

        boolean onQueryTextSubmit(String arg1);
    }

    SearchViewCompatHoneycomb() {
        super();
    }

    public static void checkIfLegalArg(View arg2) {
        if(arg2 == null) {
            throw new IllegalArgumentException("searchView must be non-null");
        }

        if(!(arg2 instanceof SearchView)) {
            throw new IllegalArgumentException("searchView must be an instance ofandroid.widget.SearchView");
        }
    }

    public static CharSequence getQuery(View arg1) {
        return ((SearchView)arg1).getQuery();
    }

    public static boolean isIconified(View arg1) {
        return ((SearchView)arg1).isIconified();
    }

    public static boolean isQueryRefinementEnabled(View arg1) {
        return ((SearchView)arg1).isQueryRefinementEnabled();
    }

    public static boolean isSubmitButtonEnabled(View arg1) {
        return ((SearchView)arg1).isSubmitButtonEnabled();
    }

    public static Object newOnCloseListener(OnCloseListenerCompatBridge arg1) {
        return new SearchView$OnCloseListener(arg1) {
            public boolean onClose() {
                return this.val$listener.onClose();
            }
        };
    }

    public static Object newOnQueryTextListener(OnQueryTextListenerCompatBridge arg1) {
        return new SearchView$OnQueryTextListener(arg1) {
            public boolean onQueryTextChange(String arg2) {
                return this.val$listener.onQueryTextChange(arg2);
            }

            public boolean onQueryTextSubmit(String arg2) {
                return this.val$listener.onQueryTextSubmit(arg2);
            }
        };
    }

    public static View newSearchView(Context arg1) {
        return new SearchView(arg1);
    }

    public static void setIconified(View arg0, boolean arg1) {
        ((SearchView)arg0).setIconified(arg1);
    }

    public static void setMaxWidth(View arg0, int arg1) {
        ((SearchView)arg0).setMaxWidth(arg1);
    }

    public static void setOnCloseListener(View arg0, Object arg1) {
        ((SearchView)arg0).setOnCloseListener(((SearchView$OnCloseListener)arg1));
    }

    public static void setOnQueryTextListener(View arg0, Object arg1) {
        ((SearchView)arg0).setOnQueryTextListener(((SearchView$OnQueryTextListener)arg1));
    }

    public static void setQuery(View arg0, CharSequence arg1, boolean arg2) {
        ((SearchView)arg0).setQuery(arg1, arg2);
    }

    public static void setQueryHint(View arg0, CharSequence arg1) {
        ((SearchView)arg0).setQueryHint(arg1);
    }

    public static void setQueryRefinementEnabled(View arg0, boolean arg1) {
        ((SearchView)arg0).setQueryRefinementEnabled(arg1);
    }

    public static void setSearchableInfo(View arg2, ComponentName arg3) {
        ((SearchView)arg2).setSearchableInfo(((SearchView)arg2).getContext().getSystemService("search").getSearchableInfo(arg3));
    }

    public static void setSubmitButtonEnabled(View arg0, boolean arg1) {
        ((SearchView)arg0).setSubmitButtonEnabled(arg1);
    }
}

