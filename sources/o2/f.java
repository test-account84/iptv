package O2;

import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class f {
    public static /* bridge */ /* synthetic */ AudioFocusRequest.Builder a(AudioFocusRequest.Builder builder, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        return builder.setOnAudioFocusChangeListener(onAudioFocusChangeListener);
    }
}
