package demo;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import demo.utils.ExcelDataProvider;

public class TestCases extends ExcelDataProvider{ // Lets us read the data
        ChromeDriver driver;
        //WebDriverWait wait;
        SoftAssert softAssert = new SoftAssert();
        /*
         * TODO: Write your tests here with testng @Test annotation.
         * Follow `testCase01` `testCase02`... format or what is provided in
         * instructions
         */
        @Test
        public void testCase01() throws InterruptedException{
                System.out.println("Start of testcase01");
                Thread.sleep(3000);
                driver.get("https://www.youtube.com/");
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                softAssert.assertTrue(driver.getCurrentUrl().contains("youtube.com"),"Current url is wrong");
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href$='.com/about/']")));
                WebElement about=driver.findElement(By.cssSelector("a[href$='.com/about/']"));
                about.click();
                softAssert.assertTrue(driver.getCurrentUrl().contains("about.youtube"),"Current url is wrong");
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
                WebElement aboutMessage=driver.findElement(By.tagName("h1"));
                if(aboutMessage.getText().contains("About"))
                        System.out.println("About Message : "+aboutMessage.getText());
                
                System.out.println("End of testcase01");
                Thread.sleep(3000);
        }
        @Test
        public void testCase02() throws InterruptedException{
                System.out.println("Start of testcase02");
                Thread.sleep(3000);
                driver.get("https://www.youtube.com/");
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //yt-formatted-string[contains(text(),'Movies')]")));
                WebElement moviesTab=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //yt-formatted-string[contains(text(),'Movies')]")));
                moviesTab.click();
                String topSellingNextButtonXpath="//span[contains(text(),'Top selling')]/ancestor::div[@id='dismissible']/descendant::button[@aria-label=\"Next\"]";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(topSellingNextButtonXpath)));
                WebElement topSellingNextButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(topSellingNextButtonXpath)));
                while (true) { 
                        if(topSellingNextButton.isDisplayed() && topSellingNextButton.isEnabled()){
                                topSellingNextButton.click();
                        }
                        else
                                break;
                }
                String ratingsXpath="//span[contains(text(),'Top selling')]/ancestor::div[@id='dismissible']/descendant::p[contains(text(),'U') or contains(text(),'A')]";
                List<WebElement> ratings=driver.findElements(By.xpath(ratingsXpath));
                boolean f=false;
                for(WebElement r:ratings){
                        System.out.println(r.getText());
                        if(r.getText().equals("A")){
                                f=true;
                                break;
                        }
                }
                
                
                softAssert.assertTrue(f,"A rating not present");
                f=false;
                String movieCatXpath="//span[contains(text(),'Top selling')]/ancestor::div[@id='dismissible']/descendant::span[contains(text(),' • ')]";
                List<WebElement> movieCat=driver.findElements(By.xpath(movieCatXpath));
                String[] category={"Comedy","Action","Romance"};
                for(WebElement c:movieCat){
                        if(c.getText().contains("Comedy")){
                                f=true;
                        }
                }
                softAssert.assertTrue(f,"Movie category ");
                //Thread.sleep(3000);
                System.out.println("End of testcase02");
                Thread.sleep(3000);
        }

        @Test
        public void testCase03 () throws InterruptedException{
                System.out.println("Start of testcase03");
                Thread.sleep(3000);
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                driver.get("https://www.youtube.com/");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //yt-formatted-string[contains(text(),'Music')]")));
                WebElement musicTab=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //yt-formatted-string[contains(text(),'Music')]")));
                musicTab.click();
                //Thread.sleep(5000);
                String NextButtonXpath="(//button[@aria-label='Next'])[1]";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NextButtonXpath)));
                WebElement NextButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NextButtonXpath)));
                int i=0;
                while (true) { 
                        if(NextButton.isDisplayed() && NextButton.isEnabled()){
                                NextButton.click();
                                System.out.println(i++);
                                //Thread.sleep(3000);
                        }
                        else
                                break;
                }
                WebElement playlistTitle=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//span[@role='text' and contains(text(),'Hitlist')])[7]"))));
                WebElement noOfTracks=driver.findElement(By.xpath("(//div[@class='badge-shape-wiz__text' and contains(text(),'songs')])[11]"));
                System.out.println(playlistTitle.getText());
                int intTrack=Integer.parseInt(noOfTracks.getText().split(" songs")[0]);
                softAssert.assertTrue(intTrack<=50,"Movie category ");
                System.out.println("End of testcase03");
                Thread.sleep(3000);
        }
        
        @Test
        public void testCase04() throws InterruptedException{
                System.out.println("Start of testcase04");
                Thread.sleep(3000);
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                driver.get("https://www.youtube.com/");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//yt-formatted-string[contains(text(),'News')]")));
                WebElement newsTab=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//yt-formatted-string[contains(text(),'News')]")));
                newsTab.click();
                //List<WebElement> latestNews=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='link']")));
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='link']")));
                List<WebElement> latestNews=driver.findElements((By.xpath("//div[@role='link']")));
                int sum=0;
                for(int i=0;i<3;i++){
                        //span/parent::a[@id='author-text']
                        WebElement l=latestNews.get(i);
                        WebElement newsTitle=l.findElement(By.xpath(".//span/parent::a[@id='author-text']"));
                        WebElement newsBody=l.findElement(By.xpath(".//span[@dir='auto']/ancestor::div[@id='post-text']"));
                        WebElement newsLikes=l.findElement(By.id("vote-count-middle"));
                        int likes=Integer.parseInt(newsLikes.getText().trim());
                        sum+=likes;
                        System.out.println("News Title : "+newsTitle.getText());
                        System.out.println("News body : "+newsBody.getText());
                        System.out.println(likes);
                }
                System.out.println("Sum of Likes : "+sum);
                System.out.println("End of testcase04");
                Thread.sleep(3000);
        }
        
        @Test(dataProvider="excelData")
        public void testCase05(String searchTerm) throws InterruptedException{
                System.out.println("Start of testcase05");
                Thread.sleep(3000);
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                driver.get("https://www.youtube.com/");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
                WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
                searchBox.sendKeys(searchTerm+Keys.ENTER);
                double totalViews=0;
                while(totalViews<300000000){
                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ytd-video-renderer//span[contains(text(), 'views')]")));
                        List<WebElement> videosViewsList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ytd-video-renderer//span[contains(text(), 'views')]")));
                        for(WebElement v:videosViewsList){
                                String viewsString=v.getText().replaceAll("[^0-9KMB]", "");
                                System.out.println(viewsString);
                                double views=0;
                                if(viewsString.endsWith("K"))
                                        views=Double.parseDouble(viewsString.replaceAll("K", ""))*1000;
                                else if(viewsString.endsWith("M"))
                                        views=Double.parseDouble(viewsString.replaceAll("M", ""))*1000000;
                                else if(viewsString.endsWith("B"))
                                        views=Double.parseDouble(viewsString.replaceAll("B", ""))*1000000000;
                                else
                                        views=Double.parseDouble(viewsString);
                                totalViews+=views;
                                if(totalViews>=300000000){
                                        System.out.println("10Cr views reached for the search item : "+ searchTerm);
                                        break;
                                }                        
                        }
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
                }
                System.out.println("Total views count : "+totalViews);
                System.out.println("End of testcase05");
                Thread.sleep(3000);
        }
        /*
         * Do not change the provided methods unless necessary, they will help in
         * automation and assessment
         */
        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                // NOT NEEDED FOR SELENIUM MANAGER
                // WebDriverManager.chromedriver().timeout(30).setup();

                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
                //wait=new WebDriverWait(driver,Duration.ofSeconds(20));
                
        }

        @AfterTest
        public void endTest() {
                driver.close();
                driver.quit();

        }
}