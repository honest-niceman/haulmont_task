package com.company.practice.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(NewService.NAME)
public class NewServiceBean implements NewService {
    @Inject
    private DataManager dataManager;


}