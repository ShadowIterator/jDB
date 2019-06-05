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

  