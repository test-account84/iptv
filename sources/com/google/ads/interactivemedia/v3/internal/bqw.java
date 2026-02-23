package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bqw extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private boolean a;

    public bqw(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static bqv a() {
        return new bqv();
    }

    public static bqw b() {
        return new bqw("Protocol message end-group tag did not match expected tag.");
    }

    public static bqw c() {
        return new bqw("Protocol message contained an invalid tag (zero).");
    }

    public static bqw d() {
        return new bqw("Protocol message had invalid UTF-8.");
    }

    public static bqw e() {
        return new bqw("CodedInputStream encountered a malformed varint.");
    }

    public static bqw f() {
        return new bqw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static bqw g() {
        return new bqw("Failed to parse the message.");
    }

    public static bqw h() {
        return new bqw("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static bqw i() {
        return new bqw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final void j() {
        this.a = true;
    }

    public final boolean k() {
        return this.a;
    }

    public bqw(String str) {
        super(str);
    }
}
