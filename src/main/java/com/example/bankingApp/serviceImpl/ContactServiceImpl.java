package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.ContactDTo;
import com.example.bankingApp.model.Contact;
import com.example.bankingApp.repository.ContactRepository;
import com.example.bankingApp.service.ContactService;
import com.example.bankingApp.validator.ObjectsValidator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ObjectsValidator<ContactDTo> objectsValidator;

    public ContactServiceImpl(ContactRepository contactRepository, ObjectsValidator<ContactDTo> objectsValidator) {
        this.contactRepository = contactRepository;
        this.objectsValidator = objectsValidator;
    }

    @Override
    public Integer save(ContactDTo dto) {
        objectsValidator.validate(dto);
        Contact contact = ContactDTo.toEntity(dto);
        return Math.toIntExact(contactRepository.save(contact).getId());
    }

    @Override
    public List<ContactDTo> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(ContactDTo::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTo findById(Long id) {
        return contactRepository.findById(id)
                .map(ContactDTo::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No contact was found with the ID :" + id));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);

    }

    @Override
    public List<ContactDTo> findAllByUserId(Long userId) {
        return contactRepository.findAllByUserId(Math.toIntExact(userId))
                .stream()
                .map(ContactDTo::fromEntity)
                .collect(Collectors.toList());
    }
}
