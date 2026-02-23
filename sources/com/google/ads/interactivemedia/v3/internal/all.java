package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.URL;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class all {
    private final aze a;
    private final float b;

    public all(ExecutorService executorService, float f) {
        this.b = f;
        this.a = azh.a(executorService);
    }

    public final /* synthetic */ Bitmap a(String str, com.google.ads.interactivemedia.v3.impl.data.bh bhVar) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        if (decodeStream == null) {
            return null;
        }
        return (bhVar.width == decodeStream.getWidth() && bhVar.height == decodeStream.getHeight() && !axu.a((double) this.b)) ? Bitmap.createScaledBitmap(decodeStream, (int) (this.b * decodeStream.getWidth()), (int) (this.b * decodeStream.getHeight()), true) : decodeStream;
    }

    public final Task b(String str, com.google.ads.interactivemedia.v3.impl.data.bh bhVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        azh.d(this.a.a(new alj(this, str, bhVar)), new alk(taskCompletionSource, str), this.a);
        return taskCompletionSource.getTask();
    }
}
