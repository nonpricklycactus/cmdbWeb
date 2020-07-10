# cmdbWeb

这是一款基于SpringBoot的服务器资产管理系统。

系统要求：

1. SpringBoot：2.0.1
2. Meaven:3.3
3. JAVA:JDK 1.8

随着近年来互联网事业的飞速发展，互联网行业也是愈加的庞大且复杂，尤其是当前大数据的广泛应用，对于服务器的需求也就越来越高。服务器的大量需求也就造成了服务器分布的分散且数量庞大，对其进行维护也越发的不易。使用传统的方法对服务器资产进行统计将花费大量的时间与精力。 所以通过自动化的方式对拥有服务器资产进行统计和管理这种方式也就随之出现，通过web页面来对服务器资产进行管理，有利于使用者更加方便快捷的对资产进行管理。通过一款服务器资产管理系统来对互联网企业进行管理也越发寻常，一个好的资产管理系统不仅仅只是方便运维人员统计数据，还能更加具体的告知运维人员服务器的问题所在。 于是我计划设计一款服务器资产管理系统，经由自动化运维的设计来对服务器资产举行统计，主动监控服务器资产的状况，当服务器资产丢失或跨越设置阈值时对运维人员发送邮件来提示。

##### 系统总的功能结构

![UKvYdK.jpg](https://s1.ax1x.com/2020/07/10/UKvYdK.jpg)

##### 数据表设计

该系统采用的数据库是MySQL数据库，并根据系统需要设计了10个数据表。（MySQL的数据类型：字符串类型（VARCHAR）、数值类型型（INT）、时间和日期类型（DATETIME））。

分别为用户表（User）、部门表（Department）、服务器系统用户（SeverUser）、服务器总资产信息表(ServerInfo) 、内存资产信息表(MemoryInfo) 、CPU资产信息表(CPUInfo) 、网卡资产信息表(NetworkInfo) 、硬盘资产信息表(DiskInfo) 、日志记录表(EventLog)。

1） 用户表（User）

主要用来包含用户的详细信息。属性包括用户名、密码、姓名、所属部门，联系电话，电子邮件。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**   |
| ------------ | ------------ | ------------ | ---------------- | -------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长 |
| username     | VARCHAR      | 32           | NOT NULL         | 用户名         |
| password     | VARCHAR      | 128          | NOT NULL         | 用户密码       |
| realname     | VARCHAR      | 32           | NOT NULL         | 真实姓名       |
| depart_id    | INT          | 32           | NOT NULL         | 所属部门(外键) |
| phone        | INT          | 32           | NOT NULL         | 联系电话       |
| email        | VARCHAR      | 128          | NOT NULL         | 电子邮箱       |

 

2） 部门表（Department）

主要用来包含部门的详细信息。属性包括部门名称、部门描述。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**   |
| ------------ | ------------ | ------------ | ---------------- | -------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长 |
| depname      | VARCHAR      | 128          | NOT NULL         | 部门名称       |
| description  | VARCHAR      | 128          |                  | 部门描述       |

 

3） 服务器系统用户表（SeverUser）

主要用来包含服务器系统用户的详细信息。属性包括系统用户名、系统密码、ip地址、创建时间、更新时间。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**       |
| ------------ | ------------ | ------------ | ---------------- | ------------------ |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长     |
| server_id    | VARCHAR      | 12           | NOT NULL         | 服务器编号（外键） |
| user_id      | INT          | 12           | NOT NULL         | 用户id（外键）     |
| user         | VARCHAR      | 128          | NOT NULL         | 系统用户名         |
| password     | VARCHAR      | 128          | NOT NULL         | 系统密码           |
| ipaddr       | VARCHAR      | 128          | NOT NULL         | Ip地址             |
| create_ time | DATETIME     |              | NOT NULL         | 创建时间           |
| update_ time | DATETIME     |              | NOT NULL         | 更新时间           |

 

4） 服务器总资产信息表(ServerInfo)

主要用来包含服务器总体资产的统计信息。属性包括主机名、主机账户、服务器型号、系统版本、系统内核、硬盘容量、内存容量、CPU内核数、ip地址、获取时间。

| **字段名称**       | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**   |
| ------------------ | ------------ | ------------ | ---------------- | -------------- |
| id                 | INT          | 12           | NOT NULL         | 主键，自动增长 |
| hostname           | VARCHAR      | 50           | NOT NULL         | 主机名         |
| server_id          | INT          | 12           | NOT NULL         | 服务器编号     |
| device_type        | VARCHAR      | 64           | NOT NULL         | 服务器型号     |
| system_version     | VARCHAR      | 64           | NOT NULL         | 系统版本       |
| system_kernel      | VARCHAR      | 64           | NOT NULL         | 系统内核       |
| hard_disk          | VARCHAR      | 64           | NOT NULL         | 硬盘容量       |
| memory             | VARCHAR      | 30           | NOT NULL         | 内存容量       |
| physical_cpu_cores | VARCHAR      | 64           | NOT NULL         | CPU内核数      |
| system_ip          | VARCHAR      | 64           | NOT NULL         | Ip地址         |
| check_time         | DATETIME     |              | NOT NULL         | 获取时间       |

 

5） 内存资产信息表(MemoryInfo)

主要用来包含服务器内存资产的统计信息。属性包括SN号、所属服务器id、制作商、内存型号、创建时间、更新时间。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**           |
| ------------ | ------------ | ------------ | ---------------- | ---------------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长         |
| sn           | VARCHAR      | 128          | NOT NULL         | sn号                   |
| server_id    | INT          | 12           | NOT NULL         | 所属服务器id号（外键） |
| manufactory  | VARCHAR      | 32           | NOT NULL         | 制造商                 |
| model        | VARCHAR      | 128          | NOT NULL         | 内存型号               |
| create_ time | DATETIME     |              | NOT NULL         | 创建时间               |
| update_ time | DATETIME     |              | NOT NULL         | 更新时间               |

 

6） CPU资产信息表(CPUInfo)

主要用来包含服务器CPU资产的统计信息。属性包括SN号、所属服务器id、制作商、CPU型号。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**           |
| ------------ | ------------ | ------------ | ---------------- | ---------------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长         |
| sn           | VARCHAR      | 128          | NOT NULL         | sn号                   |
| server_id    | INT          | 12           | NOT NULL         | 所属服务器id号（外键） |
| manufactory  | VARCHAR      | 32           | NOT NULL         | 制造商                 |
| model        | VARCHAR      | 128          | NOT NULL         | CPU型号                |

 

7） 网卡资产信息表(NetworkInfo)

主要用来包含服务器网卡资产的统计信息。属性包括SN号、所属服务器id、制作商、网卡类型、MAC地址。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**           |
| ------------ | ------------ | ------------ | ---------------- | ---------------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长         |
| sn           | VARCHAR      | 128          | NOT NULL         | sn号                   |
| server_id    | INT          | 12           | NOT NULL         | 所属服务器id号（外键） |
| manufactory  | VARCHAR      | 32           | NOT NULL         | 制造商                 |
| model        | VARCHAR      | 128          | NOT NULL         | 网卡型号               |
| mac_address  | VARCHAR      | 128          | NOT NULL         | Mac地址                |

 

8） 硬盘资产信息表(DiskInfo)

主要用来包含服务器磁盘资产的统计信息。属性包括SN号、所属服务器id、制作商、磁盘型号、磁盘容量、接口类型、创建时间、更新时间。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**           |
| ------------ | ------------ | ------------ | ---------------- | ---------------------- |
| id           | INT          | 12           | NOT NULL         | 主键，自动增长         |
| sn           | VARCHAR      | 128          | NOT NULL         | sn号                   |
| server_id    | INT          | 12           | NOT NULL         | 所属服务器id号（外键） |
| manufactory  | VARCHAR      | 32           | NOT NULL         | 制造商                 |
| model        | VARCHAR      | 128          | NOT NULL         | 磁盘型号               |
| capacity     | VARCHAR      | 64           | NOT NULL         | 磁盘容量               |
| Iface_type   | VARCHAR      | 128          | NOT NULL         | 接口类型               |
| create_ time | DATETIME     |              | NOT NULL         | 创建时间               |
| update_ time | DATETIME     |              | NOT NULL         | 更新时间               |

 

9） 硬件变更表(Maintainence)

主要用来包含服务器资产变更的详细信息。属性包括事件名称、变更类型、事件描述、事件开始时间、事件结束事件、发起人、设备SN号。

| **字段名称**  | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**   |
| ------------- | ------------ | ------------ | ---------------- | -------------- |
| id            | INT          | 12           | NOT NULL         | 主键，自动增长 |
| name          | VARCHAR      | 50           | NOT NULL         | 事件名称       |
| maintain_type | VARCHAR      | 50           | NOT NULL         | 变更类型       |
| description   | VARCHAR      | 128          | NOT NULL         | 事件描述       |
| event_start   | DATETIME     |              | NOT NULL         | 事件开始时间   |
| event_end     | DATETIME     |              | NOT NULL         | 时间结束时间   |
| applicant     | VARCHAR      | 50           | NOT NULL         | 发起人         |
| device_sn     | VARCHAR      | 128          | NOT NULL         | 设备SN号，外键 |

 

10）日志记录表(EventLog)

主要用来包含系统操作的详细信息。属性包括请求数据、创建时间、详细描述。

| **字段名称** | **字段类型** | **字段长度** | **是否允许为空** | **字段描述**   |
| ------------ | ------------ | ------------ | ---------------- | -------------- |
| uuid         | INT          | 12           | NOT NULL         | 主键，自动增长 |
| post_data    | VARCHAR      | 128          | NOT NULL         | 请求数据       |
| create_time  | DATETIME     |              | NOT NULL         | 创建时间       |
| detail       | VARCHAR      | 128          | NOT NULL         | 详细描述       |

##### 系统界面

![UKvBQA.png](https://s1.ax1x.com/2020/07/10/UKvBQA.png)