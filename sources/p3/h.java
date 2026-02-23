package P3;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h extends U2.i implements j {
    public final String n;

    public class a extends o {
        public a() {
        }

        public void release() {
            h.v(h.this, this);
        }
    }

    public h(String str) {
        super(new n[2], new o[2]);
        this.n = str;
        u(1024);
    }

    public static /* synthetic */ void v(h hVar, com.google.android.exoplayer2.decoder.a aVar) {
        hVar.r(aVar);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final k j(n nVar, o oVar, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) d4.a.e(nVar.d);
            oVar.d(nVar.f, z(byteBuffer.array(), byteBuffer.limit(), z), nVar.j);
            oVar.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (k e) {
            return e;
        }
    }

    public final String getName() {
        return this.n;
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final n g() {
        return new n();
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final o h() {
        return new a();
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final k i(Throwable th) {
        return new k("Unexpected decode error", th);
    }

    public abstract i z(byte[] bArr, int i, boolean z);

    public void a(long j) {
    }
}
