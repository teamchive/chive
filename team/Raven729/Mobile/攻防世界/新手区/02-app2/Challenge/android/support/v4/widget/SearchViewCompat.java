package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build$VERSION;
import android.view.View;

public final class SearchViewCompat {
    public interface OnCloseListener {
        boolean onClose();
    }

    @Deprecated public abstract class OnCloseListenerCompat implements OnCloseListener {
        public OnCloseListenerCompat() {
            super();
        }

        public boolean onClose() {
            return 0;
        }
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String arg1);

        boolean onQueryTextSubmit(String arg1);
    }

    @Deprecated public abstract class OnQueryTextListenerCompat implements OnQueryTextListener {
        public OnQueryTextListenerCompat() {
            super();
        }

        public boolean onQueryTextChange(String arg2) {
            return 0;
        }

        public boolean onQueryTextSubmit(String arg2) {
            return 0;
        }
    }

    class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
            super();
        }

        protected void checkIfLegalArg(View arg1) {
            SearchViewCompatHoneycomb.checkIfLegalArg(arg1);
        }

        public CharSequence getQuery(View arg2) {
            this.checkIfLegalArg(arg2);
            return SearchViewCompatHoneycomb.getQuery(arg2);
        }

        public boolean isIconified(View arg2) {
            this.checkIfLegalArg(arg2);
            return SearchViewCompatHoneycomb.isIconified(arg2);
        }

        public boolean isQueryRefinementEnabled(View arg2) {
            this.checkIfLegalArg(arg2);
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(arg2);
        }

        public boolean isSubmitButtonEnabled(View arg2) {
            this.checkIfLegalArg(arg2);
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(arg2);
        }

        public Object newOnCloseListener(OnCloseListener arg2) {
            return SearchViewCompatHoneycomb.newOnCloseListener(new OnCloseListenerCompatBridge(arg2) {
                public boolean onClose() {
                    return this.val$listener.onClose();
                }
            });
        }

        public Object newOnQueryTextListener(OnQueryTextListener arg2) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(new OnQueryTextListenerCompatBridge(arg2) {
                public boolean onQueryTextChange(String arg2) {
                    return this.val$listener.onQueryTextChange(arg2);
                }

                public boolean onQueryTextSubmit(String arg2) {
                    return this.val$listener.onQueryTextSubmit(arg2);
                }
            });
        }

        public View newSearchView(Context arg2) {
            return SearchViewCompatHoneycomb.newSearchView(arg2);
        }

        public void setIconified(View arg1, boolean arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setIconified(arg1, arg2);
        }

        public void setMaxWidth(View arg1, int arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setMaxWidth(arg1, arg2);
        }

        public void setOnCloseListener(View arg2, OnCloseListener arg3) {
            this.checkIfLegalArg(arg2);
            SearchViewCompatHoneycomb.setOnCloseListener(arg2, this.newOnCloseListener(arg3));
        }

        public void setOnQueryTextListener(View arg2, OnQueryTextListener arg3) {
            this.checkIfLegalArg(arg2);
            SearchViewCompatHoneycomb.setOnQueryTextListener(arg2, this.newOnQueryTextListener(arg3));
        }

        public void setQuery(View arg1, CharSequence arg2, boolean arg3) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setQuery(arg1, arg2, arg3);
        }

        public void setQueryHint(View arg1, CharSequence arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setQueryHint(arg1, arg2);
        }

        public void setQueryRefinementEnabled(View arg1, boolean arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(arg1, arg2);
        }

        public void setSearchableInfo(View arg1, ComponentName arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setSearchableInfo(arg1, arg2);
        }

        public void setSubmitButtonEnabled(View arg1, boolean arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(arg1, arg2);
        }
    }

    class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
            super();
        }

        public View newSearchView(Context arg2) {
            return SearchViewCompatIcs.newSearchView(arg2);
        }

        public void setImeOptions(View arg1, int arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatIcs.setImeOptions(arg1, arg2);
        }

        public void setInputType(View arg1, int arg2) {
            this.checkIfLegalArg(arg1);
            SearchViewCompatIcs.setInputType(arg1, arg2);
        }
    }

    interface SearchViewCompatImpl {
        CharSequence getQuery(View arg1);

        boolean isIconified(View arg1);

        boolean isQueryRefinementEnabled(View arg1);

        boolean isSubmitButtonEnabled(View arg1);

        Object newOnCloseListener(OnCloseListener arg1);

        Object newOnQueryTextListener(OnQueryTextListener arg1);

        View newSearchView(Context arg1);

        void setIconified(View arg1, boolean arg2);

        void setImeOptions(View arg1, int arg2);

        void setInputType(View arg1, int arg2);

        void setMaxWidth(View arg1, int arg2);

        void setOnCloseListener(View arg1, OnCloseListener arg2);

        void setOnQueryTextListener(View arg1, OnQueryTextListener arg2);

        void setQuery(View arg1, CharSequence arg2, boolean arg3);

        void setQueryHint(View arg1, CharSequence arg2);

        void setQueryRefinementEnabled(View arg1, boolean arg2);

        void setSearchableInfo(View arg1, ComponentName arg2);

        void setSubmitButtonEnabled(View arg1, boolean arg2);
    }

    class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
            super();
        }

        public CharSequence getQuery(View arg2) {
            return null;
        }

        public boolean isIconified(View arg2) {
            return 1;
        }

        public boolean isQueryRefinementEnabled(View arg2) {
            return 0;
        }

        public boolean isSubmitButtonEnabled(View arg2) {
            return 0;
        }

        public Object newOnCloseListener(OnCloseListener arg2) {
            return null;
        }

        public Object newOnQueryTextListener(OnQueryTextListener arg2) {
            return null;
        }

        public View newSearchView(Context arg2) {
            return null;
        }

        public void setIconified(View arg1, boolean arg2) {
        }

        public void setImeOptions(View arg1, int arg2) {
        }

        public void setInputType(View arg1, int arg2) {
        }

        public void setMaxWidth(View arg1, int arg2) {
        }

        public void setOnCloseListener(View arg1, OnCloseListener arg2) {
        }

        public void setOnQueryTextListener(View arg1, OnQueryTextListener arg2) {
        }

        public void setQuery(View arg1, CharSequence arg2, boolean arg3) {
        }

        public void setQueryHint(View arg1, CharSequence arg2) {
        }

        public void setQueryRefinementEnabled(View arg1, boolean arg2) {
        }

        public void setSearchableInfo(View arg1, ComponentName arg2) {
        }

        public void setSubmitButtonEnabled(View arg1, boolean arg2) {
        }
    }

    private static final SearchViewCompatImpl IMPL;

    static {
        if(Build$VERSION.SDK_INT >= 14) {
            SearchViewCompat.IMPL = new SearchViewCompatIcsImpl();
        }
        else if(Build$VERSION.SDK_INT >= 11) {
            SearchViewCompat.IMPL = new SearchViewCompatHoneycombImpl();
        }
        else {
            SearchViewCompat.IMPL = new SearchViewCompatStubImpl();
        }
    }

    private SearchViewCompat(Context arg1) {
        super();
    }

    public static CharSequence getQuery(View arg1) {
        return SearchViewCompat.IMPL.getQuery(arg1);
    }

    public static boolean isIconified(View arg1) {
        return SearchViewCompat.IMPL.isIconified(arg1);
    }

    public static boolean isQueryRefinementEnabled(View arg1) {
        return SearchViewCompat.IMPL.isQueryRefinementEnabled(arg1);
    }

    public static boolean isSubmitButtonEnabled(View arg1) {
        return SearchViewCompat.IMPL.isSubmitButtonEnabled(arg1);
    }

    public static View newSearchView(Context arg1) {
        return SearchViewCompat.IMPL.newSearchView(arg1);
    }

    public static void setIconified(View arg1, boolean arg2) {
        SearchViewCompat.IMPL.setIconified(arg1, arg2);
    }

    public static void setImeOptions(View arg1, int arg2) {
        SearchViewCompat.IMPL.setImeOptions(arg1, arg2);
    }

    public static void setInputType(View arg1, int arg2) {
        SearchViewCompat.IMPL.setInputType(arg1, arg2);
    }

    public static void setMaxWidth(View arg1, int arg2) {
        SearchViewCompat.IMPL.setMaxWidth(arg1, arg2);
    }

    public static void setOnCloseListener(View arg1, OnCloseListener arg2) {
        SearchViewCompat.IMPL.setOnCloseListener(arg1, arg2);
    }

    public static void setOnQueryTextListener(View arg1, OnQueryTextListener arg2) {
        SearchViewCompat.IMPL.setOnQueryTextListener(arg1, arg2);
    }

    public static void setQuery(View arg1, CharSequence arg2, boolean arg3) {
        SearchViewCompat.IMPL.setQuery(arg1, arg2, arg3);
    }

    public static void setQueryHint(View arg1, CharSequence arg2) {
        SearchViewCompat.IMPL.setQueryHint(arg1, arg2);
    }

    public static void setQueryRefinementEnabled(View arg1, boolean arg2) {
        SearchViewCompat.IMPL.setQueryRefinementEnabled(arg1, arg2);
    }

    public static void setSearchableInfo(View arg1, ComponentName arg2) {
        SearchViewCompat.IMPL.setSearchableInfo(arg1, arg2);
    }

    public static void setSubmitButtonEnabled(View arg1, boolean arg2) {
        SearchViewCompat.IMPL.setSubmitButtonEnabled(arg1, arg2);
    }
}

