package f4;

import O2.D1;
import O2.z0;
import d4.M;
import d4.k0;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends O2.k {
    public final U2.g q;
    public final M r;
    public long s;
    public a t;
    public long u;

    public b() {
        super(6);
        this.q = new U2.g(1);
        this.r = new M();
    }

    public void G() {
        T();
    }

    public void I(long j, boolean z) {
        this.u = Long.MIN_VALUE;
        T();
    }

    public void O(z0[] z0VarArr, long j, long j2) {
        this.s = j2;
    }

    public final float[] S(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.r.S(byteBuffer.array(), byteBuffer.limit());
        this.r.U(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.r.u());
        }
        return fArr;
    }

    public final void T() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.c();
        }
    }

    public int a(z0 z0Var) {
        return D1.a("application/x-camera-motion".equals(z0Var.m) ? 4 : 0);
    }

    public boolean d() {
        return h();
    }

    public boolean e() {
        return true;
    }

    public String getName() {
        return "CameraMotionRenderer";
    }

    public void n(int i, Object obj) {
        if (i == 8) {
            this.t = (a) obj;
        } else {
            super.n(i, obj);
        }
    }

    public void u(long j, long j2) {
        while (!h() && this.u < 100000 + j) {
            this.q.clear();
            if (P(B(), this.q, 0) != -4 || this.q.isEndOfStream()) {
                return;
            }
            U2.g gVar = this.q;
            this.u = gVar.f;
            if (this.t != null && !gVar.isDecodeOnly()) {
                this.q.i();
                float[] S = S((ByteBuffer) k0.j(this.q.d));
                if (S != null) {
                    ((a) k0.j(this.t)).b(this.u - this.s, S);
                }
            }
        }
    }
}
