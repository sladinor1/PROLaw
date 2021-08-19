package com.prolaw.controller;

import com.prolaw.domain.*;
import com.prolaw.repository.*;

import org.apache.pulsar.shade.org.apache.commons.codec.digest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

import java.lang.ProcessHandle.Info;
import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.util.concurrent.atomic.LongAccumulator;

@RestController
@RequestMapping("/api")
public class TableController {
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    private int cont = 3;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository catRepository;

    @Autowired
    private GlossaryRepository gloRepository;

    @Autowired
    private NormativityRepository normRepository;

    @Autowired
    private ProcedureRepository proRepository;

    @Autowired
    private SubCategoryRepository subRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public void llenar() {
        boolean terminado = false;
        LOG.info("HOLA");
        do {
            for (int i = 1; i < 3; i++) {
                long j = i;
                LOG.info("Area: " + Integer.toString(i));
                Category category = catRepository.findByIdCate(j);
                if (!category.equals(null)) {
                    String ids = category.getIdsSubCate();
                    String[] parts = ids.split(",");
                    for (String part : parts) {
                        Subcategory sub = subRepository.findByIdSubcat(Long.valueOf(part));
                        List<Subcategory> c = category.getSubcategories();
                        c.add(sub);
                        category.setSubcategories(c);
                    }
                } else {
                    i = 99;
                }

            }
            for (int i = 1; i < 3; i++) {
                long j = i;
                LOG.info("Subrea: " + Integer.toString(i));
                Subcategory subcategory = subRepository.findByIdSubcat(j);
                if (!subcategory.equals(null)) {
                    String ids = subcategory.getIdsProcedu();
                    String[] parts = ids.split(",");
                    for (String part : parts) {
                        Procedure pro = proRepository.findByIdPro(Long.valueOf(part));
                        List<Procedure> c = subcategory.getProcedures();
                        c.add(pro);
                        subcategory.setProcedures(c);
                    }
                } else {
                    i = 99;
                }

            }
            for (int i = 1; i < 3; i++) {
                long j = i;
                LOG.info("Procedimiento: " + Integer.toString(i));
                Procedure procedure = proRepository.findByIdPro(j);
                if (!procedure.equals(null)) {
                    String ids = procedure.getIdsNorma();
                    String[] parts = ids.split(",");
                    for (String part : parts) {
                        LOG.info(part);
                        Normativity nor = normRepository.findByIdNor(Long.valueOf(part));
                        List<Normativity> c = procedure.getNormativity();
                        c.add(nor);
                        procedure.setNormativity(c);
                    }
                } else {
                    i = 99;
                }

            }

        } while (terminado == true);
    }

    public void llenarcasos() {
        List<Case> casos = new ArrayList<Case>();
        for (int i = 1; i < 30; i++) {
            try {
                long j = i;
                Case c = caseRepository.findByIdCase(j);
                if (!c.equals(null)) {
                    casos.add(c);
                }

            } catch (NullPointerException exception) {
                LOG.info(exception.toString());
            }
        }
        if (!casos.equals(null)) {
            for (Case caso : casos) {
                LOG.info("--------------------------");
                LOG.info(caso.getIdsAns());
                String ids = caso.getIdsAns();
                if (ids == "0") {
                    LOG.info("Not answers");
                } else {
                    String[] parts = ids.split(",");
                    for (String part : parts) {
                        Answers ans = answersRepository.findByIdAns(Long.valueOf(part));
                        List<Answers> res = caso.getAnswers();
                        res.add(ans);
                        caso.setAnswers(res);
                    }
                }
            }
        }

    }

    @ResponseBody
    @GetMapping(path = "/category/{nameCat}")
    public Category getCategory(@PathVariable("nameCat") String idC) {
        llenar();
        Category category = catRepository.findByNameCate(idC);
        if (!category.equals(null)) {
            return category;
        } else {
            LOG.info("The category with the name " + idC + " couldn't be found in the database.");
            return null;
        }

    }

    @ResponseBody
    @GetMapping(path = "/category/all")
    public List<Category> getCategory() {
        llenar();
        List<Category> cats = null;
        for (int i = 1; i < 3; i++) {
            long j = i;
            Category category = catRepository.findByIdCate(j);
            if (!category.equals(null)) {
                cats.add(category);
            }
        }
        return cats;
    }

