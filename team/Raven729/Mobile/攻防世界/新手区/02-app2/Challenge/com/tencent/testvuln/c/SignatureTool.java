package com.tencent.testvuln.c;

import android.content.Context;

public class SignatureTool {
    private static final String PKGNAME = "com.tencent.testvuln";

    public SignatureTool() {
        super();
    }

    public static int getSignature(Context arg3) {
        int v0_1;
        try {
            v0_1 = arg3.getPackageManager().getPackageInfo("com.tencent.testvuln", 0x40).signatures[0].hashCode();
        }
        catch(Exception v0) {
            v0.printStackTrace();
            v0_1 = -1;
        }

        return v0_1;
    }
}

