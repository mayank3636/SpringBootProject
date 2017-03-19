package com.mindtree.skillspeed.hotelmanagement.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.mindtree.skillspeed.hotelmanagement"})
@AutoConfigureDataJpa
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.mindtree.skillspeed.hotelmanagement.dao"})
@EntityScan(basePackages={"com.mindtree.skillspeed.hotelmanagement.entity"})
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);
	}
}
