package com.wipro.testcases;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\nutha\\Downloads\\New folder (2)\\QET_CoE_SeleniumL21 copy\\src\\test\\resources\\resources\\features\\login.feature",glue={"com.wipro.testbase"}
)

public class Login_Run {

}
