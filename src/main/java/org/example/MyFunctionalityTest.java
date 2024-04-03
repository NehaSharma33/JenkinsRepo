package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyFunctionalityTest {
ExtentReports extent;
ExtentTest test;

    private Calculator calculator;

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {2, 3, 5}
        };
    }

    @BeforeSuite
    public void setUpReport()
    {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }


    @Test(groups = {"smoke"},dataProvider = "testData")
    public void testAdditionData(int a,int b, int c) {
        test = extent.createTest("TestAdditionData Method");
        assertEquals(calculator.sum(a, b), c);
        test.pass("Test Passed");
        test.log(Status.INFO, "Starting TestAdditionData test case");
    }

    @Test(groups = {"smoke"})
    public void testAdditionPositive() {
        assertEquals(calculator.sum(2, 3), 5);
    }

    @Test(groups = {"smoke"})
    public void testSubtractionPositive() {
        assertEquals(calculator.sub(5, 3), 2);
    }

    @Test(groups = {"smoke"})
    public void testMultiplicationPositive() {
        assertEquals(calculator.mult(2, 3), 6);
    }

    @Test(groups = {"smoke"})
    public void testDivisionPositive() {
        assertEquals(calculator.div(6, 3), 2);
    }

    @Test(groups = {"smoke"})
    public void testAdditionNegative() {
        assertEquals(calculator.sum(-2, 3), 1);
    }

    @Test(groups = {"regression"})
    public void testSubtractionNegative() {
        assertEquals(calculator.sub(2, 5), -3);
    }

    @Test(groups = {"regression"})
    public void testMultiplicationNegative() {
        assertEquals(calculator.mult(-2, 3), -6);
    }

    @Test(groups = {"regression"},expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        int numerator = 10;
        int denominator = 0;
        int result = numerator / denominator;
    }

}
