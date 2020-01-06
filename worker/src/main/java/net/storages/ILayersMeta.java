package net.storages;

import net.layers.ILayer;

import java.io.Serializable;
import java.util.List;

public interface ILayersMeta extends Serializable {
    List<ILayerMeta> getLayers();
    IResultLayerMeta getResultLayer();
    ILayerMeta getLayerByID(int id);
}
