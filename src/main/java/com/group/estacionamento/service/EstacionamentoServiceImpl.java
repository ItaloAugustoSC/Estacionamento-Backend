/*
 * EstacionamentoServiceImpl.
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

import com.group.estacionamento.entitys.ClienteEntity;
import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.ClienteRequest;
import com.group.estacionamento.repository.ClienteRepository;
import com.group.estacionamento.service.mappers.EstacionamentoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EstacionamentoServiceImpl implements EstacionamentoService{

  @Autowired
  private final ClienteRepository clienteRepository;

  EstacionamentoMapper estacionamentoMapper = Mappers.getMapper(EstacionamentoMapper.class);

  @Override
  public List<ClienteResponse> getClientes() {
    List<ClienteEntity> clientes = clienteRepository.findAll();
    List<ClienteResponse> map = estacionamentoMapper.clienteMapper(clientes);
    return map;
  }

  @Override
  public void createClient(ClienteRequest clienteRequest) throws Exception {

    if(clienteRepository.findByCpf(estacionamentoMapper.cliReqToEnt(clienteRequest).getCpf()) != null){
      throw new Exception("Client with CPF " + clienteRequest.getCpf() + " already exists in database!");
    }

    ClienteEntity clienteEntity = ClienteEntity.builder()
        .nome(clienteRequest.getNome())
        .cpf(clienteRequest.getCpf())
        .celular(clienteRequest.getCelular())
        .build();

    clienteRepository.save(clienteEntity);
  }

  @Override
  public void removeClient(String cpf) throws Exception {

    if(clienteRepository.findByCpf(cpf) == null){
      throw new Exception("Doesn't exists a client with CPF " + cpf + " in database!");
    }

    clienteRepository.deleteById(cpf);
  }

}