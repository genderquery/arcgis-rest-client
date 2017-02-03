package com.stoatly.ersi.arcgis.geometry;

import com.google.gson.annotations.JsonAdapter;
import com.stoatly.ersi.arcgis.json.SpatialReferenceTypeAdapter;

/**
 * Instances of this class represent a specific coordinate system, identified by a well-known ID
 * (WKID) number or well-known text (WKT) string. A SpatialReference is immutable.
 */
@JsonAdapter (SpatialReferenceTypeAdapter.class)
public final class SpatialReference {

    public static final int WKID_INVALID = -1;
    public static final int WKID_CUSTOM = 0;
    private int mWellKnownId = WKID_INVALID;
    private String mWellKnownText;

    /**
     * Creates a new immutable SpatialReference with the given well-known text.
     *
     * @param wellKnownText the well-known text of the new SpatialReference
     */
    public SpatialReference(final String wellKnownText) {
        mWellKnownId = WKID_CUSTOM;
        mWellKnownText = wellKnownText;
    }

    /**
     * Creates a new immutable SpatialReference with the given well-known ID.
     *
     * @param wellKnownId the well-known ID of the new SpatialReference
     */
    public SpatialReference(final int wellKnownId) {
        mWellKnownId = wellKnownId;
    }

    /**
     * @return an int of the well-known ID for this SpatialReference. Returns {@link
     * SpatialReference#WKID_CUSTOM} if this SpatialReference was created with a well-known text.
     */
    public int getWellKnownId() {
        return mWellKnownId;
    }

    /**
     * @return a string of the well-known text for this SpatialReference. Returns null if this
     * SpatialReference was created with a well-known ID.
     */
    public String getWellKnownText() {
        return mWellKnownText;
    }
}
