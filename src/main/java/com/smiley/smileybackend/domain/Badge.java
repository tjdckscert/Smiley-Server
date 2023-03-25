package com.smiley.smileybackend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Badge {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String badgeName;

    @Column(length = 200)
    private String badgeExplain;

    @Column(length = 200)
    private String badgeCondition;

    @Column
    private Boolean badgeType;

    @Column(length = 200)
    private String badgeImage;

    @ManyToMany(mappedBy = "userBadgeBadges")
    private List<User> userBadgeUsers;

    @Builder
    public Badge(Integer id, String badgeName, String badgeExplain, String badgeCondition, Boolean badgeType, String badgeImage, List<User> userBadgeUsers) {
        this.id = id;
        this.badgeName = badgeName;
        this.badgeExplain = badgeExplain;
        this.badgeCondition = badgeCondition;
        this.badgeType = badgeType;
        this.badgeImage = badgeImage;
        this.userBadgeUsers = userBadgeUsers;
    }
}
