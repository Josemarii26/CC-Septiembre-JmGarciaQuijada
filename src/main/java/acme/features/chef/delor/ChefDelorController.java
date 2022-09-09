package acme.features.chef.delor;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.delor.Delor;
import acme.entities.pimpam.Pimpam;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;


@Controller
public class ChefDelorController extends AbstractController<Chef, Delor> {
	
	@Autowired
	protected ChefDelorListService listDelorService;
	
	@Autowired
	protected ChefDelorShowService showDelorService;
//	
//	@Autowired
//	protected ChefPimpamCreateService	createService;
//	
//	@Autowired
//	protected ChefPimpamDeleteService deleteService;
//	
//	@Autowired
//	protected ChefPimpamUpdateService updateService;

	@PostConstruct
	protected void initialize() {
		super.addCommand("list-delor", "list", this.listDelorService);
		super.addCommand("show", this.showDelorService);
//		super.addCommand("create", this.createService);
//		super.addCommand("delete", this.deleteService);
//		super.addCommand("update", this.updateService);


	}

}