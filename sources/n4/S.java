package n4;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class s extends y4.a {
    public static final Parcelable.Creator CREATOR = new v0();
    public final l f;
    public String g;
    public final JSONObject h;

    public static class a {
        public l a;
        public JSONObject b;

        public s a() {
            return new s(this.a, this.b);
        }

        public a b(l lVar) {
            this.a = lVar;
            return this;
        }
    }

    public s(l lVar, JSONObject jSONObject) {
        this.f = lVar;
        this.h = jSONObject;
    }

    public l H() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (C4.l.a(this.h, sVar.h)) {
            return com.google.android.gms.common.internal.q.b(this.f, sVar.f);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, String.valueOf(this.h));
    }

    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.h;
        this.g = jSONObject == null ? null : jSONObject.toString();
        int a2 = y4.c.a(parcel);
        y4.c.r(parcel, 2, H(), i, false);
        y4.c.t(parcel, 3, this.g, false);
        y4.c.b(parcel, a2);
    }
}
