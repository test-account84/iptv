package com.onesignal;

import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class T1 {

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ g d;

        public a(String str, JSONObject jSONObject, g gVar) {
            this.a = str;
            this.c = jSONObject;
            this.d = gVar;
        }

        public void run() {
            T1.a(this.a, "PUT", this.c, this.d, 120000, null);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ g d;

        public b(String str, JSONObject jSONObject, g gVar) {
            this.a = str;
            this.c = jSONObject;
            this.d = gVar;
        }

        public void run() {
            T1.a(this.a, "POST", this.c, this.d, 120000, null);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ g c;
        public final /* synthetic */ String d;

        public c(String str, g gVar, String str2) {
            this.a = str;
            this.c = gVar;
            this.d = str2;
        }

        public void run() {
            T1.a(this.a, null, null, this.c, 60000, this.d);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Thread[] a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ g f;
        public final /* synthetic */ int g;
        public final /* synthetic */ String h;

        public d(Thread[] threadArr, String str, String str2, JSONObject jSONObject, g gVar, int i, String str3) {
            this.a = threadArr;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = gVar;
            this.g = i;
            this.h = str3;
        }

        public void run() {
            this.a[0] = T1.b(this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ String c;

        public e(g gVar, String str) {
            this.a = gVar;
            this.c = str;
        }

        public void run() {
            this.a.b(this.c);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Throwable e;

        public f(g gVar, int i, String str, Throwable th) {
            this.a = gVar;
            this.c = i;
            this.d = str;
            this.e = th;
        }

        public void run() {
            this.a.a(this.c, this.d, this.e);
        }
    }

    public static abstract class g {
        public void a(int i, String str, Throwable th) {
        }

        public void b(String str) {
        }
    }

    public static /* synthetic */ void a(String str, String str2, JSONObject jSONObject, g gVar, int i, String str3) {
        h(str, str2, jSONObject, gVar, i, str3);
    }

    public static /* synthetic */ Thread b(String str, String str2, JSONObject jSONObject, g gVar, int i, String str3) {
        return n(str, str2, jSONObject, gVar, i, str3);
    }

    public static Thread c(g gVar, int i, String str, Throwable th) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new f(gVar, i, str, th), "OS_REST_FAILURE_CALLBACK");
        OSUtils.W(thread);
        return thread;
    }

    public static Thread d(g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new e(gVar, str), "OS_REST_SUCCESS_CALLBACK");
        OSUtils.W(thread);
        return thread;
    }

    public static void e(String str, g gVar, String str2) {
        OSUtils.W(new Thread(new c(str, gVar, str2), "OS_REST_ASYNC_GET"));
    }

    public static void f(String str, g gVar, String str2) {
        h(str, null, null, gVar, 60000, str2);
    }

    public static int g(int i) {
        return i + 5000;
    }

    public static void h(String str, String str2, JSONObject jSONObject, g gVar, int i, String str3) {
        if (OSUtils.H()) {
            throw new s1("Method: " + str2 + " was called from the Main Thread!");
        }
        if (str2 == null || !F1.I1(null)) {
            Thread[] threadArr = new Thread[1];
            Thread thread = new Thread(new d(threadArr, str, str2, jSONObject, gVar, i, str3), "OS_HTTPConnection");
            OSUtils.W(thread);
            try {
                thread.join(g(i));
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.interrupt();
                }
                Thread thread2 = threadArr[0];
                if (thread2 != null) {
                    thread2.join();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static HttpURLConnection i(String str) {
        return new URL("https://api.onesignal.com/" + str).openConnection();
    }

    public static void j(String str, JSONObject jSONObject, g gVar) {
        OSUtils.W(new Thread(new b(str, jSONObject, gVar), "OS_REST_ASYNC_POST"));
    }

    public static void k(String str, JSONObject jSONObject, g gVar) {
        h(str, "POST", jSONObject, gVar, 120000, null);
    }

    public static void l(String str, JSONObject jSONObject, g gVar) {
        OSUtils.W(new Thread(new a(str, jSONObject, gVar), "OS_REST_ASYNC_PUT"));
    }

    public static void m(String str, JSONObject jSONObject, g gVar) {
        h(str, "PUT", jSONObject, gVar, 120000, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c A[Catch: all -> 0x004b, TryCatch #3 {all -> 0x004b, blocks: (B:89:0x0037, B:91:0x003b, B:9:0x004e, B:11:0x007c, B:13:0x0081, B:16:0x0092, B:19:0x00c3, B:21:0x00da, B:22:0x00f3, B:31:0x0123, B:33:0x013d, B:35:0x0143, B:37:0x0152, B:38:0x0156, B:39:0x0198, B:43:0x0175, B:44:0x019e, B:47:0x01c0), top: B:88:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:89:0x0037, B:91:0x003b, B:9:0x004e, B:11:0x007c, B:13:0x0081, B:16:0x0092, B:19:0x00c3, B:21:0x00da, B:22:0x00f3, B:31:0x0123, B:33:0x013d, B:35:0x0143, B:37:0x0152, B:38:0x0156, B:39:0x0198, B:43:0x0175, B:44:0x019e, B:47:0x01c0), top: B:88:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:89:0x0037, B:91:0x003b, B:9:0x004e, B:11:0x007c, B:13:0x0081, B:16:0x0092, B:19:0x00c3, B:21:0x00da, B:22:0x00f3, B:31:0x0123, B:33:0x013d, B:35:0x0143, B:37:0x0152, B:38:0x0156, B:39:0x0198, B:43:0x0175, B:44:0x019e, B:47:0x01c0), top: B:88:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3 A[Catch: all -> 0x004b, TRY_ENTER, TryCatch #3 {all -> 0x004b, blocks: (B:89:0x0037, B:91:0x003b, B:9:0x004e, B:11:0x007c, B:13:0x0081, B:16:0x0092, B:19:0x00c3, B:21:0x00da, B:22:0x00f3, B:31:0x0123, B:33:0x013d, B:35:0x0143, B:37:0x0152, B:38:0x0156, B:39:0x0198, B:43:0x0175, B:44:0x019e, B:47:0x01c0), top: B:88:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0277 A[PHI: r0 r10
      0x0277: PHI (r0v6 java.lang.Thread) = (r0v4 java.lang.Thread), (r0v16 java.lang.Thread), (r0v23 java.lang.Thread), (r0v28 java.lang.Thread) binds: [B:77:0x02ca, B:63:0x0273, B:47:0x01c0, B:39:0x0198] A[DONT_GENERATE, DONT_INLINE]
      0x0277: PHI (r10v2 javax.net.ssl.HttpsURLConnection) = 
      (r10v1 javax.net.ssl.HttpsURLConnection)
      (r10v5 javax.net.ssl.HttpsURLConnection)
      (r10v5 javax.net.ssl.HttpsURLConnection)
      (r10v5 javax.net.ssl.HttpsURLConnection)
     binds: [B:77:0x02ca, B:63:0x0273, B:47:0x01c0, B:39:0x0198] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d8 A[Catch: all -> 0x027b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x027b, blocks: (B:24:0x00f7, B:49:0x01d8), top: B:23:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0201 A[Catch: all -> 0x0206, TryCatch #1 {all -> 0x0206, blocks: (B:52:0x01df, B:54:0x0201, B:55:0x020b, B:58:0x021a, B:60:0x022c, B:62:0x0234, B:63:0x0273), top: B:51:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02a7 A[Catch: all -> 0x02a5, TryCatch #0 {all -> 0x02a5, blocks: (B:69:0x0281, B:71:0x0285, B:74:0x028a, B:76:0x02c6, B:79:0x02a7), top: B:68:0x0281 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Thread n(java.lang.String r16, java.lang.String r17, org.json.JSONObject r18, com.onesignal.T1.g r19, int r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.T1.n(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.T1$g, int, java.lang.String):java.lang.Thread");
    }
}
