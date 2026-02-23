package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ClassInstantiator implements Instantiator {
    private final List creators;
    private final Detail detail;
    private final Creator primary;
    private final ParameterMap registry;

    public ClassInstantiator(List list, Creator creator, ParameterMap parameterMap, Detail detail) {
        this.creators = list;
        this.registry = parameterMap;
        this.primary = creator;
        this.detail = detail;
    }

    private Creator getCreator(Criteria criteria) throws Exception {
        Creator creator = this.primary;
        double d = 0.0d;
        for (Creator creator2 : this.creators) {
            double score = creator2.getScore(criteria);
            if (score > d) {
                creator = creator2;
                d = score;
            }
        }
        return creator;
    }

    public List getCreators() {
        return new ArrayList(this.creators);
    }

    public Object getInstance() throws Exception {
        return this.primary.getInstance();
    }

    public Parameter getParameter(String str) {
        return (Parameter) this.registry.get(str);
    }

    public List getParameters() {
        return this.registry.getAll();
    }

    public boolean isDefault() {
        return this.creators.size() <= 1 && this.primary != null;
    }

    public String toString() {
        return String.format("creator for %s", new Object[]{this.detail});
    }

    public Object getInstance(Criteria criteria) throws Exception {
        Creator creator = getCreator(criteria);
        if (creator != null) {
            return creator.getInstance(criteria);
        }
        throw new PersistenceException("Constructor not matched for %s", this.detail);
    }
}
