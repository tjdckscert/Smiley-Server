package com.smiley.smileybackend.community.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
