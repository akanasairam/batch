package com.sr;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class Config {

	 @Autowired
	    private EntityManagerFactory entity;
@Bean
public Processor pr() {
	return new Processor();
};

	    @Bean
	    public FlatFileItemReader<Ledger> reader(){
	        return new FlatFileItemReaderBuilder<Ledger>().name("Emp").linesToSkip(1).
	                resource(new FileSystemResource("C:\\Users\\springlogix\\Downloads\\data1.csv")).delimited().delimiter(",")
	                .names("name","amount","rel").targetType(Ledger.class).build();
	    }



	    @Bean
	    public JpaItemWriter<tb> writer(){
	        return new JpaItemWriterBuilder<tb>().entityManagerFactory(entity).build();
	    }
	@Bean
	    public Step step(JobRepository jr, PlatformTransactionManager p){
	        return new StepBuilder("w",jr).<Ledger,tb>chunk(5,p).reader(reader()).allowStartIfComplete(true).processor(pr())
	                .writer(writer()).build();
	    }

	    @Bean
	    public Job job(JobRepository j,PlatformTransactionManager p){
	        return new JobBuilder("j",j).incrementer(new RunIdIncrementer()).start(step(j,p)).build();
	    }

}
