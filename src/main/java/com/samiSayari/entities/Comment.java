package com.samiSayari.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@SuperBuilder
@JsonInclude
@NoArgsConstructor
public class Comment {
    private static final long serialVersionUID = 6711457437559348053L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String commentDescription;
    private String ref;
    private int userId;
    private int productId;


}
