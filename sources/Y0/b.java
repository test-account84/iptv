package y0;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public static final c f = new a();
    public final List a;
    public final List b;
    public final SparseBooleanArray d = new SparseBooleanArray();
    public final Map c = new s.a();
    public final e e = a();

    public static class a implements c {
        public boolean a(int i, float[] fArr) {
            return (d(fArr) || b(fArr) || c(fArr)) ? false : true;
        }

        public final boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        public final boolean c(float[] fArr) {
            float f = fArr[0];
            return f >= 10.0f && f <= 37.0f && fArr[1] <= 0.82f;
        }

        public final boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }
    }

    public static final class b {
        public final List a;
        public final Bitmap b;
        public final List c;
        public int d;
        public int e;
        public int f;
        public final List g;
        public Rect h;

        public class a extends AsyncTask {
            public final /* synthetic */ d a;

            public a(d dVar) {
                this.a = dVar;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b doInBackground(Bitmap... bitmapArr) {
                try {
                    return b.this.b();
                } catch (Exception e) {
                    Log.e("Palette", "Exception thrown during async generate", e);
                    return null;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(b bVar) {
                this.a.a(bVar);
            }
        }

        public b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.d = 16;
            this.e = 12544;
            this.f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(b.f);
            this.b = bitmap;
            this.a = null;
            arrayList.add(y0.c.e);
            arrayList.add(y0.c.f);
            arrayList.add(y0.c.g);
            arrayList.add(y0.c.h);
            arrayList.add(y0.c.i);
            arrayList.add(y0.c.j);
        }

        public AsyncTask a(d dVar) {
            if (dVar != null) {
                return new a(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.b});
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public b b() {
            List list;
            c[] cVarArr;
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                Bitmap e = e(bitmap);
                Rect rect = this.h;
                if (e != this.b && rect != null) {
                    double width = e.getWidth() / this.b.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), e.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), e.getHeight());
                }
                int[] c = c(e);
                int i = this.d;
                if (this.g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List list2 = this.g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                y0.a aVar = new y0.a(c, i, cVarArr);
                if (e != this.b) {
                    e.recycle();
                }
                list = aVar.d();
            } else {
                list = this.a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.c);
            bVar.c();
            return bVar;
        }

        public final int[] c(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i = 0; i < height2; i++) {
                Rect rect2 = this.h;
                System.arraycopy(iArr, ((rect2.top + i) * width) + rect2.left, iArr2, i * width2, width2);
            }
            return iArr2;
        }

        public b d(int i) {
            this.d = i;
            return this;
        }

        public final Bitmap e(Bitmap bitmap) {
            int max;
            int i;
            double d = -1.0d;
            if (this.e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i2 = this.e;
                if (width > i2) {
                    d = Math.sqrt(i2 / width);
                }
            } else if (this.f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i = this.f)) {
                d = i / max;
            }
            return d <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d), (int) Math.ceil(bitmap.getHeight() * d), false);
        }
    }

    public interface c {
        boolean a(int i, float[] fArr);
    }

    public interface d {
        void a(b bVar);
    }

    public static final class e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public boolean f;
        public int g;
        public int h;
        public float[] i;

        public e(int i, int i2) {
            this.a = Color.red(i);
            this.b = Color.green(i);
            this.c = Color.blue(i);
            this.d = i;
            this.e = i2;
        }

        public final void a() {
            int o;
            if (this.f) {
                return;
            }
            int f = G.a.f(-1, this.d, 4.5f);
            int f2 = G.a.f(-1, this.d, 3.0f);
            if (f == -1 || f2 == -1) {
                int f3 = G.a.f(-16777216, this.d, 4.5f);
                int f4 = G.a.f(-16777216, this.d, 3.0f);
                if (f3 == -1 || f4 == -1) {
                    this.h = f != -1 ? G.a.o(-1, f) : G.a.o(-16777216, f3);
                    this.g = f2 != -1 ? G.a.o(-1, f2) : G.a.o(-16777216, f4);
                    this.f = true;
                    return;
                }
                this.h = G.a.o(-16777216, f3);
                o = G.a.o(-16777216, f4);
            } else {
                this.h = G.a.o(-1, f);
                o = G.a.o(-1, f2);
            }
            this.g = o;
            this.f = true;
        }

        public int b() {
            a();
            return this.h;
        }

        public float[] c() {
            if (this.i == null) {
                this.i = new float[3];
            }
            G.a.a(this.a, this.b, this.c, this.i);
            return this.i;
        }

        public int d() {
            return this.e;
        }

        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.e == eVar.e && this.d == eVar.d;
        }

        public int f() {
            a();
            return this.g;
        }

        public int hashCode() {
            return (this.d * 31) + this.e;
        }

        public String toString() {
            return e.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    public b(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public static b b(Bitmap bitmap) {
        return new b(bitmap);
    }

    public final e a() {
        int size = this.a.size();
        int i = Integer.MIN_VALUE;
        e eVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar2 = (e) this.a.get(i2);
            if (eVar2.d() > i) {
                i = eVar2.d();
                eVar = eVar2;
            }
        }
        return eVar;
    }

    public void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            y0.c cVar = (y0.c) this.b.get(i);
            cVar.k();
            this.c.put(cVar, e(cVar));
        }
        this.d.clear();
    }

    public final float d(e eVar, y0.c cVar) {
        float[] c2 = eVar.c();
        e eVar2 = this.e;
        return (cVar.g() > 0.0f ? cVar.g() * (1.0f - Math.abs(c2[1] - cVar.i())) : 0.0f) + (cVar.a() > 0.0f ? cVar.a() * (1.0f - Math.abs(c2[2] - cVar.h())) : 0.0f) + (cVar.f() > 0.0f ? cVar.f() * (eVar.d() / (eVar2 != null ? eVar2.d() : 1)) : 0.0f);
    }

    public final e e(y0.c cVar) {
        e g = g(cVar);
        if (g != null && cVar.j()) {
            this.d.append(g.e(), true);
        }
        return g;
    }

    public int f(int i) {
        e eVar = this.e;
        return eVar != null ? eVar.e() : i;
    }

    public final e g(y0.c cVar) {
        int size = this.a.size();
        float f2 = 0.0f;
        e eVar = null;
        for (int i = 0; i < size; i++) {
            e eVar2 = (e) this.a.get(i);
            if (i(eVar2, cVar)) {
                float d2 = d(eVar2, cVar);
                if (eVar == null || d2 > f2) {
                    eVar = eVar2;
                    f2 = d2;
                }
            }
        }
        return eVar;
    }

    public List h() {
        return Collections.unmodifiableList(this.a);
    }

    public final boolean i(e eVar, y0.c cVar) {
        float[] c2 = eVar.c();
        return c2[1] >= cVar.e() && c2[1] <= cVar.c() && c2[2] >= cVar.d() && c2[2] <= cVar.b() && !this.d.get(eVar.e());
    }
}
