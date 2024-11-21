package com.sr;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Runner implements CommandLineRunner {
	
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("a");

	}

}
