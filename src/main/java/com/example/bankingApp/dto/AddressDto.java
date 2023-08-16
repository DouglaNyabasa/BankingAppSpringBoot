package com.example.bankingApp.dto;

import com.example.bankingApp.model.Address;
import com.example.bankingApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@AllArgsConstructor
@Builder
public class AddressDto {
    private Long id;

    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String county;

    private Long userId;

    public static AddressDto fromEntity(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .county(address.getCounty())
                .userId(address.getUser().getId())
                .build();
    }

    public static Address toEntity(AddressDto address) {
        return Address.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .county(address.getCounty())
                .user(
                        User.builder()
                                .id(address.getUserId())
                                .build()
                )
                .build();
    }
}
