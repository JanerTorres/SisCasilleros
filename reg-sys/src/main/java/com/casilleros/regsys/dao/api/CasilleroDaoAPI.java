package com.casilleros.regsys.dao.api;

import org.springframework.data.repository.CrudRepository;
import com.casilleros.regsys.model.Casillero;

public interface CasilleroDaoAPI extends CrudRepository<Casillero, String> {
	
}