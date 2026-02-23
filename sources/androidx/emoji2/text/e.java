package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public static final Object n = new Object();
    public static final Object o = new Object();
    public static volatile e p;
    public final Set b;
    public final b e;
    public final g f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final boolean j;
    public final int k;
    public final int l;
    public final d m;
    public final ReadWriteLock a = new ReentrantReadWriteLock();
    public volatile int c = 3;
    public final Handler d = new Handler(Looper.getMainLooper());

    public static final class a extends b {
        public volatile androidx.emoji2.text.h b;
        public volatile m c;

        public class a extends h {
            public a() {
            }

            public void a(Throwable th) {
                a.this.a.m(th);
            }

            public void b(m mVar) {
                a.this.d(mVar);
            }
        }

        public a(e eVar) {
            super(eVar);
        }

        public void a() {
            try {
                this.a.f.a(new a());
            } catch (Throwable th) {
                this.a.m(th);
            }
        }

        public CharSequence b(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.b.h(charSequence, i, i2, i3, z);
        }

        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.a.g);
        }

        public void d(m mVar) {
            if (mVar == null) {
                this.a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.c = mVar;
            m mVar2 = this.c;
            i iVar = new i();
            d a2 = e.a(this.a);
            e eVar = this.a;
            this.b = new androidx.emoji2.text.h(mVar2, iVar, a2, eVar.h, eVar.i);
            this.a.n();
        }
    }

    public static class b {
        public final e a;

        public b(e eVar) {
            this.a = eVar;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence charSequence, int i, int i2, int i3, boolean z);

        public abstract void c(EditorInfo editorInfo);
    }

    public static abstract class c {
        public final g a;
        public boolean b;
        public boolean c;
        public int[] d;
        public Set e;
        public boolean f;
        public int g = -16711936;
        public int h = 0;
        public d i = new androidx.emoji2.text.d();

        public c(g gVar) {
            O.h.g(gVar, "metadataLoader cannot be null.");
            this.a = gVar;
        }

        public final g a() {
            return this.a;
        }

        public c b(int i) {
            this.h = i;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i, int i2, int i3);
    }

    public static abstract class e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class f implements Runnable {
        public final List a;
        public final Throwable c;
        public final int d;

        public f(e eVar, int i) {
            this(Arrays.asList(new e[]{(e) O.h.g(eVar, "initCallback cannot be null")}), i, null);
        }

        public void run() {
            int size = this.a.size();
            int i = 0;
            if (this.d != 1) {
                while (i < size) {
                    ((e) this.a.get(i)).a(this.c);
                    i++;
                }
            } else {
                while (i < size) {
                    ((e) this.a.get(i)).b();
                    i++;
                }
            }
        }

        public f(Collection collection, int i) {
            this(collection, i, null);
        }

        public f(Collection collection, int i, Throwable th) {
            O.h.g(collection, "initCallbacks cannot be null");
            this.a = new ArrayList(collection);
            this.d = i;
            this.c = th;
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(m mVar);
    }

    public static class i {
        public androidx.emoji2.text.i a(androidx.emoji2.text.g gVar) {
            return new o(gVar);
        }
    }

    public e(c cVar) {
        this.g = cVar.b;
        this.h = cVar.c;
        this.i = cVar.d;
        this.j = cVar.f;
        this.k = cVar.g;
        this.f = cVar.a;
        this.l = cVar.h;
        this.m = cVar.i;
        s.b bVar = new s.b();
        this.b = bVar;
        Set set = cVar.e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.e);
        }
        this.e = new a(this);
        l();
    }

    public static /* synthetic */ d a(e eVar) {
        return eVar.m;
    }

    public static e b() {
        e eVar;
        synchronized (n) {
            eVar = p;
            O.h.h(eVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z) {
        return androidx.emoji2.text.h.c(inputConnection, editable, i2, i3, z);
    }

    public static boolean f(Editable editable, int i2, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.d(editable, i2, keyEvent);
    }

    public static e g(c cVar) {
        e eVar = p;
        if (eVar == null) {
            synchronized (n) {
                try {
                    eVar = p;
                    if (eVar == null) {
                        eVar = new e(cVar);
                        p = eVar;
                    }
                } finally {
                }
            }
        }
        return eVar;
    }

    public static boolean h() {
        return p != null;
    }

    public int c() {
        return this.k;
    }

    public int d() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.j;
    }

    public final boolean j() {
        return d() == 1;
    }

    public void k() {
        O.h.h(this.l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            this.e.a();
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public final void l() {
        this.a.writeLock().lock();
        try {
            if (this.l == 0) {
                this.c = 0;
            }
            this.a.writeLock().unlock();
            if (d() == 0) {
                this.e.a();
            }
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new f(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new f((Collection) arrayList, this.c));
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i2, int i3) {
        return q(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i2, int i3, int i4) {
        return r(charSequence, i2, i3, i4, 0);
    }

    public CharSequence r(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        O.h.h(j(), "Not initialized yet");
        O.h.d(i2, "start cannot be negative");
        O.h.d(i3, "end cannot be negative");
        O.h.d(i4, "maxEmojiCount cannot be negative");
        O.h.a(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        O.h.a(i2 <= charSequence.length(), "start should be < than charSequence length");
        O.h.a(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.e.b(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.g : false : true);
    }

    public void s(e eVar) {
        O.h.g(eVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (this.c == 1 || this.c == 2) {
                this.d.post(new f(eVar, this.c));
            } else {
                this.b.add(eVar);
            }
            this.a.writeLock().unlock();
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public void t(e eVar) {
        O.h.g(eVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            this.b.remove(eVar);
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.e.c(editorInfo);
    }
}
