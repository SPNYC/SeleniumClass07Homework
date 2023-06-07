package class07.Homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;
import java.util.List;

/*
goto http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
login
click on PIM

from the table choose any ID
and print out the row number of that id

please make sure that ur code is dynamic enough to cater if another row gets delted , it still prints the row correctly

 */
public class HW extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "safari";
        openBrowserAndLaunchApplication(url, browser);

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        //password text box
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        //login Btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@id,'Login')]"));
        loginBtn.click();

        //wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Thread.sleep(3000);
        //click on the PIM tab
        WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimTab.click();

        //print the number of the row that has the id 56355A
        List<WebElement> allIDs = driver.findElements(By.xpath("//table/tbody/tr[6]/td[2]"));

        //look for id 56355A
        for (int i = 0; i < allIDs.size(); i++) {
            String id = allIDs.get(i).getText();
            if (id.equals("56355A")) {
               System.out.println("the id is on the row number " + (i + 1));

            }
        }
    }
}
