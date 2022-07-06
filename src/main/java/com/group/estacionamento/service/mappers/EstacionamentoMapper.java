/*
 * ClienteMapper.
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

package com.group.estacionamento.service.mappers;

import com.group.estacionamento.entitys.CarroEntity;
import com.group.estacionamento.entitys.ClienteEntity;
import com.group.estacionamento.entitys.PlanoEntity;
import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.CarroRequest;
import com.group.estacionamento.model.requests.ClienteRequest;
import com.group.estacionamento.model.requests.PlanoRequest;
import com.group.estacionamento.model.responses.CarroResponse;
import com.group.estacionamento.model.responses.PlanoResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EstacionamentoMapper {

  //Cliente
  List<ClienteResponse> clienteMapper(List<ClienteEntity> clienteEntities);
  ClienteEntity cliReqToEnt(ClienteRequest clienteRequest);

  //Carro
  List<CarroResponse> carroMapper(List<CarroEntity> carroEntities);
  CarroEntity carReqToEnt(CarroRequest carroRequest);

  //Plano
  List<PlanoResponse> planoMapper(List<PlanoEntity> planoEntities);
  PlanoEntity planReqToEnt(PlanoRequest planoRequest);


  //Funcionario


  //Acesso


}