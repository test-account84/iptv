package com.onesignal;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class G0 {
    public String a;
    public String b;

    public G0(JSONObject jsonObject) {
        kotlin.jvm.internal.l.e(jsonObject, "jsonObject");
        this.a = jsonObject.optString("pageId", (String) null);
        this.b = jsonObject.optString("pageIndex", (String) null);
    }

    public final String a() {
        return this.a;
    }
}
