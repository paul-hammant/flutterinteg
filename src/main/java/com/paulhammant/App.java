package com.paulhammant;

import org.jooby.Jooby;

public class App extends Jooby {

  protected int counter;

  {
    get("/count", (req, rsp) -> {
      rsp.status(200);
      rsp.type("text/plain");
      rsp.send("" + counter++);
    });
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
