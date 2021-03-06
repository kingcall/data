package com.kingcall.reactorbucks.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.kingcall.reactorbucks.serializer.MoneyDeserializer;
import com.kingcall.reactorbucks.serializer.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("t_coffee")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    @Id
    private Long id;
    private String name;
    @JsonSerialize(using = MoneySerializer.class)
    @JsonDeserialize(using = MoneyDeserializer.class)
    private Money price;
    private Date createTime;
    private Date updateTime;
}
