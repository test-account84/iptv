package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awv extends att {
    private static final long serialVersionUID = 0;
    transient atq a;

    public awv(Map map, atq atqVar) {
        super(map);
        this.a = atqVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.a = (atq) objectInputStream.readObject();
        p((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
        objectOutputStream.writeObject(i());
    }

    public final /* bridge */ /* synthetic */ Collection a() {
        return (List) this.a.a();
    }

    public final Map j() {
        return k();
    }

    public final Set l() {
        return m();
    }
}
