/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.widget.directwriting;

/**
 * Direct writing service callback API for providing functionality of service callback operations,
 * mainly committing recognized and handling detected gestures. These APIs are to be implemented by
 * application making use of the direct writing service to:
 * 1. provide requested information regarding the current input field location and input state for
 * which the writing is initiated.
 * 2. commit recognized text and set the cursor after commit.
 * 3. handle recognized gestures like deleting or adding text, spaces by using the gesture data
 * Bundle provided by the service.
 */
public interface IDirectWritingServiceCallback extends android.os.IInterface {
    /**
     * Default implementation for IDirectWritingServiceCallback.
     */
    class Default implements android.widget.directwriting.IDirectWritingServiceCallback {
        /**
         * Gets version of Aidl
         *
         * @returns version IDirectWritingServiceCallback.VERSION
         */
        @Override
        public int getVersion() throws android.os.RemoteException {
            return 0;
        }
        // { Life Cycle

        /**
         * Calls When finish writing from service
         */
        @Override
        public void onFinishRecognition() throws android.os.RemoteException {
        }
        // Life Cycle}
        // { Bound EditText

        /**
         * Calls When Touch Up event happens outside of bounded edit text
         * Try to find and bind proper edit text near event position
         * Should run on main looper
         */
        @Override
        public void bindEditIn(float x, float y) throws android.os.RemoteException {
        }

        /**
         * Called when the Service needs updated Edit field position. Used when the soft keyboard is
         * being shown or hidden to position the Direct writing widget toolbar near edit bounds.
         * This should respond by calling IDirectWritingService.onBoundedEditTextChanged with updated
         * bounds of focused edit field.
         * Should run on main looper.
         */
        @Override
        public void updateBoundedEditTextRect() throws android.os.RemoteException {
        }
        // Bound EditText }
        // { EditText Text and Selection Setter

        /**
         * Sets text and cursor in bounded edit text
         * Should run on main looper
         *
         * @param text  to set in edit text
         * @param index to set cursor position in edit text
         */
        @Override
        public void setTextSelection(java.lang.CharSequence text, int index) throws android.os.RemoteException {
        }

        /**
         * Same method with EditText
         * Should run on main looper
         */
        @Override
        public void setText(java.lang.CharSequence text) throws android.os.RemoteException {
        }

        /**
         * Same method with EditText
         * Should run on main looper
         */
        @Override
        public void setSelection(int selection) throws android.os.RemoteException {
        }
        // EditText Text and Selection Setter }
        // { EditText Text and Selection Getter

