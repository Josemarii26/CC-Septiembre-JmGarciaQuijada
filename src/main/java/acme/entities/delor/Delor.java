package acme.entities.delor;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.cookingItem.CookingItem;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Delor extends AbstractEntity {
	
private static final long serialVersionUID = 1L;
	

	//Para los años, meses y dias se utiliza un método en el validate de la creación(create) y la actualización(update)
	@Pattern(regexp = "[0-9]{6}:[0-9]{6}$") 
	@Column(unique=true)
	protected String keylet;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date instantiationMoment;
	
	@NotBlank
	@Length(min = 1, max = 101)
	protected String subject;
	
	@NotBlank
	@Length(min = 1, max = 255)
	protected String explanation;
	
	//La restricción del periodo [startsAt-finishesAt] se hace en el validate la creación(create) y la actualización(update)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date startsAt;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishesAt;
	
	@NotNull
	protected Money income;
	
	@URL
	protected String moreInfo;
	
	@OneToOne(optional = false)
	@Valid
	@NotNull
	protected CookingItem cookingItem;

}
