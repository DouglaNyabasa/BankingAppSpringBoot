package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.AddressDto;
import com.example.bankingApp.model.Address;
import com.example.bankingApp.repository.AddressRepository;
import com.example.bankingApp.service.AddressService;
import com.example.bankingApp.validator.ObjectsValidator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private ObjectsValidator<AddressDto> objectsValidator;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Integer save(AddressDto dto) {
        objectsValidator.validate(dto);
        Address address = AddressDto.toEntity(dto);
        return Math.toIntExact(addressRepository.save(address).getId());
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(AddressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Long id) {
        return addressRepository.findById(id)
                .map(AddressDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No address found with the ID : " + id));
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);

    }
}
