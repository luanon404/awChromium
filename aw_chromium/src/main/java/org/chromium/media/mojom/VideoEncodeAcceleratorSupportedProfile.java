// VideoEncodeAcceleratorSupportedProfile.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/video_encode_accelerator.mojom
//

package org.chromium.media.mojom;

public final class VideoEncodeAcceleratorSupportedProfile extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int profile;
    public org.chromium.gfx.mojom.Size minResolution;
    public org.chromium.gfx.mojom.Size maxResolution;
    public int maxFramerateNumerator;
    public int maxFramerateDenominator;
    public int[] rateControlModes;
    public int[] scalabilityModes;
    public boolean isSoftwareCodec;

    private VideoEncodeAcceleratorSupportedProfile(int version) {
        super(STRUCT_SIZE, version);
    }

    public VideoEncodeAcceleratorSupportedProfile() {
        this(0);
    }

    public static VideoEncodeAcceleratorSupportedProfile deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VideoEncodeAcceleratorSupportedProfile deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VideoEncodeAcceleratorSupportedProfile decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VideoEncodeAcceleratorSupportedProfile result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VideoEncodeAcceleratorSupportedProfile(elementsOrVersion);
            {

                result.profile = decoder0.readInt(8);
                VideoCodecProfile.validate(result.profile);
                result.profile = VideoCodecProfile.toKnownValue(result.profile);
            }
            {

                result.maxFramerateNumerator = decoder0.readInt(12);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.minResolution = org.chromium.gfx.mojom.Size.decode(decoder1);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.maxResolution = org.chromium.gfx.mojom.Size.decode(decoder1);
            }
            {

                result.maxFramerateDenominator = decoder0.readInt(32);
            }
            {

                result.isSoftwareCodec = decoder0.readBoolean(36, 0);
            }
            {

                result.rateControlModes = decoder0.readInts(40, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i1 = 0; i1 < result.rateControlModes.length; ++i1) {
                        VideoEncodeAcceleratorSupportedRateControlMode.validate(result.rateControlModes[i1]);
                    }
                }
            }
            {

                result.scalabilityModes = decoder0.readInts(48, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i1 = 0; i1 < result.scalabilityModes.length; ++i1) {
                        SvcScalabilityMode.validate(result.scalabilityModes[i1]);
                    }
                }
            }

        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

        encoder0.encode(this.profile, 8);

        encoder0.encode(this.maxFramerateNumerator, 12);

        encoder0.encode(this.minResolution, 16, false);

        encoder0.encode(this.maxResolution, 24, false);

        encoder0.encode(this.maxFramerateDenominator, 32);

        encoder0.encode(this.isSoftwareCodec, 36, 0);

        encoder0.encode(this.rateControlModes, 40, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);

        encoder0.encode(this.scalabilityModes, 48, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
    }
}