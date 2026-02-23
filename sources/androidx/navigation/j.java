package androidx.navigation;

import android.content.Intent;
import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j {
    public final Uri a;
    public final String b;
    public final String c;

    public j(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.a != null) {
            sb.append(" uri=");
            sb.append(this.a.toString());
        }
        if (this.b != null) {
            sb.append(" action=");
            sb.append(this.b);
        }
        if (this.c != null) {
            sb.append(" mimetype=");
            sb.append(this.c);
        }
        sb.append(" }");
        return sb.toString();
    }

    public j(Uri uri, String str, String str2) {
        this.a = uri;
        this.b = str;
        this.c = str2;
    }
}
