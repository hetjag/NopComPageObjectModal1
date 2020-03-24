package NopComPageObjectModal;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;

public class BooksCategoryPage extends Utils
{
    private By _sortByDropdown = By.id("products-orderby");
    private String highToLowSelect = "Price: High to Low";

    public void selectCategoryOpitionsHighToLow() {
        sleep(3);
        dropDrownVisibletext(_sortByDropdown, highToLowSelect);
    }

    public void verifyUserShouldOnCategoryPage() {
        assertURL("books");
    }


    public void verifyPriceOrganisedHighToLow() {


        // price with $ sign
        String price1 = getTextElement(By.xpath("//div[1]/div[1]/div[2]/div[3]/div/span[@class='price actual-price']"));
        // price without $ sign - used String regex
        String price1num = price1.replace("$", "");
        // converted String to Double - so that we can sort it
        double d1 = Double.parseDouble(price1num);

        String price2 = getTextElement(By.xpath("//div[2]/div[1]/div[2]/div[3]/div/span[@class='price actual-price']"));
        String price2num = price2.replace("$", "");
        double d2= Double.parseDouble(price2num);


        String price3 = getTextElement(By.xpath("//div[3]/div[1]/div[2]/div[3]/div/span[@class='price actual-price']"));
        String price3num = price3.replace("$", "");
        double d3 = Double.parseDouble(price3num);

        // stored all double prices into Array
        Double[] prices = { d1, d2, d3 };
        // sorted them acc to Descending order - hign to low - in Array
        Arrays.sort(prices, Collections.reverseOrder());
        for (int i = 0; i < prices.length; i++) {

            System.out.println(prices[i]);
        }
        // found our Maximum price of the array
        double maxExpectedPrice = prices[0];
        System.out.println("The Expected MAX price = " + maxExpectedPrice);
        // found our Minimum price of the array
        double minExpectedPrice = prices[prices.length - 1];
        System.out.println("The Expected MIN price = " + minExpectedPrice);
        //Verify if your first product price is matching with your Maximum array value
        if (d1 == maxExpectedPrice){
            System.out.println("The prices are sorted acc to High to Low");
        }
        sleep(3);
        System.out.println(d1);
        System.out.println(maxExpectedPrice);
        System.out.println(d1==maxExpectedPrice);
        // Assert.assertTrue("The prices are NOT sorted acc to High to Low", maxExpectedPrice==d1);
        Assert.assertTrue( maxExpectedPrice==d1,"The prices are NOT sorted acc to High to Low");
        //   Assert.assertTrue("The prices are NOT sorted acc to High to Low", minExpectedPrice==d3);
        Assert.assertTrue(minExpectedPrice==d3,"The prices are NOT sorted acc to High to Low");

    }
}
