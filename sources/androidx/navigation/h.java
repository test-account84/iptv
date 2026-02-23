package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h {
    public static final Pattern j = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public final ArrayList a = new ArrayList();
    public final Map b = new HashMap();
    public Pattern c;
    public boolean d;
    public boolean e;
    public final String f;
    public final String g;
    public Pattern h;
    public final String i;

    public static final class a {
        public String a;
        public String b;
        public String c;

        public h a() {
            return new h(this.a, this.b, this.c);
        }

        public a b(String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.a = str;
            return this;
        }
    }

    public static class b implements Comparable {
        public String a;
        public String c;

        public b(String str) {
            String[] split = str.split("/", -1);
            this.a = split[0];
            this.c = split[1];
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int i = this.a.equals(bVar.a) ? 2 : 0;
            return this.c.equals(bVar.c) ? i + 1 : i;
        }
    }

    public static class c {
        public String a;
        public ArrayList b = new ArrayList();

        public void a(String str) {
            this.b.add(str);
        }

        public String b(int i) {
            return (String) this.b.get(i);
        }

        public String c() {
            return this.a;
        }

        public void d(String str) {
            this.a = str;
        }

        public int e() {
            return this.b.size();
        }
    }

    public h(String str, String str2, String str3) {
        this.c = null;
        this.d = false;
        this.e = false;
        this.h = null;
        this.f = str;
        this.g = str2;
        this.i = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.e = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!j.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.d = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    c cVar = new c();
                    int i = 0;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i, matcher2.start())));
                        sb2.append("(.+?)?");
                        i = matcher2.end();
                    }
                    if (i < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i)));
                    }
                    cVar.d(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.b.put(str4, cVar);
                }
            } else {
                this.d = a(str, sb, compile);
            }
            this.c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
            }
            b bVar = new b(str3);
            this.h = Pattern.compile(("^(" + bVar.a + "|[*]+)/(" + bVar.c + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    public final boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    public String b() {
        return this.g;
    }

    public Bundle c(Uri uri, Map map) {
        Matcher matcher;
        Matcher matcher2 = this.c.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.a.size();
        int i = 0;
        while (i < size) {
            String str = (String) this.a.get(i);
            i++;
            if (f(bundle, str, Uri.decode(matcher2.group(i)), (d) map.get(str))) {
                return null;
            }
        }
        if (this.e) {
            for (String str2 : this.b.keySet()) {
                c cVar = (c) this.b.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i2 = 0; i2 < cVar.e(); i2++) {
                    String decode = matcher != null ? Uri.decode(matcher.group(i2 + 1)) : null;
                    String b2 = cVar.b(i2);
                    d dVar = (d) map.get(b2);
                    if (decode != null && !decode.replaceAll("[{}]", "").equals(b2) && f(bundle, b2, decode, dVar)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    public int d(String str) {
        if (this.i == null || !this.h.matcher(str).matches()) {
            return -1;
        }
        return new b(this.i).compareTo(new b(str));
    }

    public boolean e() {
        return this.d;
    }

    public final boolean f(Bundle bundle, String str, String str2, d dVar) {
        if (dVar == null) {
            bundle.putString(str, str2);
            return false;
        }
        try {
            dVar.a().g(bundle, str, str2);
            return false;
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
