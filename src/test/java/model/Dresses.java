package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Dresses {
    private final String URL = "http://automationpractice.com/index.php";

    @Test
    public void OpenUrl() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        List<WebElement> closescategories = ((ChromeDriver) driver).findElementsByClassName("sf-with-ul");
        WebElement dressesButton = closescategories.get(3);
        dressesButton.click();

        List<WebElement> dresses = ((ChromeDriver) driver).findElementsByClassName("subcategory-name");
        WebElement subcategoryButton = dresses.get(1);
        subcategoryButton.click();

        List<WebElement> prices = ((ChromeDriver) driver).findElementsByClassName("price");
        WebElement price = prices.get(4);


        List<WebElement> zeroDressPrices = ((ChromeDriver) driver).findElementsByClassName("product-price");
        WebElement zeroDressPrice = zeroDressPrices.get(1);
        String stringZeroDressPrice = zeroDressPrice.getText();


        String numbersZeroDressPrice = stringZeroDressPrice.substring(1);
        float zeroDressPriceValue = Float.parseFloat(numbersZeroDressPrice);

        System.out.println(zeroDressPriceValue);

        price.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("button-medium")));

        List<WebElement> cartes = ((ChromeDriver) driver).findElementsByClassName("icon-chevron-right");
        WebElement cart = cartes.get(1);
        cart.click();


        WebElement firstDressPrice = ((ChromeDriver) driver).findElementById("total_product_price_4_16_0");
        String stringFirstDressPrice = firstDressPrice.getText();
        String numbersFirstDressPrice = stringFirstDressPrice.substring(1);
        float firstDressPriceValue = Float.parseFloat(numbersFirstDressPrice);

        System.out.println(firstDressPriceValue);

        Assertions.assertEquals(zeroDressPriceValue, firstDressPriceValue, "Wrong price of first dress!");

        List<WebElement> closes = ((ChromeDriver) driver).findElementsByClassName("sf-with-ul");
        WebElement dressesButton0 = closes.get(3);
        dressesButton0.click();


        List<WebElement> closescategories1 = ((ChromeDriver) driver).findElementsByClassName("sf-with-ul");
        WebElement dressesButton1 = closescategories1.get(3);
        dressesButton1.click();

        List<WebElement> dresses0 = ((ChromeDriver) driver).findElementsByClassName("subcategory-name");
        WebElement subcategoryButton0 = dresses0.get(0);
        subcategoryButton0.click();

        List<WebElement> zeroDressPrices0 = ((ChromeDriver) driver).findElementsByClassName("product-price");
        WebElement zeroDressPrice0 = zeroDressPrices0.get(1);
        String stringZeroDressPrice0 = zeroDressPrice0.getText();


        String numbersZeroDressPrice0 = stringZeroDressPrice0.substring(1);
        float zeroDressPriceValue0 = Float.parseFloat(numbersZeroDressPrice0);

        System.out.println(zeroDressPriceValue0);
        zeroDressPrice0.click();


        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("button-medium")));

        List<WebElement> cartes1 = ((ChromeDriver) driver).findElementsByClassName("icon-chevron-right");
        WebElement cart1 = cartes1.get(1);
        cart1.click();


        WebElement firstDressPrice1 = ((ChromeDriver) driver).findElementById("total_product_price_3_13_0");
        String stringFirstDressPrice1 = firstDressPrice1.getText();
        String numbersFirstDressPrice1 = stringFirstDressPrice1.substring(1);
        float secondDressPriceValue = Float.parseFloat(numbersFirstDressPrice1);

        System.out.println(secondDressPriceValue);

        Assertions.assertEquals(zeroDressPriceValue0, secondDressPriceValue, "Wrong price of second dress!");

        float SumOfDressesPrices = secondDressPriceValue + firstDressPriceValue;
        float SumOfDressesPrice = new BigDecimal(SumOfDressesPrices).setScale(2, RoundingMode.DOWN).floatValue();
        System.out.println(+SumOfDressesPrice);


        WebElement totalSumOfProducts = ((ChromeDriver) driver).findElementById("total_product");
        String stringTotalProducts = totalSumOfProducts.getText();
        String numbersTotalProducts = stringTotalProducts.substring(1);
        float numberTotalProducts = Float.parseFloat(numbersTotalProducts);

        System.out.println(numberTotalProducts);

        Assertions.assertEquals(SumOfDressesPrice, numberTotalProducts, "Not equal total sum!");
    }

}