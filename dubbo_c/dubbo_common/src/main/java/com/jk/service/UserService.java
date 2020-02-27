package com.jk.service;

import com.jk.model.UserModel;

public interface UserService {


    UserModel findUserPhone(String useriphone);

    



    void register(UserModel userModel);
}
