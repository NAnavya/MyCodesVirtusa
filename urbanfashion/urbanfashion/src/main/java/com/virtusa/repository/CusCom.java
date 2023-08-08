package com.virtusa.repository;

import java.util.Comparator;

import com.virtusa.entity.RegistrationEntity;

public class CusCom implements Comparator<RegistrationEntity> {

	@Override
	public int compare(RegistrationEntity o1, RegistrationEntity o2) {
		return o1.getUsername().compareToIgnoreCase(o2.getUsername());
	}

}
