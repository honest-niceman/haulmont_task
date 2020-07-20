-- begin PRACTICE_INITIATOR
create table PRACTICE_INITIATOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIO varchar(63) not null,
    DEPARTMENT varchar(63),
    EMAIL varchar(127),
    IS_EMPLOYEE boolean,
    --
    primary key (ID)
)^
-- end PRACTICE_INITIATOR
-- begin PRACTICE_EXECUTOR
create table PRACTICE_EXECUTOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIO varchar(63) not null,
    POST varchar(63) not null,
    DEPARTMENT varchar(63) not null,
    --
    primary key (ID)
)^
-- end PRACTICE_EXECUTOR
-- begin PRACTICE_BID
create table PRACTICE_BID (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INITIATOR_ID varchar(36),
    EXECUTOR_ID varchar(36),
    STATUS varchar(50) not null,
    DESCRIPTION varchar(255),
    OPENING_DATE date,
    CLOSING_DATE date,
    IS_APPROVED boolean,
    --
    primary key (ID)
)^
-- end PRACTICE_BID
