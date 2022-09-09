package acme.testing.chef.delor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ChefDelorShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/chef/delor/delor.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(0)
	public void checkChefDelorIngredientShow(final int recordIndex, final String keylet, final String instantiationMoment, final String subject, final String explanation,
		final String startsAt,final String finishesAt, final String income, final String moreInfo) {

		super.signIn("chef1", "chef1");

		super.clickOnMenu("Chef", "List Own Ingredients");

		super.checkListingExists();
		
	
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnButton("Delors");
		super.clickOnListingRecord(recordIndex);
		
	
		super.checkInputBoxHasValue("keylet", keylet);
		super.checkInputBoxHasValue("instantiationMoment", instantiationMoment);
		super.checkInputBoxHasValue("subject", subject);
		super.checkInputBoxHasValue("explanation", explanation);
		super.checkInputBoxHasValue("startsAt", startsAt);
		super.checkInputBoxHasValue("finishesAt", finishesAt);
		super.checkInputBoxHasValue("income", income);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		
	
	

		super.signOut();
	}
	

}
