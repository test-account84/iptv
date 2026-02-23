package q1;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends RequestBody {
    public final RequestBody a;
    public BufferedSink b;
    public g c;

    public class a extends ForwardingSink {
        public long a;
        public long c;

        public a(Sink sink) {
            super(sink);
            this.a = 0L;
            this.c = 0L;
        }

        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            if (this.c == 0) {
                this.c = e.this.contentLength();
            }
            this.a += j;
            if (e.a(e.this) != null) {
                e.a(e.this).obtainMessage(1, new r1.a(this.a, this.c)).sendToTarget();
            }
        }
    }

    public e(RequestBody requestBody, p1.f fVar) {
        this.a = requestBody;
        if (fVar != null) {
            this.c = new g(fVar);
        }
    }

    public static /* synthetic */ g a(e eVar) {
        return eVar.c;
    }

    public final Sink b(Sink sink) {
        return new a(sink);
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public MediaType contentType() {
        return this.a.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) {
        if (this.b == null) {
            this.b = Okio.buffer(b(bufferedSink));
        }
        this.a.writeTo(this.b);
        this.b.flush();
    }
}
