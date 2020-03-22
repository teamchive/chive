package com.tencent.testvuln.c;

public class Encryto {
    static {
        System.loadLibrary("JNIEncrypt");
    }

    public Encryto() {
        super();
    }

    public native String HelloLoad() {
    }

    public static native int checkSignature(Object arg0) {
    }

    public static native String decode(Object arg0, String arg1) {
    }

    public static native String doRawData(Object arg0, String arg1) {
    }

    public static native String encode(Object arg0, String arg1) {
    }
}

