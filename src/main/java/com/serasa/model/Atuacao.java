package com.serasa.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Atuacao {

    @Id
    private String regiao;
    
    @ElementCollection
    private List<String> estados;

}