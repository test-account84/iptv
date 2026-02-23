package n4;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import n4.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z0 extends a.a {
    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, GoogleApiClient.b bVar, GoogleApiClient.c cVar) {
        e.c cVar2 = (e.c) obj;
        com.google.android.gms.common.internal.r.n(cVar2, "Setting the API options is required.");
        return new t4.Q(context, looper, eVar, cVar2.b, cVar2.e, cVar2.c, cVar2.d, bVar, cVar);
    }
}
