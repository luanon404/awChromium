/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.widget.directwriting;

/**
 * Direct writing service Interface definition for Samsung Platform's stylus handwriting recognition
 * service. These are the service APIs exposed to use the platform's handwriting recognition service
 * so that recognized text can be committed to input fields. Data needed to achieve functionality of
 * each API needs to be bundled in the expected format with keys and values as defined here.
 */
public interface IDirectWritingService extends android.os.IInterface {
    /**
     * Default implementation for IDirectWritingService.
     */
    class Default implements android.widget.directwriting.IDirectWritingService {
        /**
         * Gets version of Aidl
         *
         * @returns version IDirectWritingService.VERSION
         */
        @Override
        public int getVersion() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Registers callback for service
         *
         * @param callback    is IDirectWritingServiceCallback
         * @param packageName is Package name of bounded context
         * @returns true if success
         */
        @Override
        public boolean registerCallback(android.widget.directwriting.IDirectWritingServiceCallback callback, java.lang.String packageName) throws android.os.RemoteException {
            return false;
        }

        /**
         * Unregisters callback for service
         *
         * @param callback is IDirectWritingServiceCallback
         * @returns true if success
         */
        @Override
        public boolean unregisterCallback(android.widget.directwriting.IDirectWritingServiceCallback callback) throws android.os.RemoteException {
            return false;
        }

        /**
         * Gets package name of bounded process
         *
         * @returns package name of bounded process
         */
        @Override
        public java.lang.String getPackageName() throws android.os.RemoteException {
            return null;
        }

        /**
         * When Stylus pen's Motion event is detected by direct writing trigger,
         * Calls service to start direct writing recognition
         *
         * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
         *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
         * @returns true if recognition is started
         */
        @Override
        public boolean onStartRecognition(android.os.Bundle bundle) throws android.os.RemoteException {
            return false;
        }

        /**
         * When Stylus pen's Motion event is not intended to drawing
         * (e.g. when it's small amount of move)
         * Calls service to stop direct writing recognition
         *
         * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
         *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
         * @returns true if recognition is stopped
         */
        @Override
        public boolean onStopRecognition(android.os.Bundle bundle) throws android.os.RemoteException {
            return false;
        }

        /**
         * When current editing element bounds are changed in view, notify the service.
         *
         * @param bundle is KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
         *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
         * @returns true if onBoundedEditTextChanged successful
         */
        @Override
        public boolean onBoundedEditTextChanged(android.os.Bundle bundle) throws android.os.RemoteException {
            return false;
        }

        /**
         * When window lost focus, notify the service
         *
         * @param packageName which is currently bound to service.
         */
        @Override
        public void onWindowFocusLost(java.lang.String packageName) throws android.os.RemoteException {
        }

