package com.amazonaws.mobileconnectors.appsync;

import B1.d;
import D1.a;
import D1.b;
import android.util.Log;
import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.util.concurrent.Executor;
import v1.e;
import v1.f;
import v1.p;
import v1.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncComplexObjectsInterceptor implements a {
    private static final String TAG = "AppSyncComplexObjectsInterceptor";
    final r s3ObjectManager;

    public AppSyncComplexObjectsInterceptor(r rVar) {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Instantiating Complex Objects Interceptor");
        this.s3ObjectManager = rVar;
    }

    public void dispose() {
    }

    public void interceptAsync(a.c cVar, b bVar, Executor executor, a.a aVar) {
        f fVar = cVar.b;
        if (!(fVar instanceof e)) {
            bVar.a(cVar, executor, aVar);
            return;
        }
        p s3ComplexObject = S3ObjectManagerImplementation.getS3ComplexObject(fVar.variables().valueMap());
        if (s3ComplexObject == null) {
            Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: No s3 Objects found. Proceeding with the chain");
            bVar.a(cVar, executor, aVar);
            return;
        }
        Log.d(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Found S3Object. Performing upload");
        r rVar = this.s3ObjectManager;
        if (rVar == null) {
            aVar.onFailure(new B1.b("S3 Object Manager not setup"));
            return;
        }
        try {
            rVar.upload(s3ComplexObject);
            bVar.a(cVar, executor, aVar);
        } catch (AmazonClientException e) {
            if (!(e.getCause() instanceof IOException)) {
                aVar.onFailure(new B1.b("S3 upload failed.", e.getCause()));
                return;
            }
            Log.v(TAG, "Exception " + e);
            aVar.onFailure(new d("S3 upload failed.", e.getCause()));
        } catch (Exception e2) {
            aVar.onFailure(new B1.b("S3 upload failed.", e2.getCause()));
        }
    }
}
