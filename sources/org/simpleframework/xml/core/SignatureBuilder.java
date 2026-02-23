package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class SignatureBuilder {
    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    public static class ParameterList extends ArrayList {
        public ParameterList() {
        }

        public ParameterList(ParameterList parameterList) {
            super(parameterList);
        }
    }

    public static class ParameterTable extends ArrayList {
        public static /* synthetic */ int access$000(ParameterTable parameterTable) {
            return parameterTable.width();
        }

        public static /* synthetic */ int access$100(ParameterTable parameterTable) {
            return parameterTable.height();
        }

        private int height() {
            if (width() > 0) {
                return get(0).size();
            }
            return 0;
        }

        private int width() {
            return size();
        }

        public void insert(Parameter parameter, int i) {
            ParameterList parameterList = get(i);
            if (parameterList != null) {
                parameterList.add(parameter);
            }
        }

        public Parameter get(int i, int i2) {
            return (Parameter) get(i).get(i2);
        }

        public ParameterList get(int i) {
            for (int size = size(); size <= i; size++) {
                add(new ParameterList());
            }
            return (ParameterList) super.get(i);
        }
    }

    public SignatureBuilder(Constructor constructor) {
        this.factory = constructor;
    }

    private List create() throws Exception {
        ArrayList arrayList = new ArrayList();
        Signature signature = new Signature(this.factory);
        if (isValid()) {
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void populate(ParameterTable parameterTable, ParameterList parameterList, int i) {
        ParameterList parameterList2 = this.table.get(i);
        int size = parameterList.size();
        int size2 = parameterList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            for (int i3 = 0; i3 < size; i3++) {
                parameterTable.get(i3).add((Parameter) parameterList.get(i3));
            }
            parameterTable.get(i).add((Parameter) parameterList2.get(i2));
        }
    }

    public List build() throws Exception {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i) {
        this.table.insert(parameter, i);
    }

    public boolean isValid() {
        return this.factory.getParameterTypes().length == ParameterTable.access$000(this.table);
    }

    private List build(ParameterTable parameterTable) throws Exception {
        if (this.table.isEmpty()) {
            return create();
        }
        build(parameterTable, 0);
        return create(parameterTable);
    }

    private List create(ParameterTable parameterTable) throws Exception {
        ArrayList arrayList = new ArrayList();
        int access$100 = ParameterTable.access$100(parameterTable);
        int access$000 = ParameterTable.access$000(parameterTable);
        for (int i = 0; i < access$100; i++) {
            Signature signature = new Signature(this.factory);
            for (int i2 = 0; i2 < access$000; i2++) {
                Parameter parameter = parameterTable.get(i2, i);
                String path = parameter.getPath();
                if (signature.contains(parameter.getKey())) {
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", path, this.factory);
                }
                signature.add(parameter);
            }
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void build(ParameterTable parameterTable, int i) {
        build(parameterTable, new ParameterList(), i);
    }

    private void build(ParameterTable parameterTable, ParameterList parameterList, int i) {
        ParameterList parameterList2 = this.table.get(i);
        int size = parameterList2.size();
        if (ParameterTable.access$000(this.table) - 1 <= i) {
            populate(parameterTable, parameterList, i);
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ParameterList parameterList3 = new ParameterList(parameterList);
            if (parameterList != null) {
                parameterList3.add((Parameter) parameterList2.get(i2));
                build(parameterTable, parameterList3, i + 1);
            }
        }
    }
}
