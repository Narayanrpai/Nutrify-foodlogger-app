package com.narayan.foodlogger.services;

import com.narayan.foodlogger.model.PasswordResetToken;
import com.narayan.foodlogger.model.User;

public interface PasswordService {

    PasswordResetToken generateToken(String email);
    User processToken(String token);

}
