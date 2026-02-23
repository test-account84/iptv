package de.blinkt.openvpn.core;

import java.math.BigInteger;
import java.net.Inet6Address;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l {
    public TreeSet a = new TreeSet();

    public static class a implements Comparable {
        public BigInteger a;
        public int c;
        public boolean d;
        public boolean e;
        public BigInteger f;
        public BigInteger g;

        public a(de.blinkt.openvpn.core.a aVar, boolean z) {
            this.d = z;
            this.a = BigInteger.valueOf(aVar.b());
            this.c = aVar.b;
            this.e = true;
        }

        public static /* synthetic */ boolean a(a aVar) {
            return aVar.d;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int compareTo = h().compareTo(aVar.h());
            if (compareTo != 0) {
                return compareTo;
            }
            int i = this.c;
            int i2 = aVar.c;
            if (i > i2) {
                return -1;
            }
            return i2 == i ? 0 : 1;
        }

        public boolean c(a aVar) {
            BigInteger h = h();
            BigInteger l = l();
            return (h.compareTo(aVar.h()) != 1) && (l.compareTo(aVar.l()) != -1);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            return this.c == aVar.c && aVar.h().equals(h());
        }

        public BigInteger h() {
            if (this.f == null) {
                this.f = n(false);
            }
            return this.f;
        }

        public String i() {
            long longValue = this.a.longValue();
            return String.format(Locale.US, "%d.%d.%d.%d", new Object[]{Long.valueOf((longValue >> 24) % 256), Long.valueOf((longValue >> 16) % 256), Long.valueOf((longValue >> 8) % 256), Long.valueOf(longValue % 256)});
        }

        public String j() {
            BigInteger bigInteger = this.a;
            String str = null;
            boolean z = true;
            while (bigInteger.compareTo(BigInteger.ZERO) == 1) {
                long longValue = bigInteger.mod(BigInteger.valueOf(65536L)).longValue();
                if (str != null || longValue != 0) {
                    if (str == null && !z) {
                        str = ":";
                    }
                    str = z ? String.format(Locale.US, "%x", new Object[]{Long.valueOf(longValue), str}) : String.format(Locale.US, "%x:%s", new Object[]{Long.valueOf(longValue), str});
                }
                bigInteger = bigInteger.shiftRight(16);
                z = false;
            }
            return str == null ? "::" : str;
        }

        public BigInteger l() {
            if (this.g == null) {
                this.g = n(true);
            }
            return this.g;
        }

        public final BigInteger n(boolean z) {
            BigInteger bigInteger = this.a;
            int i = this.e ? 32 - this.c : 128 - this.c;
            for (int i2 = 0; i2 < i; i2++) {
                bigInteger = z ? bigInteger.setBit(i2) : bigInteger.clearBit(i2);
            }
            return bigInteger;
        }

        public a[] o() {
            a aVar = new a(h(), this.c + 1, this.d, this.e);
            return new a[]{aVar, new a(aVar.l().add(BigInteger.ONE), this.c + 1, this.d, this.e)};
        }

        public String toString() {
            return this.e ? String.format(Locale.US, "%s/%d", new Object[]{i(), Integer.valueOf(this.c)}) : String.format(Locale.US, "%s/%d", new Object[]{j(), Integer.valueOf(this.c)});
        }

        public a(BigInteger bigInteger, int i, boolean z, boolean z2) {
            this.a = bigInteger;
            this.c = i;
            this.d = z;
            this.e = z2;
        }

        public a(Inet6Address inet6Address, int i, boolean z) {
            this.c = i;
            this.d = z;
            this.a = BigInteger.ZERO;
            int length = inet6Address.getAddress().length;
            int i2 = 128;
            for (int i3 = 0; i3 < length; i3++) {
                i2 -= 8;
                this.a = this.a.add(BigInteger.valueOf(r6[i3] & 255).shiftLeft(i2));
            }
        }
    }

    public void a(de.blinkt.openvpn.core.a aVar, boolean z) {
        this.a.add(new a(aVar, z));
    }

    public void b(Inet6Address inet6Address, int i, boolean z) {
        this.a.add(new a(inet6Address, i, z));
    }

    public void c() {
        this.a.clear();
    }

    public TreeSet d() {
        PriorityQueue priorityQueue = new PriorityQueue(this.a);
        TreeSet treeSet = new TreeSet();
        a aVar = (a) priorityQueue.poll();
        if (aVar == null) {
            return treeSet;
        }
        while (aVar != null) {
            a aVar2 = (a) priorityQueue.poll();
            if (aVar2 == null || aVar.l().compareTo(aVar2.h()) == -1) {
                treeSet.add(aVar);
            } else if (!aVar.h().equals(aVar2.h()) || aVar.c < aVar2.c) {
                if (a.a(aVar) != a.a(aVar2)) {
                    a[] o = aVar.o();
                    a aVar3 = o[1];
                    if (aVar3.c != aVar2.c) {
                        priorityQueue.add(aVar3);
                    }
                    priorityQueue.add(aVar2);
                    aVar = o[0];
                }
            } else if (a.a(aVar) != a.a(aVar2)) {
                a[] o2 = aVar2.o();
                if (!priorityQueue.contains(o2[1])) {
                    priorityQueue.add(o2[1]);
                }
                if (!o2[0].l().equals(aVar.l()) && !priorityQueue.contains(o2[0])) {
                    priorityQueue.add(o2[0]);
                }
            }
            aVar = aVar2;
        }
        return treeSet;
    }

    public Collection e(boolean z) {
        Vector vector = new Vector();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (a.a(aVar) == z) {
                vector.add(aVar);
            }
        }
        return vector;
    }

    public Collection f() {
        TreeSet d = d();
        Vector vector = new Vector();
        Iterator it = d.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (a.a(aVar)) {
                vector.add(aVar);
            }
        }
        return vector;
    }
}
