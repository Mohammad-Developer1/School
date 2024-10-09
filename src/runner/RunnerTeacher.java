package runner;

import model.Teacher;
import util.ApplicationContext;

import java.util.Scanner;

public class RunnerTeacher {
    static Scanner sc = new Scanner(System.in);
    public static void Teacher() {
        System.out.println("1: Add Teacher");
        System.out.println("2: Remove Teacher");
        System.out.println("3: Update Teacher");
        System.out.println("4: Show All Teacher");
        System.out.println("5: return ");
        System.out.print("Enter your choice number: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addTeacher();
                Teacher();
                break;
            case 2:
                removeTeacher();
                Teacher();
                break;
            case 3:
                updateTeacher();
                Teacher();
                break;
            case 4:
                showAllTeacher();
                Teacher();
                break;
            case 5:
                Runner.admin();
        }


    }
    public static void addTeacher() {
        System.out.println("enter a first name:");
        String firstName = sc.nextLine();
        System.out.println("enter a last name:");
        String lastName = sc.nextLine();
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        Teacher teacher = new Teacher(firstName, lastName, nationalCode);
        try {
            ApplicationContext.getTeacherService().createTeacher(teacher);
            System.out.println("dune add teacher");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }
    }

    private static void removeTeacher() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        try {
            ApplicationContext.getTeacherService().removeTeacher(nationalCode);
            System.out.println("dune removed teacher");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }
    }

    public static void updateTeacher() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.nextLine();
        try {
            if (ApplicationContext.getTeacherService().getTeacherNationalCode(nationalCode) == null) {
                System.out.println("dune update teacher");
                return;
            }
            System.out.println("enter first name:");
            String firstName = sc.nextLine();
            System.out.println("enter last name:");
            String lastName = sc.nextLine();
            ApplicationContext.getTeacherService().updateTeacher(nationalCode, new Teacher(firstName, lastName, nationalCode));
            System.out.println("dune update teacher");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void showAllTeacher() {
        ApplicationContext.getTeacherService().printAllTeacherList();
    }

    public static void showMyTeacher() {
        ApplicationContext.getTeacherService().showMyTeacher();
    }




}
