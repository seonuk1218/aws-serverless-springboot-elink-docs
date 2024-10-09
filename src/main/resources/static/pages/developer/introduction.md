# eLink

해당 문서는 eActive Study를 위해 작성된 문서로 솔루션 정식 기술서가 아니오니 참고만 하시길 바랍니다.

## 1.1 Introduction

EMS, Online, Batch 구조도

**EMS란 무엇입니까?**  
EMS는 eLink 솔루션 패키지의 일부로, 온라인 거래 엔진 및 배치 거래 엔진의 서비스 설정과 실시간 거래를 모니터링하는 도구입니다. 관리자 및 사용자는 EMS에서 제공되는 화면을 통해 거래 서비스를 설정하고 모니터링할 수 있습니다.

---

## 2. Main Concepts and Terminology

EMS의 화면과 기능을 이해하기 위해서는 거래 서비스에 대한 이해가 필수적입니다. 아래는 EMS의 주요 개념과 용어에 대한 설명입니다:

### 2.1 역할 분리(Role Separation)
- **목적:** 역할별로 사용자 화면 권한을 분리하여 보안을 강화하고 관리의 효율성을 높임.
- **적용:** 각 사용자에게 역할에 따라 권한이 할당되며, 해당 권한에 따른 화면 접근이 가능.

### 2.2 APP Code 권한 관리
- **목적:** 사용자 계정별로 자원에 대한 권한을 관리하여 접근 제어를 강화.
- **적용:** APP Code를 기준으로 자원에 대한 접근 권한이 설정되고 관리됨.

### 2.3 서비스 패키지 통합 관리
- **목적:** 다양한 타입의 서비스 패키지를 하나의 EMS에서 관리하여 일관된 시스템 운영.
- **적용:** EMS에서 여러 서비스 패키지를 통합하여 관리할 수 있는 기능 제공.

### 2.4 (A-A) HA 구성
- **목적:** 고가용성(HA, High Availability)을 제공하여 시스템 안정성을 보장.
- **적용:** A-A 구성을 통해 높은 가용성과 서비스 연속성을 제공.

---

## 3. 주요 기능

### 3.1 실시간 Rule 재반영
- **기능 설명:** 관리자는 엔진 프로그램을 재기동하지 않고도 실시간으로 거래에 대한 규칙(Rule)을 반영할 수 있습니다.

### 3.2 거래 엔진 상태 모니터링
- **기능 설명:** EMS는 각 거래 엔진이 제공하는 다양한 상태 정보를 실시간으로 모니터링하여 문제를 조기에 발견하고 대응할 수 있도록 합니다.

---

## 4. Conclusion

EMS는 다양한 거래 서비스의 관리 및 모니터링 기능을 제공하여 관리자가 효율적으로 시스템을 운영할 수 있도록 도와줍니다. 높은 가용성을 제공하는 A-A HA 구성과 역할 분리를 통한 권한 관리 기능을 통해 보안성과 안정성을 동시에 보장합니다.




* [1. 시작하기](#1-----)
    + [1.1 Introduction](#11-introduction)
    + [1.2 Quick Start](#12-quick-start)
    + [1.3 Other Versions](#13-other-versions)
    + [1.4 With Docker](#14-with-docker)
* [2. Menus](#2-menus)
* [3. Implementations](#3-implementations)
    + [3.1 Configuration](#31-configuration)
    + [3.2 Log](#32-log)
    + [3.3 Filter](#33-filter)
    + [3.4 AppInitializer](#34-appinitializer)
    + [3.5 Interceptor](#35-interceptor)
    + [3.6 AOP](#36-aop)
    + [3.7 iBatis](#37-ibatis)
    + [3.8 JPA](#38-jpa)
    + [3.9 Scheduler](#39-scheduler)
    + [3.9 Excel Download](#39-excel-download)
    + [3.10 Resource Deploy](#310-resource-deploy)
* [4. User Interfaces](#4-user-interfaces)
    + [4.1 Common Scripts script.js, css](#41-common-scripts-scriptjs--css)
    + [4.2 LocaleMessage](#42-localemessage)
    + [4.3 View Controller 동작 원리와 Menu 권한분리를 위한 설계](#43-view-controller--------menu------------)
    + [4.4 jExcel](#44-jexcel)
    + [4.5 jqGrid](#45-jqgrid)
    + [4.6 fetch API & download](#46-fetch-api---download)
* [5. Operations](#5-operations)
    + [5.1 Command Class In Engine Project](#51-command-class-in-engine-project)
    + [5.2 AgentUtilService](#52-agentutilservice)
    + [5.3 WebAgent Servlet](#53-webagent-servlet)
* [6.1 Security](#61-security)
    + [6.2 Seed.java](#62-seedjava)
* [7. Monitoring](#7-monitoring)
    + [Bean ioAcceptor UDP 10800](#bean-ioacceptor-udp-10800)
    + [emsClient](#emsclient)
    + [Configuration in Engine Program](#configuration-in-engine-program)
* [ETC](#etc)
    + [Testing](#testing)

## 1. 시작하기

### 1.1 Introduction

- EMS는 무엇입니까?

> EMS는 eLink 솔루션 패키지의 한 프로젝트로, 온라인 거래 엔진 및 배치와 일괄 거래 엔진의 서비스 설정과 실시간 거래를 모니터링하는 툴입니다. 관리자 및 사용자는 EMS에서 제공되는 화면을 통해 거래 서비스를 구축하고 설정하며, 화면을 통해 모니터링 할 수 있습니다.

- Main Concepts and Terminology

> EMS의 화면과 기능을 이해하기 위해서는, 거래 서비스에 대한 이해가 전제로 필요합니다. 다음은

- 역할 분리를 통해 역할별 사용자의 화면권한 분리
- APP Code 권한관리를 통해 사용자 계정별 자원권한 분리
- 여러 타입의 서비스패키지를 하나의 EMS로 통합 관리
- (A-A)의 HA구성을 제공

여 높은 가용성을 제공

- 관리자 권한으로 엔진 프로그램의 재기동 필요없이 실시간 거래의 Rule 재반영
- 실시간 각 거래엔진이 제공하는 여러가지 상태 모니터링
-
-

### 1.2 Quick Start

### 1.3 Other Versions

### 1.4 With Docker

## 2. Menus

## 3. Implementations

### 3.1 Configuration

- web.xml
- context.xml
- applicationContext.xml
- applicationContext-datasource-xxx.xml
- applicationContext-jdbc-xxx.xml
- applicationContext-jpa.xml
- applicationContext-schedule.xml
- applicationContext-udpip.xml
- springapp-servlet.xml

### 3.2 Log
- logback.xml

### 3.3 Filter
- 

### 3.4 AppInitializer

### 3.5 Interceptor

### 3.6 AOP

### 3.7 iBatis

### 3.8 JPA

### 3.9 Scheduler

### 3.9 Excel Download

### 3.10 Resource Deploy

## 4. User Interfaces

### 4.1 Common Scripts script.js, css

### 4.2 LocaleMessage

### 4.3 View Controller 동작 원리와 Menu 권한분리를 위한 설계

### 4.4 jExcel

### 4.5 jqGrid

### 4.6 fetch API & download

## 5. Operations

### 5.1 Command Class In Engine Project

### 5.2 AgentUtilService

TSEAISY02

### 5.3 WebAgent Servlet

## 6.1 Security

### 6.2 Seed.java

enc, dec

## 7. Monitoring

### Bean ioAcceptor UDP 10800

### emsClient

### Configuration in Engine Program

## ETC

### Testing

### 

SSL지원?

