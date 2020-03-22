package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import java.io.File;

@TargetApi(value=21) @RequiresApi(value=21) class ContextCompatApi21 {
    ContextCompatApi21() {
        super();
    }

    public static File getCodeCacheDir(Context arg1) {
        return arg1.getCodeCacheDir();
    }

    public static Drawable getDrawable(Context arg1, int arg2) {
        return arg1.getDrawable(arg2);
    }

    public static File getNoBackupFilesDir(Context arg1) {
        return arg1.getNoBackupFilesDir();
    }
}

