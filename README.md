###                                     Maven 多模块搭建的小Demo

  

​          采用Maven 多模块 和 ssm框架搭建实现简单的实现登录功能，在Demo1父工程下主要有两个demo-utils和demo-main的子项目，demo-main主要负责web中controller的处理，并依赖demo-utils，demo-utils主要实现处理业务和数据库的操作实现。

1. #### proerties 的使用

   ​    在maven中pom文件中，<proerties>属性通常被用做版本号的定义，在项目中，比如spring-tx，spring-bean都用同一个版本号，这时我们就使用<proerties>定义这些重复的版本号，后面文件直接引用，方便后期的维护。

2. #### packaging 的类型

   packaging的类型主要是项目的打包形式 常用的为jar,war,pom 等，jar为默认类型

   pom父工程的打包类型为pom 同时有<modules>包含子模块

   jar默认打包类型，通过服务和内部调用，使用jar

   war类型，部署的项目打包为war类型

3. #### version  1.0.0-SNAPSHOT 和  1.0.0 的差异

   SNAPSHOT是快照版本，不稳定，还处于开发阶段。

   1.0.0Release正式版本 ，稳定的开发版本。

   快照版本每次构建项目时，即使本地仓库有，也会去快照版本库中下载最新的。

   正式版本构建项目时，会先在本地仓库中查找是否有依赖，没有才去远程仓库拉取。除非升级版本时，才去远程仓库查找最新的。

4. #### dependencyManagement, dependencies

   ##### **denpendencyManagement** :一个对项目所依赖的jar包进行版本管理的管理器。在denpendencyManagement中的denpendencies，maven不会真实的下载这些jar包，使用map用gav存储。单独使用denpendencies是会去下载这些jar包，当父工程使用denpendencyManagement时，子项目会继承这些jar，引入依赖时不需要写入version。如果写了version会和父工程的jar包冲突，包重复了。dependencies管理依赖会自动继承父工程的依赖。denpendency中声明了version，不管dependencyManagement有没有申明，都与声明version的为准。

5. #### 父工程的使用,继承

   父工程打包方式为pom，modules包含子模块

   ```
     <groupId>com.sunsharing</groupId>
       <artifactId>Demo</artifactId>
       <packaging>pom</packaging>
       <version>1.0-SNAPSHOT</version>
       <modules>
           <module>demomain</module>
           <module>demoutils</module>
       </modules>
   ```

   子项目demo-utils

   ```
       <parent>
           <artifactId>Demo</artifactId>
           <groupId>com.sunsharing</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>

       <artifactId>demo-utils</artifactId>
       <packaging>jar</packaging>
   ```

   demo-main模块依赖demo-utils，在demo-main中加入引入demo-utils的依赖

   ```
         <dependency>
               <groupId>com.sunsharing</groupId>
               <artifactId>demo-utils</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
   ```

   ​

   ​