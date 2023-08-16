package com.example.bankingApp.service;

import com.example.bankingApp.dto.AuthenticationRequest;
import com.example.bankingApp.dto.AuthenticationResponse;
import com.example.bankingApp.dto.SimpleUserDto;
import com.example.bankingApp.dto.UserDto;
import com.example.bankingApp.generics.service.GenericService;


public interface UserService extends GenericService<UserDto> {

    Long validateAccount(Long id);

    Long invalidateAccount(Long id);

    AuthenticationResponse register(UserDto user);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    Long update(SimpleUserDto userDto);
}
