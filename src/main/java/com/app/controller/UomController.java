package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;

@Controller
public class UomController {
	
	@Autowired
	private IUomService service;
	
	/**
	 * 1. Show Uom Register JSP
	 * on enter URL 'regUom' in
	 * Browser
	 */
	@GetMapping(value={"/regUom"})  
	public String showRegPage(){
		return "UomRegister";
	}
	
	/**
	 * 2. On submit UomRegister JSP
	 * Form, Insert Data into DB.
	 * 
	 */
	@PostMapping("/insertUom")
	public String saveUom(@ModelAttribute Uom uom,ModelMap map){
		long uomId=service.save(uom);
		map.addAttribute("message", "UOM ("+uomId+") Created ");
		return "UomRegister";
	}
	
	/**
	 * 3. Data Fetch From DB to UI
	 */
	@GetMapping("/getAllUoms")
	public String getUoms(ModelMap map){
		List<Uom> uomList=service.getAll();
		map.addAttribute("uoms", uomList);
		return "UomData";
	}
	@GetMapping("/deleteUom")
	public String deleteUom(long uomId){
		service.deleteById(uomId);
		return "redirect:getAllUoms";
	}
	
	@GetMapping("/editUom")
	public String editUom(@RequestParam("uomId")int uomId,ModelMap map){
		Uom ob=service.getOneById(uomId);
		map.addAttribute("uom", ob);
		map.addAttribute("uomTypes", UomUtil.getUomTypes());
		return "UomDataUpdate";
	}
	@PostMapping("/updateUom")
	public String updateUom(@ModelAttribute Uom uom){
		service.update(uom);
		return "redirect:getAllUoms";
		
	}
	
}
