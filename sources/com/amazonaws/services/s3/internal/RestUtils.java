package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RestUtils {
    private static final List SIGNED_PARAMETERS = Arrays.asList(new String[]{"acl", "torrent", "logging", "location", "policy", "requestPayment", "versioning", "versions", "versionId", "notification", "uploadId", "uploads", "partNumber", "website", "delete", "lifecycle", "tagging", "cors", "restore", "replication", "accelerate", "inventory", "analytics", "metrics", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires"});

    public static String makeS3CanonicalString(String str, String str2, Request request, String str3) {
        return makeS3CanonicalString(str, str2, request, str3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String makeS3CanonicalString(java.lang.String r10, java.lang.String r11, com.amazonaws.Request r12, java.lang.String r13, java.util.Collection r14) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.RestUtils.makeS3CanonicalString(java.lang.String, java.lang.String, com.amazonaws.Request, java.lang.String, java.util.Collection):java.lang.String");
    }
}
