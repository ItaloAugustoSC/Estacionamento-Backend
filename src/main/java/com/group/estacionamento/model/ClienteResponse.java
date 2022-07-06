/*
 * ClienteResponde.
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

package com.group.estacionamento.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {

  private String nome;
  private String cpf;
  private String celular;
}