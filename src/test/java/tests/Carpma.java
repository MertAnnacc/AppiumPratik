package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Carpma {
    AndroidDriver<MobileElement> driver;

    @BeforeTest

    public  void deneme() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Mert2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mert\\IdeaProjects\\Appium\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }

    @Test

    public void carpma(){

        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();

        String result = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        Assert.assertEquals(Integer.parseInt(result), 1600);
    }

}

