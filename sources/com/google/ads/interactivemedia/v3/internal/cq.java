package com.google.ads.interactivemedia.v3.internal;

import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cq {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static HashMap j;
    private static final String[] k;
    private static final String[] l;
    private static final int[] m;
    private static final int[] n;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2;
        String str = Build.DEVICE;
        b = str;
        String str2 = Build.MANUFACTURER;
        c = str2;
        String str3 = Build.MODEL;
        d = str3;
        e = str + ", " + str3 + ", " + str2 + ", " + i2;
        f = new byte[0];
        g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        i = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        k = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        l = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        m = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        n = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A() {
        return B(null);
    }

    public static Handler B(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        af.t(myLooper);
        return z(myLooper, callback);
    }

    public static Handler C() {
        return z(D(), null);
    }

    public static Looper D() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static s E(int i2, int i3, int i4) {
        r rVar = new r();
        rVar.ae("audio/raw");
        rVar.H(i3);
        rVar.af(i4);
        rVar.Y(i2);
        return rVar.v();
    }

    public static aw F(az azVar, aw awVar) {
        boolean r = azVar.r();
        boolean e2 = azVar.e();
        h hVar = (h) azVar;
        boolean z = hVar.b() != -1;
        boolean z2 = hVar.a() != -1;
        boolean d2 = azVar.d();
        boolean c2 = azVar.c();
        boolean p = azVar.o().p();
        av avVar = new av();
        avVar.c(awVar);
        boolean z3 = !r;
        avVar.e(4, z3);
        avVar.e(5, e2 && !r);
        avVar.e(6, z && !r);
        avVar.e(7, !p && (z || !d2 || e2) && !r);
        avVar.e(8, z2 && !r);
        avVar.e(9, !p && (z2 || (d2 && c2)) && !r);
        avVar.e(10, z3);
        avVar.e(11, e2 && !r);
        avVar.e(12, e2 && !r);
        return avVar.a();
    }

    public static Object G(Object obj) {
        return obj;
    }

    public static String H(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String I(byte[] bArr) {
        return new String(bArr, ath.b);
    }

    public static String J(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, ath.b);
    }

    public static String K(String str, int i2) {
        String[] am = am(str);
        if (am.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : am) {
            if (i2 == ar.c(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String L(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int length = objArr.length;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < length - 1) {
                sb.append(", ");
            }
            i2++;
        }
    }

    public static String M(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return com.google.ads.interactivemedia.v3.impl.data.k.e(networkCountryIso);
            }
        }
        return com.google.ads.interactivemedia.v3.impl.data.k.e(Locale.getDefault().getCountry());
    }

    public static String N(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static String O(Locale locale) {
        return a >= 21 ? locale.toLanguageTag() : locale.toString();
    }

    public static String P(int i2) {
        switch (i2) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            default:
                return "camera motion";
        }
    }

    public static String Q(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String d2 = com.google.ads.interactivemedia.v3.impl.data.k.d(str);
        int i2 = 0;
        String str2 = al(d2, "-")[0];
        if (j == null) {
            j = ay();
        }
        String str3 = (String) j.get(str2);
        if (str3 != null) {
            d2 = str3.concat(String.valueOf(d2.substring(str2.length())));
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return d2;
        }
        while (true) {
            String[] strArr = l;
            int length = strArr.length;
            if (i2 >= 18) {
                return d2;
            }
            if (d2.startsWith(strArr[i2])) {
                return String.valueOf(strArr[i2 + 1]).concat(String.valueOf(d2.substring(strArr[i2].length())));
            }
            i2 += 2;
        }
    }

    public static ExecutorService R(String str) {
        return Executors.newSingleThreadExecutor(new cp(str));
    }

    public static void S(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void T(List list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        }
        if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static void U(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean V(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean W(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (V(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean X(int i2) {
        return i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static boolean Y(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static boolean Z(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static float a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static boolean aa(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean ab(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean ac(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static byte[] ad(String str) {
        return str.getBytes(ath.b);
    }

    public static byte[] ae(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Object[] af(Object[] objArr) {
        return objArr;
    }

    public static Object[] ag(Object[] objArr, Object obj) {
        int length = objArr.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + 1);
        copyOf[length] = obj;
        return copyOf;
    }

    public static Object[] ah(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + length2);
        System.arraycopy(objArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static Object[] ai(Object[] objArr, int i2) {
        af.u(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static String[] aj() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] ak = a >= 24 ? ak(d.k.a(d.f.a(configuration)), ",") : new String[]{O(configuration.locale)};
        for (int i2 = 0; i2 < ak.length; i2++) {
            ak[i2] = Q(ak[i2]);
        }
        return ak;
    }

    public static String[] ak(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] al(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String[] am(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : ak(str.trim(), "(\\s*,\\s*)");
    }

    public static long an(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j2 ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static int ao(long[] jArr, long j2, boolean z) {
        int i2;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        while (true) {
            i2 = binarySearch + 1;
            if (i2 >= jArr.length || jArr[i2] != j2) {
                break;
            }
            binarySearch = i2;
        }
        return !z ? i2 : binarySearch;
    }

    public static int ap(List list, Comparable comparable, boolean z) {
        int i2;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            while (true) {
                int i3 = binarySearch - 1;
                if (i3 < 0 || ((Comparable) list.get(i3)).compareTo(comparable) != 0) {
                    break;
                }
                binarySearch = i3;
            }
            i2 = binarySearch;
        }
        return z ? Math.max(0, i2) : i2;
    }

    public static int aq(long[] jArr, long j2, boolean z) {
        int i2;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            while (true) {
                int i3 = binarySearch - 1;
                if (i3 < 0 || jArr[i3] != j2) {
                    break;
                }
                binarySearch = i3;
            }
            i2 = binarySearch;
        }
        return z ? Math.max(0, i2) : i2;
    }

    public static int ar(byte[] bArr, int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = m[(i3 >>> 24) ^ (bArr[i4] & 255)] ^ (i3 << 8);
        }
        return i3;
    }

    public static String as(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "?";
        }
        return "IMA SDK ExoPlayer/" + str + " (Linux;Android " + Build.VERSION.RELEASE + ") AndroidXMedia3/1.0.0-beta02";
    }

    public static void at(Handler handler, Runnable runnable) {
        if (handler.getLooper().getThread().isAlive()) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static void au(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (a < 33) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            g1.T.a(context, broadcastReceiver, intentFilter, 4);
        }
    }

    public static void av(long[] jArr, long j2) {
        int i2 = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
            return;
        }
        if (j2 >= 1000000 || 1000000 % j2 != 0) {
            double d2 = 1000000.0d / j2;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (jArr[i2] * d2);
                i2++;
            }
            return;
        }
        long j4 = 1000000 / j2;
        while (i2 < jArr.length) {
            jArr[i2] = jArr[i2] * j4;
            i2++;
        }
    }

    public static long aw(long j2, long j3) {
        long j4 = j2 - j3;
        if (((j2 ^ j4) & (j3 ^ j2)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    private static String ax(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            cd.c("Util", "Failed to read system property ".concat(str), e2);
            return null;
        }
    }

    private static HashMap ay() {
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int length2 = k.length;
        HashMap hashMap = new HashMap(length + 88);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = k;
            int length3 = strArr.length;
            if (i2 >= 88) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static int b(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int binarySearch = Arrays.binarySearch(iArr, i2);
        if (binarySearch < 0) {
            i4 = -(binarySearch + 2);
        } else {
            while (true) {
                i3 = binarySearch - 1;
                if (i3 < 0 || iArr[i3] != i2) {
                    break;
                }
                binarySearch = i3;
            }
            i4 = z ? binarySearch : i3;
        }
        return z2 ? Math.max(0, i4) : i4;
    }

    public static int c(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int d(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static int e(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int f(int i2) {
        if (i2 == 12) {
            return a >= 32 ? 743676 : 0;
        }
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i3 = a;
                return (i3 < 23 && i3 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int g(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i3 : Integer.reverseBytes(i3);
    }

    public static int h(String str, int i2) {
        int i3 = 0;
        for (String str2 : am(str)) {
            if (i2 == ar.c(str2)) {
                i3++;
            }
        }
        return i3;
    }

    public static int i(int i2) {
        if (i2 == 2 || i2 == 4) {
            return 6005;
        }
        if (i2 == 10) {
            return 6004;
        }
        if (i2 == 7) {
            return 6005;
        }
        if (i2 == 8) {
            return 6003;
        }
        switch (i2) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int j(String str) {
        String[] ak;
        int length;
        int i2 = 0;
        if (str == null || (length = (ak = ak(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = ak[length - 1];
        boolean z = length >= 3 && "neg".equals(ak[length + (-2)]);
        try {
            af.s(str2);
            i2 = Integer.parseInt(str2);
            if (z) {
                return -i2;
            }
        } catch (NumberFormatException unused) {
        }
        return i2;
    }

    public static int k(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int l(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 268435456) {
                    if (i2 == 536870912) {
                        return i3 * 3;
                    }
                    if (i2 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i3 * 4;
        }
        return i3 + i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(android.net.Uri r7) {
        /*
            java.lang.String r0 = r7.getScheme()
            r1 = 3
            if (r0 == 0) goto L11
            java.lang.String r2 = "rtsp"
            boolean r0 = com.google.ads.interactivemedia.v3.impl.data.k.f(r2, r0)
            if (r0 != 0) goto L10
            goto L11
        L10:
            return r1
        L11:
            java.lang.String r0 = r7.getLastPathSegment()
            r2 = 4
            if (r0 != 0) goto L19
            return r2
        L19:
            r3 = 46
            int r3 = r0.lastIndexOf(r3)
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 < 0) goto L71
            int r3 = r3 + r6
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r0 = com.google.ads.interactivemedia.v3.impl.data.k.d(r0)
            int r3 = r0.hashCode()
            switch(r3) {
                case 104579: goto L53;
                case 108321: goto L49;
                case 3242057: goto L3f;
                case 3299913: goto L35;
                default: goto L34;
            }
        L34:
            goto L5d
        L35:
            java.lang.String r3 = "m3u8"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5d
            r0 = 1
            goto L5e
        L3f:
            java.lang.String r3 = "isml"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5d
            r0 = 3
            goto L5e
        L49:
            java.lang.String r3 = "mpd"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5d
            r0 = 0
            goto L5e
        L53:
            java.lang.String r3 = "ism"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5d
            r0 = 2
            goto L5e
        L5d:
            r0 = -1
        L5e:
            if (r0 == 0) goto L6c
            if (r0 == r6) goto L6a
            if (r0 == r5) goto L68
            if (r0 == r1) goto L68
            r0 = 4
            goto L6d
        L68:
            r0 = 1
            goto L6d
        L6a:
            r0 = 2
            goto L6d
        L6c:
            r0 = 0
        L6d:
            if (r0 != r2) goto L70
            goto L71
        L70:
            return r0
        L71:
            java.util.regex.Pattern r0 = com.google.ads.interactivemedia.v3.internal.cq.i
            java.lang.String r7 = r7.getPath()
            com.google.ads.interactivemedia.v3.internal.af.s(r7)
            java.util.regex.Matcher r7 = r0.matcher(r7)
            boolean r0 = r7.matches()
            if (r0 == 0) goto L9d
            java.lang.String r7 = r7.group(r5)
            if (r7 == 0) goto L9c
            java.lang.String r0 = "format=mpd-time-csf"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L93
            return r4
        L93:
            java.lang.String r0 = "format=m3u8-aapl"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L9c
            return r5
        L9c:
            return r6
        L9d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cq.m(android.net.Uri):int");
    }

    public static int n(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static long o(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    public static long p(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static long q(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }

    public static long r(long j2) {
        return j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime();
    }

    public static long s(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / f2);
    }

    public static long t(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static long u(String str) throws as {
        Matcher matcher = g.matcher(str);
        if (!matcher.matches()) {
            throw as.a("Invalid date/time format: ".concat(String.valueOf(str)), null);
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i2 = -i2;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0.".concat(String.valueOf(matcher.group(8)))).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
    }

    public static long v(String str) {
        Matcher matcher = h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
        return isEmpty ? -parseDouble6 : parseDouble6;
    }

    public static long w(long j2, long j3, long j4) {
        return (j4 < j3 || j4 % j3 != 0) ? (j4 >= j3 || j3 % j4 != 0) ? (long) (j2 * (j3 / j4)) : j2 * (j3 / j4) : j2 / (j4 / j3);
    }

    public static long x(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static Point y(Context context) {
        DisplayManager displayManager;
        int i2 = a;
        Display display = null;
        if (i2 >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            display = displayManager.getDisplay(0);
        }
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            af.s(windowManager);
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && ab(context)) {
            String ax = ax(i2 < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(ax)) {
                try {
                    String[] ak = ak(ax.trim(), "x");
                    if (ak.length == 2) {
                        int parseInt = Integer.parseInt(ak[0]);
                        int parseInt2 = Integer.parseInt(ak[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                cd.b("Util", "Invalid display size: ".concat(String.valueOf(ax)));
            }
            if ("Sony".equals(c) && d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i3 = a;
        if (i3 >= 23) {
            Display.Mode a2 = L.a(display);
            point.x = M.a(a2);
            point.y = N.a(a2);
            return point;
        }
        if (i3 >= 17) {
            display.getRealSize(point);
            return point;
        }
        display.getSize(point);
        return point;
    }

    public static Handler z(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }
}
