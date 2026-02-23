package com.google.android.exoplayer2.extractor;

import O2.z0;
import d4.L;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FlacStreamMetadata {
    public static final int NOT_IN_LOOKUP_TABLE = -1;
    private static final String TAG = "FlacStreamMetadata";
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    private final q3.a metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    public final a seekTable;
    public final long totalSamples;

    public static class a {
        public final long[] a;
        public final long[] b;

        public a(long[] jArr, long[] jArr2) {
            this.a = jArr;
            this.b = jArr2;
        }
    }

    private FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, a aVar, q3.a aVar2) {
        this.minBlockSizeSamples = i;
        this.maxBlockSizeSamples = i2;
        this.minFrameSize = i3;
        this.maxFrameSize = i4;
        this.sampleRate = i5;
        this.sampleRateLookupKey = getSampleRateLookupKey(i5);
        this.channels = i6;
        this.bitsPerSample = i7;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(i7);
        this.totalSamples = j;
        this.seekTable = aVar;
        this.metadata = aVar2;
    }

    private static q3.a concatenateVorbisMetadata(List list, List list2) {
        q3.a c = h.c(list);
        if (c == null && list2.isEmpty()) {
            return null;
        }
        return new q3.a(list2).c(c);
    }

    private static int getBitsPerSampleLookupKey(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int getSampleRateLookupKey(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata copyWithPictureFrames(List list) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(new q3.a(list)));
    }

    public FlacStreamMetadata copyWithSeekTable(a aVar) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, aVar, this.metadata);
    }

    public FlacStreamMetadata copyWithVorbisComments(List list) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(h.c(list)));
    }

    public long getApproxBytesPerFrame() {
        long j;
        long j2;
        int i = this.maxFrameSize;
        if (i > 0) {
            j = (i + this.minFrameSize) / 2;
            j2 = 1;
        } else {
            int i2 = this.minBlockSizeSamples;
            j = ((((i2 != this.maxBlockSizeSamples || i2 <= 0) ? 4096L : i2) * this.channels) * this.bitsPerSample) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public int getDecodedBitrate() {
        return this.bitsPerSample * this.sampleRate * this.channels;
    }

    public long getDurationUs() {
        long j = this.totalSamples;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.sampleRate;
    }

    public z0 getFormat(byte[] bArr, q3.a aVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i = this.maxFrameSize;
        if (i <= 0) {
            i = -1;
        }
        return new z0.b().g0("audio/flac").Y(i).J(this.channels).h0(this.sampleRate).V(Collections.singletonList(bArr)).Z(getMetadataCopyWithAppendedEntriesFrom(aVar)).G();
    }

    public int getMaxDecodedFrameSize() {
        return this.maxBlockSizeSamples * this.channels * (this.bitsPerSample / 8);
    }

    public q3.a getMetadataCopyWithAppendedEntriesFrom(q3.a aVar) {
        q3.a aVar2 = this.metadata;
        return aVar2 == null ? aVar : aVar2.c(aVar);
    }

    public long getSampleNumber(long j) {
        return k0.s((j * this.sampleRate) / 1000000, 0L, this.totalSamples - 1);
    }

    public FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, ArrayList arrayList, ArrayList arrayList2) {
        this(i, i2, i3, i4, i5, i6, i7, j, (a) null, concatenateVorbisMetadata(arrayList, arrayList2));
    }

    public FlacStreamMetadata(byte[] bArr, int i) {
        L l = new L(bArr);
        l.p(i * 8);
        this.minBlockSizeSamples = l.h(16);
        this.maxBlockSizeSamples = l.h(16);
        this.minFrameSize = l.h(24);
        this.maxFrameSize = l.h(24);
        int h = l.h(20);
        this.sampleRate = h;
        this.sampleRateLookupKey = getSampleRateLookupKey(h);
        this.channels = l.h(3) + 1;
        int h2 = l.h(5) + 1;
        this.bitsPerSample = h2;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(h2);
        this.totalSamples = l.j(36);
        this.seekTable = null;
        this.metadata = null;
    }
}
