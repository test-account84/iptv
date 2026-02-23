package f6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h {
    public final Map a;
    public final Map b;
    public final c6.e c;

    public static final class a implements d6.b {
        public static final c6.e d = new g();
        public final Map a = new HashMap();
        public final Map b = new HashMap();
        public c6.e c = d;

        public static /* synthetic */ void a(Object obj, c6.f fVar) {
            d(obj, fVar);
        }

        private static /* synthetic */ void d(Object obj, c6.f fVar) {
            throw new c6.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h b() {
            return new h(new HashMap(this.a), new HashMap(this.b), this.c);
        }

        public a c(d6.a aVar) {
            aVar.configure(this);
            return this;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a registerEncoder(Class cls, c6.e eVar) {
            this.a.put(cls, eVar);
            this.b.remove(cls);
            return this;
        }
    }

    public h(Map map, Map map2, c6.e eVar) {
        this.a = map;
        this.b = map2;
        this.c = eVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.a, this.b, this.c).o(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
