package Q2;

import android.media.AudioDeviceCallback;
import android.media.AudioManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class j {
    public static /* bridge */ /* synthetic */ void a(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback) {
        audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
    }
}
