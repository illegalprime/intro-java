public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.equals("")) {
            System.out.println("firstName can't be null or empty");
            System.exit(0);
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.equals("")) {
            System.out.println("lastName can't be null or empty");
            System.exit(0);
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
