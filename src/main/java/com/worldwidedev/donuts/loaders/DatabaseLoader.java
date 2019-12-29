package com.worldwidedev.donuts.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.worldwidedev.donuts.repositories.DonutRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	private final DonutRepository dRepo;
	
	@Autowired
	public DatabaseLoader(DonutRepository repo) {
		this.dRepo = repo;
	}
	
	@Override
	public void run(String...strings) throws Exception {
		System.out.println("running from loader"+ dRepo.findById(1L));
	}
}
