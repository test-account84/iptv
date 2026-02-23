package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class UrlEncodedFormEntity extends StringEntity {
    public UrlEncodedFormEntity(Iterable iterable) {
        this(iterable, (Charset) null);
    }

    public UrlEncodedFormEntity(Iterable iterable, Charset charset) {
        super(URLEncodedUtils.format(iterable, charset != null ? charset : HTTP.DEF_CONTENT_CHARSET), ContentType.create("application/x-www-form-urlencoded", charset));
    }

    public UrlEncodedFormEntity(List list) throws UnsupportedEncodingException {
        this((Iterable) list, (Charset) null);
    }

    public UrlEncodedFormEntity(List list, String str) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(list, str != null ? str : HTTP.DEF_CONTENT_CHARSET.name()), ContentType.create("application/x-www-form-urlencoded", str));
    }
}
