package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class a implements a.d {
    public final /* synthetic */ FlacStreamMetadata a;

    public /* synthetic */ a(FlacStreamMetadata flacStreamMetadata) {
        this.a = flacStreamMetadata;
    }

    public final long a(long j) {
        return this.a.getSampleNumber(j);
    }
}
