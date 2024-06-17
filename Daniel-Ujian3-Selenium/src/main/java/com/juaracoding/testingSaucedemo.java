package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testingSaucedemo {
    public static void main(String[] args) {
    // Lokasi penyimpanan Chromedriver
        System.setProperty("webdriver.chrome.driver", "D:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Inisialisasi WebDriver
        driver.manage().window().maximize();
        System.out.println("Maximize Windows"); //
        driver.get("https://www.saucedemo.com/"); // Web yang akan di coba testing automation
        System.out.println("Open Browser");


    // Masukkan username dan password
    // Data login yang benar
        String username = "standard_user"; // Accepted username
        String password = "secret_sauce";  // Password for all users

    // Loop untuk mencoba login sebanyak 3 kali
        for (int attempt = 1; attempt <= 3; attempt++) {
        // Masukkan username dan password
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.clear();
            usernameField.sendKeys(username);
        // Masukkan password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(password);

        // Klik tombol Login
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Tunggu hingga halaman produk muncul
            try {
                Thread.sleep(3000); // Menunggu 3 detik untuk keperluan demonstrasi automation testing
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        // Ambil title halaman untuk verifikasi bahwa login berhasil
            String pageTitle = driver.getTitle();

        // Verifikasi login berhasil
            if (pageTitle.equals("Swag Labs")) {
                System.out.println("Login berhasil");
                break; // Keluar dari loop jika login berhasil
            } else {
                System.out.println("Login gagal pada percobaan ke-" + attempt);
                if (attempt < 3) {
                    System.out.println("Mencoba login kembali...");
                }
            }

        }

        // Menutup browser
        driver.quit();
    }

}
//  automation testing Selesai...

