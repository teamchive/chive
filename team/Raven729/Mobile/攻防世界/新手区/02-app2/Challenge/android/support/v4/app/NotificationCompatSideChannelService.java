package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService extends Service {
    class NotificationSideChannelStub extends Stub {
        NotificationSideChannelStub(NotificationCompatSideChannelService arg1) {
            NotificationCompatSideChannelService.this = arg1;
            super();
        }

        public void cancel(String arg5, int arg6, String arg7) {
            NotificationCompatSideChannelService.this.checkPermission(NotificationSideChannelStub.getCallingUid(), arg5);
            long v2 = NotificationSideChannelStub.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(arg5, arg6, arg7);
            }
            catch(Throwable v0) {
                NotificationSideChannelStub.restoreCallingIdentity(v2);
                throw v0;
            }

            NotificationSideChannelStub.restoreCallingIdentity(v2);
        }

        public void cancelAll(String arg5) {
            NotificationCompatSideChannelService.this.checkPermission(NotificationSideChannelStub.getCallingUid(), arg5);
            long v2 = NotificationSideChannelStub.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(arg5);
            }
            catch(Throwable v0) {
                NotificationSideChannelStub.restoreCallingIdentity(v2);
                throw v0;
            }

            NotificationSideChannelStub.restoreCallingIdentity(v2);
        }

        public void notify(String arg5, int arg6, String arg7, Notification arg8) {
            NotificationCompatSideChannelService.this.checkPermission(NotificationSideChannelStub.getCallingUid(), arg5);
            long v2 = NotificationSideChannelStub.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(arg5, arg6, arg7, arg8);
            }
            catch(Throwable v0) {
                NotificationSideChannelStub.restoreCallingIdentity(v2);
                throw v0;
            }

            NotificationSideChannelStub.restoreCallingIdentity(v2);
        }
    }

    public NotificationCompatSideChannelService() {
        super();
    }

    public abstract void cancel(String arg1, int arg2, String arg3);

    public abstract void cancelAll(String arg1);

    void checkPermission(int arg5, String arg6) {
        String[] v1 = this.getPackageManager().getPackagesForUid(arg5);
        int v2 = v1.length;
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            if(v1[v0].equals(arg6)) {
                return;
            }
        }

        throw new SecurityException("NotificationSideChannelService: Uid " + arg5 + " is not authorized for package " + arg6);
    }

    public abstract void notify(String arg1, int arg2, String arg3, Notification arg4);

    public IBinder onBind(Intent arg4) {
        IBinder v0 = null;
        if((arg4.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) && Build$VERSION.SDK_INT <= 19) {
            NotificationSideChannelStub v0_1 = new NotificationSideChannelStub(this);
        }

        return v0;
    }
}

