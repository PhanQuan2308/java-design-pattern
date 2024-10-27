package factoryPattern;

// + Factory Pattern để tạo ra nhiều instance của một class, nhưng mỗi instance không liên quan đến nhau và có thể thuộc các loại khác nhau.
// + Bên trong co cac methob abstract
// + Cách thức triển khai:
//                          - Tạo một interface hoặc abstract class chứa phương thức makeSound().
//                          - Các subclass sẽ implement phương thức này để tạo ra các đối tượng cụ thể của sản phẩm.
// + Ví dụ: - Khi ban tao 1 interface sau do abstract class se goi interface do, sau do nhung thang con ke thua no abstractclass se phai trien khai cac methob cua interface.

// Interface chung cho các loài động vật
interface Animal {
    void makeSound();
}

// Concrete Animal: Dog (4 chân)
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof!");
    }
}

// Concrete Animal: Cat (4 chân)
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat says: Meow!");
    }
}

// Concrete Animal: Bird (2 chân)
class Bird implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bird says: Tweet!");
    }
}

// Abstract Factory Class
abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

// Concrete Factory cho Dog
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

// Concrete Factory cho Cat
class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// Concrete Factory cho Bird
class BirdFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Bird();
    }
}

// Demo class
public class AnimalFactoryPatternDemo {
    public static void main(String[] args) {
        // Factory cho Dog
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();  // Output: Dog says: Woof!

        // Factory cho Cat
        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();  // Output: Cat says: Meow!

        // Factory cho Bird
        AnimalFactory birdFactory = new BirdFactory();
        Animal bird = birdFactory.createAnimal();
        bird.makeSound();  // Output: Bird says: Tweet!
    }
}

