#! /bin/sh
cd `dirname $0`
echo `basename $0` is at `pwd`

project_sample_zip_path=`cd ..; pwd`
echo "Using project-sample-zip path: project_sample_zip_path"
pid=`ps -ef|grep java|grep hound_dog_path |awk '{print $2}'`
echo "pid=[$pid]"
while [  -n "$pid" ]; do
    echo "kill $pid"
    kill -9 $pid
    sleep 1s
    pid=`ps -ef|grep java|grep project_sample_zip_path |awk '{print $2}'`
done
echo "shutdown ok"
