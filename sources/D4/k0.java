package d4;

import O2.H0;
import O2.l1;
import O2.t1;
import O2.z0;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
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
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class k0 {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    public static final Pattern g;
    public static final Pattern h;
    public static final Pattern i;
    public static final Pattern j;
    public static HashMap k;
    public static final String[] l;
    public static final String[] m;
    public static final int[] n;
    public static final int[] o;

    public static final class a {
        public static Drawable a(Context context, Resources resources, int i) {
            return resources.getDrawable(i, context.getTheme());
        }
    }

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
        i = Pattern.compile("%([A-Fa-f0-9]{2})");
        j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A(Handler.Callback callback) {
        return w(S(), callback);
    }

    public static String A0(int i2) {
        return Integer.toString(i2, 36);
    }

    public static HashMap B() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap hashMap = new HashMap(iSOLanguages.length + l.length);
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
            String[] strArr = l;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static boolean B0(Context context) {
        return a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static Uri C(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = j.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static boolean C0(int i2) {
        return i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static String D(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean D0(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static String E(byte[] bArr) {
        return new String(bArr, r5.d.c);
    }

    public static boolean E0(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static String F(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, r5.d.c);
    }

    public static boolean F0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static int G(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static boolean G0(Uri uri) {
        if (!"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        List pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return false;
        }
        String str = (String) pathSegments.get(0);
        return "external".equals(str) || "external_primary".equals(str);
    }

    public static String H(int i2) {
        if (i2 == 0) {
            return "application/dash+xml";
        }
        if (i2 == 1) {
            return "application/vnd.ms-sstr+xml";
        }
        if (i2 != 2) {
            return null;
        }
        return "application/x-mpegURL";
    }

    public static boolean H0(Uri uri) {
        return "http".equals(uri.getScheme()) && !f0.a(e0.a(), (String) d4.a.e(uri.getHost()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int I(int r2) {
        /*
            r0 = 6396(0x18fc, float:8.963E-42)
            switch(r2) {
                case 1: goto L28;
                case 2: goto L25;
                case 3: goto L22;
                case 4: goto L1f;
                case 5: goto L1c;
                case 6: goto L19;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L5;
                case 10: goto Lb;
                case 11: goto L5;
                case 12: goto L7;
                default: goto L5;
            }
        L5:
            r2 = 0
            return r2
        L7:
            r2 = 743676(0xb58fc, float:1.042112E-39)
            return r2
        Lb:
            int r2 = d4.k0.a
            r1 = 32
            if (r2 < r1) goto L15
            r2 = 737532(0xb40fc, float:1.033502E-39)
            return r2
        L15:
            return r0
        L16:
            r2 = 1276(0x4fc, float:1.788E-42)
            return r2
        L19:
            r2 = 252(0xfc, float:3.53E-43)
            return r2
        L1c:
            r2 = 220(0xdc, float:3.08E-43)
            return r2
        L1f:
            r2 = 204(0xcc, float:2.86E-43)
            return r2
        L22:
            r2 = 28
            return r2
        L25:
            r2 = 12
            return r2
        L28:
            r2 = 4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.k0.I(int):int");
    }

    public static boolean I0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static t1.b J(t1 t1Var, t1.b bVar) {
        boolean d2 = t1Var.d();
        boolean V = t1Var.V();
        boolean M = t1Var.M();
        boolean q = t1Var.q();
        boolean g0 = t1Var.g0();
        boolean u = t1Var.u();
        boolean v = t1Var.w().v();
        boolean z = false;
        t1.b.a d3 = new t1.b.a().b(bVar).d(4, !d2).d(5, V && !d2).d(6, M && !d2).d(7, !v && (M || !g0 || V) && !d2).d(8, q && !d2).d(9, !v && (q || (g0 && u)) && !d2).d(10, !d2).d(11, V && !d2);
        if (V && !d2) {
            z = true;
        }
        return d3.d(12, z).e();
    }

    public static /* synthetic */ Thread J0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int K(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i3 : Integer.reverseBytes(i3);
    }

    public static int K0(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static byte[] L(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public static String L0(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = m;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                return strArr[i2 + 1] + str.substring(strArr[i2].length());
            }
            i2 += 2;
        }
    }

    public static int M(String str, int i2) {
        int i3 = 0;
        for (String str2 : k1(str)) {
            if (i2 == F.m(str2)) {
                i3++;
            }
        }
        return i3;
    }

    public static boolean M0(Activity activity, Uri uri) {
        return a >= 23 && (F0(uri) || G0(uri)) && b1(activity);
    }

    public static String N(String str, int i2) {
        String[] k1 = k1(str);
        if (k1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : k1) {
            if (i2 == F.m(str2)) {
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

    public static boolean N0(Activity activity, H0... h0Arr) {
        if (a < 23) {
            return false;
        }
        for (H0 h0 : h0Arr) {
            H0.h hVar = h0.c;
            if (hVar != null) {
                if (M0(activity, hVar.a)) {
                    return true;
                }
                s5.y yVar = h0.c.h;
                for (int i2 = 0; i2 < yVar.size(); i2++) {
                    if (M0(activity, ((H0.k) yVar.get(i2)).a)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String O(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static boolean O0(Activity activity, Uri... uriArr) {
        if (a < 23) {
            return false;
        }
        for (Uri uri : uriArr) {
            if (M0(activity, uri)) {
                return true;
            }
        }
        return false;
    }

    public static String P(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return r5.b.f(networkCountryIso);
            }
        }
        return r5.b.f(Locale.getDefault().getCountry());
    }

    public static long P0(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static Point Q(Context context) {
        DisplayManager displayManager;
        Display display = (a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) d4.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return R(context, display);
    }

    public static ExecutorService Q0(String str) {
        return Executors.newSingleThreadExecutor(new j0(str));
    }

    public static Point R(Context context, Display display) {
        if (display.getDisplayId() == 0 && I0(context)) {
            String q0 = q0(a < 28 ? "sys.display-size" : "vendor.display-size");
            if (!TextUtils.isEmpty(q0)) {
                try {
                    String[] i1 = i1(q0.trim(), "x");
                    if (i1.length == 2) {
                        int parseInt = Integer.parseInt(i1[0]);
                        int parseInt2 = Integer.parseInt(i1[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                B.d("Util", "Invalid display size: " + q0);
            }
            if ("Sony".equals(c) && d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i2 = a;
        if (i2 >= 23) {
            W(display, point);
        } else if (i2 >= 17) {
            V(display, point);
        } else {
            U(display, point);
        }
        return point;
    }

    public static String R0(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String e2 = r5.b.e(str);
        String str2 = j1(e2, "-")[0];
        if (k == null) {
            k = B();
        }
        String str3 = (String) k.get(str2);
        if (str3 != null) {
            e2 = str3 + e2.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? L0(e2) : e2;
    }

    public static Looper S() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static Object[] S0(Object[] objArr, Object obj) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        copyOf[objArr.length] = obj;
        return k(copyOf);
    }

    public static Locale T() {
        return a >= 24 ? d0.a(c0.a()) : Locale.getDefault();
    }

    public static Object[] T0(Object[] objArr, Object[] objArr2) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, copyOf, objArr.length, objArr2.length);
        return copyOf;
    }

    public static void U(Display display, Point point) {
        display.getSize(point);
    }

    public static Object[] U0(Object[] objArr, int i2) {
        d4.a.a(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static void V(Display display, Point point) {
        display.getRealSize(point);
    }

    public static Object[] V0(Object[] objArr, int i2, int i3) {
        d4.a.a(i2 >= 0);
        d4.a.a(i3 <= objArr.length);
        return Arrays.copyOfRange(objArr, i2, i3);
    }

    public static void W(Display display, Point point) {
        Display.Mode a2 = com.google.ads.interactivemedia.v3.internal.L.a(display);
        point.x = com.google.ads.interactivemedia.v3.internal.M.a(a2);
        point.y = com.google.ads.interactivemedia.v3.internal.N.a(a2);
    }

    public static long W0(String str) {
        Matcher matcher = g.matcher(str);
        if (!matcher.matches()) {
            throw l1.a("Invalid date/time format: " + str, null);
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
    }

    public static Drawable X(Context context, Resources resources, int i2) {
        return a >= 21 ? a.a(context, resources, i2) : resources.getDrawable(i2);
    }

    public static long X0(String str) {
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

    public static UUID Y(String str) {
        String e2 = r5.b.e(str);
        e2.hashCode();
        switch (e2) {
            case "playready":
                return O2.o.e;
            case "widevine":
                return O2.o.d;
            case "clearkey":
                return O2.o.c;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static boolean Y0(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static int Z(int i2) {
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

    public static boolean Z0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        return J0(str, runnable);
    }

    public static int a0(String str) {
        String[] i1;
        int length;
        if (str == null || (length = (i1 = i1(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = i1[length - 1];
        boolean z = length >= 3 && "neg".equals(i1[length - 2]);
        try {
            int parseInt = Integer.parseInt((String) d4.a.e(str2));
            return z ? -parseInt : parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static void a1(List list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        }
        if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static long b(long j2, long j3, long j4) {
        long j5 = j2 + j3;
        return ((j2 ^ j5) & (j3 ^ j5)) < 0 ? j4 : j5;
    }

    public static String b0(int i2) {
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

    public static boolean b1(Activity activity) {
        if (h0.a(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        i0.a(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static String c0(Locale locale) {
        return a >= 21 ? d0(locale) : locale.toString();
    }

    public static long c1(long j2, long j3, long j4) {
        if (j4 >= j3 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (j4 < j3 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        return (long) (j2 * (j3 / j4));
    }

    public static int d(List list, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i3 = ~binarySearch;
        } else {
            int size = list.size();
            while (true) {
                i2 = binarySearch + 1;
                if (i2 >= size || ((Comparable) list.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                binarySearch = i2;
            }
            i3 = z ? binarySearch : i2;
        }
        return z2 ? Math.min(list.size() - 1, i3) : i3;
    }

    public static String d0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long[] d1(List list, long j2, long j3) {
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < size) {
                jArr[i2] = ((Long) list.get(i2)).longValue() / j4;
                i2++;
            }
        } else if (j3 >= j2 || j2 % j3 != 0) {
            double d2 = j2 / j3;
            while (i2 < size) {
                jArr[i2] = (long) (((Long) list.get(i2)).longValue() * d2);
                i2++;
            }
        } else {
            long j5 = j2 / j3;
            while (i2 < size) {
                jArr[i2] = ((Long) list.get(i2)).longValue() * j5;
                i2++;
            }
        }
        return jArr;
    }

    public static int e(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i3 = ~binarySearch;
        } else {
            while (true) {
                i2 = binarySearch + 1;
                if (i2 >= jArr.length || jArr[i2] != j2) {
                    break;
                }
                binarySearch = i2;
            }
            i3 = z ? binarySearch : i2;
        }
        return z2 ? Math.min(jArr.length - 1, i3) : i3;
    }

    public static int e0(Context context, String str, boolean z) {
        return (a < 29 || context.getApplicationContext().getApplicationInfo().targetSdkVersion < 29) ? 1 : 5;
    }

    public static void e1(long[] jArr, long j2, long j3) {
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j4;
                i2++;
            }
            return;
        }
        if (j3 >= j2 || j2 % j3 != 0) {
            double d2 = j2 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (jArr[i2] * d2);
                i2++;
            }
            return;
        }
        long j5 = j2 / j3;
        while (i2 < jArr.length) {
            jArr[i2] = jArr[i2] * j5;
            i2++;
        }
    }

    public static int f(C c2, long j2, boolean z, boolean z2) {
        int i2;
        int c3 = c2.c() - 1;
        int i3 = 0;
        while (i3 <= c3) {
            int i4 = (i3 + c3) >>> 1;
            if (c2.b(i4) < j2) {
                i3 = i4 + 1;
            } else {
                c3 = i4 - 1;
            }
        }
        if (z && (i2 = c3 + 1) < c2.c() && c2.b(i2) == j2) {
            return i2;
        }
        if (z2 && c3 == -1) {
            return 0;
        }
        return c3;
    }

    public static long f0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }

    public static boolean f1(t1 t1Var) {
        return t1Var == null || !t1Var.E() || t1Var.getPlaybackState() == 1 || t1Var.getPlaybackState() == 4;
    }

    public static int g(List list, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((Comparable) list.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                binarySearch = i2;
            }
            i3 = z ? binarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static long g0(long j2) {
        return j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime();
    }

    public static void g1(Throwable th) {
        h1(th);
    }

    public static int h(int[] iArr, int i2, boolean z, boolean z2) {
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

    public static int h0(int i2) {
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

    public static int i(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || jArr[i2] != j2) {
                    break;
                }
                binarySearch = i2;
            }
            i3 = z ? binarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static z0 i0(int i2, int i3, int i4) {
        return new z0.b().g0("audio/raw").J(i3).h0(i4).a0(i2).G();
    }

    public static String[] i1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int j0(int i2, int i3) {
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
        return i3 * 2;
    }

    public static String[] j1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static long k0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / f2);
    }

    public static String[] k1(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : i1(str.trim(), "(\\s*,\\s*)");
    }

    public static int l(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int l0(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static ComponentName l1(Context context, Intent intent) {
        return a >= 26 ? g0.a(context, intent) : context.startService(intent);
    }

    public static long m(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    public static String m0(StringBuilder sb, Formatter formatter, long j2) {
        long j3 = j2 == -9223372036854775807L ? 0L : j2;
        String str = j3 < 0 ? "-" : "";
        long abs = (Math.abs(j3) + 500) / 1000;
        long j4 = abs % 60;
        long j5 = (abs / 60) % 60;
        long j6 = abs / 3600;
        sb.setLength(0);
        return (j6 > 0 ? formatter.format("%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)}) : formatter.format("%s%02d:%02d", new Object[]{str, Long.valueOf(j5), Long.valueOf(j4)})).toString();
    }

    public static long m1(long j2, long j3, long j4) {
        long j5 = j2 - j3;
        return ((j2 ^ j5) & (j3 ^ j2)) < 0 ? j4 : j5;
    }

    public static boolean n(H0... h0Arr) {
        if (a < 24) {
            return true;
        }
        for (H0 h0 : h0Arr) {
            H0.h hVar = h0.c;
            if (hVar != null) {
                if (H0(hVar.a)) {
                    return false;
                }
                for (int i2 = 0; i2 < h0.c.h.size(); i2++) {
                    if (H0(((H0.k) h0.c.h.get(i2)).a)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String[] n0() {
        String[] o0 = o0();
        for (int i2 = 0; i2 < o0.length; i2++) {
            o0[i2] = R0(o0[i2]);
        }
        return o0;
    }

    public static long n1(long... jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        return j2;
    }

    public static void o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String[] o0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return a >= 24 ? p0(configuration) : new String[]{c0(configuration.locale)};
    }

    public static boolean o1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static int p(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static String[] p0(Configuration configuration) {
        return i1(d.k.a(d.f.a(configuration)), ",");
    }

    public static byte[] p1(InputStream inputStream) {
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

    public static float q(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static String q0(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            B.e("Util", "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static float q1(byte[] bArr) {
        d4.a.a(bArr.length == 4);
        return Float.intBitsToFloat((bArr[3] & 255) | (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8));
    }

    public static int r(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static String r0(int i2) {
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
            case 6:
                return "camera motion";
            default:
                if (i2 < 10000) {
                    return "?";
                }
                return "custom (" + i2 + ")";
        }
    }

    public static String r1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i2] & 15, 16));
        }
        return sb.toString();
    }

    public static long s(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static byte[] s0(String str) {
        return str.getBytes(r5.d.c);
    }

    public static int s1(byte[] bArr) {
        d4.a.a(bArr.length == 4);
        return bArr[3] | (bArr[0] << 24) | (bArr[1] << 16) | (bArr[2] << 8);
    }

    public static boolean t(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean t0(t1 t1Var) {
        if (t1Var == null || !t1Var.t(1)) {
            return false;
        }
        t1Var.pause();
        return true;
    }

    public static long t1(int i2, int i3) {
        return u1(i3) | (u1(i2) << 32);
    }

    public static int u(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = n[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean u0(O2.t1 r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = r4.getPlaybackState()
            r2 = 1
            if (r1 != r2) goto L17
            r3 = 2
            boolean r3 = r4.t(r3)
            if (r3 == 0) goto L17
            r4.prepare()
        L15:
            r0 = 1
            goto L24
        L17:
            r3 = 4
            if (r1 != r3) goto L24
            boolean r1 = r4.t(r3)
            if (r1 == 0) goto L24
            r4.g()
            goto L15
        L24:
            boolean r1 = r4.t(r2)
            if (r1 == 0) goto L2e
            r4.play()
            goto L2f
        L2e:
            r2 = r0
        L2f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.k0.u0(O2.t1):boolean");
    }

    public static long u1(int i2) {
        return i2 & 4294967295L;
    }

    public static int v(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = o[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    public static boolean v0(t1 t1Var) {
        return f1(t1Var) ? u0(t1Var) : t0(t1Var);
    }

    public static CharSequence v1(CharSequence charSequence, int i2) {
        return charSequence.length() <= i2 ? charSequence : charSequence.subSequence(0, i2);
    }

    public static Handler w(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static int w0(Uri uri) {
        int x0;
        String scheme = uri.getScheme();
        if (scheme != null && r5.b.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0 && (x0 = x0(lastPathSegment.substring(lastIndexOf + 1))) != 4) {
            return x0;
        }
        Matcher matcher = j.matcher((CharSequence) d4.a.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (group.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static String w1(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        StringBuilder sb = new StringBuilder(i5);
        Matcher matcher = i.matcher(str);
        while (i3 > 0 && matcher.find()) {
            char parseInt = (char) Integer.parseInt((String) d4.a.e(matcher.group(1)), 16);
            sb.append(str, i2, matcher.start());
            sb.append(parseInt);
            i2 = matcher.end();
            i3--;
        }
        if (i2 < length) {
            sb.append(str, i2, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    public static Handler x() {
        return y(null);
    }

    public static int x0(String str) {
        String e2 = r5.b.e(str);
        e2.hashCode();
        switch (e2) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static long x1(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static Handler y(Handler.Callback callback) {
        return w((Looper) d4.a.i(Looper.myLooper()), callback);
    }

    public static int y0(Uri uri, String str) {
        if (str == null) {
            return w0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static void y1(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static Handler z() {
        return A(null);
    }

    public static boolean z0(M m2, M m3, Inflater inflater) {
        if (m2.a() <= 0) {
            return false;
        }
        if (m3.b() < m2.a()) {
            m3.c(m2.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(m2.e(), m2.f(), m2.a());
        int i2 = 0;
        while (true) {
            try {
                i2 += inflater.inflate(m3.e(), i2, m3.b() - i2);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (i2 == m3.b()) {
                        m3.c(m3.b() * 2);
                    }
                } else {
                    m3.T(i2);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static void h1(Throwable th) {
        throw th;
    }

    public static Object j(Object obj) {
        return obj;
    }

    public static Object[] k(Object[] objArr) {
        return objArr;
    }
}
