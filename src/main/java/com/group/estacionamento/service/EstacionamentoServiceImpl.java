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

import com.group.estacionamento.entitys.CarroEntity;
import com.group.estacionamento.entitys.ClienteEntity;
import com.group.estacionamento.entitys.PlanoEntity;
import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.CarroRequest;
import com.group.estacionamento.model.requests.ClienteRequest;
import com.group.estacionamento.model.requests.PlanoRequest;
import com.group.estacionamento.model.responses.CarroResponse;
import com.group.estacionamento.model.responses.PlanoResponse;
import com.group.estacionamento.repository.CarroRepository;
import com.group.estacionamento.repository.ClienteRepository;
import com.group.estacionamento.repository.PlanoRepository;
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
  @Autowired
  private final CarroRepository carroRepository;
  @Autowired
  private final PlanoRepository planoRepository;
  EstacionamentoMapper estacionamentoMapper = Mappers.getMapper(EstacionamentoMapper.class);

  //CLIENTE
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

  //CARRO
  @Override
  public List<CarroResponse> getCarros() {
    List<CarroEntity> carros = carroRepository.findAll();
    List<CarroResponse> map = estacionamentoMapper.carroMapper(carros);
    return map;
  }

  @Override
  public void createCarro(CarroRequest carroRequest) throws Exception {
    if(planoRepository.findAll().isEmpty()){
      throw new Exception("There's no plan registered in database!");
    }
    if(clienteRepository.findAll().isEmpty()){
      throw new Exception("There's no client registered in database!");
    }
    if(carroRepository.findById(estacionamentoMapper.carReqToEnt(carroRequest).getPlaca()).equals(estacionamentoMapper.carReqToEnt(carroRequest))){
      throw new Exception("Car with plaque " + carroRequest.getPlaca() + " already exists in database!");
    }

    CarroEntity carro = CarroEntity.builder()
        .chave_no_local(carroRequest.getChave_no_local())
        .cpf_cliente(carroRequest.getCpf_cliente())
        .placa(carroRequest.getPlaca())
        .plano_modalidade(carroRequest.getPlano_modalidade())
        .build();

    carroRepository.save(carro);
  }

  @Override
  public void removeCarro(String placa) throws Exception {
    if(carroRepository.findById(placa) == null){
      throw new Exception("Doesn't exists a car with plaque " + placa + " in database!");
    }

    clienteRepository.deleteById(placa);
  }

  //PLANO
  @Override
  public List<PlanoResponse> getPlanos() {
    List<PlanoEntity> planos = planoRepository.findAll();
    List<PlanoResponse> map = estacionamentoMapper.planoMapper(planos);
    return map;
  }

  @Override
  public void createPlano(PlanoRequest planoRequest) throws Exception {
    if(planoRepository.findById(estacionamentoMapper.planReqToEnt(planoRequest).getModalidade()).equals(estacionamentoMapper.planReqToEnt(planoRequest))){
      throw new Exception("Plan with modality " + planoRequest.getModalidade() + " already exists in database!");
    }

    PlanoEntity plano = PlanoEntity.builder()
        .modalidade(planoRequest.getModalidade())
        .tempo(planoRequest.getTempo())
        .valor_hora(planoRequest.getValor_hora())
        .build();

    planoRepository.save(plano);
  }

  @Override
  public void removePlano(String modalidade) throws Exception {
    if(planoRepository.findById(modalidade) == null){
      throw new Exception("Doesn't exists a plan with modality " + modalidade + " in database!");
    }

    planoRepository.deleteById(modalidade);
  }

  //FUNCIONARIO



  //ACESSO




}