package com.amazonaws.mobileconnectors.appsync;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PersistentOfflineMutationObject {
    final String bucket;
    final String clientState;
    final String key;
    final String localURI;
    final String mimeType;
    final String recordIdentifier;
    final String region;
    final String requestString;
    final String responseClassName;

    public PersistentOfflineMutationObject(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null, null, null, null, null);
    }

    public PersistentOfflineMutationObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.recordIdentifier = str;
        this.requestString = str2;
        this.responseClassName = str3;
        this.clientState = str4;
        this.bucket = str5;
        this.key = str6;
        this.region = str7;
        this.localURI = str8;
        this.mimeType = str9;
    }
}
