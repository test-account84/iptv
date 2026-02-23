package com.amazonaws.services.s3.internal;

import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum BucketNameUtils {
    ;

    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("(\\d+\\.){3}\\d+");
    private static final int MAX_BUCKET_NAME_LENGTH = 63;
    private static final int MIN_BUCKET_NAME_LENGTH = 3;

    private static boolean exception(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return false;
    }

    public static boolean isDNSBucketName(String str) {
        return isValidV2BucketName(str);
    }

    public static boolean isValidV2BucketName(String str) {
        return isValidV2BucketName(str, false);
    }

    public static void validateBucketName(String str) {
        isValidV2BucketName(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a6, code lost:
    
        r7 = "Bucket name should not contain white space";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isValidV2BucketName(java.lang.String r7, boolean r8) {
        /*
            if (r7 != 0) goto L9
            java.lang.String r7 = "Bucket name cannot be null"
        L4:
            boolean r7 = exception(r8, r7)
            return r7
        L9:
            int r0 = r7.length()
            r1 = 3
            if (r0 < r1) goto Lbe
            int r0 = r7.length()
            r1 = 63
            if (r0 <= r1) goto L1a
            goto Lbe
        L1a:
            java.util.regex.Pattern r0 = com.amazonaws.services.s3.internal.BucketNameUtils.IP_ADDRESS_PATTERN
            java.util.regex.Matcher r0 = r0.matcher(r7)
            boolean r0 = r0.matches()
            if (r0 == 0) goto L29
            java.lang.String r7 = "Bucket name must not be formatted as an IP Address"
            goto L4
        L29:
            r0 = 0
            r1 = 0
            r2 = 0
        L2c:
            int r3 = r7.length()
            r4 = 45
            r5 = 46
            if (r1 >= r3) goto Laa
            char r3 = r7.charAt(r1)
            r6 = 65
            if (r3 < r6) goto L45
            r6 = 90
            if (r3 > r6) goto L45
            java.lang.String r7 = "Bucket name should not contain uppercase characters"
            goto L4
        L45:
            r6 = 32
            if (r3 == r6) goto La6
            r6 = 9
            if (r3 == r6) goto La6
            r6 = 13
            if (r3 == r6) goto La6
            r6 = 10
            if (r3 != r6) goto L56
            goto La6
        L56:
            java.lang.String r6 = "Bucket name should not contain dashes next to periods"
            if (r3 != r5) goto L6b
            if (r2 != 0) goto L5f
            java.lang.String r7 = "Bucket name should not begin with a period"
            goto L4
        L5f:
            if (r2 != r5) goto L64
            java.lang.String r7 = "Bucket name should not contain two adjacent periods"
            goto L4
        L64:
            if (r2 != r4) goto L8a
            boolean r7 = exception(r8, r6)
            return r7
        L6b:
            if (r3 != r4) goto L79
            if (r2 != r5) goto L74
            boolean r7 = exception(r8, r6)
            return r7
        L74:
            if (r2 != 0) goto L8a
            java.lang.String r7 = "Bucket name should not begin with a '-'"
            goto L4
        L79:
            r2 = 48
            if (r3 < r2) goto L8e
            r2 = 57
            if (r3 <= r2) goto L85
            r2 = 97
            if (r3 < r2) goto L8e
        L85:
            r2 = 122(0x7a, float:1.71E-43)
            if (r3 <= r2) goto L8a
            goto L8e
        L8a:
            int r1 = r1 + 1
            r2 = r3
            goto L2c
        L8e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Bucket name should not contain '"
            r7.append(r0)
            r7.append(r3)
            java.lang.String r0 = "'"
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            goto L4
        La6:
            java.lang.String r7 = "Bucket name should not contain white space"
            goto L4
        Laa:
            if (r2 == r5) goto Lba
            if (r2 != r4) goto Laf
            goto Lba
        Laf:
            java.lang.String r8 = "."
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto Lb8
            return r0
        Lb8:
            r7 = 1
            return r7
        Lba:
            java.lang.String r7 = "Bucket name should not end with '-' or '.'"
            goto L4
        Lbe:
            java.lang.String r7 = "Bucket name should be between 3 and 63 characters long"
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.BucketNameUtils.isValidV2BucketName(java.lang.String, boolean):boolean");
    }
}
