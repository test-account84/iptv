package com.amazonaws.util.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DateDeserializer implements JsonDeserializer, JsonSerializer {
    private final List dateFormats;
    private final SimpleDateFormat mIso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private SimpleDateFormat mSimpleDateFormat;

    public DateDeserializer(String[] strArr) {
        this.dateFormats = Arrays.asList(strArr);
    }

    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        String asString = jsonElement.getAsString();
        for (String str : this.dateFormats) {
            try {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                this.mSimpleDateFormat = simpleDateFormat;
                date.setTime(simpleDateFormat.parse(asString).getTime());
                return date;
            } catch (ParseException unused) {
            }
        }
        try {
            return DateFormat.getDateInstance(2).parse(asString);
        } catch (ParseException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        synchronized (this.mIso8601DateFormat) {
            jsonPrimitive = new JsonPrimitive(this.mIso8601DateFormat.format(date));
        }
        return jsonPrimitive;
    }
}
