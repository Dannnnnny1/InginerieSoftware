// This is the EJB class that is responsible for handling the business logic of the application.
package com.parking.parkinglot.ejb;
import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless

public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        LOG.info("Finding all cars");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getOwner().getUsername()));
        }
        return carDtos;
    }
    public void createCar(String licensePlate, String parkingSpot, Long OwnerId){
        LOG.info("Creating a new car");
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);


         User owner = entityManager.find(User.class, OwnerId);
         owner.getCars().add(car);
        car.setOwner(owner);

        entityManager.persist(car);

    }
    public CarDto findById(Long carId) {
        LOG.info("findById");
        Car car = entityManager.find(Car.class, carId);
        if (car == null) {
            return null;
        }
        return new CarDto(
                car.getId(),
                car.getLicensePlate(),
                car.getParkingSpot(),
                car.getOwner().getUsername() );
    }
    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        LOG.info("updateCar");

        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        //remove this care from old owner
        User oldUser = car.getOwner();
        oldUser.getCars().remove(car);

        // add the car to its new owner
        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);
    }
    public void deleteCarsByIds(Collection<Long> carIds) {
        LOG.info("deleteCarsByIds");

        for(Long carId : carIds) {
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }
}


