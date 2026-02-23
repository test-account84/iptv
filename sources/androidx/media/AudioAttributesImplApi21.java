package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes a;
    public int b;

    public static class a implements AudioAttributesImpl.a {
        public final AudioAttributes.Builder a = new AudioAttributes.Builder();

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(int i) {
            this.a.setLegacyStreamType(i);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.a.build());
        }
    }

    public AudioAttributesImplApi21() {
        this.b = -1;
    }

    public int a() {
        int i = this.b;
        return i != -1 ? i : AudioAttributesCompat.b(false, b(), c());
    }

    public int b() {
        return this.a.getFlags();
    }

    public int c() {
        return this.a.getUsage();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.a.equals(((AudioAttributesImplApi21) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.a = audioAttributes;
        this.b = i;
    }
}
