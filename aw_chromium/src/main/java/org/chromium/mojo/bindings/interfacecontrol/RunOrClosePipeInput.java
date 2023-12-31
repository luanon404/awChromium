// RunOrClosePipeInput.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     mojo/public/interfaces/bindings/interface_control_messages.mojom
//

package org.chromium.mojo.bindings.interfacecontrol;

import androidx.annotation.IntDef;


public final class RunOrClosePipeInput extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int RequireVersion = 0;
        public static final int EnableIdleTracking = 1;
        public static final int MessageAck = 2;
        public static final int NotifyIdle = 3;
    };
    private RequireVersion mRequireVersion;
    private EnableIdleTracking mEnableIdleTracking;
    private MessageAck mMessageAck;
    private NotifyIdle mNotifyIdle;

    public void setRequireVersion(RequireVersion requireVersion) {
        this.mTag = Tag.RequireVersion;
        this.mRequireVersion = requireVersion;
    }

    public RequireVersion getRequireVersion() {
        assert this.mTag == Tag.RequireVersion;
        return this.mRequireVersion;
    }

    public void setEnableIdleTracking(EnableIdleTracking enableIdleTracking) {
        this.mTag = Tag.EnableIdleTracking;
        this.mEnableIdleTracking = enableIdleTracking;
    }

    public EnableIdleTracking getEnableIdleTracking() {
        assert this.mTag == Tag.EnableIdleTracking;
        return this.mEnableIdleTracking;
    }

    public void setMessageAck(MessageAck messageAck) {
        this.mTag = Tag.MessageAck;
        this.mMessageAck = messageAck;
    }

    public MessageAck getMessageAck() {
        assert this.mTag == Tag.MessageAck;
        return this.mMessageAck;
    }

    public void setNotifyIdle(NotifyIdle notifyIdle) {
        this.mTag = Tag.NotifyIdle;
        this.mNotifyIdle = notifyIdle;
    }

    public NotifyIdle getNotifyIdle() {
        assert this.mTag == Tag.NotifyIdle;
        return this.mNotifyIdle;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.RequireVersion: {
                
                encoder0.encode(this.mRequireVersion, offset + 8, false);
                break;
            }
            case Tag.EnableIdleTracking: {
                
                encoder0.encode(this.mEnableIdleTracking, offset + 8, false);
                break;
            }
            case Tag.MessageAck: {
                
                encoder0.encode(this.mMessageAck, offset + 8, false);
                break;
            }
            case Tag.NotifyIdle: {
                
                encoder0.encode(this.mNotifyIdle, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static RunOrClosePipeInput deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final RunOrClosePipeInput decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        RunOrClosePipeInput result = new RunOrClosePipeInput();
        switch (dataHeader.elementsOrVersion) {
            case Tag.RequireVersion: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mRequireVersion = RequireVersion.decode(decoder1);
                result.mTag = Tag.RequireVersion;
                break;
            }
            case Tag.EnableIdleTracking: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mEnableIdleTracking = EnableIdleTracking.decode(decoder1);
                result.mTag = Tag.EnableIdleTracking;
                break;
            }
            case Tag.MessageAck: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mMessageAck = MessageAck.decode(decoder1);
                result.mTag = Tag.MessageAck;
                break;
            }
            case Tag.NotifyIdle: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mNotifyIdle = NotifyIdle.decode(decoder1);
                result.mTag = Tag.NotifyIdle;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}