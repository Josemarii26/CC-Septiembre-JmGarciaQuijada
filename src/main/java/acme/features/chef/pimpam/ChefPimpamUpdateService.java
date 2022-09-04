package acme.features.chef.pimpam;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.pimpam.Pimpam;
import acme.features.administrator.configurations.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Chef;


@Service
public class ChefPimpamUpdateService implements AbstractUpdateService<Chef, Pimpam> {

	@Autowired
	protected ChefPimpamRepository repository;
	
	@Autowired
	protected AdministratorConfigurationRepository confRepository;
	
	@Override
	public boolean authorise(final Request<Pimpam> request) {
		assert request != null;
		
		return true;
	}
	
	@Override
	public void bind(final Request<Pimpam> request, final Pimpam entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "instationMoment","title", "description","startsAt","finishesAt", "budget","link");
		
	}
	
	@Override
	public void unbind(final Request<Pimpam> request, final Pimpam entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "instationMoment","title", "description","startsAt","finishesAt", "budget","link");
		
	}
	
	@Override
	public Pimpam findOne(final Request<Pimpam> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		final Pimpam res =  this.repository.findOnePimpamById(id);
		return res;
	}
	
	@Override
	public void validate(final Request<Pimpam> request, final Pimpam entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final Collection<Configuration> config = this.confRepository.findConfigurations();
		
		for(final Configuration c : config) {

			errors.state(request, !c.isSpam(entity.getDescription()), "description", "detected.isSpam");
			errors.state(request, !c.isSpam(entity.getTitle()), "title", "detected.isSpam");
			errors.state(request, !c.isSpam(entity.getLink()), "link", "detected.isSpam");
			
		
		}
		
		final Pimpam ci = this.repository.findPimpamByCode(entity.getCode());
		
		if(ci != null) {
			errors.state(request, ci.getId() == entity.getId(), "code", "inventor.item.title.codeNotUnique");
		}
		
	}
	
	@Override
	public void update(final Request<Pimpam> request, final Pimpam entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
	}
}