package com.google.android.exoplayer2.ext.flac;

import O2.l1;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.g;
import d3.j;
import d3.u;
import d4.k0;
import java.io.IOException;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class FlacDecoderJni {
    private static final int TEMP_BUFFER_SIZE = 8192;
    private ByteBuffer byteBufferData;
    private boolean endOfExtractorInput;
    private j extractorInput;
    private final long nativeDecoderContext;
    private byte[] tempBuffer;

    public static final class a extends Exception {
        public final int a;

        public a(String str, int i) {
            super(str);
            this.a = i;
        }
    }

    public FlacDecoderJni() throws e {
        if (!h.isAvailable()) {
            throw new e("Failed to load decoder native libraries.");
        }
        long flacInit = flacInit();
        this.nativeDecoderContext = flacInit;
        if (flacInit == 0) {
            throw new e("Failed to initialize decoder");
        }
    }

    private native FlacStreamMetadata flacDecodeMetadata(long j) throws IOException;

    private native int flacDecodeToArray(long j, byte[] bArr) throws IOException;

    private native int flacDecodeToBuffer(long j, ByteBuffer byteBuffer) throws IOException;

    private native void flacFlush(long j);

    private native long flacGetDecodePosition(long j);

    private native long flacGetLastFrameFirstSampleIndex(long j);

    private native long flacGetLastFrameTimestamp(long j);

    private native long flacGetNextFrameFirstSampleIndex(long j);

    private native boolean flacGetSeekPoints(long j, long j2, long[] jArr);

    private native String flacGetStateString(long j);

    private native long flacInit();

    private native boolean flacIsDecoderAtEndOfStream(long j);

    private native void flacRelease(long j);

    private native void flacReset(long j, long j2);

    private int readFromExtractorInput(j jVar, byte[] bArr, int i, int i2) throws IOException {
        int read = jVar.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        this.endOfExtractorInput = true;
        return 0;
    }

    public void clearData() {
        this.byteBufferData = null;
        this.extractorInput = null;
    }

    public void decodeSample(ByteBuffer byteBuffer) throws IOException, a {
        byteBuffer.clear();
        int flacDecodeToBuffer = byteBuffer.isDirect() ? flacDecodeToBuffer(this.nativeDecoderContext, byteBuffer) : flacDecodeToArray(this.nativeDecoderContext, byteBuffer.array());
        if (flacDecodeToBuffer < 0) {
            if (!isDecoderAtEndOfInput()) {
                throw new a("Cannot decode FLAC frame", flacDecodeToBuffer);
            }
            flacDecodeToBuffer = 0;
        }
        byteBuffer.limit(flacDecodeToBuffer);
    }

    public void decodeSampleWithBacktrackPosition(ByteBuffer byteBuffer, long j) throws IOException, a {
        try {
            decodeSample(byteBuffer);
        } catch (IOException e) {
            if (j >= 0) {
                reset(j);
                j jVar = this.extractorInput;
                if (jVar != null) {
                    jVar.o(j, e);
                }
            }
            throw e;
        }
    }

    public FlacStreamMetadata decodeStreamMetadata() throws IOException {
        FlacStreamMetadata flacDecodeMetadata = flacDecodeMetadata(this.nativeDecoderContext);
        if (flacDecodeMetadata != null) {
            return flacDecodeMetadata;
        }
        throw l1.a("Failed to decode stream metadata", null);
    }

    public void flush() {
        flacFlush(this.nativeDecoderContext);
    }

    public long getDecodePosition() {
        return flacGetDecodePosition(this.nativeDecoderContext);
    }

    public long getLastFrameFirstSampleIndex() {
        return flacGetLastFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public long getLastFrameTimestamp() {
        return flacGetLastFrameTimestamp(this.nativeDecoderContext);
    }

    public long getNextFrameFirstSampleIndex() {
        return flacGetNextFrameFirstSampleIndex(this.nativeDecoderContext);
    }

    public g.a getSeekPoints(long j) {
        long[] jArr = new long[4];
        if (!flacGetSeekPoints(this.nativeDecoderContext, j, jArr)) {
            return null;
        }
        u uVar = new u(jArr[0], jArr[1]);
        return new g.a(uVar, jArr[2] == jArr[0] ? uVar : new u(jArr[2], jArr[3]));
    }

    public String getStateString() {
        return flacGetStateString(this.nativeDecoderContext);
    }

    public boolean isDecoderAtEndOfInput() {
        return flacIsDecoderAtEndOfStream(this.nativeDecoderContext);
    }

    public boolean isEndOfData() {
        ByteBuffer byteBuffer = this.byteBufferData;
        if (byteBuffer != null) {
            return byteBuffer.remaining() == 0;
        }
        if (this.extractorInput != null) {
            return this.endOfExtractorInput;
        }
        return true;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = this.byteBufferData;
        if (byteBuffer2 != null) {
            int min = Math.min(remaining, byteBuffer2.remaining());
            int limit = this.byteBufferData.limit();
            ByteBuffer byteBuffer3 = this.byteBufferData;
            byteBuffer3.limit(byteBuffer3.position() + min);
            byteBuffer.put(this.byteBufferData);
            this.byteBufferData.limit(limit);
            return min;
        }
        j jVar = this.extractorInput;
        if (jVar == null) {
            return -1;
        }
        byte[] bArr = (byte[]) k0.j(this.tempBuffer);
        int min2 = Math.min(remaining, 8192);
        int readFromExtractorInput = readFromExtractorInput(jVar, bArr, 0, min2);
        if (readFromExtractorInput < 4) {
            readFromExtractorInput += readFromExtractorInput(jVar, bArr, readFromExtractorInput, min2 - readFromExtractorInput);
        }
        int i = readFromExtractorInput;
        byteBuffer.put(bArr, 0, i);
        return i;
    }

    public void release() {
        flacRelease(this.nativeDecoderContext);
    }

    public void reset(long j) {
        flacReset(this.nativeDecoderContext, j);
    }

    public void setData(j jVar) {
        this.byteBufferData = null;
        this.extractorInput = jVar;
        this.endOfExtractorInput = false;
        if (this.tempBuffer == null) {
            this.tempBuffer = new byte[8192];
        }
    }

    public void setData(ByteBuffer byteBuffer) {
        this.byteBufferData = byteBuffer;
        this.extractorInput = null;
    }
}
