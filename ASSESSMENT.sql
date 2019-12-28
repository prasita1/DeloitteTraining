create table patients(
patient_id number(2),
patient_name varchar(30) not null,
patient_email varchar2(30) unique,
pat_dt date
);
create table medicines(
med_id number(2),
med_name varchar(30) not null
);
create table presc(
presc_id number(2),
presc_date date ,
patient_id number(2)
);
create table checkup(
id number(2),
presc_id number(2),
med_id number(2)
);

alter table patients
add constraint pk_patientId primary key (patient_id);
alter table medicines
add constraint pk_medId primary key (med_id);
alter table presc
add constraint pk_prescId primary key (presc_id);

desc patients;
desc medicines;
desc presc;
desc checkup;

alter table checkup
add constraint fk_medicines foreign key (med_id)
references medicines(med_id);
alter table checkup
add constraint fk_presc foreign key (presc_id)
references presc(presc_id); 

insert into patients values (01,'aditi','MITRA',sysdate);
insert into patients values (02,'bairali','SUMAN',sysdate);
insert into patients values (03,'chandan','SINGH',sysdate);

insert into medicines values (1,'a');
insert into medicines values (2,'b');
insert into medicines values (3,'c');
insert into medicines values (4,'d');
insert into medicines values (5,'e');

insert into presc values (10,sysdate,01);
insert into presc values (11,sysdate,02);
insert into presc values (12,sysdate,03);

select * from patients 
where pat_dt between '10-DEC-2019' and '30-DEC-2019';

insert into checkup values (30,10,4);
insert into checkup values (31,11,3);
insert into checkup values (32,12,1);

select p.presc_id,p.presc_date,p.patient_id,m.med_name 
from presc p join checkup c on p.presc_id=c.presc_id join medicines m on c.med_id=m.med_id
where patient_id = 02;

