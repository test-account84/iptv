package q8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class j extends a {
    public j(o8.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != o8.h.a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    public o8.g getContext() {
        return o8.h.a;
    }
}
