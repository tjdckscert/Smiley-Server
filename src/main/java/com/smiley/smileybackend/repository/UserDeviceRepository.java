package com.smiley.smileybackend.repository;


import com.smiley.smileybackend.domain.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice,Integer> {

    Optional<UserDevice> findByDeviceUuid(String deviceUuid);
}
