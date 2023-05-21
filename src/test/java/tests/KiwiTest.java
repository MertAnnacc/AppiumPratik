package tests;

import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class KiwiTest {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage kiwiPage = new KiwiPage();
    @Test
    public void test() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"),"uygulama yüklü değil");

        // uygulamanin basariyla acildigi dogrulanir
        String actualResult = kiwiPage.girisKontolText.getText();
        String expectedResult = "Continue with Facebook";
        Assert.assertTrue(actualResult.contains(expectedResult));
        // misafir olarak devam et e tiklanir
        kiwiPage.continueGuestText.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        kiwiPage.continueButton.click();
        kiwiPage.continueButton.click();
        Thread.sleep(1000);
        kiwiPage.exploreButton.click();
        Thread.sleep(1000);

        // Trip type,one way olarak secilir
        Thread.sleep(1000);
        kiwiPage.returnButton.click();
        kiwiPage.oneWayLink.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        kiwiPage.fromButton.click();
        kiwiPage.deleteDefaultCountryLink.click();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("sabiha");
        kiwiPage.kalkisNoktasıLink.click();
        kiwiPage.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwiPage.varisButton.click();
        driver.getKeyboard().pressKey("netherlands");
        kiwiPage.varisYeriLink.click();
        kiwiPage.chooseButton.click();

        // gidis tarihi mayis ayinin 25 i olarak secilir ve set date e tiklanir
        kiwiPage.gidisTarihButton.click();
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(534,1345))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(553,457)).release().perform();
        Thread.sleep(1600);
        action.press(PointOption.point(122,936)).release().perform();
        kiwiPage.setDateButton.click();

        // search butonuna tiklanir
        kiwiPage.searchButton.click();
        Thread.sleep(3000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        kiwiPage.popularButton.click();
        kiwiPage.cheapestButton.click();
        Thread.sleep(2000);

        kiwiPage.stopsButton.click();
        kiwiPage.nonstopLink.click();
        Thread.sleep(1500);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyat = kiwiPage.priceTextLink.getText();
        driver.sendSMS("+905304300317",fiyat + " En uygun fiyat bu şekildedir");
    }
}
