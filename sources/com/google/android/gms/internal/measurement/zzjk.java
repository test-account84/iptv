package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzjk implements zzmi {
    protected int zzb = 0;

    public static void zzbw(Iterable iterable, List list) {
        byte[] bArr = zzlj.zzd;
        iterable.getClass();
        if (iterable instanceof zzlq) {
            List zzh = ((zzlq) iterable).zzh();
            zzlq zzlqVar = (zzlq) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzlqVar.size() - size) + " is null.";
                    int size2 = zzlqVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzlqVar.remove(size2);
                    }
                } else if (obj instanceof zzka) {
                    zzlqVar.zzi((zzka) obj);
                } else {
                    zzlqVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzmp) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
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

    public int zzbu(zzmt zzmtVar) {
        throw null;
    }

    public final zzka zzbv() {
        try {
            int zzbz = zzbz();
            zzka zzkaVar = zzka.zzb;
            byte[] bArr = new byte[zzbz];
            zzki zzz = zzki.zzz(bArr, 0, zzbz);
            zzbQ(zzz);
            zzz.zzA();
            return new zzjx(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzbx() {
        try {
            int zzbz = zzbz();
            byte[] bArr = new byte[zzbz];
            zzki zzz = zzki.zzz(bArr, 0, zzbz);
            zzbQ(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
