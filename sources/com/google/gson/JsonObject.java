package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap members = new LinkedTreeMap();

    public void add(String str, JsonElement jsonElement) {
        LinkedTreeMap linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public Set entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public JsonElement get(String str) {
        return (JsonElement) this.members.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String str) {
        return (JsonElement) this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Character ch) {
        add(str, ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : this.members.entrySet()) {
            jsonObject.add((String) entry.getKey(), ((JsonElement) entry.getValue()).deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? JsonNull.INSTANCE : new JsonPrimitive(str2));
    }
}
