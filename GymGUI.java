
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class GymGUI {
    //creating instance variables
    private ArrayList<GymMember> members;

    private JFrame frame;
    private JLabel id, name, location, phone, email, gender, dob, plan, planPrice, startDate, referral, paidAmount,personalTrainer, removalReason, trainerName, primiumPrice, regularPrice, premiumPlan, regularPlan,pricePlan;
    private JTextField idTxt, nameTxt, locationTxt, planPriceTxt, phoneTxt, emailTxt, referalTxt, paidTxt, trainerTxt,personalTrainerTxt;
    private JButton regular, premium, display, Read,addReg, activateReg, markReg, revertReg, clearReg,  deactivateReg, addPrem, activatePrem, markPrem, revertPrem,discountPrem, clearPrem, payDue, deactivatePrem,upgradePlan,saveButtonReg, saveButtonPrem;
    private JTextArea removalTxt;
    private JComboBox<String> dobBox, startBox, planBox;
    private JRadioButton male, female, other;
    private JTextArea memberList;
    //creating constructors to intialize
    public GymGUI() {
        //creating frame
        frame = new JFrame("GYM SYSTEM");
        members= new ArrayList<>();
        members=new ArrayList<>();

        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //cree

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder("Home Page"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("Gym Membership System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.RED);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(title, gbc);

        regular = new JButton("Regular Member");
        premium = new JButton("Premium Member");
        display = new JButton("View Members");
        Read =new JButton("Read From File");

        buttonStyle(regular);
        buttonStyle(premium);
        buttonStyle(display);
        buttonStyle(Read);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(regular, gbc);

        gbc.gridx = 1;
        mainPanel.add(premium, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        mainPanel.add(display, gbc);

        gbc.gridy=2;
        gbc.gridx=1;
        mainPanel.add(Read, gbc);

        regular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame regularFrame = new JFrame("Add Regular Member");
                    regularFrame.setSize(700, 700);
                    regularFrame.setLocationRelativeTo(null);
                    regularFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JPanel regularPanel = new JPanel(new GridBagLayout());
                    regularPanel.setBorder(BorderFactory.createTitledBorder("Regular Members"));
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5);
                    gbc.fill = GridBagConstraints.HORIZONTAL;

                    JLabel id = new JLabel("ID");
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    regularPanel.add(id, gbc);
                    JTextField idTxt = new JTextField(20);
                    gbc.gridx = 1;
                    regularPanel.add(idTxt, gbc);

                    JLabel name = new JLabel("Name");
                    gbc.gridy = 1;
                    gbc.gridx = 0;
                    regularPanel.add(name, gbc);
                    JTextField nameTxt = new JTextField(20);
                    gbc.gridx = 1;
                    regularPanel.add(nameTxt, gbc);

                    JLabel location = new JLabel("Location");
                    gbc.gridy = 2;
                    gbc.gridx = 0;
                    regularPanel.add(location, gbc);
                    JTextField locationTxt = new JTextField(20);
                    gbc.gridx = 1;
                    regularPanel.add(locationTxt, gbc);

                    JLabel phone = new JLabel("Phone");
                    gbc.gridy = 3;
                    gbc.gridx = 0;
                    regularPanel.add(phone, gbc);
                    JTextField phoneTxt = new JTextField(20);
                    gbc.gridx = 1;
                    regularPanel.add(phoneTxt, gbc);

                    JLabel email = new JLabel("Email");
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    regularPanel.add(email, gbc);
                    JTextField emailTxt = new JTextField(20);
                    gbc.gridx = 1;
                    regularPanel.add(emailTxt, gbc);

                    JLabel gender = new JLabel("Gender");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    regularPanel.add(gender, gbc);

                    JRadioButton male = new JRadioButton("Male");
                    JRadioButton female = new JRadioButton("Female");
                    JRadioButton other = new JRadioButton("Other");
                    ButtonGroup genderGroup = new ButtonGroup();
                    genderGroup.add(male);
                    genderGroup.add(female);
                    genderGroup.add(other);

                    JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
                    genderPanel.add(male);
                    genderPanel.add(female);
                    genderPanel.add(other);
                    gbc.gridx = 1;
                    regularPanel.add(genderPanel, gbc);

                    // Arrays for year, month, day for DOB
                    String[] yearsArray = new String[61];  // 1970 to 2030
                    for (int i = 0; i < 61; i++) {
                        yearsArray[i] = String.valueOf(1970 + i);
                    }

                    String[] monthArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

                    String[] dayArray = new String[31];
                    for (int i = 0; i < 31; i++) {
                        dayArray[i] = String.valueOf(i + 1);
                    }

                    // Date of Birth
                    JLabel dob = new JLabel("Date of Birth:");
                    gbc.gridx = 0;
                    gbc.gridy = 6;
                    regularPanel.add(dob, gbc);

                    JComboBox<String> dobDay = new JComboBox<>(dayArray);
                    JComboBox<String> dobMonth = new JComboBox<>(monthArray);
                    JComboBox<String> dobYear = new JComboBox<>(yearsArray);

                    JPanel dobPanel = new JPanel(new FlowLayout());
                    dobPanel.add(dobDay);
                    dobPanel.add(dobMonth);
                    dobPanel.add(dobYear);
                    gbc.gridx = 1;
                    regularPanel.add(dobPanel, gbc);

                    plan= new JLabel("Plan");
                    gbc.gridx=0;
                    gbc.gridy=7;
                    regularPanel.add(plan,gbc);

                    String[] planArray={"Basic","Standard","Delux"};
                    JComboBox<String> planBox = new JComboBox<>(planArray);
                    gbc.gridx=1;
                    gbc.gridy=7;
                    regularPanel.add(planBox,gbc);

                    pricePlan=new JLabel("Price Plan");
                    gbc.gridx=0;
                    gbc.gridy=8;
                    regularPanel.add(pricePlan,gbc);
                    planPriceTxt=new JTextField("6500");
                    gbc.gridx=1;
                    gbc.gridy=8;
                    planPriceTxt.setEditable(false);

                    regularPanel.add(planPriceTxt,gbc);

                    //start date label and combo box
                    startDate = new JLabel("Start Date:");
                    gbc.gridy = 9;
                    gbc.gridx=0;
                    regularPanel.add(startDate, gbc);
                    JComboBox <String> startDay=new JComboBox<>(dayArray);
                    JComboBox<String> startMonth=new JComboBox<>(monthArray);
                    JComboBox<String> startYear=new JComboBox<>(yearsArray);
                    JPanel startPanel=new JPanel(new FlowLayout()); 
                    startPanel.add(startDay);
                    startPanel.add(startMonth);
                    startPanel.add(startYear);

                    gbc.gridy=9;
                    gbc.gridx=1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    regularPanel.add(startPanel, gbc);
                    //referral label and text field
                    referral = new JLabel("Referral");
                    gbc.gridy = 10;
                    gbc.gridx=0;
                    regularPanel.add(referral, gbc);
                    referalTxt=new JTextField(20);
                    gbc.gridx=1;
                    regularPanel.add(referalTxt,gbc);
                    //removal label and text area

                    regularFrame.add(regularPanel);
                    regularFrame.setVisible(true);

                    addReg= new JButton("Add Regular Member");
                    gbc.gridx=0;
                    gbc.gridy=12;
                    regularPanel.add(addReg,gbc);

                    activateReg= new JButton("Activate Regular Member");
                    gbc.gridx=1;
                    gbc.gridy=12;
                    regularPanel.add(activateReg,gbc);

                    markReg= new JButton("Mark Attendance");
                    gbc.gridx=0;
                    gbc.gridy=13;
                    regularPanel.add(markReg,gbc);

                    revertReg= new JButton("Revert Regular Member");
                    gbc.gridx=1;
                    gbc.gridy=13;
                    regularPanel.add(revertReg,gbc);

                    clearReg=new JButton("Clear form");
                    gbc.gridx=0;
                    gbc.gridy=14;
                    regularPanel.add(clearReg,gbc);

                    deactivateReg=new JButton("Deactivate");
                    gbc.gridx=1;
                    gbc.gridy=14;
                    gbc.gridwidth=2;
                    regularPanel.add(deactivateReg,gbc);

                    upgradePlan=new JButton("Upgrade Plan");
                    gbc.gridx=0;
                    gbc.gridy=15;
                    gbc.gridwidth=1;
                    regularPanel.add(upgradePlan,gbc);

                    saveButtonReg = new JButton("Save to File");
                    gbc.gridx = 1;
                    gbc.gridy = 15; // or next available row
                    regularPanel.add(saveButtonReg, gbc);

                    buttonStyle(upgradePlan);
                    buttonStyle(addReg);
                    buttonStyle(activateReg);
                    buttonStyle(markReg);
                    buttonStyle(revertReg);
                    buttonStyle(clearReg);
                    buttonStyle(deactivateReg);
                    buttonStyle(saveButtonReg);

                    planBox.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String selectedPlan = (String) planBox.getSelectedItem();
                                if ("Basic".equals(selectedPlan)) {
                                    planPriceTxt.setText("6500");

                                }else if("Standard".equals(selectedPlan)){
                                    planPriceTxt.setText("12500");
                                }else if("Delux".equals(selectedPlan)){
                                    planPriceTxt.setText("18000");
                                }

                            }});
                    addReg.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    // storing input
                                    String idStr = idTxt.getText();
                                    String name = nameTxt.getText();
                                    String location = locationTxt.getText();
                                    String phone = phoneTxt.getText();
                                    String email = emailTxt.getText();
                                    String referral = referalTxt.getText();
                                    String planStr = planPriceTxt.getText();
                                    String selectedPlan = (String) planBox.getSelectedItem();

                                    String gender = null;
                                    if (male.isSelected()) gender = "Male";
                                    else if (female.isSelected()) gender = "Female";
                                    else if (other.isSelected()) gender = "Other";

                                    String day = (String) dobDay.getSelectedItem();
                                    String month = (String) dobMonth.getSelectedItem();
                                    String year = (String) dobYear.getSelectedItem();
                                    String dob = day + "/" + month + "/" + year;

                                    String startday = (String) startDay.getSelectedItem();
                                    String startmonth = (String) startMonth.getSelectedItem();
                                    String startyear = (String) startYear.getSelectedItem();
                                    String startDate = startday + "/" + startmonth + "/" + startyear;

                                    //  Check for empty fields 
                                    if (idStr.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() ||
                                    email.isEmpty() || referral.isEmpty() || planStr.isEmpty() ||
                                    gender == null || day == null || month == null || year == null ||
                                    startday == null || startmonth == null || startyear == null || selectedPlan == null) {

                                        JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    }

                                    // changing to parseInt
                                    int id = Integer.parseInt(idStr);
                                    String stringPlan = planPriceTxt.getText();
                                    int planPrice=Integer.parseInt(stringPlan);

                                    //Check if ID already exists
                                    boolean exists = false;
                                    for (GymMember member : members) {
                                        if (member.getId() == id) {
                                            exists = true;
                                            break;
                                        }
                                    }

                                    // Step 5: Handle based on existence
                                    if (exists) {
                                        JOptionPane.showMessageDialog(null, "Member ID already exists. Please use a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dob,selectedPlan,  planPrice,startDate, referral);
                                        members.add(newMember);
                                        JOptionPane.showMessageDialog(null, "Member added successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);

                                    }
                                } catch (NumberFormatException nfe) {
                                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });
                    clearReg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //clearing all the textfields radio button and combo box
                                idTxt.setText("");
                                nameTxt.setText("");
                                locationTxt.setText("");
                                phoneTxt.setText("");
                                emailTxt.setText("");
                                referalTxt.setText("");
                                planBox.setSelectedIndex(0);
                                genderGroup.clearSelection();
                                dobDay.setSelectedIndex(0);
                                dobMonth.setSelectedIndex(0);
                                dobYear.setSelectedIndex(0);
                                startDay.setSelectedIndex(0);
                                startMonth.setSelectedIndex(0);
                                startYear.setSelectedIndex(0);

                            }
                        });
                    markReg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to mark attendance:");

                                try {
                                    int memberId = Integer.parseInt(inputId);
                                    boolean found = false;

                                    for (GymMember member : members) {
                                        if (member.getId() == memberId) {
                                            found = true;

                                            if (member.getActiveStatus()) {
                                                member.markAttendance(); // ✅ Correct way to handle it
                                                JOptionPane.showMessageDialog(null,
                                                    "Attendance marked for Member ID: " + memberId +
                                                    "\nTotal Attendance: " + member.getAttendance() +
                                                    "\nLoyalty Points: " + member.getLoyaltyPoints());
                                            } else {
                                                JOptionPane.showMessageDialog(null,
                                                    "Cannot mark attendance. Membership is deactivated.",
                                                    "Inactive Member", JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        JOptionPane.showMessageDialog(null,
                                            "Member ID not found.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null,
                                        "Invalid ID. Please enter a numeric value.",
                                        "Input Error", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        });

                    revertReg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to remove:");

                                if (input != null) {  // Only proceed if user didn't cancel
                                    try {
                                        int id = Integer.parseInt(input);
                                        boolean found = false;

                                        // Ask for removal reason
                                        String removalReason = JOptionPane.showInputDialog(null, "Enter removal reason:");

                                        if (removalReason == null || removalReason.isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Removal reason is required.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;  // Exit if no reason is provided
                                        }

                                        // Iterate over members to find the one with the given ID
                                        for (GymMember member : members) {
                                            if (member.getId() == id) {
                                                found = true;

                                                // Remove the member from the list
                                                members.remove(member);
                                                JOptionPane.showMessageDialog(null, "Member removed successfully. Reason: " + removalReason, "Success", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        });
                    activateReg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to activate:");

                                try {
                                    int id = Integer.parseInt(input);
                                    boolean found = false;

                                    for (GymMember member : members) {
                                        if (member.getId() == id) {
                                            found = true;

                                            if (member.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(null, "Member is already active.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                member.setActiveStatus(true);
                                                JOptionPane.showMessageDialog(null, "Member activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        });
                    deactivateReg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to deactivate:");

                                if (input != null) {  // Only proceed if user didn't cancel
                                    try {
                                        int id = Integer.parseInt(input);
                                        boolean found = false;

                                        for (GymMember member : members) {
                                            if (member.getId() == id) {
                                                found = true;

                                                if (!member.getActiveStatus()) {
                                                    JOptionPane.showMessageDialog(null, "Member is already inactive.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    member.setActiveStatus(false);
                                                    JOptionPane.showMessageDialog(null, "Member deactivated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        });
                    upgradePlan.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                JTextField idField = new JTextField();
                                String[] plans = {"Basic", "Standard", "Deluxe"};
                                JComboBox<String> planCombo = new JComboBox<String>(plans);

                                JPanel panel = new JPanel(new GridLayout(2, 2));
                                panel.add(new JLabel("Enter Member ID:"));
                                panel.add(idField);
                                panel.add(new JLabel("Select New Plan:"));
                                panel.add(planCombo);

                                int result = JOptionPane.showConfirmDialog(null, panel, "Upgrade Plan", JOptionPane.OK_CANCEL_OPTION);

                                if (result == JOptionPane.OK_OPTION) {
                                    try {
                                        int id = Integer.parseInt(idField.getText());
                                        String newPlan = (String) planCombo.getSelectedItem();
                                        boolean found = false;

                                        for (int i = 0; i < members.size(); i++) {
                                            GymMember member = members.get(i);
                                            if (member instanceof RegularMember && member.getId() == id) {
                                                if (!member.getActiveStatus()) {
                                                    JOptionPane.showMessageDialog(null, "Membership must be active to upgrade.");
                                                    return;
                                                }
                                                String message = ((RegularMember) member).upgradePlan(newPlan);
                                                JOptionPane.showMessageDialog(null, message);
                                                found = true;
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "No Regular Member found with ID: " + id);
                                        }
                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a number.");
                                    }
                                }
                            }
                        });
                    saveButtonReg.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                saveToFile();
                            }
                        });
                    regularFrame.add(regularPanel);
                    regularFrame.setVisible(true);

                }
            });
        display.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (members.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No members to display.");
                        return;
                    }

                    JTextArea displayArea = new JTextArea(20, 60);
                    displayArea.setEditable(false);

                    String output = "";
                    for (GymMember member : members) {
                        output += "----------- Member Info -----------\n";
                        if (member instanceof RegularMember) {
                            RegularMember rm = (RegularMember) member;
                            output += "Member Type: Regular Member\n";
                            output += "ID: " + rm.getId() + "\n";
                            output += "Name: " + rm.getName() + "\n";
                            output += "Location: " + rm.getLocation() + "\n";
                            output += "Phone: " + rm.getPhone() + "\n";
                            output += "Email: " + rm.getEmail() + "\n";
                            output += "Gender: " + rm.getGender() + "\n";
                            output += "DOB: " + rm.getDOB() + "\n";
                            output += "Membership Start Date: " + rm.membershipStartDate + "\n";
                            output += "Attendance: " + rm.attendance + "\n";
                            output += "Loyalty Points: " + rm.loyaltyPoints + "\n";
                            output += "Active Status: " + rm.activeStatus + "\n";
                            output += "Plan: " + rm.getPlan() + "\n";
                            output += "Price: " + rm.getPrice() + "\n";
                            output += "Referral Source: " + rm.getReferralSource() + "\n";
                            if (!rm.getRemovalReason().isEmpty()) {
                                output += "Removal Reason: " + rm.getRemovalReason() + "\n";
                            }
                        } else if (member instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) member;
                            output += "Member Type: Premium Member\n";
                            output += "ID: " + pm.getId() + "\n";
                            output += "Name: " + pm.getName() + "\n";
                            output += "Location: " + pm.getLocation() + "\n";
                            output += "Phone: " + pm.getPhone() + "\n";
                            output += "Email: " + pm.getEmail() + "\n";
                            output += "Gender: " + pm.getGender() + "\n";
                            output += "DOB: " + pm.getDOB() + "\n";
                            output += "Membership Start Date: " + pm.membershipStartDate + "\n";
                            output += "Attendance: " + pm.attendance + "\n";
                            output += "Loyalty Points: " + pm.loyaltyPoints + "\n";
                            output += "Active Status: " + pm.activeStatus + "\n";
                            output += "Personal Trainer: " + pm.getPersonalTrainer() + "\n";
                            output += "Paid Amount: " + pm.getPaidAmount() + "\n";
                            output += "Is Full Payment: " + pm.getIsFullPayment() + "\n";
                            double remaining = pm.getPremiumCharge() - pm.getPaidAmount();
                            output += "Remaining Amount: " + remaining + "\n";
                            if (pm.getIsFullPayment()) {
                                output += "Discount Amount: " + pm.getDiscountAmount() + "\n";
                            }
                        }
                        output += "\n";
                    }

                    displayArea.setText(output);
                    JScrollPane scrollPane = new JScrollPane(displayArea);
                    JFrame displayFrame = new JFrame("Member Details");
                    displayFrame.add(scrollPane);
                    displayFrame.pack();
                    displayFrame.setLocationRelativeTo(null);
                    displayFrame.setVisible(true);
                }
            });

        premium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame premiumFrame = new JFrame("Add Premium Member");
                    premiumFrame.setSize(700, 700);
                    premiumFrame.setLocationRelativeTo(null);
                    premiumFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JPanel premiumPanel = new JPanel(new GridBagLayout());
                    premiumPanel.setBorder(BorderFactory.createTitledBorder("Premium Members"));
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5);
                    gbc.fill = GridBagConstraints.HORIZONTAL;

                    // ID Label and TextField
                    JLabel id = new JLabel("ID");
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    premiumPanel.add(id, gbc);
                    JTextField idTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(idTxt, gbc);

                    // Name Label and TextField
                    JLabel name = new JLabel("Name");
                    gbc.gridy = 1;
                    gbc.gridx = 0;
                    premiumPanel.add(name, gbc);
                    JTextField nameTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(nameTxt, gbc);

                    // Location Label and TextField
                    JLabel location = new JLabel("Location");
                    gbc.gridy = 2;
                    gbc.gridx = 0;
                    premiumPanel.add(location, gbc);
                    JTextField locationTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(locationTxt, gbc);

                    // Phone Label and TextField
                    JLabel phone = new JLabel("Phone");
                    gbc.gridy = 3;
                    gbc.gridx = 0;
                    premiumPanel.add(phone, gbc);
                    JTextField phoneTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(phoneTxt, gbc);

                    // Email Label and TextField
                    JLabel email = new JLabel("Email");
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    premiumPanel.add(email, gbc);
                    JTextField emailTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(emailTxt, gbc);

                    // Gender Label and Radio Buttons
                    JLabel gender = new JLabel("Gender");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    premiumPanel.add(gender, gbc);

                    JRadioButton male = new JRadioButton("Male");
                    JRadioButton female = new JRadioButton("Female");
                    JRadioButton other = new JRadioButton("Other");
                    ButtonGroup genderGroup = new ButtonGroup();
                    genderGroup.add(male);
                    genderGroup.add(female);
                    genderGroup.add(other);

                    JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
                    genderPanel.add(male);
                    genderPanel.add(female);
                    genderPanel.add(other);
                    gbc.gridx = 1;
                    premiumPanel.add(genderPanel, gbc);

                    // Arrays for year, month, day for DOB
                    String[] yearsArray = new String[61];  // 1970 to 2030
                    for (int i = 0; i < 61; i++) {
                        yearsArray[i] = String.valueOf(1970 + i);
                    }

                    String[] monthArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

                    String[] dayArray = new String[31];
                    for (int i = 0; i < 31; i++) {
                        dayArray[i] = String.valueOf(i + 1);
                    }

                    // Date of Birth
                    JLabel dob = new JLabel("Date of Birth:");
                    gbc.gridx = 0;
                    gbc.gridy = 6;
                    premiumPanel.add(dob, gbc);

                    JComboBox<String> dobDay = new JComboBox<>(dayArray);
                    JComboBox<String> dobMonth = new JComboBox<>(monthArray);
                    JComboBox<String> dobYear = new JComboBox<>(yearsArray);

                    JPanel dobPanel = new JPanel(new FlowLayout());
                    dobPanel.add(dobDay);
                    dobPanel.add(dobMonth);
                    dobPanel.add(dobYear);
                    gbc.gridx = 1;
                    premiumPanel.add(dobPanel, gbc);

                    // Plan (Uneditable and Always Premium)
                    JLabel plan = new JLabel("Plan");
                    gbc.gridx = 0;
                    gbc.gridy = 7;
                    premiumPanel.add(plan, gbc);

                    JTextField planTxt = new JTextField("Premium");
                    planTxt.setEditable(false); // Make it uneditable
                    gbc.gridx = 1;
                    premiumPanel.add(planTxt, gbc);

                    JLabel pricePlan = new JLabel("Price Plan");
                    gbc.gridx = 0;
                    gbc.gridy = 8;
                    premiumPanel.add(pricePlan, gbc);

                    JTextField planPriceTxt = new JTextField("50000");
                    planPriceTxt.setEditable(false); // Make it uneditable
                    gbc.gridx = 1;
                    premiumPanel.add(planPriceTxt, gbc);

                    // Start Date
                    JLabel startDate = new JLabel("Start Date:");
                    gbc.gridy = 9;
                    gbc.gridx = 0;
                    premiumPanel.add(startDate, gbc);

                    JComboBox<String> startDay = new JComboBox<>(dayArray);
                    JComboBox<String> startMonth = new JComboBox<>(monthArray);
                    JComboBox<String> startYear = new JComboBox<>(yearsArray);

                    JPanel startPanel = new JPanel(new FlowLayout());
                    startPanel.add(startDay);
                    startPanel.add(startMonth);
                    startPanel.add(startYear);
                    gbc.gridx = 1;
                    premiumPanel.add(startPanel, gbc);

                    // Referral
                    JLabel personalTrainer = new JLabel("Personal Trainer");
                    gbc.gridy = 10;
                    gbc.gridx = 0;
                    premiumPanel.add(personalTrainer, gbc);

                    JTextField personalTrainerTxt = new JTextField(20);
                    gbc.gridx = 1;
                    premiumPanel.add(personalTrainerTxt, gbc);

                    // Discount Calculation Button and Display Field
                    JButton calculateDiscount = new JButton("Calculate Discount");
                    gbc.gridx = 0;
                    gbc.gridy = 11;
                    premiumPanel.add(calculateDiscount,gbc);

                    JLabel discountLabel = new JLabel("Discount");
                    gbc.gridx = 0;
                    gbc.gridy = 12;
                    premiumPanel.add(discountLabel, gbc);

                    JTextField discountTxt = new JTextField();
                    discountTxt.setEditable(false);  // Make the discount text field uneditable
                    gbc.gridx = 1;
                    premiumPanel.add(discountTxt, gbc);

                    // Adding the panel to the frame
                    premiumFrame.add(premiumPanel);
                    premiumFrame.setVisible(true);

                    // Buttons
                    JButton addPrem = new JButton("Add Premium Member");
                    gbc.gridx = 0;
                    gbc.gridy = 13;
                    premiumPanel.add(addPrem, gbc);

                    JButton activatePrem = new JButton("Activate Premium Member");
                    gbc.gridx = 1;
                    gbc.gridy = 13;
                    premiumPanel.add(activatePrem, gbc);

                    JButton markPrem = new JButton("Mark Attendance");
                    gbc.gridx = 0;
                    gbc.gridy = 14;
                    premiumPanel.add(markPrem, gbc);

                    JButton revertPrem = new JButton("Revert Premium Member");
                    gbc.gridx = 1;
                    gbc.gridy = 14;
                    premiumPanel.add(revertPrem, gbc);
                    //clear button
                    JButton clearPrem = new JButton("Clear Form");
                    gbc.gridx = 0;
                    gbc.gridy = 15;
                    premiumPanel.add(clearPrem, gbc);
                    //deactivate button
                    JButton deactivatePrem = new JButton("Deactivate");
                    gbc.gridx = 1;
                    gbc.gridy = 15;
                    premiumPanel.add(deactivatePrem, gbc);

                    JButton payDueButton = new JButton("Pay Due Amount");
                    gbc.gridx = 0;
                    gbc.gridy = 16;  
                    premiumPanel.add(payDueButton, gbc);
                    buttonStyle(payDueButton);

                    saveButtonPrem = new JButton("Save to File");
                    gbc.gridx = 1;
                    gbc.gridy = 16; // adjust row index
                    premiumPanel.add(saveButtonPrem, gbc);
                    buttonStyle(saveButtonPrem);

                    saveButtonPrem.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                saveToFile();
                            }
                        });

                    // Button Styling 
                    buttonStyle(addPrem);
                    buttonStyle(activatePrem);
                    buttonStyle(markPrem);
                    buttonStyle(revertPrem);
                    buttonStyle(clearPrem);
                    buttonStyle(deactivatePrem);
                    buttonStyle(calculateDiscount); 

                    addPrem.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    // store the input as strings
                                    String idStr = idTxt.getText();
                                    String name = nameTxt.getText();
                                    String location = locationTxt.getText();
                                    String phone = phoneTxt.getText();
                                    String email = emailTxt.getText();

                                    String personalTrainer = personalTrainerTxt.getText();

                                    // For Premium Member the Plan is always Premium and Price is always 50000
                                    String selectedPlan = "Premium";
                                    String planStr = "50000";  // Price for Premium plan is always 50000

                                    String gender = null;
                                    if (male.isSelected()) gender = "Male";
                                    else if (female.isSelected()) gender = "Female";
                                    else if (other.isSelected()) gender = "Other";

                                    String day = (String) dobDay.getSelectedItem();
                                    String month = (String) dobMonth.getSelectedItem();
                                    String year = (String) dobYear.getSelectedItem();
                                    String dob = day + "/" + month + "/" + year;

                                    String startday = (String) startDay.getSelectedItem();
                                    String startmonth = (String) startMonth.getSelectedItem();
                                    String startyear = (String) startYear.getSelectedItem();
                                    String startDate = startday + "/" + startmonth + "/" + startyear;

                                    //checking if the fields are empty
                                    if (idStr.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() ||
                                    email.isEmpty()  || planStr.isEmpty() ||
                                    gender == null || day == null || month == null || year == null ||
                                    startday == null || startmonth == null || startyear == null || selectedPlan == null) {

                                        JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    }

                                    //converting to parse
                                    int id = Integer.parseInt(idStr);
                                    int planPrice = Integer.parseInt(planStr);

                                    //Check if ID already exists
                                    boolean exists = false;
                                    for (GymMember member : members) {
                                        if (member.getId() == id) {
                                            exists = true;
                                            break;
                                        }
                                    }

                                    //Handle based on existence
                                    if (exists) {
                                        JOptionPane.showMessageDialog(null, "Member ID already exists. Please use a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        PremiumMember newPremiumMember = new PremiumMember( id, name, location, phone, email, gender,dob, startDate, personalTrainer);
                                        members.add(newPremiumMember);
                                        JOptionPane.showMessageDialog(null, "Premium Member added successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);

                                    }
                                } catch (NumberFormatException nfe) {
                                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID and Plan Price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                    markPrem.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to mark attendance:");

                                try {
                                    int memberId = Integer.parseInt(inputId);
                                    boolean found = false;

                                    for (GymMember member : members) {
                                        if (member.getId() == memberId) {
                                            found = true;

                                            if (member.getActiveStatus()) {
                                                member.setAttendance(member.getAttendance() + 1);
                                                JOptionPane.showMessageDialog(null, "Attendance marked for Member ID: " + memberId +
                                                    "\nTotal Attendance: " + member.getAttendance());
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cannot mark attendance. Membership is deactivated.", 
                                                    "Inactive Member", JOptionPane.WARNING_MESSAGE);
                                            }
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        JOptionPane.showMessageDialog(null, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a numeric value.", 
                                        "Input Error", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        });
                    calculateDiscount.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String idStr = JOptionPane.showInputDialog(null, "Enter Member ID:");

                                try {
                                    int id = Integer.parseInt(idStr);
                                    boolean found = false;

                                    for (GymMember member : members) {
                                        if (member instanceof PremiumMember && member.getId() == id) {
                                            found = true;
                                            PremiumMember pm = (PremiumMember) member;

                                            if (pm.getIsFullPayment()) {
                                                double discount = 0.10 * 50000; // 10% of premiumCharge
                                                pm.setDiscountAmount(discount);
                                                discountTxt.setText(String.valueOf((int) discount));
                                                JOptionPane.showMessageDialog(null, "Discount of " + (int) discount + " applied.");
                                            } else {
                                                discountTxt.setText("");
                                                JOptionPane.showMessageDialog(null, "Full payment not completed. Discount not applied.");
                                            }

                                            break;
                                        }
                                    }

                                    if (!found) {
                                        JOptionPane.showMessageDialog(null, "Member not found.");
                                    }

                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid ID.");
                                }
                            }
                        });

                    revertPrem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to remove:");

                                if (input != null) {  // Only proceed if user didn't cancel
                                    try {
                                        int id = Integer.parseInt(input);
                                        boolean found = false;

                                        // Ask for removal reason
                                        String removalReason = JOptionPane.showInputDialog(null, "Enter removal reason:");

                                        if (removalReason == null || removalReason.isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Removal reason is required.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;  // Exit if no reason is provided
                                        }

                                        // Iterate over members to find the one with the given ID
                                        for (GymMember member : members) {
                                            if (member.getId() == id) {
                                                found = true;

                                                // Remove the member from the list
                                                members.remove(member);
                                                JOptionPane.showMessageDialog(null, "Member removed successfully. Reason: " + removalReason, "Success", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        });
                    activatePrem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to activate:");

                                try {
                                    int id = Integer.parseInt(input);
                                    boolean found = false;

                                    for (GymMember member : members) {
                                        if (member.getId() == id) {
                                            found = true;

                                            if (member.getActiveStatus()) {
                                                JOptionPane.showMessageDialog(null, "Member is already active.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                member.setActiveStatus(true);
                                                JOptionPane.showMessageDialog(null, "Member activated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        });
                    deactivatePrem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(null, "Enter Member ID to deactivate:");

                                if (input != null) {  // Only proceed if user didn't cancel
                                    try {
                                        int id = Integer.parseInt(input);
                                        boolean found = false;

                                        for (GymMember member : members) {
                                            if (member.getId() == id) {
                                                found = true;

                                                if (!member.getActiveStatus()) {
                                                    JOptionPane.showMessageDialog(null, "Member is already inactive.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    member.setActiveStatus(false);
                                                    JOptionPane.showMessageDialog(null, "Member deactivated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        });
                    clearPrem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                idTxt.setText("");
                                nameTxt.setText("");
                                locationTxt.setText("");
                                phoneTxt.setText("");
                                emailTxt.setText("");
                                personalTrainerTxt.setText("");
                                genderGroup.clearSelection();
                                dobDay.setSelectedIndex(0);
                                dobMonth.setSelectedIndex(0);
                                dobYear.setSelectedIndex(0);
                                startDay.setSelectedIndex(0);
                                startMonth.setSelectedIndex(0);
                                startYear.setSelectedIndex(0);
                                discountTxt.setText("");

                            }
                        });
                    payDueButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JTextField idField = new JTextField();
                                JTextField amountField = new JTextField();

                                JPanel panel = new JPanel(new GridLayout(2, 2));
                                panel.add(new JLabel("Enter Member ID:"));
                                panel.add(idField);
                                panel.add(new JLabel("Enter Amount to Pay:"));
                                panel.add(amountField);

                                int result = JOptionPane.showConfirmDialog(null, panel, "Pay Due Amount", JOptionPane.OK_CANCEL_OPTION);

                                if (result == JOptionPane.OK_OPTION) {
                                    try {
                                        int id = Integer.parseInt(idField.getText());
                                        double amount = Double.parseDouble(amountField.getText());
                                        boolean found = false;

                                        for (GymMember member : members) {
                                            if (member instanceof PremiumMember && member.getId() == id) {
                                                found = true;
                                                PremiumMember pm = (PremiumMember) member;
                                                String message = pm.payDueAmount(amount);
                                                JOptionPane.showMessageDialog(null, message);
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            JOptionPane.showMessageDialog(null, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values only.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        });

                }
            });
       Read.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            File file = new File("MemberDetails.txt");

            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "No saved member file found.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String content = "";
            String line;

            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }

            reader.close();

            JTextArea textArea = new JTextArea(content);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 400));

            JOptionPane.showMessageDialog(null, scrollPane, "Saved Member Details", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
        }
    }
});

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 102, 204));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(160, 40));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void saveToFile() {
    try {
        FileWriter writer = new FileWriter("MemberDetails.txt");

        for (GymMember member : members) {
            writer.write("----- Member Info -----\n");
            writer.write("ID: " + member.getId() + "\n");
            writer.write("Name: " + member.getName() + "\n");
            writer.write("Location: " + member.getLocation() + "\n");
            writer.write("Phone: " + member.getPhone() + "\n");
            writer.write("Email: " + member.getEmail() + "\n");
            writer.write("Membership Start Date: " + member.membershipStartDate + "\n");

            if (member instanceof RegularMember) {
                RegularMember rm = (RegularMember) member;
                writer.write("Plan: " + rm.getPlan() + "\n");
                writer.write("Price: " + (int) rm.getPrice() + "\n");
                writer.write("Attendance: " + rm.getAttendance() + "\n");
                writer.write("Loyalty Points: " + rm.getLoyaltyPoints() + "\n");
                writer.write("Active Status: " + rm.getActiveStatus() + "\n");
                writer.write("Full Payment: N/A\n");
                writer.write("Discount Amount: N/A\n");
                writer.write("Net Amount Paid: N/A\n");

            } else if (member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                writer.write("Plan: Premium\n");
                writer.write("Price: 50000\n");
                writer.write("Attendance: " + pm.getAttendance() + "\n");
                writer.write("Loyalty Points: " + pm.getLoyaltyPoints() + "\n");
                writer.write("Active Status: " + pm.getActiveStatus() + "\n");
                writer.write("Full Payment: " + pm.getIsFullPayment() + "\n");
                writer.write("Discount Amount: " + pm.getDiscountAmount() + "\n");
                writer.write("Net Amount Paid: " + pm.getPaidAmount() + "\n");
            }

            writer.write("\n"); 
        }

        writer.close();
        JOptionPane.showMessageDialog(null, "Member details saved successfully to MemberDetails.txt");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String[] args) {
        new GymGUI();
    }
}
