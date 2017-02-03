package com.stoatly.ersi.arcgis.geometry;

/**
 * Base class for geometric shapes.
 * The specific geometric shape is returned by {@link #getGeometryType()}.
 */
abstract class Geometry {

    private GeometryType mGeometryType;
    private SpatialReference mSpatialReference;

    Geometry(final GeometryType geometryType, final SpatialReference spatialReference) {
        mGeometryType = geometryType;
        mSpatialReference = spatialReference;
    }

    Geometry(final GeometryType geometryType) {
        mGeometryType = geometryType;
    }

    static Geometry fromJson(String json) {
        return null;
    }

    public SpatialReference getSpatialReference() {
        return mSpatialReference;
    }

    public GeometryType getGeometryType() {
        return mGeometryType;
    }
}
