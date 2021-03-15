import java.util.Objects;

/**
 * Car is a type of vehicle, which can be described in many ways. For example we can distinguish number of gears, capacity, brand. We can also
 * describe a few other parameters that may change, while driving - we switch gears, someone may get in or get out the car etc.
 */
public class Car extends Vehicle {
    private int numberOfGears = 0;
    private int capacity = 0;
    private String brand = null;
    private int currentGear = 0;
    private int numberOfPassengers = 0;

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBrand() {
        return brand;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Switch the current gear.
     * @param newGear needs to be positive integer, not greater than number of gears in our car
     */
    public void switchGear(int newGear) {
        if (newGear <= this.numberOfGears & newGear >= 0) {
            this.currentGear = newGear;
            System.out.println("switched to gear: "+this.currentGear);
        } else {
            System.out.println("unable to switch to that gear");
        }
    }

    /**
     * Change number of passengers in your car.
     * @param newPassengers needs to be positive integer and when summed with current number of passengers
     *                      not greater than capacity of the car.
     */
    public void addPassenger(int newPassengers) {
        if ((this.numberOfPassengers + newPassengers) <= this.capacity & (newPassengers>0)) {
            this.numberOfPassengers += newPassengers;
            System.out.println("number of passengers: "+this.numberOfPassengers);
        } else {
            System.out.println("not enough space");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return numberOfGears == car.numberOfGears && capacity == car.capacity && currentGear == car.currentGear && numberOfPassengers == car.numberOfPassengers && brand.equals(car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfGears, capacity, brand, currentGear, numberOfPassengers);
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfGears=" + numberOfGears +
                ", capacity=" + capacity +
                ", brand='" + brand + '\'' +
                ", currentGear=" + currentGear +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }

    /**
     * A short test of this class.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        Car C1 = new Car();
        Car C2 = new Car();
        C1.setBrand("BMW");
        C1.setCapacity(5);
        C1.setNumberOfGears(6);
        C1.switchGear(5);
        System.out.println(C2.getCurrentGear());
        C1.switchGear(-2);
        C1.switchGear(7);
        System.out.println("C1 description: "+C1);
        C1.addPassenger(5);
        C1.addPassenger(2);
        System.out.println("C1 description: "+C1);
        System.out.println(C1 == C2);
        System.out.println(C1.equals(C2));
        System.out.println(C2.equals(C1));
        System.out.printf("C1 = [%s], C1.hashCode() = %d%n", C1, C1.hashCode());
        System.out.printf("C2 = [%s], C2.hashCode() = %d%n", C2, C2.hashCode());
    }
}
