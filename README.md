# jDB
This is going to be the 6th best java database (right after HSQLDB) which only supported a few SQL grammar.

## Documents

Please refer to `doc` folder.

## Project Structure

- `antlr-gen`: lexer and parser generated by ANTLR4
- `frontend`: executor related classes
- `gui`: GUI class
- `net`: client and server classes
- `src`: storage part and metadata manager part
- `doc`: documents
- `jar`: executable jar
- `lib`: ANTLR4 package
- `test-doc`: mock data generator
- `example`: some test scripts

## executor 所需要的接口

### 元数据管理部分（MetaDataManager）

- <s>一个初始化的接口</s>
- <s>创建表的接口</s>
- <s>删除表的接口</s>
- <s>数据库实例的切换</s>

### 查询所需要的接口 (TableManager/Table)

- <s>查询某个表的基本信息（属性名称，是否非空，主键）</s>
- <s>获得遍历所有数据的迭代器</s>
- <s>获得主键在某个区间的数据的迭代器</s>
- <s>迭代器返回的一个tuple的数据结构（parser怎么实现待讨论）</s>
- <s>插入一个tuple的接口（序列化方法待讨论）</s>
- <s>删除一个tuple的接口</s>
- <s>更新一个tuple的接口</s>

## 基本任务TODO

- [x] 前端支持where语句中的and/or连接
- [x] 细化上述接口
- [x] 实现上述接口
- [x] 实现executor
- [x] 实现网络部分
- [x] 实现一个前端
- [x] 改用新的Cursor
- [x] 添加不等号的实现

## 加分项TODO

- [ ] 支持三张及以上表join操作
- [ ] 支持<s>outer/inner/</s>natural join操作
- [x] 支持嵌套查询(不支持JOIN)
- [x] 支持[not] exist

