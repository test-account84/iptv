package q1;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends ResponseBody {
    public final ResponseBody a;
    public BufferedSource c;
    public b d;

    public class a extends ForwardingSource {
        public long a;

        public a(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j) {
            long read = super.read(buffer, j);
            this.a += read != -1 ? read : 0L;
            if (f.a(f.this) != null) {
                f.a(f.this).obtainMessage(1, new r1.a(this.a, f.c(f.this).contentLength())).sendToTarget();
            }
            return read;
        }
    }

    public f(ResponseBody responseBody, p1.b bVar) {
        this.a = responseBody;
        if (bVar != null) {
            this.d = new b(bVar);
        }
    }

    public static /* synthetic */ b a(f fVar) {
        return fVar.d;
    }

    public static /* synthetic */ ResponseBody c(f fVar) {
        return fVar.a;
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public MediaType contentType() {
        return this.a.contentType();
    }

    public final Source d(Source source) {
        return new a(source);
    }

    public BufferedSource source() {
        if (this.c == null) {
            this.c = Okio.buffer(d(this.a.source()));
        }
        return this.c;
    }
}
