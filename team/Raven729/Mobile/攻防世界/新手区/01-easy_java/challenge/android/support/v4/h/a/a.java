package android.support.v4.h.a;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityNodeInfo;

public class a {
    class android.support.v4.h.a.a$a extends i {
        android.support.v4.h.a.a$a() {
            super();
        }
    }

    class b extends android.support.v4.h.a.a$a {
        b() {
            super();
        }
    }

    class c extends b {
        c() {
            super();
        }

        public String a(AccessibilityNodeInfo arg2) {
            return arg2.getViewIdResourceName();
        }
    }

    class d extends c {
        d() {
            super();
        }
    }

    class e extends d {
        e() {
            super();
        }
    }

    class f extends e {
        f() {
            super();
        }
    }

    class g extends f {
        g() {
            super();
        }
    }

    class h extends g {
        h() {
            super();
        }
    }

    class i {
        i() {
            super();
        }

        public String a(AccessibilityNodeInfo arg2) {
            return null;
        }
    }

    static final i a;
    public int b;
    private final AccessibilityNodeInfo c;

    static {
        if(Build$VERSION.SDK_INT >= 24) {
            a.a = new h();
        }
        else if(Build$VERSION.SDK_INT >= 23) {
            a.a = new g();
        }
        else if(Build$VERSION.SDK_INT >= 22) {
            a.a = new f();
        }
        else if(Build$VERSION.SDK_INT >= 21) {
            a.a = new e();
        }
        else if(Build$VERSION.SDK_INT >= 19) {
            a.a = new d();
        }
        else if(Build$VERSION.SDK_INT >= 18) {
            a.a = new c();
        }
        else if(Build$VERSION.SDK_INT >= 17) {
            a.a = new b();
        }
        else if(Build$VERSION.SDK_INT >= 16) {
            a.a = new android.support.v4.h.a.a$a();
        }
        else {
            a.a = new i();
        }
    }

    private a(AccessibilityNodeInfo arg2) {
        super();
        this.b = -1;
        this.c = arg2;
    }

    public static a a(AccessibilityNodeInfo arg1) {
        return new a(arg1);
    }

    public AccessibilityNodeInfo a() {
        return this.c;
    }

    public void a(int arg2) {
        this.c.addAction(arg2);
    }

    public void a(Rect arg2) {
        this.c.getBoundsInParent(arg2);
    }

    public void a(CharSequence arg2) {
        this.c.setClassName(arg2);
    }

    public void a(boolean arg2) {
        this.c.setScrollable(arg2);
    }

    private static String b(int arg1) {
        String v0;
        switch(arg1) {
            case 1: {
                v0 = "ACTION_FOCUS";
                break;
            }
            case 2: {
                v0 = "ACTION_CLEAR_FOCUS";
                break;
            }
            case 4: {
                v0 = "ACTION_SELECT";
                break;
            }
            case 8: {
                v0 = "ACTION_CLEAR_SELECTION";
                break;
            }
            case 16: {
                v0 = "ACTION_CLICK";
                break;
            }
            case 32: {
                v0 = "ACTION_LONG_CLICK";
                break;
            }
            case 64: {
                v0 = "ACTION_ACCESSIBILITY_FOCUS";
                break;
            }
            case 128: {
                v0 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                break;
            }
            case 256: {
                v0 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                break;
            }
            case 512: {
                v0 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                break;
            }
            case 1024: {
                v0 = "ACTION_NEXT_HTML_ELEMENT";
                break;
            }
            case 2048: {
                v0 = "ACTION_PREVIOUS_HTML_ELEMENT";
                break;
            }
            case 4096: {
                v0 = "ACTION_SCROLL_FORWARD";
                break;
            }
            case 8192: {
                v0 = "ACTION_SCROLL_BACKWARD";
                break;
            }
            case 16384: {
                v0 = "ACTION_COPY";
                break;
            }
            case 32768: {
                v0 = "ACTION_PASTE";
                break;
            }
            case 65536: {
                v0 = "ACTION_CUT";
                break;
            }
            case 131072: {
                v0 = "ACTION_SET_SELECTION";
                break;
            }
            default: {
                v0 = "ACTION_UNKNOWN";
                break;
            }
        }

        return v0;
    }

    public int b() {
        return this.c.getActions();
    }

    public void b(Rect arg2) {
        this.c.getBoundsInScreen(arg2);
    }

    public boolean c() {
        return this.c.isCheckable();
    }

    public boolean d() {
        return this.c.isChecked();
    }

    public boolean e() {
        return this.c.isFocusable();
    }

    public boolean equals(Object arg5) {
        boolean v0 = true;
        if(this != (((a)arg5))) {
            if(arg5 == null) {
                v0 = false;
            }
            else if(this.getClass() != arg5.getClass()) {
                v0 = false;
            }
            else if(this.c == null) {
                if(((a)arg5).c != null) {
                    v0 = false;
                }
            }
            else if(!this.c.equals(((a)arg5).c)) {
                v0 = false;
            }
        }

        return v0;
    }

    public boolean f() {
        return this.c.isFocused();
    }

    public boolean g() {
        return this.c.isSelected();
    }

    public boolean h() {
        return this.c.isClickable();
    }

    public int hashCode() {
        int v0 = this.c == null ? 0 : this.c.hashCode();
        return v0;
    }

    public boolean i() {
        return this.c.isLongClickable();
    }

    public boolean j() {
        return this.c.isEnabled();
    }

    public boolean k() {
        return this.c.isPassword();
    }

    public boolean l() {
        return this.c.isScrollable();
    }

    public CharSequence m() {
        return this.c.getPackageName();
    }

    public CharSequence n() {
        return this.c.getClassName();
    }

    public CharSequence o() {
        return this.c.getText();
    }

    public CharSequence p() {
        return this.c.getContentDescription();
    }

    public String q() {
        return a.a.a(this.c);
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder();
        v1.append(super.toString());
        Rect v0 = new Rect();
        this.a(v0);
        v1.append("; boundsInParent: " + v0);
        this.b(v0);
        v1.append("; boundsInScreen: " + v0);
        v1.append("; packageName: ").append(this.m());
        v1.append("; className: ").append(this.n());
        v1.append("; text: ").append(this.o());
        v1.append("; contentDescription: ").append(this.p());
        v1.append("; viewId: ").append(this.q());
        v1.append("; checkable: ").append(this.c());
        v1.append("; checked: ").append(this.d());
        v1.append("; focusable: ").append(this.e());
        v1.append("; focused: ").append(this.f());
        v1.append("; selected: ").append(this.g());
        v1.append("; clickable: ").append(this.h());
        v1.append("; longClickable: ").append(this.i());
        v1.append("; enabled: ").append(this.j());
        v1.append("; password: ").append(this.k());
        v1.append("; scrollable: " + this.l());
        v1.append("; [");
        int v0_1 = this.b();
        while(v0_1 != 0) {
            int v2 = 1 << Integer.numberOfTrailingZeros(v0_1);
            v0_1 &= v2 ^ -1;
            v1.append(a.b(v2));
            if(v0_1 == 0) {
                continue;
            }

            v1.append(", ");
        }

        v1.append("]");
        return v1.toString();
    }
}

