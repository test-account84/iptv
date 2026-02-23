package o4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 extends S {
    public final /* synthetic */ z a;

    public /* synthetic */ c0(z zVar, b0 b0Var) {
        this.a = zVar;
    }

    public final F4.a zzb(String str) {
        w createSession = this.a.createSession(str);
        if (createSession == null) {
            return null;
        }
        return createSession.o();
    }

    public final String zzc() {
        return this.a.getCategory();
    }

    public final boolean zzd() {
        return this.a.isSessionRecoverable();
    }
}
