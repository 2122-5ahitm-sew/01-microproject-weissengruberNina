package at.htl.entity;

import java.util.Objects;

public class Car {
    public String brand;
    public double price;

    public Car() {
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
