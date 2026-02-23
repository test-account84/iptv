package com.onesignal;

import android.location.Location;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.onesignal.F1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class D extends O {
    public static FusedLocationProviderClient j;
    public static c k;

    public class a implements OnFailureListener {
    }

    public class b implements OnSuccessListener {
    }

    public static class c extends LocationCallback {
        public FusedLocationProviderClient a;

        public c(FusedLocationProviderClient fusedLocationProviderClient) {
            this.a = fusedLocationProviderClient;
            a();
        }

        public final void a() {
            long j = F1.N0() ? 270000L : 570000L;
            LocationRequest priority = LocationRequest.create().setFastestInterval(j).setInterval(j).setMaxWaitTime((long) (j * 1.5d)).setPriority(102);
            F1.a(F1.v.DEBUG, "HMSLocationController Huawei LocationServices requestLocationUpdates!");
            this.a.requestLocationUpdates(priority, this, O.h().getLooper());
        }
    }

    public static void e() {
        synchronized (O.d) {
            j = null;
        }
    }

    public static void l() {
        synchronized (O.d) {
            try {
                F1.a(F1.v.DEBUG, "HMSLocationController onFocusChange!");
                if (O.k() && j == null) {
                    return;
                }
                FusedLocationProviderClient fusedLocationProviderClient = j;
                if (fusedLocationProviderClient != null) {
                    c cVar = k;
                    if (cVar != null) {
                        fusedLocationProviderClient.removeLocationUpdates(cVar);
                    }
                    k = new c(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void p() {
        q();
    }

    public static void q() {
        synchronized (O.d) {
            if (j == null) {
                try {
                    j = LocationServices.getFusedLocationProviderClient(O.g);
                } catch (Exception e) {
                    F1.a(F1.v.ERROR, "Huawei LocationServices getFusedLocationProviderClient failed! " + e);
                    e();
                    return;
                }
            }
            Location location = O.h;
            if (location != null) {
                O.d(location);
            } else {
                j.getLastLocation().addOnSuccessListener(new b()).addOnFailureListener(new a());
            }
        }
    }
}
