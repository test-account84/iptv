package p7;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class e implements Consumer {
    public final /* synthetic */ BackupAndRestoreActivity a;

    public /* synthetic */ e(BackupAndRestoreActivity backupAndRestoreActivity) {
        this.a = backupAndRestoreActivity;
    }

    public final void accept(Object obj) {
        BackupAndRestoreActivity.w1(this.a, (StorageException) obj);
    }
}
