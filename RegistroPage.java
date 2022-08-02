package Automatizacion.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroPage extends Base{
	
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

	public RegistroPage(WebDriver driver) {
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
	public String registeredMessage() {
		return "";
	}

}
