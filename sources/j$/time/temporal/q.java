package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class q implements p {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ q(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    public final m u(m mVar) {
        switch (this.a) {
            case 0:
                int i = mVar.i(a.DAY_OF_WEEK);
                int i2 = this.b;
                if (i == i2) {
                    return mVar;
                }
                return mVar.e(i - i2 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int i3 = mVar.i(a.DAY_OF_WEEK);
                int i4 = this.b;
                if (i3 == i4) {
                    return mVar;
                }
                return mVar.y(i4 - i3 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
