package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Collector implements Criteria {
    private final Registry registry = new Registry(null);
    private final Registry alias = new Registry(null);

    public static class Registry extends LinkedHashMap {
        private Registry() {
        }

        public Iterator iterator() {
            return keySet().iterator();
        }

        public /* synthetic */ Registry(1 r1) {
            this();
        }
    }

    public void commit(Object obj) throws Exception {
        for (Variable variable : this.registry.values()) {
            variable.getContact().set(obj, variable.getValue());
        }
    }

    public Variable get(Object obj) {
        return (Variable) this.registry.get(obj);
    }

    public Iterator iterator() {
        return this.registry.iterator();
    }

    public Variable remove(Object obj) throws Exception {
        return (Variable) this.registry.remove(obj);
    }

    public Variable resolve(String str) {
        return (Variable) this.alias.get(str);
    }

    public void set(Label label, Object obj) throws Exception {
        Variable variable = new Variable(label, obj);
        if (label != null) {
            String[] paths = label.getPaths();
            Object key = label.getKey();
            for (String str : paths) {
                this.alias.put(str, variable);
            }
            this.registry.put(key, variable);
        }
    }

    public Variable get(Label label) throws Exception {
        if (label == null) {
            return null;
        }
        return (Variable) this.registry.get(label.getKey());
    }
}
