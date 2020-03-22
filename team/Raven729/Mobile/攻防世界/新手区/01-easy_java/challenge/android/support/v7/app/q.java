package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.b.c;
import android.util.Log;
import java.util.Calendar;

class q {
    class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
            super();
        }
    }

    private static q a;
    private final Context b;
    private final LocationManager c;
    private final a d;

    q(Context arg2, LocationManager arg3) {
        super();
        this.d = new a();
        this.b = arg2;
        this.c = arg3;
    }

    static q a(Context arg3) {
        if(q.a == null) {
            Context v1 = arg3.getApplicationContext();
            q.a = new q(v1, v1.getSystemService("location"));
        }

        return q.a;
    }

    boolean a() {
        boolean v0_1;
        a v0 = this.d;
        if(this.c()) {
            v0_1 = v0.a;
        }
        else {
            Location v1 = this.b();
            if(v1 != null) {
                this.a(v1);
                v0_1 = v0.a;
            }
            else {
                Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                int v0_2 = Calendar.getInstance().get(11);
                if(v0_2 >= 6 && v0_2 < 22) {
                    return false;
                }

                v0_1 = true;
            }
        }

        return v0_1;
    }

    private Location a(String arg4) {
        if(this.c != null) {
            try {
                if(!this.c.isProviderEnabled(arg4)) {
                    return null;
                }

                Location v0_1 = this.c.getLastKnownLocation(arg4);
                return v0_1;
            }
            catch(Exception v0) {
                Log.d("TwilightManager", "Failed to get last known location", ((Throwable)v0));
            }
        }

        return null;
    }

    private void a(Location arg21) {
        a v10 = this.d;
        long v12 = System.currentTimeMillis();
        p v3 = p.a();
        v3.a(v12 - 86400000, arg21.getLatitude(), arg21.getLongitude());
        long v14 = v3.a;
        v3.a(v12, arg21.getLatitude(), arg21.getLongitude());
        boolean v2 = v3.c == 1 ? true : false;
        long v16 = v3.b;
        long v18 = v3.a;
        v3.a(86400000 + v12, arg21.getLatitude(), arg21.getLongitude());
        long v6 = v3.b;
        long v4 = 0;
        if(v16 == -1 || v18 == -1) {
            v4 = 43200000 + v12;
        }
        else {
            if(v12 > v18) {
                v4 += v6;
            }
            else if(v12 > v16) {
                v4 += v18;
            }
            else {
                v4 += v16;
            }

            v4 += 60000;
        }

        v10.a = v2;
        v10.b = v14;
        v10.c = v16;
        v10.d = v18;
        v10.e = v6;
        v10.f = v4;
    }

    private Location b() {
        Location v1 = null;
        Location v0 = c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? this.a("network") : v1;
        if(c.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            v1 = this.a("gps");
        }

        if(v1 == null || v0 == null) {
            if(v1 == null) {
                v1 = v0;
            }

            v0 = v1;
        }
        else if(v1.getTime() > v0.getTime()) {
            v0 = v1;
        }

        return v0;
    }

    private boolean c() {
        boolean v0 = this.d == null || this.d.f <= System.currentTimeMillis() ? false : true;
        return v0;
    }
}

