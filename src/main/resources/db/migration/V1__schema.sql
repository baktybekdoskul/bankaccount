create table s_user(
    id      bigserial       primary key,
    name    varchar         not null,
    surname varchar         not null
);

create table account(
    id          bigserial       primary key,
    balance     decimal         not null,
    user_id     bigint          not null constraint account_user_id_fk references s_user
);

create table transfer(
     id              bigserial       primary key,
     amount          decimal         not null,
     account_from    bigint          not null constraint transfer_from_account_id_fk references account,
     account_to      bigint          not null constraint transfer_to_account_id_fk references account,
     created_time    timestamp    not null
);
