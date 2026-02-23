package com.google.android.exoplayer2.ext.flac;

import O2.l1;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import d4.k0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends U2.i {
    public final FlacStreamMetadata n;
    public final FlacDecoderJni o;

    public d(int i, int i2, int i3, List list) {
        super(new U2.g[i], new SimpleDecoderOutputBuffer[i2]);
        if (list.size() != 1) {
            throw new e("Initialization data must be of length 1");
        }
        FlacDecoderJni flacDecoderJni = new FlacDecoderJni();
        this.o = flacDecoderJni;
        flacDecoderJni.setData(ByteBuffer.wrap((byte[]) list.get(0)));
        try {
            FlacStreamMetadata decodeStreamMetadata = flacDecoderJni.decodeStreamMetadata();
            this.n = decodeStreamMetadata;
            u(i3 == -1 ? decodeStreamMetadata.maxFrameSize : i3);
        } catch (l1 e) {
            throw new e("Failed to decode StreamInfo", e);
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static /* synthetic */ void A(d dVar, com.google.android.exoplayer2.decoder.a aVar) {
        dVar.r(aVar);
    }

    public static /* synthetic */ void v(d dVar, com.google.android.exoplayer2.decoder.a aVar) {
        A(dVar, aVar);
    }

    public U2.g g() {
        return new U2.g(1);
    }

    public String getName() {
        return "libflac";
    }

    public void release() {
        super.release();
        this.o.release();
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public SimpleDecoderOutputBuffer h() {
        return new SimpleDecoderOutputBuffer(new c(this));
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public e i(Throwable th) {
        return new e("Unexpected decode error", th);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public e j(U2.g gVar, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z) {
        if (z) {
            this.o.flush();
        }
        this.o.setData((ByteBuffer) k0.j(gVar.d));
        try {
            this.o.decodeSample(simpleDecoderOutputBuffer.init(gVar.f, this.n.getMaxDecodedFrameSize()));
            return null;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (FlacDecoderJni.a e2) {
            return new e("Frame decoding failed", e2);
        }
    }

    public FlacStreamMetadata z() {
        return this.n;
    }
}
