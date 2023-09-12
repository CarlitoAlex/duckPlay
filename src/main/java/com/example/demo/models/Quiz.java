package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String imageUrl;
    @ElementCollection
    @CollectionTable(name="listOfOptions")
    private List<String> options = new ArrayList<>();
    private String answer;
    private String answerChoice = null;
    private boolean correct = false;
}
