/*
 * 
 * 
 *
 */
package HMS;

import java.time.LocalDate; // I USED THE LocalDate METHOD TO MAKE EASIER TO DEAL WITH THE DATE 


/**
 *
 * @author Admin
 */
public class SingleMember extends Member{
    private String MembershipType;

    public SingleMember( String ID, String Name, char Gender, LocalDate DateOfBirth, LocalDate DateOfRegestration, String Address, String Phone,String MembershipType) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegestration, Address, Phone);
        this.MembershipType = MembershipType;
    }



    public String getMembershipType() {
        return MembershipType;
    }

    public void setMembershipType(String MembershipType) {
        this.MembershipType = MembershipType;
    }

    @Override
    public String toString() {
        
        return  "SingleMembers info {"+super.toString() + " MembershipType=" + MembershipType + '}';
    }
    
    
    
}
