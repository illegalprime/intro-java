import java.util.Date;

public abstract class Employee {

    private String name;
    private Date hireDate;

    public Employee(Employee other) {
        this.name = other.name;
        this.hireDate = other.hireDate;
    }

    public Employee(String aName, Date aHireDate) {
        disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }

    public abstract double monthlyPay();

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String toString() {
        return name + "; " + hireDate;
    }

    public boolean equals(Employee other) {
        return name.equals(other.name) && hireDate.equals(other.hireDate);
    }

    private void disallowNullArguments(Object ... args) {
        boolean shouldThrowException = false;
        String nullArgs = "";
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
                nullArgs += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }

    protected void disallowZeroesAndNegatives(double ... args) {
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
