package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C05_BlueRentalCarExcelTest {
    @Test
    public void excelTest() {
        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage rentalPage = new BlueRentalPage();


        //Excel dosyasındaki tüm kullanıcı bilgileri ile login olalım login olduğumuzu doğrulayalım
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata (1).xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);

        for (int i = 1; i <=reader.rowCount() ; i++) {

            String email = reader.getCellData(i,0);
            String password = reader.getCellData(i,1);

            System.out.println(email+" || "+password);

            rentalPage.loginButton.click();
            ReusableMethods.bekle(2);

            rentalPage.userEmail.sendKeys(email, Keys.TAB,password,Keys.ENTER);

            Assert.assertTrue(rentalPage.verify.isDisplayed());

            ReusableMethods.bekle(2);
            rentalPage.profilButton.click();

            ReusableMethods.bekle(2);
            rentalPage.logout.click();


            ReusableMethods.bekle(2);
            rentalPage.okButton.click();


            Assert.assertTrue(rentalPage.loginButton.isDisplayed());
        }

        //sayfayı kapatalım
        Driver.closeDriver();
    }
}