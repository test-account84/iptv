package x4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends y4.a {
    public static final Parcelable.Creator CREATOR = new b();
    public final int f;
    public final Uri g;
    public final int h;
    public final int i;

    public a(int i, Uri uri, int i2, int i3) {
        this.f = i;
        this.g = uri;
        this.h = i2;
        this.i = i3;
    }

    public Uri H() {
        return this.g;
    }

    public JSONObject I() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.g.toString());
            jSONObject.put("width", this.h);
            jSONObject.put("height", this.i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (q.b(this.g, aVar.g) && this.h == aVar.h && this.i == aVar.i) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.i;
    }

    public int getWidth() {
        return this.h;
    }

    public int hashCode() {
        return q.c(this.g, Integer.valueOf(this.h), Integer.valueOf(this.i));
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.i), this.g.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = c.a(parcel);
        c.l(parcel, 1, i2);
        c.r(parcel, 2, H(), i, false);
        c.l(parcel, 3, getWidth());
        c.l(parcel, 4, getHeight());
        c.b(parcel, a);
    }

    public a(Uri uri) {
        this(uri, 0, 0);
    }

    public a(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(JSONObject jSONObject) {
        Uri uri = Uri.EMPTY;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        this(uri, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
