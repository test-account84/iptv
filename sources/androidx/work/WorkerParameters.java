package androidx.work;

import Q0.f;
import Q0.p;
import Q0.w;
import android.net.Network;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class WorkerParameters {
    public UUID a;
    public b b;
    public Set c;
    public a d;
    public int e;
    public Executor f;
    public c1.a g;
    public w h;
    public p i;
    public f j;

    public static class a {
        public List a = Collections.emptyList();
        public List b = Collections.emptyList();
        public Network c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection collection, a aVar, int i, Executor executor, c1.a aVar2, w wVar, p pVar, f fVar) {
        this.a = uuid;
        this.b = bVar;
        this.c = new HashSet(collection);
        this.d = aVar;
        this.e = i;
        this.f = executor;
        this.g = aVar2;
        this.h = wVar;
        this.i = pVar;
        this.j = fVar;
    }

    public Executor a() {
        return this.f;
    }

    public f b() {
        return this.j;
    }

    public UUID c() {
        return this.a;
    }

    public b d() {
        return this.b;
    }

    public c1.a e() {
        return this.g;
    }

    public w f() {
        return this.h;
    }
}
