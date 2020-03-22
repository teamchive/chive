package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong INSTANCE_LTR;
        public static final AnyStrong INSTANCE_RTL;
        private final boolean mLookForRtl;

        static {
            AnyStrong.INSTANCE_RTL = new AnyStrong(true);
            AnyStrong.INSTANCE_LTR = new AnyStrong(false);
        }

        private AnyStrong(boolean arg1) {
            super();
            this.mLookForRtl = arg1;
        }

        public int checkRtl(CharSequence arg6, int arg7, int arg8) {
            int v1 = 1;
            int v3 = arg7 + arg8;
            int v0 = 0;
            while(arg7 < v3) {
                switch(TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(arg6.charAt(arg7)))) {
                    case 0: {
                        if(this.mLookForRtl) {
                            v1 = 0;
                        }
                        else {
                            v0 = 1;
                            goto label_9;
                        }

                        return v1;
                    }
                    case 1: {
                        if(this.mLookForRtl) {
                            v0 = 1;
                            goto label_9;
                        }

                        return v1;
                    }
                }

            label_9:
                ++arg7;
            }

            if(v0 == 0) {
                v1 = 2;
            }
            else if(!this.mLookForRtl) {
                v1 = 0;
            }

            return v1;
        }
    }

    class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE;

        static {
            FirstStrong.INSTANCE = new FirstStrong();
        }

        private FirstStrong() {
            super();
        }

        public int checkRtl(CharSequence arg4, int arg5, int arg6) {
            int v1 = 2;
            int v2 = arg5 + arg6;
            int v0 = v1;
            while(arg5 < v2) {
                if(v0 != v1) {
                    return v0;
                }

                v0 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(arg4.charAt(arg5)));
                ++arg5;
            }

            return v0;
        }
    }

    interface TextDirectionAlgorithm {
        int checkRtl(CharSequence arg1, int arg2, int arg3);
    }

    abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm arg1) {
            super();
            this.mAlgorithm = arg1;
        }

        protected abstract boolean defaultIsRtl();

        private boolean doCheck(CharSequence arg2, int arg3, int arg4) {
            boolean v0;
            switch(this.mAlgorithm.checkRtl(arg2, arg3, arg4)) {
                case 0: {
                    v0 = true;
                    break;
                }
                case 1: {
                    v0 = false;
                    break;
                }
                default: {
                    v0 = this.defaultIsRtl();
                    break;
                }
            }

            return v0;
        }

        public boolean isRtl(CharSequence arg2, int arg3, int arg4) {
            if(arg2 != null && arg3 >= 0 && arg4 >= 0 && arg2.length() - arg4 >= arg3) {
                boolean v0 = this.mAlgorithm == null ? this.defaultIsRtl() : this.doCheck(arg2, arg3, arg4);
                return v0;
            }

            throw new IllegalArgumentException();
        }

        public boolean isRtl(char[] arg2, int arg3, int arg4) {
            return this.isRtl(CharBuffer.wrap(arg2), arg3, arg4);
        }
    }

    class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm arg1, boolean arg2) {
            super(arg1);
            this.mDefaultIsRtl = arg2;
        }

        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale INSTANCE;

        static {
            TextDirectionHeuristicLocale.INSTANCE = new TextDirectionHeuristicLocale();
        }

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        protected boolean defaultIsRtl() {
            boolean v0 = true;
            if(TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                v0 = false;
            }

            return v0;
        }
    }

    public static final TextDirectionHeuristicCompat ANYRTL_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = null;
    public static final TextDirectionHeuristicCompat LOCALE = null;
    public static final TextDirectionHeuristicCompat LTR = null;
    public static final TextDirectionHeuristicCompat RTL = null;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static {
        TextDirectionHeuristicsCompat.LTR = new TextDirectionHeuristicInternal(null, false);
        TextDirectionHeuristicsCompat.RTL = new TextDirectionHeuristicInternal(null, true);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
        TextDirectionHeuristicsCompat.ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        TextDirectionHeuristicsCompat.LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
        super();
    }

    static int isRtlText(int arg1) {
        int v0;
        switch(arg1) {
            case 0: {
                v0 = 1;
                break;
            }
            case 1: 
            case 2: {
                v0 = 0;
                break;
            }
            default: {
                v0 = 2;
                break;
            }
        }

        return v0;
    }

    static int isRtlTextOrFormat(int arg1) {
        int v0;
        switch(arg1) {
            case 0: 
            case 14: 
            case 15: {
                v0 = 1;
                break;
            }
            case 1: 
            case 2: 
            case 16: 
            case 17: {
                v0 = 0;
                break;
            }
            default: {
                v0 = 2;
                break;
            }
        }

        return v0;
    }
}

