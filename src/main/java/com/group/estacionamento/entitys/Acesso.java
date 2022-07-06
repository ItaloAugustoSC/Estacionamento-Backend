/*
 * Acesso.
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

package com.group.estacionamento.entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "acesso")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Acesso {

  @Column
  private Date hr_entrada;

  @Column
  private Date hr_saida;

  @Column
  private boolean status_pagamento;

  @Column
  private String placa_carro;

  @Column
  private String modalidade_plano;

  @Id
  @Column
  private int id_funcionario;

}