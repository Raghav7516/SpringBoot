package com.app.controller.multipart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.UomExcelView;
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;

@Controller
public class UomMultipartController {
	@Autowired
	private IUomService service;
	
	@GetMapping("/uomMultipart")
	public String showUomMultipartFile(){
		return "UomMultipart";
	}
	
	@GetMapping("/uomExport")
	public ModelAndView exportUom(){
		List<Uom> uoms=service.getAll();
		return new ModelAndView(new UomExcelView(),"uomList",uoms);
	}
	@PostMapping("/uomImport")
	public String importUom(@RequestParam("efile")MultipartFile file,ModelMap map){
		List<Uom> uomList=UomUtil.processUomImport(file);
		if (uomList!=null && uomList.size()>0) 
		{
			service.saveMultiple(uomList);
			map.addAttribute("ImportMessage", "data import successfully");
		}
		return "UomMultipart";
		
	}
}
