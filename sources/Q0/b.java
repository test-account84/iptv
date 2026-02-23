package q0;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public c a;

    public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String a = h.a(remoteUserInfo);
        if (a == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(a)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.a = new h(remoteUserInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public b(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.a = Build.VERSION.SDK_INT >= 28 ? new h(str, i, i2) : new i(str, i, i2);
    }
}
