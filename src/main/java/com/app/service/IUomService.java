package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.model.Uom;

public interface IUomService {
	public long save(Uom uom);
	public void update(Uom uom);
	public void deleteById(long uomId);
	public Uom getOneById(long uomId);
	public List<Uom> getAll();
	public List<Uom> saveMultiple(List<Uom> uomList);
	public Page<Uom> getAll(Pageable pageable);
}
