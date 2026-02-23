package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import q5.B;
import q5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class t {
    final y a;
    private final q5.n b;
    private final String c;

    public t(Context context, q5.n nVar) {
        this.c = context.getPackageName();
        this.b = nVar;
        if (B.a(context)) {
            this.a = new y(context, nVar, "IntegrityService", u.a, q.a, null, null);
        } else {
            nVar.b("Phonesky is not installed.", new Object[0]);
            this.a = null;
        }
    }

    public static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l != null) {
            bundle.putLong("cloud.prj", l.longValue());
        }
        ArrayList<q5.h> arrayList = new ArrayList();
        arrayList.add(q5.h.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (q5.h hVar : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", hVar.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(arrayList2));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ q5.n c(t tVar) {
        return tVar.b;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            this.b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.a.p(new r(this, taskCompletionSource, decode, cloudProjectNumber, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e) {
            return Tasks.forException(new IntegrityServiceException(-13, e));
        }
    }
}
