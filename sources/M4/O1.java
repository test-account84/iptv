package M4;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o1 extends zzbn implements p1 {
    public o1() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        List y;
        switch (i) {
            case 1:
                v vVar = (v) zzbo.zza(parcel, v.CREATOR);
                f5 f5Var = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                N(vVar, f5Var);
                parcel2.writeNoException();
                return true;
            case 2:
                V4 v4 = (V4) zzbo.zza(parcel, V4.CREATOR);
                f5 f5Var2 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                a1(v4, f5Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                f5 f5Var3 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                r(f5Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                v vVar2 = (v) zzbo.zza(parcel, v.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzbo.zzc(parcel);
                g(vVar2, readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                f5 f5Var4 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                u0(f5Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                f5 f5Var5 = (f5) zzbo.zza(parcel, f5.CREATOR);
                boolean zzf = zzbo.zzf(parcel);
                zzbo.zzc(parcel);
                y = y(f5Var5, zzf);
                parcel2.writeNoException();
                parcel2.writeTypedList(y);
                return true;
            case 9:
                v vVar3 = (v) zzbo.zza(parcel, v.CREATOR);
                String readString3 = parcel.readString();
                zzbo.zzc(parcel);
                byte[] F = F(vVar3, readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(F);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                zzbo.zzc(parcel);
                C(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                f5 f5Var6 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                String I = I(f5Var6);
                parcel2.writeNoException();
                parcel2.writeString(I);
                return true;
            case 12:
                d dVar = (d) zzbo.zza(parcel, d.CREATOR);
                f5 f5Var7 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                P0(dVar, f5Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                d dVar2 = (d) zzbo.zza(parcel, d.CREATOR);
                zzbo.zzc(parcel);
                C0(dVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzf2 = zzbo.zzf(parcel);
                f5 f5Var8 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                y = b(readString7, readString8, zzf2, f5Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(y);
                return true;
            case 15:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                boolean zzf3 = zzbo.zzf(parcel);
                zzbo.zzc(parcel);
                y = b0(readString9, readString10, readString11, zzf3);
                parcel2.writeNoException();
                parcel2.writeTypedList(y);
                return true;
            case 16:
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                f5 f5Var9 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                y = s0(readString12, readString13, f5Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(y);
                return true;
            case 17:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                zzbo.zzc(parcel);
                y = l0(readString14, readString15, readString16);
                parcel2.writeNoException();
                parcel2.writeTypedList(y);
                return true;
            case 18:
                f5 f5Var10 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                T0(f5Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                f5 f5Var11 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                z0(bundle, f5Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                f5 f5Var12 = (f5) zzbo.zza(parcel, f5.CREATOR);
                zzbo.zzc(parcel);
                j0(f5Var12);
                parcel2.writeNoException();
                return true;
        }
    }
}
