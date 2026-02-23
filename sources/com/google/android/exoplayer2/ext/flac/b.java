package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.a;
import d3.j;
import j$.util.Objects;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends com.google.android.exoplayer2.extractor.a {
    public final FlacDecoderJni e;

    public static final class b implements a.f {
        public final FlacDecoderJni a;
        public final c b;

        public b(FlacDecoderJni flacDecoderJni, c cVar) {
            this.a = flacDecoderJni;
            this.b = cVar;
        }

        public a.e a(j jVar, long j) {
            ByteBuffer byteBuffer = this.b.a;
            long position = jVar.getPosition();
            this.a.reset(position);
            try {
                this.a.decodeSampleWithBacktrackPosition(byteBuffer, position);
                if (byteBuffer.limit() == 0) {
                    return a.e.d;
                }
                long lastFrameFirstSampleIndex = this.a.getLastFrameFirstSampleIndex();
                long nextFrameFirstSampleIndex = this.a.getNextFrameFirstSampleIndex();
                long decodePosition = this.a.getDecodePosition();
                if (lastFrameFirstSampleIndex > j || nextFrameFirstSampleIndex <= j) {
                    return nextFrameFirstSampleIndex <= j ? a.e.f(nextFrameFirstSampleIndex, decodePosition) : a.e.d(lastFrameFirstSampleIndex, position);
                }
                this.b.b = this.a.getLastFrameTimestamp();
                return a.e.e(jVar.getPosition());
            } catch (FlacDecoderJni.a unused) {
                return a.e.d;
            }
        }

        public /* synthetic */ void b() {
            d3.a.a(this);
        }

        public /* synthetic */ b(FlacDecoderJni flacDecoderJni, c cVar, a aVar) {
            this(flacDecoderJni, cVar);
        }
    }

    public static final class c {
        public final ByteBuffer a;
        public long b = 0;

        public c(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FlacStreamMetadata flacStreamMetadata, long j, long j2, FlacDecoderJni flacDecoderJni, c cVar) {
        super(new com.google.android.exoplayer2.ext.flac.a(flacStreamMetadata), new b(flacDecoderJni, cVar, null), flacStreamMetadata.getDurationUs(), 0L, flacStreamMetadata.totalSamples, j, j2, flacStreamMetadata.getApproxBytesPerFrame(), Math.max(6, flacStreamMetadata.minFrameSize));
        Objects.requireNonNull(flacStreamMetadata);
        this.e = (FlacDecoderJni) d4.a.e(flacDecoderJni);
    }

    public void f(boolean z, long j) {
        if (z) {
            return;
        }
        this.e.reset(j);
    }
}
