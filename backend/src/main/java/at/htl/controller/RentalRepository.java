package at.htl.controller;

import at.htl.entity.Rental;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RentalRepository implements PanacheRepository<Rental> {
}
