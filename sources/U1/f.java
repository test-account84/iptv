package U1;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements S1.c {
    public final String a;
    public final int b;
    public final int c;
    public final S1.e d;
    public final S1.e e;
    public final S1.g f;
    public final S1.f g;
    public final i2.c h;
    public final S1.b i;
    public final S1.c j;
    public String k;
    public int l;
    public S1.c m;

    public f(String str, S1.c cVar, int i, int i2, S1.e eVar, S1.e eVar2, S1.g gVar, S1.f fVar, i2.c cVar2, S1.b bVar) {
        this.a = str;
        this.j = cVar;
        this.b = i;
        this.c = i2;
        this.d = eVar;
        this.e = eVar2;
        this.f = gVar;
        this.g = fVar;
        this.h = cVar2;
        this.i = bVar;
    }

    public void a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.a.getBytes("UTF-8"));
        messageDigest.update(array);
        S1.e eVar = this.d;
        messageDigest.update((eVar != null ? eVar.getId() : "").getBytes("UTF-8"));
        S1.e eVar2 = this.e;
        messageDigest.update((eVar2 != null ? eVar2.getId() : "").getBytes("UTF-8"));
        S1.g gVar = this.f;
        messageDigest.update((gVar != null ? gVar.getId() : "").getBytes("UTF-8"));
        S1.f fVar = this.g;
        messageDigest.update((fVar != null ? fVar.getId() : "").getBytes("UTF-8"));
        S1.b bVar = this.i;
        messageDigest.update((bVar != null ? bVar.getId() : "").getBytes("UTF-8"));
    }

    public S1.c b() {
        if (this.m == null) {
            this.m = new k(this.a, this.j);
        }
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.a.equals(fVar.a) || !this.j.equals(fVar.j) || this.c != fVar.c || this.b != fVar.b) {
            return false;
        }
        S1.g gVar = this.f;
        if ((gVar == null) ^ (fVar.f == null)) {
            return false;
        }
        if (gVar != null && !gVar.getId().equals(fVar.f.getId())) {
            return false;
        }
        S1.e eVar = this.e;
        if ((eVar == null) ^ (fVar.e == null)) {
            return false;
        }
        if (eVar != null && !eVar.getId().equals(fVar.e.getId())) {
            return false;
        }
        S1.e eVar2 = this.d;
        if ((eVar2 == null) ^ (fVar.d == null)) {
            return false;
        }
        if (eVar2 != null && !eVar2.getId().equals(fVar.d.getId())) {
            return false;
        }
        S1.f fVar2 = this.g;
        if ((fVar2 == null) ^ (fVar.g == null)) {
            return false;
        }
        if (fVar2 != null && !fVar2.getId().equals(fVar.g.getId())) {
            return false;
        }
        i2.c cVar = this.h;
        if ((cVar == null) ^ (fVar.h == null)) {
            return false;
        }
        if (cVar != null && !cVar.getId().equals(fVar.h.getId())) {
            return false;
        }
        S1.b bVar = this.i;
        if ((bVar == null) ^ (fVar.i == null)) {
            return false;
        }
        return bVar == null || bVar.getId().equals(fVar.i.getId());
    }

    public int hashCode() {
        if (this.l == 0) {
            int hashCode = this.a.hashCode();
            this.l = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.j.hashCode()) * 31) + this.b) * 31) + this.c;
            this.l = hashCode2;
            int i = hashCode2 * 31;
            S1.e eVar = this.d;
            int hashCode3 = i + (eVar != null ? eVar.getId().hashCode() : 0);
            this.l = hashCode3;
            int i2 = hashCode3 * 31;
            S1.e eVar2 = this.e;
            int hashCode4 = i2 + (eVar2 != null ? eVar2.getId().hashCode() : 0);
            this.l = hashCode4;
            int i3 = hashCode4 * 31;
            S1.g gVar = this.f;
            int hashCode5 = i3 + (gVar != null ? gVar.getId().hashCode() : 0);
            this.l = hashCode5;
            int i4 = hashCode5 * 31;
            S1.f fVar = this.g;
            int hashCode6 = i4 + (fVar != null ? fVar.getId().hashCode() : 0);
            this.l = hashCode6;
            int i5 = hashCode6 * 31;
            i2.c cVar = this.h;
            int hashCode7 = i5 + (cVar != null ? cVar.getId().hashCode() : 0);
            this.l = hashCode7;
            int i6 = hashCode7 * 31;
            S1.b bVar = this.i;
            this.l = i6 + (bVar != null ? bVar.getId().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.a);
            sb.append('+');
            sb.append(this.j);
            sb.append("+[");
            sb.append(this.b);
            sb.append('x');
            sb.append(this.c);
            sb.append("]+");
            sb.append('\'');
            S1.e eVar = this.d;
            sb.append(eVar != null ? eVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            S1.e eVar2 = this.e;
            sb.append(eVar2 != null ? eVar2.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            S1.g gVar = this.f;
            sb.append(gVar != null ? gVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            S1.f fVar = this.g;
            sb.append(fVar != null ? fVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            i2.c cVar = this.h;
            sb.append(cVar != null ? cVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            S1.b bVar = this.i;
            sb.append(bVar != null ? bVar.getId() : "");
            sb.append('\'');
            sb.append('}');
            this.k = sb.toString();
        }
        return this.k;
    }
}
