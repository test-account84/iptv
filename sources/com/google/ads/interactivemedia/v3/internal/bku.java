package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bku implements blk {
    final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public bku(Class cls, int i) {
        this.b = i;
        this.a = cls;
    }

    public final Object a() {
        switch (this.b) {
            case 0:
                throw new bjz((String) this.a);
            case 1:
                try {
                    return blt.c.a((Class) this.a);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to create instance of " + String.valueOf(this.a) + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
                }
            case 2:
                throw new bjz((String) this.a);
            case 3:
                throw new bjz((String) this.a);
            case 4:
                Object obj = this.a;
                if (!(obj instanceof ParameterizedType)) {
                    throw new bjz("Invalid EnumSet type: ".concat(String.valueOf(obj.toString())));
                }
                Class cls = ((ParameterizedType) obj).getActualTypeArguments()[0];
                if (cls instanceof Class) {
                    return EnumSet.noneOf(cls);
                }
                throw new bjz("Invalid EnumSet type: ".concat(String.valueOf(this.a.toString())));
            case 5:
                Object obj2 = this.a;
                if (!(obj2 instanceof ParameterizedType)) {
                    throw new bjz("Invalid EnumMap type: ".concat(String.valueOf(obj2.toString())));
                }
                Class cls2 = ((ParameterizedType) obj2).getActualTypeArguments()[0];
                if (cls2 instanceof Class) {
                    return new EnumMap(cls2);
                }
                throw new bjz("Invalid EnumMap type: ".concat(String.valueOf(this.a.toString())));
            case 6:
                throw new bjz((String) this.a);
            case 7:
                throw new bjz((String) this.a);
            default:
                try {
                    return ((Constructor) this.a).newInstance((Object[]) null);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Failed to invoke " + String.valueOf(this.a) + " with no args", e2);
                } catch (IllegalAccessException e3) {
                    throw blo.e(e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Failed to invoke " + String.valueOf(this.a) + " with no args", e4.getTargetException());
                }
        }
    }

    public bku(String str, int i) {
        this.b = i;
        this.a = str;
    }

    public bku(Constructor constructor, int i) {
        this.b = i;
        this.a = constructor;
    }

    public bku(Type type, int i) {
        this.b = i;
        this.a = type;
    }
}
