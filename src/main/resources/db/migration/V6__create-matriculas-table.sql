create table matriculas(
    id int auto_increment primary key,
    data_matricula date not null,
    idcliente int not null,
    foreign key (idcliente) references clientes(id),
    idplano int not null,
    foreign key (idplano) references planos(id),
    valorpago double not null,
    matriculaativa boolean not null
)