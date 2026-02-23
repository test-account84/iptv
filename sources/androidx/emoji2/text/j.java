package androidx.emoji2.text;

import L.t;
import M.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.e;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j extends e.c {
    public static final a j = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return M.g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, M.e eVar) {
            return M.g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class b implements e.g {
        public final Context a;
        public final M.e b;
        public final a c;
        public final Object d = new Object();
        public Handler e;
        public Executor f;
        public ThreadPoolExecutor g;
        public e.h h;
        public ContentObserver i;
        public Runnable j;

        public b(Context context, M.e eVar, a aVar) {
            O.h.g(context, "Context cannot be null");
            O.h.g(eVar, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = eVar;
            this.c = aVar;
        }

        public void a(e.h hVar) {
            O.h.g(hVar, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.h = hVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.d) {
                try {
                    this.h = null;
                    ContentObserver contentObserver = this.i;
                    if (contentObserver != null) {
                        this.c.c(this.a, contentObserver);
                        this.i = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.j);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    try {
                        g.b e = e();
                        int b = e.b();
                        if (b == 2) {
                            synchronized (this.d) {
                            }
                        }
                        if (b != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + b + ")");
                        }
                        try {
                            t.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface a = this.c.a(this.a, e);
                            ByteBuffer f = G.m.f(this.a, null, e.d());
                            if (f == null || a == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            m b2 = m.b(a, f);
                            t.b();
                            synchronized (this.d) {
                                try {
                                    e.h hVar = this.h;
                                    if (hVar != null) {
                                        hVar.b(b2);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            t.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.d) {
                            try {
                                e.h hVar2 = this.h;
                                if (hVar2 != null) {
                                    hVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    if (this.f == null) {
                        ThreadPoolExecutor b = androidx.emoji2.text.b.b("emojiCompat");
                        this.g = b;
                        this.f = b;
                    }
                    this.f.execute(new k(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a b = this.c.b(this.a, this.b);
                if (b.c() == 0) {
                    g.b[] b2 = b.b();
                    if (b2 == null || b2.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return b2[0];
                }
                throw new RuntimeException("fetchFonts failed (" + b.c() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        public void f(Executor executor) {
            synchronized (this.d) {
                this.f = executor;
            }
        }
    }

    public j(Context context, M.e eVar) {
        super(new b(context, eVar, j));
    }

    public j c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
