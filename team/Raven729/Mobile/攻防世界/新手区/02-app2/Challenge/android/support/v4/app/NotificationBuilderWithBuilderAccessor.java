package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification$Builder;
import android.app.Notification;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@TargetApi(value=11) @RequiresApi(value=11) @RestrictTo(value={Scope.LIBRARY_GROUP}) public interface NotificationBuilderWithBuilderAccessor {
    Notification build();

    Notification$Builder getBuilder();
}

