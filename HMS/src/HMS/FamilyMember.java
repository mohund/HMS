/*
 * 
 * 
 * 
 */
package HMS;

import java.time.LocalDate; // I USED THE LocalDate METHOD TO MAKE EASIER TO DEAL WITH THE DATE 
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class FamilyMember extends Member{
    ArrayList<String> Family_member_names;

    public FamilyMember( String ID, String Name, char Gender, LocalDate DateOfBirth, LocalDate DateOfRegestration, String Address, String Phone, ArrayList<String> Family_member_names) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone);
        this.Family_member_names = Family_member_names;
    }

 


  

    public ArrayList<String> getFamily_member_names() {
        return Family_member_names;
    }

    public void setFamily_member_names(ArrayList<String> Family_member_names) {
        this.Family_member_names = Family_member_names;
    }

    @Override
    public String toString() {
        return  "FamilyMembers{"+ super.toString() + "Family_members_names=" + Family_member_names + '}';
    }
    
}
