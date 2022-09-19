package com.wine.authservice.domain.entity;

import com.google.common.collect.Lists;
import com.wine.authservice.utils.JwtTokenProvider;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"password"})
@ToString()
@Accessors(chain = true)
@Table(name = "usrs")
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
    @JoinTable(name = "user_permission",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private Set<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "user_group",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") })
    private Set<Group> groups;

    public List<String> showAllPermissionsAsList(){
        Set<String> result = new HashSet<>();

        for(Group group: this.getGroups()){
            for (Permission permission: group.getPermissions()){
                result.add(permission.getName());
            }
        }

        for (Permission permission: this.getPermissions()){
            result.add(permission.getName());
        }

        return Lists.newArrayList(result);
    }

    public String createAccessToken(){
        Map<String, Object> map = new HashMap<>();
        map.put("scope", showAllPermissionsAsList());
        map.put("userId", id);
        return JwtTokenProvider.createToken(username, map);
    }

    public String createRefreshToken(){
        return JwtTokenProvider.createRefreshToken(username);
    }

    public String createToken(){
        return JwtTokenProvider.createToken(username);
    }
}
