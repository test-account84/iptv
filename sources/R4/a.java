package r4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    private p4.i zza;

    public p4.i getRemoteMediaClient() {
        return this.zza;
    }

    public void onSessionConnected(o4.e eVar) {
        this.zza = eVar != null ? eVar.r() : null;
    }

    public void onSessionEnded() {
        this.zza = null;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }
}
