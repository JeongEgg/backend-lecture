package com.example.db.account;

import com.example.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
}
