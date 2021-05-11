package com.prolaw.controller;



import com.prolaw.domain.*;
import com.prolaw.repository.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/api")
public class TableController {
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	   

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

    public void llenar(){
        boolean terminado = false;
		LOG.info("HOLA");
        do {	
            for(int i = 1; i < 3; i ++){
                long j = i;
				LOG.info("Area: "+Integer.toString(i));
                Category category = catRepository.findByIdCate(j);
                if(!category.equals(null)) {
                    String ids = category.getIdsSubCate();
                    String[] parts = ids.split(",");
                    for (String part: parts){
                        Subcategory sub = subRepository.findByIdSubcat(Long.valueOf(part));
						List<Subcategory> c = category.getSubcategories();
						c.add(sub);
                        category.setSubcategories(c);                            
                    }  
                }else{
                    i=99;
                }

            }
            for(int i = 1; i < 3; i ++){
                long j = i;
				LOG.info("Subrea: "+Integer.toString(i));
                Subcategory subcategory = subRepository.findByIdSubcat(j);
                if(!subcategory.equals(null)) {
                    String ids = subcategory.getIdsProcedu();
                    String[] parts = ids.split(",");
                    for (String part: parts){
                        Procedure pro = proRepository.findByIdPro(Long.valueOf(part));
                        List<Procedure> c = subcategory.getProcedures();
						c.add(pro);
                        subcategory.setProcedures(c);                            
                    }  
                }else{
                    i=99;
                }

            }
            for(int i = 1; i < 3; i ++){
                long j = i;
				LOG.info("Procedimiento: "+Integer.toString(i));
                Procedure procedure = proRepository.findByIdPro(j);
                if(!procedure.equals(null)) {
                    String ids = procedure.getIdsNorma();
                    String[] parts = ids.split(",");
                    for (String part: parts){
						LOG.info(part);
                        Normativity nor = normRepository.findByIdNor(Long.valueOf(part));
                        List<Normativity> c = procedure.getNormativity();
						c.add(nor);
                        procedure.setNormativity(c);                           
                    }  
                }else{
                    i=99;
                }

            }
         
        }while(terminado == true);
    }
    @ResponseBody
	@GetMapping(path = "/category/{nameCat}")
	public Category getCategory(@PathVariable("nameCat") String idC){
        llenar();
		Category category = catRepository.findByNameCate(idC);
        if(!category.equals(null)) {
            return category; 
        }else{
        LOG.info("The category with the name "+idC+ " couldn't be found in the database.");
        return null;
        }
        
	}
    @ResponseBody
	@GetMapping(path = "/procedure/{namePro}")
	public Procedure getProcedure(@PathVariable("namePro") String idC){
        llenar();
		Procedure category = proRepository.findByNamePro(idC);
        if(!category.equals(null)) {
            return category; 
        }else{
        LOG.info("The procedure with the name "+idC+ " couldn't be found in the database.");
        return null;
        }
        
	}
    
}
