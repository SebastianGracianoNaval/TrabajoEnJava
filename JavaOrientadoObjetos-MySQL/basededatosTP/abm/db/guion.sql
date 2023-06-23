DROP SCHEMA IF EXISTS `52` ;

CREATE SCHEMA IF NOT EXISTS `52`;
USE `52` ;

-- -----------------------------------------------------
-- Table `52`.`estudiantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `52`.`estudiantes` ;

CREATE TABLE IF NOT EXISTS `52`.`estudiantes` (
  `id_estudiante` INT NOT NULL AUTO_INCREMENT,
  `dni_estudiante` INT NOT NULL,
  `nombre_estudiante` VARCHAR(45) NOT NULL,
  `edad_estudiante` INT NOT NULL,
  PRIMARY KEY (`id_estudiante`),
  UNIQUE INDEX `dni_UNIQUE` (`dni_estudiante` ASC) VISIBLE);
