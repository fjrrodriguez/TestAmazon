package code;

import org.openqa.selenium.chrome.ChromeDriver;

public class EjecutarGoogle {

    protected ChromeDriver driver;
    public void abrirGoogle(){

        //Driver que permite la ejecucion de la automatizacion desde Google
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        //Se navega hasta la direccion URL de amazon
        driver.get("https://www.amazon.com/");
        //Se ingresa a la pagina, se maximiza ventana
        driver.manage().window().maximize();
    }
}
