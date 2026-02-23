package a3;

import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.ext.opus.OpusDecoder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class b implements a.a {
    public final /* synthetic */ OpusDecoder a;

    public /* synthetic */ b(OpusDecoder opusDecoder) {
        this.a = opusDecoder;
    }

    public final void a(com.google.android.exoplayer2.decoder.a aVar) {
        OpusDecoder.v(this.a, (SimpleDecoderOutputBuffer) aVar);
    }
}
