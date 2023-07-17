package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Authority implements Serializable {
    @Id
    @Column(length = 26)
    private String name;

//    @Override
//    public String toString() {
//        return "Authority{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
