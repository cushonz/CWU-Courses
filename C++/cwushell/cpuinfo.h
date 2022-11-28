.\" Manpage for cpuinfo.

.TH man 8 "12 April 2022" "1.0" "cpuinfo man page"
.SH CPUINFO
cpuinfo \- Fetch CPU information and specs. 
.SH Fetches various information about the CPU of the host.
cpuinfo [OPTION]
.SH DESCRIPTION
cpuinfo is a simple command to get information about the CPU.
.SH OPTIONS
.IP -c  
Retrives the clock speed of the CPU.
.IP -n  
Retrives the number of CPU cores.
.IP -t  
Retrives the type of CPU(Intel vs AMD).

.SH BUGS
No known bugs. Parameters must be used one at a time.
.SH AUTHOR
Zach Cushon
