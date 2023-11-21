# SQL STUDY

## 학습 목표

 -  ### Query문 꾸준히 연습하기
 -  ### SQLD 시험 대비

<br/>

## 개발 환경

- windows 10, windows 11, mac
- Oracle Database 21c xe
- VMware Workstation 16


## 가상 머신에서 환경 설정
```bash

rm -rf /etc/sysconfig/network-scripts/ifcfg-ens33
echo DEVICE=ens33 >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo BOOTPROTO=static >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo IPADDR=192.168.1.100 >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo NETMASK=255.255.255.0 >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo GATEWAY=192.168.1.2 >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo ONBOOT=yes >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo DNS1=168.126.63.1 >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo DNS2=8.8.8.8 >> /etc/sysconfig/network-scripts/ifcfg-ens33

service network restart && echo OK

yum install java-1.8.0-openjdk-devel.x86_64 -y && javac -version

wget https://yum.oracle.com/repo/OracleLinux/OL7/latest/x86_64/getPackage/oracle-database-preinstall-21c-1.0-1.el7.x86_64.rpm
yum -y localinstall oracle-database-preinstall-21c-1.0-1.el7.x86_64.rpm


wget https://download.oracle.com/otn-pub/otn_software/db-express/oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm
yum -y localinstall oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm

service oracle-xe-21c configure 

============================================================================================

firewall-cmd --permanent --zone=public --add-port=1521/tcp
firewall-cmd --reload
firewall-cmd --list-all

rm -rf /home/oracle/prepareAccount.sql
echo "create user c##itbank identified by it;" >> /home/oracle/prepareAccount.sql
echo "grant connect, resource, dba to c##itbank;" >> /home/oracle/prepareAccount.sql

echo "" >> /home/oracle/.bash_profile
echo "### 오라클 실행 환경 변수 설정 ###" >> /home/oracle/.bash_profile
echo "export ORACLE_HOME=/opt/oracle/product/21c/dbhomeXE" >> /home/oracle/.bash_profile
echo "export ORACLE_SID=XE" >> /home/oracle/.bash_profile
echo "export ORAENV_ASK=NO" >> /home/oracle/.bash_profile
echo "export NLS_LANG=AMERICAN_AMERICA.AL32UTF8" >> /home/oracle/.bash_profile
echo "export PATH=.:$ORACLE_HOME/bin:$PATH" >> /home/oracle/.bash_profile
echo oracle | passwd --stdin oracle

su - oracle
. oraenv
sqlplus sys/oracle@//localhost:1521/XE as sysdba < /home/oracle/prepareAccount.sql

exit

sed -i '7s/enforcing/disabled/' /etc/selinux/config
systemctl enable oracle-xe-21c.service && init 6

```

---

## hr 스키마 및 계정 생성
```bash
[https://github.com/oracle-samples/db-sample-schemas/releases]

rm -rf v21.1.tar.gz
rm -rf /opt/oracle/product/21c/dbhomeXE/demo/schema/human_resources

wget https://github.com/oracle-samples/db-sample-schemas/archive/refs/tags/v21.1.tar.gz
tar xf v21.1.tar.gz

mv db-sample-schemas-21.1/human_resources/ /opt/oracle/product/21c/dbhomeXE/demo/schema/
cd /opt/oracle/product/21c/dbhomeXE/demo/schema/

cat human_resources/hr_main.sql | grep __SUB__CWD__
sed -i "s/__SUB__CWD__/?\/demo\/schema/" human_resources/hr_main.sql


-----------------------------------------------------------------------------

su - oracle
. oraenv
cd $ORACLE_HOME/demo/schema
pwd
sqlplus / as sysdba

alter session set "_oracle_script"=true;
@?/demo/schema/human_resources/hr_main.sql


# 이건 스크립트로 전부 넣지 마시고 하나 하나 입력
1: hr				(hr 계정에서 쓰고 싶은 비밀번호)
2: users			(기본 테이블 스페이스)
3: temp				(임시 테이블 스페이스)
4: oracle			(현재 설정된 sys 계정의 비밀번호)
5: /opt/oracle/product/21c/dbhomeXE/demo/schema/log	(로그를 남길 위치)
6: localhost:1521/xe		(접속할 때 사용하는 이름, 문자열)
```
--- 




