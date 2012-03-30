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

	
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		Locale enLocale = new Locale("en","US");
		Locale geLocale = new Locale("de","DE");
		Locale frLocale = new Locale("fr","FR");
		
		//in English
		printBaseOnLocale(enLocale);
		
		//in German
		//printBaseOnLocale(geLocale);
		
		//in French
		//printBaseOnLocale(frLocale);

	}
	
	public static void printBaseOnLocale(Locale locale){
		
		//getBundle accordingly
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
		
		//print Greeting
		printGreeting(messages);
		
		//print User's Name
		printName(messages);
		
		//print today's date
		printDate(messages, locale);
		
		//print currency
		printCurrency(messages, locale);
		
		//print bye
		printBye(messages);
	}
	
	public static void printGreeting(ResourceBundle messages){
		System.out.println(messages.getString("greeting"));
	}
	
	public static void printName(ResourceBundle messages){
		Scanner scanInput = new Scanner(System.in);
		System.out.println(messages.getString("enterName"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("meetYou") + name);
	}
	
	public static void printDate(ResourceBundle messages, Locale locale){
		DateFormat dFormater = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		System.out.println(messages.getString("date") + dFormater.format(new Date()));
	}
	
	public static void printCurrency(ResourceBundle messages, Locale locale){
		NumberFormat mFormatter = NumberFormat.getCurrencyInstance(locale);
		System.out.println(messages.getString("oweSchool") + mFormatter.format(Double.parseDouble(messages.getString("money"))));
	}
	
	public static void printBye(ResourceBundle messages){
		System.out.println(messages.getString("goodBye"));
	}
}