        /**
         * Dispatch Motion Event to service for drawing
         *
         * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_ROOT_VIEW_RECT
         */
        @Override
        public void onDispatchEvent(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        /**
         * Notify to Direct Writing service when current Editing element's paste popup is shown to hide
         * the direct writing service floating toolbar. This API can be used for any use case where we
         * wish to hide this toolbar ex: changed focus to another tab, tap with finger instead of stylus,
         * and so on.
         *
         * @param bundle is KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
         */
        @Override
        public void onEditTextActionModeStarted(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        /**
         * Gets configuration from Remote service after service is connected.
         *
         * @param bundle is for configuration
         *               KEY_BUNDLE_CONFIG_HIDE_DELAY,
         *               KEY_BUNDLE_CONFIG_KEEP_WRITING_DELAY,
         *               KEY_BUNDLE_CONFIG_MAX_DISTANCE,
         *               KEY_BUNDLE_CONFIG_TRIGGER_VERTICAL_SPACE
         *               KEY_BUNDLE_CONFIG_TRIGGER_HORIZONTAL_SPACE_DEFAULT
         */
        @Override
        public void getConfiguration(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        /**
         * Notify to Direct Writing service when Edit field updates ImeOptions
         *
         * @param imeOptions is ImeOptions
         */
        @Override
        public void onUpdateImeOptions(int imeOptions) throws android.os.RemoteException {
        }
        // { Common Extra

        /**
         * Extra Command for future use.
         * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
         *
         * @param action is for future use
         * @param bundle is for future use
         */
        @Override
        public void onExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
        }
        // Common Extra }
        // { TextView

        /**
         * TextView Extra Command for future use.
         * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
         *
         * @param action is for future use
         * @param bundle is for future use
         */
        @Override
        public void onTextViewExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements android.widget.directwriting.IDirectWritingService {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.widget.directwriting.IDirectWritingService interface,
         * generating a proxy if needed.
         */
        public static android.widget.directwriting.IDirectWritingService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof android.widget.directwriting.IDirectWritingService))) {
                return ((android.widget.directwriting.IDirectWritingService) iin);
            }
            return new android.widget.directwriting.IDirectWritingService.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            java.lang.String descriptor = DESCRIPTOR;
            if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
                data.enforceInterface(descriptor);
            }
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
            }
            switch (code) {
                case TRANSACTION_getVersion: {
                    int _result = this.getVersion();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_registerCallback: {
                    android.widget.directwriting.IDirectWritingServiceCallback _arg0;
                    _arg0 = android.widget.directwriting.IDirectWritingServiceCallback.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _result = this.registerCallback(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_unregisterCallback: {
                    android.widget.directwriting.IDirectWritingServiceCallback _arg0;
                    _arg0 = android.widget.directwriting.IDirectWritingServiceCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result = this.unregisterCallback(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_getPackageName: {
                    java.lang.String _result = this.getPackageName();
                    reply.writeNoException();
                    reply.writeString(_result);
                    break;
                }
                case TRANSACTION_onStartRecognition: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    boolean _result = this.onStartRecognition(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_onStopRecognition: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    boolean _result = this.onStopRecognition(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_onBoundedEditTextChanged: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    boolean _result = this.onBoundedEditTextChanged(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_onWindowFocusLost: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.onWindowFocusLost(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_onDispatchEvent: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.onDispatchEvent(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_onEditTextActionModeStarted: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.onEditTextActionModeStarted(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_getConfiguration: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.getConfiguration(_arg0);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _arg0, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    break;
                }
                case TRANSACTION_onUpdateImeOptions: {
                    int _arg0;
                    _arg0 = data.readInt();
                    this.onUpdateImeOptions(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_onExtraCommand: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.Bundle _arg1;
                    _arg1 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.onExtraCommand(_arg0, _arg1);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _arg1, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    break;
                }
                case TRANSACTION_onTextViewExtraCommand: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.Bundle _arg1;
                    _arg1 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.onTextViewExtraCommand(_arg0, _arg1);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _arg1, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements android.widget.directwriting.IDirectWritingService {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Gets version of Aidl
             *
             * @returns version IDirectWritingService.VERSION
             */
            @Override
            public int getVersion() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getVersion, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Registers callback for service
             *
             * @param callback    is IDirectWritingServiceCallback
             * @param packageName is Package name of bounded context
             * @returns true if success
             */
            @Override
            public boolean registerCallback(android.widget.directwriting.IDirectWritingServiceCallback callback, java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    _data.writeString(packageName);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Unregisters callback for service
             *
             * @param callback is IDirectWritingServiceCallback
             * @returns true if success
             */
            @Override
            public boolean unregisterCallback(android.widget.directwriting.IDirectWritingServiceCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Gets package name of bounded process
             *
             * @returns package name of bounded process
             */
            @Override
            public java.lang.String getPackageName() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPackageName, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * When Stylus pen's Motion event is detected by direct writing trigger,
             * Calls service to start direct writing recognition
             *
             * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
             *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
             * @returns true if recognition is started
             */
            @Override
            public boolean onStartRecognition(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onStartRecognition, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * When Stylus pen's Motion event is not intended to drawing
             * (e.g. when it's small amount of move)
             * Calls service to stop direct writing recognition
             *
             * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
             *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
             * @returns true if recognition is stopped
             */
            @Override
            public boolean onStopRecognition(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onStopRecognition, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * When current editing element bounds are changed in view, notify the service.
             *
             * @param bundle is KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
             *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
             * @returns true if onBoundedEditTextChanged successful
             */
            @Override
            public boolean onBoundedEditTextChanged(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onBoundedEditTextChanged, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * When window lost focus, notify the service
             *
             * @param packageName which is currently bound to service.
             */
            @Override
            public void onWindowFocusLost(java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onWindowFocusLost, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Dispatch Motion Event to service for drawing
             *
             * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_ROOT_VIEW_RECT
             */
            @Override
            public void onDispatchEvent(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onDispatchEvent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Notify to Direct Writing service when current Editing element's paste popup is shown to hide
             * the direct writing service floating toolbar. This API can be used for any use case where we
             * wish to hide this toolbar ex: changed focus to another tab, tap with finger instead of stylus,
             * and so on.
             *
             * @param bundle is KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
             */
            @Override
            public void onEditTextActionModeStarted(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onEditTextActionModeStarted, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Gets configuration from Remote service after service is connected.
             *
             * @param bundle is for configuration
             *               KEY_BUNDLE_CONFIG_HIDE_DELAY,
             *               KEY_BUNDLE_CONFIG_KEEP_WRITING_DELAY,
             *               KEY_BUNDLE_CONFIG_MAX_DISTANCE,
             *               KEY_BUNDLE_CONFIG_TRIGGER_VERTICAL_SPACE
             *               KEY_BUNDLE_CONFIG_TRIGGER_HORIZONTAL_SPACE_DEFAULT
             */
            @Override
            public void getConfiguration(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getConfiguration, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        bundle.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Notify to Direct Writing service when Edit field updates ImeOptions
             *
             * @param imeOptions is ImeOptions
             */
            @Override
            public void onUpdateImeOptions(int imeOptions) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(imeOptions);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onUpdateImeOptions, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // { Common Extra

            /**
             * Extra Command for future use.
             * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
             *
             * @param action is for future use
             * @param bundle is for future use
             */
            @Override
            public void onExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(action);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onExtraCommand, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        bundle.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // Common Extra }
            // { TextView

            /**
             * TextView Extra Command for future use.
             * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
             *
             * @param action is for future use
             * @param bundle is for future use
             */
            @Override
            public void onTextViewExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(action);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onTextViewExtraCommand, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        bundle.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_getPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_onStartRecognition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_onStopRecognition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_onBoundedEditTextChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
        static final int TRANSACTION_onWindowFocusLost = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
        static final int TRANSACTION_onDispatchEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
        static final int TRANSACTION_onEditTextActionModeStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
        static final int TRANSACTION_getConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
        static final int TRANSACTION_onUpdateImeOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
        static final int TRANSACTION_onExtraCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 900);
        static final int TRANSACTION_onTextViewExtraCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 901);
    }

    java.lang.String DESCRIPTOR = "android.widget.directwriting.IDirectWritingService";
    int VERSION = 1;
    /**
     * Key for bundle parameter MotionEvent
     */
    String KEY_BUNDLE_EVENT = "event";
    /**
     * Key for bundle parameter Rect bounds of Edit field.
     */
    String KEY_BUNDLE_EDIT_RECT = "editRect";
    /**
     * Key for bundle parameter Flag if only edit field bounds have changed.
     */
    String KEY_BUNDLE_EDIT_RECT_RELOCATED = "onlyRectChanged";
    /**
     * Key for bundle parameter Flag if check only EditText bindable
     */
    String KEY_BUNDLE_CHECK_CAN_BIND = "onlyCheckCanBind";
    /**
     * Key for bundle parameter Rect of RootView
     */
    String KEY_BUNDLE_ROOT_VIEW_RECT = "rootViewRect";
    /**
     * Key for bundle parameter Service host source
     */
    String KEY_BUNDLE_SERVICE_HOST_SOURCE = "hostSource";
    /**
     * Value for bundle parameter Service host source : samsunginternet, webview, viewroot
     */
    String VALUE_BUNDLE_SERVICE_HOST_SOURCE_SAMSUNG_INTERNET = "samsunginternet";
    String VALUE_BUNDLE_SERVICE_HOST_SOURCE_WEBVIEW = "webview";
    String VALUE_BUNDLE_SERVICE_HOST_SOURCE_VIEWROOT = "viewroot";
    /**
     * Value for registerCallback packageName suffix to distinguish Samsung Internet or web view
     */
    String VALUE_SERVICE_HOST_SOURCE_INTERNET = "|samsunginternet";
    String VALUE_SERVICE_HOST_SOURCE_WEBVIEW = "|webview";
    /**
     * Key hide delay for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_HIDE_DELAY = "hideDelay";
    /**
     * Key keep writing delay for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_KEEP_WRITING_DELAY = "keepWritingDelay";
    /**
     * Key max distance for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_MAX_DISTANCE = "maxDistance";
    /**
     * Key trigger vertical space for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_TRIGGER_VERTICAL_SPACE = "triggerVerticalSpace";
    /**
     * Key trigger horizontal space for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_TRIGGER_HORIZONTAL_SPACE_DEFAULT = "triggerHorizontalSpace";
    /**
     * Key trigger to show keyboard with app privae command exceptionally when pen used
     * for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_FORCE_SHOW_SIP_APP_PRIVATE_COMMAND_LIST = "forceShowSipAppPrivateCommandList";
    /**
     * Key rejection distance to show transient bar during writing
     * for bundle parameter of getConfiguration()
     */
    String KEY_BUNDLE_CONFIG_TRANSIENT_BAR_REJECT_DISTANCE = "transientBarRejectDistance";

    /**
     * Gets version of Aidl
     *
     * @returns version IDirectWritingService.VERSION
     */
    int getVersion() throws android.os.RemoteException;

    /**
     * Registers callback for service
     *
     * @param callback    is IDirectWritingServiceCallback
     * @param packageName is Package name of bounded context
     * @returns true if success
     */
    boolean registerCallback(android.widget.directwriting.IDirectWritingServiceCallback callback, java.lang.String packageName) throws android.os.RemoteException;

    /**
     * Unregisters callback for service
     *
     * @param callback is IDirectWritingServiceCallback
     * @returns true if success
     */
    boolean unregisterCallback(android.widget.directwriting.IDirectWritingServiceCallback callback) throws android.os.RemoteException;

    /**
     * Gets package name of bounded process
     *
     * @returns package name of bounded process
     */
    java.lang.String getPackageName() throws android.os.RemoteException;

    /**
     * When Stylus pen's Motion event is detected by direct writing trigger,
     * Calls service to start direct writing recognition
     *
     * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
     *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
     * @returns true if recognition is started
     */
    boolean onStartRecognition(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * When Stylus pen's Motion event is not intended to drawing
     * (e.g. when it's small amount of move)
     * Calls service to stop direct writing recognition
     *
     * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
     *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
     * @returns true if recognition is stopped
     */
    boolean onStopRecognition(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * When current editing element bounds are changed in view, notify the service.
     *
     * @param bundle is KEY_BUNDLE_EDIT_RECT, KEY_BUNDLE_ROOT_VIEW_RECT
     *               KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
     * @returns true if onBoundedEditTextChanged successful
     */
    boolean onBoundedEditTextChanged(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * When window lost focus, notify the service
     *
     * @param packageName which is currently bound to service.
     */
    void onWindowFocusLost(java.lang.String packageName) throws android.os.RemoteException;

    /**
     * Dispatch Motion Event to service for drawing
     *
     * @param bundle is KEY_BUNDLE_EVENT, KEY_BUNDLE_ROOT_VIEW_RECT
     */
    void onDispatchEvent(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * Notify to Direct Writing service when current Editing element's paste popup is shown to hide
     * the direct writing service floating toolbar. This API can be used for any use case where we
     * wish to hide this toolbar ex: changed focus to another tab, tap with finger instead of stylus,
     * and so on.
     *
     * @param bundle is KEY_BUNDLE_SERVICE_HOST_SOURCE for browser
     */
    void onEditTextActionModeStarted(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * Gets configuration from Remote service after service is connected.
     *
     * @param bundle is for configuration
     *               KEY_BUNDLE_CONFIG_HIDE_DELAY,
     *               KEY_BUNDLE_CONFIG_KEEP_WRITING_DELAY,
     *               KEY_BUNDLE_CONFIG_MAX_DISTANCE,
     *               KEY_BUNDLE_CONFIG_TRIGGER_VERTICAL_SPACE
     *               KEY_BUNDLE_CONFIG_TRIGGER_HORIZONTAL_SPACE_DEFAULT
     */
    void getConfiguration(android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * Notify to Direct Writing service when Edit field updates ImeOptions
     *
     * @param imeOptions is ImeOptions
     */
    void onUpdateImeOptions(int imeOptions) throws android.os.RemoteException;
    // { Common Extra

    /**
     * Extra Command for future use.
     * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
     *
     * @param action is for future use
     * @param bundle is for future use
     */
    void onExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException;
    // Common Extra }
    // { TextView

    /**
     * TextView Extra Command for future use.
     * Note: This API is unused by Chromium for now. It is defined as per aidl from Samsung platform.
     *
     * @param action is for future use
     * @param bundle is for future use
     */
    void onTextViewExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * @hide
     */
    class _Parcel {
        static private <T> T readTypedObject(android.os.Parcel parcel, android.os.Parcelable.Creator<T> c) {
            if (parcel.readInt() != 0) {
                return c.createFromParcel(parcel);
            } else {
                return null;
            }
        }

        static private <T extends android.os.Parcelable> void writeTypedObject(android.os.Parcel parcel, T value, int parcelableFlags) {
            if (value != null) {
                parcel.writeInt(1);
                value.writeToParcel(parcel, parcelableFlags);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
