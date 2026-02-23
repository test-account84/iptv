package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.b;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiInstanceInvalidationService extends Service {
    public int a = 0;
    public final HashMap c = new HashMap();
    public final RemoteCallbackList d = new a();
    public final b.a e = new b();

    public class a extends RemoteCallbackList {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.a aVar, Object obj) {
            HashMap hashMap = MultiInstanceInvalidationService.this.c;
            Integer num = (Integer) obj;
            num.intValue();
            hashMap.remove(num);
        }
    }

    public class b extends b.a {
        public b() {
        }

        public void V(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.d) {
                try {
                    String str = (String) MultiInstanceInvalidationService.this.c.get(Integer.valueOf(i));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int beginBroadcast = MultiInstanceInvalidationService.this.d.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            Integer num = (Integer) MultiInstanceInvalidationService.this.d.getBroadcastCookie(i2);
                            int intValue = num.intValue();
                            String str2 = (String) MultiInstanceInvalidationService.this.c.get(num);
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    ((androidx.room.a) MultiInstanceInvalidationService.this.d.getBroadcastItem(i2)).o(strArr);
                                } catch (RemoteException e) {
                                    Log.w("ROOM", "Error invoking a remote callback", e);
                                }
                            }
                        } finally {
                            MultiInstanceInvalidationService.this.d.finishBroadcast();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void W0(androidx.room.a aVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.d) {
                MultiInstanceInvalidationService.this.d.unregister(aVar);
                MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(i));
            }
        }

        public int n0(androidx.room.a aVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.d) {
                try {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                    int i = multiInstanceInvalidationService.a + 1;
                    multiInstanceInvalidationService.a = i;
                    if (multiInstanceInvalidationService.d.register(aVar, Integer.valueOf(i))) {
                        MultiInstanceInvalidationService.this.c.put(Integer.valueOf(i), str);
                        return i;
                    }
                    MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                    multiInstanceInvalidationService2.a--;
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.e;
    }
}
