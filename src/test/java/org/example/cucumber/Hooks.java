package org.example.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeTest(Scenario scenario) {
        log.info("Старт сценария -- " + scenario.getName());
    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("Сценарий провалился");
        } else {
            log.info("Сценарий прошел");
        }
    }
}
