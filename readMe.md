## 项目样本案例

## 一、简介

### 1.1 概述
lwl-project-sample项目创建的目的是：快速容易开启一个项目。目前共有5个基础子项目和一个项目案例模块。

### 1.2 模块介绍
5个模块之间职责分明。Client模块和Common模块，通常用于被别的项目引用，特别是RPC调用时; core负责实现项目核心代码; web存储Client模块的实现和一些和前端逻辑操作; zip是不依赖于容器启动的java项目。这5个子模块只实现基本的配置。最后，project-some-sample用于存放日常学习的项目，供以后参考。

|模块|功能|
|:---:|:---:|
|project-sample-client|Client模块，通常定义项目接口|
|project-sample-common|Common模块，通常存储常量|
|project-sample-core|项目核心实现部分|
|project-sample-web|项目管理平台|
|project-sample-zip|项目独立启动子模块|
|project-some-sample|基础的学习项目|

### 1.3 环境
- JDK：1.7+
- Maven：3+
- Idea：2017

## 二、模块介绍

### 2.1 project-sample-web模块
project-sample-web模块是一个web项目，由于web技术种类复杂，该模块只提供基础功能:

- spring配置
- log4j配置
- springmvc配置

#### 2.1.1 模块目录详解

### 2.2 project-some-sample模块
project-some-sample模块存放日常学习的项目，供以后学习和参考。




















