package acme.testing.chef.delor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ChefDelorListTest extends TestHarness  {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/chef/delor/delor.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(0)
	public void checkChefDelorForIngredientListing(final int recordIndex, final String keylet, final String instantiationMoment, final String subject, final String explanation,
		final String startsAt,final String finishesAt, final String income, final String moreInfo) {

		super.signIn("chef1", "chef1");

		super.clickOnMenu("Chef", "List Own Ingredients");

		super.checkListingExists();

		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.clickOnButton("Delors");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, keylet);
		super.checkColumnHasValue(recordIndex, 1, instantiationMoment);
		super.checkColumnHasValue(recordIndex, 2, subject);
		super.checkColumnHasValue(recordIndex, 3, explanation);
		super.checkColumnHasValue(recordIndex, 4, startsAt);
		super.checkColumnHasValue(recordIndex, 5, finishesAt);
		super.checkColumnHasValue(recordIndex, 6, income);
		super.checkColumnHasValue(recordIndex, 7, moreInfo);
	

		super.signOut();
	}
	


}
