package i1;

import h1.b;
import h1.v;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e {
    public static List a(List list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((h1.g) it.next()).a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (h1.g gVar : aVar.h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new h1.g((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String b(long j) {
        return d("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    public static Map c(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", b(j));
        }
        return hashMap;
    }

    public static SimpleDateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static b.a e(h1.k kVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = kVar.c;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long f = str != null ? f(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = (String) map.get("Expires");
        long f2 = str3 != null ? f(str3) : 0L;
        String str4 = (String) map.get("Last-Modified");
        long f3 = str4 != null ? f(str4) : 0L;
        String str5 = (String) map.get("ETag");
        if (i != 0) {
            j4 = currentTimeMillis + (j * 1000);
            if (z) {
                j5 = j4;
            } else {
                Long.signum(j2);
                j5 = (j2 * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (f <= 0 || f2 < f) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (f2 - f);
                j3 = j4;
            }
        }
        b.a aVar = new b.a();
        aVar.a = kVar.b;
        aVar.b = str5;
        aVar.f = j4;
        aVar.e = j3;
        aVar.c = f;
        aVar.d = f3;
        aVar.g = map;
        aVar.h = kVar.d;
        return aVar;
    }

    public static long f(String str) {
        try {
            return d("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                v.e("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            v.d(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static List g(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new h1.g((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    public static Map h(List list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h1.g gVar = (h1.g) it.next();
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}
