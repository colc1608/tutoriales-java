

create table IF NOT EXISTS Exchange ( 
id SERIAL PRIMARY KEY, 
MONTO_ENVIADO DECIMAL(10,3) , 
MONTO_RECIBIDO decimal(10,3) , 
MONEDA_ORIGEN varchar (50) , 
MONEDA_DESTINO varchar (50) , 
TIPO_CAMBIO decimal(10,3) , 
TIPO_OPERACION varchar (255)  
); 

