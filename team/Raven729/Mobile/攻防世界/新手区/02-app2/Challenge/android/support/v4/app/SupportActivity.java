package android.support.v4.app;

import android.app.Activity;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.support.v4.util.SimpleArrayMap;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class SupportActivity extends Activity {
    @RestrictTo(value={Scope.LIBRARY_GROUP}) public class ExtraData {
        public ExtraData() {
            super();
        }
    }

    private SimpleArrayMap mExtraDataMap;

    public SupportActivity() {
        super();
        this.mExtraDataMap = new SimpleArrayMap();
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public ExtraData getExtraData(Class arg2) {
        return this.mExtraDataMap.get(arg2);
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) public void putExtraData(ExtraData arg3) {
        this.mExtraDataMap.put(arg3.getClass(), arg3);
    }
}

