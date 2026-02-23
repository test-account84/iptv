package g7;

import android.util.Log;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m {
    public final Lock a;
    public Condition b;
    public boolean c;
    public boolean d;

    public m() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.c = false;
        this.d = false;
    }

    public void a() {
        this.a.lock();
        try {
            Log.v("ThreadControl", "Cancelling");
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        this.a.lock();
        Log.v("ThreadControl", "Pausing");
        this.c = true;
        this.a.unlock();
    }

    public void d() {
        this.a.lock();
        try {
            Log.v("ThreadControl", "Resuming");
            if (this.c) {
                this.c = false;
                this.b.signalAll();
            }
        } finally {
            this.a.unlock();
        }
    }

    public void e() {
        this.a.lock();
        while (this.c && !this.d) {
            try {
                Log.v("ThreadControl", "Going to wait");
                this.b.await();
                Log.v("ThreadControl", "Done waiting");
            } finally {
                this.a.unlock();
            }
        }
    }
}
