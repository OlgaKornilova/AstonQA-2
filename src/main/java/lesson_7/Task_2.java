package lesson_7;

    interface Shape {
        double calculatePerimeter(); //Метод для рассчета периметра фигуры
        double calculateArea(); //Метод для рассчета площади фигуры
        String getFillColor(); //Метод для получения цвета заливки фигуры
        String getBorderColor(); //Метод для получения цвета границы фигуры

        //Метод для вывода информации о фигуре
        default void printDetails() {
            System.out.println("Perimeter: " + calculatePerimeter());
            System.out.println("Area: " + calculateArea());
            System.out.println("Fill color: " + getFillColor());
            System.out.println("Border color: " + getBorderColor());
        }
    }

    // Класс Circle, реализующий интерфейс Shape
    class Circle implements Shape {
        private double radius; //Радиус
        private String fillColor; //Цвет заливки
        private String borderColor; //Цвет границы

        // Конструктор для создания круга с заданными параметрами
        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        // Метод для расчёта периметра круга
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        // Метод для расчёта площади круга
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        // Метод для получения цвета заливки
        @Override
        public String getFillColor() {
            return fillColor;
        }

        // Метод для получения цвета границы
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Класс Rectangle, реализующий интерфейс Shape
    class Rectangle implements Shape {
        private double width; // Ширина
        private double height; //Высота
        private String fillColor; // Цвет заливки
        private String borderColor; //Цвет границы


        // Конструктор для создания прямоугольника с заданными параметрами
        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        // Метод для расчёта периметра прямоугольника
        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        // Метод для расчёта площади прямоугольника
        @Override
        public double calculateArea() {
            return width * height;
        }

        // Метод для получения цвета заливки
        @Override
        public String getFillColor() {
            return fillColor;
        }

        // Метод для получения цвета границы
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Класс Triangle, реализующий интерфейс Shape
    class Triangle implements Shape {
        private double a, b, c; // стороны треугольника
        private String fillColor; //Цвет заливки
        private String borderColor; //Цвет границы

        // Конструктор для создания треугольника с заданными параметрами
        public Triangle(double a, double b, double c, String fillColor, String borderColor) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        // Метод для расчёта периметра треугольника
        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }

        // Метод для расчёта площади треугольника
        @Override
        public double calculateArea() {
            double s = calculatePerimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        // Метод для получения цвета заливки
        @Override
        public String getFillColor() {
            return fillColor;
        }

        // Метод для получения цвета границы
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

// Класс выполнения программы
public class Task_2 {
    public static void runTask() {
        Circle circle = new Circle(10, "Blue", "Black");
        Rectangle rectangle = new Rectangle(5, 10, "Red", "Black");
        Triangle triangle = new Triangle(5, 10, 15, "Red", "Black");

        System.out.println("Circle Details:");
        circle.printDetails();
        System.out.println("Rectangle Details:");
        rectangle.printDetails();
        System.out.println("Triangle Details:");
        triangle.printDetails();
    }
}



