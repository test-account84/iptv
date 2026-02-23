package J4;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzz;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class k {
    public static final com.google.android.gms.common.api.a a;
    public static final e b;
    public static final g c;
    public static final p d;
    public static final a.g e;
    public static final a.a f;

    static {
        a.g gVar = new a.g();
        e = gVar;
        G g = new G();
        f = g;
        a = new com.google.android.gms.common.api.a("LocationServices.API", g, gVar);
        b = new zzz();
        c = new zzaf();
        d = new zzbi();
    }

    public static zzaz a(GoogleApiClient googleApiClient) {
        com.google.android.gms.common.internal.r.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzaz zzazVar = (zzaz) googleApiClient.g(e);
        com.google.android.gms.common.internal.r.q(zzazVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzazVar;
    }
}
