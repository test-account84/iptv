package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class S3ClientReference {
    private static Map map = new ConcurrentHashMap();

    public static void clear() {
        map.clear();
    }

    public static AmazonS3 get(Integer num) {
        return (AmazonS3) map.get(num);
    }

    public static void put(Integer num, AmazonS3 amazonS3) {
        map.put(num, amazonS3);
    }

    public static void remove(Integer num) {
        map.remove(num);
    }
}
