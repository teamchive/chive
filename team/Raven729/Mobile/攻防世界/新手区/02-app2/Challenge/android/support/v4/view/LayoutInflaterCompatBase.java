package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;
import android.view.View;

@TargetApi(value=9) @RequiresApi(value=9) class LayoutInflaterCompatBase {
    class FactoryWrapper implements LayoutInflater$Factory {
        final LayoutInflaterFactory mDelegateFactory;

        FactoryWrapper(LayoutInflaterFactory arg1) {
            super();
            this.mDelegateFactory = arg1;
        }

        public View onCreateView(String arg3, Context arg4, AttributeSet arg5) {
            return this.mDelegateFactory.onCreateView(null, arg3, arg4, arg5);
        }

        public String toString() {
            return this.getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    LayoutInflaterCompatBase() {
        super();
    }

    static LayoutInflaterFactory getFactory(LayoutInflater arg2) {
        LayoutInflater$Factory v0 = arg2.getFactory();
        LayoutInflaterFactory v0_1 = (v0 instanceof FactoryWrapper) ? ((FactoryWrapper)v0).mDelegateFactory : null;
        return v0_1;
    }

    static void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
        LayoutInflater$Factory v0_1;
        if(arg2 != null) {
            FactoryWrapper v0 = new FactoryWrapper(arg2);
        }
        else {
            v0_1 = null;
        }

        arg1.setFactory(v0_1);
    }
}

