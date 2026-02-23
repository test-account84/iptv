package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzei implements zzhy {
    protected int zza = 0;

    public static void zzc(Iterable iterable, List list) {
        byte[] bArr = zzgw.zzd;
        iterable.getClass();
        if (iterable instanceof zzhg) {
            List zzh = ((zzhg) iterable).zzh();
            zzhg zzhgVar = (zzhg) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzhgVar.size() - size) + " is null.";
                    int size2 = zzhgVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzhgVar.remove(size2);
                    }
                } else if (obj instanceof zzez) {
                    zzhgVar.zzi((zzez) obj);
                } else {
                    zzhgVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzig) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    public int zza(zzil zzilVar) {
        throw null;
    }

    public final zzez zzb() {
        try {
            int zzn = zzn();
            zzez zzezVar = zzez.zzb;
            byte[] bArr = new byte[zzn];
            zzfk zzA = zzfk.zzA(bArr, 0, zzn);
            zze(zzA);
            zzA.zzB();
            return new zzew(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzd() {
        try {
            int zzn = zzn();
            byte[] bArr = new byte[zzn];
            zzfk zzA = zzfk.zzA(bArr, 0, zzn);
            zze(zzA);
            zzA.zzB();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
