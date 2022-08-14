package acme.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.cookingItem.CookingItemType;
import acme.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	/*
	 * 	Old attrs:
	 * 	Integer	totalNumberComponents;
	 *	Integer	totalNumberTools;
	 *	Integer	totalNumberPatronagesProposed;
	 *	Integer	totalNumberPatronagesAccepted;
	 *	Integer	totalNumberPatronagesDenied;
	 *	
	 *	averageRetailPriceComponents
	 *  deviationRetailPriceComponents
	 *  minimunRetailPriceComponents
	 *  maximunRetailPriceComponents
		
		maximunPatronagesBudgetPatronagesProposed
		minimunPatronagesBudgetPatronagesProposed
		deviationPatronagesBudgetProposed
		averagePatronagesBudgetProposed
	 */
	
	Map<String, Integer> totalsData;
	
	Map<Pair<String, String>, Map<String, Double>> ingredientRetailPrice;
	
	Map<CookingItemType, Map<String, Map<String, Double>>> CookingItemsRetailPrice;
	
	Map<Status, Map<String, Double>> FineDishesBudgets;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
	
	
	public List<String> getTotalsDataKeys() {
		return new ArrayList<String>(Arrays.asList("ingredient", "kitchenUtensil", "Proposed", "Accepted", "Denied"));
	}
	
	public List<String> getDataKeys() {
		return new ArrayList<String>(Arrays.asList("Min", "Max", "Avg", "Dev"));
	}

}