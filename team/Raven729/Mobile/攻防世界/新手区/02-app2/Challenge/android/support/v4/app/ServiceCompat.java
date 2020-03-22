package android.support.v4.app;

import android.app.Service;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    class Api24ServiceCompatImpl implements ServiceCompatImpl {
        Api24ServiceCompatImpl() {
            super();
        }

        public void stopForeground(Service arg1, int arg2) {
            ServiceCompatApi24.stopForeground(arg1, arg2);
        }
    }

    class BaseServiceCompatImpl implements ServiceCompatImpl {
        BaseServiceCompatImpl() {
            super();
        }

        public void stopForeground(Service arg2, int arg3) {
            boolean v0 = (arg3 & 1) != 0 ? true : false;
            arg2.stopForeground(v0);
        }
    }

    interface ServiceCompatImpl {
        void stopForeground(Service arg1, int arg2);
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface StopForegroundFlags {
    }

    static final ServiceCompatImpl IMPL = null;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    static {
        ServiceCompat.IMPL = BuildCompat.isAtLeastN() ? new Api24ServiceCompatImpl() : new BaseServiceCompatImpl();
    }

    private ServiceCompat() {
        super();
    }

    public static void stopForeground(Service arg1, int arg2) {
        ServiceCompat.IMPL.stopForeground(arg1, arg2);
    }
}

