package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzz extends zzak {
    private final int zza;
    private int zzb;

    public zzz(int i, int i2) {
        zzs.zzb(i2, i, "index");
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzb = i + 1;
        return zza(i);
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb - 1;
        this.zzb = i;
        return zza(i);
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract Object zza(int i);
}
