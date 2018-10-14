package com.company;

public class StaticTest {
    public static void main(String[] args) {
        // заполнить массив staff тремя объектами типа Employee
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tom", 40000, 1987, 10, 12);
        staff[1] = new Employee("Dick", 60000, 1987, 10, 12);
        staff[2] = new Employee("Harry", 65000, 1987, 10, 12);

        // вывести данные обо всех объектах типа Employee
        for (Employee e : staff)
        {
            e.setId();
            System.out.println("name=" + e.getName() + ",id="
                    + e.getId() + ",salary=" + e.getSalary());
        }

        int n = Employee.getNextId(); // вызвать статический метод
        System.out.println("Next available id=" + n);
    }
}
