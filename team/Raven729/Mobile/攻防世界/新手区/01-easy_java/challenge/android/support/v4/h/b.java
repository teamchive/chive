package android.support.v4.h;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class b {
    class a extends android.support.v4.h.b$b {
        a() {
            super();
        }

        public android.support.v4.h.a.b a(View$AccessibilityDelegate arg3, View arg4) {
            AccessibilityNodeProvider v1 = arg3.getAccessibilityNodeProvider(arg4);
            android.support.v4.h.a.b v0 = v1 != null ? new android.support.v4.h.a.b(v1) : null;
            return v0;
        }

        public View$AccessibilityDelegate a(b arg2) {
            return new View$AccessibilityDelegate(arg2) {
                public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    return this.a.b(arg2, arg3);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View arg2) {
                    Object v0_1;
                    android.support.v4.h.a.b v0 = this.a.a(arg2);
                    if(v0 != null) {
                        v0_1 = v0.a();
                    }
                    else {
                        AccessibilityNodeProvider v0_2 = null;
                    }

                    return ((AccessibilityNodeProvider)v0_1);
                }

                public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.a.d(arg2, arg3);
                }

                public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfo arg4) {
                    this.a.a(arg3, android.support.v4.h.a.a.a(arg4));
                }

                public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.a.c(arg2, arg3);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
                    return this.a.a(arg2, arg3, arg4);
                }

                public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                    return this.a.a(arg2, arg3, arg4);
                }

                public void sendAccessibilityEvent(View arg2, int arg3) {
                    this.a.a(arg2, arg3);
                }

                public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                    this.a.a(arg2, arg3);
                }
            };
        }

        public boolean a(View$AccessibilityDelegate arg2, View arg3, int arg4, Bundle arg5) {
            return arg2.performAccessibilityAction(arg3, arg4, arg5);
        }
    }

    class android.support.v4.h.b$b {
        android.support.v4.h.b$b() {
            super();
        }

        public View$AccessibilityDelegate a(b arg2) {
            return new View$AccessibilityDelegate(arg2) {
                public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    return this.a.b(arg2, arg3);
                }

                public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.a.d(arg2, arg3);
                }

                public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfo arg4) {
                    this.a.a(arg3, android.support.v4.h.a.a.a(arg4));
                }

                public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
                    this.a.c(arg2, arg3);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
                    return this.a.a(arg2, arg3, arg4);
                }

                public void sendAccessibilityEvent(View arg2, int arg3) {
                    this.a.a(arg2, arg3);
                }

                public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
                    this.a.a(arg2, arg3);
                }
            };
        }

        public android.support.v4.h.a.b a(View$AccessibilityDelegate arg2, View arg3) {
            return null;
        }

        public boolean a(View$AccessibilityDelegate arg2, View arg3, int arg4, Bundle arg5) {
            return 0;
        }
    }

    final View$AccessibilityDelegate a;
    private static final android.support.v4.h.b$b b;
    private static final View$AccessibilityDelegate c;

    static {
        b.b = Build$VERSION.SDK_INT >= 16 ? new a() : new android.support.v4.h.b$b();
        b.c = new View$AccessibilityDelegate();
    }

    public b() {
        super();
        this.a = b.b.a(this);
    }

    public android.support.v4.h.a.b a(View arg3) {
        return b.b.a(b.c, arg3);
    }

    View$AccessibilityDelegate a() {
        return this.a;
    }

    public void a(View arg2, int arg3) {
        b.c.sendAccessibilityEvent(arg2, arg3);
    }

    public void a(View arg3, android.support.v4.h.a.a arg4) {
        b.c.onInitializeAccessibilityNodeInfo(arg3, arg4.a());
    }

    public void a(View arg2, AccessibilityEvent arg3) {
        b.c.sendAccessibilityEventUnchecked(arg2, arg3);
    }

    public boolean a(View arg3, int arg4, Bundle arg5) {
        return b.b.a(b.c, arg3, arg4, arg5);
    }

    public boolean a(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
        return b.c.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
    }

    public boolean b(View arg2, AccessibilityEvent arg3) {
        return b.c.dispatchPopulateAccessibilityEvent(arg2, arg3);
    }

    public void c(View arg2, AccessibilityEvent arg3) {
        b.c.onPopulateAccessibilityEvent(arg2, arg3);
    }

    public void d(View arg2, AccessibilityEvent arg3) {
        b.c.onInitializeAccessibilityEvent(arg2, arg3);
    }
}

