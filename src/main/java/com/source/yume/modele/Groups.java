package com.source.yume.modele;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Groups implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 3, nullable = false)
    private String name;

    @Column
    private Date creationDate;
}
