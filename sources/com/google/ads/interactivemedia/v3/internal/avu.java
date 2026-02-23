package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avu extends avx {
    final /* synthetic */ awb a;

    public avu() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = j().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return d().listIterator();
    }

    public final boolean f() {
        return j().i();
    }

    public final boolean h() {
        return false;
    }

    public final int hashCode() {
        return j().hashCode();
    }

    public final avo i() {
        return new avy(this);
    }

    public final avs j() {
        return this.a;
    }

    public final int size() {
        return j().size();
    }

    public Object writeReplace() {
        return new avt(j());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public avu(awb awbVar) {
        this();
        this.a = awbVar;
    }
}
