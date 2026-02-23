package com.google.android.gms.internal.cast;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzun extends AbstractMap {
    private final int zza;
    private boolean zzd;
    private volatile zzul zze;
    private List zzb = Collections.emptyList();
    private Map zzc = Collections.emptyMap();
    private Map zzf = Collections.emptyMap();

    public /* synthetic */ zzun(int i, zzum zzumVar) {
        this.zza = i;
    }

    public static /* bridge */ /* synthetic */ Object zzd(zzun zzunVar, int i) {
        return zzunVar.zzl(i);
    }

    public static /* bridge */ /* synthetic */ List zzf(zzun zzunVar) {
        return zzunVar.zzb;
    }

    public static /* bridge */ /* synthetic */ Map zzh(zzun zzunVar) {
        return zzunVar.zzc;
    }

    public static /* bridge */ /* synthetic */ void zzi(zzun zzunVar) {
        zzunVar.zzn();
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size();
        int i = size - 1;
        int i2 = 0;
        if (i >= 0) {
            int compareTo = comparable.compareTo(((zzuh) this.zzb.get(i)).zza());
            if (compareTo > 0) {
                return -(size + 1);
            }
            if (compareTo == 0) {
                return i;
            }
        }
        while (i2 <= i) {
            int i3 = (i2 + i) / 2;
            int compareTo2 = comparable.compareTo(((zzuh) this.zzb.get(i3)).zza());
            if (compareTo2 < 0) {
                i = i3 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    private final Object zzl(int i) {
        zzn();
        Object value = ((zzuh) this.zzb.remove(i)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzuh(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return this.zzc;
    }

    private final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzul(this, null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        Map entrySet;
        Map entrySet2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzun)) {
            return super.equals(obj);
        }
        zzun zzunVar = (zzun) obj;
        int size = size();
        if (size != zzunVar.size()) {
            return false;
        }
        int zzb = zzb();
        if (zzb == zzunVar.zzb()) {
            for (int i = 0; i < zzb; i++) {
                if (!zzg(i).equals(zzunVar.zzg(i))) {
                    return false;
                }
            }
            if (zzb == size) {
                return true;
            }
            entrySet = this.zzc;
            entrySet2 = zzunVar.zzc;
        } else {
            entrySet = entrySet();
            entrySet2 = zzunVar.entrySet();
        }
        return entrySet.equals(entrySet2);
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        return zzk >= 0 ? ((zzuh) this.zzb.get(zzk)).getValue() : this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb; i2++) {
            i += ((zzuh) this.zzb.get(i2)).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        return this.zzc.isEmpty() ? zzug.zza() : this.zzc.entrySet();
    }

    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzuh) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zzk + 1);
        if (i >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzuh zzuhVar = (zzuh) this.zzb.remove(i2 - 1);
            zzm().put(zzuhVar.zza(), zzuhVar.getValue());
        }
        this.zzb.add(i, new zzuh(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i) {
        return (Map.Entry) this.zzb.get(i);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
