package com.alexschaffer.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexschaffer.dojosandninjas.models.Dojo;
import com.alexschaffer.dojosandninjas.models.Ninja;
import com.alexschaffer.dojosandninjas.repositories.DojoRepository;
import com.alexschaffer.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {

	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// find all Ninjas
	public List<Ninja> allDonations() {
		return ninjaRepo.findAll();
	}
	
	//Create Ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	//Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
