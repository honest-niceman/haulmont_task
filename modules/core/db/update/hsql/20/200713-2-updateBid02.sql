alter table PRACTICE_BID alter column STATUS rename to STATUS__U41221 ^
alter table PRACTICE_BID add column STATUS varchar(50) ^
update PRACTICE_BID set STATUS = 'Open' where STATUS is null ;
alter table PRACTICE_BID alter column STATUS set not null ;
