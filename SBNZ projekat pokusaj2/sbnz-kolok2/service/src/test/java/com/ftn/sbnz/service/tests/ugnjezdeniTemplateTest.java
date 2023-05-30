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


    
}
