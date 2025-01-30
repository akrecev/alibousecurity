package com.akretsev.alibousecurity.user.service;

import com.akretsev.alibousecurity.user.model.ChangePasswordRequest;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

    }
}
