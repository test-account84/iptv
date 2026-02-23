package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ParameterMap extends LinkedHashMap implements Iterable {
    public Parameter get(int i) {
        return (Parameter) getAll().get(i);
    }

    public List getAll() {
        Collection values = values();
        return !values.isEmpty() ? new ArrayList(values) : Collections.emptyList();
    }

    public Iterator iterator() {
        return values().iterator();
    }
}
