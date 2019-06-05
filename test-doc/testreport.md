## 1

```sql
create table defaulttable2 (id long, name string(8), grade int, primary key(id));
create table defaulttable2 (id long, name string(8), grade int, primary key(id))\n
```

expected result: exception.

## 2

```sql
create table tablepp (id long, name string(8), grade int, primary key(id));
insert into tablepp values (2000, 'laoshi01', 6)
insert into tablepp values (2000, 'laoshi01', 4)
select * from tablepp
```

expected result:

* line 3: exception

* line 4: 

  ```
  2000, laoshi01, 6
  ```

## 3

```sql
create table tablepp (id long, name string(8), grade int);
insert into tablepp values (2000, 'laoshi01', 6)
insert into tablepp values (2000, 'laoshi01', 4)
select * from tablepp
```

expected result:

* line 4:

  ```
  2000, laoshi01, 6
  2000, laoshi01, 4
  ```

## 4

```sql
create table tablepp (id long, name string(8), grade int);
insert into tablepp values (2000, 'laoshi01', 6)
insert into tablepp values (2001, 'laoshi02', 3)
insert into tablepp values (2002, 'laoshi03', 0)
insert into tablepp values (2003, 'laoshi04', 4)
insert into tablepp values (2004, 'laoshi04', 10)
select * from tablepp where id <> 2003 and id > 2001
```

expected result:

* line 7: 

  ```
  2002
  2004
  ```

  