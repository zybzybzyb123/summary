测试文件file

多条件查询包含aaa或者bbb

#正则匹配(注意转义|)
grep -e 'aaa' -e 'bbb' file
grep -e 'aaa\|bbb' file