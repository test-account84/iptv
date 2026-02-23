package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LinkedTreeMap extends AbstractMap implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator NATURAL_ORDER = new 1();
    Comparator comparator;
    private EntrySet entrySet;
    final Node header;
    private KeySet keySet;
    int modCount;
    Node root;
    int size;

    public class 1 implements Comparator {
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class EntrySet extends AbstractSet {

        public class 1 extends LinkedTreeMapIterator {
            public 1() {
                super();
            }

            public Map.Entry next() {
                return nextNode();
            }
        }

        public EntrySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator iterator() {
            return new 1();
        }

        public boolean remove(Object obj) {
            Node findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public final class KeySet extends AbstractSet {

        public class 1 extends LinkedTreeMapIterator {
            public 1() {
                super();
            }

            public Object next() {
                return nextNode().key;
            }
        }

        public KeySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new 1();
        }

        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator implements Iterator {
        int expectedModCount;
        Node lastReturned = null;
        Node next;

        public LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }

        public final Node nextNode() {
            Node node = this.next;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = node.next;
            this.lastReturned = node;
            return node;
        }

        public final void remove() {
            Node node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
    }

    public static final class Node implements Map.Entry {
        int height;
        final Object key;
        Node left;
        Node next;
        Node parent;
        Node prev;
        Node right;
        Object value;

        public Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.key;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.value;
            Object value = entry.getValue();
            if (obj3 == null) {
                if (value != null) {
                    return false;
                }
            } else if (!obj3.equals(value)) {
                return false;
            }
            return true;
        }

        public Node first() {
            Node node = this;
            for (Node node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            Object obj = this.key;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.value;
            return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        public Node last() {
            Node node = this;
            for (Node node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }

        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node node, Object obj, Node node2, Node node3) {
            this.parent = node;
            this.key = obj;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node node, boolean z) {
        while (node != null) {
            Node node2 = node.left;
            Node node3 = node.right;
            int i = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node node4 = node3.left;
                Node node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(node3);
                }
                rotateLeft(node);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node node6 = node2.left;
                Node node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(node2);
                }
                rotateRight(node);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node node, Node node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.root = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rotateLeft(Node node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int max = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node.height = max;
        node3.height = Math.max(max, node5 != null ? node5.height : 0) + 1;
    }

    private void rotateRight(Node node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int max = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node.height = max;
        node2.height = Math.max(max, node4 != null ? node4.height : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node node = this.header;
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public Node find(Object obj, boolean z) {
        int i;
        Node node;
        Comparator comparator = this.comparator;
        Node node2 = this.root;
        if (node2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) obj : null;
            while (true) {
                Object obj2 = node2.key;
                i = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i == 0) {
                    return node2;
                }
                Node node3 = i < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        Node node4 = this.header;
        if (node2 != null) {
            node = new Node(node2, obj, node4, node4.prev);
            if (i < 0) {
                node2.left = node;
            } else {
                node2.right = node;
            }
            rebalance(node2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            node = new Node(node2, obj, node4, node4.prev);
            this.root = node;
        }
        this.size++;
        this.modCount++;
        return node;
    }

    public Node findByEntry(Map.Entry entry) {
        Node findByObject = findByObject(entry.getKey());
        if (findByObject == null || !equal(findByObject.value, entry.getValue())) {
            return null;
        }
        return findByObject;
    }

    public Node findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public Object get(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public Set keySet() {
        KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        Node find = find(obj, true);
        Object obj3 = find.value;
        find.value = obj2;
        return obj3;
    }

    public Object remove(Object obj) {
        Node removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    public void removeInternal(Node node, boolean z) {
        int i;
        if (z) {
            Node node2 = node.prev;
            node2.next = node.next;
            node.next.prev = node2;
        }
        Node node3 = node.left;
        Node node4 = node.right;
        Node node5 = node.parent;
        int i2 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                replaceInParent(node, node3);
                node.left = null;
            } else if (node4 != null) {
                replaceInParent(node, node4);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node5, false);
            this.size--;
            this.modCount++;
            return;
        }
        Node last = node3.height > node4.height ? node3.last() : node4.first();
        removeInternal(last, false);
        Node node6 = node.left;
        if (node6 != null) {
            i = node6.height;
            last.left = node6;
            node6.parent = last;
            node.left = null;
        } else {
            i = 0;
        }
        Node node7 = node.right;
        if (node7 != null) {
            i2 = node7.height;
            last.right = node7;
            node7.parent = last;
            node.right = null;
        }
        last.height = Math.max(i, i2) + 1;
        replaceInParent(node, last);
    }

    public Node removeInternalByKey(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }
}
