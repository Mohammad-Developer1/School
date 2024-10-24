package runner;

import util.ApplicationContext;
import util.Utility;

import java.util.Scanner;

public class Runner {
    static Scanner sc = new Scanner(System.in);

    public static void run() {

        System.out.println("1: Admin");
        System.out.println("2: sing in");
        System.out.println("3: sing up");
        System.out.println("4: Exit");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                adminUserPass();
                break;
            case 2:
                signInStAndTe();
                break;
            case 3:
                signUpStAndTe();
                break;
            case 4:
                return;
        }


    }

    public static void admin() {
        System.out.println("1: Student");
        System.out.println("2: Teacher");
        System.out.println("3: Course");
        System.out.println("4: Exam");
        System.out.println("5: Exit");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                RunnerStudent.Student();
                break;
            case 2:
                RunnerTeacher.Teacher();
                break;
            case 3:
                RunnerCourse.Course();
                break;
            case 4:
                RunnerExam.Exam();
            case 5:
                run();
        }
    }

    private static void adminUserPass() {
        try {
            System.out.println("\u001B[34m"+"enter your username:");
            String username = sc.next();
            System.out.println("\u001B[34m"+"enter your password:");
            String password = sc.next();
            Utility.generateRandomCode();
            if (ApplicationContext.getAdminService().login(username, password)) {
                System.out.println("\u001B[34m"+"Admin sign in success");
                System.out.print("\033[0m");
                admin();
            }else {
                System.out.println("\u001B[37m"+"**"+"\u001B[31m"+"Password or username is wrong"+"\u001B[37m"+"**");
                System.out.print("\033[0m");
                run();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }


    private static void signInStAndTe() {

        System.out.println("****welcome****");
        System.out.println("1 - student sing in");
        System.out.println("2 - teacher sing in");
        System.out.println("3 - exit");
        System.out.println("enter a number");
        int number = sc.nextInt();

        switch (number) {
            case 1:
                signInStudent();

                break;
            case 2:
                signInTeacher();
                break;
            case 3:
                run();
        }
    }

    private static void signUpStAndTe() {

        System.out.println("****welcome****");
        System.out.println("1 - student sing up");
        System.out.println("2 - teacher sing up");
        System.out.println("3 - exit");
        System.out.println("enter a number");
        int number = sc.nextInt();

        switch (number) {
            case 1:
                RunnerStudent.addStudent();
                break;
            case 2:
                RunnerTeacher.addTeacher();
                break;
            case 3:
                return;
        }
    }

    private static void signInStudent() {
        try {
            System.out.println("enter student id: ");
            int id = sc.nextInt();
            System.out.println("enter national code: ");
            String nationalCode = sc.nextLine();
            nationalCode = (sc.nextLine());
            Utility.generateRandomCode();
            if (ApplicationContext.getStudentService().signInStudent(id, nationalCode)) {
                System.out.println("student sign in success");
                student();
            }else {
                System.out.println("\u001B[31m"+"id or national Code is wrong");
                System.out.print("\033[0m");
                signInStudent();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void student() {

        System.out.println("1 - add courses");
        System.out.println("2 - remove courses");
        System.out.println("3 - Show All courses");
        System.out.println("4 - show My courses");
        System.out.println("5 - edit information");
        System.out.println("6 - ShowMyReportCard");
        System.out.println("7 - return to last page");
        System.out.println("enter a number");
        int number = sc.nextInt();
        switch (number) {
            case 1:
                RunnerStudent.addCourseStudent();
                student();
                break;
            case 2:
                RunnerStudent.removeCourseStudent();
                student();
                break;
            case 3:
                RunnerCourse.showAllCourse();
                student();
                break;
            case 4:
                RunnerStudent.showMyCourse();
                student();
                break;
            case 5:
                RunnerStudent.updateStudent();
                student();
                break;
            case 6:
                RunnerStudent.ShowMyReportCard();
                student();
            case 7:
                signInStAndTe();
        }

    }

    public static void teacher() {

        System.out.println("1 - show My Students");
        System.out.println("2 - Grading the student ");
        System.out.println("3 - edit information");
        System.out.println("4 - show My information");
        System.out.println("5 - add Exam");
        System.out.println("6 - return to last page");
        System.out.println("enter a number");
        int number = sc.nextInt();
        switch (number) {
            case 1:
                RunnerTeacher.showMyStudent();
                teacher();
            case 2:
                RunnerTeacher.addScore();
                teacher();
            case 3:
                RunnerTeacher.updateTeacher();
                teacher();
                case 4:
                RunnerTeacher.showMyInformation();
                teacher();
            case 5:
                RunnerTeacher.addExam();
                teacher();
            case 6:
                signInStAndTe();
        }
    }


    private static void signInTeacher() {
        try {
            System.out.println("enter teacher id: ");
            int id = sc.nextInt();
            System.out.println("enter national code: ");
            String nationalCode = sc.nextLine();
            nationalCode = (sc.nextLine());
            if (ApplicationContext.getTeacherService().signInTeacher(id, nationalCode)) {
                System.out.println("teacher sign in success");
                teacher();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
