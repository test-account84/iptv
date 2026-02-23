package com.onesignal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class D0 extends y0 {
    public HashMap b;
    public ArrayList c;
    public Set d;
    public L0 e;
    public double f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Date j;
    public boolean k;
    public boolean l;

    public D0(String str, Set set, boolean z, L0 l0) {
        super(str);
        new L0();
        this.h = false;
        this.d = set;
        this.g = z;
        this.e = l0;
    }

    public void a(String str) {
        this.d.add(str);
    }

    public void b() {
        this.d.clear();
    }

    public Set c() {
        return this.d;
    }

    public boolean d() {
        return this.l;
    }

    public L0 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((D0) obj).a);
    }

    public boolean f(String str) {
        return !this.d.contains(str);
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        if (this.j == null) {
            return false;
        }
        return this.j.before(new Date());
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i() {
        return this.h;
    }

    public final Date j(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("end_time");
            if (string.equals("null")) {
                return null;
            }
            try {
                return V1.a().parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } catch (JSONException unused) {
        }
    }

    public ArrayList k(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(new w1(jSONArray2.getJSONObject(i2)));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final HashMap l(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            HashMap hashMap2 = new HashMap();
            Iterator keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String str2 = (String) keys2.next();
                hashMap2.put(str2, jSONObject2.getString(str2));
            }
            hashMap.put(str, hashMap2);
        }
        return hashMap;
    }

    public void m(String str) {
        this.d.remove(str);
    }

    public void n(double d) {
        this.f = d;
    }

    public void o(boolean z) {
        this.g = z;
    }

    public void p(boolean z) {
        this.h = z;
    }

    public boolean q() {
        if (this.i) {
            return false;
        }
        this.i = true;
        return true;
    }

    public String toString() {
        return "OSInAppMessage{messageId='" + this.a + "', variants=" + this.b + ", triggers=" + this.c + ", clickedClickIds=" + this.d + ", redisplayStats=" + this.e + ", displayDuration=" + this.f + ", displayedInSession=" + this.g + ", triggerChanged=" + this.h + ", actionTaken=" + this.i + ", isPreview=" + this.k + ", endTime=" + this.j + ", hasLiquid=" + this.l + '}';
    }

    public D0(JSONObject jSONObject) {
        super(jSONObject.getString("id"));
        this.e = new L0();
        this.g = false;
        this.h = false;
        this.b = l(jSONObject.getJSONObject("variants"));
        this.c = k(jSONObject.getJSONArray("triggers"));
        this.d = new HashSet();
        this.j = j(jSONObject);
        if (jSONObject.has("has_liquid")) {
            this.l = jSONObject.getBoolean("has_liquid");
        }
        if (jSONObject.has("redisplay")) {
            this.e = new L0(jSONObject.getJSONObject("redisplay"));
        }
    }

    public D0(boolean z) {
        super("");
        this.e = new L0();
        this.g = false;
        this.h = false;
        this.k = z;
    }
}
