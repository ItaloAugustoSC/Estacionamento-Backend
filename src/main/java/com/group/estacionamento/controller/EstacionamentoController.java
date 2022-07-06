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
import com.group.estacionamento.model.requests.ClienteRequest;
import com.group.estacionamento.service.EstacionamentoService;
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

  @Override
  @GetMapping(path = "/allClients", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<ClienteResponse> getAllClientes() {
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
}