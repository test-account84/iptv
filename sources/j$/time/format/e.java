package j$.time.format;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class e implements f {
    private final f[] a;
    private final boolean b;

    e(List list, boolean z) {
        this((f[]) list.toArray(new f[list.size()]), z);
    }

    e(f[] fVarArr, boolean z) {
        this.a = fVarArr;
        this.b = z;
    }

    public final e a() {
        return !this.b ? this : new e(this.a, false);
    }

    public final boolean i(p pVar, StringBuilder sb) {
        int length = sb.length();
        boolean z = this.b;
        if (z) {
            pVar.g();
        }
        try {
            for (f fVar : this.a) {
                if (!fVar.i(pVar, sb)) {
                    sb.setLength(length);
                    return true;
                }
            }
            if (z) {
                pVar.a();
            }
            return true;
        } finally {
            if (z) {
                pVar.a();
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        f[] fVarArr = this.a;
        if (fVarArr != null) {
            boolean z = this.b;
            sb.append(z ? "[" : "(");
            for (f fVar : fVarArr) {
                sb.append(fVar);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }
}
