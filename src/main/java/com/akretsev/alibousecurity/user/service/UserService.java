package com.akretsev.alibousecurity.user.service;

import com.akretsev.alibousecurity.user.model.ChangePasswordRequest;
import java.security.Principal;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {}
}
