package com.cy.store.service;

import com.cy.store.entity.District;
import com.cy.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        List<District> list = districtService.getByParent("86");
        for (District d : list) {
            System.out.println(d);
        }
    }

    @Test
    public void getNameByCode() {
        try {
            String code = "430000";
            String result = districtService.getNameByCode(code);
            System.out.println(result);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
