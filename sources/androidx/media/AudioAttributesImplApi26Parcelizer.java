package androidx.media;

import M0.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b bVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.a = bVar.r(audioAttributesImplApi26.a, 1);
        audioAttributesImplApi26.b = bVar.p(audioAttributesImplApi26.b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, b bVar) {
        bVar.x(false, false);
        bVar.H(audioAttributesImplApi26.a, 1);
        bVar.F(audioAttributesImplApi26.b, 2);
    }
}
