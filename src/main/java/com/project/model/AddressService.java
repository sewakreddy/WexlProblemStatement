package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAllAddressOfUsers(){
        return (List<Address>) addressRepository.findAll();
    }

    public Address findAddressById(long id){
        Optional<Address> result = addressRepository.findById(id);
        return result.orElse(null);
    }
}
