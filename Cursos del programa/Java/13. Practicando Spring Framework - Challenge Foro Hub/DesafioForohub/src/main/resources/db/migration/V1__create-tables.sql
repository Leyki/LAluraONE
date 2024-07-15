create table usuario (
    id bigint not null auto_increment,
    nombre varchar(40) not null,
    contraseña varchar(256) not null,
    correo_electronico varchar(100),
    primary key(id)
);
create table curso (
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    categoria varchar(100) not null,
    primary key(id)
);

create table topico (
    id bigint not null auto_increment,
    status ENUM('OPEN', 'CLOSED') not null,
    titulo varchar(100) not null,
    mensaje varchar(100) not null unique,
    fecha_creacion datetime not null,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id),
    foreign key (autor_id) references usuario(id),
    foreign key (curso_id) references curso(id)
);

create table respuesta (
    id bigint not null auto_increment,
    autor bigint not null,
    solucion tinyint default 0,
    topico_id bigint not null,
    mensaje varchar(100) not null unique,
    fecha_creacion datetime not null default current_timestamp,

    primary key(id),
    foreign key (topico_id) references topico(id) on delete cascade
);
