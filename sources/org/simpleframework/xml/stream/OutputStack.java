package org.simpleframework.xml.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OutputStack extends ArrayList {
    private final Set active;

    public class Sequence implements Iterator {
        private int cursor;

        public Sequence() {
            this.cursor = OutputStack.this.size();
        }

        public boolean hasNext() {
            return this.cursor > 0;
        }

        public void remove() {
            OutputStack.this.purge(this.cursor);
        }

        public OutputNode next() {
            if (!hasNext()) {
                return null;
            }
            OutputStack outputStack = OutputStack.this;
            int i = this.cursor - 1;
            this.cursor = i;
            return (OutputNode) outputStack.get(i);
        }
    }

    public OutputStack(Set set) {
        this.active = set;
    }

    public OutputNode bottom() {
        if (size() <= 0) {
            return null;
        }
        return (OutputNode) get(0);
    }

    public Iterator iterator() {
        return new Sequence();
    }

    public OutputNode pop() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return purge(size - 1);
    }

    public OutputNode purge(int i) {
        OutputNode outputNode = (OutputNode) remove(i);
        if (outputNode != null) {
            this.active.remove(outputNode);
        }
        return outputNode;
    }

    public OutputNode push(OutputNode outputNode) {
        this.active.add(outputNode);
        add(outputNode);
        return outputNode;
    }

    public OutputNode top() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return (OutputNode) get(size - 1);
    }
}
