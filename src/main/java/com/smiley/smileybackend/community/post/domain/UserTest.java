package com.smiley.smileybackend.community.post.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userTest")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String userNumber;

    @Column(nullable = false, length = 200)
    private String phoneToken;

    @Column(length = 45)
    private String name;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
