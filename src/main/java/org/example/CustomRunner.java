package org.example;

import org.testng.TestNG;

public class CustomRunner extends TestNG {

    public CustomRunner(){
        super();
        this.addListener(new CustomListener());
    }

    public static void main(String[] args)
    {
        CustomRunner customRunner =new CustomRunner();
        customRunner.setTestClasses(new Class[]{MyFunctionalityTest.class});
        customRunner.run();
    }
}
