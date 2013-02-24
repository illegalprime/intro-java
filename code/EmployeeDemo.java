import java.text.DateFormat;
import java.text.ParseException;

public class EmployeeDemo {

    /**
     * Demonstrates the use of Employee and sublclasses thereof.
     *
     * @throws java.text.ParseException if the date String supplied 
     *         to DateFormat.parse is not properly formatted.
     */
    public static void main(String[] args) throws ParseException {
        DateFormat df = DateFormat.getDateInstance();
        HourlyEmployee eva = new HourlyEmployee("Eva L. Uator",
                                                df.parse("February 18, 2013"),
                                                -20.00, 160);
        System.out.println(eva.getName() + " was hired on " +eva.getHireDate());


        HourlyEmployee alyssa = new HourlyEmployee(eva);
        alyssa.setName("Alyssa P. Hacker");


        System.out.println(alyssa);


        HourlyEmployee don = 
            new HourlyEmployee("Don",
                               df.parse("February 18, 2013"),
                               25.00, 160.00);

    }
}
