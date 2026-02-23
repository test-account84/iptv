package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class blj extends AbstractMap implements Serializable {
    private static final Comparator e = new blc();
    bli a;
    int b;
    int c;
    final bli d;
    private final Comparator f;
    private final boolean g;
    private ble h;
    private blg i;

    public blj() {
        this(e, true);
    }

    private final void f(bli bliVar, boolean z) {
        while (bliVar != null) {
            bli bliVar2 = bliVar.b;
            bli bliVar3 = bliVar.c;
            int i = bliVar2 != null ? bliVar2.i : 0;
            int i2 = bliVar3 != null ? bliVar3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                bli bliVar4 = bliVar3.b;
                bli bliVar5 = bliVar3.c;
                int i4 = (bliVar4 != null ? bliVar4.i : 0) - (bliVar5 != null ? bliVar5.i : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    i(bliVar3);
                }
                h(bliVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                bli bliVar6 = bliVar2.b;
                bli bliVar7 = bliVar2.c;
                int i5 = (bliVar6 != null ? bliVar6.i : 0) - (bliVar7 != null ? bliVar7.i : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    h(bliVar2);
                }
                i(bliVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                bliVar.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                bliVar.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            bliVar = bliVar.a;
        }
    }

    private final void g(bli bliVar, bli bliVar2) {
        bli bliVar3 = bliVar.a;
        bliVar.a = null;
        if (bliVar2 != null) {
            bliVar2.a = bliVar3;
        }
        if (bliVar3 == null) {
            this.a = bliVar2;
        } else if (bliVar3.b == bliVar) {
            bliVar3.b = bliVar2;
        } else {
            bliVar3.c = bliVar2;
        }
    }

    private final void h(bli bliVar) {
        bli bliVar2 = bliVar.b;
        bli bliVar3 = bliVar.c;
        bli bliVar4 = bliVar3.b;
        bli bliVar5 = bliVar3.c;
        bliVar.c = bliVar4;
        if (bliVar4 != null) {
            bliVar4.a = bliVar;
        }
        g(bliVar, bliVar3);
        bliVar3.b = bliVar;
        bliVar.a = bliVar3;
        int max = Math.max(bliVar2 != null ? bliVar2.i : 0, bliVar4 != null ? bliVar4.i : 0) + 1;
        bliVar.i = max;
        bliVar3.i = Math.max(max, bliVar5 != null ? bliVar5.i : 0) + 1;
    }

    private final void i(bli bliVar) {
        bli bliVar2 = bliVar.b;
        bli bliVar3 = bliVar.c;
        bli bliVar4 = bliVar2.b;
        bli bliVar5 = bliVar2.c;
        bliVar.b = bliVar5;
        if (bliVar5 != null) {
            bliVar5.a = bliVar;
        }
        g(bliVar, bliVar2);
        bliVar2.c = bliVar;
        bliVar.a = bliVar2;
        int max = Math.max(bliVar3 != null ? bliVar3.i : 0, bliVar5 != null ? bliVar5.i : 0) + 1;
        bliVar.i = max;
        bliVar2.i = Math.max(max, bliVar4 != null ? bliVar4.i : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final bli a(Object obj, boolean z) {
        int i;
        bli bliVar;
        Comparator comparator = this.f;
        bli bliVar2 = this.a;
        if (bliVar2 != null) {
            Comparable comparable = comparator == e ? (Comparable) obj : null;
            while (true) {
                Object obj2 = bliVar2.f;
                i = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i == 0) {
                    return bliVar2;
                }
                bli bliVar3 = i < 0 ? bliVar2.b : bliVar2.c;
                if (bliVar3 == null) {
                    break;
                }
                bliVar2 = bliVar3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        bli bliVar4 = this.d;
        if (bliVar2 != null) {
            bliVar = new bli(this.g, bliVar2, obj, bliVar4, bliVar4.e);
            if (i < 0) {
                bliVar2.b = bliVar;
            } else {
                bliVar2.c = bliVar;
            }
            f(bliVar2, true);
        } else {
            if (comparator == e && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            bliVar = new bli(this.g, null, obj, bliVar4, bliVar4.e);
            this.a = bliVar;
        }
        this.b++;
        this.c++;
        return bliVar;
    }

    public final bli b(Map.Entry entry) {
        bli c = c(entry.getKey());
        if (c == null) {
            return null;
        }
        Object obj = c.h;
        Object value = entry.getValue();
        if (obj == value || (obj != null && obj.equals(value))) {
            return c;
        }
        return null;
    }

    public final bli c(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void clear() {
        this.a = null;
        this.b = 0;
        this.c++;
        bli bliVar = this.d;
        bliVar.e = bliVar;
        bliVar.d = bliVar;
    }

    public final boolean containsKey(Object obj) {
        return c(obj) != null;
    }

    public final bli d(Object obj) {
        bli c = c(obj);
        if (c != null) {
            e(c, true);
        }
        return c;
    }

    public final void e(bli bliVar, boolean z) {
        bli bliVar2;
        bli bliVar3;
        int i;
        if (z) {
            bli bliVar4 = bliVar.e;
            bliVar4.d = bliVar.d;
            bliVar.d.e = bliVar4;
        }
        bli bliVar5 = bliVar.b;
        bli bliVar6 = bliVar.c;
        bli bliVar7 = bliVar.a;
        int i2 = 0;
        if (bliVar5 == null || bliVar6 == null) {
            if (bliVar5 != null) {
                g(bliVar, bliVar5);
                bliVar.b = null;
            } else if (bliVar6 != null) {
                g(bliVar, bliVar6);
                bliVar.c = null;
            } else {
                g(bliVar, null);
            }
            f(bliVar7, false);
            this.b--;
            this.c++;
            return;
        }
        if (bliVar5.i > bliVar6.i) {
            do {
                bliVar3 = bliVar5;
                bliVar5 = bliVar5.c;
            } while (bliVar5 != null);
        } else {
            do {
                bliVar2 = bliVar6;
                bliVar6 = bliVar6.b;
            } while (bliVar6 != null);
            bliVar3 = bliVar2;
        }
        e(bliVar3, false);
        bli bliVar8 = bliVar.b;
        if (bliVar8 != null) {
            i = bliVar8.i;
            bliVar3.b = bliVar8;
            bliVar8.a = bliVar3;
            bliVar.b = null;
        } else {
            i = 0;
        }
        bli bliVar9 = bliVar.c;
        if (bliVar9 != null) {
            i2 = bliVar9.i;
            bliVar3.c = bliVar9;
            bliVar9.a = bliVar3;
            bliVar.c = null;
        }
        bliVar3.i = Math.max(i, i2) + 1;
        g(bliVar, bliVar3);
    }

    public final Set entrySet() {
        ble bleVar = this.h;
        if (bleVar != null) {
            return bleVar;
        }
        ble bleVar2 = new ble(this);
        this.h = bleVar2;
        return bleVar2;
    }

    public final Object get(Object obj) {
        bli c = c(obj);
        if (c != null) {
            return c.h;
        }
        return null;
    }

    public final Set keySet() {
        blg blgVar = this.i;
        if (blgVar != null) {
            return blgVar;
        }
        blg blgVar2 = new blg(this);
        this.i = blgVar2;
        return blgVar2;
    }

    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.g) {
            throw new NullPointerException("value == null");
        }
        bli a = a(obj, true);
        Object obj3 = a.h;
        a.h = obj2;
        return obj3;
    }

    public final Object remove(Object obj) {
        bli d = d(obj);
        if (d != null) {
            return d.h;
        }
        return null;
    }

    public final int size() {
        return this.b;
    }

    public blj(Comparator comparator, boolean z) {
        this.b = 0;
        this.c = 0;
        this.f = comparator;
        this.g = z;
        this.d = new bli(z);
    }

    public blj(byte[] bArr) {
        this(e, false);
    }
}
