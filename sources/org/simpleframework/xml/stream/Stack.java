package org.simpleframework.xml.stream;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Stack extends ArrayList {
    public Stack(int i) {
        super(i);
    }

    public Object bottom() {
        if (size() <= 0) {
            return null;
        }
        return get(0);
    }

    public Object pop() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return remove(size - 1);
    }

    public Object push(Object obj) {
        add(obj);
        return obj;
    }

    public Object top() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return get(size - 1);
    }
}
