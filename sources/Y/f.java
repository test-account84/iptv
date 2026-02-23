package y;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements d {
    public m d;
    public int f;
    public int g;
    public d a = null;
    public boolean b = false;
    public boolean c = false;
    public a e = a.UNKNOWN;
    public int h = 1;
    public g i = null;
    public boolean j = false;
    public List k = new ArrayList();
    public List l = new ArrayList();

    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.d = mVar;
    }

    public void a(d dVar) {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).j) {
                return;
            }
        }
        this.c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        f fVar = null;
        int i = 0;
        for (f fVar2 : this.l) {
            if (!(fVar2 instanceof g)) {
                i++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i == 1 && fVar.j) {
            g gVar = this.i;
            if (gVar != null) {
                if (!gVar.j) {
                    return;
                } else {
                    this.f = this.h * gVar.g;
                }
            }
            d(fVar.g + this.f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.k.add(dVar);
        if (this.j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (d dVar : this.k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.p());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
