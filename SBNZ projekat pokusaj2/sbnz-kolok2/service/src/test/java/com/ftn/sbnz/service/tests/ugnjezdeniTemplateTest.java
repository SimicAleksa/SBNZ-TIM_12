package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.ParametriZaKaznu;
import com.ftn.sbnz.model.ParametriZaNaseljeIVreme;
import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.model.Vozac;
import com.ftn.sbnz.model.Vozilo;
import com.ftn.sbnz.model.ZahtevZaKaznu;

import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.io.IOUtils;
import org.drools.core.time.SessionPseudoClock;
import org.drools.serialization.protobuf.ProtobufMessages.FactHandle;
import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.internal.utils.KieHelper;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ugnjezdeniTemplateTest {


    @Test
    public void tests()
    {
        KieSession kSession = insertRules();
        writeAllExistingRules(kSession);
        insertObjects(kSession);
        int n = kSession.fireAllRules();
        assertEquals(5, n);
        
    }

    private void insertObjects(KieSession kSession) {
        PodaciSaRadaraDTO p1 = new PodaciSaRadaraDTO("1", "3905732507920", "Veternik",
                54.2, "kisa", "naseljeno mesto");
        Vozac vozac1 = new Vozac("brojVozacke123", "Marko", "Markovic", 2);
        Vozilo vozilo1 = new Vozilo("vozilo1id", "brojVozacke123", 
        "crvena", "Mercedes", "B180", "3905732507920");


        kSession.insert(p1);
        kSession.insert(vozac1);
        kSession.insert(vozilo1);

        
        
    }

    private KieSession insertRules()
    {
        InputStream template12 = ugnjezdeniTemplateTest.class.getResourceAsStream("/rules/ugnjezdeniTemplate.drt");
        InputStream basicRules = ugnjezdeniTemplateTest.class.getResourceAsStream("/rules/basicRules.drl");
        InputStream template3 = ugnjezdeniTemplateTest.class.getResourceAsStream("/rules/templateZaKaznu.drt");


        List<ParametriZaNaseljeIVreme> parametri1 = new ArrayList<>();
        parametri1.add(new ParametriZaNaseljeIVreme("naseljeno mesto", 50.00, "aleksa", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("nenaseljeno mesto", 70.00, "aleksic", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("sad", 0.00, "kisa", 20));
        parametri1.add(new ParametriZaNaseljeIVreme("dsa", 0.00, "sneg", 30));

        List<ParametriZaKaznu> parametri2 = new ArrayList<>();
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", Double.valueOf(1), Double.valueOf(10.0), Double.valueOf(3000.00), Double.valueOf(3000.00), 0, 0));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 11.0, 20.0, 5000.00, 5000.00, 0, 0));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 21.0, 30.0, 10000.00, 10000.00, 4, 0));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 31.0, 50.0, 10000.00, 20000.00, 4, 0));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 51.0, 70.0, 20000.00, 40000.00, 7, 15));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 71.0, 90.0, 100000.00, 120000.00, 14, 45));
        parametri2.add(new ParametriZaKaznu("naseljeno mesto", 91.0, 1000, 0.00, 0.00, 0, 60));

        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 1.0, 10.0, 3000.00, 3000.00, 0, 0));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 11.0, 20.0, 3000.00, 3000.00, 0, 0));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 21.0, 30.0, 5000.00, 5000.00, 0, 0));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 31.0, 40.0, 10000.00, 10000.00, 0, 0));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 41.0, 60.0, 10000.00, 20000.00, 3, 0));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 61.0, 80.0, 20000.00, 40000.00, 6, 15));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 81.0, 100.0, 100000.00, 200000.00, 14, 45));
        parametri2.add(new ParametriZaKaznu("nenaseljeno mesto", 101.0, 1000, 0.00, 0.00, 0, 60));


        /*ObjectDataCompiler converter = new ObjectDataCompiler();
        KieHelper kieHelper = new KieHelper();

        String drl1 = converter.compile(parametri1, template);
        kieHelper.addContent(drl1, ResourceType.DRL);
        KieSession kSession = kieHelper.build().newKieSession();

        doFirstTemplateTest(kSession);
        return kSession;*/

        //////////////////////////////////////////////////

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl1 = converter.compile(parametri1, template12);
        String drl2 = "";
        try{
            drl2 = IOUtils.toString(basicRules, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            System.out.println("Desila se greska");
        }
        String drl3 = converter.compile(parametri2, template3);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl1, ResourceType.DRL);
        kieHelper.addContent(drl2, ResourceType.DRL);
        kieHelper.addContent(drl3, ResourceType.DRL);

        KieBaseConfiguration config = KieServices.get().newKieBaseConfiguration();
        config.setOption(EventProcessingOption.STREAM);

        KieBase kieBase = kieHelper.build(config);
        KieSession kSession = kieBase.newKieSession();
        return kSession; 
    }





    private void writeAllExistingRules(KieSession kSession) {
        KieBase kieBase = kSession.getKieBase();
        Collection<KiePackage> packages = kieBase.getKiePackages();
        for (KiePackage kiePackage : packages) {
            Collection<org.kie.api.definition.rule.Rule> rules = kiePackage.getRules();
            for (org.kie.api.definition.rule.Rule rule : rules) {
                System.out.println(rule.getName());
            }
        }
    }
}
