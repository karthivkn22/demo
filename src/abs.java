public abstract class abs {
        public abstract void display();

}
// Abstract class
abstract class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be implemented by subclasses)
    abstract void makeSound();

    // Concrete method
    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}



class A1 extends abs {
    public static void main(String[] args) {
        A1 m = new A1();
        m.display();
    }

    @Override
    public void display() {
        System.out.println("Hello from the abstract class!");

        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Kitty");

        dog.makeSound(); // Buddy says: Woof Woof!
        dog.sleep();     // Buddy is sleeping...

        cat.makeSound(); // Kitty says: Meow!
        cat.sleep();     // Kitty is sleeping..
    }
}
