package com.hackfse.fdbck.mgmt.systm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackfse.fdbck.mgmt.systm.model.OutReachNotRegisteredDTO;

@Repository
public interface OutReachNotRegisteredDao extends JpaRepository<OutReachNotRegisteredDTO, String> {

}
