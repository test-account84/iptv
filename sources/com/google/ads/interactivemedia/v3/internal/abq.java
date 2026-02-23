package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abq {
    public byte[] M;
    public aaf S;
    public boolean T;
    public aae V;
    public int W;
    private int X;
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public byte[] h;
    public aad i;
    public byte[] j;
    public o k;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = 0;
    public int q = -1;
    public float r = 0.0f;
    public float s = 0.0f;
    public float t = 0.0f;
    public byte[] u = null;
    public int v = -1;
    public boolean w = false;
    public int x = -1;
    public int y = -1;
    public int z = -1;
    public int A = 1000;
    public int B = 200;
    public float C = -1.0f;
    public float D = -1.0f;
    public float E = -1.0f;
    public float F = -1.0f;
    public float G = -1.0f;
    public float H = -1.0f;
    public float I = -1.0f;
    public float J = -1.0f;
    public float K = -1.0f;
    public float L = -1.0f;
    public int N = 1;
    public int O = -1;
    public int P = 8000;
    public long Q = 0;
    public long R = 0;
    public boolean U = true;
    private String Y = "eng";

    public static /* bridge */ /* synthetic */ int a(abq abqVar) {
        return abqVar.X;
    }

    public static /* bridge */ /* synthetic */ void b(abq abqVar, int i) {
        abqVar.X = i;
    }

    public static /* bridge */ /* synthetic */ void c(abq abqVar, String str) {
        abqVar.Y = str;
    }

    public static /* bridge */ /* synthetic */ void d(abq abqVar) {
        af.s(abqVar.V);
    }

    private static Pair f(cj cjVar) throws as {
        try {
            cjVar.G(16);
            long n = cjVar.n();
            if (n == 1482049860) {
                return new Pair("video/divx", (Object) null);
            }
            if (n == 859189832) {
                return new Pair("video/3gpp", (Object) null);
            }
            if (n != 826496599) {
                cd.e("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", (Object) null);
            }
            int c = cjVar.c() + 20;
            byte[] H = cjVar.H();
            while (true) {
                int length = H.length;
                if (c >= length - 4) {
                    throw as.a("Failed to find FourCC VC1 initialization data", null);
                }
                if (H[c] == 0 && H[c + 1] == 0 && H[c + 2] == 1 && H[c + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(H, c, length)));
                }
                c++;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw as.a("Error parsing FourCC private data", null);
        }
    }

    private static List g(byte[] bArr) throws as {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw as.a("Error parsing vorbis codec private", null);
            }
            int i3 = 1;
            int i4 = 0;
            while (true) {
                i = bArr[i3] & 255;
                if (i != 255) {
                    break;
                }
                i4 += 255;
                i3++;
            }
            int i5 = i3 + 1;
            int i6 = i4 + i;
            int i7 = 0;
            while (true) {
                i2 = bArr[i5] & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
                i5++;
            }
            int i8 = i5 + 1;
            int i9 = i7 + i2;
            if (bArr[i8] != 1) {
                throw as.a("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i8, bArr2, 0, i6);
            int i10 = i8 + i6;
            if (bArr[i10] != 3) {
                throw as.a("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw as.a("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw as.a("Error parsing vorbis codec private", null);
        }
    }

    private static boolean h(cj cjVar) throws as {
        try {
            int g = cjVar.g();
            if (g == 1) {
                return true;
            }
            if (g == 65534) {
                cjVar.F(24);
                if (cjVar.o() == abr.h().getMostSignificantBits()) {
                    if (cjVar.o() == abr.h().getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw as.a("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] i(String str) throws as {
        byte[] bArr = this.j;
        if (bArr != null) {
            return bArr;
        }
        throw as.a("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:116:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x051b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(com.google.ads.interactivemedia.v3.internal.zk r19, int r20) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.abq.e(com.google.ads.interactivemedia.v3.internal.zk, int):void");
    }
}
