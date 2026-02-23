package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SkuDetails {
    public final String a;
    public final JSONObject b;

    public SkuDetails(String str) {
        this.a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public String a() {
        return this.b.optString("price");
    }

    public String b() {
        return this.b.optString("price_currency_code");
    }

    public String c() {
        return this.b.optString("productId");
    }

    public String d() {
        return this.b.optString("type");
    }

    public int e() {
        return this.b.optInt("offer_type");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.a, ((SkuDetails) obj).a);
        }
        return false;
    }

    public String f() {
        return this.b.optString("offer_id");
    }

    public String g() {
        String optString = this.b.optString("offerIdToken");
        return optString.isEmpty() ? this.b.optString("offer_id_token") : optString;
    }

    public final String h() {
        return this.b.optString("packageName");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String i() {
        return this.b.optString("serializedDocid");
    }

    public final String j() {
        return this.b.optString("skuDetailsToken");
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.a));
    }
}
