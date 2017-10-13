package com.app.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Uom;
import com.app.repo.UomRepository;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	
	@Autowired
	private UomRepository repo;

	@Override
	public long save(Uom uom) {
		uom.setCreateDate(new Date());
		repo.save(uom);
		return uom.getUomId();
	}

	@Override
	public void update(Uom uom) {
		uom.setCreateDate(repo.getOne(uom.getUomId()).getCreateDate());
		uom.setLastModified(new Date());
		repo.save(uom);
	}

	@Override
	public void deleteById(long uomId) {
		repo.delete(uomId);
	}

	@Override
	public Uom getOneById(long uomId) {
		Uom uomOb=repo.getOne(uomId);
		return uomOb;
	}

	@Override
	public List<Uom> getAll() {
		List<Uom> uomOb=repo.findAll();
		Collections.sort(uomOb);
		return uomOb;
	}

	@Override
	public List<Uom> saveMultiple(List<Uom> uomList) {
		return repo.save(uomList);
	}

}
