package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class SimpleDecoderOutputBuffer extends a {
    public ByteBuffer data;
    private final a.a owner;

    public SimpleDecoderOutputBuffer(a.a aVar) {
        this.owner = aVar;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long j, int i) {
        this.timeUs = j;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.data = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i);
        return this.data;
    }

    public void release() {
        this.owner.a(this);
    }
}
