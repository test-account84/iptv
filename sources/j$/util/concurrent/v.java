package j$.util.concurrent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class v extends ThreadLocal {
    protected final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
