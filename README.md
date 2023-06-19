<h1 align="center">Welcome to skymatrix</h1>
<p align="center">
  <img alt="Version" src="https://img.shields.io/badge/version-114514-blue.svg?cacheSeconds=2592000" />
  <img alt="Download" src="https://img.shields.io/github/downloads/seiuna/aifadianApi/total"/>
  <img alt="V" src="https://img.shields.io/badge/Java-20-green" style=""/>
</p>

> 爱发电api

## Prerequisites

- Java version 20

## Usage

```java
        AfdApi afdApi=AfdApi.build("userid","token");
        Optional<AfdOrder> afdOrder=afdApi.queryOrder("202306192009374955565522556"); //订单号
        Optional<AfdOrders> afdOrders=afdApi.queryOrder(1); //按页查订单
        Optional<AfdSponsers> afdSponsers=afdApi.querySponsor(1); //按页查赞助者
```

## Author

- seiuna yuuiyu 

