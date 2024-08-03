package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.dto.LoginDto;

public interface AuthService {

    String userLogin(LoginDto loginDto);
}
