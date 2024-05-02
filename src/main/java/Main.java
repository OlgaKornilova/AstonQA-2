import java.math.BigDecimal;

public class Main {
    //Задание 1
    public static class Employee {

        // Поля класса
        private String fullName;
        private String position;
        private String email;
        private String phone;
        private BigDecimal salary;
        private int age;

        //Конструктор класса
        public Employee(String fullName, String position, String email, String phone, BigDecimal salary, int age) {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        //Вывод информации о сотруднике
        public void printInfo() {
            System.out.println("Сотрудник: " + fullName);
            System.out.println("Должность: " + position);
            System.out.println("Email: " + email);
            System.out.println("Телефон: " + phone);
            System.out.println("Зарплата: " + salary);
            System.out.println("Возраст: " + age);
        }

        public static void main(String[] args) {
            Employee employee = new Employee("Анна Ивановна Петрова",
                    "Менеджер по продажам", "anna.petrova@example.com",
                    "+71234567890", new BigDecimal("45000.00"), 28);
            employee.printInfo();
        }
    }

    //Задание 2
    public static void main(String[] args) {
        Person[] persArray = new Person[5];

//Создаем массив сотрудников
        persArray[0] = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Analyst",
                "petrov@mailbox.com", "891231231", 40000, 31);
        persArray[2] = new Person("Danilov Daniil", "Developer",
                "danilov@mailbox.com", "893213213", 50000, 32);
        persArray[3] = new Person("Makarov Makar", "Programmer",
                "makarov@mailbox.com", "891234123", 60000, 33);
        persArray[4] = new Person("Sergeev Sergey", "Designer",
                "sergeev@mailbox.com", "894321432", 70000, 34);

//Вывод информации о каждом сотруднике
        for (Person employee : persArray) {
            employee.printInfo();
            System.out.println();
        }
    }

    // Поля класса
    public static class Person {
        private String name;
        private String position;
        private String email;
        private String phone;
        private double salary;
        private int age;

        //Конструктор класса
        public Person(String name, String position, String email, String phone, double salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        //Вывод информации на экран
        public void printInfo() {
            System.out.println("Name: " + name);
            System.out.println("Position: " + position);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Salary: " + salary);
            System.out.println("Age: " + age);
        }
    }

    //Задание 3
    public static class Park {

        //Поля классса с данными об атракцонах
        public class Attraction {
            private String name;
            private String workingHours;
            private double cost;

            //Конструктор класса
            public Attraction(String name, String workingHours, double cost) {
                this.name = name;
                this.workingHours = workingHours;
                this.cost = cost;
            }

            //Вывод информации об атракционах на экран
            public void displayInfo() {
                System.out.println("Атракцон: " + name);
                System.out.println("Часы работы: " + workingHours);
                System.out.println("Цена: Р " + cost);
            }
        }

        public static void main(String[] args) {
            Park park = new Park();
            Attraction rollerCoaster = park.new Attraction("Американские горки", "10:00 до 21:00 ", 10.00);
            Attraction merryGoRound = park.new Attraction("Колесо обозрения", "10:00 до 21:00 ", 15.00);

            rollerCoaster.displayInfo();
            System.out.println();
            merryGoRound.displayInfo();
        }
    }

}
