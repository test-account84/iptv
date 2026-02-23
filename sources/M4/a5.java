package M4;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzpq;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a5 extends F2 {
    public static final String[] g = {"firebase_", "google_", "ga_"};
    public static final String[] h = {"_err"};
    public SecureRandom c;
    public final AtomicLong d;
    public int e;
    public Integer f;

    public a5(l2 l2Var) {
        super(l2Var);
        this.f = null;
        this.d = new AtomicLong(0L);
    }

    public static boolean Y(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean Z(String str) {
        com.google.android.gms.common.internal.r.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean a0(Context context) {
        ActivityInfo receiverInfo;
        com.google.android.gms.common.internal.r.m(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean b0(Context context, boolean z) {
        com.google.android.gms.common.internal.r.m(context);
        return k0(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean c0(String str) {
        return !h[0].equals(str);
    }

    public static final boolean f0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static final boolean g0(String str) {
        com.google.android.gms.common.internal.r.m(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    public static boolean j0(String str, String[] strArr) {
        com.google.android.gms.common.internal.r.m(strArr);
        for (String str2 : strArr) {
            if (Y4.a(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static long s0(byte[] bArr) {
        com.google.android.gms.common.internal.r.m(bArr);
        int length = bArr.length;
        int i = 0;
        com.google.android.gms.common.internal.r.p(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    public static MessageDigest t() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList v(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", dVar.f);
            bundle.putString("origin", dVar.g);
            bundle.putLong("creation_timestamp", dVar.i);
            bundle.putString("name", dVar.h.g);
            H2.b(bundle, com.google.android.gms.common.internal.r.m(dVar.h.H()));
            bundle.putBoolean("active", dVar.j);
            String str = dVar.k;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            v vVar = dVar.l;
            if (vVar != null) {
                bundle.putString("timed_out_event_name", vVar.f);
                t tVar = vVar.g;
                if (tVar != null) {
                    bundle.putBundle("timed_out_event_params", tVar.J());
                }
            }
            bundle.putLong("trigger_timeout", dVar.m);
            v vVar2 = dVar.n;
            if (vVar2 != null) {
                bundle.putString("triggered_event_name", vVar2.f);
                t tVar2 = vVar2.g;
                if (tVar2 != null) {
                    bundle.putBundle("triggered_event_params", tVar2.J());
                }
            }
            bundle.putLong("triggered_timestamp", dVar.h.h);
            bundle.putLong("time_to_live", dVar.o);
            v vVar3 = dVar.p;
            if (vVar3 != null) {
                bundle.putString("expired_event_name", vVar3.f);
                t tVar3 = vVar3.g;
                if (tVar3 != null) {
                    bundle.putBundle("expired_event_params", tVar3.J());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void y(A3 a3, Bundle bundle, boolean z) {
        if (bundle != null && a3 != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = a3.a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = a3.b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", a3.c);
                return;
            }
            z = false;
        }
        if (bundle != null && a3 == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void A(Parcelable[] parcelableArr, int i, boolean z) {
        int i2;
        com.google.android.gms.common.internal.r.m(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i3 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (Z(str) && !j0(str, M2.d) && (i3 = i3 + 1) > i) {
                    x1 s = this.a.d().s();
                    if (z) {
                        s.c("Param can't contain more than " + i + " item-scoped custom parameters", this.a.D().e(str), this.a.D().b(bundle));
                        i2 = 28;
                    } else {
                        s.c("Param cannot contain item-scoped custom parameters", this.a.D().e(str), this.a.D().b(bundle));
                        i2 = 23;
                    }
                    f0(bundle, i2);
                    bundle.remove(str);
                }
            }
        }
    }

    public final void B(A1 a1, int i) {
        int i2 = 0;
        for (String str : new TreeSet(a1.d.keySet())) {
            if (Z(str) && (i2 = i2 + 1) > i) {
                this.a.d().s().c("Event can't contain more than " + i + " params", this.a.D().d(a1.a), this.a.D().b(a1.d));
                f0(a1.d, 5);
                a1.d.remove(str);
            }
        }
    }

    public final void C(Z4 z4, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        f0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        z4.a(str, "_err", bundle);
    }

    public final void D(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.a.d().x().c("Not putting event parameter. Invalid value type. name, type", this.a.D().e(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void E(zzcf zzcfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning boolean value to wrapper", e);
        }
    }

    public final void F(zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning bundle list to wrapper", e);
        }
    }

    public final void G(zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning bundle value to wrapper", e);
        }
    }

    public final void H(zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning byte array to wrapper", e);
        }
    }

    public final void I(zzcf zzcfVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning int value to wrapper", e);
        }
    }

    public final void J(zzcf zzcfVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning long value to wrapper", e);
        }
    }

    public final void K(zzcf zzcfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            this.a.d().w().b("Error returning string value to wrapper", e);
        }
    }

    public final void L(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        String str4;
        int i2;
        int O;
        int i3;
        String str5;
        if (bundle == null) {
            return;
        }
        h z2 = this.a.z();
        zzpq.zzc();
        String str6 = null;
        int i4 = (z2.a.z().B(null, m1.B0) && z2.a.N().X(231100000, true)) ? 35 : 0;
        int i5 = 0;
        for (String str7 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str7)) {
                int o0 = !z ? o0(str7) : 0;
                if (o0 == 0) {
                    o0 = n0(str7);
                }
                i = o0;
            } else {
                i = 0;
            }
            if (i != 0) {
                x(bundle, i, str7, str7, i == 3 ? str7 : str6);
                bundle.remove(str7);
                i3 = i4;
                str5 = str6;
            } else {
                if (V(bundle.get(str7))) {
                    this.a.d().x().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str7);
                    str4 = str7;
                    i2 = i4;
                    O = 22;
                } else {
                    str4 = str7;
                    i2 = i4;
                    O = O(str, str2, str7, bundle.get(str7), bundle, list, z, false);
                }
                if (O != 0 && !"_ev".equals(str4)) {
                    x(bundle, O, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (Z(str4) && !j0(str4, M2.d)) {
                    int i6 = i5 + 1;
                    int i7 = 23;
                    if (X(231100000, true)) {
                        i3 = i2;
                        if (i6 > i3) {
                            zzpq.zzc();
                            str5 = null;
                            if (this.a.z().B(null, m1.B0)) {
                                this.a.d().s().c("Item can't contain more than " + i3 + " item-scoped custom params", this.a.D().d(str2), this.a.D().b(bundle));
                                i7 = 28;
                            } else {
                                this.a.d().s().c("Item cannot contain custom parameters", this.a.D().d(str2), this.a.D().b(bundle));
                            }
                            f0(bundle, i7);
                            bundle.remove(str4);
                        }
                        i5 = i6;
                    } else {
                        this.a.d().s().c("Item array not supported on client's version of Google Play Services (Android Only)", this.a.D().d(str2), this.a.D().b(bundle));
                        f0(bundle, 23);
                        bundle.remove(str4);
                        i3 = i2;
                    }
                    str5 = null;
                    i5 = i6;
                }
                i3 = i2;
                str5 = null;
            }
            i4 = i3;
            str6 = str5;
        }
    }

    public final boolean M(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (g0(str)) {
                return true;
            }
            if (this.a.q()) {
                this.a.d().s().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", z1.z(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.a.q()) {
                this.a.d().s().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (g0(str2)) {
            return true;
        }
        this.a.d().s().b("Invalid admob_app_id. Analytics disabled.", z1.z(str2));
        return false;
    }

    public final boolean N(String str, int i, String str2) {
        if (str2 == null) {
            this.a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        this.a.d().s().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int O(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.a5.O(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final boolean P(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        com.google.android.gms.common.internal.r.m(str2);
        String[] strArr3 = g;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.a.d().s().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !j0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && j0(str2, strArr2)) {
            return true;
        }
        this.a.d().s().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean Q(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.a.d().x().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean R(String str, String str2) {
        if (str2 == null) {
            this.a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt != 95) {
                this.a.d().s().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            codePointAt = 95;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean S(String str, String str2) {
        if (str2 == null) {
            this.a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            this.a.d().s().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean T(String str) {
        h();
        if (E4.e.a(this.a.c()).a(str) == 0) {
            return true;
        }
        this.a.d().q().b("Permission not granted", str);
        return false;
    }

    public final boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String u = this.a.z().u();
        this.a.b();
        return u.equals(str);
    }

    public final boolean V(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean W(Context context, String str) {
        x1 r;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e = E4.e.a(context).e(str, 64);
            if (e == null || (signatureArr = e.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray())).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e2) {
            e = e2;
            r = this.a.d().r();
            str2 = "Error obtaining certificate";
            r.b(str2, e);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            r = this.a.d().r();
            str2 = "Package name not found";
            r.b(str2, e);
            return true;
        }
    }

    public final boolean X(int i, boolean z) {
        Boolean J = this.a.L().J();
        if (q0() < i / 1000) {
            return (J == null || J.booleanValue()) ? false : true;
        }
        return true;
    }

    public final boolean d0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            com.google.android.gms.common.internal.r.m(str);
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final byte[] e0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final int h0(String str) {
        if ("_ldl".equals(str)) {
            this.a.z();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.a.z();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.a.z();
            return 100;
        }
        this.a.z();
        return 36;
    }

    public final void i() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.a.d().w().a("Utils falling back to Random for random id");
            }
        }
        this.d.set(nextLong);
    }

    public final Object i0(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return r(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle w0 = w0((Bundle) parcelable);
                if (!w0.isEmpty()) {
                    arrayList.add(w0);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final boolean j() {
        return true;
    }

    public final int l0(String str, Object obj) {
        int h0;
        String str2;
        if ("_ldl".equals(str)) {
            h0 = h0(str);
            str2 = "user property referrer";
        } else {
            h0 = h0(str);
            str2 = "user property";
        }
        return Q(str2, str, h0, obj) ? 0 : 7;
    }

    public final int m0(String str) {
        if (!R("event", str)) {
            return 2;
        }
        if (!P("event", L2.a, L2.b, str)) {
            return 13;
        }
        this.a.z();
        return !N("event", 40, str) ? 2 : 0;
    }

    public final int n0(String str) {
        if (!R("event param", str)) {
            return 3;
        }
        if (!P("event param", null, null, str)) {
            return 14;
        }
        this.a.z();
        return !N("event param", 40, str) ? 3 : 0;
    }

    public final Object o(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.a.z();
            return i0(256, obj, true, true);
        }
        if (Y(str)) {
            this.a.z();
        } else {
            this.a.z();
            i = 100;
        }
        return i0(i, obj, false, true);
    }

    public final int o0(String str) {
        if (!S("event param", str)) {
            return 3;
        }
        if (!P("event param", null, null, str)) {
            return 14;
        }
        this.a.z();
        return !N("event param", 40, str) ? 3 : 0;
    }

    public final Object p(String str, Object obj) {
        boolean equals = "_ldl".equals(str);
        int h0 = h0(str);
        return equals ? i0(h0, obj, true, false) : i0(h0, obj, false, false);
    }

    public final int p0(String str) {
        if (!R("user property", str)) {
            return 6;
        }
        if (!P("user property", N2.a, null, str)) {
            return 15;
        }
        this.a.z();
        return !N("user property", 24, str) ? 6 : 0;
    }

    public final String q() {
        byte[] bArr = new byte[16];
        u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final int q0() {
        if (this.f == null) {
            this.f = Integer.valueOf(w4.i.h().b(this.a.c()) / 1000);
        }
        return this.f.intValue();
    }

    public final String r(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public final int r0(int i) {
        return w4.i.h().j(this.a.c(), 12451000);
    }

    public final URL s(long j, String str, String str2, long j2) {
        try {
            com.google.android.gms.common.internal.r.g(str2);
            com.google.android.gms.common.internal.r.g(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{79000L, Integer.valueOf(q0())}), str2, str, Long.valueOf(j2)});
            if (str.equals(this.a.z().v())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException e) {
            e = e;
            this.a.d().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e2) {
            e = e2;
            this.a.d().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final long t0() {
        long j = this.d.get();
        synchronized (this.d) {
            if (j != 0) {
                this.d.compareAndSet(-1L, 1L);
                return this.d.getAndIncrement();
            }
            long nextLong = new Random(System.nanoTime() ^ this.a.a().a()).nextLong();
            int i = this.e + 1;
            this.e = i;
            return nextLong + i;
        }
    }

    public final SecureRandom u() {
        h();
        if (this.c == null) {
            this.c = new SecureRandom();
        }
        return this.c;
    }

    public final long u0(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    public final Bundle v0(Uri uri, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("utm_id");
                str6 = uri.getQueryParameter("dclid");
                str7 = uri.getQueryParameter("srsltid");
                str8 = z ? uri.getQueryParameter("sfmc_id") : null;
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && (!z || TextUtils.isEmpty(str8))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("campaign_id", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("dclid", str6);
            }
            String queryParameter6 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("source_platform", queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("creative_format", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("marketing_tactic", queryParameter8);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("srsltid", str7);
            }
            if (z && !TextUtils.isEmpty(str8)) {
                bundle.putString("sfmc_id", str8);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            this.a.d().w().b("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final void w(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.a.d().w().b("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final Bundle w0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object o = o(str, bundle.get(str));
                if (o == null) {
                    this.a.d().x().b("Param value can't be null", this.a.D().e(str));
                } else {
                    D(bundle2, str, o);
                }
            }
        }
        return bundle2;
    }

    public final void x(Bundle bundle, int i, String str, String str2, Object obj) {
        if (f0(bundle, i)) {
            this.a.z();
            bundle.putString("_ev", r(str, 40, true));
            if (obj != null) {
                com.google.android.gms.common.internal.r.m(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle x0(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.a5.x0(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    public final v y0(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m0(str2) != 0) {
            this.a.d().r().b("Invalid conditional property event name", this.a.D().f(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle x0 = x0(str, str2, bundle2, C4.f.a("_o"), true);
        if (z) {
            x0 = w0(x0);
        }
        com.google.android.gms.common.internal.r.m(x0);
        return new v(str2, new t(x0), str3, j);
    }

    public final void z(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.a.N().D(bundle, str, bundle2.get(str));
            }
        }
    }
}
