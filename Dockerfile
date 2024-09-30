FROM ubuntu:latest
LABEL authors="sofia"

ENTRYPOINT ["top", "-b"]