    @ResponseBody
    @GetMapping(path = "/procedure/{namePro}")
    public Procedure getProcedure(@PathVariable("namePro") String idC) {
        llenar();
        Procedure category = proRepository.findByNamePro(idC);
        if (!category.equals(null)) {
            return category;
        } else {
            LOG.info("The procedure with the name " + idC + " couldn't be found in the database.");
            return null;
        }

    }

    @ResponseBody
    @GetMapping(path = "/glossary/word/{nombre_glo}")
    public Glossary getGlossary(@PathVariable("nombre_glo") String nameGlo) {
        Glossary glo = gloRepository.findByNameGlo(nameGlo);
        if (!glo.equals(null)) {
            LOG.info("Reading word  with name  " + glo.getNameGlo() + " from database.");
            return glo;
        }
        LOG.info("The word " + nameGlo + " couldn't be found in the database.");
        return null;

    }

    @ResponseBody
    @GetMapping(path = "/glossary/{inicial_glo}")
    public JSONObject getListGlossary(@PathVariable("inicial_glo") char inicial_glo) {
        List<Glossary> glo = gloRepository.findByInitial(inicial_glo);
        JSONObject res = new JSONObject();
        res.put("data", glo);
        return res;
    }

    @ResponseBody
    @GetMapping(path = "/normativity/{nombre_nor}")
    public Normativity getNormativityByNombre(@PathVariable("nombre_nor") String nombre_nor) {
        Normativity norm = normRepository.findByNameNor(nombre_nor);
        if (!norm.equals(null)) {

            LOG.info("Reading norm with name  " + norm.getNameNor() + " from database.");
            return norm;

        }
        LOG.info("The norm with thw name " + nombre_nor + " couldn't be found in the database.");
        return null;

    }

    @ResponseBody
    @GetMapping(path = "/subcategory/{nombre_sub}")
    public Subcategory getSubategory(@PathVariable("nombre_sub") String nombre_sub) {
        llenar();
        Subcategory subcategory = subRepository.findByNameSubcat(nombre_sub);
        if (!subcategory.equals(null)) {
            return subcategory;
        } else {
            LOG.info("The category with the name " + nombre_sub + " couldn't be found in the database.");
            return null;
        }

    }

    @ResponseBody
    @GetMapping(path = "/cases")
    public List<Case> getAllCases() {
        llenarcasos();
        List<Case> casos = new ArrayList<Case>();
        for (int i = 1; i < 30; i++) {
            try {
                Long j = Long.valueOf(i);
                Case c = caseRepository.findByIdCase(j);
                // Case c = caseRepository.findById(j);
                if (!c.equals(null)) {
                    casos.add(c);
                    String ids = c.getIdsAns();
                    int num;
                    if (ids.equals("0")) {
                        num = 0;
                    } else {
                        String[] parts = ids.split(",");
                        num = parts.length;
                    }
                    c.setIdsAns(Integer.toString(num));
                }

            } catch (NullPointerException exception) {
                LOG.info(exception.toString());
            }
        }
        JSONObject res = new JSONObject();
        res.put("data", casos);
        return casos;
    }

    @ResponseBody
    @GetMapping(path = "/cases/{idCase}")
    public Case getOneCase(@PathVariable("idCase") Long idC) {
        llenarcasos();
        Case caso = caseRepository.findByIdCase(idC);
        String ids = caso.getIdsAns();
        int num;
        if (ids.equals("0")) {
            num = 0;
        } else {
            String[] parts = ids.split(",");
            num = parts.length;
        }
        caso.setIdsAns(Integer.toString(num));
        return caso;
    }

    @ResponseBody
    @RequestMapping(path = "/cases/new/{idUserC}/{nameU}/{topic_cas}/{descrip_case}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCase(@PathVariable("idUserC") String idU, @PathVariable("nameU") String name,
            @PathVariable("topic_cas") String topic, @PathVariable("descrip_case") String descrip) {
        String idSec = idU;
        LocalDate date = LocalDate.now();
        Case savedCase = caseRepository.save(new Case(idSec, name, topic, descrip, date.toString()));
        LOG.info(savedCase.toString() + " successfully saved into DB.");
    }

