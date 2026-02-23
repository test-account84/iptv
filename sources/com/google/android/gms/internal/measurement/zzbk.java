package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbk extends zzaw {
    public zzbk() {
        this.zza.add(zzbl.zzd);
        this.zza.add(zzbl.zzo);
        this.zza.add(zzbl.zzr);
        this.zza.add(zzbl.zzs);
        this.zza.add(zzbl.zzy);
        this.zza.add(zzbl.zzH);
        this.zza.add(zzbl.zzJ);
        this.zza.add(zzbl.zzK);
        this.zza.add(zzbl.zzX);
        this.zza.add(zzbl.zzag);
        this.zza.add(zzbl.zzak);
        this.zza.add(zzbl.zzal);
        this.zza.add(zzbl.zzam);
    }

    public final zzap zza(String str, zzg zzgVar, List list) {
        String str2;
        int i = 0;
        zzbl zzblVar = zzbl.zza;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 3) {
            zzh.zzh(zzbl.zzd.name(), 2, list);
            zzap zzb = zzgVar.zzb((zzap) list.get(0));
            if (!(zzb instanceof zzat)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[]{zzb.getClass().getCanonicalName()}));
            }
            if (!zzgVar.zzh(zzb.zzi())) {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[]{zzb.zzi()}));
            }
            zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
            zzgVar.zzg(zzb.zzi(), zzb2);
            return zzb2;
        }
        if (ordinal == 14) {
            zzh.zzi(zzbl.zzo.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            }
            for (int i2 = 0; i2 < list.size() - 1; i2 += 2) {
                zzap zzb3 = zzgVar.zzb((zzap) list.get(i2));
                if (!(zzb3 instanceof zzat)) {
                    throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[]{zzb3.getClass().getCanonicalName()}));
                }
                zzgVar.zzf(zzb3.zzi(), zzgVar.zzb((zzap) list.get(i2 + 1)));
            }
            return zzap.zzf;
        }
        if (ordinal == 24) {
            zzh.zzi(zzbl.zzy.name(), 1, list);
            zzap zzapVar = zzap.zzf;
            while (i < list.size()) {
                zzapVar = zzgVar.zzb((zzap) list.get(i));
                if (zzapVar instanceof zzag) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return zzapVar;
        }
        if (ordinal == 33) {
            zzh.zzh(zzbl.zzH.name(), 1, list);
            zzap zzb4 = zzgVar.zzb((zzap) list.get(0));
            if (zzb4 instanceof zzat) {
                return zzgVar.zzd(zzb4.zzi());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[]{zzb4.getClass().getCanonicalName()}));
        }
        if (ordinal == 49) {
            zzh.zzh(zzbl.zzX.name(), 0, list);
            return zzap.zzg;
        }
        if (ordinal == 58) {
            zzh.zzh(zzbl.zzag.name(), 3, list);
            zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
            zzap zzb6 = zzgVar.zzb((zzap) list.get(1));
            zzap zzb7 = zzgVar.zzb((zzap) list.get(2));
            if (zzb5 == zzap.zzf || zzb5 == zzap.zzg) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[]{zzb6.zzi(), zzb5.zzi()}));
            }
            if ((zzb5 instanceof zzae) && (zzb6 instanceof zzah)) {
                ((zzae) zzb5).zzq(zzb6.zzh().intValue(), zzb7);
            } else if (zzb5 instanceof zzal) {
                ((zzal) zzb5).zzr(zzb6.zzi(), zzb7);
            }
            return zzb7;
        }
        if (ordinal == 17) {
            if (list.isEmpty()) {
                return new zzae();
            }
            zzae zzaeVar = new zzae();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzap zzb8 = zzgVar.zzb((zzap) it.next());
                if (zzb8 instanceof zzag) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                zzaeVar.zzq(i, zzb8);
                i++;
            }
            return zzaeVar;
        }
        if (ordinal == 18) {
            if (list.isEmpty()) {
                return new zzam();
            }
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            }
            zzam zzamVar = new zzam();
            while (i < list.size() - 1) {
                zzap zzb9 = zzgVar.zzb((zzap) list.get(i));
                zzap zzb10 = zzgVar.zzb((zzap) list.get(i + 1));
                if ((zzb9 instanceof zzag) || (zzb10 instanceof zzag)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                zzamVar.zzr(zzb9.zzi(), zzb10);
                i += 2;
            }
            return zzamVar;
        }
        if (ordinal == 35 || ordinal == 36) {
            zzh.zzh(zzbl.zzK.name(), 2, list);
            zzap zzb11 = zzgVar.zzb((zzap) list.get(0));
            zzap zzb12 = zzgVar.zzb((zzap) list.get(1));
            if ((zzb11 instanceof zzae) && zzh.zzk(zzb12)) {
                return ((zzae) zzb11).zze(zzb12.zzh().intValue());
            }
            if (zzb11 instanceof zzal) {
                return ((zzal) zzb11).zzf(zzb12.zzi());
            }
            if (zzb11 instanceof zzat) {
                if ("length".equals(zzb12.zzi())) {
                    return new zzah(Double.valueOf(zzb11.zzi().length()));
                }
                if (zzh.zzk(zzb12) && zzb12.zzh().doubleValue() < zzb11.zzi().length()) {
                    return new zzat(String.valueOf(zzb11.zzi().charAt(zzb12.zzh().intValue())));
                }
            }
            return zzap.zzf;
        }
        switch (ordinal) {
            case 62:
                zzh.zzh(zzbl.zzak.name(), 1, list);
                zzap zzb13 = zzgVar.zzb((zzap) list.get(0));
                if (zzb13 instanceof zzau) {
                    str2 = "undefined";
                } else if (zzb13 instanceof zzaf) {
                    str2 = "boolean";
                } else if (zzb13 instanceof zzah) {
                    str2 = "number";
                } else if (zzb13 instanceof zzat) {
                    str2 = "string";
                } else if (zzb13 instanceof zzao) {
                    str2 = "function";
                } else {
                    if ((zzb13 instanceof zzaq) || (zzb13 instanceof zzag)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{zzb13}));
                    }
                    str2 = "object";
                }
                return new zzat(str2);
            case 63:
                zzh.zzh(zzbl.zzal.name(), 0, list);
                return zzap.zzf;
            case 64:
                zzh.zzi(zzbl.zzam.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzap zzb14 = zzgVar.zzb((zzap) it2.next());
                    if (!(zzb14 instanceof zzat)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[]{zzb14.getClass().getCanonicalName()}));
                    }
                    zzgVar.zze(zzb14.zzi(), zzap.zzf);
                }
                return zzap.zzf;
            default:
                return super.zzb(str);
        }
    }
}
