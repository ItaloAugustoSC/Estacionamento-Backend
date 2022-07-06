/*
 * EstacionamentoApi.
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

package com.group.estacionamento.controller.apiInterface;

import com.group.estacionamento.model.ClienteResponse;
import com.group.estacionamento.model.requests.ClienteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(value = "estacionamento")
public interface EstacionamentoApi {
  @ApiOperation(value = "Returning clients")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad request"),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 500, message = "Internal Server Failure")
  })
  List<ClienteResponse> getAllClientes();

  @ApiOperation(value = "Creating new client")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad request"),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 500, message = "Internal Server Failure")
  })
  void createNewClient(ClienteRequest clienteRequest) throws Exception;

  @ApiOperation(value = "Removing a client")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad request"),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 500, message = "Internal Server Failure")
  })
  void removeClient(String cpf) throws Exception;

}