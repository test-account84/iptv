package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzeo extends zzek implements RandomAccess, zzgv, zzig {
    private static final zzeo zza = new zzeo(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    public zzeo() {
        this(new boolean[10], 0, true);
    }

    private final String zzf(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        boolean[] zArr = this.zzb;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzb, i, zArr2, i + 1, this.zzc - i);
            this.zzb = zArr2;
        }
        this.zzb[i] = booleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzgw.zzd;
        collection.getClass();
        if (!(collection instanceof zzeo)) {
            return super.addAll(collection);
        }
        zzeo zzeoVar = (zzeo) collection;
        int i = zzeoVar.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zzb;
        if (i3 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzeoVar.zzb, 0, this.zzb, this.zzc, zzeoVar.zzc);
        this.zzc = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeo)) {
            return super.equals(obj);
        }
        zzeo zzeoVar = (zzeo) obj;
        if (this.zzc != zzeoVar.zzc) {
            return false;
        }
        boolean[] zArr = zzeoVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Boolean.valueOf(this.zzb[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + zzgw.zza(this.zzb[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i = this.zzc;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzb[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzg(i);
        boolean[] zArr = this.zzb;
        boolean z = zArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i2, zArr, i, this.zzc - i2);
        this.zzc -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i);
        boolean[] zArr = this.zzb;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzgv zzd(int i) {
        if (i >= this.zzc) {
            return new zzeo(Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z) {
        zza();
        int i = this.zzc;
        boolean[] zArr = this.zzb;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        zArr3[i2] = z;
    }

    private zzeo(boolean[] zArr, int i, boolean z) {
        super(z);
        this.zzb = zArr;
        this.zzc = i;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
