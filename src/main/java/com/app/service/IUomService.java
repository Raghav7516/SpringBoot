package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {
	public long save(Uom uom);
	public void update(Uom uom);
	public void deleteById(long uomId);
	public Uom getOneById(long uomId);
	public List<Uom> getAll();
}
