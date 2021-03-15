import java.util.Objects;

/**
 * A vehicle that is made of some material (usually metal), has a power (described in Watts) and a weight (described in kilograms).
 */
public class Vehicle {
    private int power = 0;
    private int weight = 0;
    private String material = "metal";

    public void setPower(int power) {
        this.power = power;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return power == vehicle.power && weight == vehicle.weight && material.equals(vehicle.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, weight, material);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "power=" + power +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                '}';
    }

    /**
     * We can start the engine of our vehicle
     */
    public void start() {
        System.out.printf("%s started%n", getClass().getName());
    }

    /**
     * We can turn the engine off
     */
    public void turnOff() {
        System.out.printf("%s started%n", getClass().getName());
    }

    /**
     * We can also turn the lights on and off
     */
    public void turnLigthsOn() {
        System.out.println("lights turned on");
    }

    public void turnLigthsOff() {
        System.out.println("lights turned off");
    }

    /**
     * A short test of this class.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        Vehicle V1 = new Vehicle();
        V1.setPower(100);
        V1.setWeight(250);
        System.out.printf("V1's weight is %s %n", V1.getWeight());
        System.out.printf("V1's power is %s %n", V1.getPower());
        System.out.printf("V1 is made of %s %n", V1.getMaterial());
        V1.start();
        V1.turnLigthsOn();
        V1.turnOff();
        V1.turnLigthsOff();
        Vehicle V2 = new Vehicle();
        Vehicle V3 = new Vehicle();
        V3.setWeight(100);
        V3.setPower(250);
        System.out.println(V1 == V2);
        System.out.println(V1.equals(V2));
        System.out.println(V2.equals(V1));
        System.out.println(V3.equals(V1));
        System.out.printf("V1 = [%s], V1.hashCode() = %d%n", V1, V1.hashCode());
        System.out.printf("V3 = [%s], V3.hashCode() = %d%n", V3, V3.hashCode());
        System.out.println("Description for V1: " + V1);
        System.out.println("Description for V2: " + V2);
        System.out.println("Description for V3: " + V3);
    }
}
