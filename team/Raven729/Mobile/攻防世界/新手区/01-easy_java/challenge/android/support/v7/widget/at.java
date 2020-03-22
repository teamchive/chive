package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class at extends ContextWrapper {
    private static final Object a;
    private static ArrayList b;
    private final Resources c;
    private final Resources$Theme d;

    static {
        at.a = new Object();
    }

    private at(Context arg3) {
        super(arg3);
        if(bb.a()) {
            this.c = new bb(((Context)this), arg3.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(arg3.getTheme());
        }
        else {
            this.c = new av(((Context)this), arg3.getResources());
            this.d = null;
        }
    }

    public static Context a(Context arg4) {
        Object v0_1;
        if(at.b(arg4)) {
            Object v2 = at.a;
            __monitor_enter(v2);
            try {
                if(at.b == null) {
                    at.b = new ArrayList();
                }
                else {
                    int v1;
                    for(v1 = at.b.size() - 1; v1 >= 0; --v1) {
                        v0_1 = at.b.get(v1);
                        if(v0_1 == null || ((WeakReference)v0_1).get() == null) {
                            at.b.remove(v1);
                        }
                    }

                    for(v1 = at.b.size() - 1; v1 >= 0; --v1) {
                        v0_1 = at.b.get(v1);
                        v0_1 = v0_1 != null ? ((WeakReference)v0_1).get() : null;
                        if(v0_1 != null && ((at)v0_1).getBaseContext() == arg4) {
                            __monitor_exit(v2);
                            Object v4 = v0_1;
                            goto label_17;
                        }
                    }
                }

                at v0_2 = new at(arg4);
                at.b.add(new WeakReference(v0_2));
                __monitor_exit(v2);
                at v4_1 = v0_2;
            label_17:
                return ((Context)v4_1);
            label_54:
                __monitor_exit(v2);
                goto label_55;
            }
            catch(Throwable v0) {
                goto label_54;
            }
        }

        goto label_17;
    label_55:
        throw v0;
    }

    private static boolean b(Context arg3) {
        boolean v0 = false;
        if(!(arg3 instanceof at) && !(arg3.getResources() instanceof av) && !(arg3.getResources() instanceof bb) && (Build$VERSION.SDK_INT < 21 || (bb.a()))) {
            v0 = true;
        }

        return v0;
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Resources$Theme getTheme() {
        Resources$Theme v0 = this.d == null ? super.getTheme() : this.d;
        return v0;
    }

    public void setTheme(int arg3) {
        if(this.d == null) {
            super.setTheme(arg3);
        }
        else {
            this.d.applyStyle(arg3, true);
        }
    }
}

