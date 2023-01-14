package com.wine.userservice.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"city"})
@ToString(exclude = {"city"})
@Accessors(chain = true)
@Table(name = "users")
public class User implements AbstractEntity<Long>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "activated")
    private Boolean isActivated;

    @Column(name = "sex")
    private int sex;

    @Column(name = "created_at")
    private Instant createDate;

    private Long authId;
}
