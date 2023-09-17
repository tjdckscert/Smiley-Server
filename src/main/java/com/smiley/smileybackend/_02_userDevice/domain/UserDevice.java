package com.smiley.smileybackend._02_userDevice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend._01_user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class UserDevice {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String deviceName;

    @Column(length = 50)
    private String deviceType;

    @Column(length = 200,unique = true)
    private String deviceUuid;

    @Column
    private String cordX;

    @Column
    private String cordY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_number", foreignKey = @ForeignKey(name = "fk_userdevice_user"))
    private User user;

    @Builder
    public UserDevice(Integer id, String deviceName, String deviceType, String deviceUuid, String cordX, String cordY, User user) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceUuid = deviceUuid;
        this.cordX = cordX;
        this.cordY = cordY;
        this.user = user;
    }
}
