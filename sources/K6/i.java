package k6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i extends A5.m {
    public final a a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public i(String str, a aVar) {
        super(str);
        this.a = aVar;
    }

    public i(a aVar) {
        this.a = aVar;
    }
}
