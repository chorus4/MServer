#!/bin/bash
cd "$( dirname "$0" )"
/Library/Java/JavaVirtualMachines/jdk-16.0.2.jdk/Contents/Home/bin/java -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=3201 -Xms2G -Xmx2G -jar paper.jar --nogui