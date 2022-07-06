/*
 * AcessoResponse.
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

package com.group.estacionamento.model.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcessoResponse {

  private String hrEntrada;

  private String hr_saida;

  private char status_pagamento;

  private String placaCarro;

  private String modalidade_plano;

  private int id_funcionario;
}