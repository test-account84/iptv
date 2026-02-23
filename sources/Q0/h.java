package q0;

import android.media.session.MediaSessionManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h extends i {
    public final MediaSessionManager.RemoteUserInfo d;

    public h(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(e.a(remoteUserInfo), f.a(remoteUserInfo), g.a(remoteUserInfo));
        this.d = remoteUserInfo;
    }

    public static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return e.a(remoteUserInfo);
    }

    public h(String str, int i, int i2) {
        super(str, i, i2);
        this.d = d.a(str, i, i2);
    }
}
