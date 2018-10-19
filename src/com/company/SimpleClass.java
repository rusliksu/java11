package com.company;

import java.time.LocalDate;


public class SimpleClass {
    public static void main(String[] args)
    {
        // заполнить массив Staff тремя объектами типа Employee
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // поднять вмем работникам зарплату на 5%
        for (Employee e : staff)
            e.raiseSalary(5);

        // вывести данные обо всех объектах типа Employee
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
}

class Employee {
    private static int nextId;

    private String name;
    private double salary;
    private int id;
    private LocalDate hireDay;

    // конструктор
    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        id = 0;
        hireDay = LocalDate.of(year, month, day);
    }

    // метод
    public  String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId() { return id; }

    public void setId() {
        id = nextId; // установить следующий доступный идентификатор
        nextId++;
    }

    public static int getNextId()
    {
        return nextId; // возратить статическое поле
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static void main(String[] args) // выполнить модульный тест
    {
        Employee e = new Employee("Harry", 50000, 1987, 12, 1);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
