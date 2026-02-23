package kotlinx.coroutines.flow;

import k8.q;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class l extends J8.b implements j, b {

    @NotNull
    private volatile /* synthetic */ Object _state;
    public int e;

    public static final class a extends q8.d {
        public Object a;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public a(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return l.this.b(null, this);
        }
    }

    public l(Object obj) {
        this._state = obj;
    }

    public Object a(Object obj, o8.d dVar) {
        setValue(obj);
        return q.a;
    }

    /* JADX WARN: Path cross not found for [B:19:0x0098, B:27:0x009e], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:27:0x009e, B:19:0x0098], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0093, B:19:0x0098, B:21:0x00b9, B:23:0x00bf, B:27:0x009e, B:30:0x00a5, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0093, B:19:0x0098, B:21:0x00b9, B:23:0x00bf, B:27:0x009e, B:30:0x00a5, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0093, B:19:0x0098, B:21:0x00b9, B:23:0x00bf, B:27:0x009e, B:30:0x00a5, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00bd -> B:15:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00cf -> B:15:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(kotlinx.coroutines.flow.c r11, o8.d r12) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.l.b(kotlinx.coroutines.flow.c, o8.d):java.lang.Object");
    }

    public Object getValue() {
        y yVar = J8.h.a;
        Object obj = this._state;
        if (obj == yVar) {
            return null;
        }
        return obj;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public n d() {
        return new n();
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public n[] e(int i) {
        return new n[i];
    }

    public final boolean j(Object obj, Object obj2) {
        int i;
        J8.d[] g;
        g();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !kotlin.jvm.internal.l.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.l.a(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i2 = this.e;
            if ((i2 & 1) != 0) {
                this.e = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.e = i3;
            J8.d[] g2 = g();
            q qVar = q.a;
            while (true) {
                n[] nVarArr = (n[]) g2;
                if (nVarArr != null) {
                    for (n nVar : nVarArr) {
                        if (nVar != null) {
                            nVar.f();
                        }
                    }
                }
                synchronized (this) {
                    i = this.e;
                    if (i == i3) {
                        this.e = i3 + 1;
                        return true;
                    }
                    g = g();
                    q qVar2 = q.a;
                }
                g2 = g;
                i3 = i;
            }
        }
    }

    public void setValue(Object obj) {
        if (obj == null) {
            obj = J8.h.a;
        }
        j(null, obj);
    }
}
