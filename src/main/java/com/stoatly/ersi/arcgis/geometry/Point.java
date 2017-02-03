package com.stoatly.ersi.arcgis.geometry;

public final class Point extends Geometry {

    private double mX;
    private double mY;

    public Point(final double x, final double y) {
        this(x, y, null);
    }

    public Point(final double x, final double y, final SpatialReference spatialReference) {
        super(GeometryType.POINT, spatialReference);
        mX = x;
        mY = y;
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }
}
