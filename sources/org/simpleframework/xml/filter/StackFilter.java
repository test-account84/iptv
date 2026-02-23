package org.simpleframework.xml.filter;

import java.util.Stack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class StackFilter implements Filter {
    private Stack stack = new Stack();

    public void push(Filter filter) {
        this.stack.push(filter);
    }

    public String replace(String str) {
        String replace;
        int size = this.stack.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            replace = ((Filter) this.stack.get(size)).replace(str);
        } while (replace == null);
        return replace;
    }
}
