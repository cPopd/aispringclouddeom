package com.southwind.repository;

import com.southwind.entity.Admin;

public interface AdminRepositoy {

    public Admin login(String username,String password);

}
