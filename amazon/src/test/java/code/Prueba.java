package code;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Prueba {

    private ChromeDriver driver;

    //Paso 1: El usuario navega hasta la pagina de amazon www.amazon.com
    @Given("^El usuario navega en la pagina de amazon$")
    public void el_usuario_navega_en_la_pagina_de_amazon()  {


        //Driver que permite la ejecucion de la automatizacion desde Google
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        //Se navega hasta la direccion URL de amazon
        driver.get("https://www.amazon.com/");
        //Se ingresa a la pagina, se maximiza ventana
        driver.manage().window().maximize();
    }

    //Paso 2: Por medio de la barra de busqueda se agrega "Alexa" y se ejecuta la busqueda
    @When("^Busca el articulo Alexa$")
    public void busca_el_articulo_Alexa()  {
        //Se hace uso de localizador name para encontrar la barra de busqueda
        WebElement barrabusqueda = driver.findElement(By.name("field-keywords"));

        //Ingreso de la palabra "Alexa" en la barra de busqueda
        barrabusqueda.sendKeys("Alexa");

        /**  Otra opcion de busqueda de la barra de busqueda es por medio del localizador cssSelector
         *      WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
         *      searchInput.sendKeys("Alexa");
         */

        //Se busca el boton para ejecutar la busqueda por medio del localizador id
        WebElement botonbuscar = driver.findElement(By.id("nav-search-submit-button"));

        //Se da clic en el boton
        botonbuscar.click();

    }

    //Paso 3: El usuario se dirigue a la pagina dos de los resultados obtenidos para la busqueda "Alexa"
    @When("^Navega a la pagina dos de los resultados de busqueda obtenidos$")
    public void navega_a_la_pagina_dos_de_los_resultados_de_busqueda_obtenidos() {

        //Se encuentra la opcion para ir a la pagina dos por medio del localizador linkText
    WebElement pagdos = driver.findElement(By.linkText("2"));
    //Se da clic en la opcion para dirigirse a la pagina 2
    pagdos.click();

    }

    //Paso 4: Se selecciona el producto 3 de la lista presentada
    @When("^Selecciona el tercer item de los resultados$")
    public void selecciona_el_tercer_item_de_los_resultados() throws InterruptedException {
        // Espera hasta que la pagina cargue
        WebDriverWait espera = new WebDriverWait(driver, 3); // Establece un tiempo de espera máximo de 3 segundos

        //Se ubica el item 3 por medio del localizador xpath seleccinando la imagen del producto
        WebElement itemtres = espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[3]")));
        //Se da click sobre la imagen del item 3
        itemtres.click();
    }
    //Paso 5: Se cambia la cantidad del producto seleccionado a dos unidades y se carga al carrito de compras
    @Then("^Agrega al carrito mas de dos unidades del tercer item si esta disponible para compra$")
    public void agrega_al_carrito_mas_de_dos_unidades_del_tercer_item_si_esta_disponible_para_compra() throws InterruptedException {
       //Esperar que la pagina cargue
        WebDriverWait esperar = new WebDriverWait(driver, 3); // Establece un tiempo de espera máximo de 3 segundos
        //Se ubica la opcion para modificar la cantidad por medio del localizador id del boton
        WebElement cant = esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-autoid-0-announce")));
        //Se da clic sobre el boton
        cant.click();
        //Se ubica la opcion de agregar dos unidades por medio del localizador xpath
        WebElement elementoDeseado = driver.findElement(By.xpath("(//li[@class='a-dropdown-item'])[2]"));
        //Se da clic sobre el "2"
        elementoDeseado.click();

        //Se busca el boton "agregar al carrito" por medio del localizador xpath
        WebElement carrito = driver.findElement(By.xpath("(//div[@class='a-button-stack'])[1]"));
        //Se da clic sobre el boton 
        carrito.click();
        }
    }

