# logger
logger adapter

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
    <!-- logger adapter core -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>core</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

    <!-- log4j2 adapter -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>log4j2</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

    或者使用
    <!-- slf4j adapter -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>slf4j</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

    或者在测试的时候使用以下中的一个
    <!-- jdk adapter -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>jdk</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

    <!-- stdout adapter -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>stdout</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

    包含依赖的boot
    <!-- log4j2 boot -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>log4j2-boot</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>
    
    <!-- slf4j boot -->
    <dependency>
      <groupId>com.truthbean.logger</groupId>
      <artifactId>slf4j-boot</artifactId>
      <version>0.2.0-RELEASE</version>
    </dependency>

### 注意
代码由JDK11编译！！！