package com.everydocs.customer.domain;

import com.everydocs.customer.domain.type.Gender;
import com.everydocs.customer.domain.type.PostgresSQLEnumType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Audited
@TypeDef(name = "pgsql_enum", typeClass = PostgresSQLEnumType.class)
public class Customer extends AuditableEntity {

  @Id
  @GeneratedValue
  private UUID id;

  @NotBlank
  private String username;

  @Email
  private String email;

  @Type(type = "pgsql_enum")
  @Enumerated(EnumType.STRING)
  private Gender gender;

}
