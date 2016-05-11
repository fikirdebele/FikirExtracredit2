package edu.mum.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.domain.Actor;
import edu.mum.cs544.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;
	
	public Long saveActor(Actor actor){
		return actorRepository.save(actor).getId();
	}

	public ActorRepository getActorRepository() {
		return actorRepository;
	}

	public void setActorRepository(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	
	

}
