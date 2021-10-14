package at.htl.boundary;

import at.htl.controller.CustomerRepository;
import at.htl.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer")
public class CustomerService {

    @Inject
    CustomerRepository repository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("/findCustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer findCustomer(@PathParam("id") long id) {
        return repository.findById(id);
    }

    @POST
    @Path("/addCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addCustomer(Customer customer) {
        repository.persist(customer);
        return customer;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer updateCustomer(@PathParam("id") long id, Customer customer) {
        Customer oldCustomer = repository.findById(id);

        if (oldCustomer != null){
            oldCustomer.name = customer.name;
            oldCustomer.dateOfBirth = customer.dateOfBirth;
        }

        return customer;
    }

    @DELETE
    @Path("/deleteCustomer/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer delete(@PathParam("id") long id) {
        Customer customer = repository.findById(id);
        repository.delete(customer);
        return customer;
    }

}
