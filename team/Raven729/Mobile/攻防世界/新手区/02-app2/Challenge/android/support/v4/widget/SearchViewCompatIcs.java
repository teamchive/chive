package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.SearchView;

@TargetApi(value=14) @RequiresApi(value=14) class SearchViewCompatIcs {
    public class MySearchView extends SearchView {
        public MySearchView(Context arg1) {
            super(arg1);
        }

        public void onActionViewCollapsed() {
            this.setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    SearchViewCompatIcs() {
        super();
    }

    public static View newSearchView(Context arg1) {
        return new MySearchView(arg1);
    }

    public static void setImeOptions(View arg0, int arg1) {
        ((SearchView)arg0).setImeOptions(arg1);
    }

    public static void setInputType(View arg0, int arg1) {
        ((SearchView)arg0).setInputType(arg1);
    }
}

