import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * TODO A simple class that needs to be localized
 *
 * @author mohan.
 *         Created Mar 27, 2011.
 */
public class PrintBalance{
	public static Locale enLocale = new Locale("en","US");
	public static Locale geLocale = new Locale("de","DE");
	public static Locale frLocale = new Locale("fr","FR");
	
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	
	public static void main(String args[])
	{
		//in English
		//printBaseOnLocale(enLocale);
		
		//in German
		printBaseOnLocale(geLocale);
		
		//in French
		//printBaseOnLocale(frLocale);

	}
	
	public static void printBaseOnLocale(Locale locale){
		
		//getBundle accordingly
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
		
		//print Greeting
		System.out.println(messages.getString("greeting"));
		
		//print User's Name
		Scanner scanInput = new Scanner(System.in);
		System.out.println(messages.getString("enterName"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("meetYou") + name);
		
		//print today's date
		System.out.println(messages.getString("date") + formatDate(locale,new Date()));
		
		//print currency
		System.out.println(messages.getString("oweSchool") + formatCurrency(locale, messages.getString("money")));
		
		//print bye
		System.out.println(messages.getString("goodBye"));
	}
	
	public static String formatDate(Locale locale, Date date){
		DateFormat dFormater = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		return dFormater.format(date);
	}
	
	public static String formatCurrency(Locale locale, String currency){
		NumberFormat mFormatter = NumberFormat.getCurrencyInstance(locale);
		return mFormatter.format(Double.parseDouble(currency));
	}
}



