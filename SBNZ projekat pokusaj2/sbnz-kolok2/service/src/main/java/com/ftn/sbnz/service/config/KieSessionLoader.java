package com.ftn.sbnz.service.config;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;


public interface KieSessionLoader {

    public abstract void save(KieSession kieSession);

    public abstract KieSession load();

}

