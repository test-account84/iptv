package com.amplifyframework.core.model;

import j$.util.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ModelIdentifier implements Serializable {
    private static final long serialVersionUID = 1;
    private final Serializable key;
    private final List sortedKeys;

    public static class Helper {
        public static final String PRIMARY_KEY_DELIMITER = "#";
        public static final String PRIMARY_KEY_ENCAPSULATE_CHAR = "\"";

        public static String escapeAndEncapsulateString(String str) {
            return "\"" + str.replaceAll("\"", "\"\"") + "\"";
        }

        public static String getIdentifier(Serializable serializable, List list) {
            StringBuilder sb = new StringBuilder();
            sb.append(escapeAndEncapsulateString(serializable.toString()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Serializable serializable2 = (Serializable) it.next();
                sb.append("#");
                sb.append(escapeAndEncapsulateString(serializable2.toString()));
            }
            return sb.toString();
        }

        public static String getUniqueKey(ModelSchema modelSchema, Map map) {
            try {
                List primaryIndexFields = modelSchema.getPrimaryIndexFields();
                if (primaryIndexFields.size() == 1) {
                    Object obj = map.get(primaryIndexFields.get(0));
                    Objects.requireNonNull(obj);
                    return obj.toString();
                }
                ListIterator listIterator = primaryIndexFields.listIterator();
                Serializable serializable = (Serializable) map.get(listIterator.next());
                ArrayList arrayList = new ArrayList();
                while (listIterator.hasNext()) {
                    arrayList.add((Serializable) map.get(listIterator.next()));
                }
                if (serializable != null) {
                    return getIdentifier(serializable, arrayList);
                }
                return null;
            } catch (Exception e) {
                throw new IllegalStateException("Invalid Primary Key, It should either be single field or of type composite primary key Primary Key." + e);
            }
        }

        public static String getUniqueKey(Serializable serializable) {
            try {
                return serializable instanceof ModelIdentifier ? ((ModelIdentifier) serializable).getIdentifier() : serializable.toString();
            } catch (Exception e) {
                throw new IllegalStateException("Invalid Primary Key, It should either be of type String or composite Primary Key." + e);
            }
        }
    }

    public ModelIdentifier(Serializable serializable, Serializable... serializableArr) {
        this.key = serializable;
        this.sortedKeys = Arrays.asList(serializableArr);
    }

    public String getIdentifier() {
        return Helper.getIdentifier(this.key, this.sortedKeys);
    }

    public Serializable key() {
        return this.key;
    }

    public List sortedKeys() {
        return this.sortedKeys;
    }
}
