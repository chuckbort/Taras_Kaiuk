import model.Job;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddJobTitlePage;
import pages.AdminPage;
import pages.LoginPage;
import pages.Page;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepsDefinitions {

    private WebDriver driver = new ChromeDriver();
    private Job internJob;

    @Given("I open page {string}")
    public void iOpenPage(String pageUrl) {
        Page page = new Page(driver);
        page.goToPage(pageUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I fill login form")
    public void iFillLoginForm() {
        LoginPage loginPage = new LoginPage(driver);
        String username = loginPage.getText(driver.findElement(new By.ByXPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")));
        String password = loginPage.getText(driver.findElement(new By.ByXPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")));
        username = username.substring(username.lastIndexOf(":") + 2);
        password = password.substring(password.lastIndexOf(":") + 2);
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.login();
    }

    @Then("I successful login")
    public void iSuccessfulLogin() {
        Page page = new Page(driver);
        String username = page.getText(driver.findElement(By.className("oxd-userdropdown-name")));
        Assert.assertEquals("Paul Collings", username);
    }

    @Given("I go to Add Job Title page \\(Admin -> Job - Job Titles page -> Click on the Add button)")
    public void iGoToAdminJobJobTitlesPage() {
        Page page = new Page(driver);

        WebElement adminButton = driver.findElement(By.xpath("//a[@href  = '/web/index.php/admin/viewAdminModule']"));
        page.clickButton(adminButton);

        WebElement jobButton = driver.findElement(By.xpath("//span[text()  = 'Job ']"));
        page.clickButton(jobButton);

        WebElement jobTitlesButton = driver.findElement(By.xpath("//a[text()  = 'Job Titles']"));
        page.clickButton(jobTitlesButton);

        WebElement addButton = driver.findElement(By.xpath("//button[@class  = 'oxd-button oxd-button--medium oxd-button--secondary']"));
        page.clickButton(addButton);
    }

    @When("I fill job title form")
    public void iFillJobTitleForm(List<Map<String, String>> table) {
        Map<String, String> jobData = table.get(0);
        this.internJob = new Job(jobData);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        AddJobTitlePage addPage = new AddJobTitlePage(driver);
        addPage.fillJobTitle(internJob.getJobTitle());
        addPage.fillJobDescription(internJob.getJobDescription());
        addPage.fillNotes(internJob.getNotes());
    }

    @And("save new job")
    public void saveNewJob() {
        AddJobTitlePage addPage = new AddJobTitlePage(driver);
        addPage.saveJob();
    }

    @Then("I successful add new Job Title")
    public void iSuccessfulAddNewJobTitle() {
        AdminPage adminPage = new AdminPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(adminPage.isJobExist(internJob.getJobTitle()));
    }

    @Given("There is my job title in Job list")
    public void thereIsMyJobTitleInJobList() {
        AdminPage adminPage = new AdminPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(adminPage.isJobExist(internJob.getJobTitle()));
    }

    @When("I select my title and delete it")
    public void iSelectMyTitleAndDeleteIt() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.selectJobTitle(internJob.getJobTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        adminPage.deleteSelectedTitle();
    }

    @Then("I successful delete my Job Title")
    public void iSuccessfulDeleteMyJobTitle() {
        AdminPage adminPage = new AdminPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertFalse(adminPage.isJobExist(internJob.getJobTitle()));
    }

    @After()
    public void closeBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
    }
}
