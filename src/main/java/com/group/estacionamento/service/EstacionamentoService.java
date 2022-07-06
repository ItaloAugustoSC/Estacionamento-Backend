/*
 * EstacionamentoService.
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

package com.group.estacionamento.service;

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
import java.util.Date;
import java.util.List;

public interface EstacionamentoService {

  List<ClienteResponse> getClientes();
  void createClient(ClienteRequest clienteRequest) throws Exception;

  void removeClient(String cpf) throws Exception;

  List<CarroResponse> getCarros();
  void createCarro(CarroRequest carroRequest) throws Exception;

  void removeCarro(String placa) throws Exception;

  List<PlanoResponse> getPlanos();
  void createPlano(PlanoRequest planoRequest) throws Exception;

  void removePlano(String modalidade) throws Exception;

  List<FuncionarioResponse> getFuncionarios();
  void createFuncionario(FuncionarioRequest funcionarioRequest) throws Exception;

  void removeFuncionario(int id) throws Exception;

  List<AcessoResponse> getAcessos();
  void createAcesso(AcessoRequest acessoRequest) throws Exception;

  void removeAcesso( String placa) throws Exception;

}