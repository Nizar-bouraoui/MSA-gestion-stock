package com.samisayari.services;

import com.samisayari.entities.Reclamation;
import com.samisayari.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {
    @Autowired
    ReclamationRepository reclamationRepository;

    public Reclamation addReclamation(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }

    public List<Reclamation> findAllReclamations(){
        return reclamationRepository.findAll();
    }

    public Reclamation findReclamationById(int id) {
        return reclamationRepository.findById(id).get();
    }

    public void deleteReclamationById(int id) {
        reclamationRepository.deleteById(id);
    }

    public Reclamation updateProduct(Reclamation reclamation) {
        Reclamation existingReclamation = reclamationRepository.findById(reclamation.getId()).get();
        if (existingReclamation != null) {
            return reclamationRepository.save(reclamation);
        }
        return null;
    }
}
