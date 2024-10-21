package factoryPattern;

public class CreateProductB implements Product{

    @Override
    public void use(){
        System.out.printf("Using product B");
    }
}
