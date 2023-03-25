package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class UserDevice {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String deviceName;

    @Column(length = 50)
    private String deviceType;

    @Column(length = 200)
    private String deviceUuid;

    @Column
    private String devicePoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public UserDevice(Integer id, String deviceName, String deviceType, String deviceUuid, String devicePoint, User user) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceUuid = deviceUuid;
        this.devicePoint = devicePoint;
        this.user = user;
    }
}
