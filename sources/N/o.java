package N;

import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class o {
    public static final n a = new e(null, false);
    public static final n b = new e(null, true);
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;

    public static class a implements c {
        public static final a b = new a(true);
        public final boolean a;

        public a(boolean z) {
            this.a = z;
        }

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a = o.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a != 0) {
                    if (a != 1) {
                        continue;
                        i++;
                    } else if (!this.a) {
                        return 1;
                    }
                } else if (this.a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {
        public static final b a = new b();

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = o.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    public static abstract class d implements n {
        public final c a;

        public d(c cVar) {
            this.a = cVar;
        }

        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.a == null ? b() : c(charSequence, i, i2);
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i, int i2) {
            int a = this.a.a(charSequence, i, i2);
            if (a == 0) {
                return true;
            }
            if (a != 1) {
                return b();
            }
            return false;
        }
    }

    public static class e extends d {
        public final boolean b;

        public e(c cVar, boolean z) {
            super(cVar);
            this.b = z;
        }

        public boolean b() {
            return this.b;
        }
    }

    public static class f extends d {
        public static final f b = new f();

        public f() {
            super(null);
        }

        public boolean b() {
            return p.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.a;
        c = new e(bVar, false);
        d = new e(bVar, true);
        e = new e(a.b, false);
        f = f.b;
    }

    public static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
