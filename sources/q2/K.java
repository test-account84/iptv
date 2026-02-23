package Q2;

import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class k {
    public static /* bridge */ /* synthetic */ void a(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback, Handler handler) {
        audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
    }
}
