package com.google.android.gms.internal.firebase_messaging;

import c6.c;
import c6.d;
import c6.e;
import c6.f;
import c6.g;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzu implements f {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final d zzb;
    private static final d zzc;
    private static final e zzd;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final e zzh;
    private final zzy zzi = new zzy(this);

    static {
        d.b a = d.a("key");
        zzo zzoVar = new zzo();
        zzoVar.zza(1);
        zzb = a.b(zzoVar.zzb()).a();
        d.b a2 = d.a("value");
        zzo zzoVar2 = new zzo();
        zzoVar2.zza(2);
        zzc = a2.b(zzoVar2.zzb()).a();
        zzd = zzt.zza;
    }

    public zzu(OutputStream outputStream, Map map, Map map2, e eVar) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = eVar;
    }

    public static /* synthetic */ void zzg(Map.Entry entry, f fVar) throws IOException {
        fVar.add(zzb, entry.getKey());
        fVar.add(zzc, entry.getValue());
    }

    private static int zzh(d dVar) {
        zzs zzsVar = (zzs) dVar.c(zzs.class);
        if (zzsVar != null) {
            return zzsVar.zza();
        }
        throw new c("Field has no @Protobuf config");
    }

    private final long zzi(e eVar, Object obj) throws IOException {
        zzp zzpVar = new zzp();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzpVar;
            try {
                eVar.encode(obj, this);
                this.zze = outputStream;
                long zza2 = zzpVar.zza();
                zzpVar.close();
                return zza2;
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzpVar.close();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    private static zzs zzj(d dVar) {
        zzs zzsVar = (zzs) dVar.c(zzs.class);
        if (zzsVar != null) {
            return zzsVar;
        }
        throw new c("Field has no @Protobuf config");
    }

    private final zzu zzk(e eVar, d dVar, Object obj, boolean z) throws IOException {
        long zzi = zzi(eVar, obj);
        if (z && zzi == 0) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 2);
        zzo(zzi);
        eVar.encode(obj, this);
        return this;
    }

    private final zzu zzl(g gVar, d dVar, Object obj, boolean z) throws IOException {
        this.zzi.zza(dVar, z);
        gVar.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i) throws IOException {
        while (true) {
            long j = i & (-128);
            OutputStream outputStream = this.zze;
            if (j == 0) {
                outputStream.write(i & 127);
                return;
            } else {
                outputStream.write((i & 127) | 128);
                i >>>= 7;
            }
        }
    }

    private final void zzo(long j) throws IOException {
        while (true) {
            long j2 = (-128) & j;
            OutputStream outputStream = this.zze;
            if (j2 == 0) {
                outputStream.write(((int) j) & 127);
                return;
            } else {
                outputStream.write((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }

    public final f add(d dVar, double d) throws IOException {
        zza(dVar, d, true);
        return this;
    }

    public final f inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    public final f nested(d dVar) throws IOException {
        throw new c("nested() is not implemented for protobuf encoding.");
    }

    public final f zza(d dVar, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d).array());
        return this;
    }

    public final f zzb(d dVar, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f).array());
        return this;
    }

    public final f zzc(d dVar, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                zzc(dVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzk(zzd, dVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            zza(dVar, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            zzb(dVar, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            zze(dVar, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            zzd(dVar, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            zzn((zzh(dVar) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
        }
        e eVar = (e) this.zzf.get(obj.getClass());
        if (eVar != null) {
            zzk(eVar, dVar, obj, z);
            return this;
        }
        g gVar = (g) this.zzg.get(obj.getClass());
        if (gVar != null) {
            zzl(gVar, dVar, obj, z);
            return this;
        }
        if (obj instanceof zzq) {
            zzd(dVar, ((zzq) obj).getNumber(), true);
            return this;
        }
        if (obj instanceof Enum) {
            zzd(dVar, ((Enum) obj).ordinal(), true);
            return this;
        }
        zzk(this.zzh, dVar, obj, z);
        return this;
    }

    public final zzu zzd(d dVar, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzs zzj = zzj(dVar);
        zzr zzrVar = zzr.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzn(i);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzn((i + i) ^ (i >> 31));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 5);
            this.zze.write(zzm(4).putInt(i).array());
        }
        return this;
    }

    public final zzu zze(d dVar, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzs zzj = zzj(dVar);
        zzr zzrVar = zzr.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzo(j);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzo((j >> 63) ^ (j + j));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 1);
            this.zze.write(zzm(8).putLong(j).array());
        }
        return this;
    }

    public final zzu zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        e eVar = (e) this.zzf.get(obj.getClass());
        if (eVar == null) {
            throw new c("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        eVar.encode(obj, this);
        return this;
    }

    public final f add(d dVar, float f) throws IOException {
        zzb(dVar, f, true);
        return this;
    }

    public final f nested(String str) throws IOException {
        return nested(d.d(str));
    }

    public final /* synthetic */ f add(d dVar, int i) throws IOException {
        zzd(dVar, i, true);
        return this;
    }

    public final /* synthetic */ f add(d dVar, long j) throws IOException {
        zze(dVar, j, true);
        return this;
    }

    public final f add(d dVar, Object obj) throws IOException {
        zzc(dVar, obj, true);
        return this;
    }

    public final /* synthetic */ f add(d dVar, boolean z) throws IOException {
        zzd(dVar, z ? 1 : 0, true);
        return this;
    }

    public final f add(String str, double d) throws IOException {
        zza(d.d(str), d, true);
        return this;
    }

    public final f add(String str, int i) throws IOException {
        zzd(d.d(str), i, true);
        return this;
    }

    public final f add(String str, long j) throws IOException {
        zze(d.d(str), j, true);
        return this;
    }

    public final f add(String str, Object obj) throws IOException {
        zzc(d.d(str), obj, true);
        return this;
    }

    public final f add(String str, boolean z) throws IOException {
        zzd(d.d(str), z ? 1 : 0, true);
        return this;
    }
}
