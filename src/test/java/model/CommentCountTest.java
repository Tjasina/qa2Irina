package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CommentCountTest {
    private final String URL = "http://rus.delfi.lv";

    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.tagName("h1");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains(@class,'text-red-ribbon')]");
    private final By COMMENT = By.className("type-cnt");

    private static final Logger LOGGER = LogManager.getLogger(CommentCountTest.class);

    @Test
    public void commentCountCheck() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        List<WebElement> articles = driver.findElements(ARTICLE);
        Article article = getArticle(articles, 3);


        String homePageTitleTxt = article.getTitle();
        Integer homePageComments = article.getCommentCount();

        articles.get(3).click();


        String articlePageTitleTxt = article.getTitle();
        Integer articlePageComments = article.getCommentCount();

        Assertions.assertEquals(homePageTitleTxt, articlePageTitleTxt, "Wrong article page title!");
        Assertions.assertEquals(homePageComments, articlePageComments, "Wrong article comments count");


        WebElement articlePageTitleCommentLink = driver.findElement(COMMENT_COUNTER);
        articlePageTitleCommentLink.click();

        List<WebElement> comments = driver.findElements(COMMENT);

        String commentPageTitle = article.getTitle();


        String commentPageAnonimousCommentsTxt = comments.get(0).getText();
        commentPageAnonimousCommentsTxt = commentPageAnonimousCommentsTxt.substring(1, commentPageAnonimousCommentsTxt.length() - 1);
        Integer commentPageAnonimousComments = Integer.valueOf(commentPageAnonimousCommentsTxt);


        String commentPageRegisteredCommentsTxt = comments.get(1).getText();
        commentPageRegisteredCommentsTxt = commentPageRegisteredCommentsTxt.substring(1, commentPageRegisteredCommentsTxt.length() - 1);
        Integer commentPageRegisteredComments = Integer.valueOf(commentPageRegisteredCommentsTxt);


        Integer commentPageComments = commentPageRegisteredComments + commentPageAnonimousComments;

        Assertions.assertEquals(articlePageTitleTxt, commentPageTitle, "Wrong article page title!");
        Assertions.assertEquals(articlePageComments, commentPageComments, "Wrong article page comments!");

    }


    private Article getArticle(List<WebElement> elements, int i) {
        WebElement article = elements.get(i);

        Article currentArticle = new Article();
        currentArticle.setTitle(article.findElement(TITLE).getText());

        List<WebElement> commentCounters = article.findElements(COMMENT_COUNTER);

        if (commentCounters.isEmpty()) {

            currentArticle.setCommentCount(0);
        } else {
            currentArticle.setCommentCount(commentCounters.get(0).getText());
        }

        return currentArticle;
    }

}



