import java.util.Date;

public class MutableHourlyEmployee extends Employee {

    private double hourlyWage;
    private double monthlyHours;

    public MutableHourlyEmployee(MutableHourlyEmployee other) {
        super(other);
        this.hourlyWage = other.hourlyWage;
        this.monthlyHours = other.monthlyHours;
    }

    public MutableHourlyEmployee(String aName, Date aHireDate,
                                 double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double newHourlyWage) {
        hourlyWage = newHourlyWage;
    }

    public double getMonthlyHours() {
        return monthlyHours;
    }

    public void setMonthlyHours(double newMonthlyHours) {
        monthlyHours = newMonthlyHours;
    }

    public double getMonthlyPay() {
        return hourlyWage * monthlyHours;
    }

    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Hourly Wage: "
            + hourlyWage + "; Monthly Hours: " + monthlyHours;
    }

    private void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }
}
