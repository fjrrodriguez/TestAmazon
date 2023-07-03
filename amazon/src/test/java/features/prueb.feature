Feature: Buscar producto en amazon

  Scenario: cargar al carrito de compra un producto encontrado a traves de busqueda con nombre del articulo
    Given El usuario navega en la pagina de amazon
    When Busca el articulo Alexa
    And Navega a la pagina dos de los resultados de busqueda obtenidos
    And Selecciona el tercer item de los resultados
    Then Agrega al carrito mas de dos unidades del tercer item si esta disponible para compra