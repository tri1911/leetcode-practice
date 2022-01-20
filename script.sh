# echo "Enter the path of source directory: "
# read SOURCE
# echo "Enter the path of destination directory: "
# read DESTINATION

# script to hard link java files from `source` to `dest`
# $1 - path name of the source directory
# $2 - path name of the destination directory

[ $# -ne 2 ] && { echo "Usage: $0 source dest"; exit 1; }

# SOURCE="/Users/elliotho1911/IdeaProjects/Leetcode/src/algorithm2/$1"
SOURCE="/Users/elliotho1911/IdeaProjects/Leetcode/src/$1"
[ ! -d $SOURCE ] && { echo "Error: directory $1 does not exist"; exit 1; }
[ ! -d $2 ] && mkdir "$2"

for file in $SOURCE/*.java
do
	base_name=`basename $file .java`.java # get the base name of java file
	new_link="$2/$base_name"
	if [ -f "$new_link" ]; then
		echo "$base_name already exists in $2"
	else
		echo "Linking file $base_name from $1 to $2..."
		ln $file $new_link
	fi
done