    @ResponseBody
    @RequestMapping(path = "/answer/new/{idCase}/{idUser}/{nameU}/{descrip_ans}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnswer(@PathVariable("idCase") Long idC, @PathVariable("idUser") String idU,
            @PathVariable("nameU") String name, @PathVariable("descrip_ans") String descrip) {
        Case caso = caseRepository.findByIdCase(idC);
        // String idSec = DigestUtils.sha256Hex(idU);
        LocalDate date = LocalDate.now();
        Answers savedAns = answersRepository.save(new Answers(idU, name, descrip, date));
        String r = Long.toString(savedAns.getIdAns());
        if (caso.getIdsAns().equals("0")) {
            LOG.info("--------------------");
            LOG.info("Vacio");
            caso.setIdsAns(r);
        } else {
            String re = caso.getIdsAns();
            LOG.info("--------------------");
            LOG.info("No vacio");
            LOG.info(re);
            caso.setIdsAns(re + "," + r);
        }
        caseRepository.save(caso);
        LOG.info(savedAns.toString() + " successfully saved into DB.");
    }

    @ResponseBody
    @RequestMapping(path = "/cases/edited/{id}/{topic_cas}/{descrip_case}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void editedCase(@PathVariable("id") String id, @PathVariable("topic_cas") String topic,
            @PathVariable("descrip_case") String descrip) {
        Case ecase = caseRepository.findByIdCase(Long.valueOf(id));
        ecase.setDescripCas(descrip);
        ecase.setTopicCas(topic);
        caseRepository.save(ecase);
        LOG.info(ecase.toString() + " successfully edited into DB.");
    }

    @ResponseBody
    @RequestMapping(path = "/answer/edited/{id}/{descrip_case}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void editedAnswers(@PathVariable("id") String id, @PathVariable("descrip_case") String descrip) {
        Answers eans = answersRepository.findByIdAns(Long.valueOf(id));
        eans.setDescripAns(descrip);
        answersRepository.save(eans);
        LOG.info(eans.toString() + " successfully edited into DB.");
    }

    @ResponseBody
    @RequestMapping(path = "/cases/deleted/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletedCase(@PathVariable("id") String id) {
        caseRepository.deleteById(Long.valueOf(id));
        LOG.info(id + " successfully deleted into DB.");
    }

    @ResponseBody
    @RequestMapping(path = "/answer/deleted/{id}/{idC}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletedAns(@PathVariable("id") String id, @PathVariable("idC") String idC) {
        answersRepository.deleteById(Long.valueOf(id));
        LOG.info(id + " successfully deleted into DB.");
        Case c = caseRepository.findByIdCase(Long.valueOf(idC));
        String ids = c.getIdsAns();
        String newIds = "0";
        String[] parts = ids.split(",");
        for (String part : parts) {
            if (part.equals(id)) {
            } else {
                if (newIds.equals("0")) {
                    newIds = part;
                } else {
                    newIds = newIds + "," + part;
                }
            }
        }
        c.setIdsAns(newIds);
        caseRepository.save(c);

    }

    @ResponseBody
    @GetMapping(path = "/notification/{id_not}")
    public JSONObject getNotifications(@PathVariable("id_not") Long id_not) {
        List<Notification> casos = new ArrayList<Notification>();
        for (int i = 1; i < 30; i++) {
            try {
                Long j = Long.valueOf(i);
                Notification c = notificationRepository.findByIdNots(j);
                String id = c.getIdUser();
                // Case c = caseRepository.findById(j);
                if (c.equals(id)) {
                    casos.add(c);
                }

            } catch (NullPointerException exception) {
                LOG.info(exception.toString());
            }
        }
        JSONObject res = new JSONObject();
        res.put("data", casos);
        return res;
    }

    @ResponseBody
    @RequestMapping(path = "/notification/new/{email}/{descrip}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void newNotification(@PathVariable("email") String email,@PathVariable("descrip") String descrip) {
        User user = userRepository.findByEmailUser(email);
        String id = user.getIdUser();
        Notification not = notificationRepository.save(new Notification(id,descrip));
        LOG.info(not.toString() + " successfully saved into DB.");
    }
}
