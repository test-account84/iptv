package T1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends g {
    public static final UriMatcher d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        d = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public i(Context context, Uri uri) {
        super(context, uri);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) {
        inputStream.close();
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InputStream d(Uri uri, ContentResolver contentResolver) {
        return g(uri, contentResolver, d.match(uri));
    }

    public final InputStream g(Uri uri, ContentResolver contentResolver, int i) {
        if (i != 1 && i != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i == 1 && (uri = ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return h(contentResolver, uri);
    }

    public final InputStream h(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
