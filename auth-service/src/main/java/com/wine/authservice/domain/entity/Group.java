package com.wine.authservice.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode()
@ToString()
@Accessors(chain = true)
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @ManyToMany
    @CollectionTable(name = "group_permission", joinColumns = @JoinColumn(name = "group_id"))
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private List<User> users;
}
