package lesson_7;

// Создаем основной класс Animal
abstract class Animal {
    protected String name;
    public static int numberOfAnimals = 0;

    public Animal(String name) {
        this.name = name;
        numberOfAnimals++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}

// Создаем класс Cat, который наследуется от Animal
class Cat extends Animal {
    private boolean isFull;
    public static int numberOfCats = 0;

    public Cat(String name) {
        super(name);
        isFull = false;
        numberOfCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " побежал " + distance + " метров.");
        } else {
            System.out.println(name + " cне может пробежать больше 200 метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.takeFood(amount)) {
            isFull = true;
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

// Создааем класс Dog, который наследуется от Animal
class Dog extends Animal {
    public static int numberOfDogs = 0;

    public Dog(String name) {
        super(name);
        numberOfDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " метров.");
        } else {
            System.out.println(name + " не может пробежать больше 500 метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " метров.");
        } else {
            System.out.println(name + " не может проплыть больше 10 метров.");
        }
    }
}

// Класс Bowl (Миска)
class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean takeFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        food += amount;
    }

}

public class Task_1 {
    public static void runTask() {
        Dog[] dogs = {new Dog("Bobik"), new Dog("Sharik")};
        Cat[] cats = {new Cat("Kuzya"), new Cat("Barsik"), new Cat("Tom") };

        System.out.println("Количество собак: " + Dog.numberOfDogs);
        System.out.println("Количество кошек: " + Cat.numberOfCats);
        System.out.println("Количество животных всего: " + Animal.numberOfAnimals);

        for (Dog dog : dogs) {
            dog.run(500);  // Задаем дистанцию забега для собак
            dog.swim(10);  // Задаем дистанцию заплыва для собак
        }

        for (Cat cat : cats) {
            cat.run(200);  // Задаем дистанцию забега для кошек
            cat.swim(10);   // Задаем дистанцию заплыва для кошек
        }




        Bowl bowl = new Bowl(11);  // Создаем миску с 20 единицами еды
        for (Cat cat : cats) {
            cat.eat(bowl, 5);  // Каждый кот пытается съесть 5 единиц еды
            System.out.println(cat.name + " сытость: " + cat.isFull());
        }

        bowl.addFood(10);  // Добавляем в миску еще 10 единиц еды

    }
}