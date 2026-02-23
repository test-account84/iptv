package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public AtomicReference a = new AtomicReference();

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b downFrom(c cVar) {
            int i = a.a[cVar.ordinal()];
            if (i == 1) {
                return ON_DESTROY;
            }
            if (i == 2) {
                return ON_STOP;
            }
            if (i != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static b downTo(c cVar) {
            int i = a.a[cVar.ordinal()];
            if (i == 1) {
                return ON_STOP;
            }
            if (i == 2) {
                return ON_PAUSE;
            }
            if (i != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        public static b upFrom(c cVar) {
            int i = a.a[cVar.ordinal()];
            if (i == 1) {
                return ON_START;
            }
            if (i == 2) {
                return ON_RESUME;
            }
            if (i != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static b upTo(c cVar) {
            int i = a.a[cVar.ordinal()];
            if (i == 1) {
                return ON_CREATE;
            }
            if (i == 2) {
                return ON_START;
            }
            if (i != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public c getTargetState() {
            switch (a.b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    public abstract void a(o oVar);

    public abstract c b();

    public abstract void c(o oVar);
}
