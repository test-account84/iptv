package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class avx extends avi implements Set {
    private transient avo a;

    private static avx j(int i, Object... objArr) {
        if (i == 0) {
            return axf.a;
        }
        if (i == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return n(obj);
        }
        int k = k(i);
        Object[] objArr2 = new Object[k];
        int i2 = k - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            axo.k(obj2, i5);
            int hashCode = obj2.hashCode();
            int E = axo.E(hashCode);
            while (true) {
                int i6 = E & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += hashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                E++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new axm(obj4);
        }
        if (k(i4) < k / 2) {
            return j(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new axf(objArr, i3, objArr2, i2, i4);
    }

    public static int k(int i) {
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            atp.f(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    public static avx l(Collection collection) {
        if ((collection instanceof avx) && !(collection instanceof SortedSet)) {
            avx avxVar = (avx) collection;
            if (!avxVar.f()) {
                return avxVar;
            }
        }
        Object[] array = collection.toArray();
        return j(array.length, array);
    }

    public static avx m(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? j(length, (Object[]) objArr.clone()) : n(objArr[0]) : axf.a;
    }

    public static avx n(Object obj) {
        return new axm(obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public avo d() {
        avo avoVar = this.a;
        if (avoVar != null) {
            return avoVar;
        }
        avo i = i();
        this.a = i;
        return i;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public abstract axq iterator();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof avx) && h() && ((avx) obj).h() && hashCode() != obj.hashCode()) {
            return false;
        }
        return axo.g(this, obj);
    }

    public boolean h() {
        return false;
    }

    public int hashCode() {
        return axo.b(this);
    }

    public avo i() {
        return avo.k(toArray());
    }

    public Object writeReplace() {
        return new avw(toArray());
    }
}
