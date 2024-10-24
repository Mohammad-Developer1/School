package runner;

import model.Exam;
import model.Teacher;
import model.dto.StudentDto;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.time.LocalTime;
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
        System.out.println("enter a birth date:");
        String birthDate = sc.nextLine();
        int year = Integer.parseInt(birthDate.substring(0, 4));
        int month = Integer.parseInt(birthDate.substring(5, 7));
        int day = Integer.parseInt(birthDate.substring(8, 10));
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        System.out.println("enter a course id");
        int courseId = sc.nextInt();
        Teacher teacher = new Teacher(firstName, lastName, LocalDate.of(year,month,day),nationalCode,courseId);
        try {
            ApplicationContext.getTeacherService().add(teacher);
            System.out.println("dune add teacher");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }
    }

    private static void removeTeacher() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        try {
            ApplicationContext.getTeacherService().remove(nationalCode);
            System.out.println("dune removed teacher");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }
    }

    public static void updateTeacher() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.nextLine();
        try {
            if (ApplicationContext.getTeacherService().getNationalCode(nationalCode) == null) {
                System.out.println("dune update teacher");
                return;
            }
            System.out.println("enter first name:");
            String firstName = sc.nextLine();
            System.out.println("enter last name:");
            String lastName = sc.nextLine();
            ApplicationContext.getTeacherService().update(nationalCode, new Teacher(firstName, lastName, nationalCode));
            System.out.println("dune update teacher");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void showAllTeacher() {
        ApplicationContext.getTeacherService().printAllList();
    }


    public static void showMyStudent() {
        ApplicationContext.getTeacherService().printAllStudent();
    }

    public static void addScore(){
        try {
            System.out.println("enter a score:");
            double score = sc.nextDouble();
            System.out.println("enter national code");
            String nationalCode = sc.nextLine();
            nationalCode = (sc.nextLine());
            ApplicationContext.getTeacherService().addScore(nationalCode,SecurityContext.teacher.getCourseID(),score);
            System.out.println("dune add score");
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static void showMyInformation(){
        try {

            Teacher teacher=ApplicationContext.getTeacherService().getNationalCode(SecurityContext.teacher.getNationalCode()).get();
            System.out.format("\033[1;35m"+"+------+--------------+--------------+---------------+%n");
            System.out.format("\033[1;35m"+"| ID   | first name   | last name    | national code |%n");
            System.out.format("\033[1;35m"+"+------+--------------+--------------+---------------+%n");
                 System.out.printf("\033[1;35m"+"|"+"\033[1;34m"+" %-4s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-12s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-12s"+"\033[1;35m"+" |"+"\033[1;34m"+"\033[1;34m"+" %-14s"+"\033[1;35m"+"|"+"\n",
                        teacher.getTeacherId(),
                        teacher.getFirstName(),
                        teacher.getLastName(),
                        teacher.getNationalCode());
            System.out.format("\033[1;35m"+"+------+--------------+--------------+---------------+%n");
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("\033[0m");
    }
    public static void addExam() {
        System.out.println("enter a Name:");
        String name = sc.nextLine();
        System.out.println("enter a Date (2000-01-01): ");
        String date = sc.nextLine();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        System.out.println("enter a Time (12:30): ");
        String time = sc.nextLine();
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        try {
            ApplicationContext.getExamService().addExam(new Exam( name, LocalDate.of(year,month,day), LocalTime.of(hour,minute),SecurityContext.teacher.getCourseID()));
            System.out.println("dune added exam");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
