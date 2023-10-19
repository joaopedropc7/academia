create table titulos(
    id int auto_increment primary key,
    idcliente int not null,
    foreign key (idcliente) references clientes(id),
    idplano int not null,
    foreign key (idplano) references planos(id),
    valorpago double not null,
    juros double not null,
    datapagamento date not null,
    formadepagamento varchar(50) not null
)