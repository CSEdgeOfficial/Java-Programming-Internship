import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;

    public Patient(String name, int age, String gender, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Address: " + address + ", Phone: " + phoneNumber;
    }
}

class HospitalManagementSystem {
    private List<Patient> patientRecords;
    private Map<Date, List<Patient>> appointmentSchedule;

    public HospitalManagementSystem() {
        patientRecords = new ArrayList<>();
        appointmentSchedule = new HashMap<>();
    }

    public void addPatientRecord(Patient patient) {
        patientRecords.add(patient);
    }

    public void scheduleAppointment(Date date, Patient patient) {
        appointmentSchedule.computeIfAbsent(date, k -> new ArrayList<>()).add(patient);
    }

    public void displayPatientRecords() {
        System.out.println("Patient Records:");
        for (Patient patient : patientRecords) {
            System.out.println(patient);
        }
    }

    public void displayAppointmentSchedule() {
        System.out.println("Appointment Schedule:");
        for (Map.Entry<Date, List<Patient>> entry : appointmentSchedule.entrySet()) {
            System.out.println("Date: " + entry.getKey());
            System.out.println("Patients:");
            for (Patient patient : entry.getValue()) {
                System.out.println(patient);
            }
            System.out.println();
        }
    }

    public Patient getPatientByName(String name) {
        for (Patient patient : patientRecords) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null;
    }
}

public class HospitalSystemDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem hospitalSystem = new HospitalManagementSystem();

        // Input patient records
        System.out.println("Enter patient information (name, age, gender, address, phone), type 'done' to finish:");
        while (true) {
            System.out.print("Patient name: ");
            String name = scanner.nextLine();
            if (name.equals("done")) break;
            System.out.print("Patient age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Patient gender: ");
            String gender = scanner.nextLine();
            System.out.print("Patient address: ");
            String address = scanner.nextLine();
            System.out.print("Patient phone number: ");
            String phoneNumber = scanner.nextLine();

            hospitalSystem.addPatientRecord(new Patient(name, age, gender, address, phoneNumber));
        }

        // Input appointment scheduling
        System.out.println("Enter appointment scheduling (date YYYY-MM-DD, patient name), type 'done' to finish:");
        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            String dateString = scanner.nextLine();
            if (dateString.equals("done")) break;
            System.out.print("Patient name: ");
            String patientName = scanner.nextLine();

            // Parse date
            Date date = parseDate(dateString);
            if (date != null) {
                Patient patient = hospitalSystem.getPatientByName(patientName);
                if (patient != null) {
                    hospitalSystem.scheduleAppointment(date, patient);
                } else {
                    System.out.println("Patient not found.");
                }
            } else {
                System.out.println("Invalid date format.");
            }
        }

        // Display patient records and appointment schedule
        hospitalSystem.displayPatientRecords();
        hospitalSystem.displayAppointmentSchedule();

        scanner.close();
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }
}
