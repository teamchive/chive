package android.support.b.a;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build$VERSION;
import android.support.v4.h.b.a;
import android.support.v4.h.b.b;
import android.support.v4.h.b.c;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d {
    public static Interpolator a(Context arg5, int arg6) {
        Resources$NotFoundException v2;
        Interpolator v0;
        if(Build$VERSION.SDK_INT >= 21) {
            v0 = AnimationUtils.loadInterpolator(arg5, arg6);
        }
        else {
            XmlResourceParser v1 = null;
            if(arg6 == 0x10C000F) {
                try {
                    a v0_4 = new a();
                    if(0 != 0) {
                        goto label_11;
                    }

                    return v0;
                }
                catch(XmlPullParserException v0_1) {
                    goto label_36;
                }
                catch(IOException v0_2) {
                    goto label_52;
                }
                catch(Throwable v0_3) {
                    goto label_48;
                }

            label_11:
                v1.close();
            }
            else if(arg6 == 0x10C000D) {
                try {
                    b v0_5 = new b();
                    if(0 != 0) {
                        goto label_18;
                    }

                    return v0;
                }
                catch(XmlPullParserException v0_1) {
                    goto label_36;
                }
                catch(IOException v0_2) {
                    goto label_52;
                }
                catch(Throwable v0_3) {
                    goto label_48;
                }

            label_18:
                v1.close();
            }
            else if(arg6 == 0x10C000E) {
                try {
                    c v0_6 = new c();
                    if(0 != 0) {
                        goto label_25;
                    }

                    return v0;
                }
                catch(XmlPullParserException v0_1) {
                    goto label_36;
                }
                catch(IOException v0_2) {
                    goto label_52;
                }
                catch(Throwable v0_3) {
                    goto label_48;
                }

            label_25:
                v1.close();
            }
            else {
                try {
                    v1 = arg5.getResources().getAnimation(arg6);
                    v0 = d.a(arg5, arg5.getResources(), arg5.getTheme(), ((XmlPullParser)v1));
                    if(v1 == null) {
                        return v0;
                    }
                }
                catch(Throwable v0_3) {
                }
                catch(IOException v0_2) {
                    try {
                    label_52:
                        v2 = new Resources$NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(arg6));
                        v2.initCause(((Throwable)v0_2));
                        throw v2;
                    }
                    catch(Throwable v0_3) {
                    label_48:
                        if(v1 != null) {
                            v1.close();
                        }

                        throw v0_3;
                    }
                }
                catch(XmlPullParserException v0_1) {
                    try {
                    label_36:
                        v2 = new Resources$NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(arg6));
                        v2.initCause(((Throwable)v0_1));
                        throw v2;
                    }
                    catch(Throwable v0_3) {
                        goto label_48;
                    }
                }

                v1.close();
            }
        }

        return v0;
    }

    private static Interpolator a(Context arg4, Resources arg5, Resources$Theme arg6, XmlPullParser arg7) {
        AccelerateDecelerateInterpolator v0_5;
        Interpolator v0 = null;
        int v1 = arg7.getDepth();
        while(true) {
            int v2 = arg7.next();
            if((v2 != 3 || arg7.getDepth() > v1) && v2 != 1) {
                if(v2 != 2) {
                    continue;
                }

                AttributeSet v2_1 = Xml.asAttributeSet(arg7);
                String v0_1 = arg7.getName();
                if(v0_1.equals("linearInterpolator")) {
                    LinearInterpolator v0_2 = new LinearInterpolator();
                    continue;
                }
                else if(v0_1.equals("accelerateInterpolator")) {
                    AccelerateInterpolator v0_3 = new AccelerateInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("decelerateInterpolator")) {
                    DecelerateInterpolator v0_4 = new DecelerateInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("accelerateDecelerateInterpolator")) {
                    v0_5 = new AccelerateDecelerateInterpolator();
                    continue;
                }
                else if(v0_1.equals("cycleInterpolator")) {
                    CycleInterpolator v0_6 = new CycleInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("anticipateInterpolator")) {
                    AnticipateInterpolator v0_7 = new AnticipateInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("overshootInterpolator")) {
                    OvershootInterpolator v0_8 = new OvershootInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("anticipateOvershootInterpolator")) {
                    AnticipateOvershootInterpolator v0_9 = new AnticipateOvershootInterpolator(arg4, v2_1);
                    continue;
                }
                else if(v0_1.equals("bounceInterpolator")) {
                    BounceInterpolator v0_10 = new BounceInterpolator();
                    continue;
                }
                else if(v0_1.equals("pathInterpolator")) {
                    g v0_11 = new g(arg4, v2_1, arg7);
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_83;
        }

        throw new RuntimeException("Unknown interpolator name: " + arg7.getName());
    label_83:
        return ((Interpolator)v0_5);
    }
}

