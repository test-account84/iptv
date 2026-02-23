package v3;

import O2.R0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.ArrayList;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;
    public final y e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    }

    public m(Parcel parcel) {
        this((String) d4.a.e(parcel.readString()), parcel.readString(), y.s((String[]) d4.a.e(parcel.createStringArray())));
    }

    public static List a(String str) {
        int parseInt;
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                parseInt = Integer.parseInt(str.substring(8, 10));
            } else {
                if (str.length() < 7) {
                    if (str.length() >= 4) {
                        parseInt = Integer.parseInt(str.substring(0, 4));
                    }
                    return arrayList;
                }
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                parseInt = Integer.parseInt(str.substring(5, 7));
            }
            arrayList.add(Integer.valueOf(parseInt));
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return k0.c(this.a, mVar.a) && k0.c(this.c, mVar.c) && this.e.equals(mVar.e);
    }

    public int hashCode() {
        int hashCode = (527 + this.a.hashCode()) * 31;
        String str = this.c;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void populateMediaMetadata(R0.b bVar) {
        String str = this.a;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 21;
                    break;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case '\n':
                    bVar.N((CharSequence) this.e.get(0));
                    break;
                case 1:
                case 11:
                    bVar.S((CharSequence) this.e.get(0));
                    break;
                case 2:
                case '\f':
                    String str2 = (String) this.e.get(0);
                    bVar.f0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).e0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.O((CharSequence) this.e.get(0));
                    break;
                case 4:
                case 18:
                    bVar.M((CharSequence) this.e.get(0));
                    break;
                case 5:
                case 19:
                    bVar.T((CharSequence) this.e.get(0));
                    break;
                case 6:
                case 20:
                    String[] i1 = k0.i1((String) this.e.get(0), "/");
                    bVar.p0(Integer.valueOf(Integer.parseInt(i1[0]))).o0(i1.length > 1 ? Integer.valueOf(Integer.parseInt(i1[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.m0((CharSequence) this.e.get(0));
                    break;
                case '\b':
                case 15:
                    bVar.r0((CharSequence) this.e.get(0));
                    break;
                case '\t':
                case 21:
                    bVar.g0(Integer.valueOf(Integer.parseInt((String) this.e.get(0))));
                    break;
                case '\r':
                    List a2 = a((String) this.e.get(0));
                    int size = a2.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.e0((Integer) a2.get(2));
                            }
                        }
                        bVar.f0((Integer) a2.get(1));
                    }
                    bVar.g0((Integer) a2.get(0));
                    break;
                case 14:
                    List a3 = a((String) this.e.get(0));
                    int size2 = a3.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.h0((Integer) a3.get(2));
                            }
                        }
                        bVar.i0((Integer) a3.get(1));
                    }
                    bVar.j0((Integer) a3.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public String toString() {
        return this.a + ": description=" + this.c + ": values=" + this.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeStringArray((String[]) this.e.toArray(new String[0]));
    }

    public /* synthetic */ m(Parcel parcel, a aVar) {
        this(parcel);
    }

    public m(String str, String str2, List list) {
        super(str);
        d4.a.a(!list.isEmpty());
        this.c = str2;
        y r = y.r(list);
        this.e = r;
        this.d = (String) r.get(0);
    }
}
