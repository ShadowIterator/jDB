import random

sql_init = '''show databases;
create database DB1;
create database DB2;
use database DB1;
create table table1(id long, name string(8), gpa double, group int, primary key(id));
'''

SIGMA = 'abcdefghijklmnopqrstuvwxyz123456_ !@#$%^&*()"'

output_file_name = 'test_10000-2.schema'
f = open(output_file_name, 'w')
f.write(sql_init)
nid = 0
out_strs = []
for k in range(0, 10):
	out_strs = []
	if(k % 1 == 0):
		print('''round {}: '''.format(k))
	for i in range(0, 10000):
		out_str = ''
		nid = nid + random.randint(1,1)
		name = ''.join(random.choice(SIGMA) for _ in range(random.randint(1, 8)))
		out_str = '''insert into table1 values({}, '{}', {}, {})\n'''.format(nid, name, random.uniform(1,4), random.randint(0,1000))
		out_strs.append(out_str)
#	random.shuffle(out_strs)
	for str in out_strs:
		f.write(str)
# sql_query = '''select * from table1
# select id, name, gpa from table1 where gpa > 2.312 and gpa < 3.87
# select id, name, group from table1 where group > 20 and group <> 40
# select * from table1 where id > 30 and id < 300 and group <> 69 and gpa > 2.01\n'''
sql_query = 'select * from table1 where group = 87'
f.write(sql_query)
f.close()