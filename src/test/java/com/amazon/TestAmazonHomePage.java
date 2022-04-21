package com.amazon;

import base.TestBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAmazonHomePage extends TestBasePage {

    // region 1st test case (write better assertion)
    @Test
    public void testRealismWallArtItemListings() {
        Homepage homepage = new Homepage();
        AmazonHomePage amazonHomePage = homepage.navigateToAmazonHomePage();
        amazonHomePage.furnitureButton.click();
        amazonHomePage.shopAllLivingRoomFurnitureButton.click();
        amazonHomePage.wallArtButton.click();
        amazonHomePage.realismStyleButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com";
        Assert.assertEquals(actualTitle, expectedTitle, "ACTUAL DOES NOT MATCH EXPECTED RESULT");

    }
    // endregion

    // region 2nd test case
    @Test
    public void testFilterTVItemListings() {
        Homepage homepage = new Homepage();
        AmazonHomePage amazonHomePage = homepage.navigateToAmazonHomePage();

        amazonHomePage.electronicsButton.click();
        amazonHomePage.tvVideoIcon.click();
        amazonHomePage.twentyTwentyOneCheckbox.click();

        amazonHomePage.lowPriceTextField.sendKeys("750");
        amazonHomePage.highPriceTextField.sendKeys(("1500"));
        amazonHomePage.goSearchButton.click();

        WebElement highPriceValue = driver.findElement(By.xpath("//li[@id='p_36/price-range']//input[@value='1,500']"));
        String actualText = highPriceValue.getAttribute("value");
        String expectedText = "1,500";
        System.out.println("Currently viewing 2021 TVs that cost no more than $" + actualText + " dollars.");
        Assert.assertEquals(actualText, expectedText, "ACTUAL DOES NOT MATCH EXPECTED RESULT");

    }
    // endregion

    // region 3rd test case
    @Test
    public void testSendFeedbackSurvey() {
        Homepage homepage = new Homepage();
        AmazonHomePage amazonHomePage = homepage.navigateToAmazonHomePage();
        Actions actions = new Actions(driver);

        actions.moveToElement(amazonHomePage.discoverHyperlinkHover).build().perform();
        actions.moveToElement(amazonHomePage.discoverPanel).click().build().perform();

        amazonHomePage.startLikingNowButton.click();

        // SO MUCH CLICKING LOL MY BAD
        amazonHomePage.dislikeButtonOne.click();
        amazonHomePage.likeButtonOne.click();
        amazonHomePage.likeButtonTwo.click();
        amazonHomePage.likeButtonThree.click();
        amazonHomePage.dislikeButtonTwo.click();
        amazonHomePage.dislikeButtonThree.click();
        amazonHomePage.likeButtonFour.click();
        amazonHomePage.likeButtonFive.click();
        amazonHomePage.likeButtonSix.click();
        amazonHomePage.exploreMoreCoffeeTablesPanel.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Discover your style - Coffee Tables | Amazon.com";
        Assert.assertEquals(actualTitle, expectedTitle, "ACTUAL DOES NOT MATCH EXPECTED RESULT");

    }
    // endregion

    // region 4th test case
    @Test
    public void testGardenOutdoorHoverAddItemToCart() throws InterruptedException {
        Homepage homepage = new Homepage();
        AmazonHomePage amazonHomePage = homepage.navigateToAmazonHomePage();
        Actions actions = new Actions(driver);

        actions.moveToElement(amazonHomePage.gardenOutdoorHyperlinkHover).build().perform();
        actions.moveToElement(amazonHomePage.hammocksHyperLink).click().build().perform();

        amazonHomePage.hammockItemListing.click();
        amazonHomePage.hammockAddToCartButton.click();
        amazonHomePage.noThanksToWarrantyCoverageButton.click();
        String actualText = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
        String expectedText = "Added to Cart";
        Assert.assertEquals(actualText, expectedText);

    }
    // endregion

    // region 5th test case (TBD)
    @Test
    public void testNavigatingToAmazonHomeItemThroughHomepageDropdown() {
        Homepage homepage = new Homepage();
        AmazonHomePage amazonHomePage = homepage.navigateToAmazonHomePage();
        Actions actions = new Actions(driver);

        driver.navigate().back();
    }



    // endregion

}
