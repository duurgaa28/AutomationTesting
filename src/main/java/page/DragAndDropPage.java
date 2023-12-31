package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Draggable n°1']")
	WebElement draggableOne;
	@FindBy(xpath = "//span[text()='Draggable n°2']")
	WebElement draggableTwo;
	@FindBy(xpath = "//span[text()='Draggable n°3']")
	WebElement draggableThree;
	@FindBy(xpath = "//span[text()='Draggable n°4']")
	WebElement draggableFour;
	@FindBy(xpath = "//div[@id='mydropzone']")
	WebElement dropZone;
	@FindBy(xpath = "//div[@id='mylist']")
	WebElement dropList;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public void dragAndDropOne() {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableOne, dropZone).perform();
	}

	public void dragAndDropTwo() {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableTwo, dropZone).perform();
	}

	public void dragAndDropThree() {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableThree, dropZone).perform();
	}

	public void dragAndDropFour() {
		Actions action = new Actions(driver);
		 action.dragAndDrop(draggableFour, dropZone).perform();
		
	}
}
