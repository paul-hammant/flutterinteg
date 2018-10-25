package com.paulhammant;

public class TestExtendedApp extends App {


    protected boolean appStarted;

    public TestExtendedApp() {
        onStarted(() -> {
            appStarted = true;
        });
    }


    protected TestExtendedApp startApp() {
        this.start("server.join=false");
        int ctr = 0;
        while (!this.appStarted && ctr < 300) {
            try {
                Thread.sleep(15);
                ctr++;
            } catch (InterruptedException e) {
            }
        }
        return this;
    }


    public int getCounter() {
        return counter;
    }

}
