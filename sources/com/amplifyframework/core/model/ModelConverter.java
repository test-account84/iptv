package com.amplifyframework.core.model;

import com.amplifyframework.AmplifyException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelConverter {
    private ModelConverter() {
    }

    private static Map extractAssociateId(ModelField modelField, Model model, ModelSchema modelSchema) throws AmplifyException {
        Object obj;
        Object obj2;
        Object extractFieldValue = extractFieldValue(modelField.getName(), model, modelSchema);
        if (modelField.isModel() && (extractFieldValue instanceof Model)) {
            Model model2 = (Model) extractFieldValue;
            ModelSchema modelSchemaForModelClass = SchemaRegistry.instance().getModelSchemaForModelClass(model2.getModelName());
            HashMap hashMap = new HashMap();
            if (modelSchemaForModelClass.getPrimaryIndexFields().size() > 1 && (model2.resolveIdentifier() instanceof ModelIdentifier)) {
                ModelIdentifier modelIdentifier = (ModelIdentifier) model2.resolveIdentifier();
                ListIterator listIterator = modelSchemaForModelClass.getPrimaryIndexFields().listIterator();
                hashMap.put(listIterator.next(), modelIdentifier.key());
                ListIterator listIterator2 = modelIdentifier.sortedKeys().listIterator();
                while (listIterator.hasNext()) {
                    hashMap.put(listIterator.next(), listIterator2.next());
                }
                return hashMap;
            }
            if (modelSchemaForModelClass.getPrimaryIndexFields().size() > 1 && (model2 instanceof SerializedModel)) {
                for (String str : modelSchemaForModelClass.getPrimaryIndexFields()) {
                    hashMap.put(str, ((SerializedModel) model2).getSerializedData().get(str));
                }
                return hashMap;
            }
            obj = modelSchemaForModelClass.getPrimaryIndexFields().get(0);
            obj2 = model2.getPrimaryKeyString();
        } else {
            if (!modelField.isModel() || !(extractFieldValue instanceof Map)) {
                if (modelField.isModel() && extractFieldValue == null) {
                    return null;
                }
                throw new IllegalStateException("Associated data is not a Model or Map.");
            }
            obj = "id";
            obj2 = ((Map) extractFieldValue).get("id");
        }
        return Collections.singletonMap(obj, obj2);
    }

    private static Object extractFieldValue(String str, Model model, ModelSchema modelSchema) throws AmplifyException {
        if (model instanceof SerializedModel) {
            return ((SerializedModel) model).getSerializedData().get(str);
        }
        try {
            Field declaredField = model.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(model);
        } catch (Exception e) {
            throw new AmplifyException("An invalid field was provided. " + str + " is not present in " + modelSchema.getName(), e, "Check if this model schema is a correct representation of the fields in the provided Object");
        }
    }

    public static Map toMap(Model model, ModelSchema modelSchema) throws AmplifyException {
        Object extractFieldValue;
        SchemaRegistry instance = SchemaRegistry.instance();
        HashMap hashMap = new HashMap();
        for (ModelField modelField : modelSchema.getFields().values()) {
            String name = modelField.getName();
            String targetType = modelField.getTargetType();
            ModelAssociation modelAssociation = (ModelAssociation) modelSchema.getAssociations().get(name);
            if (modelAssociation == null) {
                if (!(model instanceof SerializedModel) || ((SerializedModel) model).getSerializedData().containsKey(modelField.getName())) {
                    extractFieldValue = extractFieldValue(modelField.getName(), model, modelSchema);
                    hashMap.put(name, extractFieldValue);
                }
            } else if (modelAssociation.isOwner()) {
                ModelSchema modelSchemaForModelClass = instance.getModelSchemaForModelClass(targetType);
                Map extractAssociateId = extractAssociateId(modelField, model, modelSchema);
                if (extractAssociateId != null) {
                    extractFieldValue = SerializedModel.builder().modelSchema(modelSchemaForModelClass).serializedData(extractAssociateId).build();
                    hashMap.put(name, extractFieldValue);
                }
            }
        }
        return hashMap;
    }
}
