package com.stoatly.ersi.arcgis.geometry;

public class Envelope extends Geometry {

    private double mXMin;
    private double mYMin;
    private double mXMax;
    private double mYMax;

    public Envelope(final Point p1, final Point p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public Envelope(final double x1, final double y1, final double x2, final double y2) {
        this(x1, y1, x2, y2, null);
    }

    public Envelope(final double x1, final double y1, final double x2, final double y2,
            final SpatialReference spatialReference) {
        super(GeometryType.ENVELOPE, spatialReference);
        mXMin = x1;
        mYMin = y1;
        mXMax = x2;
        mYMax = y2;
    }

    public double getXMin() {
        return mXMin;
    }

    public double getYMin() {
        return mYMin;
    }

    public double getXMax() {
        return mXMax;
    }

    public double getYMax() {
        return mYMax;
    }
}
