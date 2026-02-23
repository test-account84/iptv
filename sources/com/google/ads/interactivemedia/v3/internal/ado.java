package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ado implements aes {
    private final int a;
    private final List b;

    public ado() {
        this(null);
    }

    private final List c(aer aerVar) {
        String str;
        int i;
        List list;
        if (d(32)) {
            return this.b;
        }
        cj cjVar = new cj(aerVar.d);
        ArrayList arrayList = this.b;
        while (cjVar.a() > 0) {
            int i2 = cjVar.i();
            int c = cjVar.c() + cjVar.i();
            if (i2 == 134) {
                arrayList = new ArrayList();
                int i3 = cjVar.i() & 31;
                for (int i4 = 0; i4 < i3; i4++) {
                    String u = cjVar.u(3);
                    int i5 = cjVar.i();
                    boolean z = (i5 & 128) != 0;
                    if (z) {
                        i = i5 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte i6 = (byte) cjVar.i();
                    cjVar.G(1);
                    if (z) {
                        int i7 = bo.a;
                        list = Collections.singletonList((i6 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    r rVar = new r();
                    rVar.ae(str);
                    rVar.V(u);
                    rVar.F(i);
                    rVar.T(list);
                    arrayList.add(rVar.v());
                }
            }
            cjVar.F(c);
        }
        return arrayList;
    }

    private final boolean d(int i) {
        return (i & this.a) != 0;
    }

    private final aeq e(aer aerVar) {
        return new aeq(c(aerVar));
    }

    private final bdy f(aer aerVar) {
        return new bdy(c(aerVar));
    }

    public final SparseArray a() {
        return new SparseArray();
    }

    public final aeu b(int i, aer aerVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new aeh(new aee(aerVar.b));
            }
            if (i == 21) {
                return new aeh(new aec());
            }
            if (i == 27) {
                if (d(4)) {
                    return null;
                }
                return new aeh(new adz(f(aerVar), d(1), d(8), null, null));
            }
            if (i == 36) {
                return new aeh(new aeb(f(aerVar), null, null));
            }
            if (i == 89) {
                return new aeh(new adq(aerVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new aeh(new adl(aerVar.b));
                }
                if (i == 257) {
                    return new aej(new aeg("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (d(16)) {
                        return null;
                    }
                    return new aej(new aeg("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!d(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!d(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!d(64)) {
                                    }
                                    break;
                            }
                    }
                    return null;
                }
                return new aeh(new adi(aerVar.b));
            }
            return new aeh(new adp(aerVar.b));
        }
        return new aeh(new adt(e(aerVar), null));
    }

    public ado(int i, List list) {
        this.a = i;
        this.b = list;
    }

    public ado(byte[] bArr) {
        this(0, avo.o());
    }
}
