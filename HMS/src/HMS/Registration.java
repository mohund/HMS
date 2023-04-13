/*
 * 
 *
 * 
 */
package HMS;

import java.time.LocalDate;// I USED THE LocalDate METHOD TO MAKE EASIER TO DEAL WITH THE DATE 
import java.time.Period;//I used the period method to facilitate the calculation of the registration period
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Registration {

    private String RegistrationID;
    private Member member;
    private ArrayList<Service> service;
    private double LoyalityDiscount;
    private double MemberDiscount;
    private double finaltotalPrice;

    public Registration(String RegistrationID, Member member, ArrayList<Service> service) {
        this.RegistrationID = RegistrationID;
        this.member = member;
        this.service = service;

    }

    @Override
    public String toString() {
        return "Registration{" + "RegistrationID =" + RegistrationID + ", member= " + member + ", service =" + service + ", LoyalityDiscount =" + LoyalityDiscount + ", MemberDiscount=" + MemberDiscount + ", finaltotalPrice=" + finaltotalPrice + '}';
    }

    public String getRegistrationID() {
        return RegistrationID;
    }

    public void setRegistrationID(String RegistrationID) {
        this.RegistrationID = RegistrationID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void setService(ArrayList<Service> service) {
        this.service = service;
    }

    public double getoriginalPrice() {
        double price = 0.0;
        for (int i = 0; i < service.size(); i++) {
            price += service.get(i).getPrice();

        }

        return price;
    }

    public double LoyalityDiscount() {
        double LoyalityDiscount = 0.0;
        if (Period.between(member.getDateOfRegestration(), LocalDate.now()).getYears() >= 10) { // IF THE USER GREATER THAN 10 OR EQUAL WILL GIVE HIM 10% Discount
            LoyalityDiscount = 0.1;

        }
        return LoyalityDiscount;

    }

    public double getDiscount() {
        double GetDiscount = 0.0;
        if (member instanceof SingleMember) {
            if (((SingleMember) member).getMembershipType().equalsIgnoreCase("VIP")) {

                GetDiscount += 0.5;

            }

        } else if (member instanceof FamilyMember) {
            if (((FamilyMember) member).getFamily_member_names().size() >= 3) {
                GetDiscount += 0.05;

            }

        }

        return GetDiscount + LoyalityDiscount();
    }

    public double getFinalPrice(Service s) {
        double GetFinalPrice = 0.0;
        GetFinalPrice = s.getPrice() - (s.getPrice() * getDiscount());
        return GetFinalPrice;
    }

    public double gettotalFinalPrice() {
        double GettotalFinalPrice = getoriginalPrice() - (getoriginalPrice() * getDiscount());

        return GettotalFinalPrice;
    }

    public int getNumberOfDiscount() {
        if (getDiscount() > 0) {
            return service.size();
        } else {
            return 0;
        }

    }

    public double getSavingAmount() {
        return getoriginalPrice() - gettotalFinalPrice();
    }

}
