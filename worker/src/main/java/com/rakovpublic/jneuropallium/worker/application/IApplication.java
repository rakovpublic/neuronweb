package com.rakovpublic.jneuropallium.worker.application;

import com.rakovpublic.jneuropallium.worker.synchronizer.IContext;

import java.io.Serializable;

public interface IApplication extends Serializable {
    void startApplication(IContext context);

}
