package br.unisul.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver browser = new ChromeDriver();
		// abrir o navegador classe principal do Selenium WebDriver, criando uma varíavel browser do tipo webdriver
		// sendo uma interface, no momento da instanciação precisamos passar qual será a implementação. 
		// já que queremos utilizar o Chrome, instanciaremos um novo ChromeDriver()
			
			browser.navigate().to("http://localhost:8090/leiloes");
			// abrirmos o endereço da aplicação. 
			// a partir da variável browser, chamaremos o método navigate().to() passando uma string com o endereço da página que queremos acessar. 
			
			browser.quit();
			// para não mantermos uma janela do navegador aberta, vamos fechá-la como método browser.quit().
	}

}
