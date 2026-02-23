package com.amplifyframework.storage.s3.service;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface StorageService {

    public interface Factory {
        StorageService create(Context context, Region region, String str);
    }

    void cancelTransfer(TransferObserver transferObserver);

    void deleteObject(String str);

    TransferObserver downloadToFile(String str, File file);

    URL getPresignedUrl(String str, int i);

    List listFiles(String str, String str2);

    void pauseTransfer(TransferObserver transferObserver);

    void resumeTransfer(TransferObserver transferObserver);

    TransferObserver uploadFile(String str, File file, ObjectMetadata objectMetadata);

    TransferObserver uploadInputStream(String str, InputStream inputStream, ObjectMetadata objectMetadata) throws IOException;
}
