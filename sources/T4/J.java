package t4;

import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j extends zzb implements k {
    public j() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                int readInt = parcel.readInt();
                zzc.zzb(parcel);
                e(readInt);
                return true;
            case 2:
                n4.d dVar = (n4.d) zzc.zza(parcel, n4.d.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean zzf = zzc.zzf(parcel);
                zzc.zzb(parcel);
                a0(dVar, readString, readString2, zzf);
                return true;
            case 3:
                int readInt2 = parcel.readInt();
                zzc.zzb(parcel);
                c(readInt2);
                return true;
            case 4:
                String readString3 = parcel.readString();
                double readDouble = parcel.readDouble();
                boolean zzf2 = zzc.zzf(parcel);
                zzc.zzb(parcel);
                J(readString3, readDouble, zzf2);
                return true;
            case 5:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                zzc.zzb(parcel);
                v0(readString4, readString5);
                return true;
            case 6:
                String readString6 = parcel.readString();
                byte[] createByteArray = parcel.createByteArray();
                zzc.zzb(parcel);
                S0(readString6, createByteArray);
                return true;
            case 7:
                int readInt3 = parcel.readInt();
                zzc.zzb(parcel);
                zze(readInt3);
                return true;
            case 8:
                int readInt4 = parcel.readInt();
                zzc.zzb(parcel);
                zzg(readInt4);
                return true;
            case 9:
                int readInt5 = parcel.readInt();
                zzc.zzb(parcel);
                zzd(readInt5);
                return true;
            case 10:
                String readString7 = parcel.readString();
                long readLong = parcel.readLong();
                int readInt6 = parcel.readInt();
                zzc.zzb(parcel);
                m(readString7, readLong, readInt6);
                return true;
            case 11:
                String readString8 = parcel.readString();
                long readLong2 = parcel.readLong();
                zzc.zzb(parcel);
                G0(readString8, readLong2);
                return true;
            case 12:
                c cVar = (c) zzc.zza(parcel, c.CREATOR);
                zzc.zzb(parcel);
                f(cVar);
                return true;
            case 13:
                e eVar = (e) zzc.zza(parcel, e.CREATOR);
                zzc.zzb(parcel);
                P(eVar);
                return true;
            case 14:
                int readInt7 = parcel.readInt();
                zzc.zzb(parcel);
                G(readInt7);
                return true;
            case 15:
                int readInt8 = parcel.readInt();
                zzc.zzb(parcel);
                N0(readInt8);
                return true;
            default:
                return false;
        }
    }
}
