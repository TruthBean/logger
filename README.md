# logger
logger adapter

该项目已合并至[https://github.com/truthbean/truthbean-projects](https://github.com/truthbean/truthbean-projects) 不在更新

## 日志级别
    1. fatal
        导致系统崩溃无法运行的错误
    
    2. error
        导致数据错误或者丢失，但是系统依然能运行
    
    3. warn
        能容忍但是必须被记录下来的错误
    
    4. info
        在正常情况下需要被记录的重要信息
    
    5. debug
        用于记录方便开发者排查错误及潜在隐患的信息
    
    6. trace
        用于跟踪数据的变化

## maven
```xml
    <dependencyManagement>
        <dependencies>
            <!-- import -->
            <dependency>
              <groupId>com.truthbean.logger</groupId>
              <artifactId>logger-dependence</artifactId>
              <version>0.4.0-RELEASE</version>
              <scope>import</scope>
              <type>pom</type>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- logger adapter core -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>logger-core</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
    
        <!-- log4j2 adapter -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>logger-to-log4j2</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
    
        或者使用
        <!-- slf4j adapter -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>logger-to-slf4j</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
    
        或者在测试的时候使用以下中的一个
        <!-- jdk adapter -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>jdk-adapter</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
        
        <!-- jul adapter -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>logger-to-jul</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
    
        <!-- stdout adapter -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>logger-stdout</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
        
        <!-- kotlin支持 -->
        <dependency>
              <groupId>com.truthbean.logger</groupId>
              <artifactId>logger-kotlin</artifactId>
              <version>0.4.0-RELEASE</version>
            </dependency>
    
        包含依赖的boot
        <!-- log4j2 boot -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>log4j2-boot</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
        
        <!-- slf4j boot -->
        <dependency>
          <groupId>com.truthbean.logger</groupId>
          <artifactId>slf4j-boot</artifactId>
          <version>0.4.0-RELEASE</version>
        </dependency>
        
        <!-- tomcat juli -->
        <dependency>
            <groupId>com.truthbean.logger</groupId>
            <artifactId>juli-bridge</artifactId>
            <version>0.4.0-RELEASE</version>
        </dependency>
    
        <!-- spring boot starter -->
        <dependency>
            <groupId>com.truthbean.logger</groupId>
            <artifactId>logger-spring-boot-starter</artifactId>
            <version>0.4.0-RELEASE</version>
        </dependency>

    </dependencies>
```

### log4j2的注意事项
如果使用spring-boot，首先应该排除springboot中自带的logback日志，引入log4j2的日志
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
其次在编写的过程中，尽量使用log4j2-api中的接口（log4j2-core是log4j2-api的官方实现，性能比logback、log4j、jul都要高很多），而不是其他门面日志系统（log4j2自身也是门面模式）；
同时，日志的message尽量不能相同，不然很难排查问题，失去了日志的原有功能点。
```java
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

...

private static final Logger LOGGER = LogManager.getLogger(XXXX.class);
```
log4j2.xml配置文件中，不允许显示行号。使用%c或者%c{36}或者%logger或者%logger{36}，注意是小写的c，大写的C将使用堆栈快照获取日志的位置信息
`官方文档显示的信息，显示日志调用的位置信息，同步logger将花费1.3到5倍的时间，异步logger将花费30到100倍的时间`
https://logging.apache.org/log4j/2.x/manual/layouts.html#LocationInformation

### 注意
JDK要求最低11

本框架藏有彩蛋！！请移步至core/src/main/java/com/truthbean/logger/LoggerFactory
