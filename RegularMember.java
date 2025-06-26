public class RegularMember extends GymMember{
    // declaring variables with access modifier private 
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price; 
    //creating a constructor to intialize the values 
    public RegularMember(int id,String name,String location,String phone, String email,String gender,String DOB,String plan,int price,String membershipStartDate,String referralSource){
        //using super keyword to call the parent class constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.referralSource = referralSource;
        this.plan = plan;
        this.price = price;
        this.attendanceLimit=30;

    }
    //accessor method for each attribute
    public int getAttendanceLimit(){
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade(){
        return isEligibleForUpgrade;
    }

    public String getRemovalReason(){
        return removalReason;
    }

    public String getReferralSource(){
        return referralSource;
    }

    public String getPlan(){
        return plan;
    }

    public double getPrice(){
      return this.price;
    }
    // overriding the markattendance as it is an abstract method  which increases the attendance and the loyalty points and checks if the user is eligible for an upgrade
    @Override 
    public void markAttendance(){
        attendance++;
        loyaltyPoints+=5;
        if(attendance>=attendanceLimit){
            isEligibleForUpgrade=true;
        }
    }
    //method to check the price for membership plans 
    public double getPlanPrice(String newPlan){
        switch(newPlan.toLowerCase()){
                case"basic" : return 6500;
            case "standard":return 12500;
            case "deluxe":return 18500;
            default: return -1;

        }
    }
    //checking if the user is eligible for upgrade
    public String upgradePlan(String newPlan) {
    if (!activeStatus) {
        return "Membership is not active. Cannot upgrade plan.";
    }

    if (this.plan.equalsIgnoreCase(newPlan)) {
        return "Plan is already active.";
    }

    double newPrice = getPlanPrice(newPlan);
    if (newPrice == -1) {
        return "Invalid plan name.";
    }

    if (!isEligibleForUpgrade) {
        return "Not eligible for upgrade yet.";
    }

    this.plan = newPlan.toLowerCase();
    this.price = newPrice;
    isEligibleForUpgrade = true;

    return "Plan upgraded successfully to " + newPlan;
}

    //method which resets the plan to "basic" price to 6500 asks for removal reason and sets the isEligibleForUpgrade to false
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Display details of the user
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (removalReason !="") {
            System.out.println("Removal Reason: " + removalReason);
        }

    }
}

