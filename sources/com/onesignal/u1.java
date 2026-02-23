package com.onesignal;

import com.onesignal.T1;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class U1 implements G1 {

    public class a extends T1.g {
        public final /* synthetic */ I1 a;

        public a(I1 i1) {
            this.a = i1;
        }

        public void a(int i, String str, Throwable th) {
            this.a.a(i, str, th);
        }

        public void b(String str) {
            this.a.onSuccess(str);
        }
    }

    public void a(String str, JSONObject jSONObject, I1 i1) {
        T1.j(str, jSONObject, new a(i1));
    }
}
