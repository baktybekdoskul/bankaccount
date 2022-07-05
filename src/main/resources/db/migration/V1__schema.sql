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
    account_from    bigint          not null,
    account_to      bigint          not null,
    created_time    timestamptz     not null
);