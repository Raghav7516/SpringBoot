package com.app.provider;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
public class UomRestController {
	
	@Autowired
	private IUomService service;
	
	@PostMapping("/rest/saveUom")
	public String saveUom(@RequestBody Uom uom){
		long uomId=service.save(uom);
		return "Uom saved successfully ,uomId : "+uomId;
	}
	
	@PostMapping("/rest/updateUom")
	public String updateUom(@RequestBody Uom uom){
		service.update(uom);
		return "Uom update successfull";
	}
	
	@GetMapping("/rest/deleteUom/{uomId}")
	public String deleteById(@PathVariable long uomId){
		String message=null;
		try {
			service.deleteById(uomId);
			message="record delete, id :"+uomId;
		} catch (EmptyResultDataAccessException e) {
			message="record not exist";
		}
		return message;
	}
	@GetMapping("/rest/getUom/{uomId}")
	public ResponseEntity<?> getUomById(@PathVariable long uomId){
		Uom uom=service.getOneById(uomId);
		if (uom!=null) {
			return ResponseEntity.ok(uom);
		} else {
			return ResponseEntity.ok("no data found");
		}		
	}
	@GetMapping("/rest/getAllUoms")
	public ResponseEntity<?> getAllUoms(){
		List<Uom> uomliList=service.getAll();
		if (uomliList!=null &uomliList.size()>0) 
		{
			return ResponseEntity.ok(uomliList);
		} else {
			return ResponseEntity.ok("no data found");

		}
		
	}

}
