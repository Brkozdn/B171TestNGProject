package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider
    public Object[][] isimler() {
        return new Object[][]{{"Ali"},{"Burak"}};
    }
}
