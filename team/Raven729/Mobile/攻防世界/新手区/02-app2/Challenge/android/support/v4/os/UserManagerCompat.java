package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat {
    private UserManagerCompat() {
        super();
    }

    public static boolean isUserUnlocked(Context arg1) {
        boolean v0 = BuildCompat.isAtLeastN() ? UserManagerCompatApi24.isUserUnlocked(arg1) : true;
        return v0;
    }
}

