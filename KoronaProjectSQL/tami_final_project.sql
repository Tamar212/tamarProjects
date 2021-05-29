use korona2

---insert values int tables---
insert INTO [dbo].[J_JERMS_TBL]
VALUES (1,'kovid19',null,'2020/1/1',null)

insert INTO [dbo].[J_TEST_TBL]
VALUES (22,12,'2020/1/1','dead')

insert INTO [dbo].[J_MEDICINE_TBL]
VALUES (11,'ddd')

insert INTO [dbo].[J_JERMS_TBL]
VALUES (9,'Atalef19','very slim','2020/5/22',null,101),(6,'Korona1','VERY OLD','2019/8/30',null,102),(7,'Korona2',null,'2021/5/2',null,103),(8,'chorfan','new','2018/5/5',null,104);

INSERT INTO [dbo].[J_MEDICINE_TBL] VALUES(1,'VITAMIND'),(2,'KOKTEL'),(3,'PENITZILINE'),(4,'SPARIN')
alter table [dbo].[J_JERMS_TBL] add medicine_id int

insert[dbo].[J_TEST_TBL]values(1,100,2020/2/2,'dying')
 
--------1----------
alter view G_SHUTS_VW(medicineName,jermsName,medicineDate)as
select [M_NAME],[J_NAME],[TEST_DATE]
from[dbo].[J_MEDICINE_TBL]m join [dbo].[J_TEST_TBL]t on m.[ID]=t.[MEDICINE_ID]
join[dbo].[J_JERMS_TBL]j on j.[ID]=t.[GERM_ID]
------
select * from G_SHUTS_VW
select * from [dbo].[J_JERMS_TBL]

--------2-----------
alter procedure ADD_TEXT_SQL (@name_mota varchar(20),@name_medicine varchar(20),@date_experianse date,@status_experianse varchar(40))
as begin
begin try
declare @id_temp int=(select [ID] from [dbo].[J_MEDICINE_TBL] where [M_NAME]=@name_medicine)
declare @id1_temp int=(select [ID] from [dbo].[J_JERMS_TBL] where [J_NAME]=@name_mota)

if @status_experianse in('dying','alive','dead') insert into [dbo].[J_TEST_TBL] values(@id1_temp,@id_temp,@date_experianse,@status_experianse)
else insert into[dbo].[J_EXCEPTION_TBL] values(ERROR_PROCEDURE()+'סטטוס שגוי') 
end
try
begin catch
if @name_medicine not in (select [M_NAME]  from [dbo].[J_MEDICINE_TBL])
begin 
insert into [dbo].[J_EXCEPTION_TBL] values(ERROR_PROCEDURE()+'התרופה לא קיימת') 
print ERROR_PROCEDURE()+'התרופה לא קיימת'
end
else if @name_mota not in (select [J_NAME] from [dbo].[J_JERMS_TBL])
begin print ERROR_PROCEDURE()+'החיידק לא קיים'
end else
insert into [dbo].[J_EXCEPTION_TBL] values(ERROR_PROCEDURE()+ERROR_MESSAGE()+ 'ניסוי זה כבר קיים ') 
print ERROR_PROCEDURE()+ERROR_MESSAGE()+ERROR_NUMBER()
end catch
end 
	
exec ADD_TEXT_SQL 'Korona1','koktel','01/21/2009' ,'dead'

--------3---------
create procedure copy_to_archive(@jerm_id int)
as
begin
begin try
declare @j_id int
declare @m_id int
declare @d datetime 
declare @r varchar (20)
declare @n varchar (20)
declare @m varchar (20)
 declare crs cursor
 for select [GERM_ID],[MEDICINE_ID],[TEST_DATE],[REACTION_TYPE] from[dbo].[J_TEST_TBL]
 open crs
 fetch next from crs into @j_id,@m_id,@d,@r
 while @@FETCH_STATUS=0
 begin
 if(@j_id=@jerm_id)
 begin
 select @n=[J_NAME] from[dbo].[J_JERMS_TBL] where [ID]=@jerm_id
 select @m=[M_NAME] from[dbo].[J_MEDICINE_TBL]  where [ID]=@m_id
 insert into [dbo].[J_ARCHIVE_TBL] values (@j_id,@m_id,@n,@m,@d,@r)
 end
 fetch next from crs into @j_id,@m_id,@d,@r
 end
 close crs
 deallocate crs
 delete from [dbo].[J_TEST_TBL] where [GERM_ID]=@jerm_id
 end try
 begin catch
 print ERROR_PROCEDURE()+error_message()
 end catch
 end

 exec copy_to_archive 3

