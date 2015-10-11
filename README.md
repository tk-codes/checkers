# Checkers Multiplayer
Peer-to-Peer Gaming with Java Networking (Socket Programming)

## Overview
![Overview](https://github.com/tk-codes/checkers/blob/master/Documentation/overview.png)
![Server-Client](https://github.com/tk-codes/checkers/blob/master/Documentation/server_client.PNG)

## Class Diagram
###Server
![Server Class Diagram](https://github.com/tk-codes/checkers/blob/master/Checkers%20-%20Server/doc/ServerSide.png)

### Client
![Client Class Diagram](https://github.com/tk-codes/checkers/blob/master/Checkers%20-%20Client/doc/ClientSide.png)

## How to get started
###1. Server Configuration

> **Checkers - Server \resources\config.properties**

set the TCP port
```
port = 50800
```

start the server application
```
Checkers - Server \src\ServerMain.java
```

###2. Client Configuration

> **Checkers - Client \resources\config.properties**

set the server ip address and tcp port
```
server=127.0.0.1
port=50800
```

start the client application
```
Checkers - Client \src\ClientMain.java
```
![Play](https://github.com/tk-codes/checkers/blob/master/Documentation/play.PNG)

