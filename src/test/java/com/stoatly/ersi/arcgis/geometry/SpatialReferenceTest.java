package com.stoatly.ersi.arcgis.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpatialReferenceTest {

    private static final int WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKID = 3857;
    private static final String WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKT =
            "PROJCS[\"WGS_1984_Web_Mercator_Auxiliary_Sphere\",GEOGCS[\"GCS_WGS_1984\","
                    + "DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],"
                    + "PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],"
                    + "PROJECTION[\"Mercator_Auxiliary_Sphere\"],PARAMETER[\"False_Easting\","
                    + "0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\","
                    + "0.0],PARAMETER[\"Standard_Parallel_1\",0.0],"
                    + "PARAMETER[\"Auxiliary_Sphere_Type\",0.0],UNIT[\"Meter\",1.0]]";

    @Test
    public void getWellKnownId() {
        final SpatialReference spatialReference = new SpatialReference(
                WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKID);
        final int wellKnownId = spatialReference.getWellKnownId();
        assertEquals("Well-known ID should be the same as given in constructor",
                wellKnownId,
                WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKID);
    }

    @Test
    public void getWellKnownText() {
        final SpatialReference spatialReference = new SpatialReference(
                WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKT);
        final String wellKnownText = spatialReference.getWellKnownText();
        assertEquals("Well-known text should be the same as given in constructor",
                wellKnownText,
                WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKT);
    }

    @Test
    public void wellKnownIdShouldBeCustomWhenCreatedWithWellKnownText() {
        final SpatialReference spatialReference =
                new SpatialReference(WGS_1984_WEB_MERCATOR_AUXILIARY_SPHERE_WKT);
        final int wellKnownId = spatialReference.getWellKnownId();
        assertEquals("Well-known ID should be WKID_CUSTOM",
                wellKnownId,
                SpatialReference.WKID_CUSTOM);
    }

}