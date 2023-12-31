// ExecutionContextToken.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/tokens/tokens.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class ExecutionContextToken extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int LocalFrameToken = 0;
        public static final int DedicatedWorkerToken = 1;
        public static final int ServiceWorkerToken = 2;
        public static final int SharedWorkerToken = 3;
        public static final int AnimationWorkletToken = 4;
        public static final int AudioWorkletToken = 5;
        public static final int LayoutWorkletToken = 6;
        public static final int PaintWorkletToken = 7;
        public static final int SharedStorageWorkletToken = 8;
        public static final int ShadowRealmToken = 9;
    };
    private LocalFrameToken mLocalFrameToken;
    private DedicatedWorkerToken mDedicatedWorkerToken;
    private ServiceWorkerToken mServiceWorkerToken;
    private SharedWorkerToken mSharedWorkerToken;
    private AnimationWorkletToken mAnimationWorkletToken;
    private AudioWorkletToken mAudioWorkletToken;
    private LayoutWorkletToken mLayoutWorkletToken;
    private PaintWorkletToken mPaintWorkletToken;
    private SharedStorageWorkletToken mSharedStorageWorkletToken;
    private ShadowRealmToken mShadowRealmToken;

    public void setLocalFrameToken(LocalFrameToken localFrameToken) {
        this.mTag = Tag.LocalFrameToken;
        this.mLocalFrameToken = localFrameToken;
    }

    public LocalFrameToken getLocalFrameToken() {
        assert this.mTag == Tag.LocalFrameToken;
        return this.mLocalFrameToken;
    }

    public void setDedicatedWorkerToken(DedicatedWorkerToken dedicatedWorkerToken) {
        this.mTag = Tag.DedicatedWorkerToken;
        this.mDedicatedWorkerToken = dedicatedWorkerToken;
    }

    public DedicatedWorkerToken getDedicatedWorkerToken() {
        assert this.mTag == Tag.DedicatedWorkerToken;
        return this.mDedicatedWorkerToken;
    }

    public void setServiceWorkerToken(ServiceWorkerToken serviceWorkerToken) {
        this.mTag = Tag.ServiceWorkerToken;
        this.mServiceWorkerToken = serviceWorkerToken;
    }

    public ServiceWorkerToken getServiceWorkerToken() {
        assert this.mTag == Tag.ServiceWorkerToken;
        return this.mServiceWorkerToken;
    }

    public void setSharedWorkerToken(SharedWorkerToken sharedWorkerToken) {
        this.mTag = Tag.SharedWorkerToken;
        this.mSharedWorkerToken = sharedWorkerToken;
    }

    public SharedWorkerToken getSharedWorkerToken() {
        assert this.mTag == Tag.SharedWorkerToken;
        return this.mSharedWorkerToken;
    }

    public void setAnimationWorkletToken(AnimationWorkletToken animationWorkletToken) {
        this.mTag = Tag.AnimationWorkletToken;
        this.mAnimationWorkletToken = animationWorkletToken;
    }

    public AnimationWorkletToken getAnimationWorkletToken() {
        assert this.mTag == Tag.AnimationWorkletToken;
        return this.mAnimationWorkletToken;
    }

    public void setAudioWorkletToken(AudioWorkletToken audioWorkletToken) {
        this.mTag = Tag.AudioWorkletToken;
        this.mAudioWorkletToken = audioWorkletToken;
    }

    public AudioWorkletToken getAudioWorkletToken() {
        assert this.mTag == Tag.AudioWorkletToken;
        return this.mAudioWorkletToken;
    }

    public void setLayoutWorkletToken(LayoutWorkletToken layoutWorkletToken) {
        this.mTag = Tag.LayoutWorkletToken;
        this.mLayoutWorkletToken = layoutWorkletToken;
    }

    public LayoutWorkletToken getLayoutWorkletToken() {
        assert this.mTag == Tag.LayoutWorkletToken;
        return this.mLayoutWorkletToken;
    }

    public void setPaintWorkletToken(PaintWorkletToken paintWorkletToken) {
        this.mTag = Tag.PaintWorkletToken;
        this.mPaintWorkletToken = paintWorkletToken;
    }

    public PaintWorkletToken getPaintWorkletToken() {
        assert this.mTag == Tag.PaintWorkletToken;
        return this.mPaintWorkletToken;
    }

    public void setSharedStorageWorkletToken(SharedStorageWorkletToken sharedStorageWorkletToken) {
        this.mTag = Tag.SharedStorageWorkletToken;
        this.mSharedStorageWorkletToken = sharedStorageWorkletToken;
    }

    public SharedStorageWorkletToken getSharedStorageWorkletToken() {
        assert this.mTag == Tag.SharedStorageWorkletToken;
        return this.mSharedStorageWorkletToken;
    }

    public void setShadowRealmToken(ShadowRealmToken shadowRealmToken) {
        this.mTag = Tag.ShadowRealmToken;
        this.mShadowRealmToken = shadowRealmToken;
    }

    public ShadowRealmToken getShadowRealmToken() {
        assert this.mTag == Tag.ShadowRealmToken;
        return this.mShadowRealmToken;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.LocalFrameToken: {
                
                encoder0.encode(this.mLocalFrameToken, offset + 8, false);
                break;
            }
            case Tag.DedicatedWorkerToken: {
                
                encoder0.encode(this.mDedicatedWorkerToken, offset + 8, false);
                break;
            }
            case Tag.ServiceWorkerToken: {
                
                encoder0.encode(this.mServiceWorkerToken, offset + 8, false);
                break;
            }
            case Tag.SharedWorkerToken: {
                
                encoder0.encode(this.mSharedWorkerToken, offset + 8, false);
                break;
            }
            case Tag.AnimationWorkletToken: {
                
                encoder0.encode(this.mAnimationWorkletToken, offset + 8, false);
                break;
            }
            case Tag.AudioWorkletToken: {
                
                encoder0.encode(this.mAudioWorkletToken, offset + 8, false);
                break;
            }
            case Tag.LayoutWorkletToken: {
                
                encoder0.encode(this.mLayoutWorkletToken, offset + 8, false);
                break;
            }
            case Tag.PaintWorkletToken: {
                
                encoder0.encode(this.mPaintWorkletToken, offset + 8, false);
                break;
            }
            case Tag.SharedStorageWorkletToken: {
                
                encoder0.encode(this.mSharedStorageWorkletToken, offset + 8, false);
                break;
            }
            case Tag.ShadowRealmToken: {
                
                encoder0.encode(this.mShadowRealmToken, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static ExecutionContextToken deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final ExecutionContextToken decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        ExecutionContextToken result = new ExecutionContextToken();
        switch (dataHeader.elementsOrVersion) {
            case Tag.LocalFrameToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mLocalFrameToken = LocalFrameToken.decode(decoder1);
                result.mTag = Tag.LocalFrameToken;
                break;
            }
            case Tag.DedicatedWorkerToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mDedicatedWorkerToken = DedicatedWorkerToken.decode(decoder1);
                result.mTag = Tag.DedicatedWorkerToken;
                break;
            }
            case Tag.ServiceWorkerToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mServiceWorkerToken = ServiceWorkerToken.decode(decoder1);
                result.mTag = Tag.ServiceWorkerToken;
                break;
            }
            case Tag.SharedWorkerToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mSharedWorkerToken = SharedWorkerToken.decode(decoder1);
                result.mTag = Tag.SharedWorkerToken;
                break;
            }
            case Tag.AnimationWorkletToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mAnimationWorkletToken = AnimationWorkletToken.decode(decoder1);
                result.mTag = Tag.AnimationWorkletToken;
                break;
            }
            case Tag.AudioWorkletToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mAudioWorkletToken = AudioWorkletToken.decode(decoder1);
                result.mTag = Tag.AudioWorkletToken;
                break;
            }
            case Tag.LayoutWorkletToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mLayoutWorkletToken = LayoutWorkletToken.decode(decoder1);
                result.mTag = Tag.LayoutWorkletToken;
                break;
            }
            case Tag.PaintWorkletToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mPaintWorkletToken = PaintWorkletToken.decode(decoder1);
                result.mTag = Tag.PaintWorkletToken;
                break;
            }
            case Tag.SharedStorageWorkletToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mSharedStorageWorkletToken = SharedStorageWorkletToken.decode(decoder1);
                result.mTag = Tag.SharedStorageWorkletToken;
                break;
            }
            case Tag.ShadowRealmToken: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mShadowRealmToken = ShadowRealmToken.decode(decoder1);
                result.mTag = Tag.ShadowRealmToken;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}