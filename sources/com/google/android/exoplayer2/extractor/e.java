package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.g;
import d3.u;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements g {
    public final FlacStreamMetadata a;
    public final long b;

    public e(FlacStreamMetadata flacStreamMetadata, long j) {
        this.a = flacStreamMetadata;
        this.b = j;
    }

    public final u a(long j, long j2) {
        return new u((j * 1000000) / this.a.sampleRate, this.b + j2);
    }

    public g.a e(long j) {
        d4.a.i(this.a.seekTable);
        FlacStreamMetadata flacStreamMetadata = this.a;
        FlacStreamMetadata.a aVar = flacStreamMetadata.seekTable;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.b;
        int i = k0.i(jArr, flacStreamMetadata.getSampleNumber(j), true, false);
        u a = a(i == -1 ? 0L : jArr[i], i != -1 ? jArr2[i] : 0L);
        if (a.a == j || i == jArr.length - 1) {
            return new g.a(a);
        }
        int i2 = i + 1;
        return new g.a(a, a(jArr[i2], jArr2[i2]));
    }

    public boolean g() {
        return true;
    }

    public long i() {
        return this.a.getDurationUs();
    }
}
