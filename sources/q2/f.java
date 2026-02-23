package Q2;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class f {
    public static /* bridge */ /* synthetic */ AudioDeviceInfo[] a(AudioManager audioManager, int i) {
        return audioManager.getDevices(i);
    }
}
