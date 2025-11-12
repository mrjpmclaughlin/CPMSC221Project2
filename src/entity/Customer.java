package entity;
/**
 *
 * @author Gokhan
 */
public class Customer
{
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(int ID, String firstName, String lastName, String email, String phone)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {return email;}
    public String getPhone() {return phone;}

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +  ", phone=" + phone + '}';
    }
}
