package com.afconsult.claes.viaplay.test;

import com.afconsult.claes.viaplay.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Claes on 2016-01-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AbstractTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
