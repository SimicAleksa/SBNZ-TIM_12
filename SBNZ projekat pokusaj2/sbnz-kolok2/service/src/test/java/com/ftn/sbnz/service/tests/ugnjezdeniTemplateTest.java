package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.ParametriZaNaseljeIVreme;
import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.model.ZahtevZaKaznu;

import org.drools.core.time.SessionPseudoClock;
import org.drools.serialization.protobuf.ProtobufMessages.FactHandle;
import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ugnjezdeniTemplateTest {


    @Test
    public void tests()
    {
        InputStream template = ugnjezdeniTemplateTest.class.getResourceAsStream("/rules/ugnjezdeniTemplate.drt");

        List<ParametriZaNaseljeIVreme> parametri1 = new ArrayList<>();
        parametri1.add(new ParametriZaNaseljeIVreme("naseljeno mesto", 50.00, "aleksa", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("nenaseljeno mesto", 70.00, "aleksic", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("sad", 0.00, "kisa", 20));
        parametri1.add(new ParametriZaNaseljeIVreme("dsa", 0.00, "sneg", 30));

        ObjectDataCompiler converter = new ObjectDataCompiler();
        KieHelper kieHelper = new KieHelper();


        String drl1 = converter.compile(parametri1, template);
        kieHelper.addContent(drl1, ResourceType.DRL);
        KieSession kSession = kieHelper.build().newKieSession();

        doFirstTemplateTest(kSession);
        createKaznuTest(kSession);
        
    }

    private void createKaznuTest(KieSession previousSession)
    {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("cepKsession");

        SessionPseudoClock clock = kieSession.getSessionClock();

        for (org.kie.api.runtime.rule.FactHandle handle : previousSession.getFactHandles()) {
            Object fact = previousSession.getObject(handle);
            if (fact instanceof ZahtevZaKaznu) {
                ZahtevZaKaznu z = (ZahtevZaKaznu) fact;
                kieSession.insert(z);
            }
        }

        int n = kieSession.fireAllRules();
        assertEquals(1, n);
    }



    private void doFirstTemplateTest(KieSession kSession) {

        PodaciSaRadaraDTO p1 = new PodaciSaRadaraDTO("1", "3905732507920", "Veternik",
                54.2, "kisa", "naseljeno mesto");
        kSession.insert(p1);


        int n = kSession.fireAllRules();
        System.out.println(p1.getOgranicenje() + " je novo ogranicenje u radaru");
        assertEquals(3, n);
    }
}
