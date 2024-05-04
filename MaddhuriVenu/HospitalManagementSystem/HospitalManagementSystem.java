import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Patient class to represent a patient
class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;

    public Patient(int patientId, String name, int age, String gender, String address, String phoneNumber) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Doctor class to represent a doctor
class Doctor {
    private int doctorId;
    private String name;
    private String specialization;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

// Appointment class to represent an appointment
class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date date;

    public Appointment(int appointmentId, int patientId, int doctorId, Date date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }
}

// Prescription class to represent a prescription
class Prescription {
    private int prescriptionId;
    private int patientId;
    private int doctorId;
    private String medication;
    private String dosage;

    public Prescription(int prescriptionId, int patientId, int doctorId, String medication, String dosage) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medication = medication;
        this.dosage = dosage;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }
}

// Billing class to represent billing information
class Billing {
    private int billId;
    private int patientId;
    private double amount;
    private Date date;

    public Billing(int billId, int patientId, double amount, Date date) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
    }

    public int getBillId() {
        return billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}

// InventoryItem class to represent an item in inventory
class InventoryItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private double price;

    public InventoryItem(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

// HospitalManagementSystem class to manage hospital operations
public class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;
    private List<Billing> bills;
    private List<InventoryItem> inventory;

    private int patientIdCounter;
    private int doctorIdCounter;
    private int appointmentIdCounter;
    private int prescriptionIdCounter;
    private int billIdCounter;
    private int itemIdCounter;

    public HospitalManagementSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.bills = new ArrayList<>();
        this.inventory = new ArrayList<>();

        this.patientIdCounter = 1000;
        this.doctorIdCounter = 2000;
        this.appointmentIdCounter = 3000;
        this.prescriptionIdCounter = 4000;
        this.billIdCounter = 5000;
        this.itemIdCounter = 6000;
    }

    // Method to add a patient
    public void addPatient(String name, int age, String gender, String address, String phoneNumber) {
        Patient patient = new Patient(patientIdCounter++, name, age, gender, address, phoneNumber);
        patients.add(patient);
    }

    // Method to add a doctor
    public void addDoctor(String name, String specialization) {
        Doctor doctor = new Doctor(doctorIdCounter++, name, specialization);
        doctors.add(doctor);
    }

    // Method to schedule an appointment
    public void scheduleAppointment(int patientId, int doctorId, Date date) {
        Appointment appointment = new Appointment(appointmentIdCounter++, patientId, doctorId, date);
        appointments.add(appointment);
    }

    // Method to prescribe medication
    public void prescribeMedication(int patientId, int doctorId, String medication, String dosage) {
        Prescription prescription = new Prescription(prescriptionIdCounter++, patientId, doctorId, medication, dosage);
        prescriptions.add(prescription);
    }

    // Method to generate a bill
    public void generateBill(int patientId, double amount, Date date) {
        Billing bill = new Billing(billIdCounter++, patientId, amount, date);
        bills.add(bill);
    }

    // Method to add an item to inventory
    public void addItemToInventory(String itemName, int quantity, double price) {
        InventoryItem item = new InventoryItem(itemIdCounter++, itemName, quantity, price);
        inventory.add(item);
    }

    // Method to display patient information
    public void displayPatientInfo() {
        System.out.println("Patient Information:");
        for (Patient patient : patients) {
            System.out.println("ID: " + patient.getPatientId() + ", Name: " + patient.getName() + ", Age: " + patient.getAge() +
                    ", Gender: " + patient.getGender() + ", Address: " + patient.getAddress() + ", Phone: " + patient.getPhoneNumber());
        }
    }

    // Method to display doctor information
    public void displayDoctorInfo() {
        System.out.println("Doctor Information:");
        for (Doctor doctor : doctors) {
            System.out.println("ID: " + doctor.getDoctorId() + ", Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
        }
    }

    // Method to display appointment information
    public void displayAppointmentInfo() {
        System.out.println("Appointment Information:");
        for (Appointment appointment : appointments) {
            System.out.println("ID: " + appointment.getAppointmentId() + ", Patient ID: " + appointment.getPatientId() +
                    ", Doctor ID: " + appointment.getDoctorId() + ", Date: " + appointment.getDate());
        }
    }

    // Method to display prescription information
    public void displayPrescriptionInfo() {
        System.out.println("Prescription Information:");
        for (Prescription prescription : prescriptions) {
            System.out.println("ID: " + prescription.getPrescriptionId() + ", Patient ID: " + prescription.getPatientId() +
                    ", Doctor ID: " + prescription.getDoctorId() + ", Medication: " + prescription.getMedication() +
                    ", Dosage: " + prescription.getDosage());
        }
    }

    // Method to display billing information
    public void displayBillingInfo() {
        System.out.println("Billing Information:");
        for (Billing bill : bills) {
            System.out.println("ID: " + bill.getBillId() + ", Patient ID: " + bill.getPatientId() +
                    ", Amount: " + bill.getAmount() + ", Date: " + bill.getDate());
        }
    }

    // Method to display inventory information
    public void displayInventory() {
        System.out.println("Inventory Information:");
        for (InventoryItem item : inventory) {
            System.out.println("ID: " + item.getItemId() + ", Name: " + item.getItemName() +
                    ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        HospitalManagementSystem hospitalSystem = new HospitalManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Prescribe Medication");
            System.out.println("5. Generate Bill");
            System.out.println("6. Add Item to Inventory");
            System.out.println("7. Display Patient Information");
            System.out.println("8. Display Doctor Information");
            System.out.println("9. Display Appointment Information");
            System.out.println("10. Display Prescription Information");
            System.out.println("11. Display Billing Information");
            System.out.println("12. Display Inventory Information");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patient gender: ");
                    String patientGender = scanner.nextLine();
                    System.out.print("Enter patient address: ");
                    String patientAddress = scanner.nextLine();
                    System.out.print("Enter patient phone number: ");
                    String patientPhoneNumber = scanner.nextLine();
                    hospitalSystem.addPatient(patientName, patientAge, patientGender, patientAddress, patientPhoneNumber);
                    break;
                case 2:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String doctorSpecialization = scanner.nextLine();
                    hospitalSystem.addDoctor(doctorName, doctorSpecialization);
                    break;
                case 3:
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int doctorId = scanner.nextInt();
                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String dateString = scanner.next();
                    Date appointmentDate = null;
                    try {
                        appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                            continue; 
                    }
                    hospitalSystem.scheduleAppointment(patientId, doctorId, appointmentDate);
                    break;
                case 4:
                    System.out.print("Enter patient ID: ");
                    int patientIdPrescription = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int doctorIdPrescription = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter medication: ");
                    String medication = scanner.nextLine();
                    System.out.print("Enter dosage: ");
                    String dosage = scanner.nextLine();
                    hospitalSystem.prescribeMedication(patientIdPrescription, doctorIdPrescription, medication, dosage);
                    break;
                case 5:
                    System.out.print("Enter patient ID: ");
                    int patientIdBill = scanner.nextInt();
                    System.out.print("Enter bill amount: ");
                    double billAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter bill date (YYYY-MM-DD): ");
                    String billDateString = scanner.next();
                    Date billDate = null;
                    try {
                        billDate = new SimpleDateFormat("yyyy-MM-dd").parse(billDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                            continue; // Skip to next iteration of the loop
                    }
                    hospitalSystem.generateBill(patientIdBill, billAmount, billDate);
                    break;
                case 6:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    hospitalSystem.addItemToInventory(itemName, itemQuantity, itemPrice);
                    break;
                case 7:
                    hospitalSystem.displayPatientInfo();
                    break;
                case 8:
                    hospitalSystem.displayDoctorInfo();
                    break;
                case 9:
                    hospitalSystem.displayAppointmentInfo();
                    break;
                case 10:
                    hospitalSystem.displayPrescriptionInfo();
                    break;
                case 11:
                    hospitalSystem.displayBillingInfo();
                    break;
                case 12:
                    hospitalSystem.displayInventory();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 13.");
            }
        }
    }
}
