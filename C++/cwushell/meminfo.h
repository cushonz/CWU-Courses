.\" Manpage for meminfo.

.TH man 8 "12 April 2022" "1.0" "meminfo man page"
.SH MEMINFO
meminfo \- Fetch Memory information and specs. 
.SH Fetches various information about the memory of the host.
meminfo [OPTION]
.SH DESCRIPTION
cpuinfo is a simple command to get information about the systems memory.
.SH OPTIONS
.IP -c  
Retrives the size of the L2 Cache.
.IP -u  
Retrives the amount of active memory.
.IP -t  
Retrives the total memory.

.SH BUGS
No known bugs. Parameters must be used one at a time.
.SH AUTHOR
Zach Cushon
