create table approve_log
(
    LOG_ID      int auto_increment
        primary key,
    U_ID        int                    null,
    STATE       varchar(2) default 'U' null,
    DONE_ID     int                    null,
    CREATE_TIME timestamp              null,
    DONE_TIME   timestamp              null,
    RESULT      varchar(2)             null
);

create table approve_log_attr
(
    ATTR_ID     int auto_increment
        primary key,
    LOG_ID      int                                  null,
    A_TABLE     varchar(255)                         null,
    A_ID        varchar(255)                         null,
    STATE       varchar(2) default 'U'               null,
    APPOINT_ID  int                                  null,
    CREATE_TIME timestamp  default CURRENT_TIMESTAMP null
);

create table bm_chat
(
    CHAT_ID    int auto_increment
        primary key,
    CHAT_UID   int                                  null,
    CHAT_UNAME varchar(255)                         null,
    CHAT_MSG   varchar(255)                         null,
    CHAT_TIME  timestamp  default CURRENT_TIMESTAMP null,
    STATE      varchar(2) default 'U'               null
);

create table bs_para_detail
(
    PARA_TYPE   varchar(255)           null,
    PARA_CODE   varchar(255)           null,
    PARA_NAME   varchar(255)           null,
    PARA1       varchar(255)           null,
    PARA2       varchar(255)           null,
    PARA3       varchar(255)           null,
    PARA4       varchar(255)           null,
    PARA5       varchar(255)           null,
    PARA_DESC   varchar(255)           null,
    STATE       varchar(2) default 'U' null,
    CREATE_TIME timestamp              null,
    UPDATE_TIME timestamp              null,
    REMARKS     varchar(255)           null
);

create table osp_cdk_used
(
    U_ID      int                    null,
    CDK       varchar(255)           null,
    USED_NUM  int                    null,
    USED_TIME timestamp              null,
    STATE     varchar(2) default 'U' null
);

create table osp_datasource_save
(
    ID            int auto_increment
        primary key,
    NAME          varchar(255)           null,
    U_ID          int                    null,
    DATA_TYPE     varchar(255)           null,
    DATA_IP       varchar(255)           null,
    DATA_PORT     varchar(255)           null,
    DATA_TABLE    varchar(255)           null,
    DATA_USERNAME varchar(255)           null,
    DATA_PASSWORD varchar(255)           null,
    STATE         varchar(2) default 'U' null,
    CREATE_TIME   timestamp              null,
    UPDATE_TIME   timestamp              null,
    NOTE          varchar(255)           null
);

create table osp_exchange
(
    id       int         not null
        primary key,
    name     varchar(50) null,
    hui_in   varchar(50) null,
    hui_out  varchar(50) null,
    chao_in  varchar(50) null,
    chao_out varchar(50) null,
    code     varchar(50) null,
    zhesuan  varchar(50) null,
    day      varchar(50) null,
    time     varchar(50) null
);

create table osp_sign_info
(
    S_ID   int auto_increment
        primary key,
    U_ID   int         not null,
    U_NAME varchar(50) not null,
    S_MSG  varchar(50) null,
    S_TIME datetime    null,
    S_EXP  int         null
);

create table osp_update_log
(
    ID      int auto_increment
        primary key,
    VERSION varchar(20)                         not null,
    TIME    timestamp default CURRENT_TIMESTAMP not null,
    MESSAGE varchar(255)                        not null
)
    comment '更新日志';

create table osp_user
(
    U_ID        int auto_increment comment '用户UID'
        primary key,
    NAME        varchar(50)            null,
    TEL         varchar(11)            null,
    EMAIL       varchar(50)            null,
    PASSWORD    varchar(50)            not null,
    DESCRIPTION varchar(255)           null,
    CREATE_TIME datetime               null,
    LOGIN_TIME  datetime               null,
    EXP         int        default 0   null,
    LEVEL       int        default 1   null,
    STATE       varchar(2) default 'U' null
);

create table website_info
(
    W_ID    int auto_increment
        primary key,
    NAME    varchar(50)  null,
    WEBSITE varchar(255) null,
    COMMENT varchar(255) null,
    IS_OPEN int          null,
    U_ID    int          null
);

