package Inheritance;

public class ManagerTest {
    public static void main(String[] args)
    {
        // построить объект типа Manager
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        // заполнить массив staff объектами типа Manager и Employee
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        Employee boss1;
        if (staff[1] instanceof Manager)
        {
            boss1 = (Manager) staff[1];
        }

        // вывести данные обо всех объектах типа Employee
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
