package com.bank.service;

import java.util.List;

import com.bank.model.Profile;

public interface IAdminService {
    public List<Profile> displayRequests();
    
	public int reject(int i);
	
	public int approve(int i);
}
