package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyTest {

        AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

        @Test
        public void test() throws IOException {

        // all currency uygulamasinin yuklendigi dogulanir
            Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"), "uygulama yükleme hatası");

        // uygulamanin acildigi dogrulanir
            AndroidElement anasayfaDogrulama = driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']");
            String actualResult = anasayfaDogrulama.getText();
            String expectedResult = "CURRENCY CONVERTER";
        Assert.assertEquals(actualResult,expectedResult, "Uygulama başlatılamadı");

        // cevirmek istedigimiz para birimi Arjantin Pesosu olarak secilir
            AndroidElement ilkKategori=  driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/linearLayoutPopupHistory");
            ilkKategori.click();
            ReusableMethods.scrollWithUiScrollable("ARS");
        // cevirelecek olan para birimi Tl olarak secilir
            AndroidElement kategore2= driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB"));
            kategore2.click();
            ReusableMethods.scrollWithUiScrollable("Turkish Lira");
            driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b1")).click();
            driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b5")).click();
            driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();
            driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();

        // cevrilen tutar screenShot olarak kaydedilir
            ReusableMethods.getScreenshot("ss");

        // Ardindan peso nun tl karsiligi olan tl degeri kaydedilir
            AndroidElement cevirilenBirim=driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB");
            String sonucParaDegeriPLN =cevirilenBirim.getText();

            driver.closeApp();

    }
}
