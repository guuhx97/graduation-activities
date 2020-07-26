
SET CLIENT_ENCODING TO 'UTF8';

CREATE TABLE caso (
	id SERIAL,
	tipo_impressora VARCHAR(15),
	cabeamento VARCHAR(10),
	fonte VARCHAR(5),
	led_power VARCHAR(10),
  led_ethernet VARCHAR(10),
	led_processamento VARCHAR(10),
	iluminador_scanner VARCHAR(15),
	imprimindo VARCHAR(50),
	scanner VARCHAR(15),
	alimentador VARCHAR(15),
	estufa VARCHAR(15),
	tonner VARCHAR(50),
	solucao VARCHAR(255),
	similaridade double precision
);

ALTER TABLE caso ADD PRIMARY KEY (id);
--1
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Sim', 'Não há tonner', 'Adquira um tonner para esta impressora e insira na impressora.');
--2
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Reinstale o driver de impressão em seu computador.');
--3
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Ligado', 'Piscando', 'Apagado', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque a fonte. Problema de tensão.');
--4
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Não', 'Desligado', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--5
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Desligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Não', 'Pouca carga', 'Troque o tonner/fita por um cheio.');
--6
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Desligado', 'Piscando', 'Não possui', 'Impressão falhada', 'Não', 'Cheio', 'Sim', 'Cheio', 'Troque o cabo paralelo. Os dados estão corrompendo.');
--7
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'USB', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Reinstale o driver de impressão em seu computador.');
--8
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Não', 'Desligado', 'Desligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--9
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Atualize o firmware da impressora, depois religue-a.');
--10
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Ligado', 'Não possui', 'Não', 'Não', 'Vazio', 'Não', 'Cheio', 'Alimente a bandeja de papel.');
--11
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Troque o cabo USB. Os dados não estão chegando.');
--12
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Desligado', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Sim', 'Sim', 'Cheio', 'Ligue a impressora no botão power.');
--13
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Poucas folhas', 'Não', 'Cheio', 'Conecte o cabo paralelo ao computador.');
--14
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Ligado', 'Piscando', 'Aceso', 'Não', 'Não', 'Cheio', 'Não', 'Cheio', 'Há um papel atolado no fusor. Remover folha trancada.');
--15
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Não possui', 'Imprime em branco', 'Não', 'Cheio', 'Não', 'Pouca carga', 'Troque o tonner por um cheio.');
--16
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Apagado', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Spool de impressão pausado. Reiniciar impressão.');
--17
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Não', 'Desligado', 'Desligado', 'Desligado', 'Não possui', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Ligue a impressora a uma fonte 220v para 110v.');
--18
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Piscando', 'Piscando', 'Piscando', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Tonner com problema. Substituir tonner.');
--19
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'USB', 'Sim', 'Ligado', 'Desligado', 'Piscando', 'Aceso', 'Sim', 'Sim', 'Cheio', 'Sim', 'Cheio', 'Limpe a fila de impressão ou reinicie o computador.');
--20
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Matricial', 'Paralelo', 'Sim', 'Ligado', 'Desligado', 'Ligado', 'Não possui', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Limpe a fila de impressão ou reinicie o computador.');
--21
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Desligado', 'Desligado', 'Não possui', 'Não', 'Não', 'Cheio', 'Sim', 'Cheio', 'Configure os parametros de rede.');
--22
INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_ethernet, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao)
VALUES ('Jato de tinta', 'Ethernet', 'Sim', 'Ligado', 'Piscando', 'Piscando', 'Não possui', 'Sim', 'Não', 'Cheio', 'Sim', 'Cheio', 'Erro ao conectar a rede, reinstale o driver da impressora.');
