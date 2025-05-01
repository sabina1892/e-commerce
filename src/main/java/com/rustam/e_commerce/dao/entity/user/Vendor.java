package com.rustam.e_commerce.dao.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@DiscriminatorValue("VENDOR")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class Vendor extends BaseUser{
    String username;

}
