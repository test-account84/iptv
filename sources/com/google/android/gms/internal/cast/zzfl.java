package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzfl extends zzfd implements Set {
    private transient zzfh zza;

    public static int zzh(int i) {
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    public static zzfl zzj(Collection collection) {
        Object[] array = collection.toArray();
        return zzm(array.length, array);
    }

    public static zzfl zzk() {
        return zzfu.zza;
    }

    private static zzfl zzm(int i, Object... objArr) {
        if (i == 0) {
            return zzfu.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzfw(obj);
        }
        int zzh = zzh(i);
        Object[] objArr2 = new Object[zzh];
        int i2 = zzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzfn.zza(obj2, i5);
            int hashCode = obj2.hashCode();
            int zza = zzfa.zza(hashCode);
            while (true) {
                int i6 = zza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += hashCode;
                    i4++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    zza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzfw(obj4);
        }
        if (zzh(i4) < zzh / 2) {
            return zzm(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfu(objArr, i3, objArr2, i2, i4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfl) && zzl() && ((zzfl) obj).zzl() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (NullPointerException | ClassCastException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzfv.zza(this);
    }

    public zzfh zzd() {
        zzfh zzfhVar = this.zza;
        if (zzfhVar != null) {
            return zzfhVar;
        }
        zzfh zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public abstract zzfx iterator();

    public zzfh zzi() {
        Object[] array = toArray();
        int i = zzfh.zzd;
        return zzfh.zzi(array, array.length);
    }

    public boolean zzl() {
        return false;
    }
}
