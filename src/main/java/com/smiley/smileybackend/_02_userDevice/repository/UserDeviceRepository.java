package com.smiley.smileybackend._02_userDevice.repository;


import com.smiley.smileybackend._02_userDevice.domain.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice,Integer> {

    Optional<UserDevice> findByDeviceUuid(String deviceUuid);
}
