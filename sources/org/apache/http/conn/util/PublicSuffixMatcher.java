package org.apache.http.conn.util;

import j$.util.concurrent.ConcurrentHashMap;
import java.net.IDN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class PublicSuffixMatcher {
    private final Map exceptions;
    private final Map rules;

    public PublicSuffixMatcher(Collection collection) {
        Args.notNull(collection, "Domain suffix lists");
        this.rules = new ConcurrentHashMap();
        this.exceptions = new ConcurrentHashMap();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            PublicSuffixList publicSuffixList = (PublicSuffixList) it.next();
            DomainType type = publicSuffixList.getType();
            Iterator it2 = publicSuffixList.getRules().iterator();
            while (it2.hasNext()) {
                this.rules.put((String) it2.next(), type);
            }
            List exceptions = publicSuffixList.getExceptions();
            if (exceptions != null) {
                Iterator it3 = exceptions.iterator();
                while (it3.hasNext()) {
                    this.exceptions.put((String) it3.next(), type);
                }
            }
        }
    }

    private static boolean hasEntry(Map map, String str, DomainType domainType) {
        DomainType domainType2;
        if (map == null || (domainType2 = (DomainType) map.get(str)) == null) {
            return false;
        }
        return domainType == null || domainType2.equals(domainType);
    }

    private boolean hasException(String str, DomainType domainType) {
        return hasEntry(this.exceptions, str, domainType);
    }

    private boolean hasRule(String str, DomainType domainType) {
        return hasEntry(this.rules, str, domainType);
    }

    public String getDomainRoot(String str) {
        return getDomainRoot(str, null);
    }

    public boolean matches(String str) {
        return matches(str, null);
    }

    public PublicSuffixMatcher(Collection collection, Collection collection2) {
        this(DomainType.UNKNOWN, collection, collection2);
    }

    public String getDomainRoot(String str, DomainType domainType) {
        if (str == null || str.startsWith(".")) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        String str2 = null;
        while (lowerCase != null) {
            if (!hasException(IDN.toUnicode(lowerCase), domainType)) {
                if (hasRule(IDN.toUnicode(lowerCase), domainType)) {
                    break;
                }
                int indexOf = lowerCase.indexOf(46);
                String substring = indexOf != -1 ? lowerCase.substring(indexOf + 1) : null;
                if (substring != null) {
                    if (hasRule("*." + IDN.toUnicode(substring), domainType)) {
                        break;
                    }
                }
                if (indexOf != -1) {
                    str2 = lowerCase;
                }
                lowerCase = substring;
            } else {
                return lowerCase;
            }
        }
        return str2;
    }

    public boolean matches(String str, DomainType domainType) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        return getDomainRoot(str, domainType) == null;
    }

    public PublicSuffixMatcher(DomainType domainType, Collection collection, Collection collection2) {
        Args.notNull(domainType, "Domain type");
        Args.notNull(collection, "Domain suffix rules");
        this.rules = new ConcurrentHashMap(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.rules.put((String) it.next(), domainType);
        }
        this.exceptions = new ConcurrentHashMap();
        if (collection2 != null) {
            Iterator it2 = collection2.iterator();
            while (it2.hasNext()) {
                this.exceptions.put((String) it2.next(), domainType);
            }
        }
    }
}
