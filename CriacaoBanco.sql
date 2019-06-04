-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeFantasia` VARCHAR(200) NULL,
  `razaoSocial` VARCHAR(200) NULL,
  `endereco` VARCHAR(500) NULL,
  `telefone` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  `estoque` INT NOT NULL,
  `estoqueMinimo` INT NOT NULL,
  `precoVenda` FLOAT NOT NULL,
  `modelo` VARCHAR(100) NOT NULL,
  `precoCompra` FLOAT NOT NULL,
  `dataCadastramento` DATE NOT NULL,
  `aliquota` FLOAT NOT NULL,
  `unidade` VARCHAR(2) NOT NULL,
  `idFornecedor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produto_Fornecedor_idx` (`idFornecedor` ASC),
  CONSTRAINT `fk_Produto_Fornecedor`
    FOREIGN KEY (`idFornecedor`)
    REFERENCES `mydb`.`Fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Caixa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `saldo` FLOAT NOT NULL,
  `contasReceber` FLOAT NOT NULL,
  `contasPagar` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeFantasia` VARCHAR(200) NOT NULL,
  `razaoSocial` VARCHAR(200) NOT NULL,
  `CPF/CNPJ` VARCHAR(200) NOT NULL,
  `tipoPessoa` VARCHAR(1) NOT NULL,
  `endereco` VARCHAR(500) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CPF/CNPJ_UNIQUE` (`CPF/CNPJ` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `horario` VARCHAR(5) NOT NULL,
  `valor` FLOAT NOT NULL,
  `tipo` INT(1) NOT NULL,
  `idUsuario` INT NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Agenda_Usuario1_idx` (`idUsuario` ASC) ,
  INDEX `fk_Agenda_Cliente1_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_Agenda_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `mydb`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agenda_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `raca` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(2) NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pet_Cliente1_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_Pet_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoVenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataEmissao` DATE NOT NULL,
  `valorTotal` FLOAT NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PedidoVenda_Cliente1_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_PedidoVenda_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoVendaProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoVendaProduto` (
  `idPedidoVenda` INT NOT NULL,
  `idProduto` INT NOT NULL,
  `quantidade` INT NULL,
  PRIMARY KEY (`idPedidoVenda`, `idProduto`),
  INDEX `fk_PedidoVenda_has_Produto_Produto1_idx` (`idProduto` ASC) ,
  INDEX `fk_PedidoVenda_has_Produto_PedidoVenda1_idx` (`idPedidoVenda` ASC) ,
  CONSTRAINT `fk_PedidoVenda_has_Produto_PedidoVenda1`
    FOREIGN KEY (`idPedidoVenda`)
    REFERENCES `mydb`.`PedidoVenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PedidoVenda_has_Produto_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `mydb`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoCompra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataEmissao` DATE NULL,
  `dataPrevisao` DATE NULL,
  `valorTotal` VARCHAR(45) NULL,
  `Fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PedidoCompra_Fornecedor1_idx` (`Fornecedor_id` ASC) ,
  CONSTRAINT `fk_PedidoCompra_Fornecedor1`
    FOREIGN KEY (`Fornecedor_id`)
    REFERENCES `mydb`.`Fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoCompraProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoCompraProduto` (
  `idPedidoCompra` INT NOT NULL,
  `idProduto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idPedidoCompra`, `idProduto`),
  INDEX `fk_PedidoCompra_has_Produto_Produto1_idx` (`idProduto` ASC) ,
  INDEX `fk_PedidoCompra_has_Produto_PedidoCompra1_idx` (`idPedidoCompra` ASC) ,
  CONSTRAINT `fk_PedidoCompra_has_Produto_PedidoCompra1`
    FOREIGN KEY (`idPedidoCompra`)
    REFERENCES `mydb`.`PedidoCompra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PedidoCompra_has_Produto_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `mydb`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

ALTER TABLE `mydb`.`fornecedor` 
ADD COLUMN `CNPJ` VARCHAR(12) NOT NULL AFTER `telefone`,
ADD COLUMN `ativo` INT(1) NOT NULL AFTER `CNPJ`,
CHANGE COLUMN `nomeFantasia` `nomeFantasia` VARCHAR(200) NOT NULL ,
CHANGE COLUMN `razaoSocial` `razaoSocial` VARCHAR(200) NOT NULL ,
CHANGE COLUMN `endereco` `endereco` VARCHAR(500) NOT NULL ,
CHANGE COLUMN `telefone` `telefone` VARCHAR(12) NOT NULL ,
ADD UNIQUE INDEX `CNPJ_UNIQUE` (`CNPJ` ASC);

ALTER TABLE `mydb`.`pedidocompraproduto` 
ADD COLUMN `valor` FLOAT NOT NULL AFTER `quantidade`;
ALTER TABLE `mydb`.`agenda` 
ADD COLUMN `concluido` TINYINT NOT NULL AFTER `idCliente`;
ALTER TABLE `mydb`.`agenda` 
CHANGE COLUMN `data` `data` VARCHAR(11) NOT NULL ;
ALTER TABLE `mydb`.`pedidocompra` 
CHANGE COLUMN `dataEmissao` `dataEmissao` VARCHAR(11) NOT NULL ,
CHANGE COLUMN `dataPrevisao` `dataPrevisao` VARCHAR(11) NOT NULL ,
CHANGE COLUMN `valorTotal` `valorTotal` VARCHAR(45) NOT NULL ;
ALTER TABLE `mydb`.`pedidovenda` 
CHANGE COLUMN `dataEmissao` `dataEmissao` VARCHAR(11) NOT NULL ;
ALTER TABLE `mydb`.`produto` 
CHANGE COLUMN `dataCadastramento` `dataCadastramento` VARCHAR(11) NOT NULL ;
ALTER TABLE `mydb`.`cliente` 
CHANGE COLUMN `CPF/CNPJ` `CPFCNPJ` VARCHAR(200) NOT NULL ;
ALTER TABLE `mydb`.`pedidocompra` 
CHANGE COLUMN `valorTotal` `valorTotal` FLOAT NOT NULL ;
ALTER TABLE `mydb`.`agenda` 
CHANGE COLUMN `tipo` `tipo` VARCHAR(1) NOT NULL ;

CREATE TABLE `mydb`.`contasreceber` (
  `id` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `mydb`.`contaspagar` (
  `id` INT NOT NULL,
  `idFornecedor` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFornecedor_idx` (`idFornecedor` ASC) VISIBLE,
  CONSTRAINT `idFornecedor`
    FOREIGN KEY (`idFornecedor`)
    REFERENCES `mydb`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ALTER TABLE `mydb`.`pedidocompra` 
DROP FOREIGN KEY `fk_PedidoCompra_Fornecedor1`;
ALTER TABLE `mydb`.`pedidocompra` 
CHANGE COLUMN `Fornecedor_id` `idFornecedor` INT(11) NOT NULL ;
ALTER TABLE `mydb`.`pedidocompra` 
ADD CONSTRAINT `fk_PedidoCompra_Fornecedor1`
  FOREIGN KEY (`idFornecedor`)
  REFERENCES `mydb`.`fornecedor` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
ALTER TABLE `mydb`.`pedidocompra` 
ADD COLUMN `status` VARCHAR(1) NOT NULL AFTER `idFornecedor`;
ALTER TABLE `mydb`.`pedidovenda` 
ADD COLUMN `status` VARCHAR(1) NOT NULL AFTER `idCliente`;

CREATE TABLE `mydb`.`contaspagar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idFornecedor` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFornecedor_idx` (`idFornecedor` ASC) VISIBLE,
  CONSTRAINT `idFornecedor`
    FOREIGN KEY (`idFornecedor`)
    REFERENCES `mydb`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `mydb`.`contasreceber` (
  `id` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `mydb`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	ALTER TABLE `mydb`.`contasreceber` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

