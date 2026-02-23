package M;

import M.g;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {
    public static final Comparator a = new c();

    public static class a {
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    public static /* synthetic */ int a(byte[] bArr, byte[] bArr2) {
        return g(bArr, bArr2);
    }

    public static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List d(e eVar, Resources resources) {
        return eVar.b() != null ? eVar.b() : F.e.c(resources, eVar.c());
    }

    public static g.a e(Context context, e eVar, CancellationSignal cancellationSignal) {
        ProviderInfo f = f(context.getPackageManager(), eVar, context.getResources());
        return f == null ? g.a.a(1, null) : g.a.a(0, h(context, eVar, f.authority, cancellationSignal));
    }

    public static ProviderInfo f(PackageManager packageManager, e eVar, Resources resources) {
        String e = eVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e);
        }
        if (!resolveContentProvider.packageName.equals(eVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + e + ", but package was not " + eVar.f());
        }
        List b = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(b, a);
        List d = d(eVar, resources);
        for (int i = 0; i < d.size(); i++) {
            ArrayList arrayList = new ArrayList((Collection) d.get(i));
            Collections.sort(arrayList, a);
            if (c(b, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static M.g.b[] h(android.content.Context r16, M.e r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            r3 = 0
            java.lang.String r4 = "_id"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "font_ttc_index"
            java.lang.String r7 = "font_variation_settings"
            java.lang.String r8 = "font_weight"
            java.lang.String r9 = "font_italic"
            java.lang.String r10 = "result_code"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch: java.lang.Throwable -> L99
            android.content.ContentResolver r4 = r16.getContentResolver()     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = "query = ?"
            java.lang.String r5 = r17.g()     // Catch: java.lang.Throwable -> L99
            java.lang.String[] r8 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L99
            r9 = 0
            r5 = r2
            r10 = r19
            android.database.Cursor r3 = M.d.a.a(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto Ld4
            int r5 = r3.getCount()     // Catch: java.lang.Throwable -> L99
            if (r5 <= 0) goto Ld4
            java.lang.String r1 = "result_code"
            int r1 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L99
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L99
            r5.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = "_id"
            int r6 = r3.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = "file_id"
            int r7 = r3.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = "font_ttc_index"
            int r8 = r3.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r9 = "font_weight"
            int r9 = r3.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = "font_italic"
            int r10 = r3.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L99
        L8b:
            boolean r11 = r3.moveToNext()     // Catch: java.lang.Throwable -> L99
            if (r11 == 0) goto Ld3
            r11 = -1
            if (r1 == r11) goto L9b
            int r12 = r3.getInt(r1)     // Catch: java.lang.Throwable -> L99
            goto L9c
        L99:
            r0 = move-exception
            goto Le3
        L9b:
            r12 = 0
        L9c:
            if (r8 == r11) goto La3
            int r13 = r3.getInt(r8)     // Catch: java.lang.Throwable -> L99
            goto La4
        La3:
            r13 = 0
        La4:
            if (r7 != r11) goto Laf
            long r14 = r3.getLong(r6)     // Catch: java.lang.Throwable -> L99
            android.net.Uri r14 = android.content.ContentUris.withAppendedId(r2, r14)     // Catch: java.lang.Throwable -> L99
            goto Lb7
        Laf:
            long r14 = r3.getLong(r7)     // Catch: java.lang.Throwable -> L99
            android.net.Uri r14 = android.content.ContentUris.withAppendedId(r0, r14)     // Catch: java.lang.Throwable -> L99
        Lb7:
            if (r9 == r11) goto Lbe
            int r15 = r3.getInt(r9)     // Catch: java.lang.Throwable -> L99
            goto Lc0
        Lbe:
            r15 = 400(0x190, float:5.6E-43)
        Lc0:
            if (r10 == r11) goto Lca
            int r11 = r3.getInt(r10)     // Catch: java.lang.Throwable -> L99
            r4 = 1
            if (r11 != r4) goto Lca
            goto Lcb
        Lca:
            r4 = 0
        Lcb:
            M.g$b r4 = M.g.b.a(r14, r13, r15, r4, r12)     // Catch: java.lang.Throwable -> L99
            r5.add(r4)     // Catch: java.lang.Throwable -> L99
            goto L8b
        Ld3:
            r1 = r5
        Ld4:
            if (r3 == 0) goto Ld9
            r3.close()
        Ld9:
            r0 = 0
            M.g$b[] r0 = new M.g.b[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            M.g$b[] r0 = (M.g.b[]) r0
            return r0
        Le3:
            if (r3 == 0) goto Le8
            r3.close()
        Le8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M.d.h(android.content.Context, M.e, java.lang.String, android.os.CancellationSignal):M.g$b[]");
    }
}
