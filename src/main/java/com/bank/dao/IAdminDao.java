package com.bank.dao;

import java.util.List;

import com.bank.model.Profile;

public interface IAdminDao {

    public List<Profile> displayRequests();
    
    public int reject(int i);
    
    public int approve(int i);
}
