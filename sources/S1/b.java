package s1;

import k1.f;
import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {
    public static void a(Response response, k1.a aVar) {
        if (aVar.B() == f.OK_HTTP_RESPONSE || response == null || response.body() == null || response.body().source() == null) {
            return;
        }
        try {
            response.body().source().close();
        } catch (Exception unused) {
        }
    }
}
