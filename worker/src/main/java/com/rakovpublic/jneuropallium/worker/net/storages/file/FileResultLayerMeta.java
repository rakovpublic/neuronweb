package com.rakovpublic.jneuropallium.worker.net.storages.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rakovpublic.jneuropallium.worker.neuron.IResultNeuron;
import com.rakovpublic.jneuropallium.worker.neuron.ISignalMerger;
import com.rakovpublic.jneuropallium.worker.neuron.ISignalProcessor;
import com.rakovpublic.jneuropallium.worker.net.signals.ISignal;
import com.rakovpublic.jneuropallium.worker.net.storages.IResultLayerMeta;
import com.rakovpublic.jneuropallium.worker.net.storages.filesystem.IFileSystem;
import com.rakovpublic.jneuropallium.worker.net.storages.filesystem.IFileSystemItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileResultLayerMeta extends FileLayerMeta implements IResultLayerMeta {
    FileResultLayerMeta(IFileSystemItem file, IFileSystem fs) {
        super(file, fs);
    }

    @Override
    public List<? extends IResultNeuron> getNeurons() {
        String layer = fileSystem.read(file);
        List<IResultNeuron> result = new ArrayList<>();
        JsonElement jelement = new JsonParser().parse(layer);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("neurons");
        ObjectMapper mapper= new ObjectMapper();
        for(JsonElement jel:jarray){
            String cl=jel.getAsJsonObject().getAsJsonPrimitive("currentNeuronClass").getAsString();
            try {
                IResultNeuron neuron= (IResultNeuron) mapper.readValue(jel.getAsJsonObject().toString(),Class.forName(cl));
                HashMap<Class<?>, ISignalProcessor> p= new HashMap<>();
                for(Map.Entry<String,JsonElement> e: jel.getAsJsonObject().getAsJsonObject("processorMap").entrySet()){
                    String cc= e.getValue().getAsJsonObject().getAsJsonPrimitive("signalProcessorClass").getAsString();
                    neuron.addSignalProcessor((Class<? extends ISignal>) Class.forName(e.getKey()),(ISignalProcessor) mapper.readValue(e.getValue().getAsJsonObject().toString(),Class.forName(cc)));
                }
                for(Map.Entry<String,JsonElement> e: jel.getAsJsonObject().getAsJsonObject("mergerMap").entrySet()){
                    String cc= e.getValue().getAsJsonObject().getAsJsonPrimitive("signalMergerClass").getAsString();
                    neuron.addSignalMerger((Class<? extends ISignal>) Class.forName(e.getKey()),(ISignalMerger) mapper.readValue(e.getValue().getAsJsonObject().toString(),Class.forName(cc)));
                }
                result.add(neuron);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                //TODO:Add logger
            }
        }
        return result;
    }
}
