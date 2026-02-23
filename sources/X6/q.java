package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q {
    public final float a;
    public final float b;

    public q(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static float a(q qVar, q qVar2, q qVar3) {
        float f = qVar2.a;
        float f2 = qVar2.b;
        return ((qVar3.a - f) * (qVar.b - f2)) - ((qVar3.b - f2) * (qVar.a - f));
    }

    public static float b(q qVar, q qVar2) {
        return E6.a.a(qVar.a, qVar.b, qVar2.a, qVar2.b);
    }

    public static void e(q[] qVarArr) {
        q qVar;
        q qVar2;
        q qVar3;
        float b = b(qVarArr[0], qVarArr[1]);
        float b2 = b(qVarArr[1], qVarArr[2]);
        float b3 = b(qVarArr[0], qVarArr[2]);
        if (b2 >= b && b2 >= b3) {
            qVar = qVarArr[0];
            qVar2 = qVarArr[1];
            qVar3 = qVarArr[2];
        } else if (b3 < b2 || b3 < b) {
            qVar = qVarArr[2];
            qVar2 = qVarArr[0];
            qVar3 = qVarArr[1];
        } else {
            qVar = qVarArr[1];
            qVar2 = qVarArr[0];
            qVar3 = qVarArr[2];
        }
        if (a(qVar2, qVar, qVar3) < 0.0f) {
            q qVar4 = qVar3;
            qVar3 = qVar2;
            qVar2 = qVar4;
        }
        qVarArr[0] = qVar2;
        qVarArr[1] = qVar;
        qVarArr[2] = qVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.a == qVar.a && this.b == qVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
