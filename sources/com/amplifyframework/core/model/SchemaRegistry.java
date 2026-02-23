package com.amplifyframework.core.model;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.util.Immutable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SchemaRegistry {
    private static SchemaRegistry instance;
    private final Map modelSchemaMap = new HashMap();
    private final Map customTypeSchemaMap = new HashMap();

    private SchemaRegistry() {
    }

    public static synchronized SchemaRegistry instance() {
        SchemaRegistry schemaRegistry;
        synchronized (SchemaRegistry.class) {
            try {
                if (instance == null) {
                    instance = new SchemaRegistry();
                }
                schemaRegistry = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return schemaRegistry;
    }

    public void clear() {
        this.modelSchemaMap.clear();
        this.customTypeSchemaMap.clear();
    }

    public synchronized CustomTypeSchema getCustomTypeSchemaForCustomTypeClass(String str) {
        return (CustomTypeSchema) this.customTypeSchemaMap.get(str);
    }

    public Map getCustomTypeSchemaMap() {
        return Immutable.of(this.customTypeSchemaMap);
    }

    public synchronized ModelSchema getModelSchemaForModelClass(Class cls) {
        return (ModelSchema) this.modelSchemaMap.get(cls.getSimpleName());
    }

    public synchronized ModelSchema getModelSchemaForModelInstance(Model model) {
        return (ModelSchema) this.modelSchemaMap.get(model.getClass().getSimpleName());
    }

    public Map getModelSchemaMap() {
        return Immutable.of(this.modelSchemaMap);
    }

    public synchronized void register(String str, CustomTypeSchema customTypeSchema) {
        this.customTypeSchemaMap.put(str, customTypeSchema);
    }

    public synchronized ModelSchema getModelSchemaForModelClass(String str) {
        return (ModelSchema) this.modelSchemaMap.get(str);
    }

    public synchronized void register(String str, ModelSchema modelSchema) {
        this.modelSchemaMap.put(str, modelSchema);
    }

    public synchronized void register(Map map) {
        this.modelSchemaMap.putAll(map);
    }

    public synchronized void register(Map map, Map map2) {
        this.modelSchemaMap.putAll(map);
        this.customTypeSchemaMap.putAll(map2);
    }

    public synchronized void register(Set set) throws AmplifyException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            this.modelSchemaMap.put(cls.getSimpleName(), ModelSchema.fromModelClass(cls));
        }
    }
}
