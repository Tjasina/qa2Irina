import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommentsCount {
    private final String URL = "http://rus.delfi.lv";
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    //private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");

    private final By HOMEPAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By ANONIMOUS_COMMENT_COUNT = By.xpath(".//span[contains(@class, 'type-cnt')]");
    private final By REGISTERED_COMMENT_COUNT = By.xpath(".//li[contains(@class, 'is-active')]");
   // private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");

    private WebDriver driver;

    @Test
    public void articleTitleCheck() {
        //Set driver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");

        //Open Browser
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        //Full screen
        driver.manage().window().maximize();

        //Open Home page
        driver.get(URL);



        //Find home page first article comments count and save it to string
        String homePageCommentCount = driver.findElement(HOMEPAGE_COMMENT_COUNT).getText();

        //Convert string to StringBuilder (we want to delete brackets!!)
        StringBuilder builder = new StringBuilder(homePageCommentCount);

        //delete last symbol ")"
        builder.deleteCharAt(homePageCommentCount.length() - 1);

        //convert back to String
        String stringHomePageCommentCount = builder.toString();

        //convert to integer and delete the first symbol
        int homePageValue = Integer.parseInt(stringHomePageCommentCount.substring(1));
        //System.out.println(homePageValue);



        //Click on article
        driver.findElement(TITLE).click();

        //Find article comments count and save it to string
        String articlePageCommentCount = driver.findElement(ARTICLE_COMMENT_COUNT).getText();

       //Convert string to StringBuilder1 (we want to delete brackets!!)
        StringBuilder builder1 = new StringBuilder(articlePageCommentCount);

        //delete last symbol ")"
        builder1.deleteCharAt(articlePageCommentCount.length() - 1);

        //convert back to String
        String stringArticlePageCommentCount = builder1.toString();

        //convert to integer and delete the first symbol
        int articlePageValue = Integer.parseInt(stringArticlePageCommentCount.substring(1));
        //System.out.println(articlePageValue);


        //Check first and second counts of comments
        Assertions.assertEquals(homePageValue,articlePageValue, "Wrong article page title!");


        //Find comment count on article page
        WebElement commentCount = driver.findElement(ARTICLE_COMMENT_COUNT);

        //Click on comment count
        commentCount.click();


        //Find anonimous comment count on comments page
        String anonimousCommentPageCount = driver.findElement(ANONIMOUS_COMMENT_COUNT).getText();

        //Convert string of anonimous comments to StringBuilder2 (we want to delete brackets!!)
        StringBuilder builder2 = new StringBuilder(anonimousCommentPageCount);

        //delete last symbol ")"
        builder2.deleteCharAt(anonimousCommentPageCount.length() - 1);

        //convert back to String
        String stringAnonimousCommentPageCount = builder2.toString();

         //convert to integer and delete the first symbol
        int anonimousCommentValue = Integer.parseInt(stringAnonimousCommentPageCount.substring(1));

       // commentCount = commentCount.substring(1, commentCount.length() -1);
      //  this.commentCount = Integer.valueOf(commentCount);


        //Find registered comment count on comments page
        String registeredCommentPageCount = driver.findElement(REGISTERED_COMMENT_COUNT).getText();

        //Convert string of anonimous comments to StringBuilder2 (we want to delete brackets!!)
        StringBuilder builder3 = new StringBuilder(registeredCommentPageCount);

        //delete last symbol ")"
        builder3.deleteCharAt(registeredCommentPageCount.length() - 1);

        //convert back to String
        String stringRegisteredCommentPageCount = builder3.toString();

        //convert to integer and delete the first symbol
        int registeredCommentValue = Integer.parseInt(stringRegisteredCommentPageCount.substring(12));


        int totalValue = anonimousCommentValue + registeredCommentValue;




        //Check summed comments count on comments page with home page comments count
       Assertions.assertEquals(homePageValue, totalValue, "Wrong article page title!");

        //close browser
    }
    @AfterEach //close browser after each test in any case. Функция должна отработать и закрыться!
    public void closeBrowser(){

        driver.close();
    }

}
