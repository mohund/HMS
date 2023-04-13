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
public class Class extends Service implements Comparable<Service> {

    private int capacity;
    private String Instructor;
    
    public Class(String ServiceID, String ServiceName, String Location, double Price, int capacity, String Instructor) {
        super(ServiceID, ServiceName, Location, Price);
        this.capacity = capacity;
        this.Instructor = Instructor;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public String getInstructor() {
        return Instructor;
    }
    
    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }
    
    @Override
    public String toString() {
        return  "Class{"+ super.toString() + ", capacity= " + capacity + ", Instructor= " + Instructor + '}';
    }
    
    @Override
    public int compareTo(Service o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() < o.getPrice()) {
            return -1;
        }

        return 0;
    }
    
}
