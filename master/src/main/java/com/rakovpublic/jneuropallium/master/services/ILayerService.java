package com.rakovpublic.jneuropallium.master.services;

import com.rakovpublic.jneuropallium.master.model.INeuronLayer;
import com.rakovpublic.jneuropallium.master.model.ISignalLayer;

import java.util.List;

public interface ILayerService {
    void deleteNeuron(Integer layerId, Long neuronId);

    void addNeuron(String neuronJson, Integer layerId);

    void mergeNeurons(Integer layerId, List<Long> neuronIds);

    void isProcessed(Long layerId);

    <K extends INeuronLayer> K getNeuronLayerForNode(Integer nodeId);

    <K extends ISignalLayer> K getSignalLayerForNode(Integer nodeId, Integer layerId);

}
