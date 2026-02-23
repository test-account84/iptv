package O2;

import Q2.X;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import p3.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class s implements G1 {
    public final Context a;
    public boolean e;
    public boolean g;
    public boolean h;
    public boolean i;
    public final p3.k b = new p3.k();
    public int c = 0;
    public long d = 5000;
    public p3.w f = p3.w.a;

    public s(Context context) {
        this.a = context;
    }

    public C1[] a(Handler handler, e4.A a, Q2.z zVar, P3.q qVar, q3.f fVar) {
        ArrayList arrayList = new ArrayList();
        h(this.a, this.c, this.f, this.e, handler, a, this.d, arrayList);
        Q2.B c = c(this.a, this.g, this.h, this.i);
        if (c != null) {
            b(this.a, this.c, this.f, this.e, c, handler, zVar, arrayList);
        }
        g(this.a, qVar, handler.getLooper(), this.c, arrayList);
        e(this.a, fVar, handler.getLooper(), this.c, arrayList);
        d(this.a, this.c, arrayList);
        f(this.a, handler, this.c, arrayList);
        return (C1[]) arrayList.toArray(new C1[0]);
    }

    public void b(Context context, int i, p3.w wVar, boolean z, Q2.B b, Handler handler, Q2.z zVar, ArrayList arrayList) {
        int i2;
        int i3;
        arrayList.add(new Q2.a0(context, i(), wVar, z, handler, zVar, b));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (C1) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor((Class[]) null).newInstance((Object[]) null));
                    d4.B.g("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        i3 = i2 + 1;
                        try {
                            arrayList.add(i2, (C1) a3.a.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                            d4.B.g("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                        } catch (ClassNotFoundException unused2) {
                            i2 = i3;
                            i3 = i2;
                            try {
                                int i4 = i3 + 1;
                                arrayList.add(i3, (C1) com.google.android.exoplayer2.ext.flac.i.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                                d4.B.g("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                            } catch (ClassNotFoundException unused3) {
                            }
                            arrayList.add(i4, (C1) com.google.android.exoplayer2.ext.ffmpeg.b.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                            d4.B.g("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                    try {
                        int i42 = i3 + 1;
                        try {
                            arrayList.add(i3, (C1) com.google.android.exoplayer2.ext.flac.i.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                            d4.B.g("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused5) {
                            i3 = i42;
                            i42 = i3;
                            arrayList.add(i42, (C1) com.google.android.exoplayer2.ext.ffmpeg.b.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                            d4.B.g("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                        arrayList.add(i42, (C1) com.google.android.exoplayer2.ext.ffmpeg.b.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                        d4.B.g("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating FLAC extension", e);
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating MIDI extension", e2);
            }
        } catch (ClassNotFoundException unused6) {
        }
        try {
            i3 = i2 + 1;
            arrayList.add(i2, (C1) a3.a.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
            d4.B.g("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            int i422 = i3 + 1;
            arrayList.add(i3, (C1) com.google.android.exoplayer2.ext.flac.i.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
            d4.B.g("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
            try {
                arrayList.add(i422, (C1) com.google.android.exoplayer2.ext.ffmpeg.b.class.getConstructor(new Class[]{Handler.class, Q2.z.class, Q2.B.class}).newInstance(new Object[]{handler, zVar, b}));
                d4.B.g("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            } catch (ClassNotFoundException unused7) {
            }
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating Opus extension", e4);
        }
    }

    public Q2.B c(Context context, boolean z, boolean z2, boolean z3) {
        return new X.f(context).l(z).k(z2).m(z3 ? 1 : 0).g();
    }

    public void d(Context context, int i, ArrayList arrayList) {
        arrayList.add(new f4.b());
    }

    public void e(Context context, q3.f fVar, Looper looper, int i, ArrayList arrayList) {
        arrayList.add(new q3.g(fVar, looper));
    }

    public void g(Context context, P3.q qVar, Looper looper, int i, ArrayList arrayList) {
        arrayList.add(new P3.r(qVar, looper));
    }

    public void h(Context context, int i, p3.w wVar, boolean z, Handler handler, e4.A a, long j, ArrayList arrayList) {
        String str;
        int i2;
        arrayList.add(new e4.i(context, i(), wVar, j, z, handler, a, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (C1) c3.a.class.getConstructor(new Class[]{Long.TYPE, Handler.class, e4.A.class, Integer.TYPE}).newInstance(new Object[]{Long.valueOf(j), handler, a, 50}));
                    str = "DefaultRenderersFactory";
                    try {
                        d4.B.g(str, "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused) {
                        size = i2;
                        i2 = size;
                        int i3 = W2.d.h0;
                        arrayList.add(i2, (C1) W2.d.class.getConstructor(new Class[]{Long.TYPE, Handler.class, e4.A.class, Integer.TYPE}).newInstance(new Object[]{Long.valueOf(j), handler, a, 50}));
                        d4.B.g(str, "Loaded Libgav1VideoRenderer.");
                    }
                } catch (ClassNotFoundException unused2) {
                    str = "DefaultRenderersFactory";
                }
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating VP9 extension", e);
            }
        } catch (ClassNotFoundException unused3) {
            str = "DefaultRenderersFactory";
        }
        try {
            int i32 = W2.d.h0;
            arrayList.add(i2, (C1) W2.d.class.getConstructor(new Class[]{Long.TYPE, Handler.class, e4.A.class, Integer.TYPE}).newInstance(new Object[]{Long.valueOf(j), handler, a, 50}));
            d4.B.g(str, "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused4) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating AV1 extension", e2);
        }
    }

    public m.b i() {
        return this.b;
    }

    public s j(int i) {
        this.c = i;
        return this;
    }

    public void f(Context context, Handler handler, int i, ArrayList arrayList) {
    }
}
