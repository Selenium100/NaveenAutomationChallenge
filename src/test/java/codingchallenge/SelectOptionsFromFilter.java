package codingchallenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectOptionsFromFilter {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.t-mobile.com/tablets");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);

		// selectFilter("Operating System", "all");
		// selectFilter("Operating System", "Android","iPadOS");

	}

	public static void selectFilter(String labelName, String... options) {

		driver.findElement(By.xpath("//legend[text()='" + " " + labelName + " " + "']")).click();

		for (String eachOptions : options) {
			if ((labelName.equals("Deals") || labelName.equals("Brands") || labelName.equals("Operating System"))
					&& eachOptions.equals("all")) {
				List<WebElement> allCheckBoxs = driver.findElements(By.xpath("//div[@aria-label='" + labelName
						+ "']/mat-checkbox/label/span[@class='mat-checkbox-inner-container']"));

				for (WebElement eachCheckBox : allCheckBoxs) {
					eachCheckBox.click();
				}

			} else if ((labelName.equals("Deals") || labelName.equals("Brands") || labelName.equals("Operating System"))
					&& (eachOptions.equals("New") || eachOptions.equals("Special offer")
							|| eachOptions.equals("Alcatel") || eachOptions.equals("Apple")
							|| eachOptions.equals("Samsung") || eachOptions.equals("T-Mobile®")
							|| eachOptions.equals("TCL") || eachOptions.equals("Android")
							|| eachOptions.equals("iPadOS") || eachOptions.equals("Other"))) {

				driver.findElement(By.xpath("//span[text()='" + " " + eachOptions + " "
						+ "']/../../span[@class='mat-checkbox-inner-container']")).click();

			}
		}

	}

}
