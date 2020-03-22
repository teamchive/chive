package android.support.v4.os;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;

@TargetApi(value=24) @RequiresApi(value=24) @RestrictTo(value={Scope.LIBRARY_GROUP}) public class UserManagerCompatApi24 {
    public UserManagerCompatApi24() {
        super();
    }

    public static boolean isUserUnlocked(Context arg1) {
        return arg1.getSystemService(UserManager.class).isUserUnlocked();
    }
}

