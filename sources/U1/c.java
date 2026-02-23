package u1;

import B1.d;
import B1.e;
import okhttp3.Response;
import v1.f;
import v1.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface c extends M1.a {

    public enum b {
        SCHEDULED,
        FETCH_CACHE,
        FETCH_NETWORK,
        COMPLETED
    }

    f operation();

    public static abstract class a {
        public void onCanceledError(B1.a aVar) {
            onFailure(aVar);
        }

        public abstract void onFailure(B1.b bVar);

        public void onHttpError(B1.c cVar) {
            onFailure(cVar);
            Response b = cVar.b();
            if (b != null) {
                b.close();
            }
        }

        public void onNetworkError(d dVar) {
            onFailure(dVar);
        }

        public void onParseError(e eVar) {
            onFailure(eVar);
        }

        public abstract void onResponse(i iVar);

        public void onStatusEvent(b bVar) {
        }
    }
}
