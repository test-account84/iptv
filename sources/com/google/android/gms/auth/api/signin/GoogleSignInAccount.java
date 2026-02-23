package com.google.android.gms.auth.api.signin;

import C4.e;
import C4.h;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new k4.a();
    public static final e s = h.c();
    public final int f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final Uri k;
    public String l;
    public final long m;
    public final String n;
    public final List o;
    public final String p;
    public final String q;
    public final Set r = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.f = i;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = uri;
        this.l = str5;
        this.m = j;
        this.n = str6;
        this.o = list;
        this.p = str7;
        this.q = str8;
    }

    public static GoogleSignInAccount Q(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), r.g(str7), new ArrayList((Collection) r.m(set)), str5, str6);
    }

    public static GoogleSignInAccount R(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount Q = Q(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        Q.l = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return Q;
    }

    public String H() {
        return this.j;
    }

    public String I() {
        return this.i;
    }

    public String J() {
        return this.q;
    }

    public String K() {
        return this.p;
    }

    public String L() {
        return this.g;
    }

    public String M() {
        return this.h;
    }

    public Uri N() {
        return this.k;
    }

    public Set O() {
        HashSet hashSet = new HashSet(this.o);
        hashSet.addAll(this.r);
        return hashSet;
    }

    public String P() {
        return this.l;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.n.equals(this.n) && googleSignInAccount.O().equals(O());
    }

    public int hashCode() {
        return ((this.n.hashCode() + 527) * 31) + O().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.l(parcel, 1, this.f);
        c.t(parcel, 2, L(), false);
        c.t(parcel, 3, M(), false);
        c.t(parcel, 4, I(), false);
        c.t(parcel, 5, H(), false);
        c.r(parcel, 6, N(), i, false);
        c.t(parcel, 7, P(), false);
        c.o(parcel, 8, this.m);
        c.t(parcel, 9, this.n, false);
        c.x(parcel, 10, this.o, false);
        c.t(parcel, 11, K(), false);
        c.t(parcel, 12, J(), false);
        c.b(parcel, a);
    }
}
