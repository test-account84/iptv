package t4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o implements v {
    public final /* synthetic */ v a;
    public final /* synthetic */ s b;

    public o(s sVar, v vVar) {
        this.b = sVar;
        this.a = vVar;
    }

    public final void a(long j) {
        v vVar = this.a;
        if (vVar != null) {
            vVar.a(j);
        }
    }

    public final void b(long j, int i, Object obj) {
        if (this.a != null) {
            if (i == 2001) {
                s sVar = this.b;
                sVar.a.f("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(s.E(sVar)));
                s.p(this.b).zzl();
                i = 2001;
            }
            this.a.b(j, i, obj);
        }
    }
}
