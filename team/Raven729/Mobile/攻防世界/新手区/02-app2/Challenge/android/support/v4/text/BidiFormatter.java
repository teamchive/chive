package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
    class android.support.v4.text.BidiFormatter$1 {
    }

    public final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            super();
            this.initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale arg2) {
            super();
            this.initialize(BidiFormatter.isRtlLocale(arg2));
        }

        public Builder(boolean arg1) {
            super();
            this.initialize(arg1);
        }

        public BidiFormatter build() {
            BidiFormatter v0 = this.mFlags != 2 || this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC ? new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null) : Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
            return v0;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean arg1) {
            BidiFormatter v0 = arg1 ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
            return v0;
        }

        private void initialize(boolean arg2) {
            this.mIsRtlContext = arg2;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat arg1) {
            this.mTextDirectionHeuristicCompat = arg1;
            return this;
        }

        public Builder stereoReset(boolean arg2) {
            if(arg2) {
                this.mFlags |= 2;
            }
            else {
                this.mFlags &= -3;
            }

            return this;
        }
    }

    class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 0x700;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            int v3 = 0x700;
            DirectionalityEstimator.DIR_TYPE_CACHE = new byte[v3];
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                DirectionalityEstimator.DIR_TYPE_CACHE[v0] = Character.getDirectionality(v0);
            }
        }

        DirectionalityEstimator(CharSequence arg2, boolean arg3) {
            super();
            this.text = arg2;
            this.isHtml = arg3;
            this.length = arg2.length();
        }

        byte dirTypeBackward() {
            byte v0_1;
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if(Character.isLowSurrogate(this.lastChar)) {
                int v0 = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(v0);
                v0_1 = Character.getDirectionality(v0);
            }
            else {
                --this.charIndex;
                v0_1 = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
                if(this.isHtml) {
                    if(this.lastChar == 62) {
                        v0_1 = this.skipTagBackward();
                    }
                    else if(this.lastChar == 59) {
                        v0_1 = this.skipEntityBackward();
                    }
                }
            }

            return v0_1;
        }

        byte dirTypeForward() {
            byte v0_1;
            this.lastChar = this.text.charAt(this.charIndex);
            if(Character.isHighSurrogate(this.lastChar)) {
                int v0 = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(v0);
                v0_1 = Character.getDirectionality(v0);
            }
            else {
                ++this.charIndex;
                v0_1 = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
                if(this.isHtml) {
                    if(this.lastChar == 60) {
                        v0_1 = this.skipTagForward();
                    }
                    else if(this.lastChar == 38) {
                        v0_1 = this.skipEntityForward();
                    }
                }
            }

            return v0_1;
        }

        private static byte getCachedDirectionality(char arg1) {
            byte v0 = arg1 < 0x700 ? DirectionalityEstimator.DIR_TYPE_CACHE[arg1] : Character.getDirectionality(arg1);
            return v0;
        }

        int getEntryDir() {
            int v4 = -1;
            this.charIndex = 0;
            int v0 = 0;
            int v3 = 0;
            int v2 = 0;
            while(true) {
            label_7:
                if(this.charIndex >= this.length) {
                    break;
                }
                else if(v0 == 0) {
                    switch(this.dirTypeForward()) {
                        case 0: {
                            goto label_24;
                        }
                        case 1: 
                        case 2: {
                            goto label_28;
                        }
                        case 9: {
                            goto label_7;
                        }
                        case 14: 
                        case 15: {
                            goto label_15;
                        }
                        case 16: 
                        case 17: {
                            goto label_18;
                        }
                        case 18: {
                            goto label_21;
                        }
                    }

                    v0 = v2;
                    continue;
                label_18:
                    ++v2;
                    v3 = 1;
                    continue;
                label_21:
                    --v2;
                    v3 = 0;
                    continue;
                label_24:
                    if(v2 != 0) {
                        v0 = v2;
                        continue;
                    label_28:
                        if(v2 == 0) {
                            v4 = 1;
                        }
                        else {
                            v0 = v2;
                            continue;
                        label_15:
                            ++v2;
                            v3 = v4;
                            continue;
                        }
                    }
                }
                else {
                    break;
                }

                return v4;
            }

            if(v0 == 0) {
                v4 = 0;
            }
            else {
                if(v3 != 0) {
                    return v3;
                }

                while(this.charIndex > 0) {
                    switch(this.dirTypeBackward()) {
                        case 14: 
                        case 15: {
                            goto label_44;
                        }
                        case 16: 
                        case 17: {
                            goto label_47;
                        }
                        case 18: {
                            goto label_52;
                        }
                    }

                    continue;
                label_52:
                    ++v2;
                    continue;
                label_44:
                    if(v0 == v2) {
                        return v4;
                    }

                    --v2;
                    continue;
                label_47:
                    if(v0 == v2) {
                        return 1;
                    }

                    --v2;
                }

                v4 = 0;
            }

            return v4;
        }

        int getExitDir() {
            int v3 = -1;
            int v1 = 0;
            this.charIndex = this.length;
            int v0 = 0;
            int v2 = 0;
        label_7:
            while(this.charIndex > 0) {
                switch(this.dirTypeBackward()) {
                    case 0: {
                        goto label_14;
                    }
                    case 1: 
                    case 2: {
                        goto label_25;
                    }
                    case 9: {
                        goto label_7;
                    }
                    case 14: 
                    case 15: {
                        goto label_20;
                    }
                    case 16: 
                    case 17: {
                        goto label_31;
                    }
                    case 18: {
                        goto label_36;
                    }
                }

                if(v0 != 0) {
                    continue;
                }

                v0 = v2;
                continue;
            label_36:
                ++v2;
                continue;
            label_20:
                if(v0 == v2) {
                    v1 = v3;
                }
                else {
                    --v2;
                    continue;
                label_25:
                    if(v2 == 0) {
                        v1 = 1;
                    }
                    else {
                        if(v0 != 0) {
                            continue;
                        }

                        v0 = v2;
                        continue;
                    label_14:
                        if(v2 == 0) {
                            v1 = v3;
                        }
                        else {
                            if(v0 != 0) {
                                continue;
                            }

                            v0 = v2;
                            continue;
                        label_31:
                            if(v0 == v2) {
                                v1 = 1;
                            }
                            else {
                                --v2;
                                continue;
                            }
                        }
                    }
                }

                return v1;
            }

            return v1;
        }

        private byte skipEntityBackward() {
            byte v0_1;
            char v3 = ';';
            int v0 = this.charIndex;
            do {
                if(this.charIndex > 0) {
                    CharSequence v1 = this.text;
                    int v2 = this.charIndex - 1;
                    this.charIndex = v2;
                    this.lastChar = v1.charAt(v2);
                    if(this.lastChar == 38) {
                        v0_1 = 12;
                    }
                    else {
                        if(this.lastChar != v3) {
                            continue;
                        }

                        break;
                    }
                }
                else {
                    break;
                }

                return v0_1;
            }
            while(true);

            this.charIndex = v0;
            this.lastChar = v3;
            return 13;
        }

        private byte skipEntityForward() {
            do {
                if(this.charIndex >= this.length) {
                    return 12;
                }

                CharSequence v0 = this.text;
                int v1 = this.charIndex;
                this.charIndex = v1 + 1;
                char v0_1 = v0.charAt(v1);
                this.lastChar = v0_1;
            }
            while(v0_1 != 59);

            return 12;
        }

        private byte skipTagBackward() {
            byte v0_1;
            char v4 = '>';
            int v0 = this.charIndex;
            do {
            label_2:
                if(this.charIndex > 0) {
                    CharSequence v1 = this.text;
                    int v2 = this.charIndex - 1;
                    this.charIndex = v2;
                    this.lastChar = v1.charAt(v2);
                    if(this.lastChar == 60) {
                        v0_1 = 12;
                    }
                    else if(this.lastChar != v4) {
                        if(this.lastChar != 34 && this.lastChar != 39) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_17;
                    }
                }
                else {
                    goto label_17;
                }

                return v0_1;
            }
            while(true);

            char v1_1 = this.lastChar;
            goto label_28;
        label_17:
            this.charIndex = v0;
            this.lastChar = v4;
            return 13;
            while(true) {
            label_28:
                if(this.charIndex <= 0) {
                    goto label_2;
                }

                CharSequence v2_1 = this.text;
                int v3 = this.charIndex - 1;
                this.charIndex = v3;
                char v2_2 = v2_1.charAt(v3);
                this.lastChar = v2_2;
                if(v2_2 == v1_1) {
                    goto label_2;
                }
            }
        }

        private byte skipTagForward() {
            byte v0_1;
            int v0 = this.charIndex;
            do {
            label_1:
                if(this.charIndex < this.length) {
                    CharSequence v1 = this.text;
                    int v2 = this.charIndex;
                    this.charIndex = v2 + 1;
                    this.lastChar = v1.charAt(v2);
                    if(this.lastChar == 62) {
                        v0_1 = 12;
                    }
                    else {
                        if(this.lastChar != 34 && this.lastChar != 39) {
                            continue;
                        }

                        break;
                    }
                }
                else {
                    goto label_33;
                }

                return v0_1;
            }
            while(true);

            char v1_1 = this.lastChar;
            goto label_22;
        label_33:
            this.charIndex = v0;
            this.lastChar = '<';
            return 13;
            while(true) {
            label_22:
                if(this.charIndex >= this.length) {
                    goto label_1;
                }

                CharSequence v2_1 = this.text;
                int v3 = this.charIndex;
                this.charIndex = v3 + 1;
                char v2_2 = v2_1.charAt(v3);
                this.lastChar = v2_2;
                if(v2_2 == v1_1) {
                    goto label_1;
                }
            }
        }
    }

    private static final int DEFAULT_FLAGS = 2;
    private static final BidiFormatter DEFAULT_LTR_INSTANCE = null;
    private static final BidiFormatter DEFAULT_RTL_INSTANCE = null;
    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = null;
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    static {
        BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        BidiFormatter.LRM_STRING = Character.toString('‎');
        BidiFormatter.RLM_STRING = Character.toString('‏');
        BidiFormatter.DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
        BidiFormatter.DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
    }

    private BidiFormatter(boolean arg1, int arg2, TextDirectionHeuristicCompat arg3) {
        super();
        this.mIsRtlContext = arg1;
        this.mFlags = arg2;
        this.mDefaultTextDirectionHeuristicCompat = arg3;
    }

    BidiFormatter(boolean arg1, int arg2, TextDirectionHeuristicCompat arg3, android.support.v4.text.BidiFormatter$1 arg4) {
        this(arg1, arg2, arg3);
    }

    static boolean access$000(Locale arg1) {
        return BidiFormatter.isRtlLocale(arg1);
    }

    static TextDirectionHeuristicCompat access$100() {
        return BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
    }

    static BidiFormatter access$200() {
        return BidiFormatter.DEFAULT_RTL_INSTANCE;
    }

    static BidiFormatter access$300() {
        return BidiFormatter.DEFAULT_LTR_INSTANCE;
    }

    private static int getEntryDir(CharSequence arg2) {
        return new DirectionalityEstimator(arg2, false).getEntryDir();
    }

    private static int getExitDir(CharSequence arg2) {
        return new DirectionalityEstimator(arg2, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale arg1) {
        return new Builder(arg1).build();
    }

    public static BidiFormatter getInstance(boolean arg1) {
        return new Builder(arg1).build();
    }

    public boolean getStereoReset() {
        boolean v0 = (this.mFlags & 2) != 0 ? true : false;
        return v0;
    }

    public boolean isRtl(CharSequence arg4) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(arg4, 0, arg4.length());
    }

    public boolean isRtl(String arg2) {
        return this.isRtl(((CharSequence)arg2));
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    private static boolean isRtlLocale(Locale arg2) {
        boolean v0 = true;
        if(TextUtilsCompat.getLayoutDirectionFromLocale(arg2) != 1) {
            v0 = false;
        }

        return v0;
    }

    private String markAfter(CharSequence arg4, TextDirectionHeuristicCompat arg5) {
        String v0_1;
        boolean v0 = arg5.isRtl(arg4, 0, arg4.length());
        if(!this.mIsRtlContext) {
            if(!v0 && BidiFormatter.getExitDir(arg4) != 1) {
                goto label_11;
            }

            v0_1 = BidiFormatter.LRM_STRING;
        }
        else {
        label_11:
            if((this.mIsRtlContext) && (!v0 || BidiFormatter.getExitDir(arg4) == -1)) {
                return BidiFormatter.RLM_STRING;
            }

            v0_1 = "";
        }

        return v0_1;
    }

    private String markBefore(CharSequence arg4, TextDirectionHeuristicCompat arg5) {
        String v0_1;
        boolean v0 = arg5.isRtl(arg4, 0, arg4.length());
        if(!this.mIsRtlContext) {
            if(!v0 && BidiFormatter.getEntryDir(arg4) != 1) {
                goto label_11;
            }

            v0_1 = BidiFormatter.LRM_STRING;
        }
        else {
        label_11:
            if((this.mIsRtlContext) && (!v0 || BidiFormatter.getEntryDir(arg4) == -1)) {
                return BidiFormatter.RLM_STRING;
            }

            v0_1 = "";
        }

        return v0_1;
    }

    public CharSequence unicodeWrap(CharSequence arg3) {
        return this.unicodeWrap(arg3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence arg4, TextDirectionHeuristicCompat arg5, boolean arg6) {
        TextDirectionHeuristicCompat v0_1;
        CharSequence v0;
        if(arg4 == null) {
            v0 = null;
        }
        else {
            boolean v2 = arg5.isRtl(arg4, 0, arg4.length());
            SpannableStringBuilder v1 = new SpannableStringBuilder();
            if((this.getStereoReset()) && (arg6)) {
                v0_1 = v2 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
                v1.append(this.markBefore(arg4, v0_1));
            }

            if(v2 != this.mIsRtlContext) {
                char v0_2 = v2 ? '‫' : '‪';
                v1.append(v0_2);
                v1.append(arg4);
                v1.append('‬');
            }
            else {
                v1.append(arg4);
            }

            if(arg6) {
                v0_1 = v2 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
                v1.append(this.markAfter(arg4, v0_1));
            }

            SpannableStringBuilder v0_3 = v1;
        }

        return v0;
    }

    public CharSequence unicodeWrap(CharSequence arg2, TextDirectionHeuristicCompat arg3) {
        return this.unicodeWrap(arg2, arg3, true);
    }

    public CharSequence unicodeWrap(CharSequence arg2, boolean arg3) {
        return this.unicodeWrap(arg2, this.mDefaultTextDirectionHeuristicCompat, arg3);
    }

    public String unicodeWrap(String arg3) {
        return this.unicodeWrap(arg3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String arg2, TextDirectionHeuristicCompat arg3, boolean arg4) {
        String v0 = arg2 == null ? null : this.unicodeWrap(((CharSequence)arg2), arg3, arg4).toString();
        return v0;
    }

    public String unicodeWrap(String arg2, TextDirectionHeuristicCompat arg3) {
        return this.unicodeWrap(arg2, arg3, true);
    }

    public String unicodeWrap(String arg2, boolean arg3) {
        return this.unicodeWrap(arg2, this.mDefaultTextDirectionHeuristicCompat, arg3);
    }
}

