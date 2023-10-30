package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {


    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{{"volvo"},{"mercedes"},{"audi"},{"ford"}};
    }

    @Test(dataProvider = "araclar")
    public void test01(String data) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        GooglePage page = new GooglePage();

        //DataProvider ile istediğimiz arac isimlerini aratalım
        page.aramaKutusu.sendKeys(data, Keys.ENTER);

        //sayfayi kapatın
        Driver.closeDriver();
    }
}