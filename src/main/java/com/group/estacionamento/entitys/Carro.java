/*
 * Carro.
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "carro")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

  @Id
  @Column
  private String placa;

  @Column
  private char chave_no_local;

  @Column
  private long cpf_cliente;

  @Column
  private String plano_modalidade;

}