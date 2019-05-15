# jDB
This is going to be the 6th best java database (right after HSQLDB) which only supported a few SQL grammar.

## executor 所需要的接口

### 元数据管理部分（MetaDataManager）

- 一个初始化的接口
- 创建表的接口
- 删除表的接口
- 数据库实例的切换

### 查询所需要的接口 (TableManager/Table)

- 查询某个表的基本信息（属性名称，是否非空，主键）
- 获得遍历所有数据的迭代器
- 获得主键在某个区间的数据的迭代器
- 迭代器返回的一个tuple的数据结构（parser怎么实现待讨论）
- 插入一个tuple的接口（序列化方法待讨论）
- 删除一个tuple的接口
- 更新一个tuple的接口