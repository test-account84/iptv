package de.blinkt.openvpn.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface n {

    public interface a {
        boolean a();
    }

    public enum b {
        noNetwork,
        userPause,
        screenOff
    }

    boolean a(boolean z);

    void b(b bVar);

    void c(String str);

    void d(boolean z);

    void e(a aVar);

    void resume();
}
