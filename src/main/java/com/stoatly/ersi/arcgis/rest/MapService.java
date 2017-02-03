package com.stoatly.ersi.arcgis.rest;

import com.stoatly.ersi.arcgis.geometry.Envelope;
import com.stoatly.ersi.arcgis.geometry.SpatialReference;

import javax.ws.rs.client.ClientBuilder;

public class MapService extends Service {

    public Object exportMap(ExportMapParameters params) {
        return null;
    }

    public class ExportMapParameters {

        ResponseFormat mResponseFormat;
        Envelope mBoundingBox;
        Size mImageSize;
        int mImageDpi;
        SpatialReference mImageSpatialReference;
        SpatialReference mBoundingBoxSpatialReference;
        ImageFormat mImageFormat;
        long[] mLayers;
        boolean mTransparent;
    }
}
