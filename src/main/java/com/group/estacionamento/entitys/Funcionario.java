package com.group.estacionamento.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "funcionario")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

  @Id
  @Column
  private int id;

  @Column
  private String cargo;
}
