package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1 - Hardcoded data

    @DataProvider(name = "LoginData1")
    public Object[][] getData1() {
        return new Object[][]{
                {"standard_user", "secret_sauce" , "Valid"},
                {"userInvalid", "secret_sauce","Invalid"},
                {"standard_user", "invalid","Invalid"},
                {"userInvalid", "invalid","Invalid"}
        };
    }
}
