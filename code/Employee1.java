import java.util.Date;

public class Employee {

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
}
