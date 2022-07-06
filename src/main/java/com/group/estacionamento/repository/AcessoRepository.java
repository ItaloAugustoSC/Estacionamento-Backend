/*
 * AcessoRepository.
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

package com.group.estacionamento.repository;

import com.group.estacionamento.entitys.AcessoEntity;
import com.group.estacionamento.entitys.FuncionarioEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AcessoRepository extends CrudRepository<AcessoEntity, String> {
  List<AcessoEntity> findAll();

  AcessoEntity findByPlacaCarro(String placa_carro);
}