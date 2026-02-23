package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bqj extends bom {
    protected bqn a;
    private final bqn b;

    public bqj(bqn bqnVar) {
        this.b = bqnVar;
        if (bqnVar.aO()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.a = a();
    }

    private final bqn a() {
        return this.b.aA();
    }

    private static void b(Object obj, Object obj2) {
        bsa.a().c(obj).g(obj, obj2);
    }

    public final /* synthetic */ bom aR(bon bonVar) {
        be((bqn) bonVar);
        return this;
    }

    public final /* bridge */ /* synthetic */ void aT(bpg bpgVar, bqb bqbVar) throws IOException {
        if (!this.a.aO()) {
            bc();
        }
        try {
            bsa.a().c(this.a).h(this.a, bpi.q(bpgVar), bqbVar);
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof IOException)) {
                throw e;
            }
            throw e.getCause();
        }
    }

    /* renamed from: aV, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final bqj clone() {
        bqj bqjVar = (bqj) this.b.aP(5);
        bqjVar.a = aZ();
        return bqjVar;
    }

    /* renamed from: aW, reason: merged with bridge method [inline-methods] */
    public final bqn aY() {
        bqn aZ = aZ();
        if (aZ.bd()) {
            return aZ;
        }
        throw new bsw();
    }

    /* renamed from: aX, reason: merged with bridge method [inline-methods] */
    public bqn aZ() {
        if (!this.a.aO()) {
            return this.a;
        }
        this.a.aJ();
        return this.a;
    }

    public final /* synthetic */ brs ba() {
        return this.b;
    }

    public final void bb() {
        if (this.a.aO()) {
            return;
        }
        bc();
    }

    public void bc() {
        bqn a = a();
        b(a, this.a);
        this.a = a;
    }

    public final boolean bd() {
        return bqn.aN(this.a, false);
    }

    public final void be(bqn bqnVar) {
        if (this.b.equals(bqnVar)) {
            return;
        }
        if (!this.a.aO()) {
            bc();
        }
        b(this.a, bqnVar);
    }

    /* renamed from: bf, reason: merged with bridge method [inline-methods] */
    public final void aU(byte[] bArr, int i, bqb bqbVar) throws bqw {
        if (!this.a.aO()) {
            bc();
        }
        try {
            bsa.a().c(this.a).i(this.a, bArr, 0, i, new boq(bqbVar));
        } catch (bqw e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw bqw.i();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }
}
