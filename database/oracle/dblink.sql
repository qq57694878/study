-- Create database link
create public database link HGC35
  connect to HGC identified by "123456"
  authenticated by TEST identified by test
  using '172.17.17.35';

-- Create database link
create public database link HGC172
  connect to HGC identified by "123456"
  authenticated by TEST identified by test
  using '61.172.243.172';