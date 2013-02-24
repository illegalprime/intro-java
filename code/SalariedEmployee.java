import java.util.Date;

public final class SalariedEmployee extends Employee {

    private static final int MONTHS_PER_YEAR = 12;

    private final double annualSalary;

    public SalariedEmployee(SalariedEmployee other) {
        super(other);
        this.annualSalary = other.annualSalary;
    }

    public SalariedEmployee(String aName, Date aHireDate,
                            double anAnnualSalary) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anAnnualSalary);
        annualSalary = anAnnualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double monthlyPay() {
        return annualSalary / MONTHS_PER_YEAR;
    }

    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Annual Salary: "
            + annualSalary;
    }
}
