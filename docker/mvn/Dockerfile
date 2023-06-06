FROM maven:3.8.6 as builder
WORKDIR /app

FROM builder as cli
CMD bash

FROM builder as compiler
CMD mvn compile
