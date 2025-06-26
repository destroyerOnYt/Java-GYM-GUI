class PremiumMember extends GymMember {
    //declaring variables with private acccess modifier accourding to the question
    private final double premiumCharge ;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount, discountAmount;
    //creating a constructor to pass the values
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        //using super keyword to call the parent class constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge=50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    //accessor for all the attributes
    public double getPremiumCharge() {
        return premiumCharge; 
    }

    public String getPersonalTrainer() {
        return personalTrainer; 
    }

    public boolean getIsFullPayment() {
        return isFullPayment; 
    }

    public double getPaidAmount() { 
        return paidAmount; 
    }

    public double getDiscountAmount() { 
        return discountAmount; 
    }
    //overiding as it is an abstract method and inceasing attendance and loyalty points
    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 10;
    }
    // method to check if the full payment is done or not
    public String payDueAmount(double amount) {
        if (isFullPayment==true) return "Payment is already completed.";
        if (paidAmount + amount > premiumCharge) return "Total payment exceeds premium charge.";

        this.paidAmount += amount;
        if (this.paidAmount == premiumCharge) {
            this.isFullPayment = true;
        }
        double remainingAmount = premiumCharge - this.paidAmount;
        return "Payment successful.And the remaining amount is " + remainingAmount;
    }
    //calulating discount for preminum members
    public void calculateDiscount() {
        if (isFullPayment==true) {
            this.discountAmount = premiumCharge * 0.10;
            System.out.println("Discount is" + discountAmount);
        }
    }

    public void setDiscountAmount(double discount) {
        this.discountAmount = discount;
    }
    //method to reset premium members
    public void revertPremiumMember() {
        resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    //method to diplay the details
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        System.out.println("Remaining Amount: " + (premiumCharge - paidAmount));
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }

}
