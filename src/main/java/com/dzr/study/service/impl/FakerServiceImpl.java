package com.dzr.study.service.impl;

import com.dzr.study.service.FakerService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * @Auther: dingzr
 * @Date: 2019/8/1 11:26
 * @Description:
 */

@Service
@Slf4j
@Transactional
public class FakerServiceImpl implements FakerService {

    private static void getFakerData(){

        Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);
        System.err.println(faker.name().firstName());
        System.err.println(faker.name().fullName());
        System.err.println(faker.food().ingredient());
        System.err.println(faker.app().name());
        System.err.println(faker.country().flag());
        System.err.println(faker.address().cityName());
        System.err.println(faker.cat().name());

    }


    public static void main(String[] args) {
        getFakerData();
    }

}
