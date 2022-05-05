Feature: Gadget snow

  Scenario: Comparar especificaciones de 2 laptops
    Given usuario ingresa a la web de Gadget snow
    When usuario selecciona la primera laptop "Lenovo 100e"
    And usuario selecciona la segunda laptop "Lenovo 300w"
    And usuario presiona el boton compare
    Then se muestra resultado de comparacion
    And usuario extrae informacion de tabla SUMMARY en archivo excel