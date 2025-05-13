import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Asset house1 = new House(150000, "now", "spanish style", "123 A Street", 1, 2500, 4000);
    Asset house2 = new House(200000, "now", "spanish style", "456 B Street", 2, 3000, 3500);
    Asset house3 = new House(100000, "now", "spanish style", "556 B Street", 3, 30100, 35100);
    Asset house4 = new House(250000, "now", "spanish style", "756 B Street", 4, 300, 30);

    Asset car1 = new Vehicle(20000, "now", "4 wheel drive", "subaru WRX", 2025, 55000);
    Asset car2 = new Vehicle(30000, "now", "4 wheel drive", "Toyota RAV4", 2021, 108000);
    Asset car3 = new Vehicle(50000, "now", "4 wheel drive", "Audi S6", 2018, 40000);
    Asset car4 = new Vehicle(100000, "now", "super car", "Lambo", 1995, 150000);

    var arrayList = new ArrayList<Asset>();
    arrayList.add(house1);
    arrayList.add(house2);
    arrayList.add(house3);
    arrayList.add(house4);
    arrayList.add(car1);
    arrayList.add(car2);
    arrayList.add(car3);
    arrayList.add(car4);

    String message = "";

    for (int i = 0; i < arrayList.size(); i++) {
      if (arrayList.get(i) instanceof House) {
        House house = (House) arrayList.get(i);
        message = "House at " + house.getAddress();
        System.out.println(message);

      } else if (arrayList.get(i) instanceof Vehicle) {
        Vehicle vehicle = (Vehicle) arrayList.get(i);
        message = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel();
        System.out.println(message);
      }
    }
  }
}
