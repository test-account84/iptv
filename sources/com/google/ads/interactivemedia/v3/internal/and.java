package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class and {
    private String a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private final String c = "ad.doubleclick.net";
    private String[] d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final amv e;

    @Deprecated
    public and(amv amvVar) {
        this.e = amvVar;
    }

    private final Uri h(Uri uri, String str) throws ane {
        String str2;
        uri.getClass();
        try {
            try {
                if (uri.getHost().equals(this.c)) {
                    if (uri.toString().contains("dc_ms=")) {
                        throw new ane("Parameter already exists: dc_ms");
                    }
                    String uri2 = uri.toString();
                    int indexOf = uri2.indexOf(";adurl");
                    if (indexOf != -1) {
                        int i = indexOf + 1;
                        str2 = uri2.substring(0, i) + "dc_ms=" + str + ";" + uri2.substring(i);
                    } else {
                        String encodedPath = uri.getEncodedPath();
                        int indexOf2 = uri2.indexOf(encodedPath);
                        str2 = uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length());
                    }
                    return Uri.parse(str2);
                }
            } catch (UnsupportedOperationException unused) {
                throw new ane("Provided Uri is not in a valid state");
            }
        } catch (NullPointerException unused2) {
        }
        if (uri.getQueryParameter("ms") != null) {
            throw new ane("Query parameter already exists: ms");
        }
        String uri3 = uri.toString();
        int indexOf3 = uri3.indexOf("&adurl");
        if (indexOf3 == -1) {
            indexOf3 = uri3.indexOf("?adurl");
        }
        if (indexOf3 == -1) {
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        }
        int i2 = indexOf3 + 1;
        return Uri.parse(uri3.substring(0, i2) + "ms=" + str + "&" + uri3.substring(i2));
    }

    @Deprecated
    public final Uri a(Uri uri, Context context) throws ane {
        return h(uri, this.e.f(context));
    }

    @Deprecated
    public final void b(MotionEvent motionEvent) {
        this.e.k(motionEvent);
    }

    public final void c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void d(String str) {
        this.d = str.split(",");
    }

    public final boolean e(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String str : this.d) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean f(Uri uri) {
        uri.getClass();
        try {
            if (uri.getHost().equals(this.a)) {
                if (uri.getPath().equals(this.b)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    @Deprecated
    public final Uri g(Uri uri, Context context) throws ane {
        try {
            return h(uri, this.e.e(context, uri.getQueryParameter("ai"), null, null));
        } catch (UnsupportedOperationException unused) {
            throw new ane("Provided Uri is not in a valid state");
        }
    }
}
