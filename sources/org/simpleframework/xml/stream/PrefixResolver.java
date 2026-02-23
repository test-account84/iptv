package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class PrefixResolver extends LinkedHashMap implements NamespaceMap {
    private final OutputNode source;

    public PrefixResolver(OutputNode outputNode) {
        this.source = outputNode;
    }

    private String resolvePrefix(String str) {
        NamespaceMap namespaces = this.source.getNamespaces();
        if (namespaces == null) {
            return null;
        }
        String prefix = namespaces.getPrefix(str);
        if (containsValue(prefix)) {
            return null;
        }
        return prefix;
    }

    private String resolveReference(String str) {
        NamespaceMap namespaces = this.source.getNamespaces();
        if (namespaces != null) {
            return namespaces.getReference(str);
        }
        return null;
    }

    public String getPrefix() {
        return this.source.getPrefix();
    }

    public String getReference(String str) {
        if (containsValue(str)) {
            Iterator it = iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = (String) get(str2);
                if (str3 != null && str3.equals(str)) {
                    return str2;
                }
            }
        }
        return resolveReference(str);
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    public String setReference(String str) {
        return setReference(str, "");
    }

    public String getPrefix(String str) {
        String str2;
        return (size() <= 0 || (str2 = (String) get(str)) == null) ? resolvePrefix(str) : str2;
    }

    public String setReference(String str, String str2) {
        if (resolvePrefix(str) != null) {
            return null;
        }
        return (String) put(str, str2);
    }
}
