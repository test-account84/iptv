package org.apache.http.conn.util;

import java.util.Collections;
import java.util.List;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class PublicSuffixList {
    private final List exceptions;
    private final List rules;
    private final DomainType type;

    public PublicSuffixList(List list, List list2) {
        this(DomainType.UNKNOWN, list, list2);
    }

    public List getExceptions() {
        return this.exceptions;
    }

    public List getRules() {
        return this.rules;
    }

    public DomainType getType() {
        return this.type;
    }

    public PublicSuffixList(DomainType domainType, List list, List list2) {
        this.type = (DomainType) Args.notNull(domainType, "Domain type");
        this.rules = Collections.unmodifiableList((List) Args.notNull(list, "Domain suffix rules"));
        this.exceptions = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
    }
}