        /**
         * Same method with EditText
         */
        @Override
        public int getSelectionStart() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getSelectionEnd() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getOffsetForPosition(float x, float y) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public java.lang.CharSequence getText() throws android.os.RemoteException {
            return null;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int length() throws android.os.RemoteException {
            return 0;
        }
        // EditText Text and Selection Getter }
        // EditText Rect and Size, Position Getter }

        /**
         * Same method with EditText
         */
        @Override
        public int getHeight() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getWidth() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getScrollY() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getPaddingStart() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getPaddingTop() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getPaddingBottom() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getPaddingEnd() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getRight() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getLeft() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getTop() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getBottom() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getLineHeight() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getLineCount() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getBaseLine() throws android.os.RemoteException {
            return 0;
        }
        // EditText Rect and Size, Position Getter }
        // { EditText layout Getter

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getParagraphDirection(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public float getPrimaryHorizontal(int offset) throws android.os.RemoteException {
            return 0.0f;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public float getLineMax(int i) throws android.os.RemoteException {
            return 0.0f;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineForOffset(int offset) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineStart(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineEnd(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineTop(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineBottom(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineVisibleEnd(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineBaseline(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Get line height by line index
         */
        @Override
        public int getLineHeightByIndex(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Get line max inclues start padding of editText
         */
        @Override
        public int getLineMaxIncludePadding(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineAscent(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText.getLayout()
         */
        @Override
        public int getLineDescent(int line) throws android.os.RemoteException {
            return 0;
        }

        /**
         * Get text area by line index
         */
        @Override
        public android.graphics.Rect getTextAreaRect(int line) throws android.os.RemoteException {
            return null;
        }
        // EditText layout Getter }
        // { VI

        /**
         * Gets location of cursor for VI
         */
        @Override
        public android.graphics.PointF getCursorLocation(int selectionStart) throws android.os.RemoteException {
            return null;
        }
        // VI }
        // { EditText EditInfo Getter

        /**
         * Same method with EditText
         */
        @Override
        public java.lang.String getPrivateImeOptions() throws android.os.RemoteException {
            return null;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getImeOptions() throws android.os.RemoteException {
            return 0;
        }

        /**
         * Same method with EditText
         */
        @Override
        public int getInputType() throws android.os.RemoteException {
            return 0;
        }
        // EditText EditInfo Getter }
        // { InputMethod

        /**
         * Same method with EditText
         * Should run on main looper
         */
        @Override
        public void onEditorAction(int actionCode) throws android.os.RemoteException {
        }

        /**
         * Executes INPUT_METHOD_SERVICE sendAppPrivateCommand to send command to Keyboard
         *
         * @param action to send to keyboard
         * @param bundle to send to keyboard
         */
        @Override
        public void onAppPrivateCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
        }

        /**
         * Hides keyboard forcely if it is showing for current input.
         */
        @Override
        public void semForceHideSoftInput() throws android.os.RemoteException {
        }
        // InputMethod }
        // { Common Extra

        /**
         * Extra Command for future use
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
         * Note: This Callback API receives the stylus writing Gesture recognized by service along with
         * gesture data bundle containing gesture coordinates, text to insert and alternate text to be
         * inserted in case gesture is not done over a valid text position in input.
         *
         * @param action is for future use
         * @param bundle is for future use
         */
        @Override
        public void onTextViewExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
        }
        // TextView }

        /**
         * Direct writing service may be stopped to save memory when unused for a while. This method is
         * called to check if still hovering over writable fields to avoid stopping the service.
         *
         * @return true if the stylus handwriting hover icon is currently being shown, false otherwise.
         */
        @Override
        public boolean isHoverIconShowing() throws android.os.RemoteException {
            return false;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements android.widget.directwriting.IDirectWritingServiceCallback {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.widget.directwriting.IDirectWritingServiceCallback interface,
         * generating a proxy if needed.
         */
        public static android.widget.directwriting.IDirectWritingServiceCallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof android.widget.directwriting.IDirectWritingServiceCallback))) {
                return ((android.widget.directwriting.IDirectWritingServiceCallback) iin);
            }
            return new android.widget.directwriting.IDirectWritingServiceCallback.Stub.Proxy(obj);
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
                case TRANSACTION_onFinishRecognition: {
                    this.onFinishRecognition();
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_bindEditIn: {
                    float _arg0;
                    _arg0 = data.readFloat();
                    float _arg1;
                    _arg1 = data.readFloat();
                    this.bindEditIn(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_updateBoundedEditTextRect: {
                    this.updateBoundedEditTextRect();
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_setTextSelection: {
                    java.lang.CharSequence _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.text.TextUtils.CHAR_SEQUENCE_CREATOR);
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setTextSelection(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_setText: {
                    java.lang.CharSequence _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.text.TextUtils.CHAR_SEQUENCE_CREATOR);
                    this.setText(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_setSelection: {
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setSelection(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_getSelectionStart: {
                    int _result = this.getSelectionStart();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getSelectionEnd: {
                    int _result = this.getSelectionEnd();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getOffsetForPosition: {
                    float _arg0;
                    _arg0 = data.readFloat();
                    float _arg1;
                    _arg1 = data.readFloat();
                    int _result = this.getOffsetForPosition(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getText: {
                    java.lang.CharSequence _result = this.getText();
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        android.text.TextUtils.writeToParcel(_result, reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    break;
                }
                case TRANSACTION_length: {
                    int _result = this.length();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getHeight: {
                    int _result = this.getHeight();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getWidth: {
                    int _result = this.getWidth();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getScrollY: {
                    int _result = this.getScrollY();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getPaddingStart: {
                    int _result = this.getPaddingStart();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getPaddingTop: {
                    int _result = this.getPaddingTop();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getPaddingBottom: {
                    int _result = this.getPaddingBottom();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getPaddingEnd: {
                    int _result = this.getPaddingEnd();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getRight: {
                    int _result = this.getRight();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLeft: {
                    int _result = this.getLeft();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getTop: {
                    int _result = this.getTop();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getBottom: {
                    int _result = this.getBottom();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineHeight: {
                    int _result = this.getLineHeight();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineCount: {
                    int _result = this.getLineCount();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getBaseLine: {
                    int _result = this.getBaseLine();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getParagraphDirection: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getParagraphDirection(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getPrimaryHorizontal: {
                    int _arg0;
                    _arg0 = data.readInt();
                    float _result = this.getPrimaryHorizontal(_arg0);
                    reply.writeNoException();
                    reply.writeFloat(_result);
                    break;
                }
                case TRANSACTION_getLineMax: {
                    int _arg0;
                    _arg0 = data.readInt();
                    float _result = this.getLineMax(_arg0);
                    reply.writeNoException();
                    reply.writeFloat(_result);
                    break;
                }
                case TRANSACTION_getLineForOffset: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineForOffset(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineStart: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineStart(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineEnd: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineEnd(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineTop: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineTop(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineBottom: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineBottom(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineVisibleEnd: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineVisibleEnd(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineBaseline: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineBaseline(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineHeightByIndex: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineHeightByIndex(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineMaxIncludePadding: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineMaxIncludePadding(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineAscent: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineAscent(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getLineDescent: {
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.getLineDescent(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getTextAreaRect: {
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.Rect _result = this.getTextAreaRect(_arg0);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    break;
                }
                case TRANSACTION_getCursorLocation: {
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.PointF _result = this.getCursorLocation(_arg0);
                    reply.writeNoException();
                    _Parcel.writeTypedObject(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    break;
                }
                case TRANSACTION_getPrivateImeOptions: {
                    java.lang.String _result = this.getPrivateImeOptions();
                    reply.writeNoException();
                    reply.writeString(_result);
                    break;
                }
                case TRANSACTION_getImeOptions: {
                    int _result = this.getImeOptions();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getInputType: {
                    int _result = this.getInputType();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_onEditorAction: {
                    int _arg0;
                    _arg0 = data.readInt();
                    this.onEditorAction(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_onAppPrivateCommand: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.Bundle _arg1;
                    _arg1 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.onAppPrivateCommand(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_semForceHideSoftInput: {
                    this.semForceHideSoftInput();
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
                case TRANSACTION_isHoverIconShowing: {
                    boolean _result = this.isHoverIconShowing();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements android.widget.directwriting.IDirectWritingServiceCallback {
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
             * @returns version IDirectWritingServiceCallback.VERSION
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
            // { Life Cycle

            /**
             * Calls When finish writing from service
             */
            @Override
            public void onFinishRecognition() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onFinishRecognition, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // Life Cycle}
            // { Bound EditText

            /**
             * Calls When Touch Up event happens outside of bounded edit text
             * Try to find and bind proper edit text near event position
             * Should run on main looper
             */
            @Override
            public void bindEditIn(float x, float y) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeFloat(x);
                    _data.writeFloat(y);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_bindEditIn, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Called when the Service needs updated Edit field position. Used when the soft keyboard is
             * being shown or hidden to position the Direct writing widget toolbar near edit bounds.
             * This should respond by calling IDirectWritingService.onBoundedEditTextChanged with updated
             * bounds of focused edit field.
             * Should run on main looper.
             */
            @Override
            public void updateBoundedEditTextRect() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_updateBoundedEditTextRect, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // Bound EditText }
            // { EditText Text and Selection Setter

            /**
             * Sets text and cursor in bounded edit text
             * Should run on main looper
             *
             * @param text  to set in edit text
             * @param index to set cursor position in edit text
             */
            @Override
            public void setTextSelection(java.lang.CharSequence text, int index) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if (text != null) {
                        _data.writeInt(1);
                        android.text.TextUtils.writeToParcel(text, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(index);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setTextSelection, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Same method with EditText
             * Should run on main looper
             */
            @Override
            public void setText(java.lang.CharSequence text) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if (text != null) {
                        _data.writeInt(1);
                        android.text.TextUtils.writeToParcel(text, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setText, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Same method with EditText
             * Should run on main looper
             */
            @Override
            public void setSelection(int selection) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(selection);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setSelection, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // EditText Text and Selection Setter }
            // { EditText Text and Selection Getter

            /**
             * Same method with EditText
             */
            @Override
            public int getSelectionStart() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getSelectionStart, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getSelectionEnd() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getSelectionEnd, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getOffsetForPosition(float x, float y) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeFloat(x);
                    _data.writeFloat(y);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getOffsetForPosition, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public java.lang.CharSequence getText() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.CharSequence _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getText, _data, _reply, 0);
                    _reply.readException();
                    _result = _Parcel.readTypedObject(_reply, android.text.TextUtils.CHAR_SEQUENCE_CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int length() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_length, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            // EditText Text and Selection Getter }
            // EditText Rect and Size, Position Getter }

            /**
             * Same method with EditText
             */
            @Override
            public int getHeight() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getHeight, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getWidth() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getWidth, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getScrollY() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getScrollY, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getPaddingStart() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPaddingStart, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getPaddingTop() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPaddingTop, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getPaddingBottom() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPaddingBottom, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getPaddingEnd() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPaddingEnd, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getRight() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getRight, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getLeft() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLeft, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getTop() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getTop, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getBottom() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getBottom, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getLineHeight() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineHeight, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getLineCount() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineCount, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getBaseLine() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getBaseLine, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            // EditText Rect and Size, Position Getter }
            // { EditText layout Getter

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getParagraphDirection(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getParagraphDirection, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public float getPrimaryHorizontal(int offset) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                float _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(offset);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPrimaryHorizontal, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readFloat();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public float getLineMax(int i) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                float _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(i);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineMax, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readFloat();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineForOffset(int offset) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(offset);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineForOffset, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineStart(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineStart, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineEnd(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineEnd, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineTop(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineTop, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineBottom(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineBottom, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineVisibleEnd(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineVisibleEnd, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineBaseline(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineBaseline, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Get line height by line index
             */
            @Override
            public int getLineHeightByIndex(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineHeightByIndex, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Get line max inclues start padding of editText
             */
            @Override
            public int getLineMaxIncludePadding(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineMaxIncludePadding, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineAscent(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineAscent, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText.getLayout()
             */
            @Override
            public int getLineDescent(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getLineDescent, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Get text area by line index
             */
            @Override
            public android.graphics.Rect getTextAreaRect(int line) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.graphics.Rect _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(line);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getTextAreaRect, _data, _reply, 0);
                    _reply.readException();
                    _result = _Parcel.readTypedObject(_reply, android.graphics.Rect.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            // EditText layout Getter }
            // { VI

            /**
             * Gets location of cursor for VI
             */
            @Override
            public android.graphics.PointF getCursorLocation(int selectionStart) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.graphics.PointF _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(selectionStart);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getCursorLocation, _data, _reply, 0);
                    _reply.readException();
                    _result = _Parcel.readTypedObject(_reply, android.graphics.PointF.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            // VI }
            // { EditText EditInfo Getter

            /**
             * Same method with EditText
             */
            @Override
            public java.lang.String getPrivateImeOptions() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPrivateImeOptions, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getImeOptions() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getImeOptions, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Same method with EditText
             */
            @Override
            public int getInputType() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getInputType, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            // EditText EditInfo Getter }
            // { InputMethod

            /**
             * Same method with EditText
             * Should run on main looper
             */
            @Override
            public void onEditorAction(int actionCode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(actionCode);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onEditorAction, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Executes INPUT_METHOD_SERVICE sendAppPrivateCommand to send command to Keyboard
             *
             * @param action to send to keyboard
             * @param bundle to send to keyboard
             */
            @Override
            public void onAppPrivateCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(action);
                    _Parcel.writeTypedObject(_data, bundle, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onAppPrivateCommand, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Hides keyboard forcely if it is showing for current input.
             */
            @Override
            public void semForceHideSoftInput() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_semForceHideSoftInput, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            // InputMethod }
            // { Common Extra

            /**
             * Extra Command for future use
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
             * Note: This Callback API receives the stylus writing Gesture recognized by service along with
             * gesture data bundle containing gesture coordinates, text to insert and alternate text to be
             * inserted in case gesture is not done over a valid text position in input.
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
            // TextView }

            /**
             * Direct writing service may be stopped to save memory when unused for a while. This method is
             * called to check if still hovering over writable fields to avoid stopping the service.
             *
             * @return true if the stylus handwriting hover icon is currently being shown, false otherwise.
             */
            @Override
            public boolean isHoverIconShowing() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_isHoverIconShowing, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_getVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_onFinishRecognition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_bindEditIn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_updateBoundedEditTextRect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_setTextSelection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
        static final int TRANSACTION_setText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
        static final int TRANSACTION_setSelection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
        static final int TRANSACTION_getSelectionStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
        static final int TRANSACTION_getSelectionEnd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
        static final int TRANSACTION_getOffsetForPosition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
        static final int TRANSACTION_getText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
        static final int TRANSACTION_length = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
        static final int TRANSACTION_getHeight = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
        static final int TRANSACTION_getWidth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
        static final int TRANSACTION_getScrollY = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
        static final int TRANSACTION_getPaddingStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
        static final int TRANSACTION_getPaddingTop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
        static final int TRANSACTION_getPaddingBottom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
        static final int TRANSACTION_getPaddingEnd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
        static final int TRANSACTION_getRight = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
        static final int TRANSACTION_getLeft = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
        static final int TRANSACTION_getTop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
        static final int TRANSACTION_getBottom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
        static final int TRANSACTION_getLineHeight = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
        static final int TRANSACTION_getLineCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
        static final int TRANSACTION_getBaseLine = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
        static final int TRANSACTION_getParagraphDirection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
        static final int TRANSACTION_getPrimaryHorizontal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
        static final int TRANSACTION_getLineMax = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
        static final int TRANSACTION_getLineForOffset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
        static final int TRANSACTION_getLineStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
        static final int TRANSACTION_getLineEnd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
        static final int TRANSACTION_getLineTop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
        static final int TRANSACTION_getLineBottom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
        static final int TRANSACTION_getLineVisibleEnd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
        static final int TRANSACTION_getLineBaseline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
        static final int TRANSACTION_getLineHeightByIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
        static final int TRANSACTION_getLineMaxIncludePadding = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
        static final int TRANSACTION_getLineAscent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
        static final int TRANSACTION_getLineDescent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
        static final int TRANSACTION_getTextAreaRect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
        static final int TRANSACTION_getCursorLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
        static final int TRANSACTION_getPrivateImeOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
        static final int TRANSACTION_getImeOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
        static final int TRANSACTION_getInputType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
        static final int TRANSACTION_onEditorAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
        static final int TRANSACTION_onAppPrivateCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
        static final int TRANSACTION_semForceHideSoftInput = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
        static final int TRANSACTION_onExtraCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 900);
        static final int TRANSACTION_onTextViewExtraCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 901);
        static final int TRANSACTION_isHoverIconShowing = (android.os.IBinder.FIRST_CALL_TRANSACTION + 902);
    }

    java.lang.String DESCRIPTOR = "android.widget.directwriting.IDirectWritingServiceCallback";
    int VERSION = 3;

    /**
     * Gets version of Aidl
     *
     * @returns version IDirectWritingServiceCallback.VERSION
     */
    int getVersion() throws android.os.RemoteException;
    // { Life Cycle

    /**
     * Calls When finish writing from service
     */
    void onFinishRecognition() throws android.os.RemoteException;
    // Life Cycle}
    // { Bound EditText

    /**
     * Calls When Touch Up event happens outside of bounded edit text
     * Try to find and bind proper edit text near event position
     * Should run on main looper
     */
    void bindEditIn(float x, float y) throws android.os.RemoteException;

    /**
     * Called when the Service needs updated Edit field position. Used when the soft keyboard is
     * being shown or hidden to position the Direct writing widget toolbar near edit bounds.
     * This should respond by calling IDirectWritingService.onBoundedEditTextChanged with updated
     * bounds of focused edit field.
     * Should run on main looper.
     */
    void updateBoundedEditTextRect() throws android.os.RemoteException;
    // Bound EditText }
    // { EditText Text and Selection Setter

    /**
     * Sets text and cursor in bounded edit text
     * Should run on main looper
     *
     * @param text  to set in edit text
     * @param index to set cursor position in edit text
     */
    void setTextSelection(java.lang.CharSequence text, int index) throws android.os.RemoteException;

    /**
     * Same method with EditText
     * Should run on main looper
     */
    void setText(java.lang.CharSequence text) throws android.os.RemoteException;

    /**
     * Same method with EditText
     * Should run on main looper
     */
    void setSelection(int selection) throws android.os.RemoteException;
    // EditText Text and Selection Setter }
    // { EditText Text and Selection Getter

    /**
     * Same method with EditText
     */
    int getSelectionStart() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getSelectionEnd() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getOffsetForPosition(float x, float y) throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    java.lang.CharSequence getText() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int length() throws android.os.RemoteException;
    // EditText Text and Selection Getter }
    // EditText Rect and Size, Position Getter }

    /**
     * Same method with EditText
     */
    int getHeight() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getWidth() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getScrollY() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getPaddingStart() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getPaddingTop() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getPaddingBottom() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getPaddingEnd() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getRight() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getLeft() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getTop() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getBottom() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getLineHeight() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getLineCount() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getBaseLine() throws android.os.RemoteException;
    // EditText Rect and Size, Position Getter }
    // { EditText layout Getter

    /**
     * Same method with EditText.getLayout()
     */
    int getParagraphDirection(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    float getPrimaryHorizontal(int offset) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    float getLineMax(int i) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineForOffset(int offset) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineStart(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineEnd(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineTop(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineBottom(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineVisibleEnd(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineBaseline(int line) throws android.os.RemoteException;

    /**
     * Get line height by line index
     */
    int getLineHeightByIndex(int line) throws android.os.RemoteException;

    /**
     * Get line max inclues start padding of editText
     */
    int getLineMaxIncludePadding(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineAscent(int line) throws android.os.RemoteException;

    /**
     * Same method with EditText.getLayout()
     */
    int getLineDescent(int line) throws android.os.RemoteException;

    /**
     * Get text area by line index
     */
    android.graphics.Rect getTextAreaRect(int line) throws android.os.RemoteException;
    // EditText layout Getter }
    // { VI

    /**
     * Gets location of cursor for VI
     */
    android.graphics.PointF getCursorLocation(int selectionStart) throws android.os.RemoteException;
    // VI }
    // { EditText EditInfo Getter

    /**
     * Same method with EditText
     */
    java.lang.String getPrivateImeOptions() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getImeOptions() throws android.os.RemoteException;

    /**
     * Same method with EditText
     */
    int getInputType() throws android.os.RemoteException;
    // EditText EditInfo Getter }
    // { InputMethod

    /**
     * Same method with EditText
     * Should run on main looper
     */
    void onEditorAction(int actionCode) throws android.os.RemoteException;

    /**
     * Executes INPUT_METHOD_SERVICE sendAppPrivateCommand to send command to Keyboard
     *
     * @param action to send to keyboard
     * @param bundle to send to keyboard
     */
    void onAppPrivateCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException;

    /**
     * Hides keyboard forcely if it is showing for current input.
     */
    void semForceHideSoftInput() throws android.os.RemoteException;
    // InputMethod }
    // { Common Extra

    /**
     * Extra Command for future use
     *
     * @param action is for future use
     * @param bundle is for future use
     */
    void onExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException;
    // Common Extra }
    // { TextView

    /**
     * TextView Extra Command for future use.
     * Note: This Callback API receives the stylus writing Gesture recognized by service along with
     * gesture data bundle containing gesture coordinates, text to insert and alternate text to be
     * inserted in case gesture is not done over a valid text position in input.
     *
     * @param action is for future use
     * @param bundle is for future use
     */
    void onTextViewExtraCommand(java.lang.String action, android.os.Bundle bundle) throws android.os.RemoteException;
    // TextView }

    /**
     * Direct writing service may be stopped to save memory when unused for a while. This method is
     * called to check if still hovering over writable fields to avoid stopping the service.
     *
     * @return true if the stylus handwriting hover icon is currently being shown, false otherwise.
     */
    boolean isHoverIconShowing() throws android.os.RemoteException;

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
