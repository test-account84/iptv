package k1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import d.D;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public static final MediaType O = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType P = MediaType.parse("text/x-markdown; charset=utf-8");
    public static final Object Q = new Object();
    public boolean A;
    public int B;
    public p1.c C;
    public p1.b D;
    public p1.f E;
    public Bitmap.Config F;
    public int G;
    public int H;
    public ImageView.ScaleType I;
    public CacheControl J;
    public Executor K;
    public OkHttpClient L;
    public String M;
    public Type N;
    public int a;
    public k1.e b;
    public int c;
    public String d;
    public int e;
    public Object f;
    public k1.f g;
    public HashMap h;
    public HashMap i;
    public HashMap j;
    public HashMap k;
    public HashMap l;
    public HashMap m;
    public HashMap n;
    public String o;
    public String p;
    public String q;
    public String r;
    public byte[] s;
    public File t;
    public MediaType u;
    public Future v;
    public Call w;
    public int x;
    public boolean y;
    public boolean z;

    public class a implements p1.b {
        public a() {
        }

        public void a(long j, long j2) {
            if (a.a(a.this) == null || a.b(a.this)) {
                return;
            }
            a.a(a.this).a(j, j2);
        }
    }

    public class b implements p1.f {
        public b() {
        }

        public void a(long j, long j2) {
            a.c(a.this, (int) ((100 * j) / j2));
            if (a.d(a.this) == null || a.b(a.this)) {
                return;
            }
            a.d(a.this).a(j, j2);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ k1.b a;

        public c(k1.b bVar) {
            this.a = bVar;
        }

        public void run() {
            a.e(a.this, this.a);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ k1.b a;

        public d(k1.b bVar) {
            this.a = bVar;
        }

        public void run() {
            a.e(a.this, this.a);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Response a;

        public e(Response response) {
            this.a = response;
        }

        public void run() {
            a.f(a.this);
            a.this.m();
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ Response a;

        public f(Response response) {
            this.a = response;
        }

        public void run() {
            a.f(a.this);
            a.this.m();
        }
    }

    public static /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k1.f.values().length];
            a = iArr;
            try {
                iArr[k1.f.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k1.f.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k1.f.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[k1.f.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[k1.f.PARSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[k1.f.PREFETCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class h {
        public int b;
        public String c;
        public Object d;
        public Bitmap.Config e;
        public int f;
        public int g;
        public ImageView.ScaleType h;
        public CacheControl l;
        public Executor m;
        public OkHttpClient n;
        public String o;
        public k1.e a = k1.e.MEDIUM;
        public HashMap i = new HashMap();
        public HashMap j = new HashMap();
        public HashMap k = new HashMap();

        public h(String str) {
            this.b = 0;
            this.c = str;
            this.b = 0;
        }

        public static /* synthetic */ int a(h hVar) {
            return hVar.b;
        }

        public static /* synthetic */ k1.e b(h hVar) {
            return hVar.a;
        }

        public static /* synthetic */ HashMap c(h hVar) {
            return hVar.k;
        }

        public static /* synthetic */ CacheControl d(h hVar) {
            return hVar.l;
        }

        public static /* synthetic */ Executor e(h hVar) {
            return hVar.m;
        }

        public static /* synthetic */ OkHttpClient f(h hVar) {
            return hVar.n;
        }

        public static /* synthetic */ String g(h hVar) {
            return hVar.o;
        }

        public static /* synthetic */ String h(h hVar) {
            return hVar.c;
        }

        public static /* synthetic */ Object i(h hVar) {
            return hVar.d;
        }

        public static /* synthetic */ HashMap j(h hVar) {
            return hVar.i;
        }

        public static /* synthetic */ Bitmap.Config k(h hVar) {
            return hVar.e;
        }

        public static /* synthetic */ int l(h hVar) {
            return hVar.g;
        }

        public static /* synthetic */ int m(h hVar) {
            return hVar.f;
        }

        public static /* synthetic */ ImageView.ScaleType n(h hVar) {
            return hVar.h;
        }

        public static /* synthetic */ HashMap o(h hVar) {
            return hVar.j;
        }

        public h p(String str, String str2) {
            ArrayList arrayList = (List) this.i.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.i.put(str, arrayList);
            }
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            return this;
        }

        public a q() {
            return new a(this);
        }

        public h r(OkHttpClient okHttpClient) {
            this.n = okHttpClient;
            return this;
        }

        public h s(k1.e eVar) {
            this.a = eVar;
            return this;
        }

        public h t(Object obj) {
            this.d = obj;
            return this;
        }
    }

    public static class i {
        public int b;
        public String c;
        public Object d;
        public CacheControl n;
        public Executor o;
        public OkHttpClient p;
        public String q;
        public String r;
        public k1.e a = k1.e.MEDIUM;
        public String e = null;
        public String f = null;
        public byte[] g = null;
        public File h = null;
        public HashMap i = new HashMap();
        public HashMap j = new HashMap();
        public HashMap k = new HashMap();
        public HashMap l = new HashMap();
        public HashMap m = new HashMap();

        public i(String str) {
            this.b = 1;
            this.c = str;
            this.b = 1;
        }

        public static /* synthetic */ int a(i iVar) {
            return iVar.b;
        }

        public static /* synthetic */ k1.e b(i iVar) {
            return iVar.a;
        }

        public static /* synthetic */ String c(i iVar) {
            return iVar.c;
        }

        public static /* synthetic */ Object d(i iVar) {
            return iVar.d;
        }

        public static /* synthetic */ HashMap e(i iVar) {
            return iVar.i;
        }

        public static /* synthetic */ HashMap f(i iVar) {
            return iVar.j;
        }

        public static /* synthetic */ HashMap g(i iVar) {
            return iVar.k;
        }

        public static /* synthetic */ HashMap h(i iVar) {
            return iVar.l;
        }

        public static /* synthetic */ HashMap i(i iVar) {
            return iVar.m;
        }

        public static /* synthetic */ String j(i iVar) {
            return iVar.e;
        }

        public static /* synthetic */ String k(i iVar) {
            return iVar.f;
        }

        public static /* synthetic */ File l(i iVar) {
            return iVar.h;
        }

        public static /* synthetic */ byte[] m(i iVar) {
            return iVar.g;
        }

        public static /* synthetic */ CacheControl n(i iVar) {
            return iVar.n;
        }

        public static /* synthetic */ Executor o(i iVar) {
            return iVar.o;
        }

        public static /* synthetic */ OkHttpClient p(i iVar) {
            return iVar.p;
        }

        public static /* synthetic */ String q(i iVar) {
            return iVar.q;
        }

        public static /* synthetic */ String r(i iVar) {
            return iVar.r;
        }

        public i s(String str, String str2) {
            this.j.put(str, str2);
            return this;
        }

        public i t(String str, String str2) {
            ArrayList arrayList = (List) this.i.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.i.put(str, arrayList);
            }
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            return this;
        }

        public a u() {
            return new a(this);
        }

        public i v(k1.e eVar) {
            this.a = eVar;
            return this;
        }

        public i w(Object obj) {
            this.d = obj;
            return this;
        }
    }

    public a(h hVar) {
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.B = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.c = 0;
        this.a = h.a(hVar);
        this.b = h.b(hVar);
        this.d = h.h(hVar);
        this.f = h.i(hVar);
        this.h = h.j(hVar);
        this.F = h.k(hVar);
        this.H = h.l(hVar);
        this.G = h.m(hVar);
        this.I = h.n(hVar);
        this.l = h.o(hVar);
        this.m = h.c(hVar);
        this.J = h.d(hVar);
        this.K = h.e(hVar);
        this.L = h.f(hVar);
        this.M = h.g(hVar);
    }

    public static /* synthetic */ p1.b a(a aVar) {
        return aVar.D;
    }

    public static /* synthetic */ boolean b(a aVar) {
        return aVar.y;
    }

    public static /* synthetic */ int c(a aVar, int i2) {
        aVar.x = i2;
        return i2;
    }

    public static /* synthetic */ p1.f d(a aVar) {
        return aVar.E;
    }

    public static /* synthetic */ void e(a aVar, k1.b bVar) {
        aVar.k(bVar);
    }

    public static /* synthetic */ p1.d f(a aVar) {
        aVar.getClass();
        return null;
    }

    public int A() {
        return this.c;
    }

    public k1.f B() {
        return this.g;
    }

    public int C() {
        return this.e;
    }

    public p1.f D() {
        return new b();
    }

    public String E() {
        String str = this.d;
        for (Map.Entry entry : this.m.entrySet()) {
            str = str.replace("{" + ((String) entry.getKey()) + "}", String.valueOf(entry.getValue()));
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse(str).newBuilder();
        HashMap hashMap = this.l;
        if (hashMap != null) {
            for (Map.Entry entry2 : hashMap.entrySet()) {
                String str2 = (String) entry2.getKey();
                List list = (List) entry2.getValue();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        newBuilder.addQueryParameter(str2, (String) it.next());
                    }
                }
            }
        }
        return newBuilder.build().toString();
    }

    public String F() {
        return this.M;
    }

    public m1.a G(m1.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().body() != null && aVar.a().body().source() != null) {
                aVar.c(Okio.buffer(aVar.a().body().source()).readUtf8());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public k1.b H(Response response) {
        m1.a aVar;
        k1.b b2;
        switch (g.a[this.g.ordinal()]) {
            case 1:
                try {
                    return k1.b.f(new JSONArray(Okio.buffer(response.body().source()).readUtf8()));
                } catch (Exception e2) {
                    aVar = new m1.a((Throwable) e2);
                    break;
                }
            case 2:
                try {
                    return k1.b.f(new JSONObject(Okio.buffer(response.body().source()).readUtf8()));
                } catch (Exception e3) {
                    aVar = new m1.a((Throwable) e3);
                    break;
                }
            case 3:
                try {
                    return k1.b.f(Okio.buffer(response.body().source()).readUtf8());
                } catch (Exception e4) {
                    aVar = new m1.a((Throwable) e4);
                    break;
                }
            case 4:
                synchronized (Q) {
                    try {
                        try {
                            b2 = s1.c.b(response, this.G, this.H, this.F, this.I);
                        } catch (Exception e5) {
                            return k1.b.a(s1.c.e(new m1.a((Throwable) e5)));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return b2;
            case 5:
                try {
                    return k1.b.f(s1.a.a().a(this.N).convert(response.body()));
                } catch (Exception e6) {
                    aVar = new m1.a((Throwable) e6);
                    break;
                }
            case 6:
                try {
                    Okio.buffer(response.body().source()).skip(Long.MAX_VALUE);
                    return k1.b.f("prefetch");
                } catch (Exception e7) {
                    aVar = new m1.a((Throwable) e7);
                    break;
                }
            default:
                return null;
        }
        return k1.b.a(s1.c.e(aVar));
    }

    public void I(Call call) {
        this.w = call;
    }

    public void J(Future future) {
        this.v = future;
    }

    public void K(boolean z) {
        this.A = z;
    }

    public void L(int i2) {
        this.e = i2;
    }

    public void M(String str) {
        this.M = str;
    }

    public void N() {
        this.z = true;
        m();
    }

    public synchronized void g(m1.a aVar) {
        try {
            try {
                if (!this.z) {
                    if (this.y) {
                        aVar.b();
                        aVar.d(0);
                    }
                    h(aVar);
                }
                this.z = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h(m1.a aVar) {
        p1.c cVar = this.C;
        if (cVar != null) {
            cVar.b(aVar);
        }
    }

    public void i(Response response) {
        Runnable fVar;
        try {
            this.z = true;
            if (this.y) {
                m1.a aVar = new m1.a();
                aVar.b();
                aVar.d(0);
                m();
                return;
            }
            Executor executor = this.K;
            if (executor != null) {
                fVar = new e(response);
            } else {
                executor = l1.b.b().a().a();
                fVar = new f(response);
            }
            executor.execute(fVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(k1.b bVar) {
        Runnable dVar;
        try {
            this.z = true;
            if (this.y) {
                m1.a aVar = new m1.a();
                aVar.b();
                aVar.d(0);
                h(aVar);
                m();
                return;
            }
            Executor executor = this.K;
            if (executor != null) {
                dVar = new c(bVar);
            } else {
                executor = l1.b.b().a().a();
                dVar = new d(bVar);
            }
            executor.execute(dVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k(k1.b bVar) {
        p1.c cVar = this.C;
        if (cVar != null) {
            cVar.a((JSONObject) bVar.c());
        }
        m();
    }

    public void l() {
        this.C = null;
        this.D = null;
        this.E = null;
    }

    public void m() {
        l();
        q1.a.c().b(this);
    }

    public p1.a n() {
        return null;
    }

    public void o(p1.c cVar) {
        this.g = k1.f.JSON_OBJECT;
        this.C = cVar;
        q1.a.c().a(this);
    }

    public CacheControl p() {
        return this.J;
    }

    public Call q() {
        return this.w;
    }

    public String r() {
        return this.o;
    }

    public p1.b s() {
        return new a();
    }

    public String t() {
        return this.p;
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.e + ", mMethod=" + this.a + ", mPriority=" + this.b + ", mRequestType=" + this.c + ", mUrl=" + this.d + '}';
    }

    public Headers u() {
        Headers.Builder builder = new Headers.Builder();
        try {
            HashMap hashMap = this.h;
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            builder.add(str, (String) it.next());
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return builder.build();
    }

    public int v() {
        return this.a;
    }

    public RequestBody w() {
        Iterator it;
        MultipartBody.Builder builder = new MultipartBody.Builder();
        MediaType mediaType = this.u;
        if (mediaType == null) {
            mediaType = MultipartBody.FORM;
        }
        MultipartBody.Builder type = builder.setType(mediaType);
        try {
            it = this.k.entrySet().iterator();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (it.hasNext()) {
            D.a(((Map.Entry) it.next()).getValue());
            throw null;
        }
        Iterator it2 = this.n.entrySet().iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((List) ((Map.Entry) it2.next()).getValue()).iterator();
            if (it3.hasNext()) {
                D.a(it3.next());
                throw null;
            }
        }
        return type.build();
    }

    public OkHttpClient x() {
        return this.L;
    }

    public k1.e y() {
        return this.b;
    }

    public RequestBody z() {
        String str = this.q;
        if (str != null) {
            MediaType mediaType = this.u;
            return mediaType != null ? RequestBody.create(mediaType, str) : RequestBody.create(O, str);
        }
        String str2 = this.r;
        if (str2 != null) {
            MediaType mediaType2 = this.u;
            return mediaType2 != null ? RequestBody.create(mediaType2, str2) : RequestBody.create(P, str2);
        }
        File file = this.t;
        if (file != null) {
            MediaType mediaType3 = this.u;
            return mediaType3 != null ? RequestBody.create(mediaType3, file) : RequestBody.create(P, file);
        }
        byte[] bArr = this.s;
        if (bArr != null) {
            MediaType mediaType4 = this.u;
            return mediaType4 != null ? RequestBody.create(mediaType4, bArr) : RequestBody.create(P, bArr);
        }
        FormBody.Builder builder = new FormBody.Builder();
        try {
            for (Map.Entry entry : this.i.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
            for (Map.Entry entry2 : this.j.entrySet()) {
                builder.addEncoded((String) entry2.getKey(), (String) entry2.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return builder.build();
    }

    public a(i iVar) {
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.B = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.c = 0;
        this.a = i.a(iVar);
        this.b = i.b(iVar);
        this.d = i.c(iVar);
        this.f = i.d(iVar);
        this.h = i.e(iVar);
        this.i = i.f(iVar);
        this.j = i.g(iVar);
        this.l = i.h(iVar);
        this.m = i.i(iVar);
        this.q = i.j(iVar);
        this.r = i.k(iVar);
        this.t = i.l(iVar);
        this.s = i.m(iVar);
        this.J = i.n(iVar);
        this.K = i.o(iVar);
        this.L = i.p(iVar);
        this.M = i.q(iVar);
        if (i.r(iVar) != null) {
            this.u = MediaType.parse(i.r(iVar));
        }
    }
}
