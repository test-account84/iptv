package j$.util.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class v extends B {
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(b bVar, int i, int i2) {
        super(bVar, i, 1);
        this.m = i2;
    }

    final q2 R(int i, q2 q2Var) {
        switch (this.m) {
            case 0:
                return new t(this, q2Var, 1);
            case 1:
                return q2Var;
            case 2:
                return new t(this, q2Var, 4);
            case 3:
                return new Y(1, q2Var);
            case 4:
                return new W(this, q2Var, 4);
            case 5:
                return new f0(q2Var);
            default:
                return new e0(this, q2Var, 3);
        }
    }
}
