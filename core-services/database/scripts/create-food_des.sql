create table FOOD_DES (
FOOD_DES_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NDB_No varchar(5) not null unique,
FdGrp_Cd varchar(4) not null,
Long_Desc varchar(200) not null,
Shrt_Desc varchar(60) not null,
ComName varchar(100),
ManufacName varchar(65),
Survey varchar(1),
Ref_desc varchar(135),
Refuse numeric(2),
SciName varchar(65),
N_Factor numeric(4,2),
Pro_Factor numeric(4,2),
Fat_Factor numeric(4,2),
CHO_Factor numeric(4,2),
primary key (FOOD_DES_ID)
);