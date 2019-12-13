package ir.mctab.java32.projects.scholarshipmanagement;

import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.impl.LoginUseCaseImpl;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.usecases.LoginUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.model.Scholarship;
import ir.mctab.java32.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class ScholarshipManagementApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String command = "";
        while (! command.equals("exit")) {
            System.out.println("what do you want? ");
            command = scanner.nextLine();
            // Login
            if (command.equals("login")) {
                System.out.println("Username : ");
                String username = scanner.nextLine();
                System.out.println("Password : ");
                String password = scanner.nextLine();
                LoginUseCase loginUseCase = new LoginUseCaseImpl();
                User user = loginUseCase.login(username, password);
                if (user != null) {
                    System.out.println(" Login successful by " + user.getRole());
                }
            }
            //request by student
            if (command.equals("request"))
            {
                System.out.println("name : ");
                String name = scanner.nextLine();
                System.out.println("family : ");
                String family = scanner.nextLine();
                System.out.println("nation code : ");
                String nationCode = scanner.nextLine();
                System.out.println("last uni : ");
                String lastUni = scanner.nextLine();
                System.out.println("last degree : ");
                String  lastDegree = scanner.nextLine();
                System.out.println("last field : ");
                String lastField = scanner.nextLine();
                System.out.println("last score : ");
                Float lastScore = scan.nextFloat();
                System.out.println("apply uni : ");
                String uni = scanner.nextLine();
                System.out.println("apply degree : ");
                String degree = scanner.nextLine();
                System.out.println("apply field : ");
                String field = scanner.nextLine();
                System.out.println("apply date : ");
                String date = scanner.nextLine();
                String status = "RequestedByStudent";
                Scholarship scholarship = new Scholarship(null,status,name,family,nationCode,lastUni,lastDegree,lastField,lastScore,uni,degree,field,date);
                RequestScholarshipByStudentUseCase requestScholarshipByStudentUseCase = new RequestScholarshipByStudentUseCaseImpl();
                requestScholarshipByStudentUseCase.request(scholarship);
            }
            // find scholarship by supervisor
            if (command.equals("svlist")) {
                FindScholarshipBySupervisorUseCase findScholarshipBySupervisorUseCase
                        = new FindScholarshipBySupervisorUseCaseImpl();

                List<Scholarship> scholarships = findScholarshipBySupervisorUseCase
                        .listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }

            // accept
            if (command.equals("svaccept")) {
                AcceptScholarshipBySupervisorUseCase acceptScholarshipBySupervisorUseCase
                        = new AcceptScholarshipBySupervisorUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipBySupervisorUseCase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("svreject"))
            {
                RejectScholarshipBySupervisorUseCase rejectScholarshipBySupervisorUseCase
                        = new RejectScholarshipBySupervisorUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipBySupervisorUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if(command.equals("malist"))
            {
                FindScholarshipByManagerUseCase findScholarshipByManagerUseCase = new FindScholarshipByManagerUseCaseImpl();
                List<Scholarship> scholarships = findScholarshipByManagerUseCase.listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
            if(command.equals("maaccept"))
            {
                AcceptScholarshipByManagerUseCase acceptScholarshipByManagerUseCase = new AcceptScholarshipByManagerUseCaseImpl();
                System.out.println("Scholarship Id : ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipByManagerUseCase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");

            }
            if (command.equals("mareject"))
            {
                RejectScholarshipByManagerUseCase rejectScholarshipByManagerUseCase
                        = new RejectScholarshipByManagerUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipByManagerUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            if (command.equals("unilist"))
            {
                FindScholarshipByUniversityUseCase findScholarshipByUniversityUseCase = new FindScholarshipByUniversityUseCaseImpl();
                List<Scholarship> scholarships = findScholarshipByUniversityUseCase.listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
        }
    }
}
