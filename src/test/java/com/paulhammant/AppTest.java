package com.paulhammant;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.jooby.test.JoobyRule;
import org.jooby.test.MockRouter;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;

public class AppTest {

  public TestExtendedApp app;

  @Test
  public void integrationTest() {
    app = new TestExtendedApp().startApp();
    counterEndpointShouldBe("0");
    counterEndpointShouldBe("1");
    counterEndpointShouldBe("2");
  }

  private void counterEndpointShouldBe(String s) {
    get("/count")
            .then()
            .assertThat()
            .body(equalTo(s))
            .statusCode(200)
            .contentType("text/plain;charset=UTF-8");
  }

  @Test
  public void functionalTests() {

    app = new TestExtendedApp().startApp();

    // launch new flutter app via Flutter-Driver
    // ... that clicks an "Increment" button five times
    // ... that invokes localhost:8080/count five times

    // Runtime.getRuntime().exec(......) -> (APK goes into QEMU)
    // Remember to do this, too: "adb reverse tcp:8080 tcp:8080"

    assertEquals(5, app.getCounter());


  }

  @After
  public void tearDown() {
    if (app != null) {
      app.stop();
    }
  }



}
