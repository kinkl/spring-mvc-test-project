package com.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Kin on 19.04.2015.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cats")
public class FunnyCat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cats_seq")
    @SequenceGenerator(name = "cats_seq", sequenceName = "cats_seq")
    private Integer id;

    @Size(min = 3, max = 20, message = "Имя котика должно быть не меньше 3х символов и не больше 20")
    @Column(name = "name")
    private String name;

    @Column(name = "filename")
    private String filename;
}
