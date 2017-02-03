package com.stoatly.ersi.arcgis.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.stoatly.ersi.arcgis.geometry.SpatialReference;

import java.io.IOException;

/**
 * Converts a {@link SpatialReference} to and from JSON.
 */
public class SpatialReferenceTypeAdapter extends TypeAdapter<SpatialReference> {

    /**
     * Writes a JSON object representing a {@link SpatialReference}.
     * <p>
     * The JSON object will contain only one of well-known text ({@code wkt}) or well-known ID
     * ({@code wkid}), depending on how the {@link SpatialReference} was instantiated.
     *
     * @param jsonWriter
     * @param spatialReference the {@link SpatialReference} to convert. May be null.
     * @throws IOException
     */
    @Override
    public void write(final JsonWriter jsonWriter, final SpatialReference spatialReference)
            throws IOException {
        if (spatialReference == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        final String wellKnownText = spatialReference.getWellKnownText();
        if (wellKnownText != null) {
            jsonWriter.name("wkt").value(wellKnownText);
        }
        else {
            final int wellKnownId = spatialReference.getWellKnownId();
            jsonWriter.name("wkid").value(wellKnownId);
        }
        jsonWriter.endObject();
    }

    /**
     * Reads a JSON object and converts it to a {@link SpatialReference}.
     * <p>
     * If the JSON object contains both a well-known text ({@code wkt}) and a well-known ID
     * ({@code wkid}), only the well-know text is retained.
     * <p>
     * If neither name is found, null will be returned.
     *
     * @param jsonReader
     * @return the converted {@link SpatialReference}. May be null.
     * @throws IOException
     */
    public SpatialReference read(final JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        SpatialReference spatialReference = null;
        jsonReader.beginObject();
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            final String nextName = jsonReader.nextName();
            if (nextName.equals("wkt")) {
                final String wellKnownText = jsonReader.nextString();
                if (spatialReference == null) {
                    spatialReference = new SpatialReference(wellKnownText);
                }
            }
            else if (nextName.equals("wkid")) {
                final int wellKnownId = jsonReader.nextInt();
                if (spatialReference == null) {
                    spatialReference = new SpatialReference(wellKnownId);
                }
            }
            else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return spatialReference;
    }
}
