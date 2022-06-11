package com.samisayari.controllers;

import com.samisayari.entities.Reclamation;
import com.samisayari.entities.Response;
import com.samisayari.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;

    @PostMapping
    public ResponseEntity<Response> addReclamation(@RequestBody Reclamation reclamation){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("reclamation",reclamationService.addReclamation(reclamation)))
                        .message("reclamation saved successfully")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @PutMapping
    public ResponseEntity<Response> updateReclamation(@RequestBody Reclamation reclamation){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Reclamation",reclamationService.updateProduct(reclamation)))
                        .message("reclamation updated successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping
    public ResponseEntity<Response> findAllReclamations(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("reclamation",reclamationService.findAllReclamations()))
                        .message("reclamation retrieved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> findReclamationById(@PathVariable int id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("reclamation",reclamationService.findReclamationById(id)))
                        .message("reclamation retrieved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> findAllReclamations(@PathVariable int id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("reclamation id : ",id))
                        .message("reclamation deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
