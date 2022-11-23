package com.dalilasantos;

import org.hibernate.ObjectNotFoundException;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class businessPartnersController {

  businessRepository repository;

  @GetMapping("/businessPartners")
  public List<BusinessPartners> getAllbusinessPartners() {
    return repository.findAll();
  }

  @GetMapping("/businessPartners/{id}")
  public BusinessPartners getbusinessPartnersById(@PathVariable Integer id) {
    return repository.findById(id).get();
  }

  @PostMapping("/businessPartners")
  public BusinessPartners savebusinessPartners(@RequestBody BusinessPartners businessPartners) {
    return repository.save(businessPartners);
  }

  @DeleteMapping("/businessPartners/{id}")
  public void deletebusinessPartners(@PathVariable Integer id) {
    repository.deleteById(id);
  }

  @PutMapping("/businessPartners/{id}")
  public BusinessPartners editabusinessPartners(@RequestBody BusinessPartners businessPartners, @PathVariable Integer id ) {
    return repository.findById(id)
            .map(item -> {
              item.setCardName(businessPartners.getCardName());
              return repository.save(item);
            })
            .orElseThrow(() -> new Error());
  }
}
