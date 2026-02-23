package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Purchase {
    public final String a;
    public final String b;
    public final JSONObject c;

    public Purchase(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = new JSONObject(str);
    }

    public String a() {
        String optString = this.c.optString("orderId");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return optString;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public String d() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.a, purchase.b()) && TextUtils.equals(this.b, purchase.e());
    }

    public ArrayList f() {
        return h();
    }

    public boolean g() {
        return this.c.optBoolean("acknowledged", true);
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        if (this.c.has("productIds")) {
            JSONArray optJSONArray = this.c.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
            }
        } else if (this.c.has("productId")) {
            arrayList.add(this.c.optString("productId"));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.a));
    }
}
