package at.htl.boundary;

import at.htl.controller.RentalRepository;
import at.htl.entity.Rental;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rental")
public class RentalService {

    RentalRepository repository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rental> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("/findRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rental findRental(@PathParam("id") long id) {
        return repository.findById(id);
    }

    @POST
    @Path("/addRental")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Rental addRental(Rental rental) {
        repository.persist(rental);
        return rental;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Rental updateRental(@PathParam("id") long id, Rental rental) {
        Rental oldRental =  repository.findById(id);

        if (oldRental != null){
            oldRental.car = rental.car;
            oldRental.customer = rental.customer;
            oldRental.startDate = rental.startDate;
            oldRental.endDate = rental.endDate;
            oldRental.discount = rental.discount;
        }

        return null;
    }

    @DELETE
    @Path("/deleteRental/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Rental delete(@PathParam("id") long id) {
        Rental rental = repository.findById(id);
        repository.delete(rental);
        return rental;
    }

}
