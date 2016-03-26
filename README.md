### SharedPreferences
sharedPreferences可通过键值对的方式持久化存储数据，数据
以文件的方式存储在手机里。具体在/data/data/<packagename>/share_prefs/
<br>
####java中：
首先实例化 pref = getSharedPreferences("data",MODE_PRIVATE);<br>
两个参数：一个是存储数据的文件名，一个是读写模式。<br>
还要定义一个：SharedPreferences.Editor editor = pref.edit();<br>
最后只需向editor中输入数据键值对便可实现数据持久化存储。<br>
![sharedpref]SharedPreferences/app/src/main/res/drawable/sharedpreference.PNG
