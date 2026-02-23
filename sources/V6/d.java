package v6;

import G8.L;
import G8.i;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import k8.k;
import k8.q;
import kotlin.jvm.internal.B;
import org.json.JSONObject;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements v6.a {
    public static final a d = new a(null);
    public final t6.b a;
    public final o8.g b;
    public final String c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends l implements p {
        public int a;
        public final /* synthetic */ Map d;
        public final /* synthetic */ p e;
        public final /* synthetic */ p f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map map, p pVar, p pVar2, o8.d dVar) {
            super(2, dVar);
            this.d = map;
            this.e = pVar;
            this.f = pVar2;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(L l, o8.d dVar) {
            return create(l, dVar).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            return d.this.new b(this.d, this.e, this.f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d = p8.c.d();
            int i = this.a;
            try {
                if (i == 0) {
                    k.b(obj);
                    HttpsURLConnection openConnection = d.b(d.this).openConnection();
                    kotlin.jvm.internal.l.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    HttpsURLConnection httpsURLConnection = openConnection;
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    for (Map.Entry entry : this.d.entrySet()) {
                        httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder();
                        B b = new B();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            b.a = readLine;
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        bufferedReader.close();
                        inputStream.close();
                        JSONObject jSONObject = new JSONObject(sb.toString());
                        p pVar = this.e;
                        this.a = 1;
                        if (pVar.invoke(jSONObject, this) == d) {
                            return d;
                        }
                    } else {
                        p pVar2 = this.f;
                        String str = "Bad response code: " + responseCode;
                        this.a = 2;
                        if (pVar2.invoke(str, this) == d) {
                            return d;
                        }
                    }
                } else if (i == 1 || i == 2) {
                    k.b(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
            } catch (Exception e) {
                p pVar3 = this.f;
                String message = e.getMessage();
                if (message == null) {
                    message = e.toString();
                }
                this.a = 3;
                if (pVar3.invoke(message, this) == d) {
                    return d;
                }
            }
            return q.a;
        }
    }

    public d(t6.b bVar, o8.g gVar, String str) {
        kotlin.jvm.internal.l.e(bVar, "appInfo");
        kotlin.jvm.internal.l.e(gVar, "blockingDispatcher");
        kotlin.jvm.internal.l.e(str, "baseUrl");
        this.a = bVar;
        this.b = gVar;
        this.c = str;
    }

    public static final /* synthetic */ URL b(d dVar) {
        return dVar.c();
    }

    public Object a(Map map, p pVar, p pVar2, o8.d dVar) {
        Object g = i.g(this.b, new b(map, pVar, pVar2, null), dVar);
        return g == p8.c.d() ? g : q.a;
    }

    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority(this.c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.a.b()).appendPath("settings").appendQueryParameter("build_version", this.a.a().a()).appendQueryParameter("display_version", this.a.a().d()).build().toString());
    }

    public /* synthetic */ d(t6.b bVar, o8.g gVar, String str, int i, kotlin.jvm.internal.g gVar2) {
        this(bVar, gVar, (i & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }
}
