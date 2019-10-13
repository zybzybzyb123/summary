测试文件file
打印文件前两列,以空格分割
[]可以实现多字段分割
awk -F' '  '{print $1 ";" $2}'
awk -F[' ']  '{print $1 ";" $2}'

测试文件file
统计出现次数前5的ip
sort排序, uniq -c检测重复行数
awk '{print $1}' file |sort|uniq -c|sort -nr|head -5
awk '{cnt[$1]++} END {for(i in cnt) print i, cnt[i]}'  file | sort -nr -k 2| head -10
./test.sh|sort -nr -k 2|head -10