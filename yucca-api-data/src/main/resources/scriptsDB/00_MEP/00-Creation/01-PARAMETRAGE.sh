#Ce script se situe sur mndiv2-2 dans db2data/db2dev/scripts

db2 connect to YUCBASE3

db2 update db cfg for YUCBASE3 using SELF_TUNING_MEM ON
db2 update db cfg for YUCBASE3  using CUR_COMMIT ON
db2 update db cfg for YUCBASE3  using SORTHEAP AUTOMATIC
db2 update db cfg for YUCBASE3  using PCKCACHESZ AUTOMATIC
db2 update db cfg for YUCBASE3  using SHEAPTHRES_SHR AUTOMATIC
db2 update db cfg for YUCBASE3  using AUTO_MAINT OFF

db2 update db cfg for YUCBASE3 using APPLHEAPSZ AUTOMATIC
db2 update db cfg for YUCBASE3 using NUM_IOCLEANERS AUTOMATIC
db2 update db cfg for YUCBASE3 using NUM_IOSERVERS AUTOMATIC

db2 update db cfg for YUCBASE3 using LOGFILSIZ 5000 
db2 update db cfg for YUCBASE3 using LOGBUFSZ 600 
db2 update db cfg for YUCBASE3 using LOGPRIMARY 20 
db2 update db cfg for YUCBASE3 using LOGSECOND -1

db2 update db cfg for YUCBASE3 using LOCKLIST 5000
db2 update db cfg for YUCBASE3 using MAXLOCKS 90
db2 update db cfg for YUCBASE3 using LOCKTIMEOUT 5

#Ajout pour maj 9.7
db2 update db cfg for YUCBASE3 using MAXAPPLS AUTOMATIC
db2 update db cfg for YUCBASE3 using SELF_TUNNING_MEM ON
db2 update db cfg for YUCBASE3 using DFT_REFRESH_AGE 0
db2 update db cfg for YUCBASE3 using AVG_APPLS AUTOMATIC

db2 activate db YUCBASE3 
db2 connect to YUCBASE3 
