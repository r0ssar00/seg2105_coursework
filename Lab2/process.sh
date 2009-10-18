#!/bin/bash
if [ $1 ]; then
 DEFINES="-D$1 "
fi
if [ $2 ]; then
 DEFINES="$DEFINES -D$2 "
fi
if [ $3 ]; then
 DEFINES="$DEFINES -D$3 "
fi

ls *.jpp | while read line; do
 JFILE="`echo $line | sed 's/jpp/java/'`";
 rm $JFILE;
 cpp -P -C $DEFINES $line $JFILE;
done
