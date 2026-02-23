package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class brc {
    protected volatile brs a;
    private volatile bpb b;

    static {
        int i = bqb.b;
    }

    public final int a() {
        if (this.b != null) {
            return this.b.d();
        }
        if (this.a != null) {
            return this.a.ax();
        }
        return 0;
    }

    public final bpb b() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            try {
                if (this.b != null) {
                    return this.b;
                }
                this.b = this.a == null ? bpb.b : this.a.au();
                return this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final brs c(brs brsVar) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    try {
                        this.a = brsVar;
                        this.b = bpb.b;
                    } catch (bqw unused) {
                        this.a = brsVar;
                        this.b = bpb.b;
                    }
                }
            }
        }
        return this.a;
    }

    public final brs d(brs brsVar) {
        brs brsVar2 = this.a;
        this.b = null;
        this.a = brsVar;
        return brsVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof brc)) {
            return false;
        }
        brc brcVar = (brc) obj;
        brs brsVar = this.a;
        brs brsVar2 = brcVar.a;
        return (brsVar == null && brsVar2 == null) ? b().equals(brcVar.b()) : (brsVar == null || brsVar2 == null) ? brsVar != null ? brsVar.equals(brcVar.c(brsVar.ba())) : c(brsVar2.ba()).equals(brsVar2) : brsVar.equals(brsVar2);
    }

    public int hashCode() {
        return 1;
    }
}
