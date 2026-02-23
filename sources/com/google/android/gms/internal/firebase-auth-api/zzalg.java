package com.google.android.gms.internal.firebase-auth-api;

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
class zzalg extends AbstractMap {
    private final int zza;
    private List zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzals zze;
    private Map zzf;
    private volatile zzalk zzg;

    private zzalg(int i) {
        this.zza = i;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    private final Object zzc(int i) {
        zzg();
        Object value = ((zzalr) this.zzb.remove(i)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzf().entrySet().iterator();
            this.zzb.add(new zzalr(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return this.zzc;
    }

    private final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzals(this, null);
        }
        return this.zze;
    }

    public boolean equals(Object obj) {
        Set set;
        Set set2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzalg)) {
            return super.equals(obj);
        }
        zzalg zzalgVar = (zzalg) obj;
        int size = size();
        if (size != zzalgVar.size()) {
            return false;
        }
        int zza = zza();
        if (zza != zzalgVar.zza()) {
            set = entrySet();
            set2 = zzalgVar.entrySet();
        } else {
            for (int i = 0; i < zza; i++) {
                if (!zzb(i).equals(zzalgVar.zzb(i))) {
                    return false;
                }
            }
            if (zza == size) {
                return true;
            }
            set = this.zzc;
            set2 = zzalgVar.zzc;
        }
        return set.equals(set2);
    }

    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? ((zzalr) this.zzb.get(zza)).getValue() : this.zzc.get(comparable);
    }

    public int hashCode() {
        int zza = zza();
        int i = 0;
        for (int i2 = 0; i2 < zza; i2++) {
            i += ((zzalr) this.zzb.get(i2)).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    public Object remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzc(zza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final Iterable zzb() {
        return this.zzc.isEmpty() ? zzalm.zza() : this.zzc.entrySet();
    }

    public void zzd() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public /* synthetic */ zzalg(int i, zzalu zzaluVar) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zza(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.zzb
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L25
            java.util.List r2 = r4.zzb
            java.lang.Object r2 = r2.get(r1)
            com.google.android.gms.internal.firebase-auth-api.zzalr r2 = (com.google.android.gms.internal.firebase-auth-api.zzalr) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L22
            int r0 = r0 + 1
        L20:
            int r5 = -r0
            return r5
        L22:
            if (r2 != 0) goto L25
            return r1
        L25:
            r0 = 0
        L26:
            if (r0 > r1) goto L49
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.zzb
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.firebase-auth-api.zzalr r3 = (com.google.android.gms.internal.firebase-auth-api.zzalr) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L43
            int r1 = r2 + (-1)
            goto L26
        L43:
            if (r3 <= 0) goto L48
            int r0 = r2 + 1
            goto L26
        L48:
            return r2
        L49:
            int r0 = r0 + 1
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzalg.zza(java.lang.Comparable):int");
    }

    public static /* bridge */ /* synthetic */ Map zzc(zzalg zzalgVar) {
        return zzalgVar.zzf;
    }

    public static /* synthetic */ void zzd(zzalg zzalgVar) {
        zzalgVar.zzg();
    }

    public final Map.Entry zzb(int i) {
        return (Map.Entry) this.zzb.get(i);
    }

    public static zzalg zza(int i) {
        return new zzalj(i);
    }

    public static /* bridge */ /* synthetic */ Map zzb(zzalg zzalgVar) {
        return zzalgVar.zzc;
    }

    public final Set zzc() {
        if (this.zzg == null) {
            this.zzg = new zzalk(this, null);
        }
        return this.zzg;
    }

    public static /* synthetic */ Object zza(zzalg zzalgVar, int i) {
        return zzalgVar.zzc(i);
    }

    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzg();
        int zza = zza(comparable);
        if (zza >= 0) {
            return ((zzalr) this.zzb.get(zza)).setValue(obj);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zza + 1);
        if (i >= this.zza) {
            return zzf().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzalr zzalrVar = (zzalr) this.zzb.remove(i2 - 1);
            zzf().put((Comparable) zzalrVar.getKey(), zzalrVar.getValue());
        }
        this.zzb.add(i, new zzalr(this, comparable, obj));
        return null;
    }

    public static /* bridge */ /* synthetic */ List zza(zzalg zzalgVar) {
        return zzalgVar.zzb;
    }
}
