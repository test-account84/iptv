package org.simpleframework.xml.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LabelMap extends LinkedHashMap implements Iterable {
    private final Policy policy;

    public LabelMap() {
        this(null);
    }

    private String[] getArray(Set set) {
        return (String[]) set.toArray(new String[0]);
    }

    public String[] getKeys() throws Exception {
        HashSet hashSet = new HashSet();
        Iterator it = iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label != null) {
                String path = label.getPath();
                String name = label.getName();
                hashSet.add(path);
                hashSet.add(name);
            }
        }
        return getArray(hashSet);
    }

    public Label getLabel(String str) {
        return (Label) remove(str);
    }

    public LabelMap getLabels() throws Exception {
        LabelMap labelMap = new LabelMap(this.policy);
        Iterator it = iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label != null) {
                labelMap.put(label.getPath(), label);
            }
        }
        return labelMap;
    }

    public String[] getPaths() throws Exception {
        HashSet hashSet = new HashSet();
        Iterator it = iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label != null) {
                hashSet.add(label.getPath());
            }
        }
        return getArray(hashSet);
    }

    public boolean isStrict(Context context) {
        Policy policy = this.policy;
        boolean isStrict = context.isStrict();
        return policy == null ? isStrict : isStrict && this.policy.isStrict();
    }

    public Iterator iterator() {
        return values().iterator();
    }

    public LabelMap(Policy policy) {
        this.policy = policy;
    }
}
