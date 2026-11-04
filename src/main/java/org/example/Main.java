package org.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void processStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) { // Тут удаляем студентов у кого средний бал < 3
                iterator.remove();
            } else {
                student.incrementCourse(); // Иначе если > 3, то переводим на следующий курс
            }
        }
    }
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("СПИСОК СТУДЕНТОВ ПРОШЕДШИХ НА " + course + " КУРС");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("* " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("НА ДАННОМ КУРСЕ НЕТ СТУДЕНТОВ");
        }
    }

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();

        studentSet.add(new Student("Антон Демидов", "№ 1", 1, Arrays.asList(2, 3, 2, 3)));
        studentSet.add(new Student("Валерий Дроздов", "№ 2", 3, Arrays.asList(3, 4, 4, 3)));
        studentSet.add(new Student("Геннадий Горин", "№ 3", 1, Arrays.asList(4, 4, 5, 5)));
        studentSet.add(new Student("Максим Северов", "№ 4", 2, Arrays.asList(4, 5, 5, 5)));
        studentSet.add(new Student("Семен Семенов", "№ 5", 5, Arrays.asList(5, 5, 5, 5)));

        System.out.println("СПИСОК СТУДЕНТОВ ДО ПОДСЧЕТА");
        for (Student s : studentSet) {
            System.out.println(s);
        }

        processStudents(studentSet);

        System.out.println("СПИСОК СТУДЕНТОВ ПОСЛЕ ПОДСЧЕТА");
        for (Student s : studentSet) {
            System.out.println(s);
        }

        System.out.println();
        printStudents(studentSet, 2);
    }
}