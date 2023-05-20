package tests;

import Pages.KiwiPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

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
        kiwiPage.exploreButton.click();

        // Trip type,one way olarak secilir
        kiwiPage.returnButton.click();
        kiwiPage.oneWayLink.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        kiwiPage.fromButton.click();
        kiwiPage.deleteDefaultCountryLink.click();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("dudullu");
        kiwiPage.kalkisNoktasıLink.click();
        kiwiPage.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwiPage.varisButton.click();
        driver.getKeyboard().pressKey("netherlands");
        kiwiPage.varisYeriLink.click();
        kiwiPage.chooseButton.click();

        // gidis tarihi mayis ayinin 31 i olarak secilir ve set date e tiklanir
        kiwiPage.gidisTarihButton.click();

        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }
}
