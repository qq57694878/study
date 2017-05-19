select orderid, paydate ,substr(paydate,1,8)||to_char( to_number( substr(paydate,9,2) )+12 ) ||substr(paydate,11),''''||orderid||''''
from WEBORDER t
where 1=1
and length(paydate)=14
and to_number(substr(paydate,9,2)）<12;


select 'and orderid in('|| wm_concat（''''||orderid||''''）||')'
from WEBORDER t
where 1=1
and length(paydate)=14
and to_number(substr(paydate,9,2)）<12;

update football.WEBORDER set paydate = substr(paydate,1,8)||to_char( to_number( substr(paydate,9,2) )+12 ) ||substr(paydate,11)
where 1=1
and length(paydate)=14
and to_number(substr(paydate,9,2)）<12
and orderid in('T20160328000922','T20161115001461','T20160407000984','T20160407000981','T20160407000982','T20170216001581','T20170426001665','T20170426001666','T20170426001664');
