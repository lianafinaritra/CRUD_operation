package com.source.yume.modele;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Students implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups group;
}
