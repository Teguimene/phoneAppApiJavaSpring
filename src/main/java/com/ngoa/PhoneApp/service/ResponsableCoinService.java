package com.ngoa.PhoneApp.service;

import com.ngoa.PhoneApp.modele.ResponsableCoin;
import com.ngoa.PhoneApp.repository.ResponsableCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsableCoinService {

    @Autowired
    private ResponsableCoinRepository responsableCoinRepository;

}
