package com.docker.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Lists {
    @Id @GeneratedValue
    private Long id;

    private String value;

    public Lists(String value) {
        this.value = value;
    }
}
