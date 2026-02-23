package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {
    public int a;
    public int b;
    public int c;
    public int d;

    public static class a implements AudioAttributesImpl.a {
        public int a = 0;
        public int b = 0;
        public int c = 0;
        public int d = -1;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final a b(int i) {
            int i2 = 1;
            switch (i) {
                case 0:
                case 10:
                    this.b = i2;
                    break;
                case 1:
                case 2:
                case 4:
                case 5:
                case 8:
                case 9:
                    this.b = 4;
                    break;
                case 3:
                    i2 = 2;
                    this.b = i2;
                    break;
                case 6:
                    this.b = 1;
                    this.c |= 4;
                    break;
                case 7:
                    this.c = 1 | this.c;
                    this.b = 4;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i + " for AudioAttributesCompat");
                    break;
            }
            this.a = AudioAttributesImplBase.e(i);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(int i) {
            if (i == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.d = i;
            return b(i);
        }
    }

    public AudioAttributesImplBase() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1;
    }

    public static int e(int i) {
        switch (i) {
        }
        return 2;
    }

    public int a() {
        int i = this.d;
        return i != -1 ? i : AudioAttributesCompat.b(false, this.c, this.a);
    }

    public int b() {
        return this.b;
    }

    public int c() {
        int i = this.c;
        int a2 = a();
        if (a2 == 6) {
            i |= 4;
        } else if (a2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.b == audioAttributesImplBase.b() && this.c == audioAttributesImplBase.c() && this.a == audioAttributesImplBase.d() && this.d == audioAttributesImplBase.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), Integer.valueOf(this.d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.c(this.a));
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }

    public AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.a = i3;
        this.d = i4;
    }
}
