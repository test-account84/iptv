package Y6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o extends i {
    public boolean c;

    public o(x6.m mVar) {
        super(mVar);
        this.c = true;
    }

    public x6.c e(x6.i iVar) {
        if (this.c) {
            this.c = false;
            return new x6.c(new D6.j(iVar.e()));
        }
        this.c = true;
        return new x6.c(new D6.j(iVar));
    }
}
