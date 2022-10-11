package com.alexschaffer.mvcdojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexschaffer.mvcdojoninjas.models.Dojo;
import com.alexschaffer.mvcdojoninjas.models.Ninja;
import com.alexschaffer.mvcdojoninjas.repositories.DojoRepository;
import com.alexschaffer.mvcdojoninjas.repositories.NinjaRepository;

@Service
public class MainService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	@Autowired
	private DojoRepository dojoRepo;
	
	//ALL NINJA SERVICES
	// FIND ALL NINJAS
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//CREATE NINJA
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	//ALL DOJO SERVICES
	//CREATE DOJO
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//FIND ALL DOJOS
	public List <Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	//DISPLAY NINJAS BELONGING TO ONE DOJO
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	
}





