package Q2;

import Q2.m;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l {
    public final s5.y a;
    public final List b = new ArrayList();
    public ByteBuffer[] c = new ByteBuffer[0];
    public m.a d;
    public m.a e;
    public boolean f;

    public l(s5.y yVar) {
        this.a = yVar;
        m.a aVar = m.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }

    public m.a a(m.a aVar) {
        if (aVar.equals(m.a.e)) {
            throw new m.b(aVar);
        }
        for (int i = 0; i < this.a.size(); i++) {
            m mVar = (m) this.a.get(i);
            m.a e = mVar.e(aVar);
            if (mVar.isActive()) {
                d4.a.g(!e.equals(m.a.e));
                aVar = e;
            }
        }
        this.e = aVar;
        return aVar;
    }

    public void b() {
        this.b.clear();
        this.d = this.e;
        this.f = false;
        for (int i = 0; i < this.a.size(); i++) {
            m mVar = (m) this.a.get(i);
            mVar.flush();
            if (mVar.isActive()) {
                this.b.add(mVar);
            }
        }
        this.c = new ByteBuffer[this.b.size()];
        for (int i2 = 0; i2 <= c(); i2++) {
            this.c[i2] = ((m) this.b.get(i2)).a();
        }
    }

    public final int c() {
        return this.c.length - 1;
    }

    public ByteBuffer d() {
        if (!f()) {
            return m.a;
        }
        Buffer buffer = this.c[c()];
        if (!buffer.hasRemaining()) {
            g(m.a);
        }
        return buffer;
    }

    public boolean e() {
        return this.f && ((m) this.b.get(c())).d() && !this.c[c()].hasRemaining();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.a.size() != lVar.a.size()) {
            return false;
        }
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i) != lVar.a.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.b.isEmpty();
    }

    public final void g(ByteBuffer byteBuffer) {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            int i = 0;
            while (i <= c()) {
                if (!this.c[i].hasRemaining()) {
                    m mVar = (m) this.b.get(i);
                    if (!mVar.d()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.c[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : m.a;
                        long remaining = byteBuffer2.remaining();
                        mVar.b(byteBuffer2);
                        this.c[i] = mVar.a();
                        z |= remaining - ((long) byteBuffer2.remaining()) > 0 || this.c[i].hasRemaining();
                    } else if (!this.c[i].hasRemaining() && i < c()) {
                        ((m) this.b.get(i + 1)).c();
                    }
                }
                i++;
            }
        }
    }

    public void h() {
        if (!f() || this.f) {
            return;
        }
        this.f = true;
        ((m) this.b.get(0)).c();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (!f() || this.f) {
            return;
        }
        g(byteBuffer);
    }

    public void j() {
        for (int i = 0; i < this.a.size(); i++) {
            m mVar = (m) this.a.get(i);
            mVar.flush();
            mVar.reset();
        }
        this.c = new ByteBuffer[0];
        m.a aVar = m.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }
}
