Feature: Comprar Pack

  Background: Cargar GascoPacks y abrir Navegador
    Given Cargar GascoPacks
    When open BrowserStack Multiple

  @RegressionMiddle
  Scenario Outline: PAC-TC-1 Realizar compra de pack exitosa
    Then marcar el check de terminos y condiciones
    And click en comprar pack
    And cargar datos de prueba API
    And seleccionar pack y hacer click en boton continuar
    And ingresar datos de formulario "<id>"
    And ingresar codigo de seguridad e ir a pagar
    And ingresar datos de pago y realizar pago
    And enviar mensaje telegram termino de prueba

    #And ingresar datos de formulario
    #And Cargar Datos Csv
    Examples:
      | id |  |  |
      | 0  |  |  |

  @RegressionMiddle
  Scenario Outline: PAC-TC-2 TESTING
    Then marcar el check de terminos y condiciones
    And click en comprar pack
    And cargar datos de prueba API
    And seleccionar pack y hacer click en boton continuar
    And ingresar datos de formulario "<id>"
    And ingresar codigo de seguridad e ir a pagar
    And ingresar datos de pago y realizar pago
    And enviar mensaje telegram termino de prueba

    #And ingresar datos de formulario
    #And Cargar Datos Csv
    Examples:
      | id |  |  |
      | 0  |  |  |
