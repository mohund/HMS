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
public abstract class Service {
    private String ServiceID;
    private String ServiceName;
    private String Location;
    private double Price;
    

    public Service(String ServiceID, String ServiceName, String Location, double Price) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.Location = Location;
        this.Price = Price;
    }

    public String getServiceID() {
        return ServiceID;
    }

    public void setServiceID(String ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "ServiceID =" + ServiceID + ", ServiceName =" + ServiceName + ", Location =" + Location + ", Price =" + Price ;
    }
    
    
}
