package com.onesignal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class r {
    public static final a a = new a(null);
    public static b b = b.MainUI;

    public static final class a {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                iArr[b.MainUI.ordinal()] = 1;
                iArr[b.Background.ordinal()] = 2;
                a = iArr;
            }
        }

        public static final class b extends kotlin.jvm.internal.m implements w8.a {
            public final /* synthetic */ Runnable a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Runnable runnable) {
                super(0);
                this.a = runnable;
            }

            public final void a() {
                this.a.run();
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return k8.q.a;
            }
        }

        public a() {
        }

        public final b a() {
            return r.a();
        }

        public final void b(Runnable runnable) {
            kotlin.jvm.internal.l.e(runnable, "runnable");
            int i = a.a[a().ordinal()];
            if (i == 1) {
                OSUtils.S(runnable);
            } else {
                if (i != 2) {
                    return;
                }
                n8.a.b(false, false, null, null, 0, new b(runnable), 31, null);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public enum b {
        MainUI,
        Background
    }

    public static final /* synthetic */ b a() {
        return b;
    }
}
