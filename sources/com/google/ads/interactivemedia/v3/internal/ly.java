package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ly {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;

    public ly() {
        Random random = new Random();
        this.b = new HashMap();
        this.a = random;
        this.d = new HashMap();
        this.c = new HashMap();
    }

    public static ly k(agu aguVar, agw agwVar, agx agxVar, agx agxVar2) {
        com.google.ads.interactivemedia.v3.impl.data.i.e(aguVar, "CreativeType is null");
        com.google.ads.interactivemedia.v3.impl.data.i.e(agwVar, "ImpressionType is null");
        com.google.ads.interactivemedia.v3.impl.data.i.e(agxVar, "Impression owner is null");
        if (agxVar == agx.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (aguVar == agu.DEFINED_BY_JAVASCRIPT && agxVar == agx.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (agwVar == agw.DEFINED_BY_JAVASCRIPT && agxVar == agx.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new ly(aguVar, agwVar, agxVar, agxVar2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.Map] */
    private final List l(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        n(elapsedRealtime, this.d);
        n(elapsedRealtime, this.c);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            lt ltVar = (lt) list.get(i);
            if (!this.d.containsKey(ltVar.b) && !this.c.containsKey(Integer.valueOf(ltVar.c))) {
                arrayList.add(ltVar);
            }
        }
        return arrayList;
    }

    private static void m(Object obj, long j, Map map) {
        if (map.containsKey(obj)) {
            Long l = (Long) map.get(obj);
            int i = cq.a;
            j = Math.max(j, l.longValue());
        }
        map.put(obj, Long.valueOf(j));
    }

    private static void n(long j, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public final String a() {
        return ((String) this.c) + "/" + ((String) this.d);
    }

    public final int b(List list) {
        HashSet hashSet = new HashSet();
        List l = l(list);
        for (int i = 0; i < l.size(); i++) {
            hashSet.add(Integer.valueOf(((lt) l.get(i)).c));
        }
        return hashSet.size();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, java.util.Map] */
    public final lt c(List list) {
        lt ltVar;
        Object obj;
        List l = l(list);
        if (l.size() >= 2) {
            Collections.sort(l, kt.a);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = ((lt) l.get(0)).c;
            int i3 = 0;
            while (true) {
                if (i3 >= l.size()) {
                    break;
                }
                lt ltVar2 = (lt) l.get(i3);
                if (i2 == ltVar2.c) {
                    arrayList.add(new Pair(ltVar2.b, Integer.valueOf(ltVar2.d)));
                    i3++;
                } else if (arrayList.size() == 1) {
                    obj = l.get(0);
                }
            }
            lt ltVar3 = (lt) this.b.get(arrayList);
            if (ltVar3 != null) {
                return ltVar3;
            }
            List subList = l.subList(0, arrayList.size());
            int i4 = 0;
            for (int i5 = 0; i5 < subList.size(); i5++) {
                i4 += ((lt) subList.get(i5)).d;
            }
            int nextInt = ((Random) this.a).nextInt(i4);
            int i6 = 0;
            while (true) {
                if (i >= subList.size()) {
                    ltVar = (lt) axo.z(subList);
                    break;
                }
                ltVar = (lt) subList.get(i);
                i6 += ltVar.d;
                if (nextInt < i6) {
                    break;
                }
                i++;
            }
            this.b.put(arrayList, ltVar);
            return ltVar;
        }
        obj = axo.B(l);
        return (lt) obj;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Map] */
    public final void d(lt ltVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        m(ltVar.b, elapsedRealtime, this.d);
        int i = ltVar.c;
        if (i != Integer.MIN_VALUE) {
            m(Integer.valueOf(i), elapsedRealtime, this.c);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    public final void e() {
        this.d.clear();
        this.c.clear();
        this.b.clear();
    }

    public final agv f() {
        return (agv) this.a;
    }

    public final String g() {
        return (String) this.b;
    }

    public final String h() {
        return (String) this.d;
    }

    public final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        ahn.h(jSONObject, "impressionOwner", this.b);
        ahn.h(jSONObject, "mediaEventsOwner", this.d);
        ahn.h(jSONObject, "creativeType", this.a);
        ahn.h(jSONObject, "impressionType", this.c);
        ahn.h(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }

    public final aia j() {
        return (aia) this.c;
    }

    public ly(View view, agv agvVar, String str) {
        this.c = new aia(view);
        this.d = view.getClass().getCanonicalName();
        this.a = agvVar;
        this.b = str;
    }

    private ly(agu aguVar, agw agwVar, agx agxVar, agx agxVar2) {
        this.a = aguVar;
        this.c = agwVar;
        this.b = agxVar;
        if (agxVar2 == null) {
            this.d = agx.NONE;
        } else {
            this.d = agxVar2;
        }
    }

    public ly(String str, String str2, long[] jArr, aal[] aalVarArr) {
        this.c = str;
        this.d = str2;
        this.b = jArr;
        this.a = aalVarArr;
    }
}
