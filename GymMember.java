public  abstract class GymMember{
    //declaring variables with protected access modifier according to the question
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    //creating a constructor to intitialize values according to the question 
    public GymMember(int id,String name,String location,String phone,String email,String gender,
    String DOB,String membershipStartDate){
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0;
        this.activeStatus=false;

    }
    //creating accessor method for each attribute(variable)
    public int getId(){
        return id;
    }

    public String getDOB(){
        return DOB;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getGender(){
        return gender;
    }

    public String getLocation(){
        return location;
    }
    public String getDob(){
        return DOB;
        
    }

    public String getMembershipStartDate(){
        return membershipStartDate;
    }

    public int getAttendance(){
        return attendance;
    }

    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }

    public boolean getActiveStatus(){
        return activeStatus;
    }

    //creating abstract method markAttendance for the sub class
    public abstract void markAttendance();

    //creating method activate membership which when called will set the active status to true as active status is set to false by default
    public void activateMembership(){

        activeStatus=true;
    }
    //creating method deavtivateMembership which when called will set the active status to false if it is already false it displays a message

    public void deactivateMembership(){
        if(activeStatus==true){

            activeStatus=false;
        }else{
            System.out.println("You don't have an active membership");
        }
    }
    //reset membet method to reset the values of attendance and loyalty points to zero and active status to false
    public void resetMember(){
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0;
    }
    // display method displays the details of the members
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
    

public void setAttendance(int attendance) {
    this.attendance = attendance;
}
public void setActiveStatus(boolean activeStatus){
    this.activeStatus=activeStatus;
    
}
}