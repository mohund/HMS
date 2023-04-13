/*
 *
 *
 * 
 */
package HMS;

/**
 *
 * @author Admin
 */
public class Amenity extends Service implements Comparable<Service>{
    private String Amenity_type;
     private String Restriction;

    public Amenity(  String ServiceID, String ServiceName,String Amenity_type, String Location, String Restriction, double Price) {
        super(ServiceID, ServiceName, Location, Price);
        this.Amenity_type = Amenity_type;
        this.Restriction = Restriction;
    }

    public String getAmenity_type() {
        return Amenity_type;
    }

    public void setAmenity_type(String Amenity_type) {
        this.Amenity_type = Amenity_type;
    }

    public String getRestriction() {
        return Restriction;
    }

    public void setRestriction(String Restriction) {
        this.Restriction = Restriction;
    }

    @Override
    public String toString() {
        return  "Amenity{"+ super.toString()+", Amenity_type=" + Amenity_type + ", Restriction=" + Restriction + '}';
    }

    @Override
    public int compareTo(Service o) {
       return getServiceName().compareTo(o.getServiceName());
    
    
    
    
    }
    
}
