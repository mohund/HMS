/*
 * 
 * 
 * 
 */
package HMS;

import java.time.LocalDate;


/**
 *
 * @author Admin
 */
public abstract class Member {

    private String ID;
    private String Name;
    private char Gender;
    private LocalDate DateOfBirth;
    private LocalDate DateOfRegestration;
    private String Address;
    private String Phone;

    public Member(String ID, String Name, char Gender, LocalDate DateOfBirth, LocalDate DateOfRegestration, String Address, String Phone) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.DateOfRegestration = DateOfRegestration;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public LocalDate getDateOfRegestration() {
        return DateOfRegestration;
    }

    public void setDateOfRegestration(LocalDate DateOfRegestration) {
        this.DateOfRegestration = DateOfRegestration;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return  "ID=" + ID + ", Name=" + Name + ", Gender=" + Gender + ", DateOfBirth=" + DateToSting(DateOfBirth) + ", DateOfRegestration=" + DateToSting(DateOfRegestration) + ", Address=" + Address + ", Phone=" + Phone +", " ;
    }

    private static String DateToSting(LocalDate date) {
        return  date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
    }
;

}
