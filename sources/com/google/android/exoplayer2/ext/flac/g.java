package com.google.android.exoplayer2.ext.flac;

import O2.z0;
import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.ext.flac.b;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.g;
import d3.j;
import d3.k;
import d3.o;
import d3.t;
import d3.u;
import d3.w;
import d4.M;
import d4.k0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements d3.i {
    public static final o k = new f();
    public final M a;
    public final boolean b;
    public FlacDecoderJni c;
    public k d;
    public w e;
    public boolean f;
    public FlacStreamMetadata g;
    public b.c h;
    public q3.a i;
    public b j;

    public static final class a implements com.google.android.exoplayer2.extractor.g {
        public final long a;
        public final FlacDecoderJni b;

        public a(long j, FlacDecoderJni flacDecoderJni) {
            this.a = j;
            this.b = flacDecoderJni;
        }

        public g.a e(long j) {
            g.a seekPoints = this.b.getSeekPoints(j);
            return seekPoints == null ? new g.a(u.c) : seekPoints;
        }

        public boolean g() {
            return true;
        }

        public long i() {
            return this.a;
        }
    }

    public g() {
        this(0);
    }

    public static /* synthetic */ d3.i[] c() {
        return i();
    }

    private static /* synthetic */ d3.i[] i() {
        return new d3.i[]{new g()};
    }

    public static void j(FlacStreamMetadata flacStreamMetadata, q3.a aVar, w wVar) {
        wVar.d(new z0.b().g0("audio/raw").I(flacStreamMetadata.getDecodedBitrate()).b0(flacStreamMetadata.getDecodedBitrate()).Y(flacStreamMetadata.getMaxDecodedFrameSize()).J(flacStreamMetadata.channels).h0(flacStreamMetadata.sampleRate).a0(k0.h0(flacStreamMetadata.bitsPerSample)).Z(aVar).G());
    }

    public static void k(M m, int i, long j, w wVar) {
        m.U(0);
        wVar.b(m, i);
        wVar.f(j, 1, i, 0, null);
    }

    public static b l(FlacDecoderJni flacDecoderJni, FlacStreamMetadata flacStreamMetadata, long j, k kVar, b.c cVar) {
        com.google.android.exoplayer2.extractor.g bVar;
        b bVar2 = null;
        if (flacDecoderJni.getSeekPoints(0L) != null) {
            bVar = new a(flacStreamMetadata.getDurationUs(), flacDecoderJni);
        } else if (j == -1 || flacStreamMetadata.totalSamples <= 0) {
            bVar = new g.b(flacStreamMetadata.getDurationUs());
        } else {
            b bVar3 = new b(flacStreamMetadata, flacDecoderJni.getDecodePosition(), j, flacDecoderJni, cVar);
            bVar = bVar3.b();
            bVar2 = bVar3;
        }
        kVar.n(bVar);
        return bVar2;
    }

    public void a(long j, long j2) {
        if (j == 0) {
            this.f = false;
        }
        FlacDecoderJni flacDecoderJni = this.c;
        if (flacDecoderJni != null) {
            flacDecoderJni.reset(j);
        }
        b bVar = this.j;
        if (bVar != null) {
            bVar.h(j2);
        }
    }

    public void b(k kVar) {
        this.d = kVar;
        this.e = kVar.e(0, 1);
        this.d.q();
        try {
            this.c = new FlacDecoderJni();
        } catch (e e) {
            throw new RuntimeException(e);
        }
    }

    public int d(j jVar, t tVar) {
        if (jVar.getPosition() == 0 && !this.b && this.i == null) {
            this.i = com.google.android.exoplayer2.extractor.d.c(jVar, true);
        }
        FlacDecoderJni g = g(jVar);
        try {
            e(jVar);
            b bVar = this.j;
            if (bVar != null && bVar.d()) {
                return f(jVar, tVar, this.a, this.h, this.e);
            }
            ByteBuffer byteBuffer = this.h.a;
            long decodePosition = g.getDecodePosition();
            try {
                g.decodeSampleWithBacktrackPosition(byteBuffer, decodePosition);
                int limit = byteBuffer.limit();
                if (limit == 0) {
                    return -1;
                }
                k(this.a, limit, g.getLastFrameTimestamp(), this.e);
                return g.isEndOfData() ? -1 : 0;
            } catch (FlacDecoderJni.a e) {
                throw new IOException("Cannot read frame at position " + decodePosition, e);
            }
        } finally {
            g.clearData();
        }
    }

    public final void e(j jVar) {
        if (this.f) {
            return;
        }
        FlacDecoderJni flacDecoderJni = this.c;
        try {
            FlacStreamMetadata decodeStreamMetadata = flacDecoderJni.decodeStreamMetadata();
            this.f = true;
            if (this.g == null) {
                this.g = decodeStreamMetadata;
                this.a.Q(decodeStreamMetadata.getMaxDecodedFrameSize());
                this.h = new b.c(ByteBuffer.wrap(this.a.e()));
                this.j = l(flacDecoderJni, decodeStreamMetadata, jVar.getLength(), this.d, this.h);
                j(decodeStreamMetadata, decodeStreamMetadata.getMetadataCopyWithAppendedEntriesFrom(this.i), this.e);
            }
        } catch (IOException e) {
            flacDecoderJni.reset(0L);
            jVar.o(0L, e);
            throw e;
        }
    }

    public final int f(j jVar, t tVar, M m, b.c cVar, w wVar) {
        int c = this.j.c(jVar, tVar);
        ByteBuffer byteBuffer = cVar.a;
        if (c == 0 && byteBuffer.limit() > 0) {
            k(m, byteBuffer.limit(), cVar.b, wVar);
        }
        return c;
    }

    public final FlacDecoderJni g(j jVar) {
        FlacDecoderJni flacDecoderJni = (FlacDecoderJni) d4.a.e(this.c);
        flacDecoderJni.setData(jVar);
        return flacDecoderJni;
    }

    public boolean h(j jVar) {
        this.i = com.google.android.exoplayer2.extractor.d.c(jVar, !this.b);
        return com.google.android.exoplayer2.extractor.d.a(jVar);
    }

    public void release() {
        this.j = null;
        FlacDecoderJni flacDecoderJni = this.c;
        if (flacDecoderJni != null) {
            flacDecoderJni.release();
            this.c = null;
        }
    }

    public g(int i) {
        this.a = new M();
        this.b = (i & 1) != 0;
    }
}
