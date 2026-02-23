package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface ITrustedWebActivityService extends IInterface {

    public static class Default implements ITrustedWebActivityService {
        public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }

        public void cancelNotification(Bundle bundle) throws RemoteException {
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
            return null;
        }

        public Bundle getActiveNotifications() throws RemoteException {
            return null;
        }

        public Bundle getSmallIconBitmap() throws RemoteException {
            return null;
        }

        public int getSmallIconId() throws RemoteException {
            return 0;
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {
        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_extraCommand = 9;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        public static class Proxy implements ITrustedWebActivityService {
            public static ITrustedWebActivityService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Bundle areNotificationsEnabled = Stub.getDefaultImpl().areNotificationsEnabled(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return areNotificationsEnabled;
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancelNotification(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelNotification(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Bundle extraCommand = Stub.getDefaultImpl().extraCommand(str, bundle, iBinder);
                        obtain2.recycle();
                        obtain.recycle();
                        return extraCommand;
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public Bundle getActiveNotifications() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveNotifications();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityService";
            }

            public Bundle getSmallIconBitmap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconBitmap();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSmallIconId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconId();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Bundle notifyNotificationWithChannel = Stub.getDefaultImpl().notifyNotificationWithChannel(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return notifyNotificationWithChannel;
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        public static ITrustedWebActivityService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityService)) ? new Proxy(iBinder) : (ITrustedWebActivityService) queryLocalInterface;
        }

        public static ITrustedWebActivityService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITrustedWebActivityService iTrustedWebActivityService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTrustedWebActivityService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTrustedWebActivityService;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 9) {
                parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                Bundle extraCommand = extraCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                if (extraCommand != null) {
                    parcel2.writeInt(1);
                    extraCommand.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
                return true;
            }
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle notifyNotificationWithChannel = notifyNotificationWithChannel(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (notifyNotificationWithChannel != null) {
                        parcel2.writeInt(1);
                        notifyNotificationWithChannel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    cancelNotification(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    int smallIconId = getSmallIconId();
                    parcel2.writeNoException();
                    parcel2.writeInt(smallIconId);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle activeNotifications = getActiveNotifications();
                    parcel2.writeNoException();
                    if (activeNotifications != null) {
                        parcel2.writeInt(1);
                        activeNotifications.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle areNotificationsEnabled = areNotificationsEnabled(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (areNotificationsEnabled != null) {
                        parcel2.writeInt(1);
                        areNotificationsEnabled.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle smallIconBitmap = getSmallIconBitmap();
                    parcel2.writeNoException();
                    if (smallIconBitmap != null) {
                        parcel2.writeInt(1);
                        smallIconBitmap.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException;

    void cancelNotification(Bundle bundle) throws RemoteException;

    Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException;

    Bundle getActiveNotifications() throws RemoteException;

    Bundle getSmallIconBitmap() throws RemoteException;

    int getSmallIconId() throws RemoteException;

    Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException;
}
