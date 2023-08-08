package com.virtusa.service;

import java.sql.Connection;

import com.virtusa.entity.RegistrationEntity;

public interface RegistrationService {

	void registerUsers(Connection connection, RegistrationEntity registration);

}
