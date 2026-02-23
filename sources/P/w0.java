package P;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class w0 {
    public final e a;

    public static class a extends e {
        public final Window a;
        public final View b;

        public a(Window window, View view) {
            this.a = window;
            this.b = view;
        }

        public void c(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void d(int i) {
            this.a.addFlags(i);
        }

        public void e(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public void f(int i) {
            this.a.clearFlags(i);
        }
    }

    public static class b extends a {
        public b(Window window, View view) {
            super(window, view);
        }

        public void b(boolean z) {
            if (!z) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    public static class c extends b {
        public c(Window window, View view) {
            super(window, view);
        }

        public void a(boolean z) {
            if (!z) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    public static class d extends e {
        public final w0 a;
        public final WindowInsetsController b;
        public final s.i c;
        public Window d;

        public d(Window window, w0 w0Var) {
            this(x0.a(window), w0Var);
            this.d = window;
        }

        public void a(boolean z) {
            if (z) {
                if (this.d != null) {
                    c(16);
                }
                y0.a(this.b, 16, 16);
            } else {
                if (this.d != null) {
                    d(16);
                }
                y0.a(this.b, 0, 16);
            }
        }

        public void b(boolean z) {
            if (z) {
                if (this.d != null) {
                    c(8192);
                }
                y0.a(this.b, 8, 8);
            } else {
                if (this.d != null) {
                    d(8192);
                }
                y0.a(this.b, 0, 8);
            }
        }

        public void c(int i) {
            View decorView = this.d.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void d(int i) {
            View decorView = this.d.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, w0 w0Var) {
            this.c = new s.i();
            this.b = windowInsetsController;
            this.a = w0Var;
        }
    }

    public w0(Window window, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.a = new d(window, this);
        } else {
            this.a = i >= 26 ? new c(window, view) : i >= 23 ? new b(window, view) : new a(window, view);
        }
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public static class e {
        public void a(boolean z) {
        }

        public void b(boolean z) {
        }
    }
}
