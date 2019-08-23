db2 connect to yucbase3;

db2 force application all;

echo "----------------------------"
echo "ATTENTION SUPPRESSION"
echo "----------------------------"

read n.

db2 drop database yucbase3;

db2 terminate