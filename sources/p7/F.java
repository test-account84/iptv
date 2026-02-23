package p7;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class f implements Consumer {
    public final /* synthetic */ BackupAndRestoreActivity a;

    public /* synthetic */ f(BackupAndRestoreActivity backupAndRestoreActivity) {
        this.a = backupAndRestoreActivity;
    }

    public final void accept(Object obj) {
        BackupAndRestoreActivity.v1(this.a, (StorageUploadFileResult) obj);
    }
}
