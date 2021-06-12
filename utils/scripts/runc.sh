#!/bin/sh


#echo $1			# the full file path
if [ $# -eq 0 ]
  then
    echo "Mandatory argument missing. File to run is missing, see below syntax"
    echo -e "Syntax:\n\t$ runc <file_with_full_path>"
    echo "Exiting"
    exit 1
fi

extension=".c"
DIR=$(dirname $1)
FILE=$(basename $1 $extension)		# gives filename without the path and extenstion

#echo $DIR
#echo $FILE

#cmd="cd \"$DIR\" && gcc $FILE$extension -o binary_tree && \"$DIR\\$FILE\""
cmd="gcc \"$1\" -o \"$DIR\\$FILE\" && \"$DIR\\$FILE.exe\""
echo $cmd
eval $cmd
