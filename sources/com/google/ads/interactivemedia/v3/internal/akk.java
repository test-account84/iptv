package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akk implements akj {
    private final are a;
    private final com.google.ads.interactivemedia.v3.impl.data.bg b;

    public akk(Context context, com.google.ads.interactivemedia.v3.impl.data.bg bgVar) {
        this.a = new arj(context);
        this.b = bgVar;
    }

    public final com.google.ads.interactivemedia.v3.impl.data.br a(com.google.ads.interactivemedia.v3.impl.data.bq bqVar) {
        String id;
        int i;
        try {
            int i2 = bqVar.requestType() == com.google.ads.interactivemedia.v3.impl.data.bp.GET ? 0 : 1;
            are areVar = this.a;
            return com.google.ads.interactivemedia.v3.impl.data.br.forResponse(bqVar.id(), (String) Tasks.await(this.b.isLimitedAdTracking() ? Tasks.forException(new arf(8)) : ((arj) areVar).doRead(com.google.android.gms.common.api.internal.t.a().d(ate.b).c(false).b(new arg((arj) areVar, bqVar.url(), i2, bqVar.content())).a()), bqVar.connectionTimeoutMs() + bqVar.readTimeoutMs(), TimeUnit.MILLISECONDS));
        } catch (ExecutionException e) {
            arf cause = e.getCause();
            if (cause instanceof arf) {
                i = cause.a();
                id = bqVar.id();
            } else {
                boolean z = cause instanceof com.google.android.gms.common.api.b;
                id = bqVar.id();
                i = z ? 102 : 100;
            }
            return com.google.ads.interactivemedia.v3.impl.data.br.forError(id, i);
        } catch (TimeoutException | InterruptedException unused) {
            id = bqVar.id();
            i = 101;
            return com.google.ads.interactivemedia.v3.impl.data.br.forError(id, i);
        }
    }
}
