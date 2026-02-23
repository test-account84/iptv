package com.amazonaws.mobileconnectors.appsync;

import android.util.Log;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import v1.p;
import v1.q;
import v1.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ObjectManagerImplementation implements r {
    private static final String TAG = "S3ObjectManagerImplementation";
    private AmazonS3Client s3Client;

    public S3ObjectManagerImplementation(AmazonS3Client amazonS3Client) {
        this.s3Client = amazonS3Client;
    }

    public static final p getS3ComplexObject(Map map) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj != null) {
                Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Looking at Key [" + str + "] of type [" + obj.getClass().getSimpleName() + "]");
                if (implementsS3InputObjectInterface(obj.getClass())) {
                    return (p) map.get(str);
                }
                if (obj instanceof Map) {
                    return getS3ComplexObject((Map) map.get(str));
                }
                for (Method method : obj.getClass().getMethods()) {
                    if (implementsS3InputObjectInterface(method.getReturnType())) {
                        Log.v(TAG, "Method [" + method.getName() + " implements S3InputObjectInterface");
                        try {
                            p pVar = (p) method.invoke(obj, (Object[]) null);
                            if (pVar != null) {
                                return pVar;
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean implementsS3InputObjectInterface(Class cls) {
        for (Class cls2 : cls.getInterfaces()) {
            if (cls2 == p.class) {
                return true;
            }
        }
        return false;
    }

    public void download(q qVar, String str) throws AmazonClientException {
        this.s3Client.getObject(new GetObjectRequest(qVar.bucket(), qVar.key()), new File(str));
    }

    public void upload(p pVar) throws AmazonClientException {
        PutObjectRequest putObjectRequest = new PutObjectRequest(pVar.bucket(), pVar.key(), new File(pVar.localUri()));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.addUserMetadata("Content-Type", pVar.mimeType());
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setFile(new File(pVar.localUri()));
        this.s3Client.putObject(putObjectRequest);
    }
}
