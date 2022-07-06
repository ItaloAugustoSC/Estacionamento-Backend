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

import com.group.estacionamento.entitys.ClienteEntity;
import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.ClienteRequest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EstacionamentoMapper {

  List<ClienteResponse> clienteMapper(List<ClienteEntity> clienteResponse);
  ClienteEntity cliReqToEnt(ClienteRequest clienteRequest);
}