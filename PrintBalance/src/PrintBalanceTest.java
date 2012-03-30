
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;


public class PrintBalanceTest {
	Date testDate;
	String testCurrency;
	
	@Before
	public void setUp() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 1, 17); //month is zero based
		testDate = cal.getTime();
		testCurrency = "384376364.38";
	}
	
	@Test
	public void testEnString(){
		ResourceBundle enMessages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.enLocale);
		assertEquals("Hello World", enMessages.getString("greeting"));
	}
	
	@Test
	public void testEnDate(){
		assertEquals("2/17/91", PrintBalance.formatDate(PrintBalance.enLocale, testDate));
	}
	
	@Test
	public void testEnCurrency(){
		assertEquals("$384,376,364.38", PrintBalance.formatCurrency(PrintBalance.enLocale, testCurrency));
	}
	
	@Test
	public void testFrString(){
		ResourceBundle frMessages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.frLocale);
		assertEquals("Bonjour tout le monde", frMessages.getString("greeting"));
	}
	
	@Test
	public void testFrDate(){
		assertEquals("17/02/91", PrintBalance.formatDate(PrintBalance.frLocale, testDate));
	}
	
	@Test
	public void testFrCurrency(){
		assertEquals("384Ê376Ê364,38 Û", PrintBalance.formatCurrency(PrintBalance.frLocale, testCurrency));
	}
	
	@Test
	public void testGeString(){
		ResourceBundle geMessages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.geLocale);
		assertEquals("Hallo Welt", geMessages.getString("greeting"));
	}
	
	@Test
	public void testGeDate(){
		assertEquals("17.02.91", PrintBalance.formatDate(PrintBalance.geLocale, testDate));
	}
	
	@Test
	public void testGeCurrency(){
		assertEquals("384.376.364,38 Û", PrintBalance.formatCurrency(PrintBalance.geLocale, testCurrency));
	}
	

	@After
	public void tearDown() throws Exception {
	}

}
