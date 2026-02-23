package f5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class s {
    public float c;
    public i5.d f;
    public final TextPaint a = new TextPaint(1);
    public final i5.f b = new a();
    public boolean d = true;
    public WeakReference e = new WeakReference((Object) null);

    public class a extends i5.f {
        public a() {
        }

        public void a(int i) {
            s.a(s.this, true);
            b bVar = (b) s.b(s.this).get();
            if (bVar != null) {
                bVar.a();
            }
        }

        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            s.a(s.this, true);
            b bVar = (b) s.b(s.this).get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public s(b bVar) {
        g(bVar);
    }

    public static /* synthetic */ boolean a(s sVar, boolean z) {
        sVar.d = z;
        return z;
    }

    public static /* synthetic */ WeakReference b(s sVar) {
        return sVar.e;
    }

    public final float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public i5.d d() {
        return this.f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.d) {
            return this.c;
        }
        float c = c(str);
        this.c = c;
        this.d = false;
        return c;
    }

    public void g(b bVar) {
        this.e = new WeakReference(bVar);
    }

    public void h(i5.d dVar, Context context) {
        if (this.f != dVar) {
            this.f = dVar;
            if (dVar != null) {
                dVar.o(context, this.a, this.b);
                b bVar = (b) this.e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.n(context, this.a, this.b);
                this.d = true;
            }
            b bVar2 = (b) this.e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.d = z;
    }

    public void j(Context context) {
        this.f.n(context, this.a, this.b);
    }
}
