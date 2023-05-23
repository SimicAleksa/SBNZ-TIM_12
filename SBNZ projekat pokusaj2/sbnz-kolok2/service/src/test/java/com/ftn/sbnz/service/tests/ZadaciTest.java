package com.ftn.sbnz.service.tests;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import com.ftn.sbnz.model.Boat;
import com.ftn.sbnz.model.BoatTemp;
import com.ftn.sbnz.model.Brod;
import com.ftn.sbnz.model.Wave;

import ch.qos.logback.core.subst.Token.Type;

public class ZadaciTest {

    @Test
    public void test1(){

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("cepKsession");

        SessionPseudoClock clock = kieSession.getSessionClock();

        kieSession.insert(new Boat(1));
        kieSession.insert(new Wave(1, 7));
        clock.advanceTime(2, TimeUnit.MINUTES);

        kieSession.insert(new Wave(2, 6));
        clock.advanceTime(20, TimeUnit.MINUTES);

        kieSession.insert(new Wave(3, 5));
        clock.advanceTime(2, TimeUnit.MINUTES);

        int fireRUleCount = kieSession.fireAllRules();
        System.out.println(fireRUleCount);
    }

    @Test
    public void test2(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("cepKsession");



        kieSession.insert( new Brod("Transport tereta I putnika", "Brod"));
        kieSession.insert( new Brod("Ratni brod", "Brod"));

            
        kieSession.insert( new Brod("Rekreacija","Transport tereta I putnika"));
        kieSession.insert( new Brod("Kruzer","Rekreacija"));
        kieSession.insert( new Brod("Sinfonija","Kruzer"));
        kieSession.insert( new Brod("Kraljica Meri","Kruzer"));
        kieSession.insert( new Brod("Poezija","Kruzer"));

        kieSession.insert( new Brod("Jahta","Rekreacija"));
        kieSession.insert( new Brod("Frida","Jahta"));
        kieSession.insert( new Brod("Eklips jahta","Jahta"));
        kieSession.insert( new Brod("Dilbar","Jahta"));


        kieSession.insert( new Brod("Fregata","Ratni brod"));
        kieSession.insert( new Brod("Admiral Gorshkov","Fregata"));
        kieSession.insert( new Brod("Penelope","Fregata"));

        kieSession.insert( new Brod("Oklopnjace","Ratni brod"));
        kieSession.insert( new Brod("SMS Kaiser","Oklopnjace"));
        kieSession.insert( new Brod("CSS VIrginia","Oklopnjace"));

        kieSession.insert( new Brod("Nosaci aviona","Ratni brod"));
        kieSession.insert( new Brod("Akagi","Nosaci aviona"));
        kieSession.insert( new Brod("Kaga","Nosaci aviona"));

        kieSession.insert( new Brod("Patrolni brodovi","Ratni brod"));
        kieSession.insert( new Brod("Minekaze","Patrolni brodovi"));
        kieSession.insert( new Brod("Savakaza","Patrolni brodovi"));

        int fireRUleCount = kieSession.fireAllRules();
        System.out.println(fireRUleCount);
    }

    @Test
    public void test3(){
        InputStream template = ZadaciTest.class.getResourceAsStream("/rules/zad3.drt");

        System.out.println(template + " je template");

        List<BoatTemp> data = new ArrayList<BoatTemp>();
        data.add(new BoatTemp(135,9,500,"Converted Cargo Vessel"));
        data.add(new BoatTemp(200,9,800,"Converted Tanker"));
        data.add(new BoatTemp(215,10,2500,"Cellular Containership"));
        data.add(new BoatTemp(250,12,4000,"Panamax Class"));

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);

        KieHelper helper = new KieHelper();
        helper.addContent(drl,ResourceType.DRL);
        KieSession kieSession = helper.build().newKieSession();

        kieSession.insert(new BoatTemp(200,9,800));

        int ruleFIreCOnt = kieSession.fireAllRules();
        System.out.println(ruleFIreCOnt);

    }
    
}
