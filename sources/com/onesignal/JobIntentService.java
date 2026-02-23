package com.onesignal;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class JobIntentService extends Service {
    public static final Object i = new Object();
    public static final HashMap j = new HashMap();
    public CompatJobEngine a;
    public WorkEnqueuer c;
    public CommandProcessor d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public final ArrayList h = new ArrayList();

    public final class CommandProcessor extends AsyncTask {
        public CommandProcessor() {
        }

        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a = JobIntentService.this.a();
                if (a == null) {
                    return null;
                }
                JobIntentService.this.g(a.getIntent());
                a.complete();
            }
        }

        public void onCancelled(Void r1) {
            JobIntentService.this.i();
        }

        public void onPostExecute(Void r1) {
            JobIntentService.this.i();
        }
    }

    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        public CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        public void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.mLaunchingService) {
                            this.mLaunchingService = true;
                            if (!this.mServiceProcessing) {
                                this.mLaunchWakeLock.acquire(60000L);
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        public void serviceProcessingFinished() {
            synchronized (this) {
                try {
                    if (this.mServiceProcessing) {
                        if (this.mLaunchingService) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                        this.mServiceProcessing = false;
                        this.mRunWakeLock.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void serviceProcessingStarted() {
            synchronized (this) {
                try {
                    if (!this.mServiceProcessing) {
                        this.mServiceProcessing = true;
                        this.mRunWakeLock.acquire(600000L);
                        this.mLaunchWakeLock.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        public CompatWorkItem(Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }

    public static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        public ComponentNameWithWakeful(ComponentName componentName, boolean z) {
            this.componentName = componentName;
            this.useWakefulService = z;
        }
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        public final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            public WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            public void complete() {
                String str;
                String str2;
                synchronized (JobServiceEngineImpl.this.mLock) {
                    JobParameters jobParameters = JobServiceEngineImpl.this.mParams;
                    if (jobParameters != null) {
                        try {
                            L.a(jobParameters, this.mJobWork);
                        } catch (IllegalArgumentException e) {
                            e = e;
                            str = "JobServiceEngineImpl";
                            str2 = "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        } catch (SecurityException e2) {
                            e = e2;
                            str = "JobServiceEngineImpl";
                            str2 = "SecurityException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        }
                    }
                }
            }

            public Intent getIntent() {
                return J.a(this.mJobWork);
            }
        }

        public JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mLock = new Object();
            this.mService = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return K.a(this);
        }

        public GenericWorkItem dequeueWork() {
            synchronized (this.mLock) {
                JobParameters jobParameters = this.mParams;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem a = I.a(jobParameters);
                    if (a == null) {
                        return null;
                    }
                    J.a(a).setExtrasClassLoader(this.mService.getClassLoader());
                    return new WrapperWorkItem(a);
                } catch (SecurityException e) {
                    Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e);
                    return null;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.e(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.mService.b();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return b;
        }
    }

    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        public JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            ensureJobId(i);
            this.mJobInfo = new JobInfo.Builder(i, this.mComponentName).setOverrideDeadline(0L).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        public void enqueueWork(Intent intent) {
            M.a(this.mJobScheduler, this.mJobInfo, N.a(intent));
        }
    }

    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        public WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        public abstract void enqueueWork(Intent intent);

        public void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else {
                if (this.mJobId == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public static void c(Context context, ComponentName componentName, int i2, Intent intent, boolean z) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (i) {
            WorkEnqueuer f = f(context, componentName, true, i2, z);
            f.ensureJobId(i2);
            try {
                f.enqueueWork(intent);
            } catch (IllegalStateException e) {
                if (!z) {
                    throw e;
                }
                f(context, componentName, true, i2, false).enqueueWork(intent);
            }
        }
    }

    public static void d(Context context, Class cls, int i2, Intent intent, boolean z) {
        c(context, new ComponentName(context, cls), i2, intent, z);
    }

    public static WorkEnqueuer f(Context context, ComponentName componentName, boolean z, int i2, boolean z2) {
        WorkEnqueuer compatWorkEnqueuer;
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, z2);
        HashMap hashMap = j;
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) hashMap.get(componentNameWithWakeful);
        if (workEnqueuer == null) {
            if (Build.VERSION.SDK_INT < 26 || z2) {
                compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
            } else {
                if (!z) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
            }
            workEnqueuer = compatWorkEnqueuer;
            hashMap.put(componentNameWithWakeful, workEnqueuer);
        }
        return workEnqueuer;
    }

    public GenericWorkItem a() {
        GenericWorkItem dequeueWork;
        CompatJobEngine compatJobEngine = this.a;
        if (compatJobEngine != null && (dequeueWork = compatJobEngine.dequeueWork()) != null) {
            return dequeueWork;
        }
        synchronized (this.h) {
            try {
                if (this.h.size() > 0) {
                    return (GenericWorkItem) this.h.remove(0);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        CommandProcessor commandProcessor = this.d;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.e);
        }
        this.f = true;
        return h();
    }

    public void e(boolean z) {
        if (this.d == null) {
            this.d = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.c;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    public void i() {
        ArrayList arrayList = this.h;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.d = null;
                    ArrayList arrayList2 = this.h;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.g) {
                        this.c.serviceProcessingFinished();
                    }
                } finally {
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.a;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new JobServiceEngineImpl(this);
            this.c = null;
        }
        this.c = f(this, new ComponentName(this, getClass()), false, 0, true);
    }

    public void onDestroy() {
        super.onDestroy();
        b();
        synchronized (this.h) {
            this.g = true;
            this.c.serviceProcessingFinished();
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        this.c.serviceStartReceived();
        synchronized (this.h) {
            ArrayList arrayList = this.h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            e(true);
        }
        return 3;
    }
}
