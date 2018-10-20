package com.company;

import java.time.LocalDate;


public class SimpleClass {
    public static void main(String[] args)
    {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        // заполнить массив Staff тремя объектами типа Employee
        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

//        // поднять вмем работникам зарплату на 5%
//        for (Employee e : staff)
//            e.raiseSalary(5);
//
        // вывести данные обо всех объектах типа Employee
        for (Employee e : staff)
            System.out.println(e.getName() + " " + e.getSalary());
    }
}

class Employee {
    private static int nextId;

    private String name;
    private double salary;
    private int id;
    private LocalDate hireDay;

    // конструктор
    public Employee()
    {
        this("1");
    }

    public Employee(String n)
    {
        this(n,1,1,1,1);
    }

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        id = 0;
        hireDay = LocalDate.of(year, month, day);
        //System.out.print(name + ' '+salary+" "+ id+" "+hireDay);
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

class Manager extends Employee
{
    public Manager(String n, double s, int year, int month, int day)
    {
        super(n, s, year, month, day);
        bonus = 0;
    }

    private double bonus;

    public void setBonus(double b)
    {
        bonus = b;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
