public class Car {
    private String brand = null;
    private int doors = 0;

    public String getBrand() { return this.brand; }
    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
    public void setDoors (int doors) { this.doors = doors; }
    public String toString(){
        return "car brand = " + brand + "\ncar doors = " + doors;
    }
}
