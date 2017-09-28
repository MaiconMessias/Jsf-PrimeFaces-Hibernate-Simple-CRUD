delete from usuario;
delete from funcionario;
alter sequence funcionario_id_seq restart with 1;
insert into funcionario (nome, cpf, rg) values('Maicon Messias', '111.111.111-11', '11.111.111-1');
insert into usuario (usuario, senha, id_funcionario) values('root', '123', 1);