package Main;

import DAO.*;
import Entities.*;
import Enum.StatusConsultation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final ClientDAO CLIENT_DAO = new ClientDAO();
    private static final PetDAO PET_DAO = new PetDAO();
    private static final VetDAO VET_DAO = new VetDAO();
    private static final ConsultationDAO CONSULTATION_DAO = new ConsultationDAO();
    private static final MedicalRecodDAO MEDICAL_RECOD_DAO = new MedicalRecodDAO();
    public static void main(String[] args) {
        firstMenu();
    }

    public static void firstMenu() {
        while (true){
            System.out.println("""
                    === CliniVet ===
                    1. Register Client
                    2. Register Pet
                    3. Register Vet
                    4. Appointment scheduling
                    5. Diagnostics log
                    6. Financial and operational reports
                    7. Exit
                    Insert: 
                    """);
            int option = SC.nextInt();
            switch (option){
                case 1:
                  registerCliet();
                  break;
                case 2:
                    registerPet();
                    break;
                case 3:
                    registerVet();
                case 4:
                    appointmentScheduling();
                case 5:
                    diagnosticsLog();
                    break;
                case 6:
                    financialAndOperationReports();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static void registerVet() {
        System.out.println("=== Register Vet ===");
        System.out.println("Name: ");
        SC.nextLine();
        String name = SC.nextLine();
        System.out.println("CRMV: ");
        String crmv = SC.nextLine();
        System.out.println("Specialty: ");
        String specialty = SC.nextLine();
        VET_DAO.insertVet(
                new Vet(
                        name,
                        crmv,
                        specialty
                )
        );

    }

    public static void registerCliet(){
        System.out.println("=== Register Client ===");
        System.out.println("Name: ");
        SC.nextLine();
        String name = SC.nextLine();
        System.out.println("CPF: ");
        String cpf = SC.nextLine();
        System.out.println("Telephone: ");
        String telephone = SC.nextLine();
        System.out.println("City: ");
        String city = SC.nextLine();
        System.out.println("State: ");
        String state = SC.nextLine();
        CLIENT_DAO.insertClient(
                new Client(
                        name,
                        cpf,
                        telephone,
                        city,
                        state
                )
        );
    }
    public static void registerPet(){
        System.out.println("=== Register Pet ===");
        showClients();
        System.out.println("Client ID: ");
        int client_id = SC.nextInt();
        System.out.println("Name: ");
        SC.nextLine();
        String name = SC.nextLine();
        System.out.println("Specie: ");
        String specie = SC.nextLine();
        System.out.println("Race: ");
        String race = SC.nextLine();
        System.out.println("Date of Birth (dd/MM/yyyy): ");
        String dateOfBirthText = SC.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthText, formatter);
        System.out.println("Date: " + dateOfBirth);
        PET_DAO.insertPet(
                new Pet(
                        client_id,
                        name,
                        specie,
                        race,
                        dateOfBirth
                )
        );


    }
    public static void appointmentScheduling(){
        showPets();
        System.out.println("Pet ID: ");
        int id_pet = SC.nextInt();
        showVets();
        System.out.println("Vet ID: ");
        int id_Vet = SC.nextInt();
        System.out.println("Date of Consultation(dd/MM/yyyy) : ");
        SC.nextLine();
        String dateOfConsultationtxt = SC.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfConsultation = LocalDate.parse(dateOfConsultationtxt, formatter);
        System.out.println("Price: ");
        double value = SC.nextDouble();
        int i = 0;
        for(StatusConsultation e : StatusConsultation.values()){
            System.out.println(i + " - " + e);
            i++;
        }
        System.out.println("Status: (Insert the number) ");
        int getEnum = SC.nextInt();
        StatusConsultation statusChoose = StatusConsultation.values()[getEnum];
        String status = statusChoose.name();
        CONSULTATION_DAO.insertConsultation(
                new Consultation(
                        id_pet,
                        id_Vet,
                        dateOfConsultation,
                        value,
                        status
                )
        );
    }
    public static void diagnosticsLog(){
        showConsultations();
        System.out.println("Consultation ID: ");
        int consultation_id = SC.nextInt();
        System.out.println("Description: ");
        SC.nextLine();
        String description = SC.nextLine();
        System.out.println("Prescription: ");
        String prescription = SC.nextLine();
        System.out.println("Date of register(dd/MM/yyyy) : ");
        String dateOfregistertxt = SC.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfConsultation = LocalDate.parse(dateOfregistertxt, formatter);
        MEDICAL_RECOD_DAO.insertMedicalRecord(
                new MedicalRecord(
                        consultation_id,
                        description,
                        prescription,
                        dateOfConsultation
                )
        );
    }
    public static void financialAndOperationReports() {

    }

    public static void showClients(){
        ArrayList<Client> listClient = CLIENT_DAO.selectAllClients();
        if(listClient.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        System.out.println("=== List Client ===");
        for(Client client : listClient){
            System.out.println(client);
        }
        System.out.println("=== End of List Client ===");
    }
    public static void showPets(){
        ArrayList<Pet> listPet = PET_DAO.selectPet();
        if(listPet.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        System.out.println("=== List Pet ===");
        for(Pet pet : listPet){
            System.out.println(pet);
        }
        System.out.println("=== End of List Pet ===");
    }
    public static void showVets(){
        ArrayList<Vet> listVet = VET_DAO.selectVet();
        if(listVet.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        System.out.println("=== List Vet ===");
        for(Vet vet : listVet){
            System.out.println(vet);
        }
    }

    public static void showConsultations(){
        ArrayList<Consultation> listConsultation = CONSULTATION_DAO.selectConsultation();
        if(listConsultation.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        System.out.println("=== List Consultation ===");
        for(Consultation consultation : listConsultation){
            System.out.println(consultation);
        }
    }

}
