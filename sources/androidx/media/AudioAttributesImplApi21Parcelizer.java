package androidx.media;

import M0.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b bVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = bVar.r(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = bVar.p(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, b bVar) {
        bVar.x(false, false);
        bVar.H(audioAttributesImplApi21.a, 1);
        bVar.F(audioAttributesImplApi21.b, 2);
    }
}
