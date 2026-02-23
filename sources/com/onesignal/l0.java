package com.onesignal;

import com.onesignal.F1;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class L0 {
    public long a;
    public int b;
    public int c;
    public long d;
    public boolean e;

    public L0() {
        this.a = -1L;
        this.b = 0;
        this.c = 1;
        this.d = 0L;
        this.e = false;
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public void c() {
        this.b++;
    }

    public boolean d() {
        if (this.a < 0) {
            return true;
        }
        long a = F1.v0().a() / 1000;
        long j = a - this.a;
        F1.a(F1.v.DEBUG, "OSInAppMessage lastDisplayTime: " + this.a + " currentTimeInSeconds: " + a + " diffInSeconds: " + j + " displayDelay: " + this.d);
        return j >= this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void f(int i) {
        this.b = i;
    }

    public void g(L0 l0) {
        h(l0.b());
        f(l0.a());
    }

    public void h(long j) {
        this.a = j;
    }

    public boolean i() {
        boolean z = this.b < this.c;
        F1.a(F1.v.DEBUG, "OSInAppMessage shouldDisplayAgain: " + z);
        return z;
    }

    public String toString() {
        return "OSInAppMessageDisplayStats{lastDisplayTime=" + this.a + ", displayQuantity=" + this.b + ", displayLimit=" + this.c + ", displayDelay=" + this.d + '}';
    }

    public L0(int i, long j) {
        this.c = 1;
        this.d = 0L;
        this.e = false;
        this.b = i;
        this.a = j;
    }

    public L0(JSONObject jSONObject) {
        long intValue;
        this.a = -1L;
        this.b = 0;
        this.c = 1;
        this.d = 0L;
        this.e = true;
        Object obj = jSONObject.get("limit");
        Object obj2 = jSONObject.get("delay");
        if (obj instanceof Integer) {
            this.c = ((Integer) obj).intValue();
        }
        if (obj2 instanceof Long) {
            intValue = ((Long) obj2).longValue();
        } else if (!(obj2 instanceof Integer)) {
            return;
        } else {
            intValue = ((Integer) obj2).intValue();
        }
        this.d = intValue;
    }
}
