package com.sr;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class Processor implements ItemProcessor<Ledger, tb>{
	
	@Autowired
	private Repo r;
	@Autowired
	private Lr l;

	@Override
	public tb process(Ledger item) throws Exception {
Optional		<tb> results=r.findByName(item.getRel());
tb re=null;

if(results.isEmpty()) {
	re=new tb();
	re.setName(item.getRel());
	re.setAmount(item.getAmount());
	re.setRel("p&l");
	
}else {
	re=results.get();
	re.setAmount(re.getAmount()+item.getAmount());
}
	
	Optional<Ledger> opt=l.findByName(item.getName());
	
	Ledger led=null;
	if(opt.isEmpty()) {
		led=item;
		
	}
	else {
		led=opt.get();
		led.setAmount(led.getAmount()+item.getAmount());
	
	}
	l.save(led);
		System.out.println();
		
		return re;
	}
	

}
