package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aaq implements Parcelable.Creator {
    private final /* synthetic */ int a;

    public aaq(int i) {
        this.a = i;
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                return new aar(parcel);
            case 1:
                return new aap(parcel);
            case 2:
                return new aas(parcel);
            case 3:
                return new aat(parcel);
            case 4:
                return new aau(parcel);
            case 5:
                return new aav(parcel);
            case 6:
                return new abb(parcel);
            case 7:
                return new abc(parcel);
            case 8:
                return new abd(parcel);
            case 9:
                return new abe(parcel);
            default:
                return new abf(parcel);
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new aar[i];
            case 1:
                return new aap[i];
            case 2:
                return new aas[i];
            case 3:
                return new aat[i];
            case 4:
                return new aau[i];
            case 5:
                return new aav[i];
            case 6:
                return new abb[i];
            case 7:
                return new abc[i];
            case 8:
                return new abd[i];
            case 9:
                return new abe[i];
            default:
                return new abf[i];
        }
    }
}
