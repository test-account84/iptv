package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kb {
    public final s a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final jb[] i;

    public kb(s sVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, jb[] jbVarArr) {
        this.a = sVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = jbVarArr;
    }

    private static AudioAttributes d(f fVar, boolean z) {
        return z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : fVar.a().a;
    }

    public final long a(long j) {
        return (j * 1000000) / this.e;
    }

    public final AudioTrack b(boolean z, f fVar, int i) throws jl {
        AudioTrack audioTrack;
        try {
            int i2 = cq.a;
            if (i2 >= 29) {
                AudioFormat B = kh.B(this.e, this.f, this.g);
                AudioAttributes d = d(fVar, z);
                n1.a();
                audioTrack = l1.a(k1.a(j1.a(i1.a(h1.a(g1.a(f1.a(m1.a(), d), B), 1), this.h), i), this.c == 1));
            } else if (i2 >= 21) {
                audioTrack = new AudioTrack(d(fVar, z), kh.B(this.e, this.f, this.g), this.h, 1, i);
            } else {
                int i3 = fVar.c;
                audioTrack = i == 0 ? new AudioTrack(3, this.e, this.f, this.g, this.h, 1) : new AudioTrack(3, this.e, this.f, this.g, this.h, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new jl(state, this.e, this.f, this.h, this.a, c(), null);
        } catch (IllegalArgumentException e) {
            e = e;
            throw new jl(0, this.e, this.f, this.h, this.a, c(), e);
        } catch (UnsupportedOperationException e2) {
            e = e2;
            throw new jl(0, this.e, this.f, this.h, this.a, c(), e);
        }
    }

    public final boolean c() {
        return this.c == 1;
    }
}
