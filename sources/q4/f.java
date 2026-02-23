package q4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zzaf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends AsyncTask {
    public static final t4.b c = new t4.b("FetchBitmapTask");
    public final i a;
    public final b b;

    public f(Context context, int i, int i2, boolean z, long j, int i3, int i4, int i5, b bVar) {
        this.b = bVar;
        this.a = zzaf.zze(context.getApplicationContext(), this, new e(this, null), i, i2, false, 2097152L, 5, 333, 10000);
    }

    public static /* synthetic */ void a(f fVar, Object[] objArr) {
        fVar.publishProgress(objArr);
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        i iVar;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (iVar = this.a) == null) {
            return null;
        }
        try {
            return iVar.l(uri);
        } catch (RemoteException e) {
            c.b(e, "Unable to call %s on %s.", "doFetch", i.class.getSimpleName());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(bitmap);
        }
    }
}
