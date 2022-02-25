import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class BMICalculator {
    //Index BMI
    //under 16   Starvation
    //16-18.5    Underweight
    //18.5-25    Normal
    //25-30      Overweight
    //30+        Obese
    // Tested woman is 165 cm tall.  Performance of the BMICalculator by equivalence classes
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void scenarioTestForOverallWork() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("84");
        driver.findElement(By.name("ht")).sendKeys("179");
        driver.findElement(By.name("cc")).click();
        boolean IsDisplayed = driver.findElement(By.name("desc")).isDisplayed();
        assertTrue(IsDisplayed);

    }


    @Test
    public void scenarioTestStarvationMaxValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("40.8");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category =driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Starvation"));
    }


    @Test
    public void scenarioTestUnderWeightMinValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("40.9");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category =driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Underweight"));
    }


    @Test
    public void scenarioTestUnderWeightMaxValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("50.3");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category =driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Underweight"));
    }


    @Test
    public void scenarioTestNormalMinValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("50.4");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category =driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Normal"));
    }


    @Test
    public void scenarioTestNormalMaxValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("68");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category =driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Normal"));
    }


    @Test
    public void scenarioTestOverWeightMinValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("68.1");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Overweight"));
    }


    @Test
    public void scenarioTestOverWeightMaxValue() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("81.6");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Overweight"));
    }


    @Test
    public void scenarioTestOverWeightMinObese() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("81.7");
        driver.findElement(By.name("ht")).sendKeys("165");
        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertTrue(category.equals("Your category is Obese"));
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

