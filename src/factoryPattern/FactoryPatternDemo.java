package factoryPattern;

// + Factory Pattern để tạo ra nhiều instance của một class, nhưng mỗi instance không liên quan đến nhau và có thể thuộc các loại khác nhau.
// + Bên trong co cac methob abstract
// + Cách thức triển khai:
//                          - Tạo một interface hoặc abstract class chứa phương thức createProduct().
//                          - Các subclass sẽ implement phương thức này để tạo ra các đối tượng cụ thể của sản phẩm.
// + Ví dụ: - Khi ban tao 1 interface sau do abstract class se goi interface do, sau do nhung thang con ke thua no abstractclass se phai trien khai cac methob cua interface
//          - Muc dich: khi tao product moi thi chi can tao concreateProduct sau do la productfactory ke thua la duoc

// Interface chung cho các sản phẩm
interface Product {
    void use();
}

// Concrete Product 1
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// Concrete Product 2
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// Factory Class
abstract class ProductFactory {
    // Factory Method
    public abstract Product createProduct();
}

// Concrete Factory 1
class ProductAFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

// Concrete Factory 2
class ProductBFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// Demo class
public class FactoryPatternDemo {
    public static void main(String[] args) {
        // Factory cho sản phẩm A
        ProductFactory factoryA = new ProductAFactory();
        Product productA = factoryA.createProduct();
        productA.use();  // In ra: Using Product A

        // Factory cho sản phẩm B
        ProductFactory factoryB = new ProductBFactory();
        Product productB = factoryB.createProduct();
        productB.use();  // In ra: Using Product B
    }
}
