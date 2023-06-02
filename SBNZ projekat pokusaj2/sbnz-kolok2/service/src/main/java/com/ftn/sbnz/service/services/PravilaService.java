package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.config.FileKieSessionLoader;
import com.ftn.sbnz.service.repositories.*;
import org.apache.commons.io.IOUtils;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class PravilaService {
    @Autowired
    PodaciSaRadaraRepository podaciSaRadaraRepository;
    @Autowired
    IzvrsiteljskiPostupakRepository izvrsiteljskiPostupakRepository;
    @Autowired
    KaznaRepository kaznaRepository;
    @Autowired
    KorisnikRepository korisnikRepository;
    @Autowired
    OduzimanjeVozackeRepository oduzimanjeVozackeRepository;
    @Autowired
    VoziloRepository voziloRepository;
    @Autowired
    ZahtevZaKaznuRepository zahtevZaKaznuRepository;
    @Autowired
    PatrolaRepository patrolaRepository;

    private KieSession insertRules() {
        InputStream template12 = PodaciSaRadaraService.class.getResourceAsStream("/rules/ugnjezdeniTemplate.drt");
        InputStream basicRules = PodaciSaRadaraService.class.getResourceAsStream("/rules/basicRules.drl");
        InputStream template3 = PodaciSaRadaraService.class.getResourceAsStream("/rules/templateZaKaznu.drt");


        List<ParametriZaNaseljeIVreme> parametri1 = new ArrayList<>();
        parametri1.add(new ParametriZaNaseljeIVreme("naseljeno mesto", 50.00, "aleksa", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("nenaseljeno mesto", 70.00, "aleksic", 0));
        parametri1.add(new ParametriZaNaseljeIVreme("sad", 0.00, "kisa", 20));
        parametri1.add(new ParametriZaNaseljeIVreme("dsa", 0.00, "sneg", 30));
        parametri1.add(new ParametriZaNaseljeIVreme("dsa", 0.00, "regularno", 0));


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

        ////////////////////////////////// umjesto koda izmedju ide novi kod
//        KieSession kSession = kieBase.newKieSession();
        ////////////////////////////////////////////////////////////////////
        KieSessionConfiguration sessionConfig = KieServices.Factory.get().newKieSessionConfiguration();
        sessionConfig.setOption( ClockTypeOption.get("pseudo") );
        KieSession kSession = kieBase.newKieSession( sessionConfig, null );

        return kSession;

    }

    private void writeAllExistingRules(KieSession kSession) {
        KieBase kieBase = kSession.getKieBase();
        Collection<KiePackage> packages = kieBase.getKiePackages();
        for (KiePackage kiePackage : packages) {
            Collection<Rule> rules = kiePackage.getRules();
            for (org.kie.api.definition.rule.Rule rule : rules) {
                System.out.println(rule.getName());
            }
        }
    }

    public void insertObjectsFromDatabase(KieSession kSession) {
        for (Korisnik k: korisnikRepository.findAll()) kSession.insert(k);
        for (IzvrsiteljskiPostupak i: izvrsiteljskiPostupakRepository.findAll()) kSession.insert(i);
//        for (Kazna k: kaznaRepository.findAll()) kSession.insert(k);
        for (OduzimanjeVozacke k: oduzimanjeVozackeRepository.findAll()) kSession.insert(k);
//        for (PodaciSaRadaraDTO k: podaciSaRadaraRepository.findAll()) kSession.insert(k);
        for (Vozilo k: voziloRepository.findAll()) kSession.insert(k);
//        for (ZahtevZaKaznu k: zahtevZaKaznuRepository.findAll())
//        {
//            System.out.println(k.toString());
//        }

        for (Patrola p: patrolaRepository.findAll()) kSession.insert(p);
    }

    public KieSession prepareSystem() {
        KieSession kSession = insertRules();
        writeAllExistingRules(kSession);
        prepareDatabase();
        insertObjectsFromDatabase(kSession);
        int n = kSession.fireAllRules();
        System.out.println(n + "je broj odradjenih pravila");
        // TODO ovdje bih mozda mogla da pogledam da li se sve sacuvalo
        saveKieSession(kSession);
        return kSession;
    }

    private void prepareDatabase() {
        this.podaciSaRadaraRepository.deleteAll();
        this.kaznaRepository.deleteAll();
        this.zahtevZaKaznuRepository.deleteAll();
        this.voziloRepository.deleteAll();
        this.voziloRepository.save(new Vozilo("065-AV-243", "brojvozacke123", "siva", "audi", "a2"));
        this.voziloRepository.save(new Vozilo("123-NS-456", "drugibroj123", "bela", "toyota", "aygo"));
        this.korisnikRepository.deleteAll();
        this.korisnikRepository.save(new Vozac("brojvozacke123", "Marko", "Markovic", "marko@gmail.com", "m", 2, 5000));
        this.korisnikRepository.save(new Vozac("drugibroj123", "Pera", "Peric", "pera@gmail.com", "p", 0, 40000));
        //this.korisnikRepository.save(new Vozac("brojvozacke123", "Marko", "Markovic", "marko@gmail.com", "m", 0));
        this.korisnikRepository.save(new Admin("Admin", "Admin", "admin@gmail.com", "a"));
        this.oduzimanjeVozackeRepository.deleteAll();
        this.izvrsiteljskiPostupakRepository.deleteAll();
        this.patrolaRepository.deleteAll();
        

    }

    public void saveKieSession(KieSession kSession) {
        String filePath = "C:\\Users\\Nevena\\Desktop\\kopija\\SBNZ-TIM_12-feature_front\\SBNZ projekat pokusaj2\\sbnz-kolok2\\kjar\\src\\main\\resources\\kieSession.bin";
        File file = new File(filePath);
        FileKieSessionLoader fksl = new FileKieSessionLoader(file);
        fksl.save(kSession);
    }

    public KieSession readKieSession() {
        String filePath = "C:\\Users\\Nevena\\Desktop\\kopija\\SBNZ-TIM_12-feature_front\\SBNZ projekat pokusaj2\\sbnz-kolok2\\kjar\\src\\main\\resources\\kieSession.bin";
        File file = new File(filePath);

        FileKieSessionLoader fksl = new FileKieSessionLoader(file);
        return fksl.load();
    }

    public void saveObjectsInRepos(KieSession kieSession) {
        // mozda bi prije ovoga trebalo da obrisem sve podatke u bazi
        for (Object o: kieSession.getObjects())
        {
            if (o instanceof Korisnik)
            {
//                korisnikRepository.deleteAll();
                korisnikRepository.save((Korisnik) o);
            }
            if (o instanceof IzvrsiteljskiPostupak)
            {
//                izvrsiteljskiPostupakRepository.deleteAll();
                izvrsiteljskiPostupakRepository.save((IzvrsiteljskiPostupak) o);
            }
            if (o instanceof Kazna)
            {
//                kaznaRepository.deleteAll();
                kaznaRepository.save((Kazna) o);
            }
            if (o instanceof OduzimanjeVozacke)
            {
//                oduzimanjeVozackeRepository.deleteAll();
                oduzimanjeVozackeRepository.save((OduzimanjeVozacke) o);
            }
            if (o instanceof PodaciSaRadaraDTO)
            {
//                podaciSaRadaraRepository.deleteAll();
                podaciSaRadaraRepository.save((PodaciSaRadaraDTO) o);
            }
            if (o instanceof Vozilo)
            {
//                voziloRepository.deleteAll();
                voziloRepository.save((Vozilo) o);
            }
            if (o instanceof ZahtevZaKaznu/* && !nalaziSeUKesuZahtev(o)*/)
            {
//                zahtevZaKaznuRepository.deleteAll();
                zahtevZaKaznuRepository.save((ZahtevZaKaznu) o);
            }
            if (o instanceof Patrola)
            {
//                patrolaRepository.deleteAll();
                patrolaRepository.save((Patrola) o);
            }
            System.out.println(o.toString());
        }
        System.out.println("zavrseno ispisivanje");
    }

    private boolean nalaziSeUKesuZahtev(Object o) {
        ZahtevZaKaznu z = (ZahtevZaKaznu) o;
        return z.getSifraKazne().equals("1") || z.getSifraKazne().equals("2") || z.getSifraKazne().equals("3");
    }

    private boolean nalaziSeUKesuAdmin(Object o) {
        if (o instanceof Admin)
        {
            for (Korisnik k: korisnikRepository.findAll() )
            {
                System.out.println(k.getEmail() + "je mejl");
                if (k.getEmail().equals("admin@gmail.com"))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean nalaziSeUKesu(Object o) {
        Kazna k = (Kazna) o;
        return k.getId().equals("1") || k.getId().equals("2") || k.getId().equals("3");
    }

    public void deleteCreated() {
        this.kaznaRepository.deleteAll();
        this.izvrsiteljskiPostupakRepository.deleteAll();
        this.zahtevZaKaznuRepository.deleteAll();
        this.podaciSaRadaraRepository.deleteAll();

    }

    public void vratiVrijemeObjektimaUBazi() {
        // kazna, oduzimanjeVozacke, patrola, podaciSaRadara, zahtjevZaKaznu
        for(Kazna k : kaznaRepository.findAll())
        {
            k.setDatum(k.getDatum().minusMonths(7));
            kaznaRepository.save(k);
        }
        for (OduzimanjeVozacke o: oduzimanjeVozackeRepository.findAll())
        {
            o.setDatum(o.getDatum().minusMonths(7));
            oduzimanjeVozackeRepository.save(o);
        }
        for (Patrola p: patrolaRepository.findAll())
        {
            p.setDatum(p.getDatum().minusMonths(7));
            patrolaRepository.save(p);
        }
        for (PodaciSaRadaraDTO p: podaciSaRadaraRepository.findAll())
        {
            p.setDatum(p.getDatum().minusMonths(7));
            podaciSaRadaraRepository.save(p);
        }
        for (ZahtevZaKaznu z: zahtevZaKaznuRepository.findAll())
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(z.getDatum());
            calendar.add(Calendar.MONTH, -7);
            Date sevenMonthsBack = calendar.getTime();
            z.setDatum(sevenMonthsBack);
        }

    }

    public KieSession vratiVrijemeObjektimaUSesiji(KieSession kieSession) {
        for (Object o: kieSession.getObjects())
        {
            if (o instanceof Kazna)
            {
                Kazna k = (Kazna) o;
                k.setDatum(k.getDatum().minusMonths(7));
                System.out.println("Vrijeme kazne u sesiji je " + k.getDatum());
            }
            if (o instanceof OduzimanjeVozacke)
            {
                OduzimanjeVozacke od = (OduzimanjeVozacke) o;
                od.setDatum(od.getDatum().minusMonths(7));
            }
            if (o instanceof Patrola)
            {
                Patrola p = (Patrola) o;
                p.setDatum(p.getDatum().minusMonths(7));
            }
            if (o instanceof PodaciSaRadaraDTO)
            {
                PodaciSaRadaraDTO p = (PodaciSaRadaraDTO) o;
                p.setDatum(p.getDatum().minusMonths(7));
            }
            if (o instanceof ZahtevZaKaznu)
            {
                ZahtevZaKaznu z = (ZahtevZaKaznu) o;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(z.getDatum());
                calendar.add(Calendar.MONTH, -7);
                Date sevenMonthsBack = calendar.getTime();
                z.setDatum(sevenMonthsBack);
            }
        }
        return kieSession;
    }

}
