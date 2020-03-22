package android.support.v4.text;

import android.os.Build$VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

public final class TextUtilsCompat {
    class TextUtilsCompatImpl {
        TextUtilsCompatImpl() {
            super();
        }

        private static int getLayoutDirectionFromFirstChar(@NonNull Locale arg2) {
            int v0 = 0;
            switch(Character.getDirectionality(arg2.getDisplayName(arg2).charAt(0))) {
                case 1: 
                case 2: {
                    v0 = 1;
                    break;
                }
            }

            return v0;
        }

        public int getLayoutDirectionFromLocale(@Nullable Locale arg3) {
            int v0_1;
            if(arg3 == null || (arg3.equals(TextUtilsCompat.ROOT))) {
            label_16:
                v0_1 = 0;
            }
            else {
                String v0 = ICUCompat.maximizeAndGetScript(arg3);
                if(v0 == null) {
                    v0_1 = TextUtilsCompatImpl.getLayoutDirectionFromFirstChar(arg3);
                }
                else {
                    if(!v0.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) && !v0.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                        goto label_16;
                    }

                    v0_1 = 1;
                }
            }

            return v0_1;
        }

        @NonNull public String htmlEncode(@NonNull String arg4) {
            StringBuilder v1 = new StringBuilder();
            int v0;
            for(v0 = 0; v0 < arg4.length(); ++v0) {
                char v2 = arg4.charAt(v0);
                switch(v2) {
                    case 34: {
                        v1.append("&quot;");
                        break;
                    }
                    case 38: {
                        v1.append("&amp;");
                        break;
                    }
                    case 39: {
                        v1.append("&#39;");
                        break;
                    }
                    case 60: {
                        v1.append("&lt;");
                        break;
                    }
                    case 62: {
                        v1.append("&gt;");
                        break;
                    }
                    default: {
                        v1.append(v2);
                        break;
                    }
                }
            }

            return v1.toString();
        }
    }

    class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        public int getLayoutDirectionFromLocale(@Nullable Locale arg2) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(arg2);
        }

        @NonNull public String htmlEncode(@NonNull String arg2) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(arg2);
        }
    }

    static String ARAB_SCRIPT_SUBTAG;
    static String HEBR_SCRIPT_SUBTAG;
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT;

    static {
        TextUtilsCompat.IMPL = Build$VERSION.SDK_INT >= 17 ? new TextUtilsCompatJellybeanMr1Impl() : new TextUtilsCompatImpl();
        TextUtilsCompat.ROOT = new Locale("", "");
        TextUtilsCompat.ARAB_SCRIPT_SUBTAG = "Arab";
        TextUtilsCompat.HEBR_SCRIPT_SUBTAG = "Hebr";
    }

    private TextUtilsCompat() {
        super();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale arg1) {
        return TextUtilsCompat.IMPL.getLayoutDirectionFromLocale(arg1);
    }

    @NonNull public static String htmlEncode(@NonNull String arg1) {
        return TextUtilsCompat.IMPL.htmlEncode(arg1);
    }
}

