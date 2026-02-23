package g3;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.a;
import d3.j;
import d3.p;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends com.google.android.exoplayer2.extractor.a {

    public static final class b implements a.f {
        public final FlacStreamMetadata a;
        public final int b;
        public final p.a c;

        public b(FlacStreamMetadata flacStreamMetadata, int i) {
            this.a = flacStreamMetadata;
            this.b = i;
            this.c = new p.a();
        }

        public a.e a(j jVar, long j) {
            long position = jVar.getPosition();
            long c = c(jVar);
            long k = jVar.k();
            jVar.n(Math.max(6, this.a.minFrameSize));
            long c2 = c(jVar);
            return (c > j || c2 <= j) ? c2 <= j ? a.e.f(c2, jVar.k()) : a.e.d(c, position) : a.e.e(k);
        }

        public /* synthetic */ void b() {
            d3.a.a(this);
        }

        public final long c(j jVar) {
            while (jVar.k() < jVar.getLength() - 6 && !p.h(jVar, this.a, this.b, this.c)) {
                jVar.n(1);
            }
            if (jVar.k() < jVar.getLength() - 6) {
                return this.c.a;
            }
            jVar.n((int) (jVar.getLength() - jVar.k()));
            return this.a.totalSamples;
        }

        public /* synthetic */ b(FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
            this(flacStreamMetadata, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        super(new com.google.android.exoplayer2.ext.flac.a(flacStreamMetadata), new b(flacStreamMetadata, i, null), flacStreamMetadata.getDurationUs(), 0L, flacStreamMetadata.totalSamples, j, j2, flacStreamMetadata.getApproxBytesPerFrame(), Math.max(6, flacStreamMetadata.minFrameSize));
        Objects.requireNonNull(flacStreamMetadata);
    }
}
