package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver = new FirefoxDriver();

    public Properties properties;

    @BeforeClass(groups = { "Master","DataDriven"})
    public void setup() throws IOException {

        FileReader fileReader = new FileReader("src/test/resources/config.properties");
        properties = new Properties();
        properties.load(fileReader);

        String url = properties.getProperty("baseUrl");  // Reading url from properties file

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @AfterClass(groups = {"DataDriven"})
    public void tearDown(){
        driver.quit();
    }
}
