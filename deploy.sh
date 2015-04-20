#!/bin/sh
FULLPATH=$(cd "$(dirname "$0")"; pwd)

update()
{
    echo 'update'
    git pull
    if [ $? -eq 0 ]; then
        echo 'update success'
    else
        echo "****************************************************"
        echo "             注意，有错误！脚本停止运行"
        echo "****************************************************"
        
        exit 1
     fi
}

build()
{
    echo 'start build'
    export MAVEN_OPTS='-Xms256m -Xmx256m'
    mvn clean install -Dmaven.test.skip=true

    if [ $? -eq 0 ]; then
        echo 'Maven Running Success!'
    else
        echo "****************************************************"
        echo "             注意，有错误！脚本停止运行"
        echo "****************************************************"
        
        exit 1
    fi
}


deploy()
{
    killall java
    rm -rf $HOME/webapps/*
    echo $HOME
    cp target/*.war $HOME/webapps
    sh /alidata/server/tomcat-7.0.54/bin/catalina.sh start
    if [ $? -eq 0 ]; then
   	 echo 'Static files deploy SUCCESS!'
    else
        echo "================================================="
        echo "        Static files deploy FAILED!"
        echo "================================================="

        exit 1
    fi
}

update
build
deploy
