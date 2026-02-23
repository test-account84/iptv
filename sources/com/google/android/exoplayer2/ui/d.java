package com.google.android.exoplayer2.ui;

import a4.A;
import a4.j;
import a4.z;
import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {
    public static final Pattern a = Pattern.compile("(&#13;)?&#10;");

    public static class b {
        public final String a;
        public final Map b;

        public b(String str, Map map) {
            this.a = str;
            this.b = map;
        }

        public /* synthetic */ b(String str, Map map, a aVar) {
            this(str, map);
        }
    }

    public static final class c {
        public static final Comparator e = new z();
        public static final Comparator f = new A();
        public final int a;
        public final int b;
        public final String c;
        public final String d;

        public c(int i, int i2, String str, String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        public static /* synthetic */ int a(c cVar, c cVar2) {
            return e(cVar, cVar2);
        }

        public static /* synthetic */ int b(c cVar, c cVar2) {
            return f(cVar, cVar2);
        }

        public static /* synthetic */ Comparator c() {
            return f;
        }

        public static /* synthetic */ Comparator d() {
            return e;
        }

        public static /* synthetic */ int e(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.b, cVar.b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar.c.compareTo(cVar2.c);
            return compareTo != 0 ? compareTo : cVar.d.compareTo(cVar2.d);
        }

        public static /* synthetic */ int f(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.a, cVar.a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar2.c.compareTo(cVar.c);
            return compareTo != 0 ? compareTo : cVar2.d.compareTo(cVar.d);
        }

        public /* synthetic */ c(int i, int i2, String str, String str2, a aVar) {
            this(i, i2, str, str2);
        }
    }

    public static final class d {
        public final List a = new ArrayList();
        public final List b = new ArrayList();

        public static /* synthetic */ List a(d dVar) {
            return dVar.b;
        }

        public static /* synthetic */ List b(d dVar) {
            return dVar.a;
        }
    }

    public static b a(CharSequence charSequence, float f) {
        int i = 0;
        if (charSequence == null) {
            return new b("", s5.A.k(), null);
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), s5.A.k(), null);
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            hashMap.put(j.a("bg_" + intValue), k0.D("background-color:%s;", j.b(intValue)));
        }
        SparseArray c2 = c(spanned, f);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < c2.size()) {
            int keyAt = c2.keyAt(i);
            sb.append(b(spanned.subSequence(i2, keyAt)));
            d dVar = (d) c2.get(keyAt);
            Collections.sort(d.a(dVar), c.c());
            Iterator it2 = d.a(dVar).iterator();
            while (it2.hasNext()) {
                sb.append(((c) it2.next()).d);
            }
            Collections.sort(d.b(dVar), c.d());
            Iterator it3 = d.b(dVar).iterator();
            while (it3.hasNext()) {
                sb.append(((c) it3.next()).c);
            }
            i++;
            i2 = keyAt;
        }
        sb.append(b(spanned.subSequence(i2, spanned.length())));
        return new b(sb.toString(), hashMap, null);
    }

    public static String b(CharSequence charSequence) {
        return a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray c(Spanned spanned, float f) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e = e(obj, f);
            String d2 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e != null) {
                d4.a.e(d2);
                c cVar = new c(spanStart, spanEnd, e, d2, null);
                d.b(f(sparseArray, spanStart)).add(cVar);
                d.a(f(sparseArray, spanEnd)).add(cVar);
            }
        }
        return sparseArray;
    }

    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof T3.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof T3.e)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof T3.c) {
                return "<rt>" + b(((T3.c) obj).a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    public static String e(Object obj, float f) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return k0.D("<span style='color:%s;'>", j.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return k0.D("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof T3.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            boolean dip = absoluteSizeSpan.getDip();
            float size = absoluteSizeSpan.getSize();
            if (!dip) {
                size /= f;
            }
            return k0.D("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        }
        if (obj instanceof RelativeSizeSpan) {
            return k0.D("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return k0.D("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof T3.c)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof T3.e)) {
                return null;
            }
            T3.e eVar = (T3.e) obj;
            return k0.D("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.a, eVar.b), g(eVar.c));
        }
        int i = ((T3.c) obj).b;
        if (i == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    public static d f(SparseArray sparseArray, int i) {
        d dVar = (d) sparseArray.get(i);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i, dVar2);
        return dVar2;
    }

    public static String g(int i) {
        return i != 2 ? "over right" : "under left";
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h(int r3, int r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 2
            r2 = 1
            if (r4 == r2) goto L12
            if (r4 == r1) goto Lc
            goto L15
        Lc:
            java.lang.String r4 = "open "
        Le:
            r0.append(r4)
            goto L15
        L12:
            java.lang.String r4 = "filled "
            goto Le
        L15:
            if (r3 == 0) goto L2d
            if (r3 == r2) goto L2a
            if (r3 == r1) goto L27
            r4 = 3
            if (r3 == r4) goto L24
            java.lang.String r3 = "unset"
        L20:
            r0.append(r3)
            goto L30
        L24:
            java.lang.String r3 = "sesame"
            goto L20
        L27:
            java.lang.String r3 = "dot"
            goto L20
        L2a:
            java.lang.String r3 = "circle"
            goto L20
        L2d:
            java.lang.String r3 = "none"
            goto L20
        L30:
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.d.h(int, int):java.lang.String");
    }
}
