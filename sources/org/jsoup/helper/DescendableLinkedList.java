package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DescendableLinkedList extends LinkedList {

    public class DescendingIterator implements Iterator {
        private final ListIterator iter;

        private DescendingIterator(int i) {
            this.iter = DescendableLinkedList.this.listIterator(i);
        }

        public boolean hasNext() {
            return this.iter.hasPrevious();
        }

        public Object next() {
            return this.iter.previous();
        }

        public void remove() {
            this.iter.remove();
        }

        public /* synthetic */ DescendingIterator(DescendableLinkedList descendableLinkedList, int i, 1 r3) {
            this(i);
        }
    }

    public Iterator descendingIterator() {
        return new DescendingIterator(this, size(), null);
    }

    public Object peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    public Object pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    public void push(Object obj) {
        addFirst(obj);
    }
}
