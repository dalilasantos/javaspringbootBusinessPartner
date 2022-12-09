package com.dalilasantos;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BusinessPartnersController {

  private BusinessRepository repository;

  @GetMapping("/businessPartners")
  public List<BusinessPartners> getAllbusinessPartners() {
    return repository.findAll();
  }

  @GetMapping("/businessPartners/{id}")
  public BusinessPartners getbusinessPartnersById(@PathVariable Integer id) {
    var teste = repository.findById(id);
    return teste.get();
  }

  @PostMapping("/businessPartners")
  public ResponseEntity savebusinessPartners(@RequestBody BusinessPartners businessPartners) {
    repository.save(businessPartners);
    return ResponseEntity.status(CREATED).build();
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
