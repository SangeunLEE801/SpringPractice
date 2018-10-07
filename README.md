# mvc_board

1. oracle developer
2. ojdbc version 11.2.0.4
3. docker https://hub.docker.com/r/wnameless/oracle-xe-11g/
4. maven 3.5.4https://joonyon.tistory.com/16
5. ❯ mvn -version
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-18T03:33:14+09:00)
Maven home: /usr/local/maven-3.5.4
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre




table&sequence
create table mvc_board(
    bId NUMBER(4) PRIMARY KEY,
    bName VARCHAR2(20),
    bTitle VARCHAR2(100),
    bContent VARCHAR2(300),
    bDate DATE DEFAULT SYSDATE,
    bHit NUMBER(4) DEFAULT 0,
    bGroup NUMBER(4),
    bStep NUMBER(4),
    bIndent NUMBER(4)
);

create sequence mvc_board.seq;