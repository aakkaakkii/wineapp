package com.wine.authservice.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"password"})
@ToString()
@Accessors(chain = true)
@Table(name = "users")
public class User implements AbstractEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private boolean active;
    private boolean blocked;
    @Column(name = "created_at")
    private Instant createDate;

//    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @ManyToMany
    @CollectionTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "user_group",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_group") })
    private Set<Group> groups;

}
