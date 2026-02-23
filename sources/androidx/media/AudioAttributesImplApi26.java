package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImplApi21;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    public static class a extends AudioAttributesImplApi21.a {
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.a.build());
        }
    }

    public AudioAttributesImplApi26() {
    }

    public AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
