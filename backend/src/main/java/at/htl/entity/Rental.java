package at.htl.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Rental {
    public Car car;
    public Customer customer;
    public LocalDate startDate;
    public LocalDate endDate;
    public double discount;

    public Rental() {
    }

    public Rental(Car car, Customer customer, LocalDate startDate, LocalDate endDate, double discount) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Rental{" +
                ", car=" + car +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Double.compare(rental.discount, discount) == 0 && Objects.equals(car, rental.car) && Objects.equals(customer, rental.customer) && Objects.equals(startDate, rental.startDate) && Objects.equals(endDate, rental.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, customer, startDate, endDate, discount);
    }
}
