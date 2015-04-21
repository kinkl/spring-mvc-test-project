package com.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * Created by Kin on 19.04.2015.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FunnyCat {
    @Size(min = 3, max = 20, message = "Имя котика должно быть не меньше 3х символов и не больше 20")
    private String name;
    private String filename;
}
