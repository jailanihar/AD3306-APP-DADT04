public class IntroOOP {
    public static void main(String[] args) {
        System.out.println("Intro to OOP");
        // String[] licensePlates = new String[5];
        // String[] brands = new String[5];
        // String[] models = new String[5];
        // for(int i = 0; i < licensePlates.length; i++) {
        //     System.out.println(licensePlates[i]);
        // }
        Car car1 = new Car();
        Car car2 = new Car();
        car1.licensePlate = "KM1234";
        car1.brand = "Toyota";
        car1.model = "Wigo";
        car2.licensePlate = "BAA9754";
        System.out.println(car1.licensePlate + " " + car1.brand);
        System.out.println(car2.licensePlate + " " + car2.brand);
        Car[] cars = new Car[5];
        cars[0].licensePlate = "BM5678";
        cars[0].brand = "Hyundai";
        cars[0].model = "i10";
        cars[1].licensePlate = "KL3421";
        cars[1].brand = "Honda";
        cars[1].model = "Civic";
        for(int i = 0; i < cars.length; i++) {
            System.out.println(
                cars[i].licensePlate + " " +
                cars[i].brand + " " +
                cars[i].model
            );
        }
    }
}
