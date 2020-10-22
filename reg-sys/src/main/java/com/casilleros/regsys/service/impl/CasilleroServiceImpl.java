package com.casilleros.regsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.casilleros.regsys.commons.GenericServiceImpl;
import com.casilleros.regsys.dao.api.CasilleroDaoAPI;
import com.casilleros.regsys.model.Casillero;
import com.casilleros.regsys.service.api.CasilleroServiceAPI;

@Service
public class CasilleroServiceImpl extends GenericServiceImpl<Casillero, String> implements CasilleroServiceAPI {
	
	@Autowired
	private CasilleroDaoAPI casilleroDaoAPI;
	
	@Override
	public CrudRepository<Casillero, String> getDao() {
		return casilleroDaoAPI;
	}

}