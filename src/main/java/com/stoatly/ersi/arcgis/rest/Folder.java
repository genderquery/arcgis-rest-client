package com.stoatly.ersi.arcgis.rest;

import java.util.List;

public abstract class Folder extends Resource {

    abstract List<Service> getServices();
}
