package org.simpleframework.xml.core;

import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DetailExtractor {
    private final Cache details;
    private final Cache fields;
    private final Cache methods;
    private final DefaultType override;
    private final Support support;

    public DetailExtractor(Support support) {
        this(support, null);
    }

    public Detail getDetail(Class cls) {
        Detail detail = (Detail) this.details.fetch(cls);
        if (detail != null) {
            return detail;
        }
        DetailScanner detailScanner = new DetailScanner(cls, this.override);
        this.details.cache(cls, detailScanner);
        return detailScanner;
    }

    public ContactList getFields(Class cls) throws Exception {
        Detail detail;
        ContactList contactList = (ContactList) this.fields.fetch(cls);
        return (contactList != null || (detail = getDetail(cls)) == null) ? contactList : getFields(cls, detail);
    }

    public ContactList getMethods(Class cls) throws Exception {
        Detail detail;
        ContactList contactList = (ContactList) this.methods.fetch(cls);
        return (contactList != null || (detail = getDetail(cls)) == null) ? contactList : getMethods(cls, detail);
    }

    public DetailExtractor(Support support, DefaultType defaultType) {
        this.methods = new ConcurrentCache();
        this.fields = new ConcurrentCache();
        this.details = new ConcurrentCache();
        this.override = defaultType;
        this.support = support;
    }

    private ContactList getFields(Class cls, Detail detail) throws Exception {
        FieldScanner fieldScanner = new FieldScanner(detail, this.support);
        if (detail != null) {
            this.fields.cache(cls, fieldScanner);
        }
        return fieldScanner;
    }

    private ContactList getMethods(Class cls, Detail detail) throws Exception {
        MethodScanner methodScanner = new MethodScanner(detail, this.support);
        if (detail != null) {
            this.methods.cache(cls, methodScanner);
        }
        return methodScanner;
    }
}
