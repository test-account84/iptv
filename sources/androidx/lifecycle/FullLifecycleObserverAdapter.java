package androidx.lifecycle;

import androidx.lifecycle.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class FullLifecycleObserverAdapter implements n {
    public final f a;
    public final n c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.b.values().length];
            a = iArr;
            try {
                iArr[j.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[j.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(f fVar, n nVar) {
        this.a = fVar;
        this.c = nVar;
    }

    public void b(p pVar, j.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                this.a.a(pVar);
                break;
            case 2:
                this.a.i(pVar);
                break;
            case 3:
                this.a.d(pVar);
                break;
            case 4:
                this.a.f(pVar);
                break;
            case 5:
                this.a.g(pVar);
                break;
            case 6:
                this.a.h(pVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        n nVar = this.c;
        if (nVar != null) {
            nVar.b(pVar, bVar);
        }
    }
}
