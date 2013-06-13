#!/bin/sh

# Debug options
#JAVA_OPTS="$JAVA_OPTS -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=y"

CURRENT_DIR=`pwd`

# Setup WINDUP_HOME
if [ "x$WINDUP_HOME" = "x" ]; then
    WINDUP_HOME=/home/lab11/Libraries/windup-cli-0.7.0
fi
export WINDUP_HOME
cd $WINDUP_HOME

java $JAVA_OPTS -jar $WINDUP_HOME/windup-cli.jar -input $CURRENT_DIR/soa5_bpm_processor -output $CURRENT_DIR/lab6-report -javaPkgs org.jboss.soa.esb.samples.quickstarts.bpm_orchestration1.esb_actions:org.jboss.soa.esb.samples.quickstarts.bpm_orchestration1.process_actions -source true -fetchRemote true

