package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat {
    class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public Api23FingerprintManagerCompatImpl() {
            super();
        }

        public void authenticate(Context arg7, CryptoObject arg8, int arg9, CancellationSignal arg10, AuthenticationCallback arg11, Handler arg12) {
            android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject v1 = Api23FingerprintManagerCompatImpl.wrapCryptoObject(arg8);
            Object v3 = arg10 != null ? arg10.getCancellationSignalObject() : null;
            FingerprintManagerCompatApi23.authenticate(arg7, v1, arg9, v3, Api23FingerprintManagerCompatImpl.wrapCallback(arg11), arg12);
        }

        public boolean hasEnrolledFingerprints(Context arg2) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(arg2);
        }

        public boolean isHardwareDetected(Context arg2) {
            return FingerprintManagerCompatApi23.isHardwareDetected(arg2);
        }

        static CryptoObject unwrapCryptoObject(android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject arg2) {
            CryptoObject v0 = null;
            if(arg2 != null) {
                if(arg2.getCipher() != null) {
                    v0 = new CryptoObject(arg2.getCipher());
                }
                else if(arg2.getSignature() != null) {
                    v0 = new CryptoObject(arg2.getSignature());
                }
                else if(arg2.getMac() != null) {
                    v0 = new CryptoObject(arg2.getMac());
                }
            }

            return v0;
        }

        private static android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback wrapCallback(AuthenticationCallback arg1) {
            return new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback(arg1) {
                public void onAuthenticationError(int arg2, CharSequence arg3) {
                    this.val$callback.onAuthenticationError(arg2, arg3);
                }

                public void onAuthenticationFailed() {
                    this.val$callback.onAuthenticationFailed();
                }

                public void onAuthenticationHelp(int arg2, CharSequence arg3) {
                    this.val$callback.onAuthenticationHelp(arg2, arg3);
                }

                public void onAuthenticationSucceeded(AuthenticationResultInternal arg4) {
                    this.val$callback.onAuthenticationSucceeded(new AuthenticationResult(Api23FingerprintManagerCompatImpl.unwrapCryptoObject(arg4.getCryptoObject())));
                }
            };
        }

        private static android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject wrapCryptoObject(CryptoObject arg2) {
            android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject v0 = null;
            if(arg2 != null) {
                if(arg2.getCipher() != null) {
                    v0 = new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject(arg2.getCipher());
                }
                else if(arg2.getSignature() != null) {
                    v0 = new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject(arg2.getSignature());
                }
                else if(arg2.getMac() != null) {
                    v0 = new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject(arg2.getMac());
                }
            }

            return v0;
        }
    }

    public abstract class AuthenticationCallback {
        public AuthenticationCallback() {
            super();
        }

        public void onAuthenticationError(int arg1, CharSequence arg2) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int arg1, CharSequence arg2) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult arg1) {
        }
    }

    public final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject arg1) {
            super();
            this.mCryptoObject = arg1;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Cipher arg2) {
            super();
            this.mCipher = arg2;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Signature arg2) {
            super();
            this.mSignature = arg2;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Mac arg2) {
            super();
            this.mMac = arg2;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    interface FingerprintManagerCompatImpl {
        void authenticate(Context arg1, CryptoObject arg2, int arg3, CancellationSignal arg4, AuthenticationCallback arg5, Handler arg6);

        boolean hasEnrolledFingerprints(Context arg1);

        boolean isHardwareDetected(Context arg1);
    }

    class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public LegacyFingerprintManagerCompatImpl() {
            super();
        }

        public void authenticate(Context arg1, CryptoObject arg2, int arg3, CancellationSignal arg4, AuthenticationCallback arg5, Handler arg6) {
        }

        public boolean hasEnrolledFingerprints(Context arg2) {
            return 0;
        }

        public boolean isHardwareDetected(Context arg2) {
            return 0;
        }
    }

    static final FingerprintManagerCompatImpl IMPL;
    private Context mContext;

    static {
        FingerprintManagerCompat.IMPL = Build$VERSION.SDK_INT >= 23 ? new Api23FingerprintManagerCompatImpl() : new LegacyFingerprintManagerCompatImpl();
    }

    private FingerprintManagerCompat(Context arg1) {
        super();
        this.mContext = arg1;
    }

    public void authenticate(@Nullable CryptoObject arg8, int arg9, @Nullable CancellationSignal arg10, @NonNull AuthenticationCallback arg11, @Nullable Handler arg12) {
        FingerprintManagerCompat.IMPL.authenticate(this.mContext, arg8, arg9, arg10, arg11, arg12);
    }

    public static FingerprintManagerCompat from(Context arg1) {
        return new FingerprintManagerCompat(arg1);
    }

    public boolean hasEnrolledFingerprints() {
        return FingerprintManagerCompat.IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isHardwareDetected() {
        return FingerprintManagerCompat.IMPL.isHardwareDetected(this.mContext);
    }
}

