Feature: Como empleado administrativo
  necesito ingresar al sistema los estudiantes de los nuevos ciclos académicos
  con el fin de cumplir las políticas administrativas y de auditoría de la universidad

  Scenario: Ingreso de un estudiante con los campos obligatorios
    Given Que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes
    When El empleado administrativo ingresa los campos obligatorios y confirma la acción
    Then El sistema deberá mostrar por pantalla el registro del estudiante ingresado
