package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater;

@TargetApi(value=21) @RequiresApi(value=21) class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
        super();
    }

    static void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
        FactoryWrapperHC v0;
        if(arg2 != null) {
            v0 = new FactoryWrapperHC(arg2);
        }
        else {
            LayoutInflater$Factory2 v0_1 = null;
        }

        arg1.setFactory2(((LayoutInflater$Factory2)v0));
    }
}

