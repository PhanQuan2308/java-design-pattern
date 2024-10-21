package signleton;

// + Dam bao 1 class co 1 instance duy nhat, duoc su dung khi ban can 1 doi tuong duy nhat de dieu khien toan bo trang thai hoac dieu khien 1 phan cua chuong trinh.
// + cach trien khai: - 1. Dat constructor la duy private,
//                    - 2. Tao 1 method de cung cap cach truy cap toi instance duy nhat cua class
//                    - 3. Dam bao instance duoc tao ra 1 lan duy nhat.
//
// + Uu diem va nhuoc diem: - Tiet kiem bo nho, de bao tri, kiem soat truy cap
//                          - Kho khan khi mo rong, kiem soat.

// + Vi du thuc te: -

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonExample {
    private static SingletonExample instance;
    private Connection connection;

    private SingletonExample() {
        try {
            System.out.printf("Creating new Database Connection");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/signleton", "root", "");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static SingletonExample getInstance() {
        if(instance == null){
            instance = new SingletonExample();
        }
            return instance;

    }

    public Connection getConnection() {
        return connection;
    }


    public static void main(String[] args) {
        SingletonExample singletonExample1 = SingletonExample.getInstance();
        SingletonExample singletonExample2 = SingletonExample.getInstance();

        if(singletonExample1 == singletonExample2){
            System.out.println("singletonExample1 and SingletonExample2 are the same");
        }
        else {
            System.out.println("singletonExample1 and SingletonExample2 are not the same");
        }
    }
}
