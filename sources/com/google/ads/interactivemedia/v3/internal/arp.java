package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import com.google.android.gms.common.internal.Hide;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arp extends arn {
    private final Object a;

    private arp(Object obj) {
        this.a = obj;
    }

    public static aro c(Object obj) {
        return new arp(obj);
    }

    public static Object d(aro aroVar) {
        if (aroVar instanceof arp) {
            return ((arp) aroVar).a;
        }
        IBinder asBinder = aroVar.asBinder();
        AccessibleObject[] declaredFields = asBinder.getClass().getDeclaredFields();
        AccessibleObject accessibleObject = null;
        int i = 0;
        for (AccessibleObject accessibleObject2 : declaredFields) {
            if (!accessibleObject2.isSynthetic()) {
                i++;
                accessibleObject = accessibleObject2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        if (((Field) com.google.android.gms.common.internal.r.m(accessibleObject)).isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        accessibleObject.setAccessible(true);
        try {
            return accessibleObject.get(asBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
