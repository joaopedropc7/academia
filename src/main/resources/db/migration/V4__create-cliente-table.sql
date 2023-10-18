CREATE TABLE clientes(
    id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null,
    cpf varchar(11) not null,
    data_nascimento date not null,
    plano_id int,
    foreign key (plano_id) references planos(id),
    numero_telefone varchar(11) not null,
    situacao_cliente_id int,
    foreign key (situacao_cliente_id) REFERENCES situacao_cliente(id)
);

