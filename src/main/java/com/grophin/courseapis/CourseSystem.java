package com.grophin.courseapis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class CourseSystem {

    private static final Logger logger = LogManager.getLogger(CourseSystem.class);

    public static void main(String [] args){
    try {
        logger.info("************************ Starting the Ticketing System Service ************************");
        SpringApplication.run(CourseSystem.class,args);
        logger.info("************************ Started the Ticketing System Service ************************");
    }
    catch (Exception ex){
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        logger.info("Exception while starting the ticketing System service\n"+stringWriter);
    }
  }
}
