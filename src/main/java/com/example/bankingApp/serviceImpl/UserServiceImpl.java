package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.AuthenticationRequest;
import com.example.bankingApp.dto.AuthenticationResponse;
import com.example.bankingApp.dto.SimpleUserDto;
import com.example.bankingApp.dto.UserDto;

import com.example.bankingApp.repository.RoleRepository;
import com.example.bankingApp.repository.UserRepository;
import com.example.bankingApp.service.AccountService;
import com.example.bankingApp.service.UserService;
import com.example.bankingApp.validator.ObjectsValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "ROLE_USER";
    private final UserRepository repository;
    private final ObjectsValidator<UserDto> validator;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository repository, ObjectsValidator<UserDto> validator,   RoleRepository roleRepository) {
        this.repository = repository;
        this.validator = validator;
        this.roleRepository = roleRepository;
    }

    @Override
    public Integer save(UserDto dto) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Long validateAccount(Long id) {
        return null;
    }

    @Override
    public Long invalidateAccount(Long id) {
        return null;
    }

    @Override
    public AuthenticationResponse register(UserDto user) {
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }

    @Override
    public Long update(SimpleUserDto userDto) {
        return null;
    }
}
