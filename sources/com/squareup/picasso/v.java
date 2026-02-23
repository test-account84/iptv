package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.G;
import com.squareup.picasso.t;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class v extends ThreadPoolExecutor {

    public static final class a extends FutureTask implements Comparable {
        public final c a;

        public a(c cVar) {
            super(cVar, (Object) null);
            this.a = cVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            t.f p = this.a.p();
            t.f p2 = aVar.a.p();
            return p == p2 ? this.a.a - aVar.a.a : p2.ordinal() - p.ordinal();
        }
    }

    public v() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new G.f());
    }

    public void a(NetworkInfo networkInfo) {
        int i;
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                i = 4;
                b(i);
                return;
            }
            b(3);
            return;
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                b(1);
                break;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                    default:
                        b(3);
                        break;
                }
                b(i);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                i = 2;
                b(i);
                break;
        }
    }

    public final void b(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }
}
