package q3;

import O2.A0;
import O2.D1;
import O2.k;
import O2.z0;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d4.k0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends k implements Handler.Callback {
    public long A;
    public final d q;
    public final f r;
    public final Handler s;
    public final e t;
    public final boolean u;
    public c v;
    public boolean w;
    public boolean x;
    public long y;
    public a z;

    public g(f fVar, Looper looper) {
        this(fVar, looper, d.a);
    }

    public void G() {
        this.z = null;
        this.v = null;
        this.A = -9223372036854775807L;
    }

    public void I(long j, boolean z) {
        this.z = null;
        this.w = false;
        this.x = false;
    }

    public void O(z0[] z0VarArr, long j, long j2) {
        this.v = this.q.b(z0VarArr[0]);
        a aVar = this.z;
        if (aVar != null) {
            this.z = aVar.d((aVar.c + this.A) - j2);
        }
        this.A = j2;
    }

    public final void S(a aVar, List list) {
        for (int i = 0; i < aVar.f(); i++) {
            z0 wrappedMetadataFormat = aVar.e(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.q.a(wrappedMetadataFormat)) {
                list.add(aVar.e(i));
            } else {
                c b = this.q.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) d4.a.e(aVar.e(i).getWrappedMetadataBytes());
                this.t.clear();
                this.t.e(bArr.length);
                ((ByteBuffer) k0.j(this.t.d)).put(bArr);
                this.t.i();
                a a = b.a(this.t);
                if (a != null) {
                    S(a, list);
                }
            }
        }
    }

    public final long T(long j) {
        d4.a.g(j != -9223372036854775807L);
        d4.a.g(this.A != -9223372036854775807L);
        return j - this.A;
    }

    public final void U(a aVar) {
        Handler handler = this.s;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            V(aVar);
        }
    }

    public final void V(a aVar) {
        this.r.e(aVar);
    }

    public final boolean W(long j) {
        boolean z;
        a aVar = this.z;
        if (aVar == null || (!this.u && aVar.c > T(j))) {
            z = false;
        } else {
            U(this.z);
            this.z = null;
            z = true;
        }
        if (this.w && this.z == null) {
            this.x = true;
        }
        return z;
    }

    public final void X() {
        if (this.w || this.z != null) {
            return;
        }
        this.t.clear();
        A0 B = B();
        int P = P(B, this.t, 0);
        if (P != -4) {
            if (P == -5) {
                this.y = ((z0) d4.a.e(B.b)).q;
            }
        } else {
            if (this.t.isEndOfStream()) {
                this.w = true;
                return;
            }
            e eVar = this.t;
            eVar.j = this.y;
            eVar.i();
            a a = ((c) k0.j(this.v)).a(this.t);
            if (a != null) {
                ArrayList arrayList = new ArrayList(a.f());
                S(a, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.z = new a(T(this.t.f), (List) arrayList);
            }
        }
    }

    public int a(z0 z0Var) {
        if (this.q.a(z0Var)) {
            return D1.a(z0Var.H == 0 ? 4 : 2);
        }
        return D1.a(0);
    }

    public boolean d() {
        return this.x;
    }

    public boolean e() {
        return true;
    }

    public String getName() {
        return "MetadataRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        V((a) message.obj);
        return true;
    }

    public void u(long j, long j2) {
        boolean z = true;
        while (z) {
            X();
            z = W(j);
        }
    }

    public g(f fVar, Looper looper, d dVar) {
        this(fVar, looper, dVar, false);
    }

    public g(f fVar, Looper looper, d dVar, boolean z) {
        super(5);
        this.r = (f) d4.a.e(fVar);
        this.s = looper == null ? null : k0.w(looper, this);
        this.q = (d) d4.a.e(dVar);
        this.u = z;
        this.t = new e();
        this.A = -9223372036854775807L;
    }
}
