package com.amplifyframework.util;

import com.amplifyframework.core.model.SerializedModel;
import com.amplifyframework.core.model.annotations.ModelField;
import j$.util.Comparator;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class FieldFinder {
    private FieldFinder() {
    }

    public static /* synthetic */ int a(Field field, Field field2) {
        return lambda$findModelFieldsIn$0(field, field2);
    }

    public static Object extractFieldValue(Object obj, String str) throws NoSuchFieldException {
        if (obj instanceof SerializedModel) {
            return ((SerializedModel) obj).getSerializedData().get(str);
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            throw e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List findModelFieldsIn(Class cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(ModelField.class)) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        Collections.sort(arrayList, new a());
        return Immutable.of((List) arrayList);
    }

    public static List findNonTransientFieldsIn(Class cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        Collections.sort(arrayList, Comparator.-CC.comparing(new b()));
        return Immutable.of((List) arrayList);
    }

    private static /* synthetic */ int lambda$findModelFieldsIn$0(Field field, Field field2) {
        return field.getName().compareTo(field2.getName());
    }
}
