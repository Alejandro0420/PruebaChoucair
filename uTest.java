package Automatizacion;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automatizacion.webElements.packg.DropdownList_Page;;


public class uTest {

	private WebDriver driver;
	//seleccione el botón Join Today
		By registerLinkLocator = By.linkText("Join Today");
	//nos redirecciona a la pagina de registro
		By registerPageLocator = By.className("step-title");
	//Seleccionamos campos donde diligenciaremos la información 
		By usernameLocator = By.id("firstName");
		By lastnameLocator = By.id("lastName");
		By emailLocator = By.id("email");
		By nextBtnLocator = By.cssSelector("[class='btn btn-blue']");
	//Lista
		DropdownList_Page ddLPage;
		
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//traemos la extension chromeDriver
		driver = new ChromeDriver();
		//maximizar la ventana 
		driver.manage().window().maximize();
		//redireccione al ejecutar a esta URL
		driver.get("https://www.utest.com/");
		//Traemos la lista
		ddLPage = new DropdownList_Page(driver);
	}

	//Lo que hará luego de ingresar a la URL
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}


	@Test
	//Seleccionar el botón de Join Today y redirecciona a la pagina del formulario

	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(4000);
		//isDisplayed--> Genera un valor booleano TRUE o FALSE
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			// vamos a ingresar información en los campos
			driver.findElement(usernameLocator).sendKeys("Alejandro");
			driver.findElement(lastnameLocator).sendKeys("Florez");
			driver.findElement(emailLocator).sendKeys("katherinepradav@gmail.com");
			
		}
		else {
			System.out.print("No se ha podido completar el registro");
		}
	}
	public void testing_classic_DDL() {
		ddLPage.registerUser();
		ddLPage.registerUser();
		assertEquals(ddLPage.selectDropdownList_Day(), "10");
		assertEquals(ddLPage.selectDropdownList_Month(), "October");
		driver.findElement(nextBtnLocator).click();
	}
}
