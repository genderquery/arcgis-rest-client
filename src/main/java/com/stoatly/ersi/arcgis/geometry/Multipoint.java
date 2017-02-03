package com.stoatly.ersi.arcgis.geometry;

public class Multipoint extends Geometry {

    private Iterable<Point> mPoints;

    public Multipoint(Iterable<Point> points) {
        this(points, null);
    }

    public Multipoint(Iterable<Point> points, SpatialReference spatialReference) {
        super(GeometryType.MULTIPOINT, spatialReference);
        mPoints = points;
    }

    public Iterable<Point> getPoints() {
        return mPoints;
    }
}
