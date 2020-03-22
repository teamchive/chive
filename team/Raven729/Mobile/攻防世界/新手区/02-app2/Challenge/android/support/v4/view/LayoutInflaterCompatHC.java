package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

@TargetApi(value=11) @RequiresApi(value=11) class LayoutInflaterCompatHC {
    class FactoryWrapperHC extends FactoryWrapper implements LayoutInflater$Factory2 {
        FactoryWrapperHC(LayoutInflaterFactory arg1) {
            super(arg1);
        }

        public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
            return this.mDelegateFactory.onCreateView(arg2, arg3, arg4, arg5);
        }
    }

    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    LayoutInflaterCompatHC() {
        super();
    }

    static void forceSetFactory2(LayoutInflater arg5, LayoutInflater$Factory2 arg6) {
        if(!LayoutInflaterCompatHC.sCheckedField) {
            try {
                LayoutInflaterCompatHC.sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
                LayoutInflaterCompatHC.sLayoutInflaterFactory2Field.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field \'mFactory2\' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", ((Throwable)v0));
            }

            LayoutInflaterCompatHC.sCheckedField = true;
        }

        if(LayoutInflaterCompatHC.sLayoutInflaterFactory2Field != null) {
            try {
                LayoutInflaterCompatHC.sLayoutInflaterFactory2Field.set(arg5, arg6);
            }
            catch(IllegalAccessException v0_1) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + arg5 + "; inflation may have unexpected results.", ((Throwable)v0_1));
            }
        }
    }

    static void setFactory(LayoutInflater arg3, LayoutInflaterFactory arg4) {
        LayoutInflater$Factory2 v1_1;
        if(arg4 != null) {
            FactoryWrapperHC v1 = new FactoryWrapperHC(arg4);
        }
        else {
            v1_1 = null;
        }

        arg3.setFactory2(v1_1);
        LayoutInflater$Factory v0 = arg3.getFactory();
        if((v0 instanceof LayoutInflater$Factory2)) {
            LayoutInflaterCompatHC.forceSetFactory2(arg3, ((LayoutInflater$Factory2)v0));
        }
        else {
            LayoutInflaterCompatHC.forceSetFactory2(arg3, v1_1);
        }
    }
}

