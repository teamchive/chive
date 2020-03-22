package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable {
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context arg1, Intent[] arg2, int arg3, int arg4, Bundle arg5);
    }

    class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
            super();
        }

        public PendingIntent getPendingIntent(Context arg3, Intent[] arg4, int arg5, int arg6, Bundle arg7) {
            Intent v0 = new Intent(arg4[arg4.length - 1]);
            v0.addFlags(0x10000000);
            return PendingIntent.getActivity(arg3, arg5, v0, arg6);
        }
    }

    class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
            super();
        }

        public PendingIntent getPendingIntent(Context arg4, Intent[] arg5, int arg6, int arg7, Bundle arg8) {
            arg5[0] = new Intent(arg5[0]).addFlags(0x1000C000);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(arg4, arg6, arg5, arg7);
        }
    }

    class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
            super();
        }

        public PendingIntent getPendingIntent(Context arg4, Intent[] arg5, int arg6, int arg7, Bundle arg8) {
            arg5[0] = new Intent(arg5[0]).addFlags(0x1000C000);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(arg4, arg6, arg5, arg7, arg8);
        }
    }

    private static final TaskStackBuilderImpl IMPL = null;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList mIntents;
    private final Context mSourceContext;

    static {
        TaskStackBuilder.IMPL = Build$VERSION.SDK_INT >= 11 ? new TaskStackBuilderImplHoneycomb() : new TaskStackBuilderImplBase();
    }

    private TaskStackBuilder(Context arg2) {
        super();
        this.mIntents = new ArrayList();
        this.mSourceContext = arg2;
    }

    public TaskStackBuilder addNextIntent(Intent arg2) {
        this.mIntents.add(arg2);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent arg2) {
        ComponentName v0 = arg2.getComponent();
        if(v0 == null) {
            v0 = arg2.resolveActivity(this.mSourceContext.getPackageManager());
        }

        if(v0 != null) {
            this.addParentStack(v0);
        }

        this.addNextIntent(arg2);
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName arg4) {
        int v1 = this.mIntents.size();
        try {
            Intent v0_1;
            for(v0_1 = NavUtils.getParentActivityIntent(this.mSourceContext, arg4); v0_1 != null; v0_1 = NavUtils.getParentActivityIntent(this.mSourceContext, v0_1.getComponent())) {
                this.mIntents.add(v1, v0_1);
            }
        }
        catch(PackageManager$NameNotFoundException v0) {
            goto label_14;
        }

        return this;
    label_14:
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(((Throwable)v0));
    }

    public TaskStackBuilder addParentStack(Activity arg3) {
        Intent v0 = null;
        if((arg3 instanceof SupportParentable)) {
            v0 = arg3.getSupportParentActivityIntent();
        }

        Intent v1 = v0 == null ? NavUtils.getParentActivityIntent(arg3) : v0;
        if(v1 != null) {
            ComponentName v0_1 = v1.getComponent();
            if(v0_1 == null) {
                v0_1 = v1.resolveActivity(this.mSourceContext.getPackageManager());
            }

            this.addParentStack(v0_1);
            this.addNextIntent(v1);
        }

        return this;
    }

    public TaskStackBuilder addParentStack(Class arg3) {
        return this.addParentStack(new ComponentName(this.mSourceContext, arg3));
    }

    public static TaskStackBuilder create(Context arg1) {
        return new TaskStackBuilder(arg1);
    }

    public Intent editIntentAt(int arg2) {
        return this.mIntents.get(arg2);
    }

    @Deprecated public static TaskStackBuilder from(Context arg1) {
        return TaskStackBuilder.create(arg1);
    }

    @Deprecated public Intent getIntent(int arg2) {
        return this.editIntentAt(arg2);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        Intent[] v0;
        Intent[] v2 = new Intent[this.mIntents.size()];
        if(v2.length == 0) {
            v0 = v2;
        }
        else {
            v2[0] = new Intent(this.mIntents.get(0)).addFlags(0x1000C000);
            int v1;
            for(v1 = 1; v1 < v2.length; ++v1) {
                v2[v1] = new Intent(this.mIntents.get(v1));
            }

            v0 = v2;
        }

        return v0;
    }

    public PendingIntent getPendingIntent(int arg2, int arg3) {
        return this.getPendingIntent(arg2, arg3, null);
    }

    public PendingIntent getPendingIntent(int arg7, int arg8, Bundle arg9) {
        if(this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }

        Object[] v2 = this.mIntents.toArray(new Intent[this.mIntents.size()]);
        v2[0] = new Intent(v2[0]).addFlags(0x1000C000);
        return TaskStackBuilder.IMPL.getPendingIntent(this.mSourceContext, ((Intent[])v2), arg7, arg8, arg9);
    }

    @Deprecated public Iterator iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        this.startActivities(null);
    }

    public void startActivities(Bundle arg5) {
        if(this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }

        Object[] v0 = this.mIntents.toArray(new Intent[this.mIntents.size()]);
        v0[0] = new Intent(v0[0]).addFlags(0x1000C000);
        if(!ContextCompat.startActivities(this.mSourceContext, ((Intent[])v0), arg5)) {
            Intent v1 = new Intent(v0[v0.length - 1]);
            v1.addFlags(0x10000000);
            this.mSourceContext.startActivity(v1);
        }
    }
}

