package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    WebDriver loginDriver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        loginDriver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;

    @FindBy(css = ".inventory_item")
    List<WebElement> products;

    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void selectMaxValueProd() {

          double maxPrice = 0;
        WebElement productPrice = null;

        for (WebElement prod : products) {
            WebElement highestPriceProduct = prod.findElement(By.className("inventory_item_price"));
            String priceValue = highestPriceProduct.getText().replace("$", "");
            double price = Double.parseDouble(priceValue);

            if (price > maxPrice) {
                maxPrice = price;
                productPrice = prod;

            }
        }
        if(productPrice != null){
            WebElement addToCartButton = productPrice.findElement(By.cssSelector(".btn_inventory"));
            addToCartButton.click();

        }

// Below code is to select the first product - I tried this code before selecting the highest value product
//        if (!products.isEmpty()) {
//            WebElement firstProduct = products.get(0);
//
//            // Find the "Add to Cart" button for the first product
//            WebElement addToCartButton = firstProduct.findElement(By.cssSelector(".btn_inventory"));
//
//            // Click the "Add to Cart" button
//            addToCartButton.click();
//        } else {
//            System.out.println("No products found on the page.");
//        }

    }
    public void clickCartButton() {
        this.cartButton.click();
    }

    public void closeTheBrowser() { this.loginDriver.close(); }
}