---------4---------
alter procedure update_status(@j_id int,@m_id int,@reaction varchar(20))
as 
begin
begin try
update [dbo].[J_TEST_TBL] set [REACTION_TYPE]=@reaction where @j_id=[GERM_ID] and @m_id=[MEDICINE_ID]
end try
begin catch
  insert into dbo.j_exception_table values (error_number(),error_procedure()+' '+error_message())
end catch
end

----------5-----------
alter function staying_alive(@test_id int ,@medicine_id int)
returns bit
as
begin
declare @date date
set @date=(select [TEST_DATE]from[dbo].[J_TEST_TBL]
where [GERM_ID]=@test_id and [REACTION_TYPE] ='dying')

if @date is not null
    begin
	if(datediff(MONTH,@date ,GETDATE())>2)
	   return 1
	 end
return 0
end

declare @jerm_id int,@med_id int
set @jerm_id=1
set @med_id=145
if (select dbo.staying_alive (@jerm_id,@med_id))>=2
     exec update_status @jerm_id,@med_id,'alive'


select [dbo].[staying_alive](1,123)


 create function staying_alive1(@jerm_id int, @med_id int)
returns int
as
begin
declare @t_date datetime,@id int
set @id=(select id_jerm from dbo.test where id_jerm=@jerm_id and id_medicine=@med_id and reaction_type='dying')
if @id is not null
   begin
    set @t_date=(select test_date from dbo.test where id_jerm=@jerm_id and id_medicine=@med_id)
    return (Datediff(month,@t_date,Getdate()))
   end
return 0 
end

declare @jerm_id int,@med_id int
set @jerm_id=1
set @med_id=123
if (select dbo.staying_alive (@jerm_id,@med_id))=1
   exec update_status @jerm_id,@med_id,'alive'

------------6------------
alter trigger t2 on [dbo].[J_TEST_TBL] 
for update,insert
as  
declare @jerm_id int
declare @d datetime
declare @medicine_id  int
select @jerm_id=inserted.[GERM_ID] from inserted inner join [dbo].[J_TEST_TBL]
on inserted.germ_id =[dbo].[J_TEST_TBL].germ_id
select  @medicine_id=inserted. medicine_id from inserted inner join [dbo].[J_TEST_TBL]
on inserted.medicine_id=[dbo].[J_TEST_TBL].[MEDICINE_ID] 
select @d=[MEDICINE_DATE] from[dbo].[J_JERMS_TBL] where [ID]=@jerm_id
if @d is not null
begin 
insert into [dbo].[J_EXCEPTION_TBL] values(ERROR_PROCEDURE()+'כבר נמצאה תרופה לחיידק זה') 
		print (ERROR_PROCEDURE()+'כבר נמצאה תרופה לחיידק זה')
		rollback
		end
		else if 'DEAD' in (select reaction_type from inserted) and @d is null
		begin
		update [dbo].[J_JERMS_TBL] set [MEDICINE_DATE] =(select[TEST_DATE] from  [dbo].[J_TEST_TBL] where  [GERM_ID]=@jerm_id and [MEDICINE_ID]=@medicine_id)
		where id=@jerm_id
		declare @name1 varchar(15)
		set @name1=(select [MEDICINE_NAME]  from[dbo].[J_ARCHIVE_TBL] where  [MEDICINE_ID]=@medicine_id )
		exec COPY_TO_ARCHIVE @jerm_id 
		end
		return

insert into [dbo].[J_TEST_TBL] values(8,22,'2020/2/2','DEAD')

----------7---------
 alter function TEST_TO_GERM (@id_mota int)
  returns int
  as begin
  declare @count int=(select count([GERM_ID])from [dbo].[J_TEST_TBL] where [GERM_ID]=@id_mota)
  return @count
  end

print [dbo].[TEST_TO_GERM](1)

----------8----------
create function GERM_FOR_SHUT (@name_m varchar(10))
  returns table
 return (select  j1.[ID],[J_NAME] from[dbo].[J_TEST_TBL] j join [dbo].[J_MEDICINE_TBL] m on j.MEDICINE_ID=m.ID ,
 [dbo].[J_JERMS_TBL] j1 join [dbo].[J_TEST_TBL]  j2 on j1.ID=j2.GERM_ID
 where m.[M_NAME]=@name_m and m.ID=j2.MEDICINE_ID )

select * from GERM_FOR_SHUT('SPARIN') 
 
---------9-----------
create function GARM_MOST_PRENSISTTENT()returns table
return(select j.J_NAME,max([dbo].[TEST_TO_GERM]([GERM_ID]))as 'max'
from [dbo].[J_JERMS_TBL]j join [dbo].[J_TEST_TBL]t on j.ID=t.GERM_ID
where [dbo].[TEST_TO_GERM]([ID])=
(select max([dbo].[TEST_TO_GERM]([GERM_ID]))from [dbo].[J_TEST_TBL])group by j.J_NAME )
 
select * from GARM_MOST_PRENSISTTENT()






