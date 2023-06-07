package br.unisul.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	    @Test
	    public void deveriaEfetuarLoginComDadosValidos() {
	        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
	        WebDriver browser = new ChromeDriver();
	        browser.navigate().to("http://localhost:8090/login");
	        browser.findElement(By.id("username")).sendKeys("fulano");
	        browser.findElement(By.id("password")).sendKeys("pass");
	        browser.findElement(By.id("login-form")).submit();
	        
	        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8090/login"));
	        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	        browser.quit();        
	    }
	    
	    @Test
	    public void naoDeveriaLogarComDadosInvalidos() {
	        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
	        WebDriver browser = new ChromeDriver();
	        browser.navigate().to("http://localhost:8090/login");
	        browser.findElement(By.id("username")).sendKeys("invalido");
	        browser.findElement(By.id("password")).sendKeys("123");
	        browser.findElement(By.id("login-form")).submit();

	        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8090/login?error"));
	        Assert.assertTrue("fulano", browser.getPageSource().contains("Usuário e senha inválidos."));
	        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
	        browser.quit();
	    }
}
