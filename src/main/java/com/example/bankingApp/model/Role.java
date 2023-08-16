package com.example.bankingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class Role extends BaseEntity{
    private String name;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
