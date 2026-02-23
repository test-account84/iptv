package com.google.android.recaptcha;

import com.google.android.gms.tasks.Task;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface RecaptchaTasksClient {
    @NotNull
    Task executeTask(RecaptchaAction recaptchaAction);
}
