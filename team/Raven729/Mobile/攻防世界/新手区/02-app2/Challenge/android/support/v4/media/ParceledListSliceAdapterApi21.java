package android.support.v4.media;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@TargetApi(value=21) @RequiresApi(value=21) class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        try {
            ParceledListSliceAdapterApi21.sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
            return;
        }
        catch(NoSuchMethodException v0) {
        }
        catch(ClassNotFoundException v0_1) {
        }

        ((ReflectiveOperationException)v0).printStackTrace();
    }

    ParceledListSliceAdapterApi21() {
        super();
    }

    static Object newInstance(List arg4) {
        Object v1 = null;
        try {
            Object v0_3 = ParceledListSliceAdapterApi21.sConstructor.newInstance(arg4);
            return v0_3;
        }
        catch(InvocationTargetException v0) {
        }
        catch(IllegalAccessException v0_1) {
        }
        catch(InstantiationException v0_2) {
        }

        ((ReflectiveOperationException)v0_1).printStackTrace();
        return v1;
    }
}

