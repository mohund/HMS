/*
 * 
 * 
 *  
 */
package HMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;

public class HMS {

    public static void main(String[] args) throws FileNotFoundException {

        File fileinput = new File("input.txt");//GIVING JAVA THE PATH OF THE FILE THAT HOLD PRINT SERVICES, CUSTOMER FROM INPUT input.TEXT.
        Scanner inputFile = new Scanner(fileinput);// CREATE SCANNER TO READ THE FILE 
        if (!fileinput.exists()) {
            System.out.println("File Not Found!");
            System.exit(0);
        }

        String inputPrintChecks = "null"; //hold the statement and check if it's true it will enter
        // CREATE ID COUNTERS FOR EACH Element
        int SingleMemberID = 1001;
        int FamilyMemberID = 2001;
        int ClassID = 5001;
        int AmenityID = 6001;
        // CREATE  AN ARRAYS TO DEAL WITH THE INFORMATIONES
        ArrayList<SingleMember> SingleMember = new ArrayList<>();
        ArrayList<FamilyMember> FamilyMember = new ArrayList<>();
        ArrayList<Class> Class = new ArrayList<>();
        ArrayList<Amenity> Amenity = new ArrayList<>();
        ArrayList<Registration> Registration = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int numberOfInvoice = 0; // COUNTER FOR NUMBER OF Invoice FOR EACH USER 
        File Writerss = new File("output.txt"); // CREATE OUT PUT FILE 
        PrintWriter Writer = new PrintWriter(Writerss); // CREATE PrintWriter TO WRITE  THE OUTPUT IN THE FILE 
        Writer.println("--------------- welcome to Gym Mangment System ---------------");
        while (!"Quit".equals(inputPrintChecks)) { // LOOP FOR THE COMMANDS 

            inputPrintChecks = inputFile.next();  //hold the statement and check if it's true it will enter

            if (inputPrintChecks.equalsIgnoreCase("Add_Single_Member")) { // Checks IF THE INPUT == Add_Single_Member IF IT'S EQUAL WILL ENTER THE IS STATEMENT

                SingleMember.add(getSingleMember(inputFile, SingleMemberID)); // CREATE Single Member OBJECT AND ADD IT INTO Single Member ARRAY TO USE AFTER FINSH ALL COMMANDS
                SingleMemberID++;// CREATE AN UNIQUE DIGIT NUMBER 
                Writer.println(SingleMember.get(SingleMember.size() - 1).toString()); // AFTER THE CREATEION WILL PRINT THE OBJECT
                Writer.println("----------------------------------------------------------------");
            }

            if (inputPrintChecks.equalsIgnoreCase("Add_Family_Member")) { // Checks IF THE INPUT == Add_Family_Member IF IT'S EQUAL WILL ENTER THE IS STATEMENT

                FamilyMember.add(getFamilyMember(inputFile, FamilyMemberID));// CREATE Family Member OBJECT AND ADD IT INTO Family Member ARRAY TO USE AFTER FINSH ALL COMMANDS
                FamilyMemberID++;// CREATE AN UNIQUE DIGIT NUMBER 
                Writer.println("Command Add_Family_Member was successfully completed"); // AFTER WE ADD  successfully WILL PRINT THIS COMMAND
                Writer.println(FamilyMember.get(FamilyMember.size() - 1).toString());// AFTER THE CREATEION AND ADD IT TO THE ARRAY WILL PRINT THE OBJECT
                Writer.println("----------------------------------------------------------------");
            }

            if (inputPrintChecks.equalsIgnoreCase("Add_Class")) {// Checks IF THE INPUT == Add_Class IF IT'S EQUAL WILL ENTER THE IS STATEMENT
                Class.add(getClass(inputFile, ClassID)); //CREATE Add Class OBJECT AND ADD IT INTO Add Class ARRAY TO USE AFTER FINSH ALL COMMANDS
                ClassID++;// CREATE AN UNIQUE DIGIT NUMBER 
                Writer.println("Command Add_Class was successfully completed");// AFTER WE ADD  successfully WILL PRINT THIS COMMAND
                Writer.println(Class.get(Class.size() - 1).toString());// AFTER THE CREATEION AND ADD IT TO THE ARRAY WILL PRINT THE OBJECT
                Writer.println("----------------------------------------------------------------");
            }
            if (inputPrintChecks.equalsIgnoreCase("Add_Amenity")) {// Checks IF THE INPUT == Add_Amenity IF IT'S EQUAL WILL ENTER THE IS STATEMENT
                Amenity.add(getAmenity(inputFile, AmenityID)); //CREATE Add Amenity OBJECT AND ADD IT INTO Add Amenity ARRAY TO USE AFTER FINSH ALL COMMANDS
                AmenityID++;// CREATE AN UNIQUE DIGIT NUMBER 
                Writer.println("Command Add_Amenity was successfully completed");// AFTER WE ADD  successfully WILL PRINT THIS COMMAND
                Writer.println(Amenity.get(Amenity.size() - 1).toString());// AFTER THE CREATEION AND ADD IT TO THE ARRAY WILL PRINT THE OBJECT
                Writer.println("----------------------------------------------------------------");

            }

            if (inputPrintChecks.equalsIgnoreCase("Register")) {  // Checks IF THE INPUT == Register IF IT'S EQUAL WILL ENTER THE IS STATEMENT

                ArrayList<Service> Service = new ArrayList<>(); // CREATE AN ARRAY FOR THE Service FOR EACH USER 

                String MemberID = inputFile.next(); // SAVE THE USER ID 

                String ServiceName = "null";
                String temp = "null";
                char gender = 'n';
                double Price = 0.0;
                String Location = "null";
                String ServiceID = "null";
                boolean CheckTheUser = true;
                boolean CHECKER = false;
                int age = 0;

                do { // START OF THE LOOP
                    temp = inputFile.next(); // HOLD IN & AND 
                    if (MemberID.charAt(0) == '1') { // IF THE FIRST NUMBER WAS 1 IT WILL ENTER 
                        for (int i = 0; i < SingleMember.size(); i++) {
                            if (MemberID.equalsIgnoreCase(SingleMember.get(i).getID())) { // CHECK IF THE USER EXIST
                                CheckTheUser = false; // IF THE USER EXIST  
                                break;
                            }

                        }
                        if (CheckTheUser) { // check IF THE USER NOT EXIST
                            Service.add(new Service(ServiceID, ServiceName, Location, Price) {
                            });
                            Registration.add(new Registration("nulll", SingleMember.get(0), Service)); // ADD IT TO THE Registration ARRAY &  ID NULLL IT'S MAKE MORE IS TO DEAL WITH THIS PROBLEM USER DOSE NOT EXIST
                            PrintReceipt(Registration.get(Registration.size() - 1), Writer); // PASS IT TO PrintReceipt METHOD
                            break;// SKIP NEXT CONDITIONS

                        }

                        for (int i = 0; i < SingleMember.size(); i++) { // IF THE USER IS EXIST I WILL COME HERE TO RECORD THE AGE & GENDER
                            if (MemberID.equalsIgnoreCase(SingleMember.get(i).getID())) {
                                age = Period.between(SingleMember.get(i).getDateOfBirth(), today).getYears();
                                gender = SingleMember.get(i).getGender();
                                break;
                            }

                        }

                        if (temp.equalsIgnoreCase("In") || temp.equalsIgnoreCase("and")) {
                            ServiceName = inputFile.next();// RECORD THE NAME OF SERVICE
                            for (int j = 0; j < SingleMember.size(); j++) { // WILL ENTER HERE TO CHECK ALL USERS 
                                for (int ClassCheckSingle = 0; ClassCheckSingle < Class.size(); ClassCheckSingle++) {

                                    if (Class.get(ClassCheckSingle).getServiceName().equalsIgnoreCase(ServiceName)) {//CHECK IF IT'S HAVE THE SIRVISE EXIST

                                        for (int i = 0; i < Class.size(); i++) {// WILL ENTER HERE 
                                            if (Class.get(i).getServiceName().equalsIgnoreCase(ServiceName)) { //GET THE NUMBER OF THE SIRVISE
                                                if (Character.toUpperCase(Class.get(i).getLocation().charAt(0)) == gender) { // CHECK THE gender IS EXIST 

                                                    Location = Class.get(i).getLocation(); // GET Location
                                                    Price = Class.get(i).getPrice();//GET PRICE
                                                    ServiceID = Class.get(i).getServiceID(); // GET THE ID FOR THE  Service
                                                    CHECKER = true; // IT WILL BECOME TRUE AND IT WILL break THE FIRST LOOP 
                                                    break;

                                                }

                                            }
                                        }
                                        if (CHECKER) { // IF IT'S TRUE IT WILL break THE SECOND LOOP AND GO TO CREATE THE OBJECT
                                            break;

                                        }
                                    }
                                }
                                for (int AmenityCheckSingle = 0; AmenityCheckSingle < 10; AmenityCheckSingle++) {

                                    if (Amenity.get(AmenityCheckSingle).getServiceName().equalsIgnoreCase(ServiceName)) {//CHECK IF IT'S HAVE THE Amenity EXIST
                                        for (int i = 0; i < Amenity.size(); i++) {// WILL ENTER HERE 
                                            if (Amenity.get(i).getServiceName().equalsIgnoreCase(ServiceName)) {//GET THE NUMBER OF THE Amenity
                                                if (Character.toUpperCase(Amenity.get(i).getLocation().charAt(0)) == gender) {// CHECK THE gender IS EXIST  
                                                    if (Amenity.get(i).getRestriction().charAt(0) == 'a') {// CHECK FOR ANY Conditions FOR AGE
                                                        if (age < 18) { // IF IT'S SMALLER THAN 18 YEARS
                                                            Location = "underage"; // GIVE THE Location value underage TO BE EASYER TO DEAL WITH IN  PrintReceipt METHOD
                                                            Price = 0.0;
                                                            ServiceID = "null";
                                                            break;

                                                        } else if (age > 18) { //IF IT'S BIGGER THAN 18 YEARS

                                                            Location = Amenity.get(i).getLocation(); // GET Location
                                                            Price = Amenity.get(i).getPrice();//GET PRICE
                                                            ServiceID = Amenity.get(i).getServiceID();// GET THE ID FOR THE  Service
                                                            CHECKER = true;// IT WILL BECOME TRUE AND IT WILL break THE FIRST LOOP 
                                                            break;

                                                        }
                                                    } else if (Amenity.get(i).getRestriction().charAt(0) == 'h') {

                                                        Location = "Family"; // GIVE THE Location value Family TO BE EASYER TO DEAL WITH IN  PrintReceipt METHOD
                                                        Price = Class.get(i).getPrice();
                                                        ServiceID = Class.get(i).getServiceID();
                                                        CHECKER = true;// IT WILL BECOME TRUE AND IT WILL break THE FIRST LOOP 
                                                        break;

                                                    }

                                                }

                                            }
                                        }
                                        if (CHECKER) { // IF IT'S TRUE IT WILL break THE SECOND LOOP AND GO TO CREATE THE OBJECT
                                            break;

                                        }

                                    }
                                }
                            }

                            Service.add(new Service(ServiceID, ServiceName, Location, Price) { // IT WILL CREATE Service OBJ  AND ALSO ADD TO Service ARRAY
                            });
                            ServiceName = "null"; //RESATE TO THE SERVICE NAME
                            Location = "NoTClosE";
                            Price = 0.0;
                        }
                    }
                    if (MemberID.charAt(0) == '2') {  // IF THE FIRST NUMBER WAS 2 IT WILL ENTER
                        for (int i = 0; i < FamilyMember.size(); i++) {
                            if (MemberID.equalsIgnoreCase(FamilyMember.get(i).getID())) { // CHECK IF THE USER EXIST
                                CheckTheUser = false;// IF THE USER EXIST  
                                break;
                            }

                        }
                        if (CheckTheUser) { // check IF THE USER NOT EXIST
                            Service.add(new Service(ServiceID, ServiceName, Location, Price) {
                            });
                            Registration.add(new Registration("nulll", SingleMember.get(0), Service));// ADD IT TO THE Registration ARRAY &  ID NULLL IT'S MAKE MORE IS TO DEAL WITH THIS PROBLEM USER DOSE NOT EXIST
                            PrintReceipt(Registration.get(Registration.size() - 1), Writer); // PASS IT TO PrintReceipt METHOD 
                            break;

                        }

                        for (int i = 0; i < FamilyMember.size(); i++) { // IF THE USER IS EXIST I WILL COME HERE TO RECORD THE AGE & GENDER
                            if (MemberID.equalsIgnoreCase(FamilyMember.get(i).getID())) {
                                age = Period.between(FamilyMember.get(i).getDateOfBirth(), today).getYears();
                                gender = SingleMember.get(i).getGender();
                                break;
                            }

                        }

                        if (temp.equalsIgnoreCase("In") || temp.equalsIgnoreCase("and")) {
                            ServiceName = inputFile.next();// RECORD THE NAME OF SERVICE
                            for (int j = 0; j < FamilyMember.size(); j++) { // WILL ENTER HERE TO CHECK ALL USERS
                                {
                                    for (int ClassCheckFamily = 0; ClassCheckFamily < Class.size(); ClassCheckFamily++) {// WILL ENTER HERE 

                                        if (Class.get(ClassCheckFamily).getServiceName().equalsIgnoreCase(ServiceName)) {//CHECK IF IT'S HAVE THE SIRVISE EXIST
                                            for (int i = 0; i < Class.size(); i++) {// WILL ENTER HERE 
                                                if (Class.get(i).getServiceName().equalsIgnoreCase(ServiceName)) {//GET THE NUMBER OF THE SIRVISE
                                                    if (Character.toUpperCase(Class.get(i).getLocation().charAt(0)) == gender) { // CHECK THE gender IS EXIST 

                                                        Location = Class.get(i).getLocation();// GET Location
                                                        Price = Class.get(i).getPrice();//GET PRICE
                                                        ServiceID = Class.get(i).getServiceID(); // GET THE ID FOR THE  Service
                                                        CHECKER = true; // IT WILL BECOME TRUE AND IT WILL break THE FIRST LOOP 
                                                        break;

                                                    }

                                                }
                                            }
                                            if (CHECKER) {// IF IT'S TRUE IT WILL break THE SECOND LOOP AND GO TO CREATE THE OBJECT
                                                break;

                                            }
                                        }
                                    }
                                    for (int AmenityCheckFamily = 0; AmenityCheckFamily < Amenity.size(); AmenityCheckFamily++) {

                                        if (Amenity.get(AmenityCheckFamily).getServiceName().equalsIgnoreCase(ServiceName)) {//CHECK IF IT'S HAVE THE Amenity EXIST
                                            for (int i = 0; i < Amenity.size(); i++) {// WILL ENTER HERE 
                                                if (Amenity.get(i).getServiceName().equalsIgnoreCase(ServiceName)) {//GET THE NUMBER OF THE Amenity
                                                    if (Character.toUpperCase(Amenity.get(i).getLocation().charAt(0)) == gender) {// CHECK THE gender IS EXIST  
                                                        if (Amenity.get(i).getRestriction().charAt(0) == 'a') {// CHECK FOR ANY Conditions FOR AGE
                                                            if (age < 18) {// IF IT'S SMALLER THAN 18 YEARS
                                                                Location = "underage"; // GIVE THE Location value underage TO BE EASYER TO DEAL WITH IN  PrintReceipt METHOD
                                                                Price = 0.0;
                                                                ServiceID = "null";
                                                                CHECKER = true;
                                                                break;

                                                            } else if (age > 18) {//IF IT'S BIGGER THAN 18 YEARS

                                                                Location = Amenity.get(i).getLocation();// GET Location
                                                                Price = Amenity.get(i).getPrice();//GET PRICE
                                                                ServiceID = Amenity.get(i).getServiceID();// GET THE ID FOR THE  Service
                                                                break;

                                                            }
                                                        } else if (Amenity.get(i).getRestriction().charAt(0) == 'h') {
                                                            Location = Amenity.get(i).getLocation();// GIVE THE Location 
                                                            Price = Amenity.get(i).getPrice(); //GET PRICE
                                                            ServiceID = Amenity.get(i).getServiceID();// GET THE ID FOR THE  Service
                                                            CHECKER = true;// IT WILL BECOME TRUE AND IT WILL break THE FIRST LOOP 
                                                            break;

                                                        }

                                                    }
                                                    if (CHECKER) {// IF IT'S TRUE IT WILL break THE SECOND LOOP AND GO TO CREATE THE OBJECT
                                                        break;

                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            Service.add(new Service(ServiceID, ServiceName, Location, Price) {// IT WILL CREATE Service OBJ  AND ALSO ADD TO Service ARRAY
                            });
                            ServiceName = "null"; //RESATE TO THE SERVICE NAME
                            Location = "NoTClosE";
                            Price = 0.0;
                        }
                    }

                    if (temp.equalsIgnoreCase("submit")) { // IF   temp IS  submit IT WILL ENTER 

                        if (MemberID.charAt(0) == '1') { // HERE IF  ENTER WILL PRITN THE INVOICE 
                            for (int i = 0; i < SingleMember.size(); i++) {

                                if (SingleMember.get(i).getID().equalsIgnoreCase(MemberID)) {
                                    for (int j = 0; j < SingleMember.size(); j++) {
                                        if (MemberID.equalsIgnoreCase(SingleMember.get(j).getID())) {

                                            numberOfInvoice++;
                                        }

                                    }

                                    Registration.add(new Registration(MemberID + String.format("%03d", numberOfInvoice), SingleMember.get(i), Service));
                                    numberOfInvoice = 0;
                                }
                            }
                        }
                        if (MemberID.charAt(0) == '2') { // HERE IF  ENTER WILL PRITN THE INVOICE 
                            for (int i = 0; i < FamilyMember.size(); i++) {

                                if (MemberID.equalsIgnoreCase(FamilyMember.get(i).getID())) {
                                    for (int j = 0; j < FamilyMember.size(); j++) {
                                        if (MemberID.equalsIgnoreCase(FamilyMember.get(j).getID())) {
                                            numberOfInvoice++;
                                        }

                                    }

                                    Registration.add(new Registration(MemberID + String.format("%03d", numberOfInvoice), FamilyMember.get(i), Service));
                                    numberOfInvoice = 0;
                                }
                            }
                        }

                    }
                    if (temp.equalsIgnoreCase("submit")) { // SPECIAL CASE FOR USER NOT FOUND

                        PrintReceipt(Registration.get(Registration.size() - 1), Writer);

                    }

                } while (!temp.equalsIgnoreCase("submit"));

            }
            if (inputPrintChecks.equalsIgnoreCase("Print_Sort_Classes")) { // ENTER AND PRINT THE CLASSES SORT
                Writer.println("----------------------------------------- Classes Sorted By Price ------------------------------------------\n"
                        + "Class name          	Location      	Instructor        	Price             	\n"
                        + "----------------------------------------------------------------------------------------------------------------");
                Collections.sort(Class);
                for (int i = 0; i < Class.size(); i++) {
                    Writer.printf("%-24s", Class.get(i).getServiceName());
                    Writer.printf("%-16s", Class.get(i).getLocation());
                    Writer.printf("%-24s", Class.get(i).getInstructor());
                    Writer.println(Class.get(i).getPrice());

                }
                Writer.println("\n");

            }
            if (inputPrintChecks.equalsIgnoreCase("Print_Sort_Amenities")) {// ENTER AND PRINT THE Amenities SORT
                Writer.println("----------------------------------------- Amenities Sorted By Name ------------------------------------------\n"
                        + "Amenity name        	Location      	Restriction       	Price             	\n"
                        + "----------------------------------------------------------------------------------------------------------------");
                Collections.sort(Amenity);

                for (int i = 0; i < Amenity.size(); i++) {
                    Writer.printf("%-24s", Amenity.get(i).getServiceName());
                    Writer.printf("%-16s", Amenity.get(i).getLocation());
                    Writer.printf("%-24s", Amenity.get(i).getRestriction());
                    Writer.println(Amenity.get(i).getPrice());

                }
                Writer.println("----------------------------------------------------------------------------------------------------------------");

            }

        }

        Writer.println("Thank you for using Gym Management System, Good Bye!");
        Writer.flush();
        Writer.close();

    }

    public static void PrintReceipt(Registration reg, PrintWriter Writer) {

        for (int i = 0; i < reg.getService().size(); i++) {//HERE WILL CHECK FOR ANY CONDITIONS

            if (reg.getRegistrationID().equalsIgnoreCase("nulll")) {
                Writer.println("the member does not exist in the system");

            }
            if (reg.getService().get(i).getLocation().equalsIgnoreCase("underage")) {
                Writer.println("The requested service " + reg.getService().get(i).getServiceName().substring(0, 1).toUpperCase() + reg.getService().get(i).getServiceName().substring(1) + "is not allowed for members below 18 years old");
                reg.getService().remove(i);
            }
            if (reg.getService().get(i).getLocation().equalsIgnoreCase("Family")) {
                Writer.println("The requested service " + reg.getService().get(i).getServiceName().substring(0, 1).toUpperCase() + reg.getService().get(i).getServiceName().substring(1) + " is not allowed for Single members");
                reg.getService().remove(i);
            }
            if (reg.getService().get(i).getLocation().equalsIgnoreCase("NoTClosE")) {
                Writer.println("The requested service " + reg.getService().get(i).getServiceName().substring(0, 1).toUpperCase() + reg.getService().get(i).getServiceName().substring(1) + " does not exist in the system");
                reg.getService().remove(i);
            }

        }
        if (!reg.getRegistrationID().equalsIgnoreCase("nulll")) {// FIRST WILL CHECK IF THE USER EXIST  IN SYSTEM IF IT'S WILL ENTER  AND AFTER WILL PRINT 
            Writer.println("------------------------- Invoice Details -------------------------");
            Writer.println("Registration Reference Number:" + reg.getRegistrationID());
            Writer.println("Member ID:" + reg.getMember().getID());
            Writer.println("Member name:" + reg.getMember().getName());
            Writer.println("-------------------------------------------------------------------");
            Writer.println("Service             	Original_Price	Discount	Final_price");
            for (int i = 0; i < reg.getService().size(); i++) { // HERE WILL PRINT THE Service

                Writer.printf("%-24s", reg.getService().get(i).getServiceName().substring(0, 1).toUpperCase() + reg.getService().get(i).getServiceName().substring(1));
                Writer.printf("%-16.2f", reg.getService().get(i).getPrice());
                Writer.printf("%.1f", reg.getDiscount() * 100);
                Writer.print("%");
                Writer.printf("%-11s", "");
                Writer.printf("%.2f", reg.getFinalPrice(reg.getService().get(i)));

                Writer.println();
            }
            Writer.println("-------------------------------------------------------------------");
            Writer.println(" Number of discounted items:" + reg.getNumberOfDiscount());
            Writer.print("- Original Total Price:");
            Writer.printf("%.2f", reg.getoriginalPrice());
            Writer.println();
            Writer.print("- Final Price:");
            Writer.printf("%.2f", reg.gettotalFinalPrice());
            Writer.println();
            Writer.print("- Saving Amount:");
            Writer.printf("%.2f", reg.getSavingAmount());
            Writer.println();
            Writer.println("-------------------------------------------------------------------");
            Writer.println("\n");

        }

    }

//
    private static FamilyMember getFamilyMember(Scanner input, int FamilyMemberCounter) { // I USE THIS METHOD FOR RETURN  NEW OBJ OF FamilyMember
        ArrayList<String> Family_member_names = new ArrayList<>(); // CREATE ARRAYLIST FOR THE Family_member_names
        String Name = input.next(); // RECORD THE NAME IN NAME
        char Gender = input.next().charAt(0); //RECORD THE GENDER
        LocalDate DateOfBirtHarry = StringToDate(input.next()); // USE StringToDate METHOD  TO SAVE DateOfBirtHarry
        LocalDate DateOfRegestration = StringToDate(input.next()); // USE StringToDate METHOD  TO SAVE DateOfRegestration
        String Address = input.next(); //RECORD THE ADDRESS
        String Phone = input.next(); // RECORD  Phone NUMBER
        String[] readnames = input.next().split("/"); //HERE WILL READ THE ALL NAMES AND SEPARATED BY / AND BUT IT IN ARRY
        for (int i = 0; i < readnames.length; i++) {
            Family_member_names.add(readnames[i]); //BUT THE THE NAMES IN ARRAYLIST

        }

        return new FamilyMember(FamilyMemberCounter + "", Name, Gender, DateOfBirtHarry, DateOfRegestration, Address, Phone, Family_member_names); // RETURN  new FamilyMember
    }

    private static SingleMember getSingleMember(Scanner input, int SingleMemberCounter) {

        String Name = input.next();// RECORD THE NAME IN NAME
        char Gender = input.next().charAt(0);//RECORD THE GENDER
        LocalDate DateOfBirtHarry = StringToDate(input.next());// USE StringToDate METHOD  TO SAVE DateOfBirtHarry
        LocalDate DateOfRegestration = StringToDate(input.next());// USE StringToDate METHOD  TO SAVE DateOfRegestration
        String Address = input.next();//RECORD THE ADDRESS
        String Phone = input.next(); // RECORD  Phone NUMBER
        String MembershipType = input.next(); // RECORD  MembershipType
        return new SingleMember(SingleMemberCounter + "", Name, Gender, DateOfBirtHarry, DateOfRegestration, Address, Phone, MembershipType); // RETURN  new SingleMember

    }

    private static Amenity getAmenity(Scanner input, int AmenityCounter) {
        return new Amenity((AmenityCounter + ""), input.next(), input.next(), input.next(), input.next(), input.nextDouble());// RETURN  new Amenity

    }

    private static Class getClass(Scanner input, int ClassCounter) {
        return new Class((ClassCounter + ""), input.next(), input.next(), input.nextDouble(), input.nextInt(), input.next());// RETURN  new Class

    }

    public static LocalDate StringToDate(String s) {

        String[] DateOfBirtHarry = s.split("/");  //HERE WILL READ THE ALL NUMERS AS STRING AND SEPARATED BY / AND BUT IT IN ARRAY
        int dayDateOfBirtHarry = Integer.parseInt(DateOfBirtHarry[0]);// HERE WILL CHANGE THE TYPE FORM STRING TO INTEGER BY Integer.parseInt();
        int monthDateOfBirtHarry = Integer.parseInt(DateOfBirtHarry[1]);// HERE WILL CHANGE THE TYPE FORM STRING TO INTEGER BY Integer.parseInt();
        int yareDateOfBirtHarry = Integer.parseInt(DateOfBirtHarry[2]);// HERE WILL CHANGE THE TYPE FORM STRING TO INTEGER BY Integer.parseInt();

        return LocalDate.of(yareDateOfBirtHarry, monthDateOfBirtHarry, dayDateOfBirtHarry); // return AS LocalDate
    }

    public static String DateToString(Date s) { // I DONT NEED TO USE IT 

        return null;

    }

}
