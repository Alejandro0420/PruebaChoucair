package Automatizacion.webElements.packg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Automatizacion.pom.Base;

public class DropdownList_Page extends Base{
	//Traemos los campos con lista desplegable
	By dropdownList_Months = By.name("birthMonth");
	By dropdownList_Day = By.name("birthDay");
	By dropdownList_Year = By.name("birthYear");
	
	//Traemos la información creada en uTest
	protected WebDriver driver;
	//seleccione el botón Join Today
		By registerLinkLocator = By.linkText("Join Today");
	//nos redirecciona a la pagina de registro
		By registerPageLocator = By.className("step-title");
	//Seleccionamos campos donde diligenciaremos la información 
		By usernameLocator = By.id("firstName");
		By lastnameLocator = By.id("lastName");
		By emailLocator = By.id("email");
		By nextBtnLocator = By.cssSelector("[class='btn btn-blue']");

		
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() {
		click(registerLinkLocator);
		
		if (isDisplayed(registerPageLocator)) {
			type("Alejandro",usernameLocator);
			type("Florez", lastnameLocator);
			type("katherinepradav@gmail.com",emailLocator);
			
			click(nextBtnLocator);
		}else {
			System.out.println("El usuario no se ha podido registrar");
		}
	}
	
	//Estamos creando una lista con todas las opciones
	public String selectDropdownList_Day() {
		WebElement dropdownList = findElement(dropdownList_Day);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if(getText(options.get(i)).equals("10"));{
			click(options.get(i));
		}
	}
	String selectOption="";
	for (int i = 0; i < options.size(); i++) {
		if(options.get(i).isSelected())
			selectOption = getText(options.get(i));
	}
	return selectOption;
  }
	public String selectDropdownList_Month() {
		Select selectList = new Select(findElement(dropdownList_Months));
		selectList.deselectByVisibleText("October");
		return getText(selectList.getFirstSelectedOption());
	}

}
