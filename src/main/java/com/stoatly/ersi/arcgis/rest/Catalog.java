package com.stoatly.ersi.arcgis.rest;

import java.util.List;

public abstract class Catalog extends Resource {

    abstract List<Folder> getFolders();

    abstract List<Service> getServices();
}

