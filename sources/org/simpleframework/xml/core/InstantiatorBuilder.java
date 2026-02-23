package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InstantiatorBuilder {
    private Detail detail;
    private Instantiator factory;
    private Scanner scanner;
    private List options = new ArrayList();
    private Comparer comparer = new Comparer();
    private LabelMap attributes = new LabelMap();
    private LabelMap elements = new LabelMap();
    private LabelMap texts = new LabelMap();

    public InstantiatorBuilder(Scanner scanner, Detail detail) {
        this.scanner = scanner;
        this.detail = detail;
    }

    private boolean contains(String[] strArr, String str) throws Exception {
        for (String str2 : strArr) {
            if (str2 == str || str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private Creator create(Signature signature) {
        SignatureCreator signatureCreator = new SignatureCreator(signature);
        if (signature != null) {
            this.options.add(signatureCreator);
        }
        return signatureCreator;
    }

    private void populate(Detail detail) throws Exception {
        Iterator it = this.scanner.getSignatures().iterator();
        while (it.hasNext()) {
            populate((Signature) it.next());
        }
    }

    private Label resolve(Parameter parameter) throws Exception {
        return resolve(parameter, parameter.isAttribute() ? this.attributes : parameter.isText() ? this.texts : this.elements);
    }

    private void validate(Detail detail) throws Exception {
        for (Parameter parameter : this.scanner.getParameters().getAll()) {
            Label resolve = resolve(parameter);
            String path = parameter.getPath();
            if (resolve == null) {
                throw new ConstructorException("Parameter '%s' does not have a match in %s", path, detail);
            }
            validateParameter(resolve, parameter);
        }
        validateConstructors();
    }

    private void validateAnnotations(Label label, Parameter parameter) throws Exception {
        Annotation annotation = label.getAnnotation();
        Annotation annotation2 = parameter.getAnnotation();
        String name = parameter.getName();
        if (this.comparer.equals(annotation, annotation2)) {
            return;
        }
        Class annotationType = annotation.annotationType();
        Class annotationType2 = annotation2.annotationType();
        if (!annotationType.equals(annotationType2)) {
            throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", annotationType2, annotationType, name, parameter);
        }
    }

    private void validateConstructor(Label label, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Signature signature = ((Creator) it.next()).getSignature();
            Contact contact = label.getContact();
            Object key = label.getKey();
            if (contact.isReadOnly() && signature.get(key) == null) {
                it.remove();
            }
        }
    }

    private void validateConstructors() throws Exception {
        List creators = this.factory.getCreators();
        if (this.factory.isDefault()) {
            validateConstructors(this.elements);
            validateConstructors(this.attributes);
        }
        if (creators.isEmpty()) {
            return;
        }
        validateConstructors(this.elements, creators);
        validateConstructors(this.attributes, creators);
    }

    private void validateNames(Label label, Parameter parameter) throws Exception {
        String name;
        String[] names = label.getNames();
        String name2 = parameter.getName();
        if (contains(names, name2) || name2 == (name = label.getName())) {
            return;
        }
        if (name2 == null || name == null) {
            throw new ConstructorException("Annotation does not match %s for '%s' in %s", label, name2, parameter);
        }
        if (!name2.equals(name)) {
            throw new ConstructorException("Annotation does not match %s for '%s' in %s", label, name2, parameter);
        }
    }

    private void validateParameter(Label label, Parameter parameter) throws Exception {
        Contact contact = label.getContact();
        String name = parameter.getName();
        if (!Support.isAssignable(parameter.getType(), contact.getType())) {
            throw new ConstructorException("Type is not compatible with %s for '%s' in %s", label, name, parameter);
        }
        validateNames(label, parameter);
        validateAnnotations(label, parameter);
    }

    public Instantiator build() throws Exception {
        if (this.factory == null) {
            populate(this.detail);
            build(this.detail);
            validate(this.detail);
        }
        return this.factory;
    }

    public void register(Label label) throws Exception {
        register(label, label.isAttribute() ? this.attributes : label.isText() ? this.texts : this.elements);
    }

    private Instantiator build(Detail detail) throws Exception {
        if (this.factory == null) {
            this.factory = create(detail);
        }
        return this.factory;
    }

    private Instantiator create(Detail detail) throws Exception {
        Signature signature = this.scanner.getSignature();
        return new ClassInstantiator(this.options, signature != null ? new SignatureCreator(signature) : null, this.scanner.getParameters(), detail);
    }

    private void populate(Signature signature) throws Exception {
        Signature signature2 = new Signature(signature);
        Iterator it = signature.iterator();
        while (it.hasNext()) {
            Parameter create = create((Parameter) it.next());
            if (create != null) {
                signature2.add(create);
            }
        }
        create(signature2);
    }

    private void register(Label label, LabelMap labelMap) throws Exception {
        String name = label.getName();
        String path = label.getPath();
        if (!labelMap.containsKey(name)) {
            labelMap.put(name, label);
        } else if (!((Label) labelMap.get(name)).getPath().equals(name)) {
            labelMap.remove(name);
        }
        labelMap.put(path, label);
    }

    private Label resolve(Parameter parameter, LabelMap labelMap) throws Exception {
        String name = parameter.getName();
        Label label = (Label) labelMap.get(parameter.getPath());
        return label == null ? (Label) labelMap.get(name) : label;
    }

    private void validateConstructors(LabelMap labelMap) throws Exception {
        Iterator it = labelMap.iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label != null && label.getContact().isReadOnly()) {
                throw new ConstructorException("Default constructor can not accept read only %s in %s", label, this.detail);
            }
        }
    }

    private Parameter create(Parameter parameter) throws Exception {
        Label resolve = resolve(parameter);
        if (resolve != null) {
            return new CacheParameter(parameter, resolve);
        }
        return null;
    }

    private void validateConstructors(LabelMap labelMap, List list) throws Exception {
        Iterator it = labelMap.iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label != null) {
                validateConstructor(label, list);
            }
        }
        if (list.isEmpty()) {
            throw new ConstructorException("No constructor accepts all read only values in %s", this.detail);
        }
    }
}
