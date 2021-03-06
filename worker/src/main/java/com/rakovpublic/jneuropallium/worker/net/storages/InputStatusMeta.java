package com.rakovpublic.jneuropallium.worker.net.storages;

import com.rakovpublic.jneuropallium.worker.net.storages.IInitInput;

public class InputStatusMeta {
    private Boolean status;
    private Boolean mandatoryUpdated;
    private Integer updateOnceInNRuns;
    private Integer currentRuns;
    private String name;

    public InputStatusMeta(Boolean status, Boolean mandatoryUpdated, Integer updateOnceInNRuns, String name) {
        this.status = status;
        this.mandatoryUpdated = mandatoryUpdated;
        this.updateOnceInNRuns = updateOnceInNRuns;
        currentRuns=0;
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getMandatoryUpdated() {
        return mandatoryUpdated;
    }

    public void setMandatoryUpdated(Boolean mandatoryUpdated) {
        this.mandatoryUpdated = mandatoryUpdated;
    }

    public Integer getUpdateOnceInNRuns() {
        return updateOnceInNRuns;
    }

    public void setUpdateOnceInNRuns(Integer updateOnceInNRuns) {
        this.updateOnceInNRuns = updateOnceInNRuns;
    }

    public Integer getCurrentRuns() {
        return currentRuns;
    }

    public void setCurrentRuns(Integer currentRuns) {
        this.currentRuns = currentRuns;
    }

    public String getName() {
        return name;
    }
}
