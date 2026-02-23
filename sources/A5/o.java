package A5;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public static final class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public o a() {
            return new o(this.b, this.a, this.c, this.d, this.e, this.f, this.g, null);
        }

        public b b(String str) {
            this.a = r.h(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.b = r.h(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.e = str;
            return this;
        }

        public b e(String str) {
            this.g = str;
            return this;
        }
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        r.q(!C4.o.b(str), "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static o a(Context context) {
        u uVar = new u(context);
        String a2 = uVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new o(a2, uVar.a("google_api_key"), uVar.a("firebase_database_url"), uVar.a("ga_trackingId"), uVar.a("gcm_defaultSenderId"), uVar.a("google_storage_bucket"), uVar.a("project_id"));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return com.google.android.gms.common.internal.q.b(this.b, oVar.b) && com.google.android.gms.common.internal.q.b(this.a, oVar.a) && com.google.android.gms.common.internal.q.b(this.c, oVar.c) && com.google.android.gms.common.internal.q.b(this.d, oVar.d) && com.google.android.gms.common.internal.q.b(this.e, oVar.e) && com.google.android.gms.common.internal.q.b(this.f, oVar.f) && com.google.android.gms.common.internal.q.b(this.g, oVar.g);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.b, this.a, this.c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).a("projectId", this.g).toString();
    }

    public /* synthetic */ o(String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
        this(str, str2, str3, str4, str5, str6, str7);
    }
}
