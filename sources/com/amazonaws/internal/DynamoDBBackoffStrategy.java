package com.amazonaws.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DynamoDBBackoffStrategy extends CustomBackoffStrategy {
    public static final CustomBackoffStrategy DEFAULT = new DynamoDBBackoffStrategy();

    public int getBackoffPeriod(int i) {
        if (i <= 0) {
            return 0;
        }
        int pow = ((int) Math.pow(2.0d, i - 1)) * 50;
        if (pow < 0) {
            return Integer.MAX_VALUE;
        }
        return pow;
    }
}
