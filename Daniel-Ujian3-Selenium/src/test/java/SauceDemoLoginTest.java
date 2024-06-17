import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoLoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Lokasi di mana Anda menyimpan Chromedriver
        System.setProperty("webdriver.chrome.driver", "D:\\MyTools\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Buka halaman login
        driver.get("https://www.saucedemo.com/");

        // Data login yang benar
        String username = "standard_user";
        String password = "secret_sauce";

        // Masukkan username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
        // Masukkan password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        // Klik tombol Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Menunggu hingga halaman produk muncul
        try {
            Thread.sleep(3000); // Tunggu 3 detik untuk keperluan demonstrasi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ambil title halaman untuk verifikasi bahwa login berhasil
        String pageTitle = driver.getTitle();

        // Verifikasi login berhasil
        Assert.assertEquals("Swag Labs", pageTitle);
    }

    @AfterTest
    public void tearDown() {
        // Menutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}
