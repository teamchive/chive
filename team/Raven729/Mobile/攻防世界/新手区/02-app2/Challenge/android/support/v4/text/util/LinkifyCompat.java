package android.support.v4.text.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify$MatchFilter;
import android.text.util.Linkify$TransformFilter;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    final class android.support.v4.text.util.LinkifyCompat$1 implements Comparator {
        android.support.v4.text.util.LinkifyCompat$1() {
            super();
        }

        public final int compare(LinkSpec arg5, LinkSpec arg6) {
            int v0 = -1;
            if(arg5.start >= arg6.start) {
                if(arg5.start > arg6.start) {
                    v0 = 1;
                }
                else if(arg5.end < arg6.end) {
                    v0 = 1;
                }
                else if(arg5.end <= arg6.end) {
                    v0 = 0;
                }
            }

            return v0;
        }

        public int compare(Object arg2, Object arg3) {
            return this.compare(((LinkSpec)arg2), ((LinkSpec)arg3));
        }
    }

    class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface LinkifyMask {
    }

    private static final Comparator COMPARATOR;
    private static final String[] EMPTY_STRING;

    static {
        LinkifyCompat.EMPTY_STRING = new String[0];
        LinkifyCompat.COMPARATOR = new android.support.v4.text.util.LinkifyCompat$1();
    }

    private LinkifyCompat() {
        super();
    }

    private static void addLinkMovementMethod(@NonNull TextView arg1) {
        MovementMethod v0 = arg1.getMovementMethod();
        if((v0 == null || !(v0 instanceof LinkMovementMethod)) && (arg1.getLinksClickable())) {
            arg1.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final void addLinks(@NonNull TextView arg6, @NonNull Pattern arg7, @Nullable String arg8) {
        LinkifyCompat.addLinks(arg6, arg7, arg8, null, null, null);
    }

    public static final void addLinks(@NonNull TextView arg6, @NonNull Pattern arg7, @Nullable String arg8, @Nullable String[] arg9, @Nullable Linkify$MatchFilter arg10, @Nullable Linkify$TransformFilter arg11) {
        SpannableString v0 = SpannableString.valueOf(arg6.getText());
        if(LinkifyCompat.addLinks(((Spannable)v0), arg7, arg8, arg9, arg10, arg11)) {
            arg6.setText(((CharSequence)v0));
            LinkifyCompat.addLinkMovementMethod(arg6);
        }
    }

    public static final void addLinks(@NonNull TextView arg6, @NonNull Pattern arg7, @Nullable String arg8, @Nullable Linkify$MatchFilter arg9, @Nullable Linkify$TransformFilter arg10) {
        LinkifyCompat.addLinks(arg6, arg7, arg8, null, arg9, arg10);
    }

    public static final boolean addLinks(@NonNull Spannable arg8, @NonNull Pattern arg9, @Nullable String arg10, @Nullable String[] arg11, @Nullable Linkify$MatchFilter arg12, @Nullable Linkify$TransformFilter arg13) {
        if(arg10 == null) {
            arg10 = "";
        }

        if(arg11 == null || arg11.length < 1) {
            arg11 = LinkifyCompat.EMPTY_STRING;
        }

        String[] v4 = new String[arg11.length + 1];
        v4[0] = arg10.toLowerCase(Locale.ROOT);
        int v0;
        for(v0 = 0; v0 < arg11.length; ++v0) {
            String v2 = arg11[v0];
            int v5 = v0 + 1;
            v2 = v2 == null ? "" : v2.toLowerCase(Locale.ROOT);
            v4[v5] = v2;
        }

        Matcher v5_1 = arg9.matcher(((CharSequence)arg8));
        boolean v0_1;
        for(v0_1 = false; v5_1.find(); v0_1 = true) {
            int v6 = v5_1.start();
            int v7 = v5_1.end();
            boolean v2_1 = arg12 != null ? arg12.acceptMatch(((CharSequence)arg8), v6, v7) : true;
            if(!v2_1) {
                continue;
            }

            LinkifyCompat.applyLink(LinkifyCompat.makeUrl(v5_1.group(0), v4, v5_1, arg13), v6, v7, arg8);
        }

        return v0_1;
    }

    public static final boolean addLinks(@NonNull Spannable arg8, int arg9) {
        boolean v0;
        Linkify$TransformFilter v5 = null;
        if(arg9 == 0) {
            v0 = false;
        }
        else {
            Object[] v0_1 = arg8.getSpans(0, arg8.length(), URLSpan.class);
            int v1;
            for(v1 = v0_1.length - 1; v1 >= 0; --v1) {
                arg8.removeSpan(v0_1[v1]);
            }

            if((arg9 & 4) != 0) {
                Linkify.addLinks(arg8, 4);
            }

            ArrayList v0_2 = new ArrayList();
            if((arg9 & 1) != 0) {
                LinkifyCompat.gatherLinks(v0_2, arg8, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, v5);
            }

            if((arg9 & 2) != 0) {
                LinkifyCompat.gatherLinks(v0_2, arg8, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, ((Linkify$MatchFilter)v5), v5);
            }

            if((arg9 & 8) != 0) {
                LinkifyCompat.gatherMapLinks(v0_2, arg8);
            }

            LinkifyCompat.pruneOverlaps(v0_2, arg8);
            if(v0_2.size() == 0) {
                return false;
            }

            Iterator v1_1 = v0_2.iterator();
            while(v1_1.hasNext()) {
                Object v0_3 = v1_1.next();
                if(((LinkSpec)v0_3).frameworkAddedSpan != null) {
                    continue;
                }

                LinkifyCompat.applyLink(((LinkSpec)v0_3).url, ((LinkSpec)v0_3).start, ((LinkSpec)v0_3).end, arg8);
            }

            v0 = true;
        }

        return v0;
    }

    public static final boolean addLinks(@NonNull Spannable arg6, @NonNull Pattern arg7, @Nullable String arg8) {
        return LinkifyCompat.addLinks(arg6, arg7, arg8, null, null, null);
    }

    public static final boolean addLinks(@NonNull Spannable arg6, @NonNull Pattern arg7, @Nullable String arg8, @Nullable Linkify$MatchFilter arg9, @Nullable Linkify$TransformFilter arg10) {
        return LinkifyCompat.addLinks(arg6, arg7, arg8, null, arg9, arg10);
    }

    public static final boolean addLinks(@NonNull TextView arg4, int arg5) {
        boolean v0;
        if(arg5 == 0) {
            v0 = false;
        }
        else {
            CharSequence v0_1 = arg4.getText();
            if(!(v0_1 instanceof Spannable)) {
                SpannableString v0_2 = SpannableString.valueOf(v0_1);
                if(LinkifyCompat.addLinks(((Spannable)v0_2), arg5)) {
                    LinkifyCompat.addLinkMovementMethod(arg4);
                    arg4.setText(((CharSequence)v0_2));
                    v0 = true;
                }
                else {
                    v0 = false;
                }
            }
            else if(LinkifyCompat.addLinks(((Spannable)v0_1), arg5)) {
                LinkifyCompat.addLinkMovementMethod(arg4);
                v0 = true;
            }
            else {
                v0 = false;
            }
        }

        return v0;
    }

    private static void applyLink(String arg2, int arg3, int arg4, Spannable arg5) {
        arg5.setSpan(new URLSpan(arg2), arg3, arg4, 33);
    }

    private static void gatherLinks(ArrayList arg5, Spannable arg6, Pattern arg7, String[] arg8, Linkify$MatchFilter arg9, Linkify$TransformFilter arg10) {
        Matcher v0 = arg7.matcher(((CharSequence)arg6));
        while(v0.find()) {
            int v1 = v0.start();
            int v2 = v0.end();
            if(arg9 != null && !arg9.acceptMatch(((CharSequence)arg6), v1, v2)) {
                continue;
            }

            LinkSpec v3 = new LinkSpec();
            v3.url = LinkifyCompat.makeUrl(v0.group(0), arg8, v0, arg10);
            v3.start = v1;
            v3.end = v2;
            arg5.add(v3);
        }
    }

    private static final void gatherMapLinks(ArrayList arg6, Spannable arg7) {
        LinkSpec v4;
        String v2;
        String v1 = arg7.toString();
        int v0 = 0;
        try {
            while(true) {
            label_2:
                v2 = WebView.findAddress(v1);
                if(v2 == null) {
                    return;
                }

                int v3 = v1.indexOf(v2);
                if(v3 < 0) {
                    return;
                }

                v4 = new LinkSpec();
                int v5 = v2.length() + v3;
                v4.start = v3 + v0;
                v4.end = v0 + v5;
                v1 = v1.substring(v5);
                v0 += v5;
                try {
                    v2 = URLEncoder.encode(v2, "UTF-8");
                    break;
                }
                catch(UnsupportedEncodingException v2_1) {
                    continue;
                }
            }
        }
        catch(UnsupportedOperationException v0_1) {
            return;
        }

        try {
            v4.url = "geo:0,0?q=" + v2;
            arg6.add(v4);
            goto label_2;
            return;
        }
        catch(UnsupportedOperationException v0_1) {
            return;
        }
    }

    private static String makeUrl(@NonNull String arg10, @NonNull String[] arg11, Matcher arg12, @Nullable Linkify$TransformFilter arg13) {
        int v1 = 1;
        String v0 = arg13 != null ? arg13.transformUrl(arg12, arg10) : arg10;
        int v9 = 0;
        while(true) {
            if(v9 >= arg11.length) {
                break;
            }
            else if(!v0.regionMatches(true, 0, arg11[v9], 0, arg11[v9].length())) {
                ++v9;
                continue;
            }
            else if(!v0.regionMatches(false, 0, arg11[v9], 0, arg11[v9].length())) {
                v0 = arg11[v9] + v0.substring(arg11[v9].length());
            }

            goto label_31;
        }

        v1 = 0;
    label_31:
        if(v1 == 0 && arg11.length > 0) {
            v0 = arg11[0] + v0;
        }

        return v0;
    }

    private static final void pruneOverlaps(ArrayList arg8, Spannable arg9) {
        int v3 = -1;
        int v2 = 0;
        Object[] v0 = arg9.getSpans(0, arg9.length(), URLSpan.class);
        int v1;
        for(v1 = 0; v1 < v0.length; ++v1) {
            LinkSpec v4 = new LinkSpec();
            v4.frameworkAddedSpan = v0[v1];
            v4.start = arg9.getSpanStart(v0[v1]);
            v4.end = arg9.getSpanEnd(v0[v1]);
            arg8.add(v4);
        }

        Collections.sort(((List)arg8), LinkifyCompat.COMPARATOR);
        int v4_1 = arg8.size();
        while(v2 < v4_1 - 1) {
            Object v0_1 = arg8.get(v2);
            Object v1_1 = arg8.get(v2 + 1);
            if(((LinkSpec)v0_1).start <= ((LinkSpec)v1_1).start && ((LinkSpec)v0_1).end > ((LinkSpec)v1_1).start) {
                if(((LinkSpec)v1_1).end <= ((LinkSpec)v0_1).end) {
                    v1 = v2 + 1;
                }
                else if(((LinkSpec)v0_1).end - ((LinkSpec)v0_1).start > ((LinkSpec)v1_1).end - ((LinkSpec)v1_1).start) {
                    v1 = v2 + 1;
                }
                else if(((LinkSpec)v0_1).end - ((LinkSpec)v0_1).start < ((LinkSpec)v1_1).end - ((LinkSpec)v1_1).start) {
                    v1 = v2;
                }
                else {
                    v1 = v3;
                }

                if(v1 == v3) {
                    goto label_69;
                }

                URLSpan v0_2 = arg8.get(v1).frameworkAddedSpan;
                if(v0_2 != null) {
                    arg9.removeSpan(v0_2);
                }

                arg8.remove(v1);
                --v4_1;
                continue;
            }

        label_69:
            ++v2;
        }
    }
}

