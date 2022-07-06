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

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

import com.group.estacionamento.entitys.AcessoEntity;
import com.group.estacionamento.entitys.CarroEntity;
import com.group.estacionamento.entitys.ClienteEntity;
import com.group.estacionamento.entitys.FuncionarioEntity;
import com.group.estacionamento.entitys.PlanoEntity;
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
import com.group.estacionamento.repository.AcessoRepository;
import com.group.estacionamento.repository.CarroRepository;
import com.group.estacionamento.repository.ClienteRepository;
import com.group.estacionamento.repository.FuncionarioRepository;
import com.group.estacionamento.repository.PlanoRepository;
import com.group.estacionamento.service.mappers.EstacionamentoMapper;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
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
  @Autowired
  private final FuncionarioRepository funcionarioRepository;
  @Autowired
  private final AcessoRepository acessoRepository;
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
  @Override
  public List<FuncionarioResponse> getFuncionarios() {
    List<FuncionarioEntity> funcionarios = funcionarioRepository.findAll();
    List<FuncionarioResponse> map = estacionamentoMapper.funcionarioMapper(funcionarios);
    return map;
  }

  @Override
  public void createFuncionario(FuncionarioRequest funcionarioRequest) throws Exception {
    if(!funcionarioRepository.findAll().isEmpty()) {
      if (funcionarioRepository.findById(
          estacionamentoMapper.funcReqToEnt(funcionarioRequest).getId())
          .equals(estacionamentoMapper.funcReqToEnt(funcionarioRequest))) {
        throw new Exception(
            "Employee with id " + funcionarioRequest.getId() + " already exists in database!");
      }
    }

    FuncionarioEntity funcionario = FuncionarioEntity.builder()
        .cargo(funcionarioRequest.getCargo())
        .id(funcionarioRequest.getId())
        .build();

    funcionarioRepository.save(funcionario);
  }

  @Override
  public void removeFuncionario(int id) throws Exception {
    if(funcionarioRepository.findById(id) == null){
      throw new Exception("Doesn't exists a employee with id " + id + " in database!");
    }

    funcionarioRepository.deleteById(id);
  }

  //ACESSO
  @Override
  public List<AcessoResponse> getAcessos() {
    List<AcessoEntity> acessos = acessoRepository.findAll();
    List<AcessoResponse> map = estacionamentoMapper.acessoMapper(acessos);
    return map;
  }

  @Override
  public void createAcesso(AcessoRequest acessoRequest) throws Exception {
    if(!acessoRepository.findAll().isEmpty()) {
      if (acessoRepository.findByPlacaCarro(
              estacionamentoMapper.aceReqToEnt(acessoRequest).getPlacaCarro())
          .equals(estacionamentoMapper.aceReqToEnt(acessoRequest))) {
        throw new Exception(
            "Acesso with plaque " + acessoRequest.getPlacaCarro() + " already exists in database!");
      }
    }

    AcessoEntity acesso = AcessoEntity.builder()
        .hrEntrada(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(acessoRequest.getHrEntrada()))
        .hr_saida(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(acessoRequest.getHr_saida()))
        .id_funcionario(acessoRequest.getId_funcionario())
        .modalidade_plano(acessoRequest.getModalidade_plano())
        .placaCarro(acessoRequest.getPlacaCarro())
        .status_pagamento(acessoRequest.getStatus_pagamento())
        .build();

    acessoRepository.save(acesso);
  }

  @Override
  public void removeAcesso( String placa) throws Exception {

  }



}