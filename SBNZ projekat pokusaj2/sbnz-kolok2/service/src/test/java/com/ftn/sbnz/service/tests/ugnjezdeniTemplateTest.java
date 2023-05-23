package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.ParametriZaKaznu;
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
        KieSession kSession = doAllForFirstTemplateTest();
        
        kSession = changeZahtjevZaKaznuTest(kSession);
        kSession = kreirajKaznuTest(kSession);
    }


    private KieSession kreirajKaznuTest(KieSession previousSession)
    {
        InputStream template = ugnjezdeniTemplateTest.class.getResourceAsStream("/rules/templateZaKaznu.drt");

        List<ParametriZaKaznu> parametri = new ArrayList<>();
        parametri.add(new ParametriZaKaznu("naseljeno mesto", Double.valueOf(1), Double.valueOf(10.0), Double.valueOf(3000.00), Double.valueOf(3000.00), 0, 0));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 11.0, 20.0, 5000.00, 5000.00, 0, 0));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 21.0, 30.0, 10000.00, 10000.00, 4, 0));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 31.0, 50.0, 10000.00, 20000.00, 4, 0));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 51.0, 70.0, 20000.00, 40000.00, 7, 15));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 71.0, 90.0, 100000.00, 120000.00, 14, 45));
        parametri.add(new ParametriZaKaznu("naseljeno mesto", 91.0, 1000, 0.00, 0.00, 0, 60));

        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 1.0, 10.0, 3000.00, 3000.00, 0, 0));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 11.0, 20.0, 3000.00, 3000.00, 0, 0));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 21.0, 30.0, 5000.00, 5000.00, 0, 0));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 31.0, 40.0, 10000.00, 10000.00, 0, 0));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 41.0, 60.0, 10000.00, 20000.00, 3, 0));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 61.0, 80.0, 20000.00, 40000.00, 6, 15));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 81.0, 100.0, 100000.00, 200000.00, 14, 45));
        parametri.add(new ParametriZaKaznu("nenaseljeno mesto", 101.0, 1000, 0.00, 0.00, 0, 60));

        ObjectDataCompiler converter = new ObjectDataCompiler();
        KieHelper kieHelper = new KieHelper();

        String drl1 = converter.compile(parametri, template);
        kieHelper.addContent(drl1, ResourceType.DRL);
        KieSession kSession = kieHelper.build().newKieSession();

        ZahtevZaKaznu z = new ZahtevZaKaznu();
        for (org.kie.api.runtime.rule.FactHandle handle : previousSession.getFactHandles()) {
            Object fact = previousSession.getObject(handle);
            if (fact instanceof ZahtevZaKaznu) {
                z = (ZahtevZaKaznu) fact;
                kSession.insert(z);
            }
        }

        int n = kSession.fireAllRules();
        assertEquals(1, n);

        for (org.kie.api.runtime.rule.FactHandle handle : previousSession.getFactHandles()) {
            Object fact = previousSession.getObject(handle);
            if (fact instanceof Kazna) {
                Kazna k = (Kazna) fact;
                //System.out.println(k);
            }
        }
        return kSession;
    }


    private KieSession doAllForFirstTemplateTest()
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
        return kSession;
    }


    private KieSession changeZahtjevZaKaznuTest(KieSession previousSession)
    {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("cepKsession");

        SessionPseudoClock clock = kieSession.getSessionClock();

        ZahtevZaKaznu z = new ZahtevZaKaznu();
        for (org.kie.api.runtime.rule.FactHandle handle : previousSession.getFactHandles()) {
            Object fact = previousSession.getObject(handle);
            if (fact instanceof ZahtevZaKaznu) {
                z = (ZahtevZaKaznu) fact;
                kieSession.insert(z);
            }
        }

        int n = kieSession.fireAllRules();
        System.out.println(z.getTipZahtevaZaKaznu() + " JE NOVI TIP");
        assertEquals(1, n);
        assertEquals("DODELI_KAZNU", z.getTipZahtevaZaKaznu());
        return kieSession;
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
