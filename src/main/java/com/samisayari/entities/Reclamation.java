package com.samisayari.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@SuperBuilder
@JsonInclude
@NoArgsConstructor
public class Reclamation implements Serializable {
    private static final long serialVersionUID = 6711457437559348053L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String reclamationReference;
    private String title;
    private String description;
    private int productId;
}
