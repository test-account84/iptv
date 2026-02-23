package com.amplifyframework.api.graphql;

import O.c;
import j$.lang.Iterable;
import j$.util.Spliterator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class PaginatedResult implements Iterable, Iterable {
    private final Iterable items;
    private final GraphQLRequest requestForNextResult;

    public PaginatedResult(Iterable iterable, GraphQLRequest graphQLRequest) {
        this.requestForNextResult = graphQLRequest;
        this.items = iterable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaginatedResult.class != obj.getClass()) {
            return false;
        }
        PaginatedResult paginatedResult = (PaginatedResult) obj;
        return c.a(this.requestForNextResult, paginatedResult.requestForNextResult) && c.a(this.items, paginatedResult.items);
    }

    public void forEach(Consumer consumer) {
        Iterable.-EL.forEach(this.items, consumer);
    }

    public Iterable getItems() {
        return this.items;
    }

    public GraphQLRequest getRequestForNextResult() {
        return this.requestForNextResult;
    }

    public boolean hasNextResult() {
        return this.requestForNextResult != null;
    }

    public int hashCode() {
        return c.b(this.requestForNextResult, this.items);
    }

    public Iterator iterator() {
        return this.items.iterator();
    }

    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public String toString() {
        return "PaginatedResult{requestForNextResult=" + this.requestForNextResult + ", items=" + this.items + '}';
    }

    public j$.util.Spliterator spliterator() {
        return Iterable.-EL.spliterator(this.items);
    }
}
