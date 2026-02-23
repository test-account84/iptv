package n7;

import android.content.Context;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public Context a;
    public int b;
    public b c;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            if (c.c(c.this) != null) {
                c.c(c.this).R0();
            }
            SharepreferenceDBHandler.setUpdateVersionCode(c.b(c.this), "", "", "");
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(retrofit2.Call r5, retrofit2.Response r6) {
            /*
                r4 = this;
                boolean r5 = r6.isSuccessful()
                java.lang.String r0 = ""
                if (r5 == 0) goto Lc0
                java.lang.Object r5 = r6.body()
                if (r5 == 0) goto La5
                java.lang.Object r5 = r6.body()
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r5 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r5
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r5 = r5.a()
                if (r5 == 0) goto La5
                java.lang.Object r5 = r6.body()     // Catch: java.lang.Exception -> L4a
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r5 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r5     // Catch: java.lang.Exception -> L4a
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r5 = r5.a()     // Catch: java.lang.Exception -> L4a
                java.lang.String r5 = r5.c()     // Catch: java.lang.Exception -> L4a
                java.lang.Object r1 = r6.body()     // Catch: java.lang.Exception -> L47
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r1 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r1     // Catch: java.lang.Exception -> L47
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r1 = r1.a()     // Catch: java.lang.Exception -> L47
                java.lang.String r1 = r1.a()     // Catch: java.lang.Exception -> L47
                java.lang.Object r6 = r6.body()     // Catch: java.lang.Exception -> L45
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r6 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r6     // Catch: java.lang.Exception -> L45
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r6 = r6.a()     // Catch: java.lang.Exception -> L45
                java.lang.String r6 = r6.b()     // Catch: java.lang.Exception -> L45
                goto L51
            L45:
                r6 = move-exception
                goto L4d
            L47:
                r6 = move-exception
                r1 = r0
                goto L4d
            L4a:
                r6 = move-exception
                r5 = r0
                r1 = r5
            L4d:
                r6.printStackTrace()
                r6 = r0
            L51:
                if (r5 == 0) goto L9c
                int r2 = r5.length()
                if (r2 <= 0) goto L9c
                java.lang.String r2 = "."
                boolean r2 = r5.contains(r2)
                if (r2 != 0) goto Le0
                int r2 = java.lang.Integer.parseInt(r5)
                r3 = 108(0x6c, float:1.51E-43)
                if (r2 <= r3) goto L84
                n7.c r0 = n7.c.this
                android.content.Context r0 = n7.c.b(r0)
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r0, r5, r6, r1)
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                if (r5 == 0) goto Le0
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                r5.f(r6)
                goto Le0
            L84:
                n7.c r5 = n7.c.this
                android.content.Context r5 = n7.c.b(r5)
                java.lang.String r6 = java.lang.String.valueOf(r3)
                java.lang.String r1 = "5.0"
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r5, r6, r0, r1)
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                if (r5 == 0) goto Le0
                goto Lb6
            L9c:
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                if (r5 == 0) goto Ld7
                goto Lce
            La5:
                n7.c r5 = n7.c.this
                android.content.Context r5 = n7.c.b(r5)
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r5, r0, r0, r0)
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                if (r5 == 0) goto Le0
            Lb6:
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                r5.R0()
                goto Le0
            Lc0:
                java.lang.Object r5 = r6.body()
                if (r5 != 0) goto Le0
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                if (r5 == 0) goto Ld7
            Lce:
                n7.c r5 = n7.c.this
                n7.c$b r5 = n7.c.c(r5)
                r5.R0()
            Ld7:
                n7.c r5 = n7.c.this
                android.content.Context r5 = n7.c.b(r5)
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r5, r0, r0, r0)
            Le0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n7.c.a.onResponse(retrofit2.Call, retrofit2.Response):void");
        }
    }

    public interface b {
        void R0();

        void f(String str);
    }

    public c(b bVar, Context context) {
        this.c = bVar;
        this.a = context;
    }

    public static /* synthetic */ Context b(c cVar) {
        return cVar.a;
    }

    public static /* synthetic */ b c(c cVar) {
        return cVar.c;
    }

    public void a() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.b = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void d() {
        Retrofit D0 = w.D0(this.a);
        if (D0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) D0.create(RetrofitPost.class);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            a();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", m7.a.d1);
            retrofitPost.getDownloadInfo(jsonObject).enqueue(new a());
        }
    }
}
