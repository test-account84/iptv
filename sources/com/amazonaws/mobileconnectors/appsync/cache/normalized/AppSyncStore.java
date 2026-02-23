package com.amazonaws.mobileconnectors.appsync.cache.normalized;

import F1.d;
import F1.h;
import F1.i;
import F1.j;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import v1.b;
import v1.f;
import v1.l;
import z1.a;
import z1.c;
import z1.e;
import z1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncStore {
    private a mStore;

    public AppSyncStore(a aVar) {
        this.mStore = aVar;
    }

    public c cacheKeyResolver() {
        return this.mStore.a();
    }

    public h cacheResponseNormalizer() {
        return this.mStore.e();
    }

    public e clearAll() {
        return this.mStore.s();
    }

    public Set merge(Collection collection, y1.a aVar) {
        return ((j) this.mStore).q(collection, aVar);
    }

    public h networkResponseNormalizer() {
        return this.mStore.j();
    }

    public f normalizedCache() {
        return this.mStore.u();
    }

    public void publish(Set set) {
        this.mStore.r(set);
    }

    public Collection read(Collection collection, y1.a aVar) {
        return ((d) this.mStore).p(collection, aVar);
    }

    public Object readTransaction(i iVar) {
        return this.mStore.o(iVar);
    }

    public e remove(List list) {
        return this.mStore.m(list);
    }

    public synchronized void subscribe(a.a aVar) {
        this.mStore.l(aVar);
    }

    public synchronized void unsubscribe(a.a aVar) {
        this.mStore.h(aVar);
    }

    public e write(b bVar, z1.b bVar2, f.b bVar3) {
        return this.mStore.g(bVar, bVar2, bVar3);
    }

    public e writeAndPublish(b bVar, z1.b bVar2, f.b bVar3) {
        return this.mStore.c(bVar, bVar2, bVar3);
    }

    public Object writeTransaction(i iVar) {
        return this.mStore.n(iVar);
    }

    public Set merge(z1.i iVar, y1.a aVar) {
        return ((j) this.mStore).w(iVar, aVar);
    }

    public e read(v1.f fVar) {
        return this.mStore.k(fVar);
    }

    public e remove(z1.b bVar) {
        return this.mStore.d(bVar);
    }

    public e write(v1.f fVar, f.a aVar) {
        return this.mStore.i(fVar, aVar);
    }

    public e writeAndPublish(v1.f fVar, f.a aVar) {
        return this.mStore.b(fVar, aVar);
    }

    public e read(v1.f fVar, l lVar, h hVar, y1.a aVar) {
        return this.mStore.v(fVar, lVar, hVar, aVar);
    }

    public e read(l lVar, z1.b bVar, f.b bVar2) {
        return this.mStore.f(lVar, bVar, bVar2);
    }

    public z1.i read(String str, y1.a aVar) {
        return ((d) this.mStore).t(str, aVar);
    }
}
