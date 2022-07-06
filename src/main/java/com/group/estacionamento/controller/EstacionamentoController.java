/*
 * EstacionamentoController.
 *
 * @author isantos2
 * @version 1
 * Copyright: Copyright (c) 2022
 * Company: LifeScan IP Holdings, LLC
 * This file contains trade secrets of LifeScan IP Holdings, LLC.
 * No part may be reproduced or transmitted in any
 * form by any means or for any purpose without the express written
 * permission of LifeScan IP Holdings, LLC.
 */

package com.group.estacionamento.controller;

import com.group.estacionamento.controller.apiInterface.EstacionamentoApi;
import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.AcessoRequest;
import com.group.estacionamento.model.requests.CarroRequest;
import com.group.estacionamento.model.requests.ClienteRequest;
import com.group.estacionamento.model.requests.FuncionarioRequest;
import com.group.estacionamento.model.requests.PlanoRequest;
import com.group.estacionamento.model.responses.AcessoResponse;
import com.group.estacionamento.model.responses.CarroResponse;
import com.group.estacionamento.model.responses.FuncionarioResponse;
import com.group.estacionamento.model.responses.PlanoResponse;
import com.group.estacionamento.service.EstacionamentoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstacionamentoController implements EstacionamentoApi {

  @Autowired
  EstacionamentoService estacionamentoService;

  //CLIENTE
  @Override
  @GetMapping(path = "/allClients", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<ClienteResponse> getAllClients() {
    return estacionamentoService.getClientes();
  }

  @Override
  @PostMapping(path = "/createClient", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public void createNewClient(ClienteRequest clienteRequest) throws Exception {
    estacionamentoService.createClient(clienteRequest);
  }

  @Override
  @DeleteMapping(path ="/removeClient", produces ="application/json")
  @ResponseStatus(HttpStatus.OK)
  public void removeClient(String cpf) throws Exception {
    estacionamentoService.removeClient(cpf);
  }

  //CARRO
  @Override
  @GetMapping(path = "/allCars", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<CarroResponse> getAllCars() {
    return estacionamentoService.getCarros();
  }

  @Override
  @PostMapping(path = "/createCar", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public void createNewCar(CarroRequest carroRequest) throws Exception {
    estacionamentoService.createCarro(carroRequest);
  }

  @Override
  @DeleteMapping(path ="/removeCar", produces ="application/json")
  @ResponseStatus(HttpStatus.OK)
  public void removeCar(String placa) throws Exception {
    estacionamentoService.removeCarro(placa);
  }

  //PLANO
  @Override
  @GetMapping(path = "/allPlans", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<PlanoResponse> getAllPlans() {
    return estacionamentoService.getPlanos();
  }

  @Override
  @PostMapping(path = "/createPlan", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public void createNewPlan(PlanoRequest planoRequest) throws Exception {
    estacionamentoService.createPlano(planoRequest);
  }

  @Override
  @DeleteMapping(path ="/removePlan", produces ="application/json")
  @ResponseStatus(HttpStatus.OK)
  public void removePlan(String modalidade) throws Exception {
    estacionamentoService.removePlano(modalidade);
  }

  //FUNCIONARIO
  @Override
  @GetMapping(path = "/allEmployees", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<FuncionarioResponse> getAllEmployees() {
    return estacionamentoService.getFuncionarios();
  }

  @Override
  @PostMapping(path = "/createEmployee", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public void createNewEmployee(FuncionarioRequest funcionarioRequest) throws Exception {
    estacionamentoService.createFuncionario(funcionarioRequest);
  }

  @Override
  @DeleteMapping(path ="/removeEmployee", produces ="application/json")
  @ResponseStatus(HttpStatus.OK)
  public void removeEmployee(int id) throws Exception {
    estacionamentoService.removeFuncionario(id);
  }

  //ACESSO
  @Override
  @GetMapping(path = "/allAccess", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<AcessoResponse> getAllAccess() {
    return estacionamentoService.getAcessos();
  }

  @Override
  @PostMapping(path = "/createAccess", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public void createNewAccess(AcessoRequest acessoRequest) throws Exception {
    estacionamentoService.createAcesso(acessoRequest);
  }

  @Override
  public void removeAccess( String placa_carro) throws Exception {
    estacionamentoService.removeAcesso( placa_carro);
  }

}