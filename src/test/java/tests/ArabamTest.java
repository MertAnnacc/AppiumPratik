package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamTest {
    AndroidDriver<MobileElement> driver;

    @BeforeTest

    public  void deneme() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,  ConfigReader.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
        capabilities.setCapability("appPackage", "com.dogan.arabam"); // Hangi uygulamada çalışmak istediğimizi
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity"); // hangi sayfadan başlamak
        // home ya da main activity olur genelde
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bittikten sonra SIFIRLAR
        // eger true olursa uygulama calistiktan sonra yapilacak adimlari gercceklestirir uygulamayi islem bittikten sonra SIFIRLAMAZ
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void  test() throws InterruptedException {
        // Arabam kac para bolumune tiklayalim
        driver.findElement(By.xpath("//*[@text='Arabam kaç para?']")).click();
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']")).click();
        // Wolkswagen markasini secelim
        TouchAction touchAction = new TouchAction<>(driver);

        touchAction.press(PointOption.point(537,2053))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(531,649)).release().perform();

        Thread.sleep(1000);

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // yil secimi yapalim
        driver.findElement(By.xpath("//*[@text='2020']")).click();

        // model secimi yapalim
        driver.findElement(By.xpath("//*[@text='Caddy']")).click();

        // govde tipini secelim
        driver.findElement(By.xpath("//*[@text='Panelvan']")).click();

        // yakit tipini secelim
        driver.findElement(By.xpath("//*[@text='Dizel']")).click();

        // vites tipini secelim
        driver.findElement(By.xpath("//*[@text='Düz']")).click();

        // Versiyon secimi yapalim
        driver.findElement(By.xpath("//*[@text='Seç']")).click();

        // aracin km bilgilerini girelim
        if(driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("80000");
        } else{
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("80000");
        }
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@text='Devam']")).click();

        // aracin rengini secelim
        driver.findElement(By.xpath("//*[@text='Füme']")).click();

        // opsiyel donanim (varsa) seecelim
        driver.findElementById("com.dogan.arabam:id/iv_B01201").click();
        driver.findElement(By.xpath("(//*[@text='Boyalı'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Devam']")).click();

        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        driver.findElement(By.xpath("//*[@text='Tramer kaydı var']")).click();
        if(driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("5000");
        } else{
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("5000");
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text='Devam']")).click();

        // Aradığınız aracın fiyatını bulamadık yazısının göründüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Aradığınız aracın fiyatını bulamadık']")).isDisplayed());

        // uygulamayi kapatalim
        driver.closeApp();


    }
}
