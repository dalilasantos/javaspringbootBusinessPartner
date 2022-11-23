package com.dalilasantos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessPartners {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer cardCode;
  String cardName;
  String avatar;
  String address;
  String zipCode;
}
