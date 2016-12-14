package ru.ya.mail

import pages.Application
import webDriver.DriverManager

this.metaClass.mixin(cucumber.api.groovy.Hooks)

Boolean firstExecute = true

//Run new ThreadForQuit which observe shutdown of jvm runtime
Before()
        {
            //AfterClass
            if (firstExecute) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        System.out.println(" CLOSE-RUN")
                        DriverManager.quitWebDriver();
                    }
                })
                firstExecute = false
            }

        }

Before('@MailSearch'){
    Application.navigateToMainPage();
}

