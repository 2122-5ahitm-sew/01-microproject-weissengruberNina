package at.htl.boundary;

import at.htl.controller.CarRepository;
import at.htl.entity.Car;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/car")
public class CarService {

    @Inject
    CarRepository repository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("/findCar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car findCar(@PathParam("id") long id) {
        return repository.findById(id);
    }

    @POST
    @Path("/addCar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car addCar(Car car) {
        repository.persist(car);
        return car;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Car updateCar(@PathParam("id") long id, Car car) {
        Car oldCar = repository.findById(id);

        if (oldCar != null){
            oldCar.brand = car.brand;
            oldCar.price = car.price;
        }

        return oldCar;
    }

    @DELETE
    @Path("/deleteCar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Car delete(@PathParam("id") long id) {
        Car car = repository.findById(id);
        repository.delete("id = " + id);
        return car;
    }

}
