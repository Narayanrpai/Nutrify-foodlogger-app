package com.narayan.foodlogger.services;

import com.narayan.foodlogger.model.PasswordResetToken;

public interface MailService {

    void sendForgotPasswordMail(String email, PasswordResetToken token);

}
