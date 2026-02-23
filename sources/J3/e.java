package j3;

import O2.l1;
import V2.m;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.o;
import d3.t;
import d3.w;
import d3.x;
import d4.B;
import d4.C;
import d4.G;
import d4.M;
import d4.k0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e implements i {
    public static final o c0 = new d();
    public static final byte[] d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] e0 = k0.s0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final byte[] g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    public static final UUID h0 = new UUID(72057594037932032L, -9223371306706625679L);
    public static final Map i0;
    public long A;
    public long B;
    public C C;
    public C D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public byte Z;
    public final j3.c a;
    public boolean a0;
    public final g b;
    public k b0;
    public final SparseArray c;
    public final boolean d;
    public final M e;
    public final M f;
    public final M g;
    public final M h;
    public final M i;
    public final M j;
    public final M k;
    public final M l;
    public final M m;
    public final M n;
    public ByteBuffer o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public c u;
    public boolean v;
    public int w;
    public long x;
    public boolean y;
    public long z;

    public final class b implements j3.b {
        public b() {
        }

        public void a(int i) {
            e.this.o(i);
        }

        public void b(int i, int i2, j jVar) {
            e.this.l(i, i2, jVar);
        }

        public void c(int i, double d) {
            e.this.r(i, d);
        }

        public void d(int i, long j) {
            e.this.x(i, j);
        }

        public int e(int i) {
            return e.this.u(i);
        }

        public boolean f(int i) {
            return e.this.z(i);
        }

        public void g(int i, String str) {
            e.this.H(i, str);
        }

        public void h(int i, long j, long j2) {
            e.this.G(i, j, j2);
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    public static final class c {
        public byte[] N;
        public x T;
        public boolean U;
        public w X;
        public int Y;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public w.a j;
        public byte[] k;
        public m l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        public String W = "eng";

        public static /* synthetic */ void a(c cVar) {
            cVar.f();
        }

        public static /* synthetic */ int b(c cVar) {
            return cVar.g;
        }

        public static /* synthetic */ int c(c cVar, int i) {
            cVar.g = i;
            return i;
        }

        public static /* synthetic */ String d(c cVar, String str) {
            cVar.W = str;
            return str;
        }

        public static /* synthetic */ boolean e(c cVar, boolean z) {
            return cVar.o(z);
        }

        public static Pair k(M m) {
            try {
                m.V(16);
                long x = m.x();
                if (x == 1482049860) {
                    return new Pair("video/divx", (Object) null);
                }
                if (x == 859189832) {
                    return new Pair("video/3gpp", (Object) null);
                }
                if (x != 826496599) {
                    B.j("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", (Object) null);
                }
                byte[] e = m.e();
                for (int f = m.f() + 20; f < e.length - 4; f++) {
                    if (e[f] == 0 && e[f + 1] == 0 && e[f + 2] == 1 && e[f + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(e, f, e.length)));
                    }
                }
                throw l1.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw l1.a("Error parsing FourCC private data", null);
            }
        }

        public static boolean l(M m) {
            try {
                int z = m.z();
                if (z == 1) {
                    return true;
                }
                if (z != 65534) {
                    return false;
                }
                m.U(24);
                if (m.A() == e.g().getMostSignificantBits()) {
                    if (m.A() == e.g().getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw l1.a("Error parsing MS/ACM codec private", null);
            }
        }

        public static List m(byte[] bArr) {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw l1.a("Error parsing vorbis codec private", null);
                }
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw l1.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw l1.a("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw l1.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw l1.a("Error parsing vorbis codec private", null);
            }
        }

        public final void f() {
            d4.a.e(this.X);
        }

        public final byte[] g(String str) {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            throw l1.a("Missing CodecPrivate for codec " + str, null);
        }

        public final byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:11:0x03fb  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0414  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0423  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0541  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0435  */
        /* JADX WARN: Removed duplicated region for block: B:3:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0416  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i(d3.k r20, int r21) {
            /*
                Method dump skipped, instructions count: 1622
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j3.e.c.i(d3.k, int):void");
        }

        public void j() {
            x xVar = this.T;
            if (xVar != null) {
                xVar.a(this.X, this.j);
            }
        }

        public void n() {
            x xVar = this.T;
            if (xVar != null) {
                xVar.b();
            }
        }

        public final boolean o(boolean z) {
            return "A_OPUS".equals(this.b) ? z : this.f > 0;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        i0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    private static /* synthetic */ i[] A() {
        return new i[]{new e()};
    }

    public static void F(String str, long j, byte[] bArr) {
        byte[] s;
        int i;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                s = s(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                s = s(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                s = s(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(s, 0, bArr, i, s.length);
    }

    public static /* synthetic */ i[] c() {
        return A();
    }

    public static /* synthetic */ byte[] e() {
        return e0;
    }

    public static /* synthetic */ Map f() {
        return i0;
    }

    public static /* synthetic */ UUID g() {
        return h0;
    }

    private void k() {
        d4.a.i(this.b0);
    }

    public static int[] p(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] s(long j, String str, long j2) {
        d4.a.a(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return k0.s0(String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))}));
    }

    public static boolean y(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    public final boolean B(t tVar, long j) {
        if (this.y) {
            this.A = j;
            tVar.a = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            long j2 = this.A;
            if (j2 != -1) {
                tVar.a = j2;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    public final void C(j jVar, int i) {
        if (this.g.g() >= i) {
            return;
        }
        if (this.g.b() < i) {
            M m = this.g;
            m.c(Math.max(m.b() * 2, i));
        }
        jVar.m(this.g.e(), this.g.g(), i - this.g.g());
        this.g.T(i);
    }

    public final void D() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.a0 = false;
        this.j.Q(0);
    }

    public final long E(long j) {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return k0.c1(j, j2, 1000L);
        }
        throw l1.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    public void G(int i, long j, long j2) {
        k();
        if (i == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i == 174) {
            this.u = new c();
            return;
        }
        if (i == 187) {
            this.E = false;
            return;
        }
        if (i == 19899) {
            this.w = -1;
            this.x = -1L;
            return;
        }
        if (i == 20533) {
            t(i).h = true;
            return;
        }
        if (i == 21968) {
            t(i).x = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.q;
            if (j3 != -1 && j3 != j) {
                throw l1.a("Multiple Segment elements not supported", null);
            }
            this.q = j;
            this.p = j2;
            return;
        }
        if (i == 475249515) {
            this.C = new C();
            this.D = new C();
        } else if (i == 524531317 && !this.v) {
            if (this.d && this.z != -1) {
                this.y = true;
            } else {
                this.b0.n(new g.b(this.t));
                this.v = true;
            }
        }
    }

    public void H(int i, String str) {
        if (i == 134) {
            t(i).b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                t(i).a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                c.d(t(i), str);
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw l1.a("DocType " + str + " not supported", null);
    }

    public final int I(j jVar, c cVar, int i, boolean z) {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.b)) {
            J(jVar, d0, i);
        } else if ("S_TEXT/ASS".equals(cVar.b)) {
            J(jVar, f0, i);
        } else {
            if (!"S_TEXT/WEBVTT".equals(cVar.b)) {
                w wVar = cVar.X;
                if (!this.V) {
                    if (cVar.h) {
                        this.O &= -1073741825;
                        if (!this.W) {
                            jVar.m(this.g.e(), 0, 1);
                            this.S++;
                            if ((this.g.e()[0] & 128) == 128) {
                                throw l1.a("Extension bit is set in signal byte", null);
                            }
                            this.Z = this.g.e()[0];
                            this.W = true;
                        }
                        byte b2 = this.Z;
                        if ((b2 & 1) == 1) {
                            boolean z2 = (b2 & 2) == 2;
                            this.O |= 1073741824;
                            if (!this.a0) {
                                jVar.m(this.l.e(), 0, 8);
                                this.S += 8;
                                this.a0 = true;
                                this.g.e()[0] = (byte) ((z2 ? 128 : 0) | 8);
                                this.g.U(0);
                                wVar.c(this.g, 1, 1);
                                this.T++;
                                this.l.U(0);
                                wVar.c(this.l, 8, 1);
                                this.T += 8;
                            }
                            if (z2) {
                                if (!this.X) {
                                    jVar.m(this.g.e(), 0, 1);
                                    this.S++;
                                    this.g.U(0);
                                    this.Y = this.g.H();
                                    this.X = true;
                                }
                                int i3 = this.Y * 4;
                                this.g.Q(i3);
                                jVar.m(this.g.e(), 0, i3);
                                this.S += i3;
                                short s = (short) ((this.Y / 2) + 1);
                                int i4 = (s * 6) + 2;
                                ByteBuffer byteBuffer = this.o;
                                if (byteBuffer == null || byteBuffer.capacity() < i4) {
                                    this.o = ByteBuffer.allocate(i4);
                                }
                                this.o.position(0);
                                this.o.putShort(s);
                                int i5 = 0;
                                int i6 = 0;
                                while (true) {
                                    i2 = this.Y;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    int L = this.g.L();
                                    if (i5 % 2 == 0) {
                                        this.o.putShort((short) (L - i6));
                                    } else {
                                        this.o.putInt(L - i6);
                                    }
                                    i5++;
                                    i6 = L;
                                }
                                int i7 = (i - this.S) - i6;
                                int i8 = i2 % 2;
                                ByteBuffer byteBuffer2 = this.o;
                                if (i8 == 1) {
                                    byteBuffer2.putInt(i7);
                                } else {
                                    byteBuffer2.putShort((short) i7);
                                    this.o.putInt(0);
                                }
                                this.m.S(this.o.array(), i4);
                                wVar.c(this.m, i4, 1);
                                this.T += i4;
                            }
                        }
                    } else {
                        byte[] bArr = cVar.i;
                        if (bArr != null) {
                            this.j.S(bArr, bArr.length);
                        }
                    }
                    if (c.e(cVar, z)) {
                        this.O |= 268435456;
                        this.n.Q(0);
                        int g = (this.j.g() + i) - this.S;
                        this.g.Q(4);
                        this.g.e()[0] = (byte) ((g >> 24) & 255);
                        this.g.e()[1] = (byte) ((g >> 16) & 255);
                        this.g.e()[2] = (byte) ((g >> 8) & 255);
                        this.g.e()[3] = (byte) (g & 255);
                        wVar.c(this.g, 4, 2);
                        this.T += 4;
                    }
                    this.V = true;
                }
                int g2 = i + this.j.g();
                if (!"V_MPEG4/ISO/AVC".equals(cVar.b) && !"V_MPEGH/ISO/HEVC".equals(cVar.b)) {
                    if (cVar.T != null) {
                        d4.a.g(this.j.g() == 0);
                        cVar.T.d(jVar);
                    }
                    while (true) {
                        int i9 = this.S;
                        if (i9 >= g2) {
                            break;
                        }
                        int K = K(jVar, wVar, g2 - i9);
                        this.S += K;
                        this.T += K;
                    }
                } else {
                    byte[] e = this.f.e();
                    e[0] = 0;
                    e[1] = 0;
                    e[2] = 0;
                    int i10 = cVar.Y;
                    int i11 = 4 - i10;
                    while (this.S < g2) {
                        int i12 = this.U;
                        if (i12 == 0) {
                            L(jVar, e, i11, i10);
                            this.S += i10;
                            this.f.U(0);
                            this.U = this.f.L();
                            this.e.U(0);
                            wVar.b(this.e, 4);
                            this.T += 4;
                        } else {
                            int K2 = K(jVar, wVar, i12);
                            this.S += K2;
                            this.T += K2;
                            this.U -= K2;
                        }
                    }
                }
                if ("A_VORBIS".equals(cVar.b)) {
                    this.h.U(0);
                    wVar.b(this.h, 4);
                    this.T += 4;
                }
                return q();
            }
            J(jVar, g0, i);
        }
        return q();
    }

    public final void J(j jVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.k.b() < length) {
            this.k.R(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.k.e(), 0, bArr.length);
        }
        jVar.m(this.k.e(), bArr.length, i);
        this.k.U(0);
        this.k.T(length);
    }

    public final int K(j jVar, w wVar, int i) {
        int a2 = this.j.a();
        if (a2 <= 0) {
            return wVar.a(jVar, i, false);
        }
        int min = Math.min(i, a2);
        wVar.b(this.j, min);
        return min;
    }

    public final void L(j jVar, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.j.a());
        jVar.m(bArr, i + min, i2 - min);
        if (min > 0) {
            this.j.l(bArr, i, min);
        }
    }

    public void a(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.a.reset();
        this.b.e();
        D();
        for (int i = 0; i < this.c.size(); i++) {
            ((c) this.c.valueAt(i)).n();
        }
    }

    public final void b(k kVar) {
        this.b0 = kVar;
    }

    public final int d(j jVar, t tVar) {
        this.F = false;
        boolean z = true;
        while (z && !this.F) {
            z = this.a.a(jVar);
            if (z && B(tVar, jVar.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            c cVar = (c) this.c.valueAt(i);
            c.a(cVar);
            cVar.j();
        }
        return -1;
    }

    public final boolean h(j jVar) {
        return new f().b(jVar);
    }

    public final void i(int i) {
        if (this.C == null || this.D == null) {
            throw l1.a("Element " + i + " must be in a Cues", null);
        }
    }

    public final void j(int i) {
        if (this.u != null) {
            return;
        }
        throw l1.a("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0231, code lost:
    
        throw O2.l1.a("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(int r22, int r23, d3.j r24) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.e.l(int, int, d3.j):void");
    }

    public final com.google.android.exoplayer2.extractor.g m(C c2, C c3) {
        int i;
        if (this.q == -1 || this.t == -9223372036854775807L || c2 == null || c2.c() == 0 || c3 == null || c3.c() != c2.c()) {
            return new g.b(this.t);
        }
        int c4 = c2.c();
        int[] iArr = new int[c4];
        long[] jArr = new long[c4];
        long[] jArr2 = new long[c4];
        long[] jArr3 = new long[c4];
        int i2 = 0;
        for (int i3 = 0; i3 < c4; i3++) {
            jArr3[i3] = c2.b(i3);
            jArr[i3] = this.q + c3.b(i3);
        }
        while (true) {
            i = c4 - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArr[i2] = (int) (jArr[i4] - jArr[i2]);
            jArr2[i2] = jArr3[i4] - jArr3[i2];
            i2 = i4;
        }
        iArr[i] = (int) ((this.q + this.p) - jArr[i]);
        long j = this.t - jArr3[i];
        jArr2[i] = j;
        if (j <= 0) {
            B.j("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArr = Arrays.copyOf(iArr, i);
            jArr = Arrays.copyOf(jArr, i);
            jArr2 = Arrays.copyOf(jArr2, i);
            jArr3 = Arrays.copyOf(jArr3, i);
        }
        return new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3);
    }

    public final void n(c cVar, long j, int i, int i2, int i3) {
        String str;
        x xVar = cVar.T;
        if (xVar != null) {
            xVar.c(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.b) || "S_TEXT/ASS".equals(cVar.b) || "S_TEXT/WEBVTT".equals(cVar.b)) {
                if (this.K > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        str = "Skipping subtitle sample with no duration.";
                    } else {
                        F(cVar.b, j2, this.k.e());
                        int f = this.k.f();
                        while (true) {
                            if (f >= this.k.g()) {
                                break;
                            }
                            if (this.k.e()[f] == 0) {
                                this.k.T(f);
                                break;
                            }
                            f++;
                        }
                        w wVar = cVar.X;
                        M m = this.k;
                        wVar.b(m, m.g());
                        i2 += this.k.g();
                    }
                }
                B.j("MatroskaExtractor", str);
            }
            if ((268435456 & i) != 0) {
                if (this.K > 1) {
                    this.n.Q(0);
                } else {
                    int g = this.n.g();
                    cVar.X.c(this.n, g, 2);
                    i2 += g;
                }
            }
            cVar.X.f(j, i, i2, i3, cVar.j);
        }
        this.F = true;
    }

    public void o(int i) {
        k();
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = (c) this.c.get(this.M);
            c.a(cVar);
            if (this.R > 0 && "A_OPUS".equals(cVar.b)) {
                this.n.R(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.K; i3++) {
                i2 += this.L[i3];
            }
            int i4 = 0;
            while (i4 < this.K) {
                long j = this.H + ((cVar.e * i4) / 1000);
                int i5 = this.O;
                if (i4 == 0 && !this.Q) {
                    i5 |= 1;
                }
                int i6 = this.L[i4];
                int i7 = i2 - i6;
                n(cVar, j, i5, i6, i7);
                i4++;
                i2 = i7;
            }
            this.G = 0;
            return;
        }
        if (i == 174) {
            c cVar2 = (c) d4.a.i(this.u);
            String str = cVar2.b;
            if (str == null) {
                throw l1.a("CodecId is missing in TrackEntry element", null);
            }
            if (y(str)) {
                cVar2.i(this.b0, cVar2.c);
                this.c.put(cVar2.c, cVar2);
            }
            this.u = null;
            return;
        }
        if (i == 19899) {
            int i8 = this.w;
            if (i8 != -1) {
                long j2 = this.x;
                if (j2 != -1) {
                    if (i8 == 475249515) {
                        this.z = j2;
                        return;
                    }
                    return;
                }
            }
            throw l1.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            j(i);
            c cVar3 = this.u;
            if (cVar3.h) {
                if (cVar3.j == null) {
                    throw l1.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.l = new m(new m.b(O2.o.a, "video/webm", this.u.j.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            j(i);
            c cVar4 = this.u;
            if (cVar4.h && cVar4.i != null) {
                throw l1.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.r == -9223372036854775807L) {
                this.r = 1000000L;
            }
            long j3 = this.s;
            if (j3 != -9223372036854775807L) {
                this.t = E(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.c.size() == 0) {
                throw l1.a("No valid tracks were found", null);
            }
            this.b0.q();
        } else {
            if (i != 475249515) {
                return;
            }
            if (!this.v) {
                this.b0.n(m(this.C, this.D));
                this.v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    public final int q() {
        int i = this.T;
        D();
        return i;
    }

    public void r(int i, double d) {
        if (i == 181) {
            t(i).Q = (int) d;
        }
        if (i == 17545) {
            this.s = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                t(i).D = (float) d;
                break;
            case 21970:
                t(i).E = (float) d;
                break;
            case 21971:
                t(i).F = (float) d;
                break;
            case 21972:
                t(i).G = (float) d;
                break;
            case 21973:
                t(i).H = (float) d;
                break;
            case 21974:
                t(i).I = (float) d;
                break;
            case 21975:
                t(i).J = (float) d;
                break;
            case 21976:
                t(i).K = (float) d;
                break;
            case 21977:
                t(i).L = (float) d;
                break;
            case 21978:
                t(i).M = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        t(i).s = (float) d;
                        break;
                    case 30324:
                        t(i).t = (float) d;
                        break;
                    case 30325:
                        t(i).u = (float) d;
                        break;
                }
        }
    }

    public c t(int i) {
        j(i);
        return this.u;
    }

    public int u(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public void v(c cVar, j jVar, int i) {
        if (c.b(cVar) != 1685485123 && c.b(cVar) != 1685480259) {
            jVar.q(i);
            return;
        }
        byte[] bArr = new byte[i];
        cVar.N = bArr;
        jVar.m(bArr, 0, i);
    }

    public void w(c cVar, int i, j jVar, int i2) {
        if (i != 4 || !"V_VP9".equals(cVar.b)) {
            jVar.q(i2);
        } else {
            this.n.Q(i2);
            jVar.m(this.n.e(), 0, i2);
        }
    }

    public void x(int i, long j) {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw l1.a("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw l1.a("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                t(i).d = (int) j;
                return;
            case 136:
                t(i).V = j == 1;
                return;
            case 155:
                this.I = E(j);
                return;
            case 159:
                t(i).O = (int) j;
                return;
            case 176:
                t(i).m = (int) j;
                return;
            case 179:
                i(i);
                this.C.a(E(j));
                return;
            case 186:
                t(i).n = (int) j;
                return;
            case 215:
                t(i).c = (int) j;
                return;
            case 231:
                this.B = E(j);
                return;
            case 238:
                this.P = (int) j;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                i(i);
                this.D.a(j);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                c.c(t(i), (int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw l1.a("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw l1.a("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw l1.a("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw l1.a("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw l1.a("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.x = j + this.q;
                return;
            case 21432:
                int i2 = (int) j;
                j(i);
                if (i2 == 0) {
                    this.u.w = 0;
                    return;
                }
                if (i2 == 1) {
                    this.u.w = 2;
                    return;
                } else if (i2 == 3) {
                    this.u.w = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.u.w = 3;
                    return;
                }
            case 21680:
                t(i).o = (int) j;
                return;
            case 21682:
                t(i).q = (int) j;
                return;
            case 21690:
                t(i).p = (int) j;
                return;
            case 21930:
                t(i).U = j == 1;
                return;
            case 21998:
                t(i).f = (int) j;
                return;
            case 22186:
                t(i).R = j;
                return;
            case 22203:
                t(i).S = j;
                return;
            case 25188:
                t(i).P = (int) j;
                return;
            case 30114:
                this.R = j;
                return;
            case 30321:
                j(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.u.r = 0;
                    return;
                }
                if (i3 == 1) {
                    this.u.r = 1;
                    return;
                } else if (i3 == 2) {
                    this.u.r = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.u.r = 3;
                    return;
                }
            case 2352003:
                t(i).e = (int) j;
                return;
            case 2807729:
                this.r = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        j(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.u.A = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.u.A = 1;
                            return;
                        }
                    case 21946:
                        j(i);
                        int j2 = e4.c.j((int) j);
                        if (j2 != -1) {
                            this.u.z = j2;
                            return;
                        }
                        return;
                    case 21947:
                        j(i);
                        this.u.x = true;
                        int i5 = e4.c.i((int) j);
                        if (i5 != -1) {
                            this.u.y = i5;
                            return;
                        }
                        return;
                    case 21948:
                        t(i).B = (int) j;
                        return;
                    case 21949:
                        t(i).C = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public boolean z(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public e(int i) {
        this(new j3.a(), i);
    }

    public e(j3.c cVar, int i) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.a = cVar;
        cVar.b(new b(this, null));
        this.d = (i & 1) == 0;
        this.b = new g();
        this.c = new SparseArray();
        this.g = new M(4);
        this.h = new M(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new M(4);
        this.e = new M(G.a);
        this.f = new M(4);
        this.j = new M();
        this.k = new M();
        this.l = new M(8);
        this.m = new M();
        this.n = new M();
        this.L = new int[1];
    }

    public final void release() {
    }
}
