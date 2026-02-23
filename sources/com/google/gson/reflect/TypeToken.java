package com.google.gson.reflect;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TypeToken {
    final int hashCode;
    final Class rawType;
    final Type type;

    public TypeToken() {
        Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = $Gson$Types.getRawType(superclassTypeParameter);
        this.hashCode = superclassTypeParameter.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError(sb.toString());
    }

    public static TypeToken get(Class cls) {
        return new TypeToken(cls);
    }

    public static TypeToken getArray(Type type) {
        return new TypeToken($Gson$Types.arrayOf(type));
    }

    public static TypeToken getParameterized(Type type, Type... typeArr) {
        return new TypeToken($Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
    }

    public static Type getSuperclassTypeParameter(Class cls) {
        ParameterizedType genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return $Gson$Types.canonicalize(genericSuperclass.getActualTypeArguments()[0]);
    }

    private static boolean matches(Type type, Type type2, Map map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && $Gson$Types.equals(this.type, ((TypeToken) obj).type);
    }

    public final Class getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }

    public TypeToken(Type type) {
        Type canonicalize = $Gson$Types.canonicalize((Type) $Gson$Preconditions.checkNotNull(type));
        this.type = canonicalize;
        this.rawType = $Gson$Types.getRawType(canonicalize);
        this.hashCode = canonicalize.hashCode();
    }

    public static TypeToken get(Type type) {
        return new TypeToken(type);
    }

    @Deprecated
    public boolean isAssignableFrom(Class cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        ParameterizedType parameterizedType = this.type;
        if (parameterizedType instanceof Class) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(type));
        }
        if (parameterizedType instanceof ParameterizedType) {
            return isAssignableFrom(type, parameterizedType, new HashMap());
        }
        if (parameterizedType instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(type)) && isAssignableFrom(type, this.type);
        }
        throw buildUnexpectedTypeError(parameterizedType, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        ParameterizedType genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, genericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class rawType = $Gson$Types.getRawType(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type) map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type3 : rawType.getGenericInterfaces()) {
            if (isAssignableFrom(type3, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }
}
