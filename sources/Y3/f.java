package Y3;

import P3.b;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import d4.B;
import d4.M;
import d4.k0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    public static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
    public static final Map c;
    public static final Map d;

    public static class b {
        public static final Comparator c = new g();
        public final c a;
        public final int b;

        public b(c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        public static /* synthetic */ int a(b bVar, b bVar2) {
            return e(bVar, bVar2);
        }

        public static /* synthetic */ Comparator b() {
            return c;
        }

        public static /* synthetic */ c c(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ int d(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.a.b, bVar2.a.b);
        }

        public /* synthetic */ b(c cVar, int i, a aVar) {
            this(cVar, i);
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final String c;
        public final Set d;

        public c(String str, int i, String str2, Set set) {
            this.b = i;
            this.a = str;
            this.c = str2;
            this.d = set;
        }

        public static c a(String str, int i) {
            String str2;
            String trim = str.trim();
            d4.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] i1 = k0.i1(trim, "\\.");
            String str3 = i1[0];
            HashSet hashSet = new HashSet();
            for (int i2 = 1; i2 < i1.length; i2++) {
                hashSet.add(i1[i2]);
            }
            return new c(str3, i, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    public static final class d implements Comparable {
        public final int a;
        public final Y3.d c;

        public d(int i, Y3.d dVar) {
            this.a = i;
            this.c = dVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.a, dVar.a);
        }
    }

    public static final class e {
        public CharSequence c;
        public long a = 0;
        public long b = 0;
        public int d = 2;
        public float e = -3.4028235E38f;
        public int f = 1;
        public int g = 0;
        public float h = -3.4028235E38f;
        public int i = Integer.MIN_VALUE;
        public float j = 1.0f;
        public int k = Integer.MIN_VALUE;

        public static float b(float f, int i) {
            if (f == -3.4028235E38f || i != 0 || (f >= 0.0f && f <= 1.0f)) {
                return f != -3.4028235E38f ? f : i == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        public static Layout.Alignment c(int i) {
            if (i != 1) {
                if (i == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            B.j("WebvttCueParser", "Unknown textAlignment: " + i);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i, float f) {
            if (i == 0) {
                return 1.0f - f;
            }
            if (i == 1) {
                return f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            }
            if (i == 2) {
                return f;
            }
            throw new IllegalStateException(String.valueOf(i));
        }

        public static float e(int i) {
            if (i != 4) {
                return i != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return i != 5 ? 1 : 2;
            }
            return 0;
        }

        public Y3.e a() {
            return new Y3.e(g().a(), this.a, this.b);
        }

        public b.b g() {
            float f = this.h;
            if (f == -3.4028235E38f) {
                f = e(this.d);
            }
            int i = this.i;
            if (i == Integer.MIN_VALUE) {
                i = f(this.d);
            }
            b.b r = new b.b().p(c(this.d)).h(b(this.e, this.f), this.f).i(this.g).k(f).l(i).n(Math.min(this.j, d(i, f))).r(this.k);
            CharSequence charSequence = this.c;
            if (charSequence != null) {
                r.o(charSequence);
            }
            return r;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        d = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i, int i2) {
        BackgroundColorSpan foregroundColorSpan;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = c;
            if (map.containsKey(str)) {
                foregroundColorSpan = new ForegroundColorSpan(((Integer) map.get(str)).intValue());
            } else {
                Map map2 = d;
                if (map2.containsKey(str)) {
                    foregroundColorSpan = new BackgroundColorSpan(((Integer) map2.get(str)).intValue());
                }
            }
            spannableStringBuilder.setSpan(foregroundColorSpan, i, i2, 33);
        }
    }

    public static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        str.hashCode();
        switch (str) {
            case "gt":
                c2 = '>';
                break;
            case "lt":
                c2 = '<';
                break;
            case "amp":
                c2 = '&';
                break;
            case "nbsp":
                c2 = ' ';
                break;
            default:
                B.j("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
        spannableStringBuilder.append(c2);
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int i = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.b());
        int i2 = cVar.b;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(b.c((b) arrayList.get(i4)).a)) {
                b bVar = (b) arrayList.get(i4);
                int g = g(i(list2, str, b.c(bVar)), i, 1);
                int i5 = b.c(bVar).b - i3;
                int d2 = b.d(bVar) - i3;
                CharSequence subSequence = spannableStringBuilder.subSequence(i5, d2);
                spannableStringBuilder.delete(i5, d2);
                spannableStringBuilder.setSpan(new T3.c(subSequence.toString(), g), i2, i5, 33);
                i3 += subSequence.length();
                i2 = i5;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[LOOP:0: B:37:0x0098->B:39:0x009e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(java.lang.String r9, Y3.f.c r10, java.util.List r11, android.text.SpannableStringBuilder r12, java.util.List r13) {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            int r3 = r10.b
            int r4 = r12.length()
            java.lang.String r5 = r10.a
            r5.hashCode()
            r6 = 33
            r7 = -1
            int r8 = r5.hashCode()
            switch(r8) {
                case 0: goto L67;
                case 98: goto L5c;
                case 99: goto L51;
                case 105: goto L46;
                case 117: goto L3b;
                case 118: goto L30;
                case 3314158: goto L25;
                case 3511770: goto L1a;
                default: goto L18;
            }
        L18:
            goto L71
        L1a:
            java.lang.String r8 = "ruby"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L23
            goto L71
        L23:
            r7 = 7
            goto L71
        L25:
            java.lang.String r8 = "lang"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L2e
            goto L71
        L2e:
            r7 = 6
            goto L71
        L30:
            java.lang.String r8 = "v"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L39
            goto L71
        L39:
            r7 = 5
            goto L71
        L3b:
            java.lang.String r8 = "u"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L44
            goto L71
        L44:
            r7 = 4
            goto L71
        L46:
            java.lang.String r8 = "i"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L4f
            goto L71
        L4f:
            r7 = 3
            goto L71
        L51:
            java.lang.String r8 = "c"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L5a
            goto L71
        L5a:
            r7 = 2
            goto L71
        L5c:
            java.lang.String r8 = "b"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L65
            goto L71
        L65:
            r7 = 1
            goto L71
        L67:
            java.lang.String r8 = ""
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L70
            goto L71
        L70:
            r7 = 0
        L71:
            switch(r7) {
                case 0: goto L94;
                case 1: goto L8e;
                case 2: goto L88;
                case 3: goto L82;
                case 4: goto L79;
                case 5: goto L94;
                case 6: goto L94;
                case 7: goto L75;
                default: goto L74;
            }
        L74:
            return
        L75:
            c(r12, r9, r10, r11, r13)
            goto L94
        L79:
            android.text.style.UnderlineSpan r11 = new android.text.style.UnderlineSpan
            r11.<init>()
        L7e:
            r12.setSpan(r11, r3, r4, r6)
            goto L94
        L82:
            android.text.style.StyleSpan r11 = new android.text.style.StyleSpan
            r11.<init>(r0)
            goto L7e
        L88:
            java.util.Set r11 = r10.d
            a(r12, r11, r3, r4)
            goto L94
        L8e:
            android.text.style.StyleSpan r11 = new android.text.style.StyleSpan
            r11.<init>(r2)
            goto L7e
        L94:
            java.util.List r9 = h(r13, r9, r10)
        L98:
            int r10 = r9.size()
            if (r1 >= r10) goto Lab
            java.lang.Object r10 = r9.get(r1)
            Y3.f$d r10 = (Y3.f.d) r10
            Y3.d r10 = r10.c
            e(r12, r10, r3, r4)
            int r1 = r1 + r2
            goto L98
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.f.d(java.lang.String, Y3.f$c, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(android.text.SpannableStringBuilder r4, Y3.d r5, int r6, int r7) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            int r0 = r5.i()
            r1 = -1
            r2 = 33
            if (r0 == r1) goto L18
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            int r1 = r5.i()
            r0.<init>(r1)
            T3.d.a(r4, r0, r6, r7, r2)
        L18:
            boolean r0 = r5.l()
            if (r0 == 0) goto L26
            android.text.style.StrikethroughSpan r0 = new android.text.style.StrikethroughSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L26:
            boolean r0 = r5.m()
            if (r0 == 0) goto L34
            android.text.style.UnderlineSpan r0 = new android.text.style.UnderlineSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L34:
            boolean r0 = r5.k()
            if (r0 == 0) goto L46
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            int r1 = r5.c()
            r0.<init>(r1)
            T3.d.a(r4, r0, r6, r7, r2)
        L46:
            boolean r0 = r5.j()
            if (r0 == 0) goto L58
            android.text.style.BackgroundColorSpan r0 = new android.text.style.BackgroundColorSpan
            int r1 = r5.a()
            r0.<init>(r1)
            T3.d.a(r4, r0, r6, r7, r2)
        L58:
            java.lang.String r0 = r5.d()
            if (r0 == 0) goto L6a
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            java.lang.String r1 = r5.d()
            r0.<init>(r1)
            T3.d.a(r4, r0, r6, r7, r2)
        L6a:
            int r0 = r5.f()
            r1 = 1
            if (r0 == r1) goto L92
            r1 = 2
            if (r0 == r1) goto L88
            r1 = 3
            if (r0 == r1) goto L78
            goto L9d
        L78:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r3 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r3
            r0.<init>(r1)
        L84:
            T3.d.a(r4, r0, r6, r7, r2)
            goto L9d
        L88:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r0.<init>(r1)
            goto L84
        L92:
            android.text.style.AbsoluteSizeSpan r0 = new android.text.style.AbsoluteSizeSpan
            float r3 = r5.e()
            int r3 = (int) r3
            r0.<init>(r3, r1)
            goto L84
        L9d:
            boolean r5 = r5.b()
            if (r5 == 0) goto Lab
            T3.a r5 = new T3.a
            r5.<init>()
            r4.setSpan(r5, r6, r7, r2)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.f.e(android.text.SpannableStringBuilder, Y3.d, int, int):void");
    }

    public static int f(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    public static int g(int i, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    public static List h(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Y3.d dVar = (Y3.d) list.get(i);
            int h = dVar.h(str, cVar.a, cVar.d, cVar.c);
            if (h > 0) {
                arrayList.add(new d(h, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List list, String str, c cVar) {
        List h = h(list, str, cVar);
        for (int i = 0; i < h.size(); i++) {
            Y3.d dVar = ((d) h.get(i)).c;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String trim = str.trim();
        d4.a.a(!trim.isEmpty());
        return k0.j1(trim, "[ \\.]")[0];
    }

    public static boolean k(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static P3.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.c = charSequence;
        return eVar.g().a();
    }

    public static Y3.e m(M m, List list) {
        String s = m.s();
        if (s == null) {
            return null;
        }
        Pattern pattern = a;
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return n(null, matcher, m, list);
        }
        String s2 = m.s();
        if (s2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(s2);
        if (matcher2.matches()) {
            return n(s.trim(), matcher2, m, list);
        }
        return null;
    }

    public static Y3.e n(String str, Matcher matcher, M m, List list) {
        e eVar = new e();
        try {
            eVar.a = i.d((String) d4.a.e(matcher.group(1)));
            eVar.b = i.d((String) d4.a.e(matcher.group(2)));
            p((String) d4.a.e(matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String s = m.s();
                if (TextUtils.isEmpty(s)) {
                    eVar.c = q(str, sb.toString(), list);
                    return eVar.a();
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(s.trim());
            }
        } catch (NumberFormatException unused) {
            B.j("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    public static b.b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    public static void p(String str, e eVar) {
        Matcher matcher = b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) d4.a.e(matcher.group(1));
            String str3 = (String) d4.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.d = v(str3);
                } else if ("position".equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.k = w(str3);
                } else {
                    B.j("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                B.j("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString q(String str, String str2, List list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (charAt == '&') {
                i++;
                int indexOf = str2.indexOf(59, i);
                int indexOf2 = str2.indexOf(32, i);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i++;
            } else {
                int i2 = i + 1;
                if (i2 < str2.length()) {
                    boolean z = str2.charAt(i2) == '/';
                    i2 = f(str2, i2);
                    int i3 = i2 - 2;
                    boolean z2 = str2.charAt(i3) == '/';
                    int i4 = i + (z ? 2 : 1);
                    if (!z2) {
                        i3 = i2 - 1;
                    }
                    String substring = str2.substring(i4, i3);
                    if (!substring.trim().isEmpty()) {
                        String j = j(substring);
                        if (k(j)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length(), null));
                                    }
                                    if (cVar.a.equals(j)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                arrayDeque.push(c.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i = i2;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static int r(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                B.j("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.e = i.c(str);
            eVar.f = 0;
        } else {
            eVar.e = Integer.parseInt(str);
            eVar.f = 1;
        }
    }

    public static int t(String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                B.j("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        eVar.h = i.c(str);
    }

    public static int v(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                B.j("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    public static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        B.j("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
