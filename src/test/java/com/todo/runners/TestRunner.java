package com.todo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.todo.steps"},
        plugin = {
                "pretty",
                "html:build/reports/cucumber/cucumber-report.html",
                "json:build/reports/cucumber/cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "not @wip",
        monochrome = true
)
public class TestRunner {
}
```

**Ctrl+S** to save.

---

Now create the Allure config file. Right-click on `resources` folder → **New File** → name it `allure.properties`, open it and type:
```
allure.results.directory=build/allure-results