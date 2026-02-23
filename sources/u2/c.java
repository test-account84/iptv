package U2;

import android.media.MediaCodec;
import com.google.ads.interactivemedia.v3.internal.P;
import com.google.ads.interactivemedia.v3.internal.Q;
import com.google.ads.interactivemedia.v3.internal.S;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public final MediaCodec.CryptoInfo i;
    public final b j;

    public static final class b {
        public final MediaCodec.CryptoInfo a;
        public final MediaCodec.CryptoInfo.Pattern b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = S.a(0, 0);
        }

        public static /* synthetic */ void a(b bVar, int i, int i2) {
            bVar.b(i, i2);
        }

        public final void b(int i, int i2) {
            P.a(this.b, i, i2);
            Q.a(this.a, this.b);
        }

        public /* synthetic */ b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }
    }

    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = k0.a >= 24 ? new b(cryptoInfo, null) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void b(int i) {
        if (i == 0) {
            return;
        }
        if (this.d == null) {
            int[] iArr = new int[1];
            this.d = iArr;
            this.i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.d;
        iArr2[0] = iArr2[0] + i;
    }

    public void c(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (k0.a >= 24) {
            b.a((b) d4.a.e(this.j), i3, i4);
        }
    }
}
