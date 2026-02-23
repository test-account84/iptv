package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public enum bhq implements bqp {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);

    private final int h;

    bhq(int i) {
        this.h = i;
    }

    public static bhq a(int i) {
        if (i == 0) {
            return UNKNOWN_KEYMATERIAL;
        }
        if (i == 1) {
            return SYMMETRIC;
        }
        if (i == 2) {
            return ASYMMETRIC_PRIVATE;
        }
        if (i == 3) {
            return ASYMMETRIC_PUBLIC;
        }
        if (i != 4) {
            return null;
        }
        return REMOTE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final String toString() {
        return Integer.toString(getNumber());
    }